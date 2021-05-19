package com.javarush.task.task08.task0811;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Квартет «Методы»
Реализовать 4 метода.
Каждый из них должен возвращать список, который лучше всего подходит
для выполнения данных операций (быстрее всего справится с большим количеством операций).
Ничего измерять не нужно.

Требования:
1. Программа не должна выводить текст на экран.
2. Класс Solution должен содержать только 5 методов.
3. Метод getListForGet должен возвращать список,
который лучше всего подходит для операции взятия элемента.
4. Метод getListForSet должен возвращать список,
который лучше всего подходит для установки значения элемента.
5. Метод getListForAddOrInsert должен возвращать список,
который лучше всего подходит для операций добавления или вставки элемента.
6. Метод getListForRemove должен возвращать список,
который лучше всего подходит для операции удаления элемента.
*/

public class Solution {
    public static List getListForGet() {

        ArrayList<Solution> arrayList = new ArrayList<>();//напишите тут ваш код
        return arrayList;
    }
    public static List getListForSet() {

        ArrayList<Solution> arrayList = new ArrayList<>();//напишите тут ваш код
        return arrayList;
    }
    public static List getListForAddOrInsert() {

        LinkedList<Solution> linkedList = new LinkedList<>(); //напишите тут ваш код
        return linkedList;
    }
    public static List getListForRemove() {

        LinkedList<Solution> linkedList = new LinkedList<>(); //напишите тут ваш код
        return linkedList;
    }
    public static void main(String[] args) {

    }
}
