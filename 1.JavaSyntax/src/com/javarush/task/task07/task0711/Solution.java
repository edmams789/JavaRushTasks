package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
1. Создай список строк.
2. Добавь в него 5 строк с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.

Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Программа должна считывать 5 строк с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Программа должна выводить список на экран, каждое значение с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        ArrayList<String> list = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String s = reader.readLine();
            list.add(s);
        }
        for (int j = 0; j < 13; j++) {

            String s = list.get(4);
            list.remove(4);
            list.add(0, s);
        }
        for (int i = 0; i < 5; i++)
            System.out.println(list.get(i));

//  for (int j = 0; j < 13; j++) {

        //s = list.get(4);
        //  list.remove(4);
        //    list.add(0, list.get(4));
        //   list.remove(4);
        // list.set(0, list.get(4));
           //     int q = list.size() - i - 1;
         //       Совсем уж просто.
            //list.add(0, list.get(4));
           // list.remove(5);
            }}
        //напишите тут ваш код


