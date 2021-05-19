package com.javarush.task.task28.task2807;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* 
Знакомство с ThreadPoolExecutor
1. В методе main создай очередь LinkedBlockingQueue<Runnable>.
2. В цикле добавь в очередь 10 задач Runnable.
3. У каждой задачи в методе run вызови метод doExpensiveOperation с порядковым номером задачи начиная с 1,
см. пример вывода.
4. Создай объект ThreadPoolExecutor со следующими параметрами:
- основное количество трэдов (ядро) = 3,
- максимальное количество трэдов = 5,
- время удержания трэда живым после завершения работы = 1000,
- тайм-юнит - миллисекунды,
- созданная в п.1. очередь с задачами.
5. Запусти все трэды, которые входят в основное кол-во трэдов - ядро, используй метод prestartAllCoreThreads.
6. Запрети добавление новых задач на исполнение в пул (метод shutdown).
7. Дай объекту ThreadPoolExecutor 5 секунд на завершение всех тасок (метод awaitTermination и параметр TimeUnit.SECONDS).


Требования:
1. В методе main нужно создать очередь LinkedBlockingQueue<Runnable>.
2. В цикле добавь в очередь 10 задач Runnable.
3. Нужно создать объект ThreadPoolExecutor с параметрами, указанными в задании.
4. С помощью метода prestartAllCoreThreads нужно запустить основные трэды.
5. Каждая задача должна вызывать метод doExpensiveOperation с порядковым номером задачи, начиная с 1.
6. Запрети добавление новых задач на исполнение в пул.
7. На завершение всех задач в пуле нужно установить 5 секунд.
*/
public class Solution {
    public static int j = 1;
    public static void main(String[] args) throws InterruptedException {
        // Add your code here
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
        for (int i = 0; i < 10; i++) {
            queue.add(new Runnable() {
                @Override
                public void run() {
                    doExpensiveOperation(j++);
                }
            });
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 1000, TimeUnit.MILLISECONDS, queue);
        threadPoolExecutor.prestartAllCoreThreads();
        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(5, TimeUnit.SECONDS);

        /* Example output
pool-1-thread-2, localId=2
pool-1-thread-3, localId=3
pool-1-thread-1, localId=1
pool-1-thread-3, localId=5
pool-1-thread-2, localId=4
pool-1-thread-3, localId=7
pool-1-thread-1, localId=6
pool-1-thread-3, localId=9
pool-1-thread-2, localId=8
pool-1-thread-1, localId=10
         */
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}
/*
add(); - Вставляет указанный элемент в эту очередь, если это возможно сделать немедленно,
не нарушая ограничений емкости, возвращая true при успешном выполнении и бросая исключение
IllegalStateException, если в настоящее время нет свободного места.

put(); - Вставляет указанный элемент в хвост этой очереди, ожидая при необходимости,
чтобы пространство стало доступным.

offer(); - Вставляет указанный элемент в хвост этой очереди, ожидая при необходимости до указанного
времени ожидания, чтобы пространство стало доступным.

p/s нам нужен тот что кидает исключение, если переполнен
 */