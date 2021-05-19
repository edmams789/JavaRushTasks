package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты

Читайте с консоли имена файлов, пока не будет введено слово "exit".
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз,
и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
2. Для каждого файла создай нить ReadThread и запусти ее.
3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
4. Затем нити должны найти максимально встречающийся байт в своем файле
и добавить его в словарь resultMap.
5. Поток для чтения из файла в каждой нити должен быть закрыт.
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        while (!fileName.equals("exit")){
            ReadThread readThread = new ReadThread(fileName);
            readThread.start();
            readThread.join();
            fileName = reader.readLine();
        }
    }
    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) throws IOException {
            //implement constructor body
            this.fileName = fileName;
            FileInputStream inputStream = new FileInputStream(fileName);
            while (inputStream.available() > 0) list.add(inputStream.read());
            inputStream.close();
        }
        // implement file reading here - реализуйте чтение из файла тут

        ArrayList<Integer> list = new ArrayList<>();

        @Override
        public void run(){
            int element = list.get(0);
            for (Integer x : list)
                if (Collections.frequency(list, x) > Collections.frequency(list, element))
                    element = x;
                resultMap.put(fileName, element);
        }
    }
}
//for (String fileName = reader.readLine(); !fileName.equals("exit"); fileName = reader.readLine())
//
//Избавляет от лишних трех строк :)