package com.javarush.task.task14.task1417;

public class USD extends Money {

    String usd = "USD";

    public USD(double amount) {
        super(amount);
    }

    public String getCurrencyName() {
        return usd;
    }
}
