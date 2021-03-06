package com.javarush.task.task29.task2909.human;
/*
Рефакторинг (2)
2.1. Извлечение подкласса.
2.1.1. Добавь класс Soldier в пакет human.
2.1.2. Избавься от поля isSoldier.
2.1.3. Перенеси в Soldier необходимые методы из Human.
2.1.4. Обнови сигнатуру конструктора Human.
2.2. Подъем тела конструктора.
2.2.1. Перенеси инициализацию полей name и age в подходящее место, добавь необходимые
параметры в конструктор Human.
2.2.2. Добавь конструктор в класс Soldier.

Требования:
1. Класс Soldier должен существовать в пакете human в отдельном файле. Класс Soldier должен наследоваться
от класса Human.
2. В классе Human не должно быть поля isSoldier.
3. В класс Soldier из класса Human требуется перенести необходимые методы.
4. Конструктор класса Human должен принимать два параметра: String name и int age, и инициализировать
соответствующие поля.
5. В классе Soldier должен быть конструктор, который принимает два параметра: String name и int age,
и вызывает соответствующий конструктор суперкласса.
 */
public class Soldier extends Human {

    public Soldier(String name, int age) {
        super(name, age);
    }


    public Soldier(boolean isSoldier) {
        super(isSoldier);
    }



    public void live() {
        fight();
    }

    public void fight() {
    }
}
