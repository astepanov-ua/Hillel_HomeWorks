package HW24_Pow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PowerCalcTest {
    @Test
    void zeroPow() {
        assertTrue(PowerCalc.pow(123, 0) == 1);
        assertTrue(PowerCalc.pow(-13, 0) == 1);
    }

    @Test
    void onePow() {
        assertTrue(PowerCalc.pow(123, 1) == 123);
        assertTrue(PowerCalc.pow(0, 1) == 0);
        assertTrue(PowerCalc.pow(-12.3, 1) == -12.3);
    }

    @Test
    void zeroNumber() {
        assertTrue(PowerCalc.pow(0, 0) == 1); //important case!
        assertTrue(PowerCalc.pow(0, 11) == 0);
        assertTrue(PowerCalc.pow(0, -11) == 0);
    }

    @Test
    void differentCombinations() {
        assertTrue(PowerCalc.pow(2, 8) == 256);
        assertTrue(PowerCalc.pow(3, 9) == 19683);
        assertTrue(PowerCalc.pow(0.5, 3) == 0.125);
        assertTrue(PowerCalc.pow(4, -2) == 0.125 / 2);
        assertTrue(PowerCalc.pow(0.2, -5) == 3125);
    }
}