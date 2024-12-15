# Solution

## Description of the problem

The flag is hidden in another file.

## Solution

1. I wrote a code to decrypt all the encrypted hardcoded string in the apk
   ```
        System.out.println("Encrypted String: " + encryptedString);
        System.out.println("Decrypted String: " + decryptedString);
        encryptedString = "QLrdlqkhOkxIe5FEfpCLWw==";
        decryptedString = instance.ds(encryptedString);
        System.out.println("Encrypted String: " + encryptedString);
        System.out.println("Decrypted String: " + decryptedString);
        encryptedString = "ca9O9YbCZ/+vIYUvxPQUHA4SgyL/m3cwlvVZ4ArkBFQ=";
        decryptedString = instance.ds(encryptedString);
        System.out.println("Encrypted String: " + encryptedString);
        System.out.println("Decrypted String: " + decryptedString);
        encryptedString = "6RSjLOfRkvb/qXa34Y7cOQ==";
        decryptedString = instance.ds(encryptedString);
        System.out.println("Encrypted String: " + encryptedString);
        System.out.println("Decrypted String: " + decryptedString);

        // String path = dc("https://challs.reyammer.io/loadme/stage1.apk");
        // System.out.println(path);
        // da(path);
        // com.mobisec.stage1.LoadImag.load

        encryptedString = "VYsdn556h+cox7bnQV4UsA==";
        decryptedString = instance.decryptString(encryptedString);
        System.out.println("Encrypted String: " + encryptedString);
        System.out.println("Decrypted String: " + decryptedString);

        encryptedString = "SXkAHK1O8Ssd6aCiqtpiAg==";
        decryptedString = instance.decryptString(encryptedString);
        System.out.println("Encrypted String: " + encryptedString);
        System.out.println("Decrypted String: " + decryptedString);
    
          
        encryptedString = "4hJIFOEdvGy81kngg5W2mh4ZMYOQVmqX+FqCg8UmFmc=";
        decryptedString = instance.decryptString(encryptedString);
        System.out.println("Encrypted String: " + encryptedString);
        System.out.println("Decrypted String: " + decryptedString);
        
        encryptedString = "zkKQzoRGUwBJurGdAYVuMw==";
        decryptedString = instance.decryptString(encryptedString);
        System.out.println("Encrypted String: " + encryptedString);
        System.out.println("Decrypted String: " + decryptedString);
    ```

In here, through the download link, I got the ```stage1.apk```

2. I tried to open the it with jdax, and it failed. I double checked the code and noticed in the ```da``` function, it decrypted the ```stage1.apk```. So I used this function to get ```new_stage1.apk```, which can be opened in jdax.

    ```
       private static void da(String path) {
        byte[] xorKey = "com.mobisec.dexclassloader".getBytes();
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
            File outFile = new File("new_stage1.apk");
            FileOutputStream out = new FileOutputStream(outFile, false);
            out.write(decbytes);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    ```

3. I moved on to analysis ```new_stage1.apk```. Here I found out that this apk tried to load the image ```logo.png``` and then decrypted it to ```logo.apk```. And call the ```check``` function in the ```com.mobisec.stage2.Check``` Class. So I wrote down the code to de the same, and got ```logo.apk```.

    ```
    import java.io.BufferedInputStream;
   import java.io.File;
   import java.io.FileInputStream;
   import java.io.FileOutputStream;
   import java.io.InputStream;
   import java.io.OutputStream;
   import java.lang.reflect.Method;
   import java.net.HttpURLConnection;
   import java.net.URL;
   import java.util.Base64;
   import java.util.regex.Pattern;
   import javax.crypto.Cipher;
   import javax.crypto.spec.IvParameterSpec;
   import javax.crypto.spec.SecretKeySpec;
   import javax.naming.Context;

   public class loadme {
       private static byte[] initVector = {-34, -83, -66, -17, -34, -83, -66, -17, -34, -83, -66, -17, -34, -83, -66, -17};

       public static void main(String[] args) {
           loadme instance = new loadme();

           loadme.load();
       }

       public static boolean load() {
           byte[] xorKey = "weneedtogodeeper".getBytes();
           try {
               InputStream in = new FileInputStream("logo.png");
               File outFile = new File("./", "logo.dex");
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
                       return true;
                   }
               }
           } catch (Exception e) {
               return false;
           }
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

       private static String decryptString(String enc) {
           try {
               String[] parts = "com.mobisec.dexclassloader".split(Pattern.quote("."));
               String key = "!!!" + parts[0] + parts[1] + "key";
               IvParameterSpec iv = new IvParameterSpec(initVector);
               SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
               Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
               cipher.init(2, skeySpec, iv);
               byte[] original = cipher.doFinal(Base64.getDecoder().decode(enc.getBytes()));
               return new String(original);
           } catch (Exception ex) {
               ex.printStackTrace();
               return null;
           }
       }

       private String ds(String enc) {
           try {
               String key = "mobisec" + "com" + "key!!!";
               IvParameterSpec iv = new IvParameterSpec(initVector);
               SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
               Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
               cipher.init(2, skeySpec, iv);
               byte[] original = cipher.doFinal(Base64.getDecoder().decode(enc.getBytes()));
               return new String(original);
           } catch (Exception ex) {
               ex.printStackTrace();
               return null;
           }
       }
    }

    ```

4. I put ```new_stage1.apk``` to jdax, checked the ```check``` function, and got the flag, which is ```"MOBISEC{dynamic_code_loading_can_make_everything_tricky_eh?}"```

## Optional Feedback

Three stages are difficult.