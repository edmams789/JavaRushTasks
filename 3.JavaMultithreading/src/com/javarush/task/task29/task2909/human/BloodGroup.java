package com.javarush.task.task29.task2909.human;
/*
Рефакторинг (9)
9.4. Замена кодирования типа классом.
9.4.1. Объяви публичный класс группы крови BloodGroup внутри пакета human.
9.4.2. Добавь в класс BloodGroup приватное константное поле int code, приватный конструктор,
принимающий int и инициализирующий поле code, геттер для поля класса.
9.4.3. Добавь в класс BloodGroup статические методы first(), second(), third() и fourth(),
создающие и возвращающие объекты типа BloodGroup с правильным кодом внутри (1, 2, 3 и 4 соответственно).

Требования:
4. Необходимо создать публичный класс BloodGroup внутри пакета human.
5. Необходимо добавить в класс BloodGroup константное поле int code, приватный конструктор,
принимающий int и инициализирующий поле code, геттер для поля класса.
6. Необходимо добавить в класс BloodGroup статические методы first(), second(), third() и fourth(),
создающие и возвращающие объекты типа BloodGroup с правильным кодом внутри (1, 2, 3 и 4 соответственно).
*/
public class BloodGroup {

    private final int code;

    private BloodGroup(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
//    public static void second() { // не правильно
//        new BloodGroup(2);
//    }

    public static BloodGroup first() {
        return new BloodGroup(1);
    }
    public static BloodGroup second() {
        return new BloodGroup(2);
    }
    public static BloodGroup third() {
        return new BloodGroup(3);
    }
//Создай публичный статический метод third(), который возвращает объект типа BloodGroup, у которого code = 3.
    public static BloodGroup fourth() {
        return new BloodGroup(4);
    }
}
//Поле private можно инициализировать либо в конструкторе, либо в месте объявления.
// Инициализировать - это не менять.
//
//Мой код:
//public class BloodGroup
//{
//    private final int code;
//
//    private BloodGroup (int i)
//    {
//        code = i;
//    }
//...