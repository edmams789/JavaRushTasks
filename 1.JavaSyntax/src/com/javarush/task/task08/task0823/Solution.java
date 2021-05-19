package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Омовение Рамы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
мама мыла раму.

Пример вывода:
Мама Мыла Раму.

Требования:
1. Программа должна выводить текст на экран.
2. Программа должна считывать строку с клавиатуры.
3. Класс Solution должен содержать один метод.
4. Программа должна заменять в тексте первые буквы всех слов на заглавные.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();//напишите тут ваш код

        ArrayList<String> list = new ArrayList<String>();{
//        while (true) {
//            String s = reader.readLine();
//            if (s.isEmpty()) break;
        list.add(s);
    }
        ArrayList<String> listUpperCase = new ArrayList<String>();
                for (int i = 0; i < list.size(); i++) {
                    s = list.get(i);
                    listUpperCase.add(s.toUpperCase());
                }
                for (int i = 0; i < listUpperCase.size(); i++) {
                    System.out.println(listUpperCase.get(i));


                }
    //    Нашел вот такое решение на Stackoverflow:
    //    StringBuilder sb = new StringBuilder(s);
      //  for(int i = 0; i < sb.length(); i++)
        //    if(i==0 || sb.charAt(i-1) == ' ')
          //      sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
     //   System.out.println(sb.toString());
    }
}
