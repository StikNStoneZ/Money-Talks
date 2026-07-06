package com.example.demo.finance;

public abstract class Scenario {
    String name;

    public Scenario(String name) {
        this.name = name;
    }

    abstract double adjustExpenses(double baseExpenses);
}