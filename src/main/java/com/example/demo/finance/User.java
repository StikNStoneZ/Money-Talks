package com.example.demo.finance;

public class User {

    double monthlyIncome;
    double monthlyExpenses;
    int totalMonths;
    double investmentRate;

    public User(double monthlyIncome, double monthlyExpenses, int totalMonths, double investmentRate) {
        this.monthlyIncome = monthlyIncome;
        this.monthlyExpenses = monthlyExpenses;
        this.totalMonths = totalMonths;
        this.investmentRate = investmentRate;
    }
}
