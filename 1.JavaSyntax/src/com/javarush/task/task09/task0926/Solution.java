package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
Создать список, элементами которого будут массивы чисел.
Добавить в список пять объектов-массивов длиной 5, 2, 4, 7, 0 соответственно.
Заполнить массивы любыми данными и вывести их на экран.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Метод createList должен объявлять и инициализировать переменную типа ArrayList<int[]>.
3. Метод createList должен возвращать созданный список.
4. Метод createList должен добавлять в список 5 элементов.
5. Каждый элемент в списке должен быть массивом чисел.
Длина первого должна быть 5 элементов, второго - 2, следующих - 4, 7, 0 соответственно.
6. Программа должна выводить на экран элементы всех массивов из списка. Каждый элемент с новой строки.
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> myList = new ArrayList<>();
        int[] a = {2, 5, 8, 7, 3};
        myList.add(a);
        int[] b = {3, 8};
        myList.add(b);
        int[] c = {11, 9, 78, 16};
        myList.add(c);
        int[] d = {5, 9, 15, 62, 75, 3, 1};
        myList.add(d);
        int[] e = {};
        myList.add(e);

        return myList;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
