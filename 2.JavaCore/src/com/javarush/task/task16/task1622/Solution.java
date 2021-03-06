package com.javarush.task.task16.task1622;

/* 
Последовательные выполнения нитей
1. В методе run после всех действий поставь задержку в 10 миллисекунд. Выведи "Нить прервана",
если нить будет прервана.
2. Сделай так, чтобы все нити выполнялись последовательно: сначала для нити №1 отсчет с COUNT до 1,
потом для нити №2 с COUNT до 1 и т.д.

Пример:
#1: 4
#1: 3
...
#1: 1
#2: 4
...

Требования:
1. Программа должна создавать 4 объекта типа SleepingThread.
2. Метод main должен вызвать join у каждой создаваемой SleepingThread нити.
3. Метод run должен использовать Thread.sleep(10).
4. Вывод программы должен соответствовать условию.
5. Если нить SleepingThread прерывается, она должна вывести сообщение "Нить прервана".
*/

public class Solution {
    public volatile static int COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < COUNT; i++) {
          //  new SleepingThread();
            //напишите тут ваш код
            new SleepingThread().join();
        }
    }
    //new SleepingThread().join(); - будет ждать конкретно эту нить.
    // (т.к. при создании данного объекта вызывается метод start(); )
    //Thread.currentThread().join(); - Ждет текущую нить, а текущая нить у тебя main.

    //перед join() указывается поток, окончания которого будет ожидать поток, в котором этот join вызван.
    //
    //таким образом, в вашем втором варианте код некорректно написан.
    //получается, что поток ждет в этой строке, когда он сам же прекратит выполнение.

    public static class SleepingThread extends Thread {
        private static volatile int threadCount = 0;
        private volatile int countdownIndex = COUNT;

        public SleepingThread() {
            super(String.valueOf(++threadCount));
            start();
        }
        public void run() {
            while (true) {
                System.out.println(this);
                if (--countdownIndex == 0) return;
                //напишите тут ваш код
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("Нить прервана");
                }
//Просто вставляйте сообщение о прерывании нити в catch блока try.
// Не спрашивать почему. Просто вставлять)
            }
        }
        public String toString() {
            return "#" + getName() + ": " + countdownIndex;
        }
    }
}
