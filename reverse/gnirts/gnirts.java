import java.security.MessageDigest;
import java.util.Base64;

public class gnirts {

    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    static String t1 = "6e9a4d130a9b316e9201238844dd5124";
    static String t2 = "7c51a5e6ea3214af970a86df89793b19";
    static String t3 = "e5f20324ae520a11a86c7602e29ecbb8";
    static String t4 = "1885eca5a40bc32d5e1bca61fcd308a5";
    static String t5 = "da5062d64347e5e020c5419cebd149a2";
    static String t6 = "1c4d1410a4071880411f02ff46370e46b464ab2f87e8a487a09e13040d64e396";


    public static void main(String[] args) {
        String result = foo();
        System.out.println("Decoded String: " + result); // Decoded String: -
        String sum = "";
        
        outerLoop:
        for (char possibleChar = 'a'; possibleChar <= 'z'; possibleChar++) {
            for (char possibleChar2 = 'a'; possibleChar2 <= 'z'; possibleChar2++) {
                for (char possibleChar3 = 'a'; possibleChar3 <= 'z'; possibleChar3++) {
                    for (char possibleChar4 = 'a'; possibleChar4 <= 'z'; possibleChar4++) {
                        for (char possibleChar5 = 'a'; possibleChar5 <= 'z'; possibleChar5++) {
                            String test = String.valueOf(possibleChar) + String.valueOf(possibleChar2) + String.valueOf(possibleChar3) + String.valueOf(possibleChar4) + String.valueOf(possibleChar5);
                            if(dh(gs("xwe", "53P"), test).equals(t1)){
                                System.out.println("1");
                                System.out.println(test);
                                sum = sum + test + "-";
                                break outerLoop;
                            }
                        }
                    }
                }
            }
        }

        outerLoop1:
        for (char possibleChar0 = '0'; possibleChar0 <= '9'; possibleChar0++) {
            for (char possibleChar1 = '0'; possibleChar1 <= '9'; possibleChar1++) {
                for (char possibleChar2 = '0'; possibleChar2 <= '9'; possibleChar2++) {
                    for (char possibleChar3 = '0'; possibleChar3 <= '9'; possibleChar3++) {
                        for (char possibleChar4 = '0'; possibleChar4 <= '9'; possibleChar4++) {
                            for (char possibleChar5 = '0'; possibleChar5 <= '9'; possibleChar5++) {
                                for (char possibleChar6 = '0'; possibleChar6 <= '9'; possibleChar6++) {
                                    String test = String.valueOf(possibleChar0) +
                                                  String.valueOf(possibleChar1) +
                                                  String.valueOf(possibleChar2) +
                                                  String.valueOf(possibleChar3) +
                                                  String.valueOf(possibleChar4) +
                                                  String.valueOf(possibleChar5) +
                                                  String.valueOf(possibleChar6);
        
                                    if (dh(gs("uyt", "8=A"), test).equals(t2)) {
                                        System.out.println("2");
                                        System.out.println(test);
                                        sum = sum + test + "-";

                                        break outerLoop1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        outerLoop2:
        for (char possibleChar = 'A'; possibleChar <= 'Z'; possibleChar++) {
            for (char possibleChar2 = 'A'; possibleChar2 <= 'Z'; possibleChar2++) {
                for (char possibleChar3 = 'A'; possibleChar3 <= 'Z'; possibleChar3++) {
                    for (char possibleChar4 = 'A'; possibleChar4 <= 'Z'; possibleChar4++) {
                        for (char possibleChar5 = 'A'; possibleChar5 <= 'Z'; possibleChar5++) {
                            String test = String.valueOf(possibleChar) +
                                          String.valueOf(possibleChar2) +
                                          String.valueOf(possibleChar3) +
                                          String.valueOf(possibleChar4) +
                                          String.valueOf(possibleChar5);
        
                            if (dh(gs("42s", "yvF"), test).equals(t3)) {
                                System.out.println("3");
                                System.out.println(test);
                                sum = sum + test + "-";
                                break outerLoop2;
                                

                            }
                        }
                    }
                }
            }
        }

        String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        outerLoop3:
        for (char possibleChar: characters.toCharArray()) {
            for (char possibleChar2 : characters.toCharArray()) {
                for (char possibleChar3 : characters.toCharArray()) {
                    for (char possibleChar4 : characters.toCharArray()) {
                        String test = String.valueOf(possibleChar) + String.valueOf(possibleChar2) + String.valueOf(possibleChar3) + String.valueOf(possibleChar4);
                        
                        if (dh(gs("42s", "yvF"), test).equals(t4)) {
                            System.out.println("4");
                            System.out.println(test);
                            sum = sum + test + "-";
                            break outerLoop3;
                        }
                    }
                }
            }
        }
        
        outerLoop4:
        for (char possibleChar = '0'; possibleChar <= '9'; possibleChar++) {
            for (char possibleChar2 = '0'; possibleChar2 <= '9'; possibleChar2++) {
                for (char possibleChar3 = '0'; possibleChar3 <= '9'; possibleChar3++) {
                    for (char possibleChar4 = '0'; possibleChar4 <= '9'; possibleChar4++) {
                        for (char possibleChar5 = '0'; possibleChar5 <= '9'; possibleChar5++) {
                            for (char possibleChar6 = '0'; possibleChar6 <= '9'; possibleChar6++) {
                                for (char possibleChar7 = '0'; possibleChar7 <= '9'; possibleChar7++) {
                                    String test = String.valueOf(possibleChar) +
                                                String.valueOf(possibleChar2) +
                                                String.valueOf(possibleChar3) +
                                                String.valueOf(possibleChar4) +
                                                String.valueOf(possibleChar5) +
                                                String.valueOf(possibleChar6) +
                                                String.valueOf(possibleChar7);
            
                                    if (dh(gs("p0X", "=tm"), test).equals(t5)) {
                                        System.out.println("5");
                                        System.out.println(test);
                                        sum = sum + test;
                                        break outerLoop4;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("the core part is " + sum);
    }

    public static String foo() {
        String s = "Vm0wd2QyVkZNVWRYV0docFVtMVNWVmx0ZEhkVlZscDBUVlpPVmsxWGVIbFdiVFZyVm0xS1IyTkliRmRXTTFKTVZsVmFWMVpWTVVWaGVqQTk=";
        for (int i = 0; i < 10; i++) {
            s = new String(Base64.getDecoder().decode(s));
        }
        return s;
    }

    private static String dh(String hash, String s) {
        try {
            MessageDigest md = MessageDigest.getInstance(hash);
            md.update(s.getBytes());
            byte[] digest = md.digest();
            return toHexString(digest);
        } catch (Exception e) {
            return null;
        }
    }

    private static String toHexString(byte[] bytes) {
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

    private static String gs(String a, String b) {
        String s = "";
        for (int i = 0; i < a.length(); i++) {
            s = s + Character.toString((char) (a.charAt(i) ^ b.charAt(i % b.length())));
        }
        return s;
    }


}

// me() equals