package com.javarush.task.task36.task3611;

import java.util.HashSet;
import java.util.Set;

/* 
Сколько у человека потенциальных друзей?

Сегодня рассмотрим часть функционала социальных сетей. Откуда сеть знает, каких людей предлагать тебе
в друзья, которых ты можешь знать? Эту задачу легко решить с помощью графов.

Твоя задача реализовать метод Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep),
который возвращает индексы людей, которые у тебя в друзьях уже есть и которых ты можешь знать.
После этого отработает метод removeFriendsFromSet, и результат этого метода - это все потенциальные
друзья человека с индексом index и глубиной поиска deep.
Для упрощения будем рассматривать связи всех людей как двумерный массив humanRelationships
(смотри пример массива в методе generateRelationships). По главной диагонали все элементы true,
так как это один и тот же человек. Пересечение столбца и столбика указывает, добавлены ли люди друг у
друга в друзья (если true - то люди есть друг у друга в друзьях). Если человек с индексом k добавлен в
друзья к человеку с индексом p, это означает, что у человека с индексом p в друзьях есть человек с индексом k.

В метод передается два аргумента:
int index - это индекс человека в массиве (начиная с нуля);
int deep - глубина поиска друзей. Если Маша в друзьях у Наташи и у Маши в друзьях есть Оля,
при глубине поиска = 1, для Наташи нужно добавить в результирующее множество Машу и как потенциального
друга Олю. Если глубина поиска = 2, в это же множество нужно добавить еще и всех, с кем дружит Оля.
Смотри пример в методе main.
В множестве, которое возвращает метод getAllFriendsAndPotentialFriends не должно быть индекса index.

Требования:
1. В классе Solution должен существовать публичный метод
Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep).
2. В классе Solution должно быть объявлено приватное поле boolean[][] humanRelationships.
3. В множестве, которое возвращает метод getAllFriendsAndPotentialFriends не должно быть индекса index.
4. Метод getAllFriendsAndPotentialFriends должен быть реализован согласно условию.
*/

public class Solution {
    private boolean[][] humanRelationships;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.humanRelationships = generateRelationships();

        Set<Integer> allFriendsAndPotentialFriends = solution.getAllFriendsAndPotentialFriends(4, 2);
        System.out.println(allFriendsAndPotentialFriends);                              // Expected: [0, 1, 2, 3, 5, 7]
        Set<Integer> potentialFriends = solution.removeFriendsFromSet(allFriendsAndPotentialFriends, 4);
        System.out.println(potentialFriends);                                           // Expected: [2, 5, 7]
    }

    public Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep) {
        //напишите тут ваш код
        Set<Integer> result = new HashSet<>();
        if (deep == 0) return result;
        for (int i = 0; i < humanRelationships.length; i++) {
            if (i < index) {
                if (humanRelationships[index][i]) {
                    result.add(i);
                    result.addAll(getAllFriendsAndPotentialFriends(i, deep - 1));
                }
            } else {
                if (humanRelationships[i][index]) {
                    result.add(i);
                    result.addAll(getAllFriendsAndPotentialFriends(i, deep - 1));
                }
            }
        }
        result.remove(index);
        return result;
    }

/*
Сразу начал решать через рекурсию...
Решение в 11 строк...

Алгоритм:
1. Создаем сет.
2. Если deep > 0
       2.1 Цикл от i = 0 до длины humansRelationships
           2.2.1 Если (i < index и  элемент [index][i] == true)
               - кладем в сет индекс столбца проверяемого элемента -> i
               - кладем в сет (set.addAll) рекурсивный вызов getAllFriendsAndPotentialFriends(индекс столбца
                 проверяемого элемента, deep - 1)
           2.2.2 Иначе если (i > index и  элемент [i][index] == true)
               - кладем в сет индекс строки проверяемого элемента -> i
               - кладем в сет (set.addAll) рекурсивный вызов - getAllFriendsAndPotentialFriends(индекс строки
                 проверяемого элемента, deep - 1)
3. Удаляем index из сета.
4. return сет
 */

/*
Решил без рекурсии, с помощью двусторонней очереди.

Алгоритм вкратце таков:

1. Создаём трисет куда будем класть индексы друзей, друзей друзей и т.д.
2. Создаем двустороннюю очередь, кладём туда индекс из аргументов метода
3.Создаём  цикл for с 0 по deep
4. В нём создаём локальную переменную dequeSize размера очереди, т.к. размер будет меняться динамически
5.  Создаём внутри цикл while пока dequeSize>0
6. Внутри вытаскиваем первый элемент из очереди, это по сути индекс того для кого в данный момент ищем друзей, dequeSize--
7.  Двумя циклами ищем всех друзей для индекса который достали из очереди.  В первом проходим по подмассиву с 0 по length -1 и если ячейка true и не равна индексу из аргументов метода кладём i в treeset и добавляем его в очередь. Во втором цикле проходимся по оставшимся массивам с индекса который достали на 6 шаге до конца(кроме того, который указан в аргументе метода) и ищем, содержат ли они в ячейке с индексом из 6 шага true и , если да, то также добавляем в treeSet и очередь.

Кратко не получилось, надеюсь кому - то поможет)
 */

    // Remove from the set the people with whom you already have a relationship
    //Уберите из набора людей, с которыми у вас уже есть отношения
    public Set<Integer> removeFriendsFromSet(Set<Integer> set, int index) {
        for (int i = 0; i < humanRelationships.length; i++) {
            if ((i < index) && (index < humanRelationships.length) && humanRelationships[index][i]) {
                set.remove(i);
            } else if ((i > index) && humanRelationships[i][index]) {
                set.remove(i);
            }
        }
        return set;
    }

    // Return test data
    private static boolean[][] generateRelationships() {
        return new boolean[][]{
                {true},                                                                 //0
                {true, true},                                                           //1
                {false, true, true},                                                    //2
                {false, false, false, true},                                            //3
                {true, true, false, true, true},                                        //4
                {true, false, true, false, false, true},                                //5
                {false, false, false, false, false, true, true},                        //6
                {false, false, false, true, false, false, false, true}                  //7
        };
    }
}