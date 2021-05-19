package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Ресторан(2)
1. Мы много работаем с консолью. Пора создать единую точку взаимодействия.
Создай класс ConsoleHelper с единственным BufferedReader, через который будем работать с консолью.
Запомни, этот класс не хранит никаких данных и состояний, поэтому все методы будут статическими.
Создай в нем три метода:
- writeMessage(String message) - для вывода message в консоль
- String readString() - для чтения строки с консоли
- List<Dish> getAllDishesForOrder() - просит пользователя выбрать блюдо и добавляет его в список.
Выведи список всех блюд и попроси пользователя ввести строку - название блюда.
Введенное 'exit' означает завершение заказа.
В случае, если введенное блюдо не представлено в меню, выведи сообщение о том, что такого блюда нет и продолжи формирование заказа.
Исключения ввода-вывода бросай выше, на этом уровне не понятно, что с ними делать.

2. Сделай рефакторинг - работа с консолью должна быть только через класс ConsoleHelper.

3. Вернемся к классу Order: в нем есть ссылка на планшет, и еще есть список выбранных блюд.
Инициализируй список dishes в конструкторе, вызвав метод getAllDishesForOrder из ConsoleHelper.

4. Перепиши метод toString в классе Order. Пусть он возвращает пустую строку, если нет блюд в заказе, иначе вывод должен быть аналогичным примеру в порядке добавления блюд. Используй ConsoleHelper.
Также измени метод toString в классе Tablet (внутри класса Tablet нажмите Alt+Insert -> toString()).
Пример:
Your order: [Juice, Fish] of Tablet{number=5}

5. У нас все завязано на работу с консолью. Однако, при возникновении исключений, наше приложение умрет.
Чтобы узнать причину - добавим в Tablet статическое поле logger типа java.util.logging.Logger,
инициализированное именем класса (Logger.getLogger(Tablet.class.getName())).

6. В методе createOrder класса Tablet обработаем исключения ввода-вывода.
Запишем в лог "Console is unavailable.". Уровень лога - SEVERE - это самый серьезный уровень, мы не можем работать.
Также в методе createOrder класса Tablet должен быть создан новый заказ.

7. Надо начинать тестировать наше приложение.
Добавьте в main создание планшета и создание четырех заказов.

Требования:
1. Метод writeMessage класса ConsoleHelper должен выводить полученную строку в консоль.
2. Метод readString класса ConsoleHelper должен возвращать строку считанную с консоли.
3. Метод getAllDishesForOrder класса ConsoleHelper должен возвращать список блюд выбранных пользователем.
4. В конструкторе класса Order список dishes должен быть инициализирован результатом работы метода getAllDishesForOrder.
5. Метод toString в классе Order должен возвращать содержимое заказа согласно условию задачи.
6. Поле logger в классе Tablet должно быть инициализировано с помощью метода Logger.getLogger()
с именем текущего класса в качестве параметра.
7. В методе createOrder класса Tablet должен быть создан новый заказ, в качестве параметра передай текущий планшет.
8. В случае возникновения IOException в процессе создания заказа - в лог должно быть записано сообщение
"Console is unavailable.", уровень - SEVERE.
9. В методе main класса Restaurant должен быть создан новый планшет и с его помощью созданы четыре новых заказа.
10. Метод toString в классе Tablet должен возвращать информацию о планшете (смотри пример в задании).
 */
public class ConsoleHelper {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

//Метод writeMessage класса ConsoleHelper должен выводить полученную строку в консоль.
    public static void writeMessage(String message) {//- для вывода message в консоль
        System.out.println(message);
    }
//Метод readString класса ConsoleHelper должен возвращать строку считанную с консоли.
    public static String readString() throws IOException {// - для чтения строки с консоли
        String str = bufferedReader.readLine();
        return str;
    }
//Метод getAllDishesForOrder класса ConsoleHelper должен возвращать список блюд выбранных пользователем.
    public static List<Dish> getAllDishesForOrder() throws IOException{ // - просит пользователя выбрать блюдо и добавляет его в список.
        List<Dish> dishes = new ArrayList<>();
        while (true) {
            writeMessage("");
            writeMessage("Выберите блюдо:");
            for (Dish dish : Dish.values()) {
                writeMessage(String.format("\t %s", dish.toString()));
            }
            writeMessage("\t exit - выход");
            writeMessage("");
            writeMessage("Введите название блюда:");
            String s = readString();
            if (s.toLowerCase().equals("exit")) {
                break;
            }
            else {
                try {
                    Dish dish = Dish.valueOf(s.substring(0, 1).toUpperCase() + s.substring(1));
                    dishes.add(dish);
                } catch (IllegalArgumentException e) {
                    writeMessage("Такое блюдо отсутствует в меню");
                }
            }
        }
        return dishes;
    }

}
