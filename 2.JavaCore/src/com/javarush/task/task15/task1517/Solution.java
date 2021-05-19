package com.javarush.task.task15.task1517;

/* 
Статики и исключения
В статическом блоке выбросьте Exception
В результате класс не загрузится, и вы увидите сообщение об ошибке вместо значения переменной B

Exception in thread "main" java.lang.ExceptionInInitializerError
at java.lang.Class.forName0(Native Method)
at java.lang.Class.forName(Class.java:186)
at com.intellij.rt.execution.application.AppMain.main(AppMain.java:113)
Caused by: java.lang.RuntimeException:
at com.javarush.task.task15.task1517.Solution.<clinit>(Solution.java:22)

Hint: Нужно погуглить причину, если получилось следующее:
java: initializer must be able to complete normally
java: unreachable statement


Требования:
1. В классе Solution в статическом блоке должно возникать исключение (Exception).
2. Программа не должна ничего выводить на экран(кроме автоматического сообщения о возникшем исключении).
3. Программа не должна считывать данные с клавиатуры.
4. Класс Solution должен быть public.
*/

public class Solution {
    public static int A = 0;

    static {

        //throw an exception here - выбросьте эксепшн тут

        //Кроме исключений котрые есть в компиляторе - программисты могут прописывать условия
        // при которых так же будут выкидываться исключения. Получается что в данном примере
        // программисту нельзя чтоб А == 0, но так как в программе так и есть,
        // то исключение обязательно выскочит.  Это же демонстрация.

        if(A == 0) {
            throw new java.lang.RuntimeException("END MEEEEEEEEEEEEEEEEEEEEEEEEEE");
        }
    }
    public static int B = 5;

    public static void main(String[] args) {
        System.out.println(B);
    }
}
//https://ru.stackoverflow.com/questions/719099/exceptionininitializererror-%D0%BF%D1%80%D0%B8-%D0%B7%D0%B0%D0%BF%D1%83%D1%81%D0%BA%D0%B5-javafx-%D0%BF%D1%80%D0%B8%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F-%D0%B8%D0%B7-%D0%B4%D1%80%D1%83%D0%B3%D0%BE%D0%B3%D0%BE-%D0%BA%D0%BB%D0%B0%D1%81%D1%81%D0%B0