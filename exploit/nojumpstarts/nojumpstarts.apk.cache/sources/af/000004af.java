package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ActivityChooserModel extends DataSetObservable {
    static final String ATTRIBUTE_ACTIVITY = "activity";
    static final String ATTRIBUTE_TIME = "time";
    static final String ATTRIBUTE_WEIGHT = "weight";
    static final boolean DEBUG = false;
    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    private static final String HISTORY_FILE_EXTENSION = ".xml";
    private static final int INVALID_INDEX = -1;
    static final String TAG_HISTORICAL_RECORD = "historical-record";
    static final String TAG_HISTORICAL_RECORDS = "historical-records";
    private OnChooseActivityListener mActivityChoserModelPolicy;
    final Context mContext;
    final String mHistoryFileName;
    private Intent mIntent;
    static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
    private static final Object sRegistryLock = new Object();
    private static final Map<String, ActivityChooserModel> sDataModelRegistry = new HashMap();
    private final Object mInstanceLock = new Object();
    private final List<ActivityResolveInfo> mActivities = new ArrayList();
    private final List<HistoricalRecord> mHistoricalRecords = new ArrayList();
    private ActivitySorter mActivitySorter = new DefaultSorter();
    private int mHistoryMaxSize = 50;
    boolean mCanReadHistoricalData = true;
    private boolean mReadShareHistoryCalled = false;
    private boolean mHistoricalRecordsChanged = true;
    private boolean mReloadActivities = false;

    /* loaded from: classes.dex */
    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel activityChooserModel);
    }

    /* loaded from: classes.dex */
    public interface ActivitySorter {
        void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2);
    }

    /* loaded from: classes.dex */
    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent);
    }

    public static ActivityChooserModel get(Context context, String historyFileName) {
        ActivityChooserModel dataModel;
        synchronized (sRegistryLock) {
            dataModel = sDataModelRegistry.get(historyFileName);
            if (dataModel == null) {
                dataModel = new ActivityChooserModel(context, historyFileName);
                sDataModelRegistry.put(historyFileName, dataModel);
            }
        }
        return dataModel;
    }

    private ActivityChooserModel(Context context, String historyFileName) {
        this.mContext = context.getApplicationContext();
        if (!TextUtils.isEmpty(historyFileName) && !historyFileName.endsWith(HISTORY_FILE_EXTENSION)) {
            this.mHistoryFileName = historyFileName + HISTORY_FILE_EXTENSION;
            return;
        }
        this.mHistoryFileName = historyFileName;
    }

    public void setIntent(Intent intent) {
        synchronized (this.mInstanceLock) {
            if (this.mIntent == intent) {
                return;
            }
            this.mIntent = intent;
            this.mReloadActivities = true;
            ensureConsistentState();
        }
    }

    public Intent getIntent() {
        Intent intent;
        synchronized (this.mInstanceLock) {
            intent = this.mIntent;
        }
        return intent;
    }

    public int getActivityCount() {
        int size;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            size = this.mActivities.size();
        }
        return size;
    }

    public ResolveInfo getActivity(int index) {
        ResolveInfo resolveInfo;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            resolveInfo = this.mActivities.get(index).resolveInfo;
        }
        return resolveInfo;
    }

    public int getActivityIndex(ResolveInfo activity) {
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            List<ActivityResolveInfo> activities = this.mActivities;
            int activityCount = activities.size();
            for (int i = 0; i < activityCount; i++) {
                ActivityResolveInfo currentActivity = activities.get(i);
                if (currentActivity.resolveInfo == activity) {
                    return i;
                }
            }
            return -1;
        }
    }

    public Intent chooseActivity(int index) {
        synchronized (this.mInstanceLock) {
            if (this.mIntent == null) {
                return null;
            }
            ensureConsistentState();
            ActivityResolveInfo chosenActivity = this.mActivities.get(index);
            ComponentName chosenName = new ComponentName(chosenActivity.resolveInfo.activityInfo.packageName, chosenActivity.resolveInfo.activityInfo.name);
            Intent choiceIntent = new Intent(this.mIntent);
            choiceIntent.setComponent(chosenName);
            if (this.mActivityChoserModelPolicy != null) {
                Intent choiceIntentCopy = new Intent(choiceIntent);
                boolean handled = this.mActivityChoserModelPolicy.onChooseActivity(this, choiceIntentCopy);
                if (handled) {
                    return null;
                }
            }
            HistoricalRecord historicalRecord = new HistoricalRecord(chosenName, System.currentTimeMillis(), (float) DEFAULT_HISTORICAL_RECORD_WEIGHT);
            addHistoricalRecord(historicalRecord);
            return choiceIntent;
        }
    }

    public void setOnChooseActivityListener(OnChooseActivityListener listener) {
        synchronized (this.mInstanceLock) {
            this.mActivityChoserModelPolicy = listener;
        }
    }

    public ResolveInfo getDefaultActivity() {
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            if (!this.mActivities.isEmpty()) {
                return this.mActivities.get(0).resolveInfo;
            }
            return null;
        }
    }

    public void setDefaultActivity(int index) {
        float weight;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            ActivityResolveInfo newDefaultActivity = this.mActivities.get(index);
            ActivityResolveInfo oldDefaultActivity = this.mActivities.get(0);
            if (oldDefaultActivity != null) {
                weight = (oldDefaultActivity.weight - newDefaultActivity.weight) + 5.0f;
            } else {
                weight = DEFAULT_HISTORICAL_RECORD_WEIGHT;
            }
            ComponentName defaultName = new ComponentName(newDefaultActivity.resolveInfo.activityInfo.packageName, newDefaultActivity.resolveInfo.activityInfo.name);
            HistoricalRecord historicalRecord = new HistoricalRecord(defaultName, System.currentTimeMillis(), weight);
            addHistoricalRecord(historicalRecord);
        }
    }

    private void persistHistoricalDataIfNeeded() {
        if (!this.mReadShareHistoryCalled) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (!this.mHistoricalRecordsChanged) {
            return;
        }
        this.mHistoricalRecordsChanged = false;
        if (!TextUtils.isEmpty(this.mHistoryFileName)) {
            new PersistHistoryAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.mHistoricalRecords), this.mHistoryFileName);
        }
    }

    public void setActivitySorter(ActivitySorter activitySorter) {
        synchronized (this.mInstanceLock) {
            if (this.mActivitySorter == activitySorter) {
                return;
            }
            this.mActivitySorter = activitySorter;
            if (sortActivitiesIfNeeded()) {
                notifyChanged();
            }
        }
    }

    public void setHistoryMaxSize(int historyMaxSize) {
        synchronized (this.mInstanceLock) {
            if (this.mHistoryMaxSize == historyMaxSize) {
                return;
            }
            this.mHistoryMaxSize = historyMaxSize;
            pruneExcessiveHistoricalRecordsIfNeeded();
            if (sortActivitiesIfNeeded()) {
                notifyChanged();
            }
        }
    }

    public int getHistoryMaxSize() {
        int i;
        synchronized (this.mInstanceLock) {
            i = this.mHistoryMaxSize;
        }
        return i;
    }

    public int getHistorySize() {
        int size;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            size = this.mHistoricalRecords.size();
        }
        return size;
    }

    private void ensureConsistentState() {
        boolean stateChanged = loadActivitiesIfNeeded();
        boolean stateChanged2 = stateChanged | readHistoricalDataIfNeeded();
        pruneExcessiveHistoricalRecordsIfNeeded();
        if (stateChanged2) {
            sortActivitiesIfNeeded();
            notifyChanged();
        }
    }

    private boolean sortActivitiesIfNeeded() {
        if (this.mActivitySorter != null && this.mIntent != null && !this.mActivities.isEmpty() && !this.mHistoricalRecords.isEmpty()) {
            this.mActivitySorter.sort(this.mIntent, this.mActivities, Collections.unmodifiableList(this.mHistoricalRecords));
            return true;
        }
        return false;
    }

    private boolean loadActivitiesIfNeeded() {
        if (!this.mReloadActivities || this.mIntent == null) {
            return false;
        }
        this.mReloadActivities = false;
        this.mActivities.clear();
        List<ResolveInfo> resolveInfos = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int resolveInfoCount = resolveInfos.size();
        for (int i = 0; i < resolveInfoCount; i++) {
            ResolveInfo resolveInfo = resolveInfos.get(i);
            this.mActivities.add(new ActivityResolveInfo(resolveInfo));
        }
        return true;
    }

    private boolean readHistoricalDataIfNeeded() {
        if (this.mCanReadHistoricalData && this.mHistoricalRecordsChanged && !TextUtils.isEmpty(this.mHistoryFileName)) {
            this.mCanReadHistoricalData = false;
            this.mReadShareHistoryCalled = true;
            readHistoricalDataImpl();
            return true;
        }
        return false;
    }

    private boolean addHistoricalRecord(HistoricalRecord historicalRecord) {
        boolean added = this.mHistoricalRecords.add(historicalRecord);
        if (added) {
            this.mHistoricalRecordsChanged = true;
            pruneExcessiveHistoricalRecordsIfNeeded();
            persistHistoricalDataIfNeeded();
            sortActivitiesIfNeeded();
            notifyChanged();
        }
        return added;
    }

    private void pruneExcessiveHistoricalRecordsIfNeeded() {
        int pruneCount = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
        if (pruneCount <= 0) {
            return;
        }
        this.mHistoricalRecordsChanged = true;
        for (int i = 0; i < pruneCount; i++) {
            this.mHistoricalRecords.remove(0);
        }
    }

    /* loaded from: classes.dex */
    public static final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(String activityName, long time, float weight) {
            this(ComponentName.unflattenFromString(activityName), time, weight);
        }

        public HistoricalRecord(ComponentName activityName, long time, float weight) {
            this.activity = activityName;
            this.time = time;
            this.weight = weight;
        }

        public int hashCode() {
            int i = 1 * 31;
            ComponentName componentName = this.activity;
            int result = i + (componentName == null ? 0 : componentName.hashCode());
            long j = this.time;
            return (((result * 31) + ((int) (j ^ (j >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            HistoricalRecord other = (HistoricalRecord) obj;
            ComponentName componentName = this.activity;
            if (componentName == null) {
                if (other.activity != null) {
                    return false;
                }
            } else if (!componentName.equals(other.activity)) {
                return false;
            }
            if (this.time == other.time && Float.floatToIntBits(this.weight) == Float.floatToIntBits(other.weight)) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "[; activity:" + this.activity + "; time:" + this.time + "; weight:" + new BigDecimal(this.weight) + "]";
        }
    }

    /* loaded from: classes.dex */
    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.resolveInfo = resolveInfo;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ActivityResolveInfo other = (ActivityResolveInfo) obj;
            if (Float.floatToIntBits(this.weight) == Float.floatToIntBits(other.weight)) {
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(ActivityResolveInfo another) {
            return Float.floatToIntBits(another.weight) - Float.floatToIntBits(this.weight);
        }

        public String toString() {
            return "[resolveInfo:" + this.resolveInfo.toString() + "; weight:" + new BigDecimal(this.weight) + "]";
        }
    }

    /* loaded from: classes.dex */
    private static final class DefaultSorter implements ActivitySorter {
        private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
        private final Map<ComponentName, ActivityResolveInfo> mPackageNameToActivityMap = new HashMap();

        DefaultSorter() {
        }

        @Override // android.support.v7.widget.ActivityChooserModel.ActivitySorter
        public void sort(Intent intent, List<ActivityResolveInfo> activities, List<HistoricalRecord> historicalRecords) {
            Map<ComponentName, ActivityResolveInfo> componentNameToActivityMap = this.mPackageNameToActivityMap;
            componentNameToActivityMap.clear();
            int activityCount = activities.size();
            for (int i = 0; i < activityCount; i++) {
                ActivityResolveInfo activity = activities.get(i);
                activity.weight = 0.0f;
                ComponentName componentName = new ComponentName(activity.resolveInfo.activityInfo.packageName, activity.resolveInfo.activityInfo.name);
                componentNameToActivityMap.put(componentName, activity);
            }
            int i2 = historicalRecords.size();
            int lastShareIndex = i2 - 1;
            float nextRecordWeight = ActivityChooserModel.DEFAULT_HISTORICAL_RECORD_WEIGHT;
            for (int i3 = lastShareIndex; i3 >= 0; i3--) {
                HistoricalRecord historicalRecord = historicalRecords.get(i3);
                ComponentName componentName2 = historicalRecord.activity;
                ActivityResolveInfo activity2 = componentNameToActivityMap.get(componentName2);
                if (activity2 != null) {
                    activity2.weight += historicalRecord.weight * nextRecordWeight;
                    nextRecordWeight *= WEIGHT_DECAY_COEFFICIENT;
                }
            }
            Collections.sort(activities);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1026=4] */
    private void readHistoricalDataImpl() {
        try {
            FileInputStream fis = this.mContext.openFileInput(this.mHistoryFileName);
            try {
                try {
                    try {
                        try {
                            XmlPullParser parser = Xml.newPullParser();
                            parser.setInput(fis, "UTF-8");
                            for (int type = 0; type != 1 && type != 2; type = parser.next()) {
                            }
                            if (!TAG_HISTORICAL_RECORDS.equals(parser.getName())) {
                                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                            }
                            List<HistoricalRecord> historicalRecords = this.mHistoricalRecords;
                            historicalRecords.clear();
                            while (true) {
                                int type2 = parser.next();
                                if (type2 == 1) {
                                    if (fis != null) {
                                        fis.close();
                                        return;
                                    }
                                    return;
                                } else if (type2 != 3 && type2 != 4) {
                                    String nodeName = parser.getName();
                                    if (!TAG_HISTORICAL_RECORD.equals(nodeName)) {
                                        throw new XmlPullParserException("Share records file not well-formed.");
                                    }
                                    String activity = parser.getAttributeValue(null, ATTRIBUTE_ACTIVITY);
                                    long time = Long.parseLong(parser.getAttributeValue(null, ATTRIBUTE_TIME));
                                    float weight = Float.parseFloat(parser.getAttributeValue(null, ATTRIBUTE_WEIGHT));
                                    HistoricalRecord readRecord = new HistoricalRecord(activity, time, weight);
                                    historicalRecords.add(readRecord);
                                }
                            }
                        } catch (IOException ioe) {
                            String str = LOG_TAG;
                            Log.e(str, "Error reading historical recrod file: " + this.mHistoryFileName, ioe);
                            if (fis != null) {
                                fis.close();
                            }
                        }
                    } catch (XmlPullParserException xppe) {
                        String str2 = LOG_TAG;
                        Log.e(str2, "Error reading historical recrod file: " + this.mHistoryFileName, xppe);
                        if (fis != null) {
                            fis.close();
                        }
                    }
                } catch (IOException e) {
                }
            } catch (Throwable th) {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e2) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        PersistHistoryAsyncTask() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1092=5, 1094=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:64:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Void doInBackground(java.lang.Object... r18) {
            /*
                r17 = this;
                r1 = r17
                java.lang.String r0 = "historical-record"
                java.lang.String r2 = "historical-records"
                java.lang.String r3 = "Error writing historical record file: "
                r4 = 0
                r5 = r18[r4]
                java.util.List r5 = (java.util.List) r5
                r6 = 1
                r7 = r18[r6]
                java.lang.String r7 = (java.lang.String) r7
                r8 = 0
                r9 = 0
                android.support.v7.widget.ActivityChooserModel r10 = android.support.v7.widget.ActivityChooserModel.this     // Catch: java.io.FileNotFoundException -> L110
                android.content.Context r10 = r10.mContext     // Catch: java.io.FileNotFoundException -> L110
                java.io.FileOutputStream r10 = r10.openFileOutput(r7, r4)     // Catch: java.io.FileNotFoundException -> L110
                r8 = r10
                org.xmlpull.v1.XmlSerializer r10 = android.util.Xml.newSerializer()
                r10.setOutput(r8, r9)     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L8d java.lang.IllegalStateException -> Lb3 java.lang.IllegalArgumentException -> Ld9
                java.lang.String r11 = "UTF-8"
                java.lang.Boolean r12 = java.lang.Boolean.valueOf(r6)     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L8d java.lang.IllegalStateException -> Lb3 java.lang.IllegalArgumentException -> Ld9
                r10.startDocument(r11, r12)     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L8d java.lang.IllegalStateException -> Lb3 java.lang.IllegalArgumentException -> Ld9
                r10.startTag(r9, r2)     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L8d java.lang.IllegalStateException -> Lb3 java.lang.IllegalArgumentException -> Ld9
                int r11 = r5.size()     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L8d java.lang.IllegalStateException -> Lb3 java.lang.IllegalArgumentException -> Ld9
                r12 = 0
            L36:
                if (r12 >= r11) goto L6e
                java.lang.Object r13 = r5.remove(r4)     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L8d java.lang.IllegalStateException -> Lb3 java.lang.IllegalArgumentException -> Ld9
                android.support.v7.widget.ActivityChooserModel$HistoricalRecord r13 = (android.support.v7.widget.ActivityChooserModel.HistoricalRecord) r13     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L8d java.lang.IllegalStateException -> Lb3 java.lang.IllegalArgumentException -> Ld9
                r10.startTag(r9, r0)     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L8d java.lang.IllegalStateException -> Lb3 java.lang.IllegalArgumentException -> Ld9
                java.lang.String r14 = "activity"
                android.content.ComponentName r15 = r13.activity     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L8d java.lang.IllegalStateException -> Lb3 java.lang.IllegalArgumentException -> Ld9
                java.lang.String r15 = r15.flattenToString()     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L8d java.lang.IllegalStateException -> Lb3 java.lang.IllegalArgumentException -> Ld9
                r10.attribute(r9, r14, r15)     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L8d java.lang.IllegalStateException -> Lb3 java.lang.IllegalArgumentException -> Ld9
                java.lang.String r14 = "time"
                r16 = r5
                long r4 = r13.time     // Catch: java.io.IOException -> L81 java.lang.IllegalStateException -> L83 java.lang.IllegalArgumentException -> L85 java.lang.Throwable -> L102
                java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.io.IOException -> L81 java.lang.IllegalStateException -> L83 java.lang.IllegalArgumentException -> L85 java.lang.Throwable -> L102
                r10.attribute(r9, r14, r4)     // Catch: java.io.IOException -> L81 java.lang.IllegalStateException -> L83 java.lang.IllegalArgumentException -> L85 java.lang.Throwable -> L102
                java.lang.String r4 = "weight"
                float r5 = r13.weight     // Catch: java.io.IOException -> L81 java.lang.IllegalStateException -> L83 java.lang.IllegalArgumentException -> L85 java.lang.Throwable -> L102
                java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.io.IOException -> L81 java.lang.IllegalStateException -> L83 java.lang.IllegalArgumentException -> L85 java.lang.Throwable -> L102
                r10.attribute(r9, r4, r5)     // Catch: java.io.IOException -> L81 java.lang.IllegalStateException -> L83 java.lang.IllegalArgumentException -> L85 java.lang.Throwable -> L102
                r10.endTag(r9, r0)     // Catch: java.io.IOException -> L81 java.lang.IllegalStateException -> L83 java.lang.IllegalArgumentException -> L85 java.lang.Throwable -> L102
                int r12 = r12 + 1
                r5 = r16
                r4 = 0
                goto L36
            L6e:
                r16 = r5
                r10.endTag(r9, r2)     // Catch: java.io.IOException -> L81 java.lang.IllegalStateException -> L83 java.lang.IllegalArgumentException -> L85 java.lang.Throwable -> L102
                r10.endDocument()     // Catch: java.io.IOException -> L81 java.lang.IllegalStateException -> L83 java.lang.IllegalArgumentException -> L85 java.lang.Throwable -> L102
                android.support.v7.widget.ActivityChooserModel r0 = android.support.v7.widget.ActivityChooserModel.this
                r0.mCanReadHistoricalData = r6
                if (r8 == 0) goto L101
                r8.close()     // Catch: java.io.IOException -> Lff
                goto Lfe
            L81:
                r0 = move-exception
                goto L90
            L83:
                r0 = move-exception
                goto Lb6
            L85:
                r0 = move-exception
                goto Ldc
            L87:
                r0 = move-exception
                r16 = r5
                r2 = r0
                goto L104
            L8d:
                r0 = move-exception
                r16 = r5
            L90:
                java.lang.String r2 = android.support.v7.widget.ActivityChooserModel.LOG_TAG     // Catch: java.lang.Throwable -> L102
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L102
                r4.<init>()     // Catch: java.lang.Throwable -> L102
                r4.append(r3)     // Catch: java.lang.Throwable -> L102
                android.support.v7.widget.ActivityChooserModel r3 = android.support.v7.widget.ActivityChooserModel.this     // Catch: java.lang.Throwable -> L102
                java.lang.String r3 = r3.mHistoryFileName     // Catch: java.lang.Throwable -> L102
                r4.append(r3)     // Catch: java.lang.Throwable -> L102
                java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L102
                android.util.Log.e(r2, r3, r0)     // Catch: java.lang.Throwable -> L102
                android.support.v7.widget.ActivityChooserModel r0 = android.support.v7.widget.ActivityChooserModel.this
                r0.mCanReadHistoricalData = r6
                if (r8 == 0) goto L101
                r8.close()     // Catch: java.io.IOException -> Lff
                goto Lfe
            Lb3:
                r0 = move-exception
                r16 = r5
            Lb6:
                java.lang.String r2 = android.support.v7.widget.ActivityChooserModel.LOG_TAG     // Catch: java.lang.Throwable -> L102
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L102
                r4.<init>()     // Catch: java.lang.Throwable -> L102
                r4.append(r3)     // Catch: java.lang.Throwable -> L102
                android.support.v7.widget.ActivityChooserModel r3 = android.support.v7.widget.ActivityChooserModel.this     // Catch: java.lang.Throwable -> L102
                java.lang.String r3 = r3.mHistoryFileName     // Catch: java.lang.Throwable -> L102
                r4.append(r3)     // Catch: java.lang.Throwable -> L102
                java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L102
                android.util.Log.e(r2, r3, r0)     // Catch: java.lang.Throwable -> L102
                android.support.v7.widget.ActivityChooserModel r0 = android.support.v7.widget.ActivityChooserModel.this
                r0.mCanReadHistoricalData = r6
                if (r8 == 0) goto L101
                r8.close()     // Catch: java.io.IOException -> Lff
                goto Lfe
            Ld9:
                r0 = move-exception
                r16 = r5
            Ldc:
                java.lang.String r2 = android.support.v7.widget.ActivityChooserModel.LOG_TAG     // Catch: java.lang.Throwable -> L102
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L102
                r4.<init>()     // Catch: java.lang.Throwable -> L102
                r4.append(r3)     // Catch: java.lang.Throwable -> L102
                android.support.v7.widget.ActivityChooserModel r3 = android.support.v7.widget.ActivityChooserModel.this     // Catch: java.lang.Throwable -> L102
                java.lang.String r3 = r3.mHistoryFileName     // Catch: java.lang.Throwable -> L102
                r4.append(r3)     // Catch: java.lang.Throwable -> L102
                java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L102
                android.util.Log.e(r2, r3, r0)     // Catch: java.lang.Throwable -> L102
                android.support.v7.widget.ActivityChooserModel r0 = android.support.v7.widget.ActivityChooserModel.this
                r0.mCanReadHistoricalData = r6
                if (r8 == 0) goto L101
                r8.close()     // Catch: java.io.IOException -> Lff
            Lfe:
                goto L101
            Lff:
                r0 = move-exception
                goto Lfe
            L101:
                return r9
            L102:
                r0 = move-exception
                r2 = r0
            L104:
                android.support.v7.widget.ActivityChooserModel r0 = android.support.v7.widget.ActivityChooserModel.this
                r0.mCanReadHistoricalData = r6
                if (r8 == 0) goto L10f
                r8.close()     // Catch: java.io.IOException -> L10e
                goto L10f
            L10e:
                r0 = move-exception
            L10f:
                throw r2
            L110:
                r0 = move-exception
                r16 = r5
                java.lang.String r2 = android.support.v7.widget.ActivityChooserModel.LOG_TAG
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r3)
                r4.append(r7)
                java.lang.String r3 = r4.toString()
                android.util.Log.e(r2, r3, r0)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActivityChooserModel.PersistHistoryAsyncTask.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }
}