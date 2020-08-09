package HW24_Pow;

public class PowerCalc {
    public static void main(String[] args) {
        System.out.println(pow(3, -3));
    }

    static double pow(double n, int p) {
        double result = 1;
        if (n == 0) {
            return 0;
        }
        if (p == 1) {
            return n;
        }
        if (p == 0) {
            return 1;
        }
        if (p < 0) {
            p = -p;
            n = 1 / n;
        }

        while (p > 1) {
            if (p % 2 != 0) {
                result *= n;
                p--;
            } else {
                result *= (n * n);
                p/=2;
            }
        }
        return result;
    }
}
