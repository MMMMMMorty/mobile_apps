package com.mobisec.upos;

import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public class FC {
    public static Context ctx = null;
    public static long[][] m = (long[][]) Array.newInstance(long.class, 256, 256);

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [336=11, 340=11, 344=11, 348=10, 352=10, 195=7, 232=7] */
    /* JADX WARN: Can't wrap try/catch for region: R(10:(4:(15:35|36|37|38|39|(1:41)(1:328)|42|43|44|45|(1:(2:47|(2:50|51)(1:49))(1:307))|52|53|54|(7:56|57|58|59|60|61|(1:63)(9:64|65|(2:66|(2:68|(2:70|71))(1:264))|72|73|74|75|76|(1:78)(2:79|(2:223|224)(2:83|(1:85)(32:86|(1:88)(1:222)|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|(2:119|(1:177)(8:123|(8:126|127|(3:129|(1:131)|132)|133|134|(5:136|137|138|139|140)(2:162|163)|141|124)|164|165|(2:167|(2:170|171)(1:169))|172|173|(1:175)(1:176)))(2:179|180))))))(2:285|286))|53|54|(0)(0))|38|39|(0)(0)|42|43|44|45|(2:(0)(0)|49)|52) */
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
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean checkFlag(android.content.Context r28, java.lang.String r29) {
        /*
            r1 = r28
            r2 = r29
            java.lang.String r3 = " "
            java.lang.String r4 = "mayb"
            r5 = r1
            com.mobisec.upos.MainActivity r5 = (com.mobisec.upos.MainActivity) r5
            android.support.v7.app.Activity.initActivity(r5)
            com.mobisec.upos.FC.ctx = r1
            r5 = 200(0xc8, float:2.8E-43)
            boolean[] r5 = new boolean[r5]
            com.mobisec.upos.Streamer r6 = new com.mobisec.upos.Streamer
            r6.<init>()
            r7 = 0
            r8 = 0
            long[][] r10 = com.mobisec.upos.FC.m     // Catch: java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d java.util.concurrent.RejectedExecutionException -> L544 java.security.cert.CertificateEncodingException -> L54b java.sql.BatchUpdateException -> L552
            lm(r10)     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            int r10 = r29.length()     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            r11 = 69
            if (r10 == r11) goto L29
            return r8
        L29:
            int r10 = r7 + 1
            java.lang.String r11 = "MOBISEC{"
            boolean r11 = r2.startsWith(r11)     // Catch: java.lang.Exception -> L512 java.security.GeneralSecurityException -> L516 java.util.concurrent.RejectedExecutionException -> L51a java.security.cert.CertificateEncodingException -> L51f java.sql.BatchUpdateException -> L524
            r5[r7] = r11     // Catch: java.lang.Exception -> L512 java.security.GeneralSecurityException -> L516 java.util.concurrent.RejectedExecutionException -> L51a java.security.cert.CertificateEncodingException -> L51f java.sql.BatchUpdateException -> L524
            r7 = 8
            java.lang.String r11 = r2.substring(r7)     // Catch: java.lang.Exception -> L512 java.security.GeneralSecurityException -> L516 java.util.concurrent.RejectedExecutionException -> L51a java.security.cert.CertificateEncodingException -> L51f java.sql.BatchUpdateException -> L524
            int r12 = r10 + 1
            java.lang.String r13 = "}"
            boolean r13 = r11.endsWith(r13)     // Catch: java.lang.Exception -> L4f6 java.security.GeneralSecurityException -> L4fb java.util.concurrent.RejectedExecutionException -> L500 java.security.cert.CertificateEncodingException -> L506 java.sql.BatchUpdateException -> L50c
            r5[r10] = r13     // Catch: java.lang.Exception -> L4f6 java.security.GeneralSecurityException -> L4fb java.util.concurrent.RejectedExecutionException -> L500 java.security.cert.CertificateEncodingException -> L506 java.sql.BatchUpdateException -> L50c
            r10 = 1
            r6.step()     // Catch: java.lang.NullPointerException -> L2ad java.util.IllformedLocaleException -> L2b2 java.lang.Exception -> L4f6 java.security.GeneralSecurityException -> L4fb java.util.concurrent.RejectedExecutionException -> L500 java.security.cert.CertificateEncodingException -> L506 java.sql.BatchUpdateException -> L50c
            boolean r15 = com.mobisec.upos.MainActivity.g2     // Catch: java.lang.NullPointerException -> L2ad java.util.IllformedLocaleException -> L2b2 java.lang.Exception -> L4f6 java.security.GeneralSecurityException -> L4fb java.util.concurrent.RejectedExecutionException -> L500 java.security.cert.CertificateEncodingException -> L506 java.sql.BatchUpdateException -> L50c
            if (r15 == 0) goto L4c
            return r8
        L4c:
            r6.step()     // Catch: java.lang.NullPointerException -> L2ad java.util.IllformedLocaleException -> L2b2 java.lang.Exception -> L4f6 java.security.GeneralSecurityException -> L4fb java.util.concurrent.RejectedExecutionException -> L500 java.security.cert.CertificateEncodingException -> L506 java.sql.BatchUpdateException -> L50c
            r6.step()     // Catch: java.lang.NullPointerException -> L2ad java.util.IllformedLocaleException -> L2b2 java.lang.Exception -> L4f6 java.security.GeneralSecurityException -> L4fb java.util.concurrent.RejectedExecutionException -> L500 java.security.cert.CertificateEncodingException -> L506 java.sql.BatchUpdateException -> L50c
            int r15 = r12 + 1
            java.lang.String r7 = "this_is_"
            boolean r7 = r11.startsWith(r7)     // Catch: java.lang.Exception -> L289 java.security.GeneralSecurityException -> L28e java.util.concurrent.RejectedExecutionException -> L293 java.security.cert.CertificateEncodingException -> L299 java.sql.BatchUpdateException -> L29f java.lang.NullPointerException -> L2a5 java.util.IllformedLocaleException -> L2a9
            r5[r12] = r7     // Catch: java.lang.Exception -> L289 java.security.GeneralSecurityException -> L28e java.util.concurrent.RejectedExecutionException -> L293 java.security.cert.CertificateEncodingException -> L299 java.sql.BatchUpdateException -> L29f java.lang.NullPointerException -> L2a5 java.util.IllformedLocaleException -> L2a9
            int r7 = r15 + 1
            java.lang.String r12 = "upos"
            boolean r12 = r11.endsWith(r12)     // Catch: java.lang.NullPointerException -> L281 java.util.IllformedLocaleException -> L285 java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            r5[r15] = r12     // Catch: java.lang.NullPointerException -> L281 java.util.IllformedLocaleException -> L285 java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            int r12 = r7 + 1
            r15 = 10
            char r9 = r11.charAt(r15)     // Catch: java.util.IllegalFormatCodePointException -> L27c java.lang.NullPointerException -> L2ad java.util.IllformedLocaleException -> L2b2 java.lang.Exception -> L4f6 java.security.GeneralSecurityException -> L4fb java.util.concurrent.RejectedExecutionException -> L500 java.security.cert.CertificateEncodingException -> L506 java.sql.BatchUpdateException -> L50c
            r14 = 99
            r15 = 13
            if (r9 == r14) goto L7f
            char r9 = r11.charAt(r15)     // Catch: java.util.IllegalFormatCodePointException -> L27c java.lang.NullPointerException -> L2ad java.util.IllformedLocaleException -> L2b2 java.lang.Exception -> L4f6 java.security.GeneralSecurityException -> L4fb java.util.concurrent.RejectedExecutionException -> L500 java.security.cert.CertificateEncodingException -> L506 java.sql.BatchUpdateException -> L50c
            r14 = 113(0x71, float:1.58E-43)
            if (r9 != r14) goto L7d
            goto L7f
        L7d:
            r9 = 0
            goto L80
        L7f:
            r9 = 1
        L80:
            r5[r7] = r9     // Catch: java.util.IllegalFormatCodePointException -> L27c java.lang.NullPointerException -> L2ad java.util.IllformedLocaleException -> L2b2 java.lang.Exception -> L4f6 java.security.GeneralSecurityException -> L4fb java.util.concurrent.RejectedExecutionException -> L500 java.security.cert.CertificateEncodingException -> L506 java.sql.BatchUpdateException -> L50c
            int r7 = r12 + 1
            r9 = 3
            char r9 = r11.charAt(r9)     // Catch: java.util.IllegalFormatCodePointException -> L278 java.lang.NullPointerException -> L281 java.util.IllformedLocaleException -> L285 java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            r14 = 7
            char r14 = r11.charAt(r14)     // Catch: java.util.IllegalFormatCodePointException -> L278 java.lang.NullPointerException -> L281 java.util.IllformedLocaleException -> L285 java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            int r9 = r9 + r14
            r14 = 114(0x72, float:1.6E-43)
            if (r9 != r14) goto L95
            r9 = 1
            goto L96
        L95:
            r9 = 0
        L96:
            r5[r12] = r9     // Catch: java.util.IllegalFormatCodePointException -> L278 java.lang.NullPointerException -> L281 java.util.IllformedLocaleException -> L285 java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            r6.step()     // Catch: java.util.IllegalFormatCodePointException -> L278 java.lang.NullPointerException -> L281 java.util.IllformedLocaleException -> L285 java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            int r9 = r7 + 1
            java.lang.String r12 = "really_"
            boolean r12 = r11.contains(r12)     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            r5[r7] = r12     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            r7 = 0
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            r12.<init>()     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            r14 = 2131427368(0x7f0b0028, float:1.847635E38)
            java.lang.String r14 = r1.getString(r14)     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            java.lang.String r14 = dec(r14)     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            r12.append(r14)     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            r12.append(r3)     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            r14 = 2131427369(0x7f0b0029, float:1.8476352E38)
            java.lang.String r20 = r1.getString(r14)     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            java.lang.String r8 = dec(r20)     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            r12.append(r8)     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            java.lang.String r8 = r12.toString()     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            java.lang.String r8 = ec(r8)     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            java.lang.String r12 = "\n"
            java.lang.String[] r8 = r8.split(r12)     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            int r12 = r8.length     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            r15 = 0
        Lda:
            if (r15 >= r12) goto L138
            r22 = r8[r15]     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            r23 = r22
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            r13.<init>()     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            r14 = 2131427370(0x7f0b002a, float:1.8476354E38)
            java.lang.String r14 = r1.getString(r14)     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            java.lang.String r14 = dec(r14)     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            r13.append(r14)     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            r13.append(r3)     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            r14 = 2131427369(0x7f0b0029, float:1.8476352E38)
            java.lang.String r24 = r1.getString(r14)     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            java.lang.String r14 = dec(r24)     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            r13.append(r14)     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            java.lang.String r14 = "/"
            r13.append(r14)     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            r14 = r23
            r13.append(r14)     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            java.lang.String r2 = "/maps"
            r13.append(r2)     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            java.lang.String r2 = r13.toString()     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            java.lang.String r13 = ec(r2)     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            r23 = r2
            r2 = 2131427371(0x7f0b002b, float:1.8476356E38)
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            java.lang.String r2 = dec(r2)     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            boolean r2 = r13.contains(r2)     // Catch: java.lang.Exception -> L251 java.security.GeneralSecurityException -> L256 java.util.concurrent.RejectedExecutionException -> L25b java.security.cert.CertificateEncodingException -> L261 java.sql.BatchUpdateException -> L267 java.lang.NullPointerException -> L26d java.util.IllformedLocaleException -> L271 java.util.IllegalFormatCodePointException -> L275
            if (r2 == 0) goto L130
            r7 = 1
            goto L138
        L130:
            int r15 = r15 + 1
            r2 = r29
            r14 = 2131427369(0x7f0b0029, float:1.8476352E38)
            goto Lda
        L138:
            int r2 = r9 + 1
            r5[r9] = r7     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.util.IllegalFormatCodePointException -> L24d java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            int r3 = r2 + (-1)
            boolean r3 = r5[r3]     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.util.IllegalFormatCodePointException -> L24d java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            if (r3 != 0) goto L23d
            r6.step()     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.util.IllegalFormatCodePointException -> L24d java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            int r3 = r2 + 1
            r9 = 14
            java.lang.String r12 = r11.substring(r9)     // Catch: java.lang.Exception -> L212 java.security.GeneralSecurityException -> L217 java.util.concurrent.RejectedExecutionException -> L21c java.security.cert.CertificateEncodingException -> L222 java.sql.BatchUpdateException -> L228 java.lang.NullPointerException -> L22e java.util.IllformedLocaleException -> L233 java.util.IllegalFormatCodePointException -> L238
            java.lang.String r9 = "_evil"
            boolean r9 = r12.endsWith(r9)     // Catch: java.lang.Exception -> L212 java.security.GeneralSecurityException -> L217 java.util.concurrent.RejectedExecutionException -> L21c java.security.cert.CertificateEncodingException -> L222 java.sql.BatchUpdateException -> L228 java.lang.NullPointerException -> L22e java.util.IllformedLocaleException -> L233 java.util.IllegalFormatCodePointException -> L238
            r5[r2] = r9     // Catch: java.lang.Exception -> L212 java.security.GeneralSecurityException -> L217 java.util.concurrent.RejectedExecutionException -> L21c java.security.cert.CertificateEncodingException -> L222 java.sql.BatchUpdateException -> L228 java.lang.NullPointerException -> L22e java.util.IllformedLocaleException -> L233 java.util.IllegalFormatCodePointException -> L238
            int r2 = r3 + 1
            r9 = 9
            r12 = 13
            java.lang.String r9 = r11.substring(r9, r12)     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.util.IllegalFormatCodePointException -> L24d java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            java.lang.String r12 = "bam"
            boolean r9 = r9.endsWith(r12)     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.util.IllegalFormatCodePointException -> L24d java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            r5[r3] = r9     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.util.IllegalFormatCodePointException -> L24d java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            r6.step()     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.util.IllegalFormatCodePointException -> L24d java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            boolean r3 = com.mobisec.upos.MainActivity.g4     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.util.IllegalFormatCodePointException -> L24d java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            if (r3 == 0) goto L170
            r3 = 0
            return r3
        L170:
            r6.step()     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.util.IllegalFormatCodePointException -> L24d java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            android.content.pm.PackageManager r3 = r28.getPackageManager()     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            r8 = 128(0x80, float:1.8E-43)
            java.util.List r3 = r3.getInstalledApplications(r8)     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            r7 = 0
            java.util.Iterator r8 = r3.iterator()     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
        L183:
            boolean r9 = r8.hasNext()     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            if (r9 == 0) goto L1a5
            java.lang.Object r9 = r8.next()     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            android.content.pm.ApplicationInfo r9 = (android.content.pm.ApplicationInfo) r9     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            java.lang.String r12 = r9.packageName     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            r13 = 2131427372(0x7f0b002c, float:1.8476358E38)
            java.lang.String r13 = r1.getString(r13)     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            java.lang.String r13 = dec(r13)     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            boolean r12 = r12.equals(r13)     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            if (r12 == 0) goto L1a4
            r7 = 1
            goto L1a5
        L1a4:
            goto L183
        L1a5:
            int r8 = r2 + 1
            r5[r2] = r7     // Catch: java.lang.Exception -> L1ec java.security.GeneralSecurityException -> L1f1 java.util.concurrent.RejectedExecutionException -> L1f6 java.security.cert.CertificateEncodingException -> L1fc java.sql.BatchUpdateException -> L202 java.lang.NullPointerException -> L208 java.util.IllformedLocaleException -> L20d
            r6.step()     // Catch: java.lang.Exception -> L1ec java.security.GeneralSecurityException -> L1f1 java.util.concurrent.RejectedExecutionException -> L1f6 java.security.cert.CertificateEncodingException -> L1fc java.sql.BatchUpdateException -> L202 java.lang.NullPointerException -> L208 java.util.IllformedLocaleException -> L20d
            int r2 = r8 + 1
            r9 = 4
            r12 = 10
            java.lang.String r9 = r11.substring(r9, r12)     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            java.lang.String r9 = r9.toLowerCase()     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            java.lang.String r12 = "incred"
            boolean r9 = r9.equals(r12)     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            r5[r8] = r9     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            boolean r8 = com.mobisec.upos.MainActivity.g1     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            if (r8 == 0) goto L1c7
            r4 = 0
            return r4
        L1c7:
            r6.step()     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            int r8 = r6.step()     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            if (r8 > 0) goto L1e6
            boolean r8 = com.mobisec.upos.MainActivity.g1     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            if (r8 == 0) goto L1e6
            r6.step()     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            r6.step()     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            r6.step()     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            r6.step()     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            r6.step()     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            goto L31c
        L1e6:
            java.util.IllformedLocaleException r8 = new java.util.IllformedLocaleException     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            r8.<init>()     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            throw r8     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
        L1ec:
            r0 = move-exception
            r1 = r0
            r2 = r8
            goto L53b
        L1f1:
            r0 = move-exception
            r1 = r0
            r2 = r8
            goto L540
        L1f6:
            r0 = move-exception
            r1 = r0
            r2 = r8
            r3 = 1
            goto L548
        L1fc:
            r0 = move-exception
            r1 = r0
            r2 = r8
            r3 = 1
            goto L54f
        L202:
            r0 = move-exception
            r1 = r0
            r2 = r8
            r3 = 1
            goto L556
        L208:
            r0 = move-exception
            r2 = r0
            r9 = r8
            goto L2b0
        L20d:
            r0 = move-exception
            r2 = r0
            r9 = r8
            goto L2b5
        L212:
            r0 = move-exception
            r1 = r0
            r2 = r3
            goto L53b
        L217:
            r0 = move-exception
            r1 = r0
            r2 = r3
            goto L540
        L21c:
            r0 = move-exception
            r1 = r0
            r2 = r3
            r3 = 1
            goto L548
        L222:
            r0 = move-exception
            r1 = r0
            r2 = r3
            r3 = 1
            goto L54f
        L228:
            r0 = move-exception
            r1 = r0
            r2 = r3
            r3 = 1
            goto L556
        L22e:
            r0 = move-exception
            r2 = r0
            r9 = r3
            goto L2b0
        L233:
            r0 = move-exception
            r2 = r0
            r9 = r3
            goto L2b5
        L238:
            r0 = move-exception
            r2 = r0
            r9 = r3
            goto L27f
        L23d:
            java.sql.BatchUpdateException r3 = new java.sql.BatchUpdateException     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.util.IllegalFormatCodePointException -> L24d java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            r3.<init>()     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.util.IllegalFormatCodePointException -> L24d java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            throw r3     // Catch: java.lang.NullPointerException -> L243 java.util.IllformedLocaleException -> L248 java.util.IllegalFormatCodePointException -> L24d java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
        L243:
            r0 = move-exception
            r9 = r2
            r2 = r0
            goto L2b0
        L248:
            r0 = move-exception
            r9 = r2
            r2 = r0
            goto L2b5
        L24d:
            r0 = move-exception
            r9 = r2
            r2 = r0
            goto L27f
        L251:
            r0 = move-exception
            r1 = r0
            r2 = r9
            goto L53b
        L256:
            r0 = move-exception
            r1 = r0
            r2 = r9
            goto L540
        L25b:
            r0 = move-exception
            r1 = r0
            r2 = r9
            r3 = 1
            goto L548
        L261:
            r0 = move-exception
            r1 = r0
            r2 = r9
            r3 = 1
            goto L54f
        L267:
            r0 = move-exception
            r1 = r0
            r2 = r9
            r3 = 1
            goto L556
        L26d:
            r0 = move-exception
            r2 = r0
            goto L2b0
        L271:
            r0 = move-exception
            r2 = r0
            goto L2b5
        L275:
            r0 = move-exception
            r2 = r0
            goto L27f
        L278:
            r0 = move-exception
            r2 = r0
            r9 = r7
            goto L27f
        L27c:
            r0 = move-exception
            r2 = r0
            r9 = r12
        L27f:
            r3 = 0
            return r3
        L281:
            r0 = move-exception
            r2 = r0
            r9 = r7
            goto L2b0
        L285:
            r0 = move-exception
            r2 = r0
            r9 = r7
            goto L2b5
        L289:
            r0 = move-exception
            r1 = r0
            r2 = r15
            goto L53b
        L28e:
            r0 = move-exception
            r1 = r0
            r2 = r15
            goto L540
        L293:
            r0 = move-exception
            r1 = r0
            r2 = r15
            r3 = 1
            goto L548
        L299:
            r0 = move-exception
            r1 = r0
            r2 = r15
            r3 = 1
            goto L54f
        L29f:
            r0 = move-exception
            r1 = r0
            r2 = r15
            r3 = 1
            goto L556
        L2a5:
            r0 = move-exception
            r2 = r0
            r9 = r15
            goto L2b0
        L2a9:
            r0 = move-exception
            r2 = r0
            r9 = r15
            goto L2b5
        L2ad:
            r0 = move-exception
            r2 = r0
            r9 = r12
        L2b0:
            r3 = 0
            return r3
        L2b2:
            r0 = move-exception
            r2 = r0
            r9 = r12
        L2b5:
            int r7 = r9 + 1
            r3 = 22
            java.lang.String r8 = r11.substring(r3)     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            java.lang.String r3 = r8.toUpperCase()     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            boolean r3 = r3.startsWith(r4)     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            r5[r9] = r3     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            r6.step()     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            int r3 = r7 + (-3)
            boolean r3 = r5[r3]     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            if (r3 == 0) goto L4f0
            boolean r3 = com.mobisec.upos.MainActivity.g3     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            if (r3 == 0) goto L2d9
            r6.step()     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            r3 = 0
            return r3
        L2d9:
            r6.step()     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            r3 = 2131427374(0x7f0b002e, float:1.8476362E38)
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Exception -> L30d
            java.lang.String r3 = dec(r3)     // Catch: java.lang.Exception -> L30d
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Exception -> L30d
            r8 = 2131427375(0x7f0b002f, float:1.8476364E38)
            java.lang.String r8 = r1.getString(r8)     // Catch: java.lang.Exception -> L30d
            java.lang.String r8 = dec(r8)     // Catch: java.lang.Exception -> L30d
            r9 = 0
            java.lang.Class[] r12 = new java.lang.Class[r9]     // Catch: java.lang.Exception -> L30d
            java.lang.reflect.Method r8 = r3.getMethod(r8, r12)     // Catch: java.lang.Exception -> L30d
            r12 = 0
            java.lang.Object[] r13 = new java.lang.Object[r9]     // Catch: java.lang.Exception -> L30d
            java.lang.Object r9 = r8.invoke(r12, r13)     // Catch: java.lang.Exception -> L30d
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Exception -> L30d
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Exception -> L30d
            r5[r7] = r9     // Catch: java.lang.Exception -> L30d
            goto L312
        L30d:
            r0 = move-exception
            r3 = r0
            r8 = 0
            r5[r7] = r8     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
        L312:
            int r7 = r7 + 1
            int r3 = r7 + (-1)
            boolean r3 = r5[r3]     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            if (r3 != 0) goto L4ea
            r10 = 0
            r2 = r7
        L31c:
            if (r10 == 0) goto L320
            r3 = 0
            return r3
        L320:
            int r7 = r2 + 1
            java.lang.String r3 = r11.toLowerCase()     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            r8 = 11
            r9 = 14
            java.lang.String r3 = r3.substring(r8, r9)     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            r8 = 1
            char r3 = r3.charAt(r8)     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            r8 = 52
            if (r3 != r8) goto L339
            r3 = 1
            goto L33a
        L339:
            r3 = 0
        L33a:
            r5[r2] = r3     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            int r2 = r7 + 1
            r3 = 22
            java.lang.String r3 = r11.substring(r3)     // Catch: java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            java.lang.String r3 = r3.toUpperCase()     // Catch: java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            boolean r3 = r3.startsWith(r4)     // Catch: java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            r5[r7] = r3     // Catch: java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            android.content.pm.PackageManager r3 = r28.getPackageManager()     // Catch: java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            java.lang.String r4 = r28.getPackageName()     // Catch: java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            r7 = 64
            r8 = 0
            android.content.pm.PackageInfo r9 = r3.getPackageInfo(r4, r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L35f java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            r8 = r9
            goto L364
        L35f:
            r0 = move-exception
            r9 = r0
            r9.printStackTrace()     // Catch: java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
        L364:
            android.content.pm.Signature[] r9 = r8.signatures     // Catch: java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            r12 = 0
            r13 = r9[r12]     // Catch: java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            byte[] r12 = r13.toByteArray()     // Catch: java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            java.io.ByteArrayInputStream r13 = new java.io.ByteArrayInputStream     // Catch: java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            r13.<init>(r12)     // Catch: java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            r14 = 0
            java.lang.String r15 = "X509"
            java.security.cert.CertificateFactory r15 = java.security.cert.CertificateFactory.getInstance(r15)     // Catch: java.security.cert.CertificateException -> L37b java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.sql.BatchUpdateException -> L4e5
            r14 = r15
            goto L380
        L37b:
            r0 = move-exception
            r15 = r0
            r15.printStackTrace()     // Catch: java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
        L380:
            r15 = 0
            java.security.cert.Certificate r18 = r14.generateCertificate(r13)     // Catch: java.security.cert.CertificateException -> L38a java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.sql.BatchUpdateException -> L4e5
            java.security.cert.X509Certificate r18 = (java.security.cert.X509Certificate) r18     // Catch: java.security.cert.CertificateException -> L38a java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.sql.BatchUpdateException -> L4e5
            r15 = r18
            goto L390
        L38a:
            r0 = move-exception
            r18 = r0
            r18.printStackTrace()     // Catch: java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
        L390:
            r18 = 0
            java.lang.String r19 = "SHA1"
            java.security.MessageDigest r19 = java.security.MessageDigest.getInstance(r19)     // Catch: java.security.cert.CertificateEncodingException -> L3c1 java.security.NoSuchAlgorithmException -> L3cb java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.sql.BatchUpdateException -> L4e5
            r20 = r19
            r19 = r3
            byte[] r3 = r15.getEncoded()     // Catch: java.security.cert.CertificateEncodingException -> L3b7 java.security.NoSuchAlgorithmException -> L3bc java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.sql.BatchUpdateException -> L4e5
            r22 = r4
            r4 = r20
            byte[] r3 = r4.digest(r3)     // Catch: java.security.cert.CertificateEncodingException -> L3b1 java.security.NoSuchAlgorithmException -> L3b4 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.sql.BatchUpdateException -> L4e5
            java.lang.String r20 = th(r3)     // Catch: java.security.cert.CertificateEncodingException -> L3b1 java.security.NoSuchAlgorithmException -> L3b4 java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.sql.BatchUpdateException -> L4e5
            r18 = r20
            r3 = r18
            goto L3d7
        L3b1:
            r0 = move-exception
            r3 = r0
            goto L3c7
        L3b4:
            r0 = move-exception
            r3 = r0
            goto L3d1
        L3b7:
            r0 = move-exception
            r22 = r4
            r3 = r0
            goto L3c7
        L3bc:
            r0 = move-exception
            r22 = r4
            r3 = r0
            goto L3d1
        L3c1:
            r0 = move-exception
            r19 = r3
            r22 = r4
            r3 = r0
        L3c7:
            r3.printStackTrace()     // Catch: java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
            goto L3d5
        L3cb:
            r0 = move-exception
            r19 = r3
            r22 = r4
            r3 = r0
        L3d1:
            r3.printStackTrace()     // Catch: java.lang.Exception -> L4d3 java.security.GeneralSecurityException -> L4d7 java.util.concurrent.RejectedExecutionException -> L4db java.security.cert.CertificateEncodingException -> L4e0 java.sql.BatchUpdateException -> L4e5
        L3d5:
            r3 = r18
        L3d7:
            int r4 = r2 + 1
            r18 = r7
            r7 = 2131427373(0x7f0b002d, float:1.847636E38)
            java.lang.String r7 = r1.getString(r7)     // Catch: java.lang.Exception -> L4b7 java.security.GeneralSecurityException -> L4bc java.util.concurrent.RejectedExecutionException -> L4c1 java.security.cert.CertificateEncodingException -> L4c7 java.sql.BatchUpdateException -> L4cd
            boolean r7 = r3.equals(r7)     // Catch: java.lang.Exception -> L4b7 java.security.GeneralSecurityException -> L4bc java.util.concurrent.RejectedExecutionException -> L4c1 java.security.cert.CertificateEncodingException -> L4c7 java.sql.BatchUpdateException -> L4cd
            r5[r2] = r7     // Catch: java.lang.Exception -> L4b7 java.security.GeneralSecurityException -> L4bc java.util.concurrent.RejectedExecutionException -> L4c1 java.security.cert.CertificateEncodingException -> L4c7 java.sql.BatchUpdateException -> L4cd
            int r2 = r4 + (-1)
            boolean r2 = r5[r2]     // Catch: java.lang.Exception -> L4b7 java.security.GeneralSecurityException -> L4bc java.util.concurrent.RejectedExecutionException -> L4c1 java.security.cert.CertificateEncodingException -> L4c7 java.sql.BatchUpdateException -> L4cd
            if (r2 == 0) goto L4b1
            r2 = 0
            boolean r7 = r5[r2]     // Catch: java.lang.Exception -> L4b7 java.security.GeneralSecurityException -> L4bc java.util.concurrent.RejectedExecutionException -> L4c1 java.security.cert.CertificateEncodingException -> L4c7 java.sql.BatchUpdateException -> L4cd
            if (r7 == 0) goto L4af
            r2 = 1
            boolean r7 = r5[r2]     // Catch: java.lang.Exception -> L4b7 java.security.GeneralSecurityException -> L4bc java.util.concurrent.RejectedExecutionException -> L4c1 java.security.cert.CertificateEncodingException -> L4c7 java.sql.BatchUpdateException -> L4cd
            if (r7 != 0) goto L3fa
            goto L4af
        L3fa:
            r2 = 100
            r4 = 0
            r7 = r2
        L3fe:
            r2 = 30
            if (r4 >= r2) goto L492
            r2 = 1
            r5[r7] = r2     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            r2.<init>()     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            int r1 = r4 * 2
            char r1 = r11.charAt(r1)     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            java.lang.String r1 = java.lang.Character.toString(r1)     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            r2.append(r1)     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            int r1 = r4 * 2
            r17 = 1
            int r1 = r1 + 1
            char r1 = r11.charAt(r1)     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            java.lang.String r1 = java.lang.Character.toString(r1)     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            r2.append(r1)     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            java.lang.String r1 = r2.toString()     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            boolean r2 = ip(r4)     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            if (r2 == 0) goto L43b
            r2 = 0
        L433:
            if (r2 >= r4) goto L43b
            r6.step()     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            int r2 = r2 + 1
            goto L433
        L43b:
            int r2 = r6.g2()     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r20 = r6.g2()     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            r23 = 65280(0xff00, float:9.1477E-41)
            r20 = r20 & r23
            r16 = 8
            int r20 = r20 >> 8
            java.lang.String r23 = r(r1)     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            long r23 = sq(r23)     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            long[][] r25 = com.mobisec.upos.FC.m     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            r25 = r25[r2]     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            r26 = r25[r20]     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            int r25 = (r23 > r26 ? 1 : (r23 == r26 ? 0 : -1))
            if (r25 == 0) goto L48a
            int r23 = r7 + 1
            r21 = 0
            r5[r7] = r21     // Catch: java.lang.Exception -> L469 java.security.GeneralSecurityException -> L46f java.util.concurrent.RejectedExecutionException -> L475 java.security.cert.CertificateEncodingException -> L47c java.sql.BatchUpdateException -> L483
            r7 = r23
            goto L48c
        L469:
            r0 = move-exception
            r1 = r0
            r2 = r23
            goto L53b
        L46f:
            r0 = move-exception
            r1 = r0
            r2 = r23
            goto L540
        L475:
            r0 = move-exception
            r1 = r0
            r2 = r23
            r3 = 1
            goto L548
        L47c:
            r0 = move-exception
            r1 = r0
            r2 = r23
            r3 = 1
            goto L54f
        L483:
            r0 = move-exception
            r1 = r0
            r2 = r23
            r3 = 1
            goto L556
        L48a:
            int r7 = r7 + 1
        L48c:
            int r4 = r4 + 1
            r1 = r28
            goto L3fe
        L492:
            int r1 = r7 + (-30)
        L494:
            if (r1 >= r7) goto L49f
            boolean r2 = r5[r1]     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            if (r2 != 0) goto L49c
            r2 = 0
            return r2
        L49c:
            int r1 = r1 + 1
            goto L494
        L49f:
            java.lang.String r1 = h(r29)     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            java.lang.String r2 = "4193d9b72a5c4805e9a5cc739f8a8fc23b2890e13b83bb887d96f86c30654a12"
            boolean r1 = r1.equals(r2)     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            if (r1 != 0) goto L4ad
            r1 = 0
            return r1
        L4ad:
            r1 = 1
            return r1
        L4af:
            r1 = 0
            return r1
        L4b1:
            java.security.GeneralSecurityException r1 = new java.security.GeneralSecurityException     // Catch: java.lang.Exception -> L4b7 java.security.GeneralSecurityException -> L4bc java.util.concurrent.RejectedExecutionException -> L4c1 java.security.cert.CertificateEncodingException -> L4c7 java.sql.BatchUpdateException -> L4cd
            r1.<init>()     // Catch: java.lang.Exception -> L4b7 java.security.GeneralSecurityException -> L4bc java.util.concurrent.RejectedExecutionException -> L4c1 java.security.cert.CertificateEncodingException -> L4c7 java.sql.BatchUpdateException -> L4cd
            throw r1     // Catch: java.lang.Exception -> L4b7 java.security.GeneralSecurityException -> L4bc java.util.concurrent.RejectedExecutionException -> L4c1 java.security.cert.CertificateEncodingException -> L4c7 java.sql.BatchUpdateException -> L4cd
        L4b7:
            r0 = move-exception
            r1 = r0
            r2 = r4
            goto L53b
        L4bc:
            r0 = move-exception
            r1 = r0
            r2 = r4
            goto L540
        L4c1:
            r0 = move-exception
            r1 = r0
            r2 = r4
            r3 = 1
            goto L548
        L4c7:
            r0 = move-exception
            r1 = r0
            r2 = r4
            r3 = 1
            goto L54f
        L4cd:
            r0 = move-exception
            r1 = r0
            r2 = r4
            r3 = 1
            goto L556
        L4d3:
            r0 = move-exception
            r1 = r0
            goto L53b
        L4d7:
            r0 = move-exception
            r1 = r0
            goto L540
        L4db:
            r0 = move-exception
            r1 = r0
            r3 = 1
            goto L548
        L4e0:
            r0 = move-exception
            r1 = r0
            r3 = 1
            goto L54f
        L4e5:
            r0 = move-exception
            r1 = r0
            r3 = 1
            goto L556
        L4ea:
            java.security.cert.CertificateEncodingException r1 = new java.security.cert.CertificateEncodingException     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            r1.<init>()     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            throw r1     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
        L4f0:
            java.util.concurrent.RejectedExecutionException r1 = new java.util.concurrent.RejectedExecutionException     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            r1.<init>()     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
            throw r1     // Catch: java.util.concurrent.RejectedExecutionException -> L529 java.security.cert.CertificateEncodingException -> L52e java.sql.BatchUpdateException -> L533 java.lang.Exception -> L538 java.security.GeneralSecurityException -> L53d
        L4f6:
            r0 = move-exception
            r1 = r0
            r2 = r12
            goto L53b
        L4fb:
            r0 = move-exception
            r1 = r0
            r2 = r12
            goto L540
        L500:
            r0 = move-exception
            r1 = r0
            r2 = r12
            r3 = 1
            goto L548
        L506:
            r0 = move-exception
            r1 = r0
            r2 = r12
            r3 = 1
            goto L54f
        L50c:
            r0 = move-exception
            r1 = r0
            r2 = r12
            r3 = 1
            goto L556
        L512:
            r0 = move-exception
            r1 = r0
            r2 = r10
            goto L53b
        L516:
            r0 = move-exception
            r1 = r0
            r2 = r10
            goto L540
        L51a:
            r0 = move-exception
            r1 = r0
            r2 = r10
            r3 = 1
            goto L548
        L51f:
            r0 = move-exception
            r1 = r0
            r2 = r10
            r3 = 1
            goto L54f
        L524:
            r0 = move-exception
            r1 = r0
            r2 = r10
            r3 = 1
            goto L556
        L529:
            r0 = move-exception
            r1 = r0
            r2 = r7
            r3 = 1
            goto L548
        L52e:
            r0 = move-exception
            r1 = r0
            r2 = r7
            r3 = 1
            goto L54f
        L533:
            r0 = move-exception
            r1 = r0
            r2 = r7
            r3 = 1
            goto L556
        L538:
            r0 = move-exception
            r1 = r0
            r2 = r7
        L53b:
            r3 = 0
            return r3
        L53d:
            r0 = move-exception
            r1 = r0
            r2 = r7
        L540:
            r3 = 1
            com.mobisec.upos.MainActivity.g4 = r3
            goto L558
        L544:
            r0 = move-exception
            r3 = 1
            r1 = r0
            r2 = r7
        L548:
            com.mobisec.upos.MainActivity.g3 = r3
            goto L558
        L54b:
            r0 = move-exception
            r3 = 1
            r1 = r0
            r2 = r7
        L54f:
            com.mobisec.upos.MainActivity.g1 = r3
            goto L558
        L552:
            r0 = move-exception
            r3 = 1
            r1 = r0
            r2 = r7
        L556:
            com.mobisec.upos.MainActivity.g2 = r3
        L558:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobisec.upos.FC.checkFlag(android.content.Context, java.lang.String):boolean");
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