package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова

1. Введи с клавиатуры 10 слов в список строк.

2. Метод doubleValues должен удваивать слова по принципу:
"альфа", "бета", "гамма" -> "альфа", "альфа", "бета", "бета", "гамма", "гамма"

3. Выведи результат на экран, каждое значение с новой строки.

Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Считай 10 строк с клавиатуры и добавь их в список.
3. Метод doubleValues должен удваивать элементы списка по принципу "альфа", "бета", "гамма" ->
"альфа", "альфа", "бета", "бета", "гамма", "гамма".
4. Выведи получившийся список на экран, каждый элемент с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // Считать строки с консоли и объявить ArrayList list тут

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }
        ArrayList<String> result = doubleValues(list);
        // Вывести на экран result
        for (int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
    }
    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        //напишите тут ваш код
        for (int i = 0; i < list.size(); i = i + 2) {
            list.add(i, list.get(i));
        }
        return list;
    }
}
//for (int i =0; i< list.size(); i=i+2) {
//            list.add(i, list.get(i));
//мозг раком встает, правильно ли я понял?
//Мы берем из индекса [0] "элемент" и вставляем рядом с этим индексом [0] тот же самый "элемент"
// в тот же самый массив, потом считаем шаг (i+=2), т.е. [0] индекс (это второй [0 ]индекс,
// который только что создали) , [1] индекс, берем элемент [1] индекса и вставляем рядом  с ним
// элемент [1] индекса из этого же массива, снова считаем шаг (i+=2): [1] индекс (это снова второй
// созданный индекс), [2] индекс, берем элемент [2] индекса .... и .т.д.
//Больше спросить некого, кто подскажет, правильно ли я разобрал эту строку кода?