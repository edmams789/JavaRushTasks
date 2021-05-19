package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Order;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

//1.2. Начнем с планшета, создадим класс Tablet, в котором создадим поле private final int number -
//это номер планшета, чтобы можно было однозначно установить, откуда поступил заказ.
//Номер планшета должен инициализироваться в конструкторе переданным параметром.
//3.2. Tablet создает заказы, а Cook их обрабатывает.
// Расставь правильно Observer и Observable между Tablet и Cook.
//Класс Tablet должен быть потомком класса Observable.
public class Tablet extends Observable {
//В классе Tablet должно быть создано поле private final int number.
    private final int number;
//Конструктор класса Tablet должен принимать 1 параметр типа int и инициализировать поле number.
    public Tablet(int number) {
        this.number = number;
    }
//1.3. В классе Tablet создадим метод public void createOrder(), который будет создавать заказ из тех блюд,
//которые выберет пользователь.
//Для этого создадим класс Order, который поместим в пакет kitchen.
//В классе Tablet должен существовать метод public void createOrder().
    public void createOrder() {
//2.6. В методе createOrder класса Tablet обработаем исключения ввода-вывода.
//Запишем в лог "Console is unavailable.". Уровень лога - SEVERE - это самый серьезный уровень, мы не можем работать.
//Также в методе createOrder класса Tablet должен быть создан новый заказ.
//В методе createOrder класса Tablet должен быть создан новый заказ, в качестве параметра передай текущий планшет.
        Order order = null;
        try {
          new Order(this);
//5. Также внесем небольшое изменение. Сделай так чтобы метод createOrder возвращал текущий заказ или null,
//если заказ создать не удалось.
            if (order != null) {
                return;
            }
        } catch (Exception e) {
//В случае возникновения IOException в процессе создания заказа - в лог должно быть записано сообщение
// "Console is unavailable.", уровень - SEVERE.
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
//В методе createOrder класса Tablet должен быть вызван метод setChanged.
        setChanged();
//В методе createOrder класса Tablet должен быть вызван метод notifyObservers с текущим заказом в качестве
//параметра.
        notifyObservers(this);

    }
//2.5. У нас все завязано на работу с консолью. Однако, при возникновении исключений, наше приложение умрет.
//Чтобы узнать причину - добавим в Tablet статическое поле logger типа java.util.logging.Logger,
//инициализированное именем класса (Logger.getLogger(Tablet.class.getName())).
//Поле logger в классе Tablet должно быть инициализировано с помощью метода Logger.getLogger()
// с именем текущего класса в качестве параметра.
    static Logger logger = Logger.getLogger(Tablet.class.getName());
//2.4. Перепиши метод toString в классе Order. Пусть он возвращает пустую строку, если нет блюд в заказе,
// иначе вывод должен быть аналогичным примеру в порядке добавления блюд. Используй ConsoleHelper.
//Также измени метод toString в классе Tablet (внутри класса Tablet нажмите Alt+Insert -> toString()).
//Пример:
//Your order: [Juice, Fish] of Tablet{number=5}
    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
