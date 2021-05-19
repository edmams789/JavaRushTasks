package com.javarush.task.task04.task0436;


/* 
Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.

Пример: m=2, n=4
8888
8888


Требования:
1. Программа должна считывать два числа c клавиатуры.
2. Программа должна выводить текст на экран.
3. Программа должна выводить прямоугольник размером m на n из восьмёрок.
4. В программе должен использоваться цикл for.
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int m, n;

        m = scanner.nextInt();
        n = scanner.nextInt();

        for (int y = 1; y <= m; y++) {
        for (int a = 8, x = 1; x <= n; x++) {

            System.out.print(a);
        }
            System.out.println();
        }
    }                //напишите тут ваш код
    }

