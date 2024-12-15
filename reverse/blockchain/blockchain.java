import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

public class blockchain {


    public static void main(String[] args) {
        String hexString = "0eef68c5ef95b67428c178f045e6fc8389b36a67bbbd800148f7c285f938a24e696ee2925e12ecf7c11f35a345a2a142639fe87ab2dd7530b29db87ca71ffda2af558131d7da615b6966fb0360d5823b79c26608772580bf14558e6b7500183ed7dfd41dbb5686ea92111667fd1eff9cec8dc29f0cfe01e092607da9f7c2602f5463a361ce5c83922cb6c3f5b872dcc088eb85df80503c92232bf03feed304d669ddd5ed1992a26674ecf2513ab25c20f95a5db49fdf6167fda3465a74e0418b2ea99eb2673d4c7e1ff7c4921c4e2d7b";  // Replace with your hex string
        byte[] originalBytes = fromHex(hexString);
        System.out.println((originalBytes));

        String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";



        for (char c : characters.toCharArray()) {
            String keyStr = "" + c;
            try {

                byte[] fullKey = keyStr.getBytes();
                byte[] digest = hash(fullKey);
                byte[] key = {digest[0], digest[digest.length / 2], digest[digest.length - 1]};
                byte[] currKey = hash(key);

                byte[][] intermediateKeys = new byte[10][];

                for (int i = 0; i < 10; i++) {
                    intermediateKeys[i] = currKey.clone(); // Record the current key
                    currKey = hash(currKey); // Hash the current key for the next iteration
                }

                byte[] one= decrypt(originalBytes, intermediateKeys[9]);
                byte[] two= decrypt(one, intermediateKeys[8]);
                byte[] three= decrypt(two, intermediateKeys[7]);
                byte[] four= decrypt(three, intermediateKeys[6]);
                byte[] five= decrypt(four, intermediateKeys[5]);
                byte[] six= decrypt(five, intermediateKeys[4]);
                byte[] seven= decrypt(six, intermediateKeys[3]);
                byte[] eight= decrypt(seven, intermediateKeys[2]);
                byte[] nigh= decrypt(eight, intermediateKeys[1]);
                byte[] ten= decrypt(nigh, intermediateKeys[0]);

                if (ten.toString().startsWith("MOBISEC{") && ten.toString().endsWith("}")){
                    System.out.println(ten.toString());
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // for (char a : characters.toCharArray()) {
        //     for (char b : characters.toCharArray()) {
        //         for (char c : characters.toCharArray()) {
        //             String keyStr = "" + a + b + c;
        //         }
        //     }
        // }
    }

    


    public static byte[] fromHex(String hexString) {
        int len = hexString.length();
        byte[] result = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            result[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                                   + Character.digit(hexString.charAt(i + 1), 16));
        }
        return result;
    }


    public static byte[] decrypt(byte[] in, byte[] key) throws Exception {
        Key aesKey = new SecretKeySpec(key, "AES");
        Cipher decryptCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        decryptCipher.init(Cipher.DECRYPT_MODE, aesKey);
        // byte[] buffer = new byte[1024]; // You can adjust the buffer size as needed
        return decryptCipher.doFinal(in);
    }

    public static byte[] hash(byte[] in) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(in);
        return md.digest();
    }



}