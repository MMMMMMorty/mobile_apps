# Solution

## Description of the problem

Give me the PIN, I'll give you the flag.

## Solution

First, I check the ```getFlag``` function in ```Mainactivity```. Accroding to it, I knew that I need to figure out the correct pincode, and get the key from this url.

```
public String getFlag(String pin) {
        String url = "https://challs.reyammer.io/pincode/" + pin;
        try {
            String ans = getUrlContent(url);
            return ans;
        } catch (FileNotFoundException e) {
            return "Too many requests, slow down. You can do at most 10 requests per minute.";
        } catch (Exception e2) {
            String ans2 = "Exception: " + Log.getStackTraceString(e2);
            Log.e("MOBISEC", "Exception: " + Log.getStackTraceString(e2));
            return ans2;
        }
    }
```

Then I found out the pincode hash string needs to be equal to ```d04988522ddfed3133cc24fb6924eae9```, the length of pincode is 6. And wrote a program to brute force the pincode.

Here is my code

```
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
```

Through this code, I got the correct pincode and then I get the correct flag.


## Optional Feedback

Brute force is one important tool in security reversing.
