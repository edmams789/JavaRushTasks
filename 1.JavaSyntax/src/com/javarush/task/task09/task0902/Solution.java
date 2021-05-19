package com.javarush.task.task09.task0902;

/* 
И снова StackTrace
Написать пять методов, которые вызывают друг друга.
Каждый метод должен возвращать имя метода, вызвавшего его, полученное с помощью StackTrace.


Требования:
1. В классе должно быть 5 методов (метод main не учитывать).
2. Каждый метод должен вызывать следующий: main вызывать method1, method1 вызывать method2 и т.д.
3. Каждый метод должен возвращать имя метода, вызвавшего его.
4. Для получения имени вызвавшего метода, используй метод getMethodName.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
    }

    public static String method1() {
        method2();
        //напишите тут ваш код

        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String method2() {
        method3();
        //напишите тут ваш код

        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String method3() {
        method4();
        //напишите тут ваш код

        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String method4() {
        method5();
        //напишите тут ваш код

        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String method5() {
        //напишите тут ваш код

        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}
//0-ой индекс - getStackTrace, 1-ый - ВСЕГДА текущий метод независимо от уровня вложенности,
// а дальше по принципу матрешки (вложенности методов). Т.к. по условию задачи требуется
// вывести имя вызвавшего метода, то для всех методов это 2ой индекс.

//Сначала вообще не поняла что нужно сделать, начала изучать комментарии. где-то наткнулась
// на предложение прогнать в каждом методе цикл, выводящий все значения массива StackTraceElemets[]
// в одну строку с указанием индекса метода в стэке и названия метода
// (в лекции как раз пример приведен), перед этим методы все сделала void. и, знаете,
// получилось все очень наглядно, и стало понятно почему везде при возврате значения в методе
// индекс нужен указывать 2. надеюсь, кому-нибудь это поможет))) задача прикольная))

//Вне зависимости в каком методе по глубине вложения если проделать -
//StackTraceElement[] stackTraceElements = (Thread.currentThread().getStackTrace()); мы получим:
//
//stackTraceElements[0].getMethodName() - всегда будет getStackTrace.
//stackTraceElements[1].getMethodName() - узнаем имя метода в котором мы.
//stackTraceElements[2].getMethodName() - узнаем имя метода который вызвал данный метод*/

