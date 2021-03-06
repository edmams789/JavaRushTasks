package com.javarush.task.task05.task0504;


/* 
Трикотаж
Пару задач назад студенты секретного центра JavaRush создавали класс Cat.
Теперь пришла пора реализовать котов во плоти,
разумеется по образу и подобию класса Cat, а точнее - основываясь на нём, как на шаблоне.
Их - котов - должно быть трое. Наполните этих троих жизнью, то есть, конкретными данными.

Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Нужно создать три объекта типа Cat.
3. Класс Cat нельзя изменять.
4. Программа не должна выводить данные на экран.
*/

public class Solution {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Vaska", 3, 4, 2);
        Cat cat2 = new Cat("Murzik", 4, 6, 3);
        Cat cat3 = new Cat("Kuzya", 7, 5, 5);
        //напишите тут ваш код
    }

    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }
    }
}