package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв
(для 33 маленьких букв алфавита). Результат вывести на экран в алфавитном порядке.

Пример вывода:
а 5
б 8
в 3
г 7
д 0
...
я 9


Требования:
1. Программа должна 10 раз считывать данные с клавиатуры.
2. Программа должна выводить текст на экран.
3. Выведенный текст должен содержать 33 строки.
4. Каждая строка вывода должна содержать букву русского алфавита,
пробел и сколько раз буква встречалась в введенных строках.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        // напишите тут ваш код
        for (char x : alphabet) {
        int count = 0;
        for (String s : list) {
        for (char y : s.toCharArray()) {
           if (y == x) count++;
        }
    }
            System.out.println(x + " " + count);

}
//        for (int i = 0, j = 0; i < 33; i++) {
  //          String s1 = abc.substring(i, i + 1);
    //        System.out.println(s1 + " " + j);
      //  }
    }
}
//for (Character x : alphabet) {
//    int count = 0;
//    for (String s : list) {
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i)==x) count++;
//        }
//    }
//    System.out.println(x + " " + count);
//}

// for (char x : alphabet){
//            int counter = 0;
//            for (String s : list){
//                for (char y : s.toCharArray()){
//                    if (y == x){counter++;}
//                }
//            }
//            System.out.println(x + " " + counter);
//        }

//Зацените  через мапу для разнообразия, когда сделал залез на форум и поржал насколько все проще:
//
//
//Map<Character, Integer> map = new HashMap<>();                    // создали и заполнили в виде (буква, 0)
//        for (int i = 0; i < alphabet.size() ; i++) {
//            map.put(alphabet.get(i), 0);
//        }
//        for (int i = 0; i <list.size() ; i++) {
//            char[] a = list.get(i).toCharArray();                                // разбиваем строку на символы
//            for (int j = 0; j <a.length ; j++) {
//                if (!(a[j] == ' '))                                                             // проверили что не пробел
//                    map.put(a[j], map.get(a[j])+1) ;                       // в мапе увеличили значение по ключу буквы
//            }
//        }
//        for (Character letter : alphabet) System.out.println(letter + " " + map.get(letter));      // вывод по порядку