package com.javarush.task.task22.task2212;

/*
Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.

Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')' , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true
+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false


Требования:
1. Метод checkTelNumber должен возвращать значение типа boolean.
2. Метод checkTelNumber должен быть публичным.
3. Метод checkTelNumber должен принимать один параметр типа String.
4. Метод checkTelNumber должен корректно проверять валидность номера телефона переданного ему в качестве параметра.
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;
        if (telNumber.isEmpty()) return false;

        if (telNumber.matches("^[\\+][0-9]{12}")) return true;
        if (telNumber.matches("\\+\\d{2}\\(\\d{3}\\)\\d{7}")) return true;
        if (telNumber.matches("\\+\\d{8}\\-\\d{2}\\-\\d{2}")) return true;
        if (telNumber.matches("\\d{6}\\-\\d{4}")) return true;


        return false;
    }

    public static void main(String[] args) {
//        Pattern pt = Pattern.compile("\\+\\d{12}");
//        Matcher m = pt.matcher("+380501234567");
//        boolean ft = m.matches();
//
//        System.out.println("ft = " + ft);

    }
}
//Cоветую к прочтению
//1.Регулярные выражения в Java
//2.Пакет java.util.regex
//3.6 пунктов, которые помогут легко разобраться с regexp ИМХО она лучшая
//Советую делать и проверять регулярки тут www.debuggex.com
//В моем выражении посути 3 выражения через ИЛИ для наглядности загоните его на сайт вместе с текстом пример. На сайте рисует классную логическую цепочку
//Наглядный майн для теста
//ArrayList<String> numbers = new ArrayList<>();
//        numbers.add("+380501234567");
//        numbers.add("+38(050)1234567");
//        numbers.add("+38050123-45-67");
//        numbers.add("050123-4567");
//        numbers.add("+38)050(1234567");
//        numbers.add("+38(050)1-23-45-6-7");
//        numbers.add("050ххх4567");
//        numbers.add("050123456");
//        numbers.add("(0)501234567");
//
//        for (String num :  numbers){
//            System.out.println(num+" "+checkTelNumber(num));
//        }