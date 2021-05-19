package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.

Пример ввода:
5
8
-2
11
3
-5
2
10

Пример вывода:
-2
2
8
10


Требования:
1. Программа должна считывать данные с консоли.
2. Программа должна создавать FileInputStream для введенной с консоли строки.
3. Программа должна выводить данные на экран.
4. Программа должна вывести на экран все четные числа считанные из файла отсортированные по возрастанию.
5. Программа должна закрывать поток чтения из файла(FileInputStream).
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
        InputStream inputStream = new FileInputStream(reader.readLine());


        while(inputStream.available() > 0) {
  //          if (Integer.parseInt(reader.readLine()) % 2 == 0) {
                  //        list.add(Integer.parseInt(reader.readLine());
  //          }

            System.out.write((int) inputStream.read());
        }
        int data = inputStream.read();

        if (data % 2 == 0)
            if ((int) inputStream.read() % 2 == 0)
                System.out.println(data);

        inputStream.close();
    }
}
//int t = Integer.parseInt(reader.readLine());


// InputStream inStream = new FileInputStream("c:/my-object-data.txt");
//BufferedReader fileStream = new BufferedReader(new InputStreamReader(new FileInputStream(bufferedReader.readLine())));