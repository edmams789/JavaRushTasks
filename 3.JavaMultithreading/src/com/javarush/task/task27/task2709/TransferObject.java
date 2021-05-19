package com.javarush.task.task27.task2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable - используйте эту переменную

//3. Метод get класса TransferObject должен ждать появления value, и возвращать его после того, как оно появится.
//5. Метод get класса TransferObject должен устанавливать флаг isValuePresent в false и уведомлять другие
//нити ожидающие освобождения монитора перед возвратом значение поля value.

    public synchronized int get() {

        while (isValuePresent) {

            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Got: " + value);

            isValuePresent = false;

        }
        notify();
        return value;
    }
//4. Метод put класса TransferObject должен ждать пока value заберут и обновлять его значение после того,
//как оно пропадет.
//6. Метод put класса TransferObject должен устанавливать флаг isValuePresent в true и уведомлять другие
//нити ожидающие освобождения монитора после обновления значение поля value.
    public synchronized void put(int value) {

        while (!isValuePresent) {


            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Put: " + value);


            isValuePresent = true;
            this.value = value;
    }

        notify();
    }
}
