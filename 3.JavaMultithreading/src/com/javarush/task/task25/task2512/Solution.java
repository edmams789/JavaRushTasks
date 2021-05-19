package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
Живем своим умом
В классе Solution реализуй интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений, начиная с самого вложенного.

Пример исключения:
new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))

Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC


Требования:
1. Класс Solution должен реализовывать интерфейс Thread.UncaughtExceptionHandler.
2. После вызова uncaughtException нужно прервать нить, которая бросила исключение.
3. Затем, вывести в консоль стек исключений, начиная с самого вложенного исключения.
4. Сообщения должны выводиться в формате "exception class: exception message".
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<Throwable> list = new ArrayList<>();
        list.add(e);
        while (list.get(list.size() - 1).getCause() != null){
            list.add(list.get(list.size() - 1).getCause());
        }
            Collections.reverse(list);

        for (Throwable ee : list) {
            System.out.println(ee.getClass().getName() + ": " + ee.getMessage());
        }
      //  for (Throwable ee : list) System.out.println(ee);
    }
//    public void recursion(Throwable e) {
//        if (e.getCause() != null) recursion(e.getCause());
//        System.out.println(e.getClass().getName() + ": " + e.getMessage());
//    }

    public static void main(String[] args) {
        new Solution().uncaughtException(Thread.currentThread(), new Exception("ABC",
                new RuntimeException("DEF", new IllegalAccessException("GHI"))));

    }
}
//Много в комментариях примеров решений, но многие я даже понять не могу, особенно лямбды...
//У меня получилось достаточно лаконично и понятно, на мой взгляд. Решил рекурсией, вызываем Interrupt с нашей функцией и всё работает. Мало ли кому пригодится
//public void recursion(Throwable e){
//        if(e.getCause()!=null) recursion(e.getCause());
//        System.out.println(e.getClass().toString().substring(6) +": " + e.getMessage());
//    }
//Т.к. у объект типа Class есть метод getName(), можно немножко упростить:
//
//System.out.println(e.getClass().getName() +": " + e.getMessage());

//Правильный вывод массива :
//System.out.println(list.get(i).getClass().getName() +": "+list.get(i).getMessage());

//Описание возможной ошибки, это - e.getMessage().

//пришлось посидеть над этой простейшей задачкой, т.к. изрядно подзабылись цепочки исключений.
//тем, у кого трудности с решением, напомню, что у класса Throwable есть такие методы:
//- getCause();
//- getMessage().
//ну, и все-таки стоит осваивать рекурсии. и идеально начинать с таких простых, как в этой задаче.
//
//в метод main для тестирования поместите:
//new Solution().uncaughtException(Thread.currentThread(), new Exception("ABC", new RuntimeException("DEF",
// new IllegalAccessException("GHI"))));
//
//(эту строку можно не удалять при отправке на валидацию)

//Может и стоит городить рекурсию, а может и нет.  Накидал список исключений, развернул его и вывел в консоль.
//t.interrupt();
//List<Throwable> list = new ArrayList<>();
//list.add(e);
//while(list.get(list.size()-1).getCause() != null)
//    list.add(list.get(list.size()-1).getCause());
//Collections.reverse(list);
//for (Throwable el:list) System.out.println(el.getClass().getName() + ": " + el.getMessage());
