package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
Изучи класс Circle. Напиши максимальное количество конструкторов с разными аргументами.

Подсказка:
не забудь про конструктор по умолчанию.

Требования:
1. У класса должно быть хотя бы три переменные.
2. У класса должен быть конструктор по умолчанию.
3. У класса должен быть хотя бы один конструктор.
4. У класса должно быть хотя бы два конструктора.
5. У класса должно быть хотя бы три конструктора.
6. У класса должно быть хотя бы четыре конструктора.
*/

public class Circle {
    public double x;
    public double y;
    public double radius;

    public Circle() {
        {
            double x = 3;
            double y = 4;
            double radius = 5;
        }
    }
    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public Circle(double y, double radius) {
            this.y = y;
            this.radius = radius;
            {
                double x = 8;
            }
        }
    public Circle(double radius) {
        this.radius = radius;
        {
            double x = 13;
            double y = 14;
        }
    }
    //напишите тут ваш код

        public static void main (String[]args){

        }
}