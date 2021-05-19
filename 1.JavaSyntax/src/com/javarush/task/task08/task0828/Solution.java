package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран
в виде: "May is the 5 month".
Используйте коллекции.


Требования:
1. Программа должна считывать одно значение с клавиатуры.
2. Программа должна выводить текст на экран.
3. Программа должна использовать коллекции.
4. Программа должна считывать с клавиатуры имя месяца и выводить
его номер на экран по заданному шаблону.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        Map<String, Integer> map = new HashMap<>();

        map.put("", 0);
        map.put("January", 1);
        map.put("February", 2);
        map.put("March", 3);
        map.put("April", 4);
        map.put("May", 5);
        map.put("June", 6);
        map.put("July", 7);
        map.put("August", 8);
        map.put("September", 9);
        map.put("October", 10);
        map.put("November", 11);
        map.put("December", 12);


    //    January February March April May June July August September October November December


        System.out.println(s + " is the " + map.get(s) + " month");

        //На мой взгляд самый простой способ - это создать мапу <String, Integer>
        //где ключ - это название месяца, а значение - номер месяца
        //
        //затем просто выводим на экран:
        //String userInput = reader.readLine();
        //System.out.println(userInput + " is the " + map.get(userInput) + " month");


    }
}
