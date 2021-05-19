package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький,
вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.

Требования:
1. Программа должна создавать большой массив на 20 целых чисел.
2. Программа должна считывать с клавиатуры 20 чисел для большого массива.
3. Программа должна создавать два маленьких массива на 10 чисел каждый.
4. Программа должна скопировать одну половину большого массива в первый маленький,
а вторую - во второй и вывести его на экран.
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[20];

        for (int i = 0; i < a.length; i++)
        {
            String s = reader.readLine();
            a[i] = Integer.parseInt(s);
        }
        int[] c = new int[10];

        int[] d = new int[10];

        int[] aCopy = Arrays.copyOf(a,9);
        c = aCopy;


        int[] aCopy2 = Arrays.copyOfRange(a,10,20);
        d = aCopy2;
        System.out.println(Arrays.toString(d));
        //напишите тут ваш код
    }
}
