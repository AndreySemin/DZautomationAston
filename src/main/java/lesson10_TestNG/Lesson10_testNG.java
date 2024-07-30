package lesson10_TestNG;

import java.math.BigInteger;

public class Lesson10_testNG {
        public static BigInteger Factorial(int f) {
            if (f < 0) {
                throw new IllegalArgumentException("Факториал должен быть больше нуля");

            }
            BigInteger result = BigInteger.ONE;
            for (int i = 1; i <= f; i++)
                result = result.multiply(BigInteger.valueOf(i));
            return result;
        }
}
