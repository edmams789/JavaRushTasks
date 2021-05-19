package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/*
Shortener (16)
Что можешь сделать самостоятельно (тестов на этот пункт нет):
- Добавить стратегию, основанную на работе с базой данных. Гугли JDBC.
- Сделать веб сервис, который будет для любого url или строки возвращать идентификатор, а для идентификатора строку.
- Написать вариант HashMap с использованием двух потоков, где один поток будет отвечать за работу с элементами, а второй следить за количеством элементов. Когда количество элементов превысит порог threshold, второй поток должен увеличить размер table в 2 раза. При этом, первый поток ничего не должен знать о пороге.

Твои достижения:
- Повторил паттерн Стратегия.
- Получил опыт работы с библиотекой Guava.
- Получил опыт работы с Apache Commons Collections.
- Попробовал писать тесты, используя Junit.
- Еще на шаг продвинулся к работе Java программистом.

Поздравляю! Я горжусь тобой!
Ты отличный ученик!

Требования:
1. Shortener готов!
 */
public class Solution {
    public static void main(String[] args) {
//8. В методе main должен быть вызван метод testStrategy.
//6.2.4. Добавь метод main(). Внутри метода протестируй стратегию HashMapStorageStrategy с помощью 10000 элементов.
//6.3. Проверь, что программа работает и тест пройден.
        StorageStrategy strategy1 = new HashMapStorageStrategy();
        testStrategy(strategy1, 10000);
//        StorageStrategy strategy2 = new FileStorageStrategy();
//        testStrategy(strategy2, 10000);
        StorageStrategy strategy3 = new OurHashMapStorageStrategy();
        testStrategy(strategy3, 10000);
        StorageStrategy strategy4 = new OurHashBiMapStorageStrategy();
        testStrategy(strategy4, 10000);
        StorageStrategy strategy5 = new HashBiMapStorageStrategy();
        testStrategy(strategy5, 10000);
        StorageStrategy strategy6 = new DualHashBidiMapStorageStrategy();
        testStrategy(strategy6, 10000);
    }
//6.2. Добавь в класс Solution реализации вспомогательных статических методов:
//6.2.1. Set<Long> getIds(Shortener shortener, Set<String> strings).
// Этот метод должен для переданного множества строк возвращать множество идентификаторов.
// Идентификатор для каждой отдельной строки нужно получить, используя shortener.
    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> result = new HashSet<>();
        for (String s : strings)
            result.add(shortener.getId(s));

        return result;
    }

//6.2.2. Set<String> getStrings(Shortener shortener, Set<Long> keys).
// Метод будет возвращать множество строк, которое соответствует переданному множеству идентификаторов.
//При реальном использовании Shortener, задача получить из множества строк множество идентификаторов
// и наоборот скорее всего не встретится, это нужно исключительно для тестирования.
    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> result = new HashSet<>();
        for (Long id : keys)
            result.add(shortener.getString(id));

        return result;
    }

//6.2.3. testStrategy(StorageStrategy strategy, long elementsNumber).
// Метод будет тестировать работу переданной стратегии на определенном количестве элементов elementsNumber.
    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
// Реализация метода должна:
//6.2.3.1. Выводить имя класса стратегии. Имя не должно включать имя пакета.
        System.out.println(strategy.getClass().getSimpleName());

//6.2.3.2. Генерировать тестовое множество строк, используя Helper и заданное количество элементов elementsNumber.
        Set<String> strings = new HashSet<>();
        Long[] elements = new Long[(int) elementsNumber];

        for (int i = 0; i < elementsNumber; i++)
            strings.add(Helper.generateRandomString());

//6.2.3.3. Создавать объект типа Shortener, используя переданную стратегию.
        Shortener shortener = new Shortener(strategy);

//6.2.3.4. Замерять и выводить время необходимое для отработки метода getIds для заданной стратегии и заданного множества
// элементов. Время вывести в миллисекундах. При замере времени работы метода можно пренебречь переключением
// процессора на другие потоки, временем, которое тратится на сам вызов, возврат значений и вызов методов
// получения времени (даты). Замер времени произведи с использованием объектов типа Date.
        Date startDataTime = new Date();
        Set<Long> ids = (Set<Long>) getIds(shortener, strings);

        Date finishDateTime = new Date();
        long deltaTime = finishDateTime.getTime() - startDataTime.getTime();
        Helper.printMessage(Long.toString(deltaTime));

//6.2.3.5. Замерять и выводить время необходимое для отработки метода getStrings для заданной стратегии и
// полученного в предыдущем пункте множества идентификаторов.
        startDataTime = new Date();
        Set<String> strs = (Set<String>) getStrings(shortener, ids);

        finishDateTime = new Date();
        deltaTime = finishDateTime.getTime() - startDataTime.getTime();
        Helper.printMessage(Long.toString(deltaTime));

//6.2.3.6. Сравнивать одинаковое ли содержимое множества строк, которое было сгенерировано и множества,
// которое было возвращено методом getStrings. Если множества одинаковы, то выведи "Тест пройден.",
// иначе "Тест не пройден.".
        if (strings.equals(strs))
            Helper.printMessage("Тест пройден.");
        else
            Helper.printMessage("Тест не пройден.");
}
}
