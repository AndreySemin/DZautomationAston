package lesson10_test;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.math.BigInteger;

import static lesson10_TestNG.Lesson10_testNG.Factorial;
@Test
public class lesson10_test {
    public void testFactorialZero(){
        Assert. assertEquals(BigInteger.valueOf(1),Factorial(0));
    }
    public void testFactorialOne(){
        Assert.assertEquals(BigInteger.valueOf(1),Factorial(1));
    }
    public void testFactorialFive(){
        Assert.assertEquals(BigInteger.valueOf(120),Factorial(5));
    }
    public void testForNegativeNumbers(){
        Assert.assertThrows(IllegalAccessError.class,()->Factorial(-1));
    }






}
