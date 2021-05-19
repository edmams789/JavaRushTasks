package com.javarush.task.task04.task0433;


/* 
Гадание на долларовый счет
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в каждой строке не разделять.

Пример вывода на экран:
SSSSSSSSSS
SSSSSSSSSS
SSSSSSSSSS
SSSSSSSSSS
SSSSSSSSSS
SSSSSSSSSS
SSSSSSSSSS
SSSSSSSSSS
SSSSSSSSSS
SSSSSSSSSS


Требования:
1. Программа не должна считывать текст c клавиатуры.
2. Программа должна выводить текст на экран.
3. Программа должна выводить квадрат из 10х10 букв S.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        String s = "S";
        int x = 10;
        int y = 1;

        while (y <= x) {
            System.out.println(s + s + s + s + s + s + s + s + s + s);
            y++;
            }

        }//напишите тут ваш код

    }

