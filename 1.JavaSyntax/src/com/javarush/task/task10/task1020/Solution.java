package com.javarush.task.task10.task1020;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Задача по алгоритмам
Задача: ввести с клавиатуры 30 чисел. Вывести 10-е и 11-е минимальные числа.
Пояснение:
Самое минимальное число - 1-е минимальное.
Следующее минимальное после него - 2-е минимальное

Пример:
1 6 5 7 1 15 63 88
Первое минимальное - 1
Второе минимальное - 1
Третье минимальное - 5
Четвертое минимальное - 6


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить текст на экран.
3. Класс Solution должен содержать два метода.
4. Метод sort() должен сортировать массив элементов.
5. Метод main() должен вызывать метод sort().
6. Программа должна выводить 10-е и 11-е минимальные числа. Каждое значение с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[30];
        for (int i = 0; i < 30; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[9]);
        System.out.println(array[10]);
    }

    public static void sort(int[] array) {
        //напишите тут ваш код
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    changed = true;
                }}}
        for (int i = 0; i < array.length; i++) {


        }

    }
}
//public class SortArray
//{
//    public static void main(String[] args) {
//        int[] sample = {12, 56, 7, 34, 89, 43, 23, 9};
//
//        // выставляем признак "обмена" переменных в true, чтобы начать цикл
//        boolean changed = true;
//
//        // цикл длится до тех пор, пока при проверке массива ни одного обмена не произошло
//        while (changed) {
//
//            // Надеемся, что обмена данных не будет
//            changed = false;
//
//            // Проходим по всему массиву
//            for (int i = 0; i < sample.length - 1; i++) {
//
//                // Если впереди стоящее число больше, чем следующее - меняем
//                // их местами и выставляем признак, что был обмен
//                if (sample[i] > sample[i + 1]) {
//
//                    // Производим обмен с использованием дополнительной переменной
//                    int tmp = sample[i];
//                    sample[i] = sample[i + 1];
//                    sample[i + 1] = tmp;
//
//                    // Выставляем признак обмена в true
//                    changed = true;
//                }}}
//
//        // Выводим отсортрованный массив
//        for (int i = 0; i < sample.length; i++) {
//            System.out.println(sample[i]);
//        }}}