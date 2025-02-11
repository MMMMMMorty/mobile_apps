package com.mobisec.gonative;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* loaded from: C:\Users\MMMMM\AppData\Local\Temp\jadx-11512558176823414093.dex */
public class MainActivity extends AppCompatActivity {
    TextView mResultWidget = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131296284);
        final EditText editText = (EditText) findViewById(2131165245);
        final TextView textView = (TextView) findViewById(2131165280);
        this.mResultWidget = textView;
        editText.addTextChangedListener(new TextWatcher() { // from class: com.mobisec.gonative.MainActivity.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                MainActivity.this.mResultWidget.setText("");
            }
        });
        ((Button) findViewById(2131165223)).setOnClickListener(new View.OnClickListener() { // from class: com.mobisec.gonative.MainActivity.2
            /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
            /* JADX WARN: Removed duplicated region for block: B:13:0x0063  */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onClick(android.view.View r5) {
                /*
                    r4 = this;
                    android.widget.EditText r5 = r2
                    android.text.Editable r5 = r5.getText()
                    java.lang.String r5 = r5.toString()
                    android.widget.TextView r0 = r3
                    java.lang.String r1 = "Checking flag...."
                    r0.setText(r1)
                    android.widget.TextView r0 = r3
                    r1 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                    r0.setTextColor(r1)
                    boolean r5 = com.mobisec.gonative.FlagChecker.checkFlag(r5)     // Catch: java.lang.Exception -> L35
                    java.lang.String r0 = "MOBISEC"
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L33
                    r1.<init>()     // Catch: java.lang.Exception -> L33
                    java.lang.String r2 = "Flag result: "
                    r1.append(r2)     // Catch: java.lang.Exception -> L33
                    r1.append(r5)     // Catch: java.lang.Exception -> L33
                    java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L33
                    android.util.Log.d(r0, r1)     // Catch: java.lang.Exception -> L33
                    goto L51
                L33:
                    r0 = move-exception
                    goto L37
                L35:
                    r0 = move-exception
                    r5 = 0
                L37:
                    java.lang.String r1 = "MOBISEC"
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "Exception while checking flags:"
                    r2.append(r3)
                    java.lang.String r0 = android.util.Log.getStackTraceString(r0)
                    r2.append(r0)
                    java.lang.String r0 = r2.toString()
                    android.util.Log.e(r1, r0)
                L51:
                    if (r5 == 0) goto L63
                    android.widget.TextView r5 = r3
                    java.lang.String r0 = "Flag is valid!"
                    r5.setText(r0)
                    android.widget.TextView r4 = r3
                    r5 = -16737536(0xffffffffff009b00, float:-1.7094599E38)
                    r4.setTextColor(r5)
                    goto L71
                L63:
                    android.widget.TextView r5 = r3
                    java.lang.String r0 = "Flag is not valid"
                    r5.setText(r0)
                    android.widget.TextView r4 = r3
                    r5 = -65536(0xffffffffffff0000, float:NaN)
                    r4.setTextColor(r5)
                L71:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mobisec.gonative.MainActivity.AnonymousClass2.onClick(android.view.View):void");
            }
        });
    }
}