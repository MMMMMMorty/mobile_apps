package com.mobisec.stage1;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Base64;
import dalvik.system.DexClassLoader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class LoadImage {
    private static Context context;
    private static String TAG = "STAGE1";
    private static byte[] initVector = {-34, -83, -66, -17, -34, -83, -66, -17, -34, -83, -66, -17, -34, -83, -66, -17};

    private static String getAssetsName() {
        return decryptString("VYsdn556h+cox7bnQV4UsA==");
    }

    private static String getCodeName() {
        return decryptString("SXkAHK1O8Ssd6aCiqtpiAg==");
    }

    private static void setContext(Context ctx) {
        context = ctx;
    }

    public static boolean load(Context ctx, String flag) {
        byte[] xorKey = "weneedtogodeeper".getBytes();
        setContext(ctx);
        AssetManager assetManager = ctx.getAssets();
        try {
            InputStream in = assetManager.open(getAssetsName());
            File outFile = new File(ctx.getCodeCacheDir().getAbsolutePath(), getCodeName());
            OutputStream out = new FileOutputStream(outFile);
            byte[] buffer = new byte[1024];
            while (true) {
                int read = in.read(buffer);
                if (read != -1) {
                    out.write(buffer, 0, read);
                } else {
                    in.close();
                    out.close();
                    decryptApk(outFile.getAbsolutePath(), xorKey);
                    return loadClass(ctx, outFile.getAbsolutePath(), flag);
                }
            }
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean loadClass(Context context2, String path, String flag) {
        File tmpDir = new File(context2.getFilesDir().getAbsolutePath());
        File file = new File(path);
        DexClassLoader classloader = new DexClassLoader(file.getAbsolutePath(), tmpDir.getAbsolutePath(), null, ClassLoader.getSystemClassLoader());
        file.delete();
        File[] ftemp = tmpDir.listFiles();
        for (File f : ftemp) {
            f.delete();
        }
        try {
            Class<?> classToLoad = classloader.loadClass(generateClass());
            Method method = classToLoad.getDeclaredMethod(generateMethod(), String.class);
            boolean res = ((Boolean) method.invoke(classToLoad, flag)).booleanValue();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String generateMethod() {
        return decryptString("zkKQzoRGUwBJurGdAYVuMw==");
    }

    private static String decryptString(String enc) {
        try {
            String[] parts = context.getPackageName().split(Pattern.quote("."));
            String key = "!!!" + parts[0] + parts[1] + "key";
            IvParameterSpec iv = new IvParameterSpec(initVector);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(2, skeySpec, iv);
            byte[] original = cipher.doFinal(Base64.decode(enc.getBytes(), 0));
            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private static String generateClass() {
        return decryptString("4hJIFOEdvGy81kngg5W2mh4ZMYOQVmqX+FqCg8UmFmc=");
    }

    private static void decryptApk(String path, byte[] xorKey) {
        File file = new File(path);
        int size = (int) file.length();
        byte[] bytes = new byte[size];
        byte[] decbytes = new byte[size];
        try {
            BufferedInputStream buf = new BufferedInputStream(new FileInputStream(file));
            buf.read(bytes, 0, bytes.length);
            buf.close();
            for (int i = 0; i < size; i++) {
                decbytes[i] = (byte) (bytes[i] ^ xorKey[i % xorKey.length]);
            }
            File outFile = new File(path);
            FileOutputStream out = new FileOutputStream(outFile, false);
            out.write(decbytes);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}