package com.javarush.task.task01.task0130;

/* 
Наш первый конвертер!
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        System.out.println(convertCelsiumToFahrenheit(41));
    }
    public static double convertCelsiumToFahrenheit(int celsium) {
        double fahrenheit = 9 / 5.0 * celsium + 32;//напишите тут ваш код

        return fahrenheit;

    }
}
