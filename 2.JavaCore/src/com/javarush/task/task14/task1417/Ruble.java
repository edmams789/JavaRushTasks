package com.javarush.task.task14.task1417;

public class Ruble extends Money {

    String rub = "RUB";

    public Ruble(double amount) {
        super(amount);
    }

    public String getCurrencyName() {
        return rub;
    }
}