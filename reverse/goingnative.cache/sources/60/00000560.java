package com.mobisec.gonative;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* loaded from: C:\Users\MMMMM\AppData\Local\Temp\jadx-11512558176823414093.dex */
class FlagChecker {
    private static native boolean helloFromTheOtherSide(String str, int i);

    FlagChecker() {
    }

    static {
        System.loadLibrary("native-lib");
    }

    public static boolean checkFlag(String str) {
        String[] split = str.split("-");
        if (split.length == 2 && split[0].startsWith("MOBISEC{") && split[1].endsWith("}")) {
            String replace = split[0].replace("MOBISEC{", "");
            String replace2 = split[1].replace("}", "");
            if (replace2.matches("^[0-9]*$") && replace2.length() == 6) {
                return helloFromTheOtherSide(replace, Integer.parseInt(replace2));
            }
            return false;
        }
        return false;
    }
}