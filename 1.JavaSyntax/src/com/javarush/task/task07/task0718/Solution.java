package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
1. Введи с клавиатуры 10 слов в список строк.
2. Определить, является ли список упорядоченным по возрастанию длины строки.
3. В случае отрицательного ответа вывести на экран индекс первого элемента,
нарушающего такую упорядоченность.

Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Считай 10 строк с клавиатуры и добавь их в список.
3. Если список упорядочен по возрастанию длины строки, то ничего выводить не нужно.
4. Если список не упорядочен по возрастанию длины строки,
то нужно вывести на экран индекс первого элемента, нарушающего такую упорядоченность.
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            String s = reader.readLine();
            list.add(s);
        }
        int max = list.get(0).length();

        for (int j = 1; j <= list.size(); j++)

        if (max > list.get(j).length()){

        System.out.println(list);  //(list.get(j).length()); - выводится размер
                                                   // первой строки которая короче предыдущей
        break;

        } else if (list.get(0).length() <= list.get(j).length()){
         return;

}        else {
         max = list.get(j).length();
}
//напишите тут ваш код
    }
}
//Если список не упорядочен по возрастанию длины строки,
// то нужно вывести на экран индекс первого элемента, нарушающего такую упорядоченность.


//дедушка
//бабушка
//папа
//мама
//сын
//дочь
//коты
//собака
//программа
//машина