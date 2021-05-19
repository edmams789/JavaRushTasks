package com.javarush.task.task28.task2802;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* 
Пишем свою ThreadFactory
В классе Solution создай публичный статический класс AmigoThreadFactory, реализующий интерфейс ThreadFactory.
1. Реализация интерфейсного метода - создайте и верните трэд, который должен:
1.1. не быть демоном,
1.2. иметь нормальный приоритет,
1.3. имя трэда должно иметь шаблон "GN-pool-A-thread-B",
где GN - это имя группы,
A - это номер фабрики инкрементируется в пределах класса начиная с 1, используйте AtomicInteger,
B - номер треда инкрементируется в пределах конкретной фабрики начиная с 1, используйте AtomicInteger.
2. Каждая фабрика должна иметь ту группу тредов (ThreadGroup), в которой она была создана.
3. Методы main и emulateThreadFactory не участвуют в тестировании.

Пример вывода:
secondGroup-pool-2-thread-1
firstGroup-pool-1-thread-1
firstGroup-pool-1-thread-3
secondGroup-pool-2-thread-3
firstGroup-pool-1-thread-2
secondGroup-pool-2-thread-2
*/
public class Solution {

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }
//В классе Solution создай публичный статический класс AmigoThreadFactory, реализующий интерфейс ThreadFactory.

 //Прежде чем решать, посмотрите в Idea интерфейс ThreadFactory.
 // Найдите в нем ссылку на Executors#defaultThreadFactory, перейдите по ней и далее в конструктор
 // DefaultThreadFactory() . Там то, что нам нужно. Не списывайте сразу :) Я посмотрел бегло,
 // потом воспроизвел как мог в своей фабрике, отладил. P. S. Приоритет и демона ставить принудительно.
    public static class AmigoThreadFactory implements ThreadFactory {

        AtomicInteger atomicInteger = new AtomicInteger(0);
        AtomicInteger factoryNumber = new AtomicInteger(0);
        static AtomicInteger factoryCount = new AtomicInteger(0);
        public AmigoThreadFactory() {
            factoryNumber.set(factoryCount.incrementAndGet());
        }
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setDaemon(false);
            thread.setPriority(Thread.NORM_PRIORITY);
            thread.setName(thread.getThreadGroup().getName() + "-pool-" +
                    factoryNumber + "-thread-" + atomicInteger.incrementAndGet());
            return thread;
        }
 }
}

//return new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable runnable) {
//                Thread thread = backingThreadFactory.newThread(runnable);
//                if (namePrefix != null) {
//                    thread.setName(namePrefix + "-" + count.getAndIncrement());
//                }
//                if (daemon != null) {
//                    thread.setDaemon(daemon);
//                }
//                if (priority != null) {
//                    thread.setPriority(priority);
//                }
//                if (uncaughtExceptionHandler != null) {
//                    thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
//                }
//                return thread;
//            }
//        };