package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы из введённой строки.
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.
Пример ввода:
Мама мыла раму.

Пример вывода:
а а ы а а у
М м м л р м .


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить две строки.
3. Первая строка должна содержать только гласные буквы из введенной строки, разделенные пробелом.
4. Вторая строка должна содержать только согласные и знаки препинания из введенной строки,
разделенные пробелом.
5. Каждая строка должна заканчиваться пробелом.
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String s = new BufferedReader(new InputStreamReader(System.in)).readLine().replace(" ", "");
    String a = "", b = "";

    for (Character ch : s.toCharArray()) {
        if (isVowel(ch)) {
            a += ch + " ";
        } else {
            b += ch + " ";
        }
    }
    System.out.println(a);
    System.out.println(b);




 //       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   //     String s = reader.readLine();
     //   isVowel();
   //     char [] bf = reader.readLine().toCharArray();
   //     StringBuilder sb1 = new StringBuilder();
   //     StringBuilder sb2 = new StringBuilder();
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
//String s = new BufferedReader(new InputStreamReader(System.in)).readLine().replace(" ", "");
//    String a = "", b = "";
//
//    for (Character ch : s.toCharArray()) {
//        if (isVowel(ch)) {
//            a += ch + " ";//напишите тут ваш код
//        } else {
//            b += ch + " ";
//        }
//    }
//    System.out.println(a);
//    System.out.println(b);
//}


//В циклах рекомендуется использовать StringBuilder, а не String:
//
//Создаем символьный массив и присваиваем ему считанную из консоли строку,
// переведенную в массив символов ( bf.readLine().toCharArray(); ).
//
//Создаем два стрингбилдера ( StringBuilder sb1 = new StringBuilder(); и т.д. )
//Бежим при помощи foreach по массиву чаров, если isVovel:
//sb1.append(aChar).append(' ');
//еще если чар не пробел (else if (aChar!='  ')):
//sb2.append(aChar).append(' ');
//
//Выводим первый и второй стрингбилдер в консоль

//С пробелами помог метод для строк  replaceAll()