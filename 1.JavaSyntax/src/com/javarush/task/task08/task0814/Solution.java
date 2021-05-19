package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.

Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только три метода.
4. Метод createSet() должен создавать и возвращать множество HashSet состоящих из 20 различных чисел.
5. Метод removeAllNumbersGreaterThan10() должен удалять из множества все числа больше 10.
*/

public class Solution {

    public static HashSet<Integer> createSet() {

        HashSet<Integer> set = new HashSet<Integer>();

        set.add(14);
        set.add(18);
        set.add(1);
        set.add(124);
        set.add(4);
        set.add(314);
        set.add(3);
        set.add(8);
        set.add(194);
        set.add(147);
        set.add(19);
        set.add(15);
        set.add(514);
        set.add(114);
        set.add(7);
        set.add(2);
        set.add(6);
        set.add(11);
        set.add(178);
        set.add(436);

        return set;

    }// напишите тут ваш код

    public static HashSet<Integer> removeAllNumbersGreaterThan10(HashSet<Integer> set) {

        Iterator<Integer> integerIterator = set.iterator();

        while (integerIterator.hasNext()) {

            Integer nextInt = integerIterator.next();

            if (nextInt > 10)

                integerIterator.remove();
        }
            return set;
    } // напишите тут ваш код

    public static void main(String[] args) {
    }
}
//      for (int i = 0; i < 20; i++) {
//      set.add(1 + i);
//      }