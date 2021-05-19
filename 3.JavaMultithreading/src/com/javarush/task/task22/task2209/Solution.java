package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Составить цепочку слов
В методе main считай с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставь все слова в таком порядке, чтобы последняя буква
данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Считай, что абсолютно все слова из исходного списка могут (и должны!) быть включены в результат
(лишних слов нет).
Метод getLine должен возвращать любой правильный вариант при наличии нескольких таковых (см. пример).
Слова разделять пробелом.
Вывести полученную строку на экран.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
или
Вена Амстердам Мельбурн Нью-Йорк Киев
или
Мельбурн Нью-Йорк Киев Вена Амстердам
и т.п.


Требования:
1. Метод main должен считывать имя файла с клавиатуры.
2. В классе Solution не должно быть статических полей.
3. В методе getLine должен быть использован StringBuilder.
4. Метод getLine должен возвращать пустую строку (пустой StringBuilder) в случае если ему не были
переданы параметры (слова).
5. Метод getLine не должен изменять переданные ему параметры (слова).
6. Все слова переданные в метод getLine должны быть включены в результирующую строку.
7. Вывод на экран должен соответствовать условию задачи.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder();
        while (br.ready()){
            sb.append(br.readLine() + " ");
            String[] str = sb.toString().trim().split(" ");
            for (String s : str){

            }
        }

        StringBuilder result = getLine();
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

          return null;
    }
}
//C:\Users\Александр\Desktop\fileTwo.txt

//Collections.sort(list);
//
//        for (int j=0 ; j<list.size();j++) {
//            for (int i = j+1; i < list.size(); i++) {
//                if ( list.get(j).charAt(list.get(j).length()-1) == list.get(i).toLowerCase().charAt(0)    ) {
//                    String s = list.get(j+1);
//                    list.set(j+1, list.get(i));
//                    list.set(i, s);
//                }
//            }
//        }