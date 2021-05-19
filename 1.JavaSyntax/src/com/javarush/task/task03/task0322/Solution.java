package com.javarush.task.task03.task0322;


/* 
Большая и чистая
Ввести с клавиатуры три имени, вывести на экран надпись:
name1 + name2 + name3 = Чистая любовь, да-да!

Пример:
Вася + Ева + Анжелика = Чистая любовь, да-да!


Требования:
1. Программа должна выводить текст.
2. Программа должна считывать данные с клавиатуры.
3. Выведенный текст должен содержать введенное имя name1.
4. Выведенный текст должен содержать введенное имя name2.
5. Выведенный текст должен содержать введенное имя name3.
6. Выведенный тест должен полностью соответствовать заданию.
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.nextLine();
        String name2 = scanner.nextLine();
        String name3 = scanner.nextLine();

        System.out.println(name1 + " + " + name2 + " + " + name3 +
                " = Чистая любовь, да-да!");//напишите тут ваш код
    }
}