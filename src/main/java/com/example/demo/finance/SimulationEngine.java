package com.example.demo.finance;
public class SimulationEngine {

    public double simulate(User user, Scenario scenario, double inflationRate) {

        double total = 0;

        double currentExpenses = scenario.adjustExpenses(user.monthlyExpenses);

        // Convert annual percentage to monthly decimal
        double monthlyRate = user.investmentRate / 100.0 / 12.0;

        for (int i = 0; i < user.totalMonths; i++) {

            double monthlySavings = user.monthlyIncome - currentExpenses;

            if (monthlySavings < 0) {
                monthlySavings = 0;
            }

            if (monthlyRate <= 0) {
                total += monthlySavings;
            } else {
                total = (total + monthlySavings) * (1 + monthlyRate);
            }

            // Increase expenses once every year due to inflation
            if ((i + 1) % 12 == 0) {
                currentExpenses *= (1 + inflationRate / 100.0);
            }
        }

        return total;
    }

    public double adjustForInflation(double amount, int totalMonths, double inflationRate) {

        double years = totalMonths / 12.0;

        return amount / Math.pow(1 + inflationRate / 100.0, years);
    }

    public int monthsToReachGoal(User user,
                                 Scenario scenario,
                                 double goal,
                                 double inflationRate) {

        double total = 0;

        double currentExpenses = scenario.adjustExpenses(user.monthlyExpenses);

        double monthlyRate = user.investmentRate / 100.0 / 12.0;

        int months = 0;

        while (total < goal) {

            double monthlySavings = user.monthlyIncome - currentExpenses;

            if (monthlySavings < 0) {
                monthlySavings = 0;
            }

            if (monthlyRate <= 0) {
                total += monthlySavings;
            } else {
                total = (total + monthlySavings) * (1 + monthlyRate);
            }

            months++;

            if (months % 12 == 0) {
                currentExpenses *= (1 + inflationRate / 100.0);
            }

            // Prevent infinite loop
            if (months > 1200) {
                return -1;
            }
        }

        return months;
    }
}