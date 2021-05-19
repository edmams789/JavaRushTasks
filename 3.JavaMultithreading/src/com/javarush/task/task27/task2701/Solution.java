package com.javarush.task.task27.task2701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Избавляемся от меток
Избавьтесь от меток в методе isSubstringPresent сохранив логику.
Метод возвращает true, в случае если строка substring является подстрокой строки string, иначе false.
В коде должны отсутствовать операторы break и continue.

Требования:
1. Метод isSubstringPresent должен возвращать true, если строка substring является подстрокой
строки string.
2. Метод isSubstringPresent должен возвращать false, если строка substring НЕ является подстрокой
строки string.
3. В методе isSubstringPresent должны отсутствовать операторы break.
4. В методе isSubstringPresent должны отсутствовать операторы continue.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String substring = reader.readLine();

        if (isSubstringPresent(substring, string)) {
            System.out.println("String: \n" + substring + "\nis present in the string: \n" + string);
        } else {
            System.out.println("String: \n" + substring + "\nis not present in the string: \n" + string);
        }
    }
    static boolean isSubstringPresent(String substring, String string) {
        boolean found = false;
        int max = string.length() - substring.length();

        for (int i = 0; i <= max; i++) {
            int length = substring.length();
            int j = i;
            int k = 0;
            while (length-- != 0) {
                if (string.charAt(j++) != substring.charAt(k++)) {
                }
            }
            found = true;
        }
        return string.contains(substring);
    }
}
//static boolean isSubstringPresent(String substring, String string) {
//        for (int i = 0; i <= string.length()-substring.length(); i++)
//            for (int j = i; string.charAt(j)==substring.charAt(j-i) ; j++)
//                if (j==i+substring.length()-1) return true;
//        return false;
//    }

//Метод charAt() — возвращает символ, расположенный по указанному индексу строки.
// Индексы строк в Java начинаются с нуля.
//Синтаксис метода: public char charAt(int index)