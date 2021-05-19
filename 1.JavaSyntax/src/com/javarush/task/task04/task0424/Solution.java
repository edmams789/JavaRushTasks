package com.javarush.task.task04.task0424;

/* 
Три числа
Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других,
равных между собой. Вывести на экран порядковый номер числа, отличного от остальных.

Пример для чисел 4 6 6:
1

Пример для чисел 6 6 3:
3

Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна использовать команды System.out.println() или System.out.print().
3. Программа должна выводить на экран порядковый номер числа, отличного от остальных.
4. Если все числа разные, ничего не выводить.
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

        if (a != b && b == c) {
            System.out.println(1);//напишите тут ваш код
        } else if (b != a && a == c) {
            System.out.println(2);
        } else if (c != a && a == b) {
            System.out.println(3);
        } else {
//напишите тут ваш код
        }
    }
}
