package com.tips.modernjava.demos;


import java.util.Arrays;
import java.util.List;

interface TaxStrategy {

    public double calculateTax(double income);
}






public class TaxManager {


    public void withLambda() {

        //Create a List of Tax strategies for different scenarios with inline logic using Lambda
        List<TaxStrategy> taxStrategyList =
                Arrays.asList(
                        (income) -> {
                            System.out.println("PersonalTax");
                            return 0.30 * income;
                        },
                        (income) -> {
                            System.out.println("PersonalTaxWithPenalty");
                            return 0.40 * income;
                        },
                        (income) -> {
                            System.out.println("PersonalTaxWithRebate");
                            return 0.20 * income;
                        }
                );

        //Calculate Tax for different scenarios with corresponding strategies
        taxStrategyList.forEach((strategy) -> System.out.println(strategy.calculateTax(30000.0)));

    }


    public static void main(String[] args) {




    }
}
