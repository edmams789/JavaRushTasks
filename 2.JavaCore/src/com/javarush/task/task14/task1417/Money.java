package com.javarush.task.task14.task1417;

public abstract class Money {

    private double amount; //Приватное поле не доступно наследникам.

    public Money(double amount) {
        this.amount = amount;   //
    }


    public double getAmount() {
        return amount;
    }

    public abstract String getCurrencyName();
}

//super - вызывает конструктор родительского класса (здесь Money).
// То есть ты пишешь allMoney.add(new USD(1100.5)); - ты создаёшь объект класса USD с параметром amount 1100.5.
// Конструктор USD в свою очередь вызывает метод super и кидает туда параметр amount (те же 1100.5).
// Выполняется конструктор Money с параметром amount.
// То есть amount ты передаёшь в класс Money ( super - родительский класс ),
// потом оттуда надо его достать геттером.
// Можно тоже через super + вызов геттера из класса Money.