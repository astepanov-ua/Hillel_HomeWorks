package HW22_MD5_Brote_Force_Decrypt;

import java.util.Arrays;

public class BruteForce {
    private int min;
    private int max;
    private int len;
    public int[] chars;

    public BruteForce(int min, int max, int len) {
        this.min = min;
        this.max = max;
        this.len = len;
        chars = new int[len + 1];
        Arrays.fill(chars, 1, len + 1, min);
    }

    private void increment() {
        while (chars[0] == 0) {
            for (int i = len; i >= 0; i--) {
                if (chars[i] < max) {
                    chars[i]++;
                    return;
                } else {
                    chars[i] = min;
                }
            }
        }
    }

    public String getNextString() {
        if (chars[0] != 0) {
            return null;
        }
        String result = "";
        for (int i = 1; i <  chars.length; i++) {
            result += (char) chars[i];
        }
        increment();
        return result;
    }


}
