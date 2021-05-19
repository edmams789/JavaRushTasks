package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
Разложить целое число n > 1 на простые множители.
Вывести в консоль через пробел все множители в порядке возрастания.
Написать рекурсивный метод для вычисления простых множителей.
Не создавай в классе Solution дополнительные поля.

Пример:
132

Вывод на консоль:
2 2 3 11

Требования:
1. В классе Solution не должны быть созданы дополнительные поля.
2. Метод recurse должен выводить на экран все простые множители числа полученного в качестве параметра (пример в условии).
3. Метод recurse не должен быть статическим.
4. Метод recurse должен быть рекурсивным.
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse(1);
    }

    public void recurse(int n) {
        if (n <= 1) {
            return;
        }
        if (n > 1 && n % 2 == 0) {
            System.out.print(n * 2 / n + " ");
            recurse(n / 2);
        } else if (n > 1 && n % 3 == 0) {
            System.out.print(n * 3 / n + " ");
            recurse(n / 3);
        } else if (n > 1 && n % 5 == 0) {
            System.out.print(n * 5 / n + " ");
            recurse(n / 5);
        } else if (n > 1 && n % 7 == 0) {
            System.out.print(n * 7 / n + " ");
            recurse(n / 7);
        } else {
            System.out.println(n);
        }
    }
}