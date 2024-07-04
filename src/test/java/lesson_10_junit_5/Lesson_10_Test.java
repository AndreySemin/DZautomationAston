package lesson_10_junit_5;


import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import static lesson_10_junit_5.Lesson_10_junit_5.Factorial;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Lesson_10_Test {


    @Test
    void testFactorialZero(){
        assertEquals(BigInteger.valueOf(1),Factorial(0));
    }
    @Test
    void testFactorialOne(){
        assertEquals(BigInteger.valueOf(1),Factorial(1));
    }
    @Test
    public void testFactorialFive(){
        assertEquals(BigInteger.valueOf(120),Factorial(5));
    }
    @Test
    public void testForNegativeNumbers(){
        assertThrows(IllegalAccessError.class,()->Factorial(-1));


    }
}
