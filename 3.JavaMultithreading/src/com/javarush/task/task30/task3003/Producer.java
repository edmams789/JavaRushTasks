package com.javarush.task.task30.task3003;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
/*
   1. Создай класс Producer. Для этого на красном имени класса нажми Alt+Enter -> Create Class ...
   2. Стань на имени аргумента в конструкторе (queue) и нажми Alt+Enter -> Create Field for Parameter
   'queue' -> Enter -> Enter. Имя поля - queue.
   3. Стань на подчеркнутой строке - описании класса. Далее Alt+Enter -> Implement Methods -> Enter.
   4. Проделай п.1-3 для класса Consumer.
    */
public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }
//3. В Producer и Consumer реализуй метод run так, чтобы вызов метода interrupt прерывал работу consumer
//и producer трэдов.
    @Override
    public void run() {
/*
4. Реализация метода run для Producer:
4.1. Используя метод offer добавь в очередь 9 ShareItem-ов с такими параметрами: ("ShareItem-N", N),
где N - номер элемента от 1 до 9.
4.2. Перед каждым добавлением выведи фразу "Элемент 'ShareItem-N' добавлен". Используй System.out.format.
4.3. Усыпи трэд на 0.1 секунды.
4.4. Если у очереди есть Consumer, не занятый работой, то выведи фразу "Consumer в ожидании!".
Просмотри методы интерфейса TransferQueue, там есть нужный метод.
 */
    try {
        for (int i = 1; i < 10; i++) {
        System.out.format("Элемент 'ShareItem-" + i + "' добавлен\n");
    //        queue.offer("ShareItem-N", N, 100);
        }

            Thread.sleep(100);

            if (queue.hasWaitingConsumer()) {
                System.out.format("Consumer в ожидании!");

            }

        } catch (InterruptedException e) {
          //  e.printStackTrace();
        }
    }
}
