package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран. Если таких строк несколько,
выведи каждую с новой строки.


Требования:
1. Инициализируй существующее поле strings класса Solution новым ArrayList<>
2. Программа должна считывать 5 строк с клавиатуры и
записывать их в поле strings класса Solution.
3. Программа должна выводить самую длинную строку на экран.
4. Если есть несколько строк с длиной равной максимальной,
то нужно вывести каждую из них с новой строки.
*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {

        strings = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {

            String s = reader.readLine();
            strings.add(s);
        }
     //   String max = strings.get(0).length() >= strings.get(1).length() ? strings.get(0) : strings.get(1);
        int num = strings.get(0).length();

        for (int j = 0; j < 5; j++) {

          if (strings.get(j).length() >= num)
              num = strings.get(j).length();
        }
          for (int i = 0; i < 5; i++)
              if (strings.get(i).length() == num)
                  System.out.println(strings.get(i));

      //      max = max.length() >= strings.get(j).length() ? max : strings.get(j);

     //       if (max.length() == strings.get(j).length())

      //          System.out.println(strings.get(j));
       //     System.out.println(max);

    }}//напишите тут ваш код
//Делаем всё по порядку:
//1. Создали список строк, считали с клавиатуры данные
//strings = new ArrayList<String>();
//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//for (int i = 0; i < 5; i++) {
//  strings.add(br.readLine());
//}
//
//2. Нашли самую длинную строку в цикле
//int num = strings.get(0).length();
//  for (int i = 0; i < 5; i++) {
//    if (strings.get(i).length() >= num) {
//      num = strings.get(i).length();
//    }
//}
//
//3. Вывод на экран
//for (int i = 0; i < 5; i++) {
//  if (strings.get(i).length() == num) System.out.println(strings.get(i));
//}