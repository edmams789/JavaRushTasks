package com.javarush.task.task04.task0428;

/* 
Положительное число
Ввести с клавиатуры три целых числа. Вывести на экран количество
положительных чисел среди этих трех.

Примеры:
а) при вводе чисел
-4
6
6
получим вывод
2

б) при вводе чисел
-6
-6
-3
получим вывод
0
в) при вводе чисел
0
1
2
получим вывод
2

Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить число на экран.
3. Программа должна выводить количество положительных чисел в исходном наборе.
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int a, b, c;

        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();

        if (a > 0 && b > 0 && c > 0) {
            System.out.println(3);
        } else if ((a > 0 && b > 0 && c <= 0) ||
                (a > 0 && b <= 0 && c > 0) ||
                (a <= 0 && b > 0 && c > 0)) {
            System.out.println(2);
        } else if (a <= 0 && b <= 0 && c <= 0){
            System.out.println(0);
        } else {
            System.out.println(1);//напишите тут ваш код
        }

    }
}

