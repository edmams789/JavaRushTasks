package com.javarush.task.task26.task2601;

import java.util.Arrays;

/*
Почитать в инете про медиану выборки
Реализуй логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы.
Верни отсортированный массив от минимального расстояния до максимального.
Если удаленность одинаковая у нескольких чисел, то сортируй их в порядке возрастания.

Пример входящего массива:
13, 8, 15, 5, 17
медиана - 13

Отсортированный масив:
13, 15, 17, 8, 5


Требования:
1. Программа не должна выводить текст в консоль.
2. Программа не должна считывать данные с консоли.
3. Класс Solution должен содержать публичный статический метод Integer[] sort(Integer[] array).
4. Метод sort(Integer[] array) класса Solution должен сортировать данные в массиве по удаленности
от его медианы.
*/
public class Solution {

    public static void main(String[] args) {
    }
    public static Integer[] sort(Integer[] array) {
        //implement logic here
        int median;
        Arrays.sort(array);
        if (array.length % 2 == 0) median = (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        else median = array[array.length / 2];
        Arrays.sort(array,(x,y) -> Integer.compare(Math.abs(median - x), Math.abs(median - y)));
        return array;
    }
}
//К комментариям Игоря и Karahanid:
//Работает медиана как с double, так и с int.
//public static Integer[] sort(Integer[] array) {
//        //Находим медиану
//              //Сортируем массив из параметра
//        int median;
//        Arrays.sort(array);
//              //Если массив с четным колличеством элементов
//        if (array.length%2==0) median = (array[array.length/2] + array[array.length/2-1])/2;
//              //И если с нечетным
//        else median = array[array.length/2];
//
//        //Сортируем по условию
//        Arrays.sort(array,(x,y)->Integer.compare(Math.abs(median-x), Math.abs(median-y)));
//        return array;
//    }
//
//Вывод с int: {2, 1, 1, 3, 4, 5}  и задачу принимает.