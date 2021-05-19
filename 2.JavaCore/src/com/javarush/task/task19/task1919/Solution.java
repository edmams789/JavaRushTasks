package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты

В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
Закрыть потоки.

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль каждое имя и сумму всех его значений, все данные должны быть
отсортированы в возрастающем порядке по имени.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> wage = new TreeMap<>();


        while (reader.ready()){

            String[] str = reader.readLine().split(" ");
            //if (str.length < 2) continue;
            if (wage.containsKey(str[0])){
   //             m.put(s[0], m.get(s[0])+Double.parseDouble(s[1]));
                wage.put(str[0], wage.get(str[0]) + Double.parseDouble(str[1]));
            } else
                wage.put(str[0], Double.parseDouble(str[1]));
        }
            for (Map.Entry<String, Double> pair : wage.entrySet()){
                System.out.println(pair.getKey() + " " + pair.getValue());
            }
            reader.close();

    }
}
//вывод map, чтобы еще короче
//m.forEach((k, v) -> System.out.println(k + " " + v));
//вместо
//for (Map.Entry<String, Double> entry: m.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }

