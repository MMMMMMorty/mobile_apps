import java.security.MessageDigest;

public class pincode {
   public static byte[] reverseHexString(String hexString) {
    int length = hexString.length();
    byte[] result = new byte[length / 2];
    
    for (int i = 0; i < length; i += 2) {
        String hexPair = hexString.substring(i, i + 2);
        result[i / 2] = (byte) Integer.parseInt(hexPair, 16);
    }
    
    return result;
    }

    // public static void main(String[] args) {
    //     String hexString = "d04988522ddfed3133cc24fb6924eae9";
    //     byte[] originalBytes = reverseHexString(hexString);
        
    //     // Print the original byte array
    //     for (byte b : originalBytes) {
    //         System.out.print(b + " ");
    //     }
    // }

    public static void main(String[] args) {
        System.out.println("start");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        for (int m = 0; m < 10; m++) {
                            for (int n = 0; n < 10; n++) {
                                String possiblePin = Integer.toString(i) + Integer.toString(j) + Integer.toString(k) + Integer.toString(l) + Integer.toString(m) + Integer.toString(n);
                                if (checkPin(possiblePin)){
                                    System.out.println(possiblePin);
                                    return;
                                }
                            }
                        }
                    }
            
                }
            }
        }
        
    }

    
    public static boolean checkPin(String pin) {
        if (pin.length() != 6) {
            System.out.println(pin);
            return false;
        }
        try {
            byte[] pinBytes = pin.getBytes();
            for (int i = 0; i < 25; i++) {
                for (int j = 0; j < 400; j++) {
                    MessageDigest md = MessageDigest.getInstance("MD5");
                    md.update(pinBytes);
                    byte[] digest = md.digest();
                    pinBytes = (byte[]) digest.clone();
                }
            }
            String hexPinBytes = toHexString(pinBytes);
            return hexPinBytes.equals("d04988522ddfed3133cc24fb6924eae9");
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static String toHexString(byte[] bytes) {
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


}

// -48 73 -120 82 45 -33 -19 49 51 -52 36 -5 105 36 -22 -23 、、//703958