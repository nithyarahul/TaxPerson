package com.comcast.TaxPerson;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Unit test for Item tax calculator
 */
public class ItemTest {

    @Test
    public void testLuxuryItemTaxCalculation(){
        Item luxuryItem = new Item(100.0, true);
        double finalCost = luxuryItem.calculateCostAfterTax();
        double expectedValue = 109.0;
        Assert.assertEquals(expectedValue, finalCost);
    }

    @Test
    public void testNecesityItemTaxCalculation(){
        Item necessityItem = new Item(100.0, false);
        double finalCost = necessityItem.calculateCostAfterTax();
        double expectedValue = 101.0;
        Assert.assertEquals(expectedValue, finalCost);
    }

    @Test(expected=RuntimeException.class)
    public void testRunTimeExceptionOnNegativeValue(){
        Item item = new Item(-100.0, false);
    }

    @Test(expected=RuntimeException.class)
    public void testRunTimeExceptionOnNegativeValue2(){
        Item item = new Item(100.0, false);
        item.setBaseCost(-100.0);
    }

    @Test
    public void testRoundToPennies() {
    Item firstItem = new Item(10.00, false);
    Item secondItem = new Item(10.00, false);
    Assert.assertTrue(firstItem.roundToPennies(10.00) == secondItem.roundToPennies(10.00));
    }

    @Test
    public void testRoundToPenniesDifferentValues() {
    Item firstItem = new Item(10.004, true);
    Item secondItem = new Item(10.005, true);
    Assert.assertFalse(firstItem.roundToPennies(10.004) == secondItem.roundToPennies(10.005));
    }
}