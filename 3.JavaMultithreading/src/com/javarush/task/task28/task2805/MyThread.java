package com.javarush.task.task28.task2805;

public class MyThread extends Thread {

static int count;
    {
        setPriority(count++ % 10 + 1);

    }

    public MyThread() {
    }

    public MyThread(Runnable runnable) {
        super(runnable);
    }

    public MyThread(ThreadGroup threadGroup, Runnable runnable) {
        super(threadGroup, runnable);
    }

    public MyThread(String s) {
        super(s);
    }

    public MyThread(ThreadGroup threadGroup, String s) {
        super(threadGroup, s);
    }

    public MyThread(Runnable runnable, String s) {
        super(runnable, s);
    }

    public MyThread(ThreadGroup threadGroup, Runnable runnable, String s) {
        super(threadGroup, runnable, s);
    }

    public MyThread(ThreadGroup threadGroup, Runnable runnable, String s, long l) {
        super(threadGroup, runnable, s, l);
    }
}
/*
зачетная задачка!!! простая, быстрая, заставляет вспомнить пройденное.
поначалу немного растерялся, когда задумался, как же статический счетчик использовать при создании объекта, когда столько разных конструкторов в классе! неужели пихать в каждый конструктор?
и тут же вспомнил про замечательную штуку - динамическую инициализацию класса!
наконец-то она пригодилась!!!)
то самое приятное чувство, когда знания, когда-то полученные и едва ли востребованные до данного момента, вдруг оказались незабытыми и полезными!
sa-tis-fac-tion!)

кто забыл - напомню:
class MyClass {

{
//динамическая инициализация
//блок вызывается каждый раз при создании нового объекта ДО вызова его конструктора.
}

}

для решения задачи после автоматического создания всех конструкторов, требуется:
- объявить static переменную;
- добавить ровно одну строчку кода в блок динамической инициализации.
короткое и лаконичное решение!)
 */

//если делать в одну строчку(коменты ниже),  то можно и без тернарных операторов :
//count++ % 10 + 1