package HW22_MD5_Brote_Force_Decrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import javax.xml.bind.DatatypeConverter;

public class MainDemo {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String result = "";
        String inputHash;
        inputHash = "d701fde59d74f76803087b6632186caf";
        result = decryptMD5Hash_WeKnowResultIs4LetterWord(inputHash);
        System.out.println("First result is: " + result);


        inputHash = "5ebe2294ecd0e0f08eab7690d2a6ee69";
        for (int i = 1; i < 15; i++) {
            BruteForce bruteForce = new BruteForce('a', 'z', i);
            String next = bruteForce.getNextString();
            while (next != null) {
                if (decryptMD5Hash(next, inputHash) != null) {
                    System.out.println(decryptMD5Hash(next, inputHash));
                    System.out.println(i);
                    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                    Date date = new Date(System.currentTimeMillis());
                    System.out.println(formatter.format(date));
                    return;
                }
                next = bruteForce.getNextString();
            }
            System.out.println(i);
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            System.out.println(formatter.format(date));
         }
    }

    public static String decryptMD5Hash(String toCheck, String hash) throws NoSuchAlgorithmException {
        return (check(toCheck, hash)) ? toCheck : null;
    }

    public static String decryptMD5Hash_WeKnowResultIs4LetterWord(String hash) throws NoSuchAlgorithmException {
        String wordToCheck = "";
        for (int i = 97; i < 123; i++) {
            for (int j = 97; j < 123; j++) {
                for (int k = 97; k < 123; k++) {
                    for (int l = 97; l < 123; l++) {
                        wordToCheck += (char) i;
                        wordToCheck += (char) j;
                        wordToCheck += (char) k;
                        wordToCheck += (char) l;
                        if (check(wordToCheck, hash)) {
                            return wordToCheck;
                        }
                        wordToCheck = "";
                    }
                }
            }
        }
        return "not found";
    }

    private static boolean check(String wordToCheck, String hash) throws NoSuchAlgorithmException {
        MessageDigest md;
        md = MessageDigest.getInstance("MD5");
        md.update(wordToCheck.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        return (Objects.equals(hash.toUpperCase(), myHash));
    }
}

