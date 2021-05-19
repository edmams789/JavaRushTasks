package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

//1.3. В классе Tablet создадим метод public void createOrder(), который будет создавать заказ из тех блюд,
//которые выберет пользователь.
//Для этого создадим класс Order, который поместим в пакет kitchen.
//В пакете kitchen должен быть создан класс Order, содержащий в себе список блюд(dishes), а также планшет(tablet).
public class Order { // - заказ
//1.4. В классе Order (заказ) должна быть информация, относящаяся к списку выбранных пользователем блюд.
//Т.е. где-то должен быть список всех блюд, и должен быть список выбранных блюд в классе Order.
//В классе Order нужны поля private final Tablet tablet и protected List<Dish> dishes.
//Конструктор должен принимать один параметр типа Tablet и инициализировать поле tablet.
    private final Tablet tablet;
    protected List<Dish> dishes;

//Конструктор класса Order должен принимать один параметр типа Tablet и инициализировать поле tablet.
        public Order(Tablet tablet) throws IOException {
            this.tablet = tablet;
//2.3. Вернемся к классу Order: в нем есть ссылка на планшет, и еще есть список выбранных блюд.
//Инициализируй список dishes в конструкторе, вызвав метод getAllDishesForOrder из ConsoleHelper.
//В конструкторе класса Order список dishes должен быть инициализирован результатом работы метода getAllDishesForOrder.
            this.dishes = ConsoleHelper.getAllDishesForOrder();

        }
//2.4. Перепиши метод toString в классе Order. Пусть он возвращает пустую строку, если нет блюд в заказе,
// иначе вывод должен быть аналогичным примеру в порядке добавления блюд. Используй ConsoleHelper.
//5. Метод toString в классе Order должен возвращать содержимое заказа согласно условию задачи.
    @Override
    public String toString() {
            return dishes.isEmpty() ? "" : String.format("Your order: %s of %s", dishes, tablet);
    }

}



