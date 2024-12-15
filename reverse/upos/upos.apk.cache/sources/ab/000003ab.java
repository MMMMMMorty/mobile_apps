package android.support.v7.app;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.mobisec.upos.FC;
import com.mobisec.upos.MainActivity;
import com.mobisec.upos.R;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class Activity {
    public static void initActivity(MainActivity ctx) {
        boolean found;
        boolean found2 = false;
        String[] lines = FC.ec(FC.dec(ctx.getString(R.string.s1)) + " " + FC.dec(ctx.getString(R.string.s2))).split("\n");
        int length = lines.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            String line = lines[i];
            String maps = FC.dec(ctx.getString(R.string.s3)) + " " + FC.dec(ctx.getString(R.string.s2)) + "/" + line + "/maps";
            String out = FC.ec(maps);
            if (!out.contains(FC.dec(ctx.getString(R.string.s4)))) {
                i++;
            } else {
                found2 = true;
                break;
            }
        }
        MainActivity.g2 = found2;
        List<ApplicationInfo> packages = ctx.getPackageManager().getInstalledApplications(128);
        Iterator<ApplicationInfo> it = packages.iterator();
        while (true) {
            if (it.hasNext()) {
                ApplicationInfo info = it.next();
                if (info.packageName.equals(FC.dec(ctx.getString(R.string.s5)))) {
                    found = true;
                    break;
                }
            } else {
                found = false;
                break;
            }
        }
        MainActivity.g3 = !found;
        try {
            Class c = Class.forName(FC.dec(ctx.getString(R.string.s7)));
            Method m = c.getMethod(FC.dec(ctx.getString(R.string.s8)), new Class[0]);
            boolean res = ((Boolean) m.invoke(null, new Object[0])).booleanValue();
            MainActivity.g1 = res;
        } catch (Exception e) {
            MainActivity.g1 = false;
        }
        PackageManager pm = ctx.getPackageManager();
        String packageName = ctx.getPackageName();
        PackageInfo packageInfo = null;
        try {
            packageInfo = pm.getPackageInfo(packageName, 64);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        Signature[] signatures = packageInfo.signatures;
        byte[] cert = signatures[0].toByteArray();
        InputStream input = new ByteArrayInputStream(cert);
        CertificateFactory cf = null;
        try {
            cf = CertificateFactory.getInstance("X509");
        } catch (CertificateException e3) {
            e3.printStackTrace();
        }
        X509Certificate c2 = null;
        try {
            c2 = (X509Certificate) cf.generateCertificate(input);
        } catch (CertificateException e4) {
            e4.printStackTrace();
        }
        String hexString = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            byte[] publicKey = md.digest(c2.getEncoded());
            hexString = FC.th(publicKey);
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (CertificateEncodingException e5) {
            e5.printStackTrace();
        }
        MainActivity.g4 = !hexString.equals(ctx.getString(R.string.s6));
    }
}