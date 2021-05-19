package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;

/* 
Перепись населения
Создать словарь (Map<String, String>) занести в него десять записей по принципу "Фамилия" - "Имя".
Проверить сколько людей имеют совпадающие с заданным именем или фамилией.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь HashMap
с типом элементов String, String состоящих из 10 записей по принципу «Фамилия» - «Имя».
4. Метод getCountTheSameFirstName() должен возвращать число людей у которых совпадает имя.
5. Метод getCountTheSameLastName() должен возвращать число людей у которых совпадает фамилия.
*/

public class Solution {
    public static HashMap<String, String> createMap() {

        HashMap<String, String> map = new HashMap<String, String>();

        map.put("Sheen", "Charley");
        map.put("Wilkinson", "Tom");
        map.put("Ritchie", "Guy");
        map.put("Sheen", "Sam");
        map.put("Cruise", "Tom");
        map.put("Fox", "Megan");
        map.put("Ritchie", "Guy");
        map.put("Sheen", "Megan");
        map.put("Fox", "Samantha");
        map.put("Ritchie", "Charley");

        return createMap();
        //напишите тут ваш код

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {

for (HashMap.Entry<String, String> pair : map.entrySet()){
    String key = pair.getKey();


    System.out.println(key);

 //   String value = pair.getValue();
}

        //напишите тут ваш код
return getCountTheSameLastName(map, name);
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {



        return getCountTheSameLastName(map,lastName);
        //напишите тут ваш код

    }

    public static void main(String[] args) {

    }
}
//public class Solution {
//    public static void main(String[] args) throws Exception {
//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("Sim", "Sim");
//        map.put("Tom", "Tom");
//        map.put("Arbus", "Arbus");
//        map.put("Baby", "Baby");
//        map.put("Cat", "Cat");
//        map.put("Dog", "Dog");
//        map.put("Eat", "Eat");
//        map.put("Food", "Food");
//        map.put("Gevey", "Gevey");
//        map.put("Hugs", "Hugs");
//
//        printValues(map);
//    }
//    public static void printValues(Map<String, String> map) {
//
//        for (Map.Entry<String, String> pair : map.entrySet()) {
//            String value = pair.getValue();
//            System.out.println(value); //напишите тут ваш код
//        }}}