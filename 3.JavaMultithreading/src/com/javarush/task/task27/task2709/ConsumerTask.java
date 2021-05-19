package com.javarush.task.task27.task2709;

public class ConsumerTask implements Runnable {
    private TransferObject transferObject;
//Переменные volatile никогда не будут закэшированы и все операции чтения/записи будут выполняться только
// из основной памяти.
    protected volatile boolean stopped;

    public ConsumerTask(TransferObject transferObject) {
        this.transferObject = transferObject;
        new Thread(this, "ConsumerTask").start();
    }
//1. В методе run класса ConsumerTask должен содержаться synchronized блок, монитор - transferObject.
    @Override
    public void run() {
        while (!stopped) {
            synchronized (transferObject) {

                transferObject.get();
            }
        }
    }

    public void stop() {
        stopped = true;
    }
}