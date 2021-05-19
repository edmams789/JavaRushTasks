package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
Выведенные числа должны быть разделены пробелом.

Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить числа на экран.
3. Программа должна выводить три числа разделенных пробелами.
4. Программа должна выводить числа в порядке убывания.
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

        if (b > a && a >= c) {
            System.out.println(b + " " + a + " " + c);
            } else if (b >= c && c > a) {
            System.out.println(b + " " + c + " " + a);
            } else if (c > a && a >= b) {
            System.out.println(c + " " + a + " " + b);
            } else if (c > b && b > a) {
            System.out.println(c + " " + b + " " + a);
            } else if (a == c && c > b) {
            System.out.println(a + " " + c + " " + b);
            } else {
            System.out.println(a + " " + b + " " + c);
        }
        //напишите тут ваш код
    }
}
