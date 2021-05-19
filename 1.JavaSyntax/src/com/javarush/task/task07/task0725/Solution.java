package com.javarush.task.task07.task0725;

/* 
Переставь один модификатор static

Переставь один модификатор static, чтобы пример скомпилировался.

Требования:
1. Программа не должна считывать данные с клавиатуры.
2. В классе должна быть переменная A.
3. В классе должна быть переменная B.
4. В классе должна быть переменная C.
5. В классе должен быть метод main.
6. В классе должен быть метод getValue.
7. В классе должно быть 4 модификатора static (переменные и методы).
*/

public class Solution {
    public final static int A = 5;
    public final static int B = 2;
    public final static int C = A * B;

    public static void main(String[] args) {
    }

    public int getValue() {
        return C;
    }
}
