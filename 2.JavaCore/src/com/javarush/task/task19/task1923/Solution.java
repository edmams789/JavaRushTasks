package com.javarush.task.task19.task1923;

/* 
Слова с цифрами

В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со словами, разделенными пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.

Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать во второй файл все слова из первого файла которые содержат цифры
(используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        String line;
        while ((line = reader.readLine()) != null){
            String[] str = line.split(" ");
        for (String num : str) {
            if (num.matches(".*[0-9]+.*"))
                writer.write(num + " ");
        }
    }
        reader.close();
        writer.close();
        }
    }
//"C:\Users\Александр\Desktop\fileOne.txt"

//можно так)
//args = new String[]{"c:\\ww.txt", "c:\\1\\ww1.txt"};
//
////(там мои пути к файлам)

//if (s.matches(".*[0-9]+.*"))
//работает