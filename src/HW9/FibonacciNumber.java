package HW9;

import java.math.BigInteger;

public class FibonacciNumber {
    public static BigInteger getBySequenceNumber(int sequenceNumber) {
        BigInteger previous = new BigInteger("0");
        BigInteger next = new BigInteger("1");
        BigInteger result = new BigInteger("0");
        if (sequenceNumber < 2) {
            return BigInteger.valueOf(0);
        } else if (sequenceNumber < 3) {
            return BigInteger.valueOf(1);
        } else {
            for (int i = 2; i < sequenceNumber; i++) {
                result = previous.add(next);
                previous = next;
                next = result;
            }
            return result;
        }
    }
}
