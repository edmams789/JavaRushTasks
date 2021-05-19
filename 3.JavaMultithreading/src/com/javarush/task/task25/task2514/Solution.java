package com.javarush.task.task25.task2514;
/* 
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
Обеспечь переуступку кванта времени (переход хода для текущей нити) для последовательных выводов текста в консоль.

Требования:
1. Класс Solution должен содержать вложенный класс YieldRunnable, который реализует интерфейс Runnable.
2. Класс YieldRunnable должен иметь поле с индексом, которое инициализируется через конструктор.
3. Метод run() должен выводить в консоль сообщения с текущим индексом о начале и конце работы метода.
4. В правильном месте должен быть вызван Thread.yield.
*/
public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);
        }
    }
    public static void main(String[] args) {
       // for (int i = 1; i <= 10; i++) new YieldRunnable(i).run();
        for (int i = 1; i <= 10; i++)  new Thread(new YieldRunnable(i)).start();// проверочный код
    }
}
//обавил в метод main следующий код:
//for (int i = 1; i <= 10; i++) new YieldRunnable(i).run();
//Никакой переуступки нет.
//Где же тот последовательный вывод сначала begin, а потом end?
//
//P.S. Yeld стоит там где нужно (задачу приняло), не буду спойлить где.
//Добил цикл до 100 и то же самое
//
//Или я не так проверяю?

//нити запускаются через threadname.start()
//Проверять надо так
// for (int i = 1; i <= 10; i++)  new Thread(new YieldRunnable(i)).start();
//У вас никаких нитей не создается, вызывается метод ран напрямую.

//Для наглядности, какой будет работать программа. Поэкспериментируйте с количеством одновременно запущенных потоков и попереставляйте yield в методе run, результат вывода будет интересный.
//
//ExecutorService service = Executors.newCachedThreadPool();
//        for (int i = 1; i <= 100; i++) {
//            service.execute(new YieldRunnable(i));
//        }
//service.shutdown();