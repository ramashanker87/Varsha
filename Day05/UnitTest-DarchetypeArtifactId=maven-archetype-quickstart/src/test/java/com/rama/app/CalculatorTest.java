package com.rama.app;

import junit.framework.TestCase;
import org.junit.Test;


public class CalculatorTest {
    @Test
    public void testAdd(){
        Calculator calc = new Calculator();
        int result= calc.add(2,3);
        assert result == 5;
    }
    @Test
    public void testmultiply(){
        Calculator multiply = new Calculator();
        double result= multiply.mul(10,5);
        assert result == 50;
    }
    @Test
    public void testsubtract(){
        Calculator subtract = new Calculator();
        double result= subtract.sub(8,3);
        assert result == 5;
    }
    @Test
    public void testDivision(){
        Calculator Div = new Calculator();
        double result= Div.Division(2,2);
        assert result == 0;
    }


}