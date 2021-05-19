package com.javarush.task.task05.task0532;

import java.io.*;

import static sun.swing.MenuItemLayoutHelper.max;

/* 
Задача по алгоритмам
Написать программу, которая:
1. считывает с консоли число N, которое должно быть больше 0
2. потом считывает N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.

Требования:
1. Программа должна считывать числа с клавиатуры.
2. Программа должна выводить число на экран.
3. В классе должен быть метод public static void main.
4. Нельзя добавлять новые методы в класс Solution.
5. Программа должна выводить на экран максимальное из введенных N чисел.
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] a = new int[n];
        {
            for (int i = 0; i < a.length; i++) {
                String s = reader.readLine();
                a[i] = Integer.parseInt(s);
            }
        int maximum = max(a);

        //напишите тут ваш код

        System.out.println(maximum);
    }
}}
