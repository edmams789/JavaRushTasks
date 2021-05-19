package com.javarush.task.task09.task0929;

import java.io.*;

/* 
Обогатим код функциональностью!
Задача: Программа вводит два имени файла. И копирует первый файл на место, заданное вторым именем.
Новая задача: Программа вводит два имени файла. И копирует первый файл на место, заданное вторым именем.
Если файла (который нужно копировать) с указанным именем не существует,
то программа должна вывести надпись "Файл не существует."
и еще один раз прочитать имя файла с консоли, а уже потом считывать файл для записи.


Требования:
1. Программа должна считывать имена файлов.
2. Метод main должен обрабатывать исключения кидаемые методом getInputStream.
Если возникло исключение, нужно вывести сообщение «Файл не существует.».
3. Программа должна копировать содержимое первого файла во второй.
4. В методе main должен вызываться метод getInputStream.
5. Метод getInputStream изменять нельзя.
6. В методе main должен вызывать метод getOutputStream.
7. Метод getOutputStream изменять нельзя.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream fileInputStream;
        try {
            String sourceFileName = reader.readLine();
            fileInputStream = getInputStream(sourceFileName);
        }
        catch (IOException e) {
            System.out.println("Файл не существует.");
            String sourceFileName = reader.readLine();
            fileInputStream = getInputStream(sourceFileName);
        }
        String destinationFileName = reader.readLine();
        OutputStream fileOutputStream = getOutputStream(destinationFileName);

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            fileOutputStream.write(data);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
    public static InputStream getInputStream(String fileName) throws IOException {
        return new FileInputStream(fileName);
    }
    public static OutputStream getOutputStream(String fileName) throws IOException {
        return new FileOutputStream(fileName);
    }
}

//Объясняю по-человечески.
//1) Следующей строкой после создания объекта BufferedReader объявляете ссылочную переменную
// типа InputStream:
//InputStream fileInputStream;
//
//Если переменную не объявить, в после try - в блоке while она не будет видна.
//
//2) Две строки по считыванию имени файла и чтению файла оборачиваете в try:
//String sourceFileName =...
// fileInputStream =...
//
//3) В catch (IOException e) выводим сообщение в консоль "Файл не существует",
// а также  повторно считываем имя файла и читаем его (то есть вставляем эти же две строки как в try)
//
//4) После блока catch идет дальнейший код данной программы - считывание из консоли
// имени файла для вывода, чтение файла в поток, блок while и т.д.
//String destinationFileName = reader.readLine();
//        OutputStream fileOutputStream = getOutputStream(destinationFileName);
//while ....