package com.example.demo.finance;
public class SmartScenario extends Scenario {

    double reductionRate;

    public SmartScenario(double reductionRate) {
        super("Careful Saver");
        this.reductionRate = reductionRate;
    }

    @Override
    double adjustExpenses(double baseExpenses) {
        return baseExpenses * (1 - reductionRate / 100.0);
    }
}