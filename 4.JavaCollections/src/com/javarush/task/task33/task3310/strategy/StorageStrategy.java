package com.javarush.task.task33.task3310.strategy;
/*
Shortener (2)
Укорачиватель Shortener будет поддерживать разные стратегии хранения данных (строк и их идентификаторов). Все эти стратегии будут наследоваться от интерфейса StorageStrategy. Почитай подробнее про паттерн Стратегия на Вики.
Наше хранилище будет оперировать двумя понятиями: ключ и значение. Ключом будет идентификатор строки, а значением сама строка.

2.1. Добавь интерфейс StorageStrategy в пакет strategy.
2.2. Добавь в интерфейс следующие методы:
2.2.1. boolean containsKey(Long key) - должен вернуть true, если хранилище
содержит переданный ключ.
2.2.2. boolean containsValue(String value) - должен вернуть true, если хранилище
содержит переданное значение.
2.2.3. void put(Long key, String value) - добавить в хранилище новую пару ключ -
значение.
2.2.4. Long getKey(String value) - вернуть ключ для переданного значения.
2.2.5. String getValue(Long key) - вернуть значение для переданного ключа.

Требования:
1. В интерфейсе StorageStrategy должен быть объявлен метод boolean containsKey(Long key).
2. В интерфейсе StorageStrategy должен быть объявлен метод boolean containsValue(String value).
3. В интерфейсе StorageStrategy должен быть объявлен метод void put(Long key, String value).
4. В интерфейсе StorageStrategy должен быть объявлен метод Long getKey(String value).
5. В интерфейсе StorageStrategy должен быть объявлен метод boolean String getValue(Long key).
6. Интерфейс StorageStrategy должен быть создан в пакете strategy.
 */
public interface StorageStrategy {
//2.1. Добавь интерфейс StorageStrategy в пакет strategy.

//2.2. Добавь в интерфейс следующие методы:
//2.2.1. boolean containsKey(Long key) - должен вернуть true, если хранилище
//содержит переданный ключ.
    boolean containsKey(Long key);

//2.2.2. boolean containsValue(String value) - должен вернуть true, если хранилище
//содержит переданное значение.
    boolean containsValue(String value);

//2.2.3. void put(Long key, String value) - добавить в хранилище новую пару ключ - значение.
    void put(Long key, String value);

//2.2.4. Long getKey(String value) - вернуть ключ для переданного значения.
    Long getKey(String value);

//2.2.5. String getValue(Long key) - вернуть значение для переданного ключа.
    String getValue(Long key);
}
