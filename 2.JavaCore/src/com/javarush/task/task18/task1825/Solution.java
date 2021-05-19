package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл

Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ...,
в конце - последнюю.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
3. В новый файл перепиши все байты из файлов-частей *.partN.
4. Чтение и запись должны происходить с использованием буфера.
5. Созданные для файлов потоки должны быть закрыты.
6. Не используй статические переменные.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        TreeSet<String> treeSet = new TreeSet<>();
        while (!fileName.equals("end"))
            treeSet.add(fileName);
            FileOutputStream fileOutputStream =
                    new FileOutputStream(treeSet.first().substring(0, treeSet.first().lastIndexOf(".part")));
            for (String s : treeSet){
            //    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(s));
                FileInputStream fileInputStream = new FileInputStream(s);
               // byte[] buffer = new byte[bufferedInputStream.available()];
                byte[] buffer = new byte[fileInputStream.available()];
               // bufferedInputStream.read(buffer);
                fileInputStream.read(buffer);
                fileOutputStream.write(buffer);
              //  bufferedInputStream.close();
                fileInputStream.close();
            }
            fileOutputStream.close();
    }
}
//опытным путем получено:
//1.Файл создавать не надо(newFile.createNewFile() не проходит валидатор),
// надо просто открыть поток вывода и в конструктор передать нужное имя конечного файла
//2.Через arraylist и Collections.sort() прекрасно сработало.
//3.Создал поток вывода так:
//FileOutputStream outputStream = new FileOutputStream(filePart.get(0).split(".part")[0]);
//прямо в конструкторе получив нужную часть строки,где filePart это ArrayList с именами файлов.
// Видел об этом комментарии ниже.
//Успехов.