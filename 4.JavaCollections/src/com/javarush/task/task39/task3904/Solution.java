package com.javarush.task.task39.task3904;

import java.util.HashMap;

/* 
Лестница

Ребенок бежит по лестнице состоящей из N ступенек, за 1 шаг он может пройти одну, две или три ступеньки.

Реализуй метод numberOfPossibleAscents(int n), который вернет количество способов которыми ребенок может
пробежать всю лестницу состоящую из n ступенек.

P.S. Если лестница состоит из 0 ступенек - метод должен возвращать 1. Для n < 0 верни 0.

Требования:
1. Метод numberOfPossibleAscents должен возвращать количество способов прохождения лестницы из n ступенек.
2. Метод numberOfPossibleAscents должен возвращать 1 для n = 0.
3. Метод numberOfPossibleAscents должен возвращать 0 для n < 0.
4. Время выполнения метода numberOfPossibleAscents должно быть линейным.
*/
public class Solution {
    private static int n = 70;
    static HashMap<Integer, Long> map = new HashMap<>();

    static {
        map.put(0, 1L);
        map.put(1, 1L);
        map.put(2, 2L);
        map.put(3, 4L);
    }

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        if (n < 0)
            return 0;

        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            long fibonacciValue = ((numberOfPossibleAscents(n - 3) + numberOfPossibleAscents(n - 2)) + numberOfPossibleAscents(n - 1));
            map.put(n, fibonacciValue);
            return fibonacciValue;
        }
    }
}
//https://tproger.ru/problems/stairs/
