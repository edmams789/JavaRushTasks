package com.javarush.task.task18.task1818;

/* 
Два в одном

Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.

Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine(), true);
        FileInputStream fileInputStream1 = new FileInputStream(reader.readLine());
        FileInputStream fileInputStream2 = new FileInputStream(reader.readLine());

        while (fileInputStream1.available() > 0){

            fileOutputStream.write(fileInputStream1.read());
        }
        fileInputStream1.close();

        while (fileInputStream2.available() > 0){

            fileOutputStream.write(fileInputStream2.read());

        }
        fileInputStream2.close();
        fileOutputStream.close();
    }
}
//FileOutputStream file = new FileOutputStream(reader.readLine(), true);
//
//в одном из конструкторов FileOutputStream есть аргумент append (boolean), значение true которого позволяет дозаписывать данные.
//
//while (file1.available() > 0){ file.write(file1.read()); } file1.close();
//while (file2.available() > 0){ file.write(file2.read()); } file2.close();
//file.close();