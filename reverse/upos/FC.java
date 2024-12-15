package com.mobisec.upos;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.Activity;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.sql.BatchUpdateException;
import java.util.IllegalFormatCodePointException;
import java.util.IllformedLocaleException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes2.dex */
public class FC {
    public static Context ctx = null;
    public static long[][] m = (long[][]) Array.newInstance(long.class, 256, 256);

    /* JADX WARN: Can't wrap try/catch for region: R(26:21|22|23|24|25|26|27|28|29|30|(15:35|36|37|38|39|(1:41)(1:328)|42|43|44|45|(1:(2:47|(2:50|51)(1:49))(1:307))|52|53|54|(7:56|57|58|59|60|61|(1:63)(9:64|65|(2:66|(2:68|(2:70|71))(1:264))|72|73|74|75|76|(1:78)(2:79|(2:223|224)(2:83|(1:85)(32:86|(1:88)(1:222)|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|(2:119|(1:177)(8:123|(8:126|127|(3:129|(1:131)|132)|133|134|(5:136|137|138|139|140)(2:162|163)|141|124)|164|165|(2:167|(2:170|171)(1:169))|172|173|(1:175)(1:176)))(2:179|180))))))(2:285|286))|333|36|37|38|39|(0)(0)|42|43|44|45|(2:(0)(0)|49)|52|53|54|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(4:(15:35|36|37|38|39|(1:41)(1:328)|42|43|44|45|(1:(2:47|(2:50|51)(1:49))(1:307))|52|53|54|(7:56|57|58|59|60|61|(1:63)(9:64|65|(2:66|(2:68|(2:70|71))(1:264))|72|73|74|75|76|(1:78)(2:79|(2:223|224)(2:83|(1:85)(32:86|(1:88)(1:222)|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|(2:119|(1:177)(8:123|(8:126|127|(3:129|(1:131)|132)|133|134|(5:136|137|138|139|140)(2:162|163)|141|124)|164|165|(2:167|(2:170|171)(1:169))|172|173|(1:175)(1:176)))(2:179|180))))))(2:285|286))|53|54|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0249, code lost:
        r9 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x025c, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0262, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0268, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:?, code lost:
        return false;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x023d A[Catch: NullPointerException -> 0x0243, IllformedLocaleException -> 0x0248, IllegalFormatCodePointException -> 0x024d, Exception -> 0x04d3, GeneralSecurityException -> 0x04d7, RejectedExecutionException -> 0x04db, CertificateEncodingException -> 0x04e0, BatchUpdateException -> 0x04e5, TRY_ENTER, TryCatch #69 {CertificateEncodingException -> 0x04e0, blocks: (B:44:0x013a, B:46:0x0142, B:50:0x015b, B:54:0x0170, B:55:0x0174, B:56:0x0183, B:58:0x0189, B:65:0x01b1, B:69:0x01c7, B:71:0x01d0, B:73:0x01d4, B:186:0x0340, B:188:0x0359, B:193:0x0364, B:223:0x03c7, B:226:0x03d1, B:205:0x038d, B:199:0x037d, B:192:0x0361, B:74:0x01e6, B:75:0x01eb, B:106:0x023d, B:107:0x0242), top: B:358:0x013a }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x031e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0320 A[Catch: RejectedExecutionException -> 0x0529, CertificateEncodingException -> 0x052e, BatchUpdateException -> 0x0533, Exception -> 0x0538, GeneralSecurityException -> 0x053d, TryCatch #64 {GeneralSecurityException -> 0x053d, Exception -> 0x0538, blocks: (B:3:0x001b, B:4:0x001d, B:20:0x005e, B:31:0x0085, B:35:0x0096, B:180:0x0320, B:184:0x033a, B:240:0x0403, B:244:0x0435, B:245:0x043b, B:265:0x0496, B:269:0x049c, B:270:0x049f, B:161:0x02b9, B:163:0x02d0, B:165:0x02d4, B:167:0x02d9, B:174:0x0312, B:300:0x04ea, B:301:0x04ef, B:173:0x0310, B:302:0x04f0, B:303:0x04f5), top: B:368:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x03ee A[Catch: Exception -> 0x04b7, GeneralSecurityException -> 0x04bc, RejectedExecutionException -> 0x04c1, CertificateEncodingException -> 0x04c7, BatchUpdateException -> 0x04cd, TryCatch #32 {CertificateEncodingException -> 0x04c7, GeneralSecurityException -> 0x04bc, BatchUpdateException -> 0x04cd, RejectedExecutionException -> 0x04c1, Exception -> 0x04b7, blocks: (B:229:0x03de, B:231:0x03ee, B:233:0x03f3, B:278:0x04b1, B:279:0x04b6), top: B:377:0x03de }] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x04b1 A[Catch: Exception -> 0x04b7, GeneralSecurityException -> 0x04bc, RejectedExecutionException -> 0x04c1, CertificateEncodingException -> 0x04c7, BatchUpdateException -> 0x04cd, TRY_ENTER, TryCatch #32 {CertificateEncodingException -> 0x04c7, GeneralSecurityException -> 0x04bc, BatchUpdateException -> 0x04cd, RejectedExecutionException -> 0x04c1, Exception -> 0x04b7, blocks: (B:229:0x03de, B:231:0x03ee, B:233:0x03f3, B:278:0x04b1, B:279:0x04b6), top: B:377:0x03de }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0138 A[EDGE_INSN: B:386:0x0138->B:43:0x0138 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00dc A[Catch: Exception -> 0x0251, GeneralSecurityException -> 0x0256, RejectedExecutionException -> 0x025b, CertificateEncodingException -> 0x0261, BatchUpdateException -> 0x0267, NullPointerException -> 0x026d, IllformedLocaleException -> 0x0271, IllegalFormatCodePointException -> 0x0275, TRY_LEAVE, TryCatch #27 {NullPointerException -> 0x026d, CertificateEncodingException -> 0x0261, GeneralSecurityException -> 0x0256, BatchUpdateException -> 0x0267, IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, RejectedExecutionException -> 0x025b, Exception -> 0x0251, blocks: (B:37:0x009d, B:39:0x00dc), top: B:384:0x009d }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0142 A[Catch: NullPointerException -> 0x0243, IllformedLocaleException -> 0x0248, IllegalFormatCodePointException -> 0x024d, Exception -> 0x04d3, GeneralSecurityException -> 0x04d7, RejectedExecutionException -> 0x04db, CertificateEncodingException -> 0x04e0, BatchUpdateException -> 0x04e5, TRY_LEAVE, TryCatch #69 {CertificateEncodingException -> 0x04e0, blocks: (B:44:0x013a, B:46:0x0142, B:50:0x015b, B:54:0x0170, B:55:0x0174, B:56:0x0183, B:58:0x0189, B:65:0x01b1, B:69:0x01c7, B:71:0x01d0, B:73:0x01d4, B:186:0x0340, B:188:0x0359, B:193:0x0364, B:223:0x03c7, B:226:0x03d1, B:205:0x038d, B:199:0x037d, B:192:0x0361, B:74:0x01e6, B:75:0x01eb, B:106:0x023d, B:107:0x0242), top: B:358:0x013a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean checkFlag(Context ctx2, String fl) {
        boolean z;
        boolean z2;
        boolean z3;
        int idx;
        int idx2;
        CertificateEncodingException e;
        NoSuchAlgorithmException e1;
        String hexString;
        int idx3;
        MessageDigest md;
        int idx4;
        boolean z4;
        int length;
        int i;
        int idx5;
        int idx6;
        Activity.initActivity((MainActivity) ctx2);
        ctx = ctx2;
        boolean[] fs = new boolean[200];
        Streamer s = new Streamer();
        try {
            try {
                try {
                    lm(m);
                    if (fl.length() != 69) {
                        return false;
                    }
                    int idx7 = 0 + 1; // 1
                    try {
                        fs[0] = fl.startsWith("MOBISEC{"); //f[0]
                        String core = fl.substring(8);
                        int idx8 = idx7 + 1; // 2
                        try {
                            fs[idx7] = core.endsWith("}"); // f[1]
                            boolean f = true;
                            s.step();
                            s.step();
                            s.step(); //3
                            int idx9 = idx8 + 1; // 3
                       
                            fs[idx8] = core.startsWith("this_is_"); //f[2]
                            idx4 = idx9 + 1; //4
                
                            fs[idx9] = core.endsWith("upos"); //f[3]
                            idx8 = idx4 + 1; //5
                           
                    
                            try {
                                try {
                                    try {
                                        try {
                                            if (core.charAt(10) != 'c' && core.charAt(13) != 'q') { // true
                                                z4 = false;
                                                fs[idx4] = z4;  //f[4] == false
                                                idx4 = idx8 + 1; // 6
                                                fs[idx8] = core.charAt(3) + core.charAt(7) != 114; // f[5]
                                                s.step(); // 4
                                                idx = idx4 + 1; // 7
                                                fs[idx4] = core.contains("really_"); // f[6]
                                                boolean found = false;
                                                String[] lines = ec(dec(ctx2.getString(R.string.s1)) + " " + dec(ctx2.getString(R.string.s2))).split("\n"); // s1: ls, s2: /proc
                                                length = lines.length; 
                                                i = 0;
                                                while (true) {
                                                    if (i < length) {
                                                        break;
                                                    }
                                                    String line = lines[i];
                                                    String maps = dec(ctx2.getString(R.string.s3)) + " " + dec(ctx2.getString(R.string.s2)) + "/" + line + "/maps"; // cat /x/proc
                                                    String out = ec(maps);
                                                    if (out.contains(dec(ctx2.getString(R.string.s4)))) { //frida
                                                        found = true;
                                                        break;
                                                    }
                                                    i++;
                                                }
                                                idx5 = idx + 1; // 8
                                                fs[idx] = found; // f[7]
                                                if (!fs[idx5 - 1]) { //f[7] == true, found == true
                                                    throw new BatchUpdateException();
                                                }
                                                s.step(); // 5
                                                int idx10 = idx5 + 1; // 9
                                             
                                                fs[idx5] = core.substring(14).endsWith("_evil"); //f[8]
                                                idx6 = idx10 + 1; // 10
                                                fs[idx10] = core.substring(9, 13).endsWith("bam"); //f[9]
                                                s.step(); //6
                                              
                                                s.step(); // 7
                                                List<ApplicationInfo> packages = ctx2.getPackageManager().getInstalledApplications(128);
                                                boolean found2 = false;
                                                Iterator<ApplicationInfo> it = packages.iterator();
                                                while (true) {
                                                    if (!it.hasNext()) {
                                                        break;
                                                    }
                                                    ApplicationInfo info = it.next();
                                                    if (info.packageName.equals(dec(ctx2.getString(R.string.s5)))) { //com.android.vending
                                                        found2 = true;
                                                        break;
                                                    }
                                                }
                                                int idx11 = idx6 + 1; // 11
                                              
                                                fs[idx6] = found2; // f[10]
                                                s.step(); // 8
                                                idx2 = idx11 + 1; // 12
                                                fs[idx11] = core.substring(4, 10).toLowerCase().equals("incred"); //f[11]
                                                
                                                // catch (IllformedLocaleException e26) {
                                                //     idx = idx11; //12
                                                //     int idx12 = idx + 1;
                                                //     fs[idx] = core.substring(22).toUpperCase().startsWith("mayb");
                                                //     s.step();
                                                //     if (!fs[idx12 - 3]) {
                                                //         throw new RejectedExecutionException();
                                                //     }
                                                //     if (MainActivity.g3) {
                                                //         s.step();
                                                //         return false;
                                                //     }
                                                //     s.step();
                                                //     try {
                                                //         Class c = Class.forName(dec(ctx2.getString(R.string.s7)));
                                                //         Method m2 = c.getMethod(dec(ctx2.getString(R.string.s8)), new Class[0]);
                                                //         boolean res = ((Boolean) m2.invoke(null, new Object[0])).booleanValue();
                                                //         fs[idx12] = res;
                                                //     } catch (Exception e27) {
                                                //         fs[idx12] = false;
                                                //     }
                                                //     int idx13 = idx12 + 1;
                                                //     if (fs[idx13 - 1]) {
                                                //         throw new CertificateEncodingException();
                                                //     }
                                                //     f = false;
                                                //     idx2 = idx13;
                                                //     if (!f) {
                                                //     }
                                                // } 
                                                s.step(); //9
                                                if (s.step() > 0 || !MainActivity.g1) {
                                                    throw new IllformedLocaleException();
                                                }
                                                s.step(); // 10
                                                s.step(); // 11
                                                s.step(); // 12
                                                s.step(); // 13
                                                s.step(); // 14
                                                if (!f) { // f == true
                                                    return false;
                                                }
                                                int idx14 = idx2 + 1; //13
                                                fs[idx2] = core.toLowerCase().substring(11, 14).charAt(1) == '4'; // f[12]
                                                int idx15 = idx14 + 1; // 14
                                                fs[idx14] = core.substring(22).toUpperCase().startsWith("mayb"); //f[13]
                                                PackageManager pm = ctx2.getPackageManager();
                                                String packageName = ctx2.getPackageName();
                                                PackageInfo packageInfo = null;   
                                                packageInfo = pm.getPackageInfo(packageName, 64);
                                                Signature[] signatures = packageInfo.signatures;
                                                byte[] cert2 = signatures[0].toByteArray();
                                                InputStream input = new ByteArrayInputStream(cert2);
                                                CertificateFactory cf = null;
                                               
                                                cf = CertificateFactory.getInstance("X509");
                                            
                                                X509Certificate c2 = null;
                                         
                                                c2 = (X509Certificate) cf.generateCertificate(input);
                                                
                                             
                                                md = MessageDigest.getInstance("SHA1");
                                                 
                                             
                                                byte[] publicKey = md.digest(c2.getEncoded());
                                                String hexString2 = th(publicKey);
                                                hexString = hexString2;
                                            
                                                idx3 = idx15 + 1; // 15
                                                try {
                                                    fs[idx15] = hexString.equals(ctx2.getString(R.string.s6)); //f[14]
                                                    if (fs[idx3 - 1]) { // f[14] == true
                                                        if (fs[0] && fs[1]) {
                                                            int idx16 = 100; //fs[100] - fs[129] true
                                                            for (int i2 = 0; i2 < 30; i2++) {
                                                                fs[idx16] = true;
                                                                String curr = Character.toString(core.charAt(i2 * 2)) + Character.toString(core.charAt((i2 * 2) + 1));
                                                                if (ip(i2)) { // starts with 14
                                                                    for (int j = 0; j < i2; j++) {
                                                                        s.step();
                                                                    }
                                                                }
                                                                int j2 = s.g2();
                                                                int mX = j2 & 255;
                                                                int mY = (s.g2() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                                                                if (sq(r(curr)) != m[mX][mY]) {
                                                                    int idx17 = idx16 + 1;
                                                                    fs[idx16] = false;
                                                                    idx16 = idx17;
                                                                } else {
                                                                    idx16++;
                                                                }
                                                            }
                                                            for (int i3 = idx16 - 30; i3 < idx16; i3++) {
                                                                if (!fs[i3]) {
                                                                    return false;
                                                                }
                                                            }
                                                            return h(fl).equals("4193d9b72a5c4805e9a5cc739f8a8fc23b2890e13b83bb887d96f86c30654a12");
                                                        }
                                                        return false;
                                                    }
                                                    throw new GeneralSecurityException();
                                                } catch (CertificateEncodingException e44) {
                                                    z3 = true;
                                                } catch (GeneralSecurityException e45) {
                                                } catch (BatchUpdateException e46) {
                                                    z2 = true;
                                                } catch (RejectedExecutionException e47) {
                                                    z = true;
                                                } catch (Exception e48) {
                                                    return false;
                                                }
                                            }
                                            fs[idx] = found;
                                            if (!fs[idx5 - 1]) {
                                            }
                                        } catch (CertificateEncodingException e49) {
                                            z3 = true;
                                        }
                                    } catch (IllegalFormatCodePointException e50) {
                                        return false;
                                    }
                                } catch (GeneralSecurityException e51) {
                                } catch (BatchUpdateException e52) {
                                    z2 = true;
                                } catch (RejectedExecutionException e53) {
                                    z = true;
                                } catch (Exception e54) {
                                    return false;
                                }
                                fs[idx8] = core.charAt(3) + core.charAt(7) != 114;
                                s.step();
                                idx = idx4 + 1;
                                fs[idx4] = core.contains("really_");
                                boolean found3 = false;
                                String[] lines2 = ec(dec(ctx2.getString(R.string.s1)) + " " + dec(ctx2.getString(R.string.s2))).split("\n");
                                length = lines2.length;
                                i = 0;
                                while (true) {
                                    if (i < length) {
                                    }
                                    i++;
                                }
                                idx5 = idx + 1;
                            } catch (IllegalFormatCodePointException e55) {
                                return false;
                            }
                            z4 = true;
                            fs[idx4] = z4;
                            idx4 = idx8 + 1;
                        } catch (CertificateEncodingException e56) {
                            z3 = true;
                        } catch (GeneralSecurityException e57) {
                        } catch (BatchUpdateException e58) {
                            z2 = true;
                        } catch (RejectedExecutionException e59) {
                            z = true;
                        } catch (Exception e60) {
                            return false;
                        }
                    } catch (CertificateEncodingException e61) {
                        z3 = true;
                    } catch (GeneralSecurityException e62) {
                    } catch (BatchUpdateException e63) {
                        z2 = true;
                    } catch (RejectedExecutionException e64) {
                        z = true;
                    } catch (Exception e65) {
                        return false;
                    }
                } catch (CertificateEncodingException e66) {
                    z3 = true;
                } catch (BatchUpdateException e67) {
                    z2 = true;
                } catch (RejectedExecutionException e68) {
                    z = true;
                }
            } catch (GeneralSecurityException e69) {
            } catch (Exception e70) {
                return false;
            }
        } catch (CertificateEncodingException e71) {
            z3 = true;
        } catch (BatchUpdateException e72) {
            z2 = true;
        } catch (RejectedExecutionException e73) {
            z = true;
        }
    }

    private static String h(String flag) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(flag.getBytes());
            byte[] digest = md.digest();
            return th(digest);
        } catch (Exception e) {
            return null;
        }
    }

    public static String th(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 255);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private static void lm(long[][] matrix) throws Exception {
        BufferedReader reader = null;
        try {
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(ctx.getAssets().open("lotto.dat")));
            int rowIdx = 0;
            while (true) {
                String row = reader2.readLine();
                if (row != null) {
                    String[] elems = row.split(" ");
                    int colIdx = 0;
                    for (String elem : elems) {
                        long e = Long.parseLong(elem);
                        matrix[rowIdx][colIdx] = e;
                        colIdx++;
                    }
                    if (colIdx != 256) {
                        throw new Exception("error");
                    }
                    rowIdx++;
                } else if (rowIdx != 256) {
                    throw new Exception("error");
                } else {
                    reader2.close();
                    return;
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                reader.close();
            }
            throw th;
        }
    }

    public static boolean ip(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String r(String s) {
        String out = BuildConfig.FLAVOR;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 's') {
                c = (char) (c + 7);
            } else if (c >= 'A' && c <= 'S') {
                c = (char) (c + 7);
            } else if (c >= 't' && c <= 'z') {
                c = (char) (c - 19);
            } else if (c >= 'T' && c <= 'Z') {
                c = (char) (c - 19);
            }
            out = out + c;
        }
        return out;
    }

    public static long sq(String a) {
        int n = (a.charAt(0) + (a.charAt(1) << '\b')) & SupportMenu.USER_MASK;
        long n2 = (long) Math.pow(n, 2.0d);
        return n2;
    }

    public static String dec(String x) {
        return new String(Base64.decode(x, 0));
    }

    public static String ec(String cmd) {
        String out = new String();
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            InputStream stdout = p.getInputStream();
            byte[] buffer = new byte[102400];
            while (true) {
                int read = stdout.read(buffer);
                if (read > 0 && read <= 102400) {
                    String line = new String(buffer, 0, read);
                    out = out + line;
                } else if (stdout.available() <= 0) {
                    break;
                }
            }
            stdout.close();
        } catch (Exception e) {
        }
        return out;
    }
}
