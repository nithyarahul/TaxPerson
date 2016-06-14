package com.comcast.TaxPerson;

import junit.framework.Assert;

import org.junit.Test;

public class TaxPersonExecutorTest {
    @Test
    public void testIsValidNumberInput1() {
        String input = "100.00";
        Assert.assertTrue(TaxPersonExecutor.isValidNumberInput(input));
    }
    
    @Test
    public void testIsValidNumberInput2() {
        String input = "100.0";
        Assert.assertTrue(TaxPersonExecutor.isValidNumberInput(input));
    }

    @Test
    public void testIsValidNumberInput3() {
        String input = "100";
        Assert.assertTrue(TaxPersonExecutor.isValidNumberInput(input));
    }
    
    @Test
    public void testIsValidNumberInput4() {
        String input = "100.";
        Assert.assertFalse(TaxPersonExecutor.isValidNumberInput(input));
    }
    
    @Test
    public void testIsValidNumberInput5() {
        String input = "absb100";
        Assert.assertFalse(TaxPersonExecutor.isValidNumberInput(input));
    }
    
    @Test
    public void testIsValidNumberInput6() {
        String input = "100.00.34";
        Assert.assertFalse(TaxPersonExecutor.isValidNumberInput(input));
    }
    
    @Test
    public void testIsValidNumberInput7() {
        String input = "100.1233123";
        Assert.assertFalse(TaxPersonExecutor.isValidNumberInput(input));
    }

    @Test
    public void testIsValidNumberInput8() {
        String input = "-100";
        Assert.assertFalse(TaxPersonExecutor.isValidNumberInput(input));
    }
}
