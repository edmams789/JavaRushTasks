package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

/* 
Использование TreeSet
Первым параметром приходит имя файла: файл1.
файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
Отсортируй буквы по алфавиту и выведи на экран первые 5 различных букв в одну строку без разделителей.
Если файл1 содержит менее 5 различных букв, то выведи их все.
Буквы различного регистра считаются одинаковыми.
Регистр выводимых букв не влияет на результат.
Закрой потоки.

Пример 1 данных входного файла:
zBk yaz b-kN

Пример 1 вывода:
abkny

Пример 2 данных входного файла:
caAC
A, aB? bB

Пример 2 вывода:
abc

Подсказка: использовать TreeSet

Требования:
1. Программа должна использовать класс TreeSet.
2. У объекта типа TreeSet вызови метод add для добавления элементов.
3. Программа должна выводить результат на экран.
4. Вывод программы должен соответствовать условию задачи.
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        TreeSet<Character> letters = new TreeSet<>();
        String fileName = args[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            while (reader.ready()){
                String str = reader.readLine().toLowerCase().replaceAll("[^\\p{Alpha}]","");
                for (int i = 0; i < str.length(); i++)
                    letters.add(str.charAt(i));
            }
        }
        Iterator<Character> iterator = letters.iterator();
        int n = letters.size() < 5 ? letters.size() : 5;

        for (int i = 0; i < n; i++){
            System.out.print(iterator.next());
        }
    }
}
//        TreeSet<String> treeSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
//        Stream<String> stream = reader.lines();
//
//        treeSet.addAll(stream.map(s -> s.split(" "))
//                .flatMap(Arrays::stream)
//                .filter(c -> c.matches("[A-Za-z]"))
//
//                .collect(Collectors.toSet()));
//
//        treeSet.stream().limit(5).forEach(System.out::print);
