package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Самые-самые
1. Создай список строк.
2. Добавь в него 10 строчек с клавиатуры.
3. Узнай, какая строка в списке встретится раньше: самая короткая или самая длинная.
Если таких строк несколько, то должны быть учтены самые первые из них.
4. Выведи на экран строку из п.3. Должна быть выведена одна строка.


Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Программа должна считывать 10 строк с клавиатуры и добавлять их в список.
3. Программа должна выводить на экран самую короткую строку, если она была раньше самой длинной.
4. Программа должна выводить на экран самую длинную строку, если она была раньше самой короткой.
5. Должна быть выведена только одна строка.
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        ArrayList<String> list = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s);
        }
             String min = list.get(0).length() <= list.get(1).length() ? list.get(0) : list.get(1);
             String max = list.get(0).length() >= list.get(1).length() ? list.get(0) : list.get(1);

        for (int j = 2; j < 10; j++) {

            min = min.length() <= list.get(j).length() ? min : list.get(j);
            max = max.length() >= list.get(j).length() ? max : list.get(j);
        }
        System.out.println(list.indexOf(min) < list.indexOf(max) ? min : max); //напишите тут ваш код
        }
    }










