package com.javarush.task.task10.task1008;

/* 
Правильный ответ: d = 2.941
Добавить одну операцию по преобразованию типа, чтобы получался ответ: d = 2.941

Пример вывода:
2.9411764705882355


Требования:
1. Программа должна выводить текст на экран.
2. Нельзя менять команду вывода на экран.
3. Метод main() должен содержать переменную a типа int.
4. Метод main() должен содержать переменную b типа int.
5. Метод main() должен содержать переменную d типа double.
6. Значения переменных менять нельзя. Можно добавлять только операторы приведения типа.
7. Программа должна выводить число 2.9411764705882355.
*/

public class Solution {
    public static void main(String[] args) {
        int a = 50;
        int b = 17;
        double d = (float) a / b;
        System.out.println(d);
    }
}
