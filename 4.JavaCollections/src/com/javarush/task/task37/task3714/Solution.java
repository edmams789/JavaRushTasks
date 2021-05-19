package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Древний Рим

Амиго, привет! Я недавно увлекся историей вашей планеты и меня заинтересовал период Древнего Рима.
Интересно тогда было жить, сплошные развлечения и вино! Или рабство, если не повезло со стартовой локацией...

В общем, мне нужен метод romanToInteger, который будет конвертировать число в римской системе счисления
{I, V, X, L, C, D, M} в десятичную. Иначе никак не разобрать что и когда у них происходило.

Требования:
1. Метод romanToInteger должен конвертировать число в римской системе счисления в десятичную.
2. Метод romanToInteger должен возвращать значение типа int и принимать один параметр типа String.
3. Метод romanToInteger должен быть публичным.
4. Метод romanToInteger должен быть статическим.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        if (s.isEmpty()) return 0;
        if (s.startsWith("M"))  return 1000 + romanToInteger(s.substring(1));
        else if (s.startsWith("CM")) return 900  + romanToInteger(s.substring(2));
        else if (s.startsWith("D"))  return 500  + romanToInteger(s.substring(1));
        else if (s.startsWith("CD")) return 400  + romanToInteger(s.substring(2));
        else if (s.startsWith("C"))  return 100  + romanToInteger(s.substring(1));
        else if (s.startsWith("XC")) return 90   + romanToInteger(s.substring(2));
        else if (s.startsWith("L"))  return 50   + romanToInteger(s.substring(1));
        else if (s.startsWith("XL")) return 40   + romanToInteger(s.substring(2));
        else if (s.startsWith("X"))  return 10   + romanToInteger(s.substring(1));
        else if (s.startsWith("IX")) return 9    + romanToInteger(s.substring(2));
        else if (s.startsWith("V"))  return 5    + romanToInteger(s.substring(1));
        else if (s.startsWith("IV")) return 4    + romanToInteger(s.substring(2));
        else if (s.startsWith("I"))  return 1    + romanToInteger(s.substring(1));
        throw new IllegalArgumentException("Unexpected roman numerals");
    }

    public static int convert(String s) {
        if (s == null || s.isEmpty() || !s.matches("^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$"))
            return -1;
        return romanToInteger(s);
    }
}
