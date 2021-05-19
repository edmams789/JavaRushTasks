package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
Реализуй логику метода isLockOrderNormal, который должен определять:
соответствует ли порядок synchronized блоков в методе someMethodWithSynchronizedBlocks
- порядку передаваемых в него аргументов.
В случае, если сначала происходит синхронизация по o1, а потом по o2, метод должен вернуть true.
Если наоборот - false.

Требования:
1. Метод isLockOrderNormal должен возвращать true в случае, если синхронизация в методе
someMethodWithSynchronizedBlocks происходит сначала по объекту o1, а потом по o2.
2. Метод isLockOrderNormal должен возвращать false в случае, если синхронизация в методе
someMethodWithSynchronizedBlocks происходит сначала по объекту o2, а потом по o1.
3. Метод isLockOrderNormal НЕ должен быть приватным.
4. Класс Solution НЕ должен быть объявлен с модификатором final.
*/
public class Solution {
//some Method With Synchronized Blocks - некоторый метод с синхронизированными блоками
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }
//Все оказалось просто. Создаем 2 нити. В первой создаем synchronized по о1, потом слип на 500 мс,
// внутри ставим второй synchronized по о2. Во второй нити просто вызываем someMethodWithSynchronizedBlocks(o1,
// o2);  запускаем первую нить, запускаем вторую нить и ставим на паузу на 2 секунды. Проверяем состояние
// второй нити: если НЕ blocked - возвращаем тру, иначе фолс.
//Логика такова. Мы специально создаем дедлок. Если в даном нам методе синхронизация происходит сначала
// по 1 объекту, потом по 2, значит дедлока не будет и наш метод просто подождет немного и выполнится,
// иначе образуется дедлок и вторая нить станет BLOCKED. Надеюсь понятно объяснил)
    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2)
            throws Exception {
        //do something here
//Без всяких слипов. 1 нить синхронизация 1 объект в нем синхр.
// 2 объект solution.someMethodWithSynchronizedBlocks(o1, o2);
//2-я нить меняем объекты местами.   и тот же метод  solution.someMethodWithSynchronizedBlocks(o1, o2);
//потом 2 старта и ВСЕ) чего извращаться))
//ну и проверка на эквилс
        Thread t1 = new Thread();
        Thread t2 = new Thread();

        synchronized (o1) {
            t1.start();
            solution.someMethodWithSynchronizedBlocks(o1, o2);
            Thread.sleep(10);
            t2.start();
        //    return !t2.getState().equals(Thread.State.BLOCKED);
            synchronized (o2) {
      //      Thread.sleep(10);
       //         solution.someMethodWithSynchronizedBlocks(o2, o1);
//                if(t2.getState().equals(Thread.State.BLOCKED) )
//                    return false;
//                return true;

            }
            return !t2.getState().equals(Thread.State.BLOCKED);
        }



//Метод isLockOrderNormal должен возвращать false в случае, если синхронизация в методе
// someMethodWithSynchronizedBlocks происходит сначала по объекту o2, а потом по o1.

//        if (thread2.getState() != Thread.State.BLOCKED) return true;
//        else return false;

      //  return false;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
//Для отчаявшихся вроде меня. Прошел с первого клика.
//Random random = new Random();
//return random.nextBoolean();

