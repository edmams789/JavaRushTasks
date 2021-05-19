package com.javarush.task.task30.task3004;

import java.util.concurrent.RecursiveTask;
/*
Fork/Join
1. Создай класс BinaryRepresentationTask. Для этого в IntelliJ IDEA на красном имени класса нажми
Alt+Enter -> Create Class ...
(класс должен наследоваться от RecursiveTask<String>). Параметр конструктора - int x.
2. Реализуй логику метода compute - число должно переводиться в двоичное представление.
3. Используй методы fork и join.
4. Пример функциональной реализации - метод binaryRepresentationMethod.

Требования:
1. Создай класс BinaryRepresentationTask.
2. В классе BinaryRepresentationTask должен быть переопределен метод compute().
3. В классе BinaryRepresentationTask в методе compute() используй методы fork() и join().
4. Метод compute() должен правильно переводить число в двоичную систему счисления.
*/
public class BinaryRepresentationTask extends RecursiveTask {
    public BinaryRepresentationTask(int i) {

    }

    @Override
    protected Object compute() {
//        int a = x % 2;
//        int b = x / 2;
//        String result = String.valueOf(a);
//        if (b > 0) {
//            BinaryRepresentationTask task = new BinaryRepresentationTask(b);
//            task.fork();
//            return task.join() + a;
//
//        }
//        return result;
return null;
    }
}
/*
- к слову, когда используется пустой конструктор ForkJoinPool(), как в нашем случае, JVM сама запрашивает
у системы количество ядер процессора и создает пул с соответствующим количеством потоков.

- Да, можно даже посмотреть сколько выделено процессоров для текущей JVM
System.out.println(Runtime.getRuntime().availableProcessors());

У меня показало значение 4, хотя если зайти в информация о системе - то там указано 2 ядра у моего
процессора. Оказывается если процессор поддерживает технологию Hyper-Threading, то количество логических
процессоров будет увеличено вдвое.
 */