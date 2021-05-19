package com.javarush.task.task28.task2806;

import java.util.concurrent.*;
/* 
Знакомство с Executors
1. В методе main создай фиксированный пул из 5 трэдов используя класс Executors.
2. В цикле отправь на исполнение в пул 10 задач Runnable.
3. У каждой задачи в методе run вызови метод doExpensiveOperation с порядковым номером задачи начиная с 1,
см. пример вывода.
4. Запрети добавление новых задач на исполнение в пул (метод shutdown).
5. Дай пулу 5 секунд на завершение всех задач (метод awaitTermination и параметр TimeUnit.SECONDS).

Требования:
1. Используя класс Executors, создай в методе main фиксированный пул из 5 трэдов.
2. Пул должен принимать на исполнение 10 задач Runnable.
3. Каждая задача должна вызывать метод doExpensiveOperation с порядковым номером задачи, начиная с 1.
4. Запрети добавление новых задач на исполнение в пул.
5. На завершение всех задач в пуле нужно установить 5 секунд.
*/
public class Solution {
    public static int j = 0;
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //Add your code here
//1. В методе main создай фиксированный пул из 5 трэдов используя класс Executors.
//1. Используя класс Executors, создай в методе main фиксированный пул из 5 трэдов.
        ExecutorService service = Executors.newFixedThreadPool(5);
//2. В цикле отправь на исполнение в пул 10 задач Runnable.
//2. Пул должен принимать на исполнение 10 задач Runnable.
        for(int i = 0; i < 10; i++)
        {
            service.submit(new Runnable() {
                public void run()
                {
//3. У каждой задачи в методе run вызови метод doExpensiveOperation с порядковым номером задачи начиная с 1,
//см. пример вывода.
//3. Каждая задача должна вызывать метод doExpensiveOperation с порядковым номером задачи, начиная с 1.
                    doExpensiveOperation(++j);
                }
            });
        }
//4. Запрети добавление новых задач на исполнение в пул (метод shutdown).
//4. Запрети добавление новых задач на исполнение в пул.
        service.shutdown();
//5. Дай пулу 5 секунд на завершение всех задач (метод awaitTermination и параметр TimeUnit.SECONDS).
//5. На завершение всех задач в пуле нужно установить 5 секунд.
        service.awaitTermination(5, TimeUnit.SECONDS);
/*
//1. Создаем ThreadPoolExecutor
ExecutorService service = Executors.newFixedThreadPool(5);

//2 помещаем в него задачу для выполнения
Future<String> task = service.submit(new ReverseString("Amigo"));

//3 ждем пока задача выполнится
while(!task.isDone())
{
 Thread.sleep(1);
}

//4 пробуем получить результат задачи
//получим или результат или исключение, если оно было при выполнении задачи
try
{
 System.out.println("Развернутая строка : " + task.get());
}
catch (Exception ie)
{
 ie.printStackTrace(System.err);
}

//5 останавливаем ThreadPool.
service.shutdown();
*/
        /* output example
pool-1-thread-2, localId=2
pool-1-thread-1, localId=1
pool-1-thread-3, localId=3
pool-1-thread-1, localId=7
pool-1-thread-1, localId=9
pool-1-thread-4, localId=4
pool-1-thread-5, localId=5
pool-1-thread-2, localId=6
pool-1-thread-1, localId=10
pool-1-thread-3, localId=8
         */
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId="+localId);
    }
}
