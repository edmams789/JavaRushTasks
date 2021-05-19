package com.javarush.task.task08.task0813;

import java.util.Set;
import java.util.HashSet;

/* 
20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву "Л".

Требования:
1. Не изменяй заголовок метода createSet().
2. Программа не должна выводить текст на экран.
3. Программа не должна считывать значения с клавиатуры.
4. Метод createSet() должен создавать и возвращать множество (реализация HashSet).
5. Множество из метода createSet() должно содержать 20 слов на букву «Л».
*/

public class Solution {
    public static Set<String> createSet() {

        Set<String> set = new  HashSet<String>(); //напишите тут ваш код

        set.add("Локон");
        set.add("Луна");
        set.add("Локи");
        set.add("Лансароте");
        set.add("Любовь");
        set.add("Лимонад");
        set.add("Лагуна");
        set.add("Ловелас");
        set.add("Лабрадор");
        set.add("Лазурь");
        set.add("Лопасть");
        set.add("Лимон");
        set.add("Лист");
        set.add("Лаза");
        set.add("Латы");
        set.add("Лакомство");
        set.add("Летопись");
        set.add("Лампа");
        set.add("Лоск");
        set.add("Лувр");

        return set;
    }

    public static void main(String[] args) {

    }
}
// Set<String> set = new HashSet<String>() {{
//        for (int i = 0; i < 20; i++)
//        add("Л"+i);
//        }};

//for (int i = 0; i < 20; i++) {
//    set.add("Любовь"+i);
//}