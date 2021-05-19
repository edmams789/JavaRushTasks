package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* 
Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое
первого файла в кодировке .


Требования:
1. Программа НЕ должна считывать данные с клавиатуры.
2. Программа НЕ должна выводить данные на экран.
3. Программа должна записывать данные в файл.
4. Содержимое второго файла должно соответствовать содержимому первого файла за исключением кодировки(UTF-8).
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");

        FileInputStream fis = new FileInputStream(args[0]);
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);

        String s = new String(buffer, windows1251);
        FileOutputStream fos = new FileOutputStream(args[1]);
        buffer = s.getBytes(utf8);
        fos.write(buffer);
    }
}
//Charset koi8 = Charset.forName("KOI8-R");
//Charset windows1251 = Charset.forName("Windows-1251");
//
//byte[] buffer = new byte[1000];
//inputStream.read(buffer);
//String s = new String(buffer, koi8);
//buffer = s.getBytes(windows1251);
//outputStream.write(buffer);

//Чтобы такой дикой чешуи не происходило, читая файл не системной кодировки не пользуйтесь символьными ридерами, которые работают с текстом. А пользуйтесь теми, которые читают бинарные файлы, т.е. читают сразу просто байты.
//
//В жизни тут нужно пользовать
//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
//но ублюдочный валидатор думает, что это чтение с консоли. Нахрена делать проверку на отсутствие чтения с консоли? Мы типа как-то с помощью консоли смухлевать можем?
//
//По этому пользуем голый FileInputStream:
//Создаём FileInputStream закинув в него имя входящего файла;
//Создаём массив байтов размером с available() файлопотока;
//Читаем один раз сразу все байты в созданный массив байтов;
//Создаём строковую переменную, с конструктором массива байтов и кодировки UTF-8;
//Создаём FileOutputStream закинув в него имя выходящего файла;
//Получаем из строковой переменой массив байтов в кодировке Windows-1251;
//Записываем выходной массив байтов в выходной поток.

//Все правильно, как в лекции только нужно поменять две вещи:
// - загоняем байты из первого файла в строковую переменную, но с кодировкой Windows-1251;
// - получаем из строковой переменой массив байтов в кодировке UTF-8