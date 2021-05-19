package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
Создать словарь (Map<String, String>) занести в него десять записей по принципу "фамилия" - "имя".
Удалить людей, имеющих одинаковые имена.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь HashMap
с типом элементов String, String состоящих из 10 записей.
4. Метод removeTheFirstNameDuplicates() должен удалять из словаря всех людей,
имеющие одинаковые имена.
5. Метод removeTheFirstNameDuplicates() должен вызывать метод removeItemFromMapByValue().
*/

public class Solution {
    public static HashMap<String, String> createMap() {

        HashMap<String, String> map = new HashMap<String, String>();

        map.put("She", "Charley");
        map.put("Wilkinson", "Tom");
        map.put("Rit", "Guy");
        map.put("Sheen", "Sam");
        map.put("Cruise", "Tom");
        map.put("Food", "Megan");
        map.put("Rid", "Guy");
        map.put("Heen", "Megan");
        map.put("Fox", "Samantha");
        map.put("Ritchie", "Charley");
        //напишите тут ваш код
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {


        //напишите тут ваш код
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();

            String key = pair.getKey();
            String value = pair.getValue();

            removeItemFromMapByValue(map, value);
        }
//
//        while (integerIterator.hasNext()) {
//
//            Integer nextInt = integerIterator.next();
//
//            if (nextInt > 10)
//
//                integerIterator.remove();
//        }

//Всё решается очень просто при помощи двух итераторов.
//Инициализируете один. Начинаете цикл. В цикле инициализируете второй итератор первым.
// И проходите по Map.
//Только нужно помнить, что метод .next() итератора сдвинет его вперёд после выполнения.
// По-этому чтобы первый итератор стоял на месте, пока второй проверяет значения в Map,
// нужно значение .value()  первого итератора хранить в переменной String temp.
// Если значение .next().getValue() второго итератора такое же, то удаляем второй итератор.
// И, кстати, после удаления второго итератора, просто удалить первый не получится -
// будет ошибка памяти. Его надо будет заново инициализировать.
//А так, принцип работы цикла в цикле. Как по обычному массиву, только с помощью итераторов.

//    } // напишите тут ваш код
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
