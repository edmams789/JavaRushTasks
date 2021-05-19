package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;

/* 
Сортировка байт

Ввести с консоли имя файла.
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран.
Закрыть поток ввода-вывода.

Пример байт входного файла:
44 83 44

Пример вывода:
44 83


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все уникальные байты из файла в порядке возрастания.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        TreeSet<Byte> treeSet = new TreeSet<>();
        while (inputStream.available() > 0){
            treeSet.add((byte)inputStream.read());
        }
        inputStream.close();
        for (Byte b: treeSet){
            System.out.print(b + " ");
        }
    }
}
//Через ArrayList не получалось почему то(((
//Сделал через Treeset как все тут
//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//
////Объект для считывания имени с консоли
//        String name = "";// строка имени файла
//        name = reader.readLine();// имя файла вводим в переменную
//        FileInputStream inputStream = new FileInputStream(name);//поток для чтения файла
//        TreeSet<Byte> treeSet = new TreeSet<>();///Коллекция для хранения уникальных данных
//        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
//        {
//           treeSet.add((byte)inputStream.read()); // прочитать очередной байт в трисет
//        }
//        inputStream.close();//закрываем поток
//        for (Byte b: treeSet){//в цикле выводим
//            System.out.print(b + " ");// добавляем пробел при выводе
//        }

//Да оставят тут админы этот кусок кода с комментами для всех не сведущих вдруг. ))) Спасибо.
//
//FileInputStream filereader = new FileInputStream // создаем и открываем поток, вводим название файла
//                (new BufferedReader(new InputStreamReader(System.in)).readLine());
//        TreeSet<Integer> set = new TreeSet<Integer>(); // тут создаем самосортирующийся TreeSet
//
//        while (filereader.available() > 0){ // записываем все байты в TreeSet он сам режет все повторы
//            set.add(filereader.read());
//        }
//        filereader.close(); // закрываем поток, мы считали весь файл
//        for (int i : set){ // и выводим наш TreeSet отсортированный через пробел в одну строку
//            System.out.print(i + " ");
//        }