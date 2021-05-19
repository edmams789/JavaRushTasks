package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }
//3. В Producer и Consumer реализуй метод run так, чтобы вызов метода interrupt прерывал работу consumer
//и producer трэдов.
    @Override
    public void run() {
/*
5. Реализация метода run для Consumer:
5.1. Усыпи трэд на 0.45 секунды.
5.2. В бесконечном цикле забери элемент из очереди методом take и выведи в консоль
"Processing item.toString()".
 */
    try {
        Thread.sleep(450);
        while (true) {
            queue.take();
            System.out.format("Processing item.toString()\n");
        }
    } catch (InterruptedException e) {

    }
    }
}
