package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;

import java.util.ArrayList;
import java.util.List;

/*

 */
public class Restaurant {
//1.1. Создай класс Restaurant с методом main.
//В классе Restaurant должен быть создан метод public static void main(String[] args).
    public static void main(String[] args) {
//7. Надо начинать тестировать наше приложение.
//Добавьте в main создание планшета и создание четырех заказов.
//В методе main класса Restaurant должен быть создан новый планшет и с его помощью созданы четыре новых заказа.
        List<Tablet> tablets = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablets.add(tablet);
            tablet.createOrder();
        }
//8. В методе main класса Restaurant должен быть создан новый повар и добавлен планшету в качестве наблюдателя
//с помощью метода addObserver.
        Cook cook1 = new Cook("Amigo");

    }
//3. Пишем main.
//Для объекта Observable добавляем свой объект Observer. См. п.2 и описание паттерна в wikipedia
//Называем повара, имя не влияет на тесты. В моем варианте - это Amigo : )


}

//
//Сверим выводы в консоль. Пример моего вывода:
//Your order: [Soup] of Tablet{number=5}
//Start cooking - Your order: [Soup] of Tablet{number=5}

