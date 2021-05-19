package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
Ввести с клавиатуры число. Определить, сколько в введенном числе четных цифр,
а сколько нечетных.
Если число делится без остатка на 2 (т. е. остаток равен нулю), значит оно четное.
Увеличиваем на 1 счетчик четных цифр (статическая переменная even).
Иначе число нечетное, увеличиваем счетчик нечетных цифр (статическая переменная odd).
Вывести на экран сообщение: "Even: а Odd: b", где а - количество четных цифр,
b - количество нечетных цифр.

Пример для числа 4445:
Even: 3 Odd: 1


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Метод main должен посчитать сколько четных цифр во веденном числе и
записать это количество в переменную even.
3. Метод main должен посчитать сколько нечетных цифр во веденном числе и
записать это количество в переменную odd.
4. Программа должна выводить текст на экран.
5. Выведенный текст должен соответствовать заданию.
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int i = Integer.parseInt(reader.readLine());

        if (i % 2 == 0)
             Solution.even++;
         else
             Solution.odd++;
        {
            for (int x = i; i >= 10; i /= 10)

                if ((i / 10) % 2 == 0) {
                    Solution.even++;
                } else
                    Solution.odd++;
        }
        System.out.println("Even: " + even + " Odd: " + odd);
}    //напишите тут ваш код
}
