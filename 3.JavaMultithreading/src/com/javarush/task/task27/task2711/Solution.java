package com.javarush.task.task27.task2711;

import java.util.concurrent.CountDownLatch;

/* 
CountDownLatch
Дана стандартная реализация методологии wait-notify.
Почитай про CountDownLatch и перепиши тело метода someMethod используя поле latch.
Весь лишний код удали из класса.


Требования:
1. Из класса Solution должно быть удалено поле lock.
2. Из метода someMethod должен быть удален synchronized блок.
3. В методе someMethod должен быть вызван метод await без параметров у объекта сохраненного в поле latch.
4. В методе someMethod должен быть вызван метод retrieveValue.
5. В методе someMethod должен быть вызван метод countDown у объекта сохраненного в поле latch.
*/
public class Solution {
  //  private final Object lock = new Object();
    private volatile boolean isWaitingForValue = true; // - нвдо было тоже удалить

    CountDownLatch latch = new CountDownLatch(1);

    public void someMethod() throws InterruptedException {

        latch.await();
        retrieveValue();
        latch.countDown();
    }

    void retrieveValue() {
        System.out.println("Value retrieved.");
    }

    public static void main(String[] args) {

    }
}
