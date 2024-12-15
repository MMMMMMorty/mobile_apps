package android.support.v4.util;

import android.support.annotation.RestrictTo;
import java.io.PrintWriter;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class TimeUtils {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final Object sFormatSync = new Object();
    private static char[] sFormatStr = new char[24];

    private static int accumField(int amt, int suffix, boolean always, int zeropad) {
        if (amt > 99 || (always && zeropad >= 3)) {
            return suffix + 3;
        }
        if (amt > 9 || (always && zeropad >= 2)) {
            return suffix + 2;
        }
        if (always || amt > 0) {
            return suffix + 1;
        }
        return 0;
    }

    private static int printField(char[] formatStr, int amt, char suffix, int pos, boolean always, int zeropad) {
        if (always || amt > 0) {
            if ((always && zeropad >= 3) || amt > 99) {
                int dig = amt / 100;
                formatStr[pos] = (char) (dig + 48);
                pos++;
                amt -= dig * 100;
            }
            if ((always && zeropad >= 2) || amt > 9 || pos != pos) {
                int dig2 = amt / 10;
                formatStr[pos] = (char) (dig2 + 48);
                pos++;
                amt -= dig2 * 10;
            }
            formatStr[pos] = (char) (amt + 48);
            int pos2 = pos + 1;
            formatStr[pos2] = suffix;
            return pos2 + 1;
        }
        return pos;
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x0132, code lost:
        if (r9 != r7) goto L69;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int formatDurationLocked(long r27, int r29) {
        /*
            r0 = r27
            r2 = r29
            char[] r3 = android.support.v4.util.TimeUtils.sFormatStr
            int r3 = r3.length
            if (r3 >= r2) goto Ld
            char[] r3 = new char[r2]
            android.support.v4.util.TimeUtils.sFormatStr = r3
        Ld:
            char[] r3 = android.support.v4.util.TimeUtils.sFormatStr
            r4 = 32
            r5 = 0
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r7 != 0) goto L26
            r5 = 0
            int r2 = r2 + (-1)
        L1a:
            if (r5 >= r2) goto L1f
            r3[r5] = r4
            goto L1a
        L1f:
            r4 = 48
            r3[r5] = r4
            int r4 = r5 + 1
            return r4
        L26:
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r7 <= 0) goto L2e
            r5 = 43
            r10 = r5
            goto L32
        L2e:
            r5 = 45
            long r0 = -r0
            r10 = r5
        L32:
            r5 = 1000(0x3e8, double:4.94E-321)
            long r7 = r0 % r5
            int r11 = (int) r7
            long r5 = r0 / r5
            double r5 = (double) r5
            double r5 = java.lang.Math.floor(r5)
            int r5 = (int) r5
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 86400(0x15180, float:1.21072E-40)
            if (r5 <= r9) goto L4e
            int r6 = r5 / r9
            int r9 = r9 * r6
            int r5 = r5 - r9
            r12 = r6
            goto L4f
        L4e:
            r12 = r6
        L4f:
            r6 = 3600(0xe10, float:5.045E-42)
            if (r5 <= r6) goto L5a
            int r6 = r5 / 3600
            int r7 = r6 * 3600
            int r5 = r5 - r7
            r13 = r6
            goto L5b
        L5a:
            r13 = r7
        L5b:
            r6 = 60
            if (r5 <= r6) goto L67
            int r6 = r5 / 60
            int r7 = r6 * 60
            int r5 = r5 - r7
            r15 = r5
            r14 = r6
            goto L69
        L67:
            r15 = r5
            r14 = r8
        L69:
            r5 = 0
            r16 = 3
            r9 = 2
            r8 = 0
            r7 = 1
            if (r2 == 0) goto La5
            int r6 = accumField(r12, r7, r8, r8)
            if (r6 <= 0) goto L78
            r8 = 1
        L78:
            int r8 = accumField(r13, r7, r8, r9)
            int r6 = r6 + r8
            if (r6 <= 0) goto L81
            r8 = 1
            goto L82
        L81:
            r8 = 0
        L82:
            int r8 = accumField(r14, r7, r8, r9)
            int r6 = r6 + r8
            if (r6 <= 0) goto L8b
            r8 = 1
            goto L8c
        L8b:
            r8 = 0
        L8c:
            int r8 = accumField(r15, r7, r8, r9)
            int r6 = r6 + r8
            if (r6 <= 0) goto L95
            r8 = 3
            goto L96
        L95:
            r8 = 0
        L96:
            int r8 = accumField(r11, r9, r7, r8)
            int r8 = r8 + r7
            int r6 = r6 + r8
        L9c:
            if (r6 >= r2) goto La5
            r3[r5] = r4
            int r5 = r5 + 1
            int r6 = r6 + 1
            goto L9c
        La5:
            r3[r5] = r10
            int r17 = r5 + 1
            r8 = r17
            if (r2 == 0) goto Laf
            r4 = 1
            goto Lb0
        Laf:
            r4 = 0
        Lb0:
            r18 = r4
            r6 = 100
            r19 = 0
            r20 = 0
            r4 = r3
            r5 = r12
            r21 = 1
            r7 = r17
            r22 = r8
            r23 = 0
            r8 = r19
            r19 = 2
            r9 = r20
            int r9 = printField(r4, r5, r6, r7, r8, r9)
            r6 = 104(0x68, float:1.46E-43)
            r8 = r22
            if (r9 == r8) goto Ld5
            r17 = 1
            goto Ld7
        Ld5:
            r17 = 0
        Ld7:
            if (r18 == 0) goto Ldc
            r20 = 2
            goto Lde
        Ldc:
            r20 = 0
        Lde:
            r4 = r3
            r5 = r13
            r7 = r9
            r24 = r8
            r8 = r17
            r17 = r9
            r9 = r20
            int r9 = printField(r4, r5, r6, r7, r8, r9)
            r6 = 109(0x6d, float:1.53E-43)
            r8 = r24
            if (r9 == r8) goto Lf6
            r17 = 1
            goto Lf8
        Lf6:
            r17 = 0
        Lf8:
            if (r18 == 0) goto Lfd
            r20 = 2
            goto Lff
        Lfd:
            r20 = 0
        Lff:
            r4 = r3
            r5 = r14
            r7 = r9
            r25 = r8
            r8 = r17
            r17 = r9
            r9 = r20
            int r9 = printField(r4, r5, r6, r7, r8, r9)
            r6 = 115(0x73, float:1.61E-43)
            r8 = r25
            if (r9 == r8) goto L115
            goto L117
        L115:
            r21 = 0
        L117:
            if (r18 == 0) goto L11a
            goto L11c
        L11a:
            r19 = 0
        L11c:
            r4 = r3
            r5 = r15
            r7 = r9
            r26 = r8
            r8 = r21
            r17 = r9
            r9 = r19
            int r9 = printField(r4, r5, r6, r7, r8, r9)
            r6 = 109(0x6d, float:1.53E-43)
            r8 = 1
            if (r18 == 0) goto L135
            r7 = r26
            if (r9 == r7) goto L137
            goto L139
        L135:
            r7 = r26
        L137:
            r16 = 0
        L139:
            r4 = r3
            r5 = r11
            r17 = r7
            r7 = r9
            r19 = r9
            r9 = r16
            int r4 = printField(r4, r5, r6, r7, r8, r9)
            r5 = 115(0x73, float:1.61E-43)
            r3[r4] = r5
            int r5 = r4 + 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.TimeUtils.formatDurationLocked(long, int):int");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void formatDuration(long duration, StringBuilder builder) {
        synchronized (sFormatSync) {
            int len = formatDurationLocked(duration, 0);
            builder.append(sFormatStr, 0, len);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void formatDuration(long duration, PrintWriter pw, int fieldLen) {
        synchronized (sFormatSync) {
            int len = formatDurationLocked(duration, fieldLen);
            pw.print(new String(sFormatStr, 0, len));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void formatDuration(long duration, PrintWriter pw) {
        formatDuration(duration, pw, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void formatDuration(long time, long now, PrintWriter pw) {
        if (time == 0) {
            pw.print("--");
        } else {
            formatDuration(time - now, pw, 0);
        }
    }

    private TimeUtils() {
    }
}