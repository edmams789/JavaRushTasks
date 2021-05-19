package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/* 
Добрая Зинаида и летние каникулы

Создать словарь (Map<String, Date>) и занести в него десять записей по принципу:
"фамилия" - "дата рождения".
Удалить из словаря всех людей, родившихся летом.

Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь HashMap
с типом элементов String, Date состоящий из 10 записей.
4. Метод removeAllSummerPeople() должен удалять из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {

        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);

        HashMap<String, Date> map = new HashMap<String, Date>();

        map.put("Stallone", df.parse("JULY 6 1946"));
        map.put("Schwarzenegger", df.parse("JULY 30 1947"));
        map.put("Lundgren", df.parse("NOVEMBER 3 1957"));
        map.put("Statham", df.parse("JULY 26 1967"));
        map.put("Willis", df.parse("MARCH 19 1955"));
        map.put("Gibson", df.parse("JANUARY 3 1956"));
        map.put("Cruise", df.parse("JULY 3 1962"));
        map.put("Chan", df.parse("APRIL 7 1954"));
        map.put("Norris", df.parse("MARCH 10 1940"));
        map.put("Ford", df.parse("JULY 13 1942"));

        System.out.println(map.size());

        return map;//напишите тут ваш код

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {





        //напишите тут ваш код

    }

    public static void main(String[] args) {

    }
}
