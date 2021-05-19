package com.javarush.task.task37.task3702;
/*
Фабрики (4)
1. В корне задачи создай интерфейс AbstractFactory, в который вынеси общий в фабриках метод.

2. Реализуй интерфейс AbstractFactory в обеих фабриках.

3. В корне задачи создай класс FactoryProducer, в котором создай публичный статический энум
HumanFactoryType со значениями MALE, FEMALE.

4. В FactoryProducer создай публичный статический метод getFactory с аргументом HumanFactoryType.
Этот метод должен возвращать одну из фабрик: для ключа MALE - MaleFactory, для FEMALE - FemaleFactory.

Молодец, Фабрика фабрик готова! Это паттерн Abstract Factory.
В коде тебе не важно, какая фабрика используется.

Твои успехи:
1. Освоен паттерн Factory Method.
2. Освоен паттерн Abstract Factory.
3. +2 паттерна для прохождения собеседования.

Работа джава программистом стала еще ближе, скоро достигнешь цели!


Требования:
1. Класс MaleFactory должен поддерживать интерфейс AbstractFactory.
2. Класс FemaleFactory должен поддерживать интерфейс AbstractFactory.
3. В классе FactoryProducer должен быть создан enum HumanFactoryType со значениями MALE, FEMALE.
4. Метод getFactory в классе FactoryProducer должен принимать один параметр типа HumanFactoryType.
5. Метод getFactory в классе FactoryProducer должен возвращать одну из фабрик в зависимости от принятого параметра.
 */
public class Solution {
    public static void main(String[] args) {
        AbstractFactory factory = (AbstractFactory) FactoryProducer.getFactory(FactoryProducer.HumanFactoryType.FEMALE);
        useFactory(factory);

        factory = (AbstractFactory) FactoryProducer.getFactory(FactoryProducer.HumanFactoryType.MALE);
        useFactory(factory);
    }

    public static void useFactory(AbstractFactory factory) {
        System.out.println(factory.getPerson(99));
        System.out.println(factory.getPerson(4));
        System.out.println(factory.getPerson(15));
    }
}
