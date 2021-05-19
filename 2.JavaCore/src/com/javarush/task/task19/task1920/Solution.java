package com.javarush.task.task19.task1920;

/* 
Самый богатый

В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров

Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль имена, у которых максимальная сумма.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> wage = new TreeMap<>();

        while (reader.ready()) {
            String[] str = reader.readLine().split(" ");

//containsKey(Object key) — проверяет, существует ли в массиве элемент с ключом key;
            if (wage.containsKey(str[0])){
                wage.put(str[0], wage.get(str[0]) + Double.parseDouble(str[1]));
            } else
                wage.put(str[0], Double.parseDouble(str[1]));
        }
        double maxValue = Collections.max(wage.values()); //дублирование со следующим кодом

        for (Map.Entry<String, Double> pair : wage.entrySet()){
            if (maxValue < pair.getValue())
                maxValue = pair.getValue();
        }
            for (Map.Entry<String, Double> pair : wage.entrySet()) {
                if (pair.getValue().equals(maxValue))
                    System.out.println(pair.getKey());
            }
            reader.close();
        }
    }

