package com.javarush.task.task19.task1914;

/* 
Решаем пример

В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна выводить на консоль решенный пример.
Вызови готовый метод printSomething(), воспользуйтесь testString.
Верни переменной System.out первоначальный поток.

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9

Требования:
1. Класс Solution должен содержать класс TestString.
2. Класс Solution должен содержать публичное статическое поле testString типа TestString,
которое сразу проинициализировано.
3. Класс TestString должен содержать публичный void метод printSomething().
4. Метод printSomething() класса TestString должен выводить на экран строку "3 + 6 = ".
5. Метод main(String[] args) класса Solution должен создавать поток PrintStream (используй PrintStream
c параметром конструктора ByteArrayOutputStream).
6. Метод main(String[] args) класса Solution должен подменять и восстанавливать поток вывода в консоль
объекта System.out.
7. Метод main(String[] args) класса Solution должен вызывать метод printSomething(),объекта testString.
8. Метод main(String[] args) класса Solution должен модифицировать строку выведенную методом
printSomething() согласно заданию, и выводить её в консоль.
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);
        String[] str = result.split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[2]);
        int res = 0;
        switch (str[1]){
            case "+": res = a + b; break;
            case "-": res = a - b; break;
            case "*": res = a * b; break;
            case "/": res = a / b; break;
        }

        System.out.print(result);
        System.out.println(res);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}
//public static void main(String[] args) {
//
//    PrintStream oldPrintStream = System.out;
//    ByteArrayOutputStream myOut = new ByteArrayOutputStream();
//
//    System.setOut(new PrintStream(myOut));
//    testString.printSomething();
//    System.setOut(oldPrintStream);
//
//    String theString = myOut.toString().replace( "\n", "" );
//    String[] elements = theString.split(" ");
//    int a = Integer.parseInt(elements[0]), b = Integer.parseInt(elements[2]), result = 0;
//    switch (elements[1]){
//        case "+": result = a + b; break;
//        case "-": result = a - b; break;
//        case "*": result = a * b; break;
//        case "/": result = a / b; break;
//    }
//    System.out.println( theString + result );
//}

//Matcher m = Pattern.compile("(\\d+) ([\\+\\-\\*]) (\\d+)").matcher( resultString );
//if (m.find()) {
//     if ("+".equals( m.group(2) ))
//          // складываем m.group(1) и m.group(3)
//     else if ("-".equals( m.group(2) ))
//          // вычитаем из m.group(1) m.group(3)
//     else
//          // умножаем m.group(1) и m.group(3)

//я извращенец с тернарным условием:
//System.out.printf("%d %s %d = %d ", ints[0], z, ints[1], z.equals("+") ? (ints[0] + ints[1]) : z.equals("*") ? (ints[0] * ints[1]) : (ints[0] - ints[1]));

//parseInt() возвращает примитивное целое число type (int), в результате чего valueOf
// возвращается java.lang.Integer, который является объектом представитель целого числа.
// Там являются обстоятельствами, в которых вы, возможно, захотите объект Integer,
// вместо примитивный тип.
//
//Конечно, еще одно очевидное различие что intValue - это метод экземпляра в результате чего parseInt
// является статическим методом.

//public static void main(String[] args) {
//        PrintStream printS = System.out; // записали в переменную printS настоящий исходный поток
//
//        ByteArrayOutputStream byteAOS = new ByteArrayOutputStream(); // это динамический массив с OutputStream
//
//        PrintStream adapter = new PrintStream(byteAOS); // Это адаптер!!! переводит из потока в массив
//
//        System.setOut(adapter); // Перезаписываем значение переменной out в System. То есть наш поток вывода
//        // работает как надо нам, а именно выходные данные записывает в наш динамический массив
//        testString.printSomething();
//
//        System.setOut(printS); // возвращаем первоначальное значение выходному потоку (зачем-то)
//        String[] x = null;
//
//        if (byteAOS.toString().contains("+")) {
//            x = byteAOS.toString().substring(0,byteAOS.size()-4).replaceAll(" ","").split("\\+");
//            System.out.println(byteAOS.toString() + (Integer.parseInt(x[0]) + Integer.parseInt(x[1])));
//        } else if (byteAOS.toString().contains("*")) {
//            x = byteAOS.toString().substring(0,byteAOS.size()-4).replaceAll(" ","").split("\\*");
//            System.out.println(byteAOS.toString() + (Integer.parseInt(x[0]) * Integer.parseInt(x[1])));
//        } else if (byteAOS.toString().contains("-")) {
//            x = byteAOS.toString().substring(0,byteAOS.size()-4).replaceAll(" ","").split("-");
//            System.out.println(byteAOS.toString() + (Integer.parseInt(x[0]) - Integer.parseInt(x[1])));
//        }
//
//    }

//trim() отрезает пробелы, переходы строки (\n) и знаки табуляции (\t) по краям строки
//byteArrayOutputStream.toString().trim().split(" ")