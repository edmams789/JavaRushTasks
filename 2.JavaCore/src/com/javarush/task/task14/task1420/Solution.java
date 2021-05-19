package com.javarush.task.task14.task1420;

/* 
НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.


Требования:
1. Программа должна считывать с клавиатуры 2 строки.
2. В случае если введенные строки невозможно преобразовать в положительные целые числа,
должно возникать исключение.
3. Программа должна выводить данные на экран.
4. Программа должна выводить на экран наибольший общий делитель(НОД)
чисел считанных с клавиатуры и успешно завершаться.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        int a = list.get(0);
        int b = list.get(1);

        if (a <= 0 || b <= 0)
            throw new Exception();

        while (a != 0 && b != 0) {
            if (a > b)
                a = a % b;
                        else b = b % a;


    }
        System.out.println(a + b);



}
}
