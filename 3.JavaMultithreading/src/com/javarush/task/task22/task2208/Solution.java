package com.javarush.task.task22.task2208;

import java.util.Map;

/* 
Формируем WHERE
Сформируй часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.

Пример:
{name=Ivanov, country=Ukraine, city=Kiev, age=null}

Результат:
name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'


Требования:
1. Метод getQuery должен принимать один параметр типа Map.
2. Метод getQuery должен иметь тип возвращаемого значения String.
3. Метод getQuery должен быть статическим.
4. Метод getQuery должен возвращать строку сформированную по правилам описанным в условии задачи.
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String getQuery(Map<String, String> params) {

        StringBuilder sb = new StringBuilder();
        params.entrySet().stream()
                .filter(pair ->
                        pair.getKey() != null
                                &&  pair.getValue() != null
                                && !pair.getKey().isEmpty()
                                && !pair.getValue().isEmpty()
                ).forEach(pair ->
                sb.append(pair.getKey())
                        .append(" = '")
                        .append(pair.getValue())
                        .append("' and ")
        );
        int len = sb.length();
        sb.setLength(len > 4 ? len-5 : 0);
        return sb.toString();
    }
}
//Суть условия не сразу понял.
//Расскажу, кто тоже зашёл сюда за разъяснением условия:
//
//По сути нужно всю мапу (переданную в getQuery) вывести в одну строку, где пары разделены словом and
//И пары из мапы надо выводить в формате как в задании:
//Ключ = 'значение'  (это одиночные опострофы, а не ковычки)
//
//Тот образец в задании короткий. Если в мапе будет много пар, результирующая строка соответственно будет длиннее.
//
//В результат не должны входить пары содержащие: пустые ключ или пустые значения

//Задачка непойми на что.
//public static String getQuery(Map<String, String> params) {
//        StringBuilder where = new StringBuilder();
//        for (String key:params.keySet()) {
//            if (params.get(key) != null) {
//                where.append(key + " = '"+ params.get(key)+"' and ");
//            }
//        }
//        if (where.length()>0)  return where.substring(0, where.length() -5);
//        return "";
//    }

//Это нас плавно подводят к  sql запросам)))
//https://help.anylogic.ru/index.jsp?topic=%2Fcom.anylogic.help%2Fhtml%2Fconnectivity%2FQuerying.html