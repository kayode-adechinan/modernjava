package com.tips.modernjava.demos;

import java.util.Arrays;
import java.util.List;

interface TaxStrategy {

    public double calculateTax(double income);
}

class PersonalTaxStrategy implements TaxStrategy {

    public PersonalTaxStrategy() { }

    @Override
    public double calculateTax(double income) {

        System.out.println("PersonalTax");

        double tax = income * 0.3;
        return tax;
    }
}

class PersonalTaxPenaltyStrategy implements TaxStrategy {

    public PersonalTaxPenaltyStrategy() { }

    @Override
    public double calculateTax(double income) {

        System.out.println("PersonalTaxWithPenalty");

        double tax = income * 0.4;
        return tax;
    }
}

class PersonalTaxRebateStrategy implements TaxStrategy {

    public PersonalTaxRebateStrategy() { }

    @Override
    public double calculateTax(double income) {

        System.out.println("PersonalTaxWithRebate");

        double tax = income * 0.2;
        return tax;
    }
}



public class TaxManager {


    public void withoutLambda(){
        //Create a List of Tax strategies for different scenarios
        List<TaxStrategy> taxStrategyList =
                Arrays.asList(
                        new PersonalTaxStrategy(),
                        new PersonalTaxPenaltyStrategy(),
                        new PersonalTaxRebateStrategy());

        //Calculate Tax for different scenarios with corresponding strategies
        for (TaxStrategy taxStrategy : taxStrategyList) {
            System.out.println(taxStrategy.calculateTax(30000.0));
        }

    }

    public void withLambda(){

        //Create a List of Tax strategies for different scenarios with inline logic using Lambda
        List<TaxStrategy> taxStrategyList =
                Arrays.asList(
                        (income) -> { System.out.println("PersonalTax"); return 0.30 * income; },
                        (income) -> { System.out.println("PersonalTaxWithPenalty"); return 0.40 * income; },
                        (income) -> { System.out.println("PersonalTaxWithRebate"); return 0.20 * income; }
                );

        //Calculate Tax for different scenarios with corresponding strategies
        taxStrategyList.forEach((strategy) -> System.out.println(strategy.calculateTax(30000.0)));

    }

    public static void main(String[] args) {

        TaxManager manager = new TaxManager();
        manager.withLambda();
        manager.withoutLambda();

    }
}
