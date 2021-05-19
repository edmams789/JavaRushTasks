package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/*
Палиндром?
Объяви и реализуй логику приватного статического метода Set<Integer> getRadix(String number),
в котором нужно определить, в каких системах счисления (от 2 до 36 включительно) представление
числа number (передается в десятичной системе счисления) является палиндромом и добавить индекс
таких систем в результат.
Если переданное число некорректно - возвращай пустой HashSet.
В системах счисления с основанием большим 10 в качестве цифр используются латинские буквы. К примеру,
числу 35 в десятичной системе соответствует число "Z" в системе с основанием 36.

Метод main не принимает участие в тестировании.

P.S.: В методе getRadix перехватывай NumberFormatException. Стек-трейс выводить не нужно.


Требования:
1. Необходимо объявить приватный статический метод Set<Integer> getRadix(String number).
2. Метод getRadix в случае некорректных входных данных должен возвращать пустой HashSet.
3. Методе getRadix не должен бросать NumberFormatException.
4. Метод getRadix не должен ничего выводить в консоль.
5. Метод getRadix должен возвращать множество согласно условию задачи.
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }
    private static Set<Integer> getRadix(String number) {
        Set<Integer> set = new HashSet<>();
        try {
            for (int i = 2; i <= 36; i++) {
                StringBuilder str = new StringBuilder(Integer.toString(Integer.parseInt(number), i));
                if ((str.toString()).equals((str.reverse()).toString())) {
                   //   set.add(Integer.parseInt(String.valueOf(str)));
                      set.add(i);
        }
        }
        } catch (NumberFormatException e) {

        }
        return set;
    }
}
//Знание алгоритма для реверса строки полезно и для того, чтобы сравнивать первые и последние символы
// в строке :)
//
//Советы:
//1) Полиндром - имеется ввиду, что число в какой-то системе счисления считывается одинаково и
// с конца в начало, и с начала в конец. Например: 11011. Как не читать, все равно будет 11011.
//
//2) В этой задаче нужно использовать Integer.toString(int value, int radix) и
// Integer.parseInt(String value, int radix). radix - основание системы счисления (дословный перевод),
// toString конвертирует число в другую систему счисления, а parseInt считывает число, считая,
// что оно в системе счисления radix.

//Сделал такой велосипед, точнее инвалидное кресло. Строку в методе парсю в int, потом в цикле от 2 до 36
// включительно этот int обратно перевожу в строку методом Integer.toString(a, i), где а - это наше число,
// а i это разрядность числа. И вызываю метод на проверку палиндромности данной строки,
// который при тру суёт i в set.