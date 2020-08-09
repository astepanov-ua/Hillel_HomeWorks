package HW24_Pow;

public class PowerCalc {
    public static double pow(double n, int p) {
        if (p == 0) {           //n^0=1
            return 1;
        } else if (n == 0) {    //0^p=0
            return 0;
        } else if (p == 1) {    //n^1=n
            return n;
        } else if (p < 0) {     //n^(-p)=(1/n)^p
            p = -p;
            n = 1 / n;
        }

        double result = 1;
        while (p >= 1) {
            if (p % 2 != 0) {
                result *= n;
                p--;
            } else {
                n = n * n;
                p /= 2;
            }
        }
        return result;
    }
}
