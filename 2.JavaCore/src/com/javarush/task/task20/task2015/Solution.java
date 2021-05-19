package com.javarush.task.task20.task2015;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* 
Переопределение сериализации
Сделайте так, чтобы после десериализации нить runner продолжила работать.
Ключевые слова объекта runner менять нельзя.

Hint/Подсказка:
Конструктор не вызывается при десериализации, только инициализируются все поля.


Требования:
1. Класс Solution должен поддерживать интерфейс Serializable.
2. Класс Solution должен поддерживать интерфейс Runnable.
3. Поле runner в классе Solution должно быть объявлено с модификатором transient.
4. В методе readObject должен быть создан новый объект типа Thread с текущим объектом в качестве параметра.
5. В методе readObject должен быть вызван метод start у нового объекта типа Thread.
*/
public class Solution implements Serializable, Runnable {
//3. Поле runner в классе Solution должно быть объявлено с модификатором transient.
    transient private Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, doesn't matter what
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(runner);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        runner = (Thread) in.readObject();
//4. В методе readObject должен быть создан новый объект типа Thread с текущим объектом в качестве параметра.
        Thread thread = new Thread(this);
//5. В методе readObject должен быть вызван метод start у нового объекта типа Thread.
        thread.start();
    }

    public static void main(String[] args) {

    }
}
//Подскажите, для чего мы передаем this в конструктор  Thread() ??
//А это суть многопоточности по 1-му варианту, когда объект имплементирует Runnable:
// Сначала создаем объект Runnable, где реализован метод run(), а затем - передаем его
// в конструктор Thread и далее - созданный thread стартуем. Просто в последних задачах
// по многопоточности мы сразу создавали объект наследованный от Thread и имплементировали
// run() прямо в нем - более короткий путь.