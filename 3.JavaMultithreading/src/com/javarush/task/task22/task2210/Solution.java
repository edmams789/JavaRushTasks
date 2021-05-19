package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.

Пример
getTokens("level22.lesson13.task01", ".")

возвращает массив строк
{"level22", "lesson13", "task01"}

Требования:
1. Метод getTokens должен использовать StringTokenizer.
2. Метод getTokens должен быть публичным.
3. Метод getTokens должен принимать два параметра типа String.
4. Массив типа String возвращенный методом getTokens должен быть заполнен правильно(согласно условию задачи).
*/
public class Solution {
    public static void main(String[] args) {
    }
    public static String [] getTokens(String query, String delimiter) {

        ArrayList<String> token = new ArrayList<>();

        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        while (tokenizer.hasMoreTokens())
        {
            token.add(tokenizer.nextToken());

        }
        return token.toArray(new String[0]);
    }
}

//Чем это
//return query.trim().split(delimited);
//
//лучше этого
//ArrayList<String> tokens = new ArrayList<>();
//       StringTokenizer strT = new StringTokenizer(query,delimiter);
//       while (strT.hasMoreTokens()){
//           tokens.add(strT.nextToken());
//       }
//       return tokens.toArray(new String[0])

//Зашёл сюда чтоб написать ровно тоже самое.
//
//Если нам надо разделить ВСЮ строку, зачем использовать ПОЭТАПНОЕ разделение?

//split(".") понимает как регулярку, а не как символ!

//задача подозрительно легко решилась....
//может кому пригодится http://pro-java.ru/java-dlya-nachinayushhix/klass-stringtokenizer-primery-ispolzovaniya-v-java/