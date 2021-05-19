package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
В методе main подмени объект System.out написанной тобой реадер-оберткой.
Твоя реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth


Требования:
1. Класс Solution должен содержать класс TestString.
2. Класс Solution должен содержать публичное статическое поле testString типа TestString, которое
сразу проинициализировано.
3. Класс TestString должен содержать публичный void метод printSomething().
4. Метод printSomething() класса TestString должен выводить на экран строки:
"first","second","third","fourth","fifth".
5. Метод main(String[] args) класса Solution должен создавать поток PrintStream (используй PrintStream
c конструктором принимающим ByteArrayOutputStream).
6. Метод main(String[] args) класса Solution должен подменять и восстанавливать поток вывода в консоль
объекта System.out.
7. Метод main(String[] args) класса Solution должен вызывать метод printSomething(),объекта testString.
8. Метод main(String[] args) класса Solution должен модифицировать строки(вставлять контекстную рекламу)
выведенные методом printSomething() согласно заданию, и выводить её в консоль.
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        String line = "JavaRush - курсы Java онлайн";
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream);
        testString.printSomething();

        String[] result = byteArrayOutputStream.toString().split("\n");
        System.setOut(consoleStream);

        int i = 0;
        for (String res : result){
            System.out.println(res);
            i++;
            if (i % 2 == 0)
        System.out.println(line);
        }
    }
//PrintStream sout = System.out; // сохраняем ссылку на System.out в sout класса PrintStream
//
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); // это расширяемый массив
//        PrintStream stream = new PrintStream(byteArrayOutputStream); // закидываем в поток наш массив
//        System.setOut(stream); // подменяем вывод на консоль загонянием в наш поток
//        testString.printSomething(); // выводим в наш массив 5 строк, предназначенных на консоль
//        System.setOut(sout); // возвращаем консольный вывод
//
//        String [] st = byteArrayOutputStream.toString().split("\\n"); // режем вывод на консоль по строкам
//        int i = 0;
//        for (String sti : st) { // пока есть строки, что загнаны в наш массив
//            System.out.println(sti); // выводим первую строку
//            i++; // считаем счетчик второй строки
//            if  ((i % 2) == 0) { // если строка третья, то выводим в консоль рекламу
//                System.out.println("JavaRush - курсы Java онлайн");
//            }
//        }
    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
