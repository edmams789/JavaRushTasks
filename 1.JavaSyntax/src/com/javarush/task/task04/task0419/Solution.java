package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
Если числа равны между собой, необходимо вывести любое.

Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить число на экран.
3. Программа должна выводить на экран максимальное из четырёх чисел.
4. Если максимальных чисел несколько, необходимо вывести любое из них.
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int a, b, c, d;

        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        d = scanner.nextInt();

        if (( a > b && a > c && a > d ) || ( a == b && a == c && a == d ) ||
                (a == b && a == c && a > d ) || ( a == c && a == d && a > b ) ||
                ( a == b && a == d && a > c ) || ( a == b && a > c && a > d ) ||
                ( a == c && a > b && a > d ) || ( a == d && a > b && a > c )) {
            System.out.println(a);//напишите тут ваш код

        } else if ( b > a && b > c && b > d ) {
            System.out.println(b);

        } else if ( c > a && c > b && c > d ) {
            System.out.println(c);

        } else {
            System.out.println(d);
        }
    }
}
