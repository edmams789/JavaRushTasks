package com.javarush.task.task19.task1908;

/* 
Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8ю 1

Результат:
12 14 1


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором
принимающим FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл все числа, через пробел, из первого файла
(используй BufferedWriter с конструктором FileWriter).
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = reader.readLine();
        String fileTwo = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(fileOne);
        FileWriter fileWriter = new FileWriter(fileTwo);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String line;
        while ((line = bufferedReader.readLine()) != null){
            String[] numbers = line.split(" ");
            for (String num : numbers){
                if (num.matches("[0-9]+"))
                    bufferedWriter.write(num + " ");
            }
            bufferedReader.close();
            bufferedWriter.close();
        }
        fileReader.close();
        fileWriter.close();
    }
}
