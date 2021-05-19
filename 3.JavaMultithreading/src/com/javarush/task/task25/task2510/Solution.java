package com.javarush.task.task25.task2510;

/*
Поживем - увидим
Все исключения, которые возникают в процессе работы нити Solution, должны быть обработаны одним из вариантов:
1. Если это Error, то вывести в консоль "Нельзя дальше работать".
2. Если это Exception, то вывести в консоль "Надо обработать".
3. Если это Throwable, то вывести в консоль "Поживем - увидим".
Реализуй эту логику.

Требования:
1. В конструкторе Solution должен устанавливаться свой UncaughtExceptionHandler,
который будет перехватывать возникшие ошибки и выводить текст в консоль.
2. Если выполнение нити Solution закончилось исключением Error,
нужно вывести в консоль "Нельзя дальше работать".
3. Если выполнение нити Solution закончилось исключением Exception,
нужно вывести в консоль "Надо обработать".
4. Если выполнение нити Solution закончилось исключением Throwable,
нужно вывести в консоль "Поживем - увидим".
*/
public class Solution extends Thread {

    public Solution() {
      //  Thread thread = new Thread();
        setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {

                if (e instanceof Error) { System.out.println("Нельзя дальше работать");}
               else if (e instanceof Exception) { System.out.println("Надо обработать");}
               else if (e instanceof Throwable) { System.out.println("Поживем - увидим");}
            }
        });
    }
    public static void main(String[] args) {
//        Thread thread = new Thread();
//        thread.start();
    }
}
//У меня с первого раза прошло. Я вызывал в конструкторе
// super.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {};
//так как Solution является потомком Thread.

//Думаю уже не актуально, но может для других))
//Нам не надо создавать экземпляр Thread т.к. мы наследуемся от Thread.
// В этом разница реализации наследования самой нити и имплементации Runnable, где, как раз,
// и нужен объект new Thread(Runnable target), где target и является нашим классом,
// имплементирующим Runnable.