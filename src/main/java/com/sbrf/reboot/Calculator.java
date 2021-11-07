package com.sbrf.reboot;

/**
 * Class for calculate some method, such as addition, subtraction, multiplication, division, remainder of division, square root, second power
 *
 * @version 1.0
 * @autor Kravchenko Denis
 */
public class Calculator {

    /**
     * @return the value of @param x + @param y
     */
    public static long getAddition(long x, long y) {
        return x + y;
    }

    /**
     * @return the value of @param x - @param y
     */
    public static long getSubtraction(long x, long y) {
        return x - y;
    }

    /**
     * @return the value of @param x * @param y
     */
    public static long getMultiplication(long x, long y) {
        return x * y;
    }

    /**
     * @return the value of @param x div @param y
     */
    public static long getDivision(long x, long y) {
        return Math.floorDiv(x, y);
    }

    /**
     * @return remainder of the division
     */
    public static long getRemainderOfDivision(long x, long y) {
        return Math.floorMod(x, y);
    }

    /**
     * @return square root of @param sqrt
     */
    public static double getSqrt(double sqrt) {
        return Math.sqrt(sqrt);
    }

    /**
     * @return second power of @param x
     */
    public static double getPow(double x) {
        return Math.pow(x, 2);
    }
}
