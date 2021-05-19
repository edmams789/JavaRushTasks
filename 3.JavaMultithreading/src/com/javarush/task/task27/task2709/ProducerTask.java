package com.javarush.task.task27.task2709;

import java.util.concurrent.atomic.AtomicInteger;

public class ProducerTask implements Runnable {
    private TransferObject transferObject;
    protected volatile boolean stopped;
    static volatile AtomicInteger i = new AtomicInteger(0);

    public ProducerTask(TransferObject transferObject) {
        this.transferObject = transferObject;
        new Thread(this, "ProducerTask").start();
    }
//2. В методе run класса ProducerTask должен содержаться synchronized блок, монитор - transferObject.
    @Override
    public void run() {
        while (!stopped) {
            synchronized (transferObject) {
                transferObject.put(i.incrementAndGet());
            }
        }
    }

    public void stop() {
        stopped = true;
    }
}
