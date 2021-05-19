package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
1. Измени класс GenerateThread так, чтобы он стал нитью.
2. Создай конструктор GenerateThread, который должен:
2.1. Вызвать конструктор суперкласса с параметром String - номером созданной нити.
Используй createdThreadCount.
2.2. Запустить текущую нить.
2.3. Номер первой нити должен начинается с 1.
3. Переопредели метод toString, для этого внутри GenerateThread нажми Alt+Insert -> Override Methods.
Начни печатать toString.
3.1. Метод toString должен возвращать № текущей нити и слово " created". Используй getName().

Пример:
8 created

4. Пока количество созданных нитей меньше Solution.count метод run должен:
4.1. Создавать новую нить типа GenerateThread.
4.2. Выводить в консоль созданную в пункте 4.1 нить.
5. В итоге должно быть выведено в консоль 15 строк.
*/

public class Solution {
    static int count = 15;
    static volatile int createdThreadCount;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }
    public static class GenerateThread extends Thread {

        public GenerateThread() {
          super(String.valueOf("" + ++Solution.createdThreadCount));
            start();
        }
        public void run() {
                if (createdThreadCount < Solution.count)
            System.out.println(new GenerateThread());
            }
        @Override
        public String toString() {
            return getName() + " created";
        }}}

//1. System.out.println(new GenerateThread());  - строка провоцирует создание объекта.
//2. В конструкторе вызываем конструктор суперкласса - наша нить. В качестве параметра передаем имя нити.
// Имя нити должно быть задано при помощи переменной, которая по умолчанию не проинициализирована,
// а значит равна 0, а имя первой нити должно быть равно 1. Следовательно, просто инкреминируем
// переменную и передаем ее в качестве параметра. В качестве параметра мы должны передать строку,
// поэтому используем String.valueOf().
//3. Запускаем нить из того же конструктора.
//4. Это провоцирует вызов метода run() в котором проверяем, количество созданных нитей меньше count,
// если да то создаем новый объект GenerateThread, конструктор которого запустит новую нить и придет
// к этому же шагу. И так пока счетчик нитей не окажется равным счетчику count.
//5. Создание метода toString - думаю тут комментарии излишни.