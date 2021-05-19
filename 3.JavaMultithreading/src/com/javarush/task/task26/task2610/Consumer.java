package com.javarush.task.task26.task2610;

import java.util.concurrent.BlockingQueue;

/*
Мир скучен для скучных людей
Разберись с BlockingQueue.
По образу и подобию класса Producer создай класс Consumer, который будет выводить данные из
BlockingQueue в консоль.

Требования:
1. Класс Consumer должен быть создан в отдельном файле.
2. Класс Consumer должен реализовывать интерфейс Runnable.
3. Класс Consumer должен содержать приватное поле BlockingQueue queue.
4. Класс Consumer должен содержать конструктор с одним параметром, инициализирующий поле queue.
5. Метод run() класса Consumer должен постоянно выводить на экран значения из очереди.
 */
public class Consumer implements Runnable {

    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
           // int i = 0;
            while (true) {
               // queue.put(String.valueOf(i++));
                Thread.sleep(300);
                System.out.println(queue.remove());
            }
        } catch (InterruptedException e) {
        //    System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));

        }
    }
}
//Из того что понял.
//1) Queue - это очередь которая имеет голову и хвост (в нашем случае она синхронизирована).
//2) Метод take(). Возвращает и удаляет голову нашей очереди. т.е., в Producer мы дополняем очередь,
// в Consumer мы возвращаем а заодно и удаляем значение из очереди.

//http://java-online.ru/concurrent-queue-block.xhtml#synhronous