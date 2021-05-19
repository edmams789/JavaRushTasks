package com.javarush.task.task27.task2710;

public class Person implements Runnable {
    private final Mail mail;

    public Person(Mail mail) {
        this.mail = mail;
    }
//4. В методе run класса Person должен присутствовать synchronized блок, монитор - mail.
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(1000);
            //сделайте что-то тут - do something here
            synchronized (mail) {

            //сделайте что-то тут - do something here
           // while (mail.getText() == null) {
                mail.setText("Person [" + name + "] wrote an email 'AAA'");
                mail.notify();
          //  }
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
