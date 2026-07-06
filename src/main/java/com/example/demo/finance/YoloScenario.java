package com.example.demo.finance;
public class YoloScenario extends Scenario {

    double increaseRate;

    public YoloScenario(double increaseRate) {
        super("High Spending Lifestyle");
        this.increaseRate = increaseRate;
    }

    @Override
    double adjustExpenses(double baseExpenses) {
        return baseExpenses * (1 + increaseRate / 100.0);
    }
}