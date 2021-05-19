package com.javarush.task.task27.task2712.kitchen;

import java.util.Arrays;

//1.5. Нам нужен класс Dish(Блюдо), создадим его в пакете kitchen. Пусть это будет enum со списком блюд:
//Fish, Steak, Soup, Juice, Water.
//В пакете kitchen должен быть создан enum Dish с элементами Fish, Steak, Soup, Juice, Water.
public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

//1.6. Чтобы пользователь мог выбрать себе блюда, нужно их все ему отобразить. Для этого в Dish
//создай метод public static String allDishesToString(), который сформирует строку из всех блюд.
//В Dish должен быть создан статический метод allDishesToString, динамически формирующий строку из всех блюд.
    public static String allDishesToString() {
        return Arrays.toString(values());
    }
}




