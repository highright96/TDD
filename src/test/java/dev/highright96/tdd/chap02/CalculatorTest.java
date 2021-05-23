package dev.highright96.tdd.chap02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void plus(){
        int result = Calculator.plus(1,2);
        Assertions.assertEquals(3,result);
        Assertions.assertEquals(4,Calculator.plus(3,1));
    }

}
