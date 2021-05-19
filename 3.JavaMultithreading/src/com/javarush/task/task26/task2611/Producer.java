package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

/*
Мир не меняется, меняемся мы
Разберись с ConcurrentHashMap.
В отдельном файле создайте класс Producer, который будет:
1. каждые полсекунды добавлять в ConcurrentHashMap ключ и значение, где ключ - счетчик начиная с 1,
значение - фраза: "Some text for i" , пример "Some text for 1".
2. при возникновении исключения выводить в консоль: "[THREAD_NAME] thread was terminated",
пример "[thread-1] thread was terminated".

Требования:
1. Класс Producer должен быть создан в отдельном файле.
2. Класс Producer должен реализовывать интерфейс Runnable.
3. Класс Producer должен содержать приватное поле ConcurrentHashMap<String, String> map.
4. Класс Producer должен содержать конструктор с одним параметром, инициализирующий поле map.
5. Метод run() класса Producer должен каждые полсекунды добавлять в ConcurrentHashMap ключ и значение
согласно заданию.
6. Метод run() класса Producer должен при возникновении исключения выводить в консоль
"[THREAD_NAME] thread was terminated".
 */
public class Producer implements Runnable{
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {

            int i = 1;
            while (true){
                map.put(String.valueOf(i), "Some text for " + i++);
              //  System.out.println("Some text for " + i);
                Thread.sleep(500);

            }
        } catch (InterruptedException e) {
          //  String[] threadArr = Thread.currentThread().getName().split("\\-", 3);
           // System.out.println("[THREAD_NAME] thread was terminated");
           // System.out.println("[" + threadArr[threadArr.length-1] + "] thread was terminated");
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));

        }

    }
}
//Вместо while (!currentThread.isInterrupted()) используйте бесконечный цикл  while(true)
//А строку Thread currentThread = Thread.currentThread();  вообще не писать....