package com.javarush.task.task28.task2813;

import java.util.concurrent.Callable;
//1. Класс FactorialCalculator должен поддерживать интерфейс Callable.
public class FactorialCalculator implements Callable {
//4. Поле number класса FactorialCalculator должно быть приватным.
    private final int number;

    public FactorialCalculator(int number) {
        this.number = number;
    }
//2. Метод call класса FactorialCalculator должен возвращать результат выполнения метода factorial.
//3. Метод call класса FactorialCalculator должен быть публичным.
    @Override
    public Long call() throws InterruptedException {
        return factorial(number);
    }

    public long factorial(int number) throws InterruptedException {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be greater than zero");
        }
        long result = 1;
        while (number > 1) {
            Thread.sleep(1);
            result = result * number;
            number--;
        }
        return result;
    }
}
