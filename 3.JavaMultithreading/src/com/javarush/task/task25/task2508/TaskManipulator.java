package com.javarush.task.task25.task2508;
/*
Не валять дурака
Восстанови логику класса TaskManipulator.

Требования:
1. Класс TaskManipulator должен реализовывать интерфейсы Runnable и CustomThreadManipulator.
2. Метод run должен каждые 100 миллисекунд выводить имя исполняемой нити в консоль.
3. Класс TaskManipulator должен иметь внутреннее поле типа Thread.
4. Метод start должен создавать, сохранять во внутреннее поле и запускать нить с именем,
которое передано через аргумент метода.
5. Метод stop должен прерывать последнюю созданную классом TaskManipulator нить.
*/
public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;

    @Override
    public void run() {
      //  thread = Thread.currentThread();
        while (!Thread.currentThread().isInterrupted()){
            try {
                System.out.println(thread.getName());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
    @Override
    public void start(String threadName) {

    thread = new Thread(this);
    thread.setName(threadName);
    thread.start();
    }

    @Override
    public void stop() {
    thread.interrupt();
    }
}
//Вспомни как ты обычно запускал свою нить
//class MyThread implements Runnable {
//        @Override
//        public void run() {
//            /*Some actions*/
//        }
//    }
//
//
//MyThread myThread = new MyThread();
//Thread thread = new Thread(myThread);
//thread.start();
// this - это объект у которого ты вызываешь функцию, если в main глянуть то это TaskManipulator,
// у которого ты имплементишь Runnable. Получается тоже самое

//@Override
//            public String toString () {
//                return getName() + " from " + Thread.currentThread().getName() + " created";
//            }
//
//
//почему getName() выдает  имя новой нити, а Thread.currentThread().getName() предыдущей (с которой создавалась)?