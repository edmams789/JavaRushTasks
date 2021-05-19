package com.javarush.task.task14.task1417;

public class Hrivna extends Money {

    String uah = "UAH";

    public Hrivna(double amount) {
        super(amount);
    }

    public String getCurrencyName() {

        return uah;
    }
}
