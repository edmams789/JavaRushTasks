package com.javarush.task.task17.task1720;

import java.math.BigDecimal;

public class BankAccount {
//1. Класс BankAccount должен содержать private поле balance типа BigDecimal.
    private BigDecimal balance;
    private String owner;

    public BankAccount(String owner) {
        this(BigDecimal.ZERO, owner);
    }

    public BankAccount(BigDecimal balance, String owner) {
        this.balance = balance;
        this.owner = owner;
    }
//5. В методе deposit(BigDecimal money), если необходимо, используй synchronized.
    public synchronized void deposit(BigDecimal money) {
        BigDecimal newBalance = balance.add(money);
        System.out.println("Добавляем " + money + ", на счету " + newBalance);
        balance = newBalance;
    }
//4. В методе withdraw(BigDecimal money), если необходимо, используй synchronized.
    public synchronized void withdraw(BigDecimal money) throws NotEnoughMoneyException {
        BigDecimal newBalance = balance.subtract(money);

        if (newBalance.compareTo(BigDecimal.ZERO) < 0) throw new NotEnoughMoneyException();

        balance = newBalance;
        System.out.println("Тратим " + money + ", на счету " + balance);
    }
//2. Метод deposit(String money) класса BankAccount должен делегировать поведение
//в метод deposit(BigDecimal money).
    public void deposit(String money) {
        deposit(new BigDecimal(money));
    }
//3. Метод withdraw(String money) класса BankAccount должен делегировать поведение
//в метод withdraw(BigDecimal money).
    public void withdraw(String money) throws NotEnoughMoneyException {
        withdraw(new BigDecimal(money));
    }
}
