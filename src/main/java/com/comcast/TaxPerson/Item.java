package com.comcast.TaxPerson;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by nithyarahul on 6/10/16.
 */

public class Item {
    //e.g. for necessity items if x is the price and 1% is the tax.
    //then (x + 1%) = (x * 1.01)
    public static final double LUXURY_ITEM_TAX_MULTIPLIER = 1.09;
    public static final double NECESSITIES_TAX_MULTIPLIER = 1.01;

    private double baseCost;
    private boolean isLuxury;

    /**
     * Constructor with params
     */
    public Item(double cost, Boolean isLuxury) {
        if(cost>0)
            this.baseCost = cost;
        else
            throw new RuntimeException("Cost cannot be less than zero");
        this.isLuxury = isLuxury;
    }

    /**
     * getter for baseCost
     * 
     * @return base cost
     */
    public double getBaseCost() {
        return baseCost;
    }

    /**
     * setter for baseCost
     * 
     * @param baseCost
     */
    public void setBaseCost(double cost) {
        if(cost>0)
            this.baseCost = cost;
        else
            throw new RuntimeException("Cost cannot be less than zero");
    }

    /**
     * Returns isLuxury
     * 
     * @return
     */
    public boolean getIsLuxury() {
        return isLuxury;
    }

    /**
     * Sets isLuxury
     * 
     * @param isLuxury
     */
    public void setIsLuxury(boolean isLuxury) {
        this.isLuxury = isLuxury;
    }

    /*
     * Calculates the cost after tax
     */
    public double calculateCostAfterTax() {
        if (isLuxury) {
            if (baseCost * LUXURY_ITEM_TAX_MULTIPLIER >= Double.MAX_VALUE) {
                throw new RuntimeException(
                        "Final Cost greater than max supported value");
            }
            return this.roundToPennies((baseCost * LUXURY_ITEM_TAX_MULTIPLIER));
        }
        if (baseCost * LUXURY_ITEM_TAX_MULTIPLIER >= Double.MAX_VALUE) {
            throw new RuntimeException("Value greater than max supported value");
        }
        return this.roundToPennies((baseCost * NECESSITIES_TAX_MULTIPLIER));
    }

    /**
     * Rounds to 2 places in decimal.
     * 
     * @param input
     * @return
     */
    public double roundToPennies(double input) {
        BigDecimal value = new BigDecimal(input);
        return value.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

}
