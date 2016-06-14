package com.comcast.TaxPerson;

import java.util.Scanner;

/**
 * Created by nithyarahul on 6/10/16.
 */
public class TaxPersonExecutor {
    final static String REGEX = "[0-9]*+([.][0-9]{1,2})?";
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double cost = -1.0;
        String isLuxury = "";
        boolean luxury = false;
        do {
            System.out.println("Enter the price of item as number or floating number with max 2 decimals");
            String inputCost = scanner.nextLine();
            if(isValidNumberInput(inputCost)) {
                cost = Double.parseDouble(inputCost);
            }
        } while (cost == -1.0);
        do {
            System.out.println("Enter 'yes' if the item is a necessity or 'no' if it a luxury ");
            String inputLuxuryStatus = scanner.nextLine();
            if(inputLuxuryStatus.toLowerCase().equals("yes") || inputLuxuryStatus.toLowerCase().equals("no")) {
                if(inputLuxuryStatus.toLowerCase().equals("yes")) {
                    isLuxury = "yes";
                    luxury = true;
                } else {
                    isLuxury = "no";
                    luxury = false;
                }
            }
        } while (isLuxury.equals(""));
        
        Item item = new Item(cost, luxury);
        double finalCost = item.calculateCostAfterTax();
        System.out.println("Cost after taxes: "+ finalCost);
        scanner.close();
    }

    public static boolean isValidNumberInput(String input){
        return input.matches(REGEX);
    }
}
