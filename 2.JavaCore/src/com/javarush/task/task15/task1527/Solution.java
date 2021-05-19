package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
Считать с консоли URL-ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &,
например, lvl=15).
URL содержит минимум 1 параметр.
Выводить параметры нужно в той же последовательности, в которой они представлены в URL.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк
Обрати внимание на то, что метод alert необходимо вызывать ПОСЛЕ вывода списка всех параметров на экран.

Пример 1

Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo

Вывод:
lvl view name

Пример 2

Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo

Вывод:
obj name
double: 3.14


Требования:
1. Программа должна считывать с клавиатуры только одну строку.
2. Класс Solution не должен содержать статические поля.
3. Программа должна выводить данные на экран в соответствии с условием.
4. Программа должна вызывать метод alert с параметром double в случае, если значение параметра obj
может быть корректно преобразовано в число типа double.
5. Программа должна вызывать метод alert с параметром String в случае, если значение параметра obj
НЕ может быть корректно преобразовано в число типа double.
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String url = reader.readLine();

            url = url.substring(url.indexOf("?") + 1);

         //   url = url.substring();

            for (String s : url.split("&")) {
            //    s = s.replaceAll(" = ", "");
         //

            boolean eq = s.startsWith(" = ");
            if (eq == true)
                s = s.substring(0);
         //   else if ()
                System.out.println(s);
          //  if (("."))

      //      System.out.println(s);
                //if (s.equals(".")) {
            //                    alert(s);
            //                } else if (s.equals("name")) {
            //                    alert(s);
                            }

//String result = chapterNumber.substring(0, chapterNumber.indexOf("."));

// String result = chapterNumber.split("\\.")[0];

//String chapterNumber = "1.2.1";
//int index = chapterNumber.indexOf(".");
//String mainChapterNumber = chapterNumber.substring(0,index);

            reader.close();
        } catch (IOException e) {

        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
//Логика ведь простая:
//1. читаем строку
//2.отрезаем всё, что до "?"
//3.нарезаем части через "&" (лично я использовал просто substring)
//4.проверяем, есть ли "=", и выводим на экран куски строки до него (либо весь кусок),
// не забываем ставить пробел в конце
//5.проверяем куски до "=" на соответствие obj. Если ок, то в блоке try пробуем запарсить
// часть после "=" в double и вызываем соответствующий метод, а в catch вызываем метод для строки

// Считал строку, затем обрезал ненужное (по "?" включительно). С этим же всё понятно?
//        String url = reader.readLine();
//        url = url.substring(url.indexOf("?") + 1);
//
//for (String s : url.split("&") )
//А затем ты url нарезаешь "&" и для каждой строки(String s) в полученном массиве выполняешь действие ниже.
// Думаю, ты делаешь у себя в коде то же самое, только большим количеством строк. Честно, уже не помню,
// где такую конструкцию нарыл, но мне понравилось - компактненько.

//String self = getString();//как-нибудь получаем строку
//String result = self.replaceAll("\\w|\\d", "")//регулярным выражением заменяем буквы(\\w) и цифры(\\d) на пустую строку, то есть удаляем.