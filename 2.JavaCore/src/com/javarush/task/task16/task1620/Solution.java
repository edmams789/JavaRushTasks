package com.javarush.task.task16.task1620;

import java.util.ArrayList;
import java.util.List;

/* 
Один для всех, все - для одного
1. Разберись, как работает программа.
1.1. Обрати внимание, что объект Water - один для всех нитей.
2. Реализуй метод ourInterruptMethod, чтобы он прерывал все нити из threads.
3. В методе run исправь значения переменных:
3.1. isCurrentThreadInterrupted - должна равняться значению метода isInterrupted у текущей нити.
3.2. threadName - должна равняться значению метода getName (реализовано в классе Thread) у текущей нити.


Требования:
1. Метод ourInterruptMethod должен прервать все нити из списка threads.
2. Метод run должен получать текущую нить с помощью Thread.currentThread.
3. Метод run должен использовать метод isInterrupted текущей нити.
4. Метод run должен использовать метод getName текущей нити.
5. Метод main должен работать примерно 3 сек.
*/

public class Solution {
    public static byte threadCount = 3;
    static List<Thread> threads = new ArrayList<Thread>(threadCount);

    public static void main(String[] args) throws InterruptedException {
        initThreadsAndStart();
        Thread.sleep(3000);
        ourInterruptMethod();
    }
    public static void ourInterruptMethod() {
        //add your code here - добавь код тут
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
    private static void initThreadsAndStart() {
        Water water = new Water("water");
        for (int i = 0; i < threadCount; i++) {
            threads.add(new Thread(water, "#" + i));
        }
        for (int i = 0; i < threadCount; i++) {
            threads.get(i).start();
        }
    }
    public static class Water implements Runnable {
        private String sharedResource;

        public Water(String sharedResource) {
            this.sharedResource = sharedResource;
        }
        public void run() {
            //fix 2 variables - исправь 2 переменных
            boolean isCurrentThreadInterrupted = Thread.currentThread().isInterrupted();
            String threadName = Thread.currentThread().getName();
//threadName — должна равняться значению метода getName.
//Каждая нить имеет имя, которое мы передали её в момент создания,  getName() получает его.
//"isCurrentThreadInterrupted — должна равняться значению метода isInterrupted" я не понял
//Опять таки у нити есть метод isInterrupt() и переменная хранящая значение о прерывании.
//Откройте Java API полистайте.
            try {
                while (!isCurrentThreadInterrupted) {

                    System.out.println("Объект " + sharedResource + ", нить " + threadName);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
            }
        }
    }
}
//Зачем в методе run проверять значение interrupted, если нить и так должна закончится после вызова метода interrupt??>_<

//потому что это учебная задача, и вообще надо привыкать не оставлять хвосты.
//interupt() не прерывает нити, прерывает нити проверка на isInterupted встроенная в sleep();
//но sleep ведь не обязателен, даже свой код можно переделывать по несколько раз какнибудь,
// будет что сначала sleep был а потом был убран, и раз нить нить перестала прерываться в совершенно
// другом месте программы, потому что проверки небыло а была надежда на sleep