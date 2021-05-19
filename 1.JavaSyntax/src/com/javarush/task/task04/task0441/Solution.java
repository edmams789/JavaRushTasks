package com.javarush.task.task04.task0441;

/* 
Как-то средненько
Ввести с клавиатуры три числа, вывести на экран среднее из них.
Т.е. не самое большое и не самое маленькое.
Если все числа равны, вывести любое из них.

Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить число на экран.
3. Программа должна выводить среднее из трех чисел.
4. Если все числа равны, вывести любое из них.
5. Если два числа из трех равны, вывести любое из двух.
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

        if ((a > b && b > c) || (c > b && b > a) ||
                (a == b && b == c) || (a == b || b == c)) {
            System.out.println(b);
        } else if ((a > c && c > b) || (b > c && c > a)) {
            System.out.println(c);
        } else if ((b > a && a > c) || (c > a && a > b) || (a == c)) {
            System.out.println(a);
        } else {

        }
//напишите тут ваш код
    }
}
