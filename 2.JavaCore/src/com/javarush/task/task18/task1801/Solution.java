package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт

Ввести с консоли имя файла.
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться максимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        int max = 0;

        while (inputStream.available() > 0){
            int data = inputStream.read();

            if (data > max){
                max = data;
            }
        }
        inputStream.close();
        System.out.println(max);
    }
}
//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
////Принимаем имя файла с консоли
//        String string = null;//создаем строку куда положим имя файла
////
//        string = reader.readLine();//кладем имя файла в переменную
////
//        FileInputStream fileInputStream = new FileInputStream(string);//создаем объект потока
////в конструкторе объекта кладем имя файла
//        int count = 0;// эта переменная нужна для определения какой байт больше
//
//        while (fileInputStream.available() > 0){// пока еще байты остались делаем то то
//            int data = fileInputStream.read();// считываем байты и кладем в переменную
//            if (data > count){//тут если байт больше созданной нами переменной
//                count = data;//то этой переменной присваиваем байт
//            }
//        }
//
//        fileInputStream.close();//закрываем поток
//
//        System.out.println(count);//выводим самый большой байт с потока