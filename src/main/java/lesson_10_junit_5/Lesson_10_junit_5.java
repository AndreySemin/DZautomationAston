package lesson_10_junit_5;

import java.math.BigInteger;

public class Lesson_10_junit_5 {
    public static BigInteger Factorial(int f) {
        if (f < 0) {
            throw new IllegalArgumentException("факториал должен быть больше нуля");

        }
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= f; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

}
