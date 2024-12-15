
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.util.Base64;

import ups.streamer;


// .\jadx-gui-1.4.7.exe --comments-level debug 
public class upos {
    private static byte[] initVector = {-34, -83, -66, -17, -34, -83, -66, -17, -34, -83, -66, -17, -34, -83, -66, -17};

    // MOBISEC{this_is_           really_                              upos}
    public static void main(String[] args) throws Exception {
        // streamer lfsr = new streamer("01101000010", 8);
        // System.out.println("Testing step()");
        // for (int i = 0; i < 10; i++) {
        //     int bit = lfsr.step();
        //     PrintStream printStream = System.out;
        //     printStream.println(lfsr + " " + bit);
        // }
        // streamer lfsr2 = new streamer("01101000010", 8);
        // System.out.println("\nTesting generate()");
        // for (int i2 = 0; i2 < 10; i2++) {
        //     int r = lfsr2.generate(5);
        //     PrintStream printStream2 = System.out;
        //     printStream2.println(lfsr2 + " " + r);
        // }

        long[][] m = (long[][]) Array.newInstance(long.class, 256, 256);

        // String flag = "MOBISEC{this_is_";
        // String flagEnd = "upos}";

        // // L49f
        // String hash = "4193d9b72a5c4805e9a5cc739f8a8fc23b2890e13b83bb887d96f86c30654a12";

        upos instance = new upos();
        instance.lm(m);

        // System.out.println(upos.ip(0));

        // String r12 = "";


        // String encryptedString = "bHM=";
        // String decryptedString = instance.dec(encryptedString);
        // r12 = decryptedString + " ";

        // System.out.println("Encrypted String: " + encryptedString);
        // System.out.println("Decrypted String: " + decryptedString);

        // encryptedString = "L3Byb2M=";
        // decryptedString = instance.dec(encryptedString);

        // System.out.println("Encrypted String: " + encryptedString);
        // System.out.println("Decrypted String: " + decryptedString);

        // r12 = r12 + decryptedString;

        // String r8 = instance.ec(r12);
        // System.out.println("String: " + r8);

        // encryptedString = "Y2F0";
        // decryptedString = instance.dec(encryptedString);

        // System.out.println("Encrypted String: " + encryptedString);
        // System.out.println("Decrypted String: " + decryptedString);

        // encryptedString = "ZnJpZGE=";
        // decryptedString = instance.dec(encryptedString);

        // System.out.println("Encrypted String: " + encryptedString);
        // System.out.println("Decrypted String: " + decryptedString);

        // encryptedString = "Y29tLmFuZHJvaWQudmVuZGluZw==";
        // decryptedString = instance.dec(encryptedString);

        // System.out.println("Encrypted String: " + encryptedString);
        // System.out.println("Decrypted String: " + decryptedString);

        // encryptedString = "YW5kcm9pZC5vcy5EZWJ1Zw==";
        // decryptedString = instance.dec(encryptedString);

        // System.out.println("Encrypted String: " + encryptedString);
        // System.out.println("Decrypted String: " + decryptedString);

        // encryptedString = "aXNEZWJ1Z2dlckNvbm5lY3RlZA==";
        // decryptedString = instance.dec(encryptedString);

        // System.out.println("Encrypted String: " + encryptedString);
        // System.out.println("Decrypted String: " + decryptedString);

        // String out = instance.r("018a94a01edcfd1c8121f56dd36a412e62b3dd8");
        // System.out.println("out String: " + out);

        streamer s = new streamer();

        String core = "this_is";



        int idx16 = 100; //fs[100] - fs[129] true
        for (int i2 = 0; i2 < 1; i2++) {
            
            String curr = Character.toString(core.charAt(i2 * 2)) + Character.toString(core.charAt((i2 * 2) + 1));
            if (ip(i2)) { // starts with 14
                for (int j = 0; j < i2; j++) {
                    s.step();
                }
            }
            int j2 = s.g2();
            int mX = j2 & 255;
            int mY = (s.g2() & 65280) >> 8;
            if (sq(r(curr)) == m[mX][mY]) {
                System.out.println("correct String" + i2 + curr);
            } else {
                idx16++;
            }
        }

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

    
    public static String r(String s) {
        String out = "";
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

    public static boolean ip(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static long sq(String a) {
        int n = (a.charAt(0) + (a.charAt(1) << '\b')) & 65535;
        long n2 = (long) Math.pow(n, 2.0d);
        return n2;
    }

    public static String th(byte[] bytes) { // to Hex
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

    private void lm(long[][] matrix) throws Exception { //load me
        BufferedReader reader = null;
        try {
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream("lotto.dat")));
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

    public static String dec(String x) {
        return new String(Base64.getDecoder().decode(x));
    }
}

