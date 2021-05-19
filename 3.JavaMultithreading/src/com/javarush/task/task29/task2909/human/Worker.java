package com.javarush.task.task29.task2909.human;
/*
Рефакторинг (9)
9.3. Инкапсуляция поля. Сокрой поле company в классе Worker. Добавь сеттер и геттер для него.

Требования:
3. Необходимо изменить модификатор доступа поля company в классе Worker на приватный. Необходимо добавить
сеттер и геттер для этого поля.
 */
public class Worker extends Human {
 //   private Human human;
    private double salary;
    private String company;

    public Worker(String name, int age) {
        super(name, age);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}