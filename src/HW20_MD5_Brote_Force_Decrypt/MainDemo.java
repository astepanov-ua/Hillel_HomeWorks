package HW20_MD5_Brote_Force_Decrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import javax.xml.bind.DatatypeConverter;

public class MainDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest md;
        md = MessageDigest.getInstance("MD5");
        md.update("very".getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        System.out.println(Objects.equals("f016441d00c16c9b912d05e9d81d894d".toUpperCase(), myHash));
    }
}
