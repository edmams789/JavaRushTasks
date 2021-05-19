package com.javarush.task.task26.task2603;

import java.util.Arrays;
import java.util.Comparator;
/*
Убежденному убеждать других не трудно
В таблице есть колонки, по которым можно сортировать.
Пользователь имеет возможность настроить под себя список колонок, которые будут сортироваться.
Напиши public static компаратор CustomizedComparator, который будет:
1. В конструкторе принимать массив компараторов.
2. Сортировать данные в порядке, соответствующем последовательности компараторов.
Все переданные компараторы сортируют дженерик тип Т.
В конструктор передается как минимум один компаратор.

Требования:
1. Класс Solution должен содержать public static компаратор CustomizedComparator.
2. Класс CustomizedComparator должен содержать приватное поле comparators типа Comparator<T>[].
3. Класс CustomizedComparator должен содержать конструктор с параметром vararg компараторов.
4. Метод compare() класса CustomizedComparator должен сравнивать объекты в порядке, соответствующем
последовательности компараторов comparators.
*/
public class Solution {

    public static void main(String[] args) {
    }

//    public static class CustomizedComparator<T> implements Comparator<T> { //
//
//        private Comparator<T>[] comparators;
//
//        public CustomizedComparator(Comparator<T>[]... comparators) {
//            this.comparators = comparators;
//        }
    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T t1, T t2) {
            return Arrays.stream(comparators)
                    .reduce((ttt1, ttt2) -> 0, Comparator::thenComparing)
                    .compare(t1, t2);
//Для тех, кто, как и я, захочет понять, что здесь написано, оставлю ссылку:
//https://stackoverflow.com/questions/25850008/how-to-chain-and-apply-a-stream-of-comparators
//
//Код красив!)
        }
    }
}
//Пояснение / Пример:
//
//У нас есть список people элементов: a, b, c ,d ....
//Пример элемента из списка : a ( String имя, int рост , Kids дети)
//У нас есть список comps компораторов, по которому надо сделать сортировку списка people.
//
//Что же делает Collections.sort(people, new CustomizedComparator(Comporator[] comps)) ?
//
//Он принимает список people и список comps, и делает следующее:
//1.	Берет первый компоратор из списка comps и сравнивает по нему элементы списка people.
//2.	Если по первому компоратору элементы равны, то берется след компоратор из списка comps и тд.