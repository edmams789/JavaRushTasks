package com.javarush.task.task04.task0427;

/* 
Описываем числа
Ввести с клавиатуры целое число в диапазоне 1 - 999. Вывести его строку-описание
следующего вида:
"четное однозначное число" - если число четное и имеет одну цифру,
"нечетное однозначное число" - если число нечетное и имеет одну цифру,
"четное двузначное число" - если число четное и имеет две цифры,
"нечетное двузначное число" - если число нечетное и имеет две цифры,
"четное трехзначное число" - если число четное и имеет три цифры,
"нечетное трехзначное число" - если число нечетное и имеет три цифры.
Если введенное число не попадает в диапазон 1 - 999, в таком случае
ничего не выводить на экран.

Пример для числа 100:
четное трехзначное число

Пример для числа 51:
нечетное двузначное число

Требования:
1. Программа должна считывать одно число c клавиатуры.
2. Программа должна использовать команду System.out.println() или System.out.print().
3. Программа должна выводить только строку-описание числа и больше ничего.
4. Если число четное и имеет одну цифру, вывести "четное однозначное число".
5. Если число нечетное и имеет одну цифру, вывести "нечетное однозначное число".
6. Если число четное и имеет две цифры, вывести "четное двузначное число".
7. Если число нечетное и имеет две цифры, вывести "нечетное двузначное число".
8. Если число четное и имеет три цифры, вывести "четное трехзначное число".
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int a;

        a = scanner.nextInt();
        if (a >= 1 && a <= 999) {
        if (a%2 == 0 && a/100 >= 1) {
            System.out.println("четное трехзначное число");
        } else  if (a%2 > 0 && a/100 >= 1) {
            System.out.println("нечетное трехзначное число");//напишите тут ваш код
        } else if (a%2 == 0 && a/10 >= 1) {
            System.out.println("четное двузначное число");
        } else if (a%2 > 0 && a/10 >= 1) {
            System.out.println("нечетное двузначное число");
        } else if (a%2 == 0 && a < 10) {
            System.out.println("четное однозначное число");
        } else {
            System.out.println("нечетное однозначное число");
        }
        } else {
        }
}
}
