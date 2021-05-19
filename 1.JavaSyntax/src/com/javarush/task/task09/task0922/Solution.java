package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
Ввести с клавиатуры дату в формате "2013-08-18"
Вывести на экран введенную дату в виде "AUG 18, 2013".
Воспользоваться объектом Date и SimpleDateFormat.

Требования:
1. Программа должна считывать данные с клавиатуры.
2. В программе должна быть объявлена переменная типа SimpleDateFormat.
3. В программе должна быть объявлена переменная типа Date.
4. Программа должна выводить данные на экран.
5. Вывод должен соответствовать заданию.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
        Date date = dateFormat.parse(reader.readLine());
     //   String str = args.length == 0 ? reader.readLine() : args[0];
    //    Date parsingDate;
    //        parsingDate = dateFormat.parse(str);
            dateFormat = new SimpleDateFormat("MMM dd, y", Locale.ENGLISH);
            System.out.println(dateFormat.format(date).toUpperCase());
        }
    }

//В решении задачи помогла статья:
//
//http://www.seostella.com/ru/article/2012/02/05/formatirovanie-daty-v-java.html
//
//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//Date date = dateFormat.parse(reader.readLine());
//SimpleDateFormat dateFormat1 = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);
//System.out.println(dateFormat1.format(date).toUpperCase());