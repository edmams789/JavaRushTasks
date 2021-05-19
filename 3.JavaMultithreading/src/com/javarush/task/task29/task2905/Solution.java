package com.javarush.task.task29.task2905;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/* 
Странные ошибки О_о
Исправь 2 ошибки:
1) возникновение исключения
2) подвисание
Сделай минимальные изменения.

Требования:
1. Метод startCreatingMessages() должен без зависаний добавлять в messageQueue 100000 элементов.
2. Исправь ошибку в строке "messageQueue.drainTo(messageQueue, MAX_BATCH_SIZE);".
3. Метод main() не должен зависать.
4. Вывод программы должен показывать, что все сообщения из messageQueue были перенесены в fakeDataBase.
*/
public class Solution {
    final int NUMBER_OF_THREADS = 3; // 3 треда будет обрабатывать нашу очередь
    final int MAX_BATCH_SIZE = 100; // Будем вытаскивать по 100 сообщений

    private Logger logger = Logger.getLogger(Solution.class.getName());
    private BlockingQueue messageQueue = new LinkedBlockingQueue(); // Тут будут храниться все сообщения

    private BlockingQueue fakeDatabase = new LinkedBlockingQueue();

    public static void main(String[] args) throws InterruptedException {
        // Статики во многих местах неуместны, поэтому помещаем все данные в поля класса,
        // затем создаем объект и вызываем его метод
        Solution solution = new Solution();

        solution.startCreatingMessages();
        solution.startPersistingMessages();

        Thread.sleep(100);
        solution.printResults();

        Thread.sleep(100);
        solution.printResults();

        Thread.sleep(100);
        solution.printResults();

        Thread.sleep(500);
        solution.printResults();
    }

    public void startCreatingMessages() {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    messageQueue.add(String.valueOf(i));
                }
            }
        }.start();
    }

    public void startPersistingMessages() {
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            new Thread() {
                private final Collection batch = new ArrayList(MAX_BATCH_SIZE);

                {
                    setDaemon(true);
                }

                @Override
                public void run() {
                    while (true) {
                        try {
//2. Исправь ошибку в строке "messageQueue.drainTo(messageQueue, MAX_BATCH_SIZE);".
                            messageQueue.drainTo(batch, MAX_BATCH_SIZE);
                            persistData(batch);
                            batch.clear();
                            Thread.sleep(1);
                        } catch (Throwable e) {
                            logger.log(Level.SEVERE, "impossible to persist a batch", e);
                        }
                    }
                }
            }.start();
        }
    }

    private void persistData(Collection batch) {
        // Представим, что тут мы коннектимся к базе данных, и сохраняем данные в нее
        // Сохранение данных по 1 записи тратит много ресурсов, поэтому делают батчем (группой по несколько)
        fakeDatabase.addAll(batch);
    }

    private void printResults() {
        System.out.println();
        System.out.println("messageQueue size is " + messageQueue.size());
        System.out.println("fakeDatabase size is " + fakeDatabase.size());
    }
}
//Не знаю ребят, если чисто построчно читать код, то всё становится понятно.
//...инкремент и декремент в цикле
//
//...неизвестный метод drainTo(), смотрим документацию, "..удаляет из очереди и помещает в коллекцию..".
// А у нас удаляет из очереди и помещает туда же, уже фигня какая то. Смотрим какие исключения кидает.
//"..IllegalArgumentException-если указанная коллекция является этой очередью.." - наш случай.
// Запускаем программу для подтверждения. Ок, выбрасывает нужное исключение в нужной строчке.
//
//..в какую тогда коллекцию записывать элементы, у нас остаётся batch, при том что в persistData(batch);
// передаётся пустой batch, значит его мы и должны заполнить.
//Ну а после разбора методов и коллекций становится понятно что конкретно уже происходит в программе.