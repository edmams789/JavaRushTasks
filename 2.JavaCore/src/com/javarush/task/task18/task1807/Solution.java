package com.javarush.task.task18.task1807;

/* 
Подсчет запятых

С консоли считать имя файла.
Посчитать в файле количество символов ',', количество вывести на консоль.
Закрыть потоки.

Подсказка:
нужно сравнивать с ascii-кодом символа ','.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должно выводится число запятых в считанном файле.
4. Поток чтения из файла должен быть закрыт.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        int tmp = 0;
        while (inputStream.available() > 0){
            if (inputStream.read() == (byte) ',') tmp++;
        }

        inputStream.close();
        System.out.println(tmp);

    }
}
//Друганы, вы прогеры или где? Не надо знать нам код символа на память или по таблице, надо так:
//if (fileInputStream.read() == (byte) ',') tmp++;
//то есть берем символ, которые есть тип char, в данном случае запятая в одинарных кавычках ','
// и преобразовываем её в byte приведением типов. Сравниваем и считаем.
//
//ну, или, разнести на две строчки:
//char ch = ',';
//byte bt = (byte) ch;
//
//if (fileInputStream.read() == bt) делаем что надо.