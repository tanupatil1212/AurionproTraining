package com.aurionpro.test;

import com.aurionpro.model.DBLogger;
import com.aurionpro.model.TaxCalculator;

public class TaxCalculatorTest {
    public static void main(String[] args) {
        DBLogger dbLogger = new DBLogger();

        TaxCalculator t1 = new TaxCalculator(dbLogger);
        int tax1 = t1.calculateTax(100, 10);
        System.out.println("Tax 1: " + tax1);

        TaxCalculator t2 = new TaxCalculator(dbLogger);
        int tax2 = t2.calculateTax(2000, 0);
        System.out.println("Tax 2: " + tax2);
    }
}

