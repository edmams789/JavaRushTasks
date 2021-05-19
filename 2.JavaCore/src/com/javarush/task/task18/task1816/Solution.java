package com.javarush.task.task18.task1816;

/* 
Английские буквы

В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.

Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
4. Нужно учитывать заглавные и строчные буквы.
5. Поток чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);

        byte[] bytes = new byte[fileInputStream.available()];
        int data = fileInputStream.read(bytes);
        fileInputStream.close();
        int count = 0;
        for (byte a : bytes) {
//По таблице в интернете английские буквы находятся 65-90 диапазон прописных букв, 97-122 строчных.
            if ((a >= 65 && a <= 90) || (a >= 97 && a <= 122)) {
                count++;
            }
        }
        System.out.println(count);
            }
        }
//Таблица символов ASCII:
//https://istarik.ru/blog/programmirovanie/53.html
//Нам нужны коды коды английских букв в столбце DEC

//while (fileInputStream.available() > 0){
//            int i = fileInputStream.read();
//            if ((i >= 97 && i <= 122)||(i >= 65 && i <= 90)){
//                count++;
//            }
//        }