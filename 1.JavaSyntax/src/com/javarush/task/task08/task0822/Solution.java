package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Минимальное из N чисел
1. Ввести с клавиатуры число N.
2. Считать N целых чисел и заполнить ими список - метод getIntegerList.
3. Найти минимальное число среди элементов списка - метод getMinimum.


Требования:
1. Программа должна выводить текст на экран.
2. Программа должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только три метода.
4. Метод getIntegerList() должен считать с клавиатуры число N,
потом вернуть список размером N элементов, заполненный числами с клавиатуры.
5. Метод getMinimum() должен вернуть минимальное число среди элементов списка.
6. Метод main() должен вызывать метод getIntegerList().
7. Метод main() должен вызывать метод getMinimum().
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {

  //      int minimum = min(getMinimum());   //напишите тут ваш код
     // Collections.min(array);
     //   System.out.println(array);


        // Найти минимум тут
        return Collections.min(array);
    }

    public static List<Integer> getIntegerList() throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(reader.readLine());



      //      list.addAll() = Integer.parseInt(reader.readLine());
        }
      //      System.out.println();
     //       result = Integer.parseInt(reader.readLine());

      //      result.add(Integer.parseInt(reader.readLine()));

          //   String s = reader.readLine();
         //    a[i] = Integer.parseInt(s);

            //    a[i] = Integer.parseInt(reader.readLine());

        List<Integer> list = new ArrayList<>();


        //for (int i = 0; i < n; i++) {
        //         result.add(Integer.parseInt(reader.readLine()));
        //        }
        //Это работает.
        //А вот если вы создание списка (result)  закинете внутрь цикла ,
        // то тоже будет работать - каждый проход будет создаваться новый список
        // и соответственно  данных по завершению цикла там никаких не будет.

      //  list.addAll(new ArrayList<>(n));
   //     list.addAll(n);
        //int[] a = new int[n];
        //        {
        //            for (int i = 0; i < a.length; i++) {
        //                String s = reader.readLine();
        //                a[i] = Integer.parseInt(s);
        //            }
        //        int maximum = max(a);



        // Создать и заполнить список тут
        return list;
    }
}
