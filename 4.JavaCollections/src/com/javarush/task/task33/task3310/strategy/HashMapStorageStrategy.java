package com.javarush.task.task33.task3310.strategy;

import java.util.HashMap;

/*
Shortener (5)
Давай напишем наше первое хранилище (стратегию хранилища). Внутри оно будет содержать обычный HashMap. Все стратегии будем хранить в пакете strategy.
5.1. Создай класс HashMapStorageStrategy, реализующий интерфейс StorageStrategy.
5.2. Добавь в класс поле HashMap<Long, String> data. В нем будут храниться наши данные.
5.3. Реализуй в классе все необходимые методы. Реализации методов должны использовать поле data.
Дополнительные поля не создавать.

Требования:
1. Класс HashMapStorageStrategy должен поддерживать интерфейс StorageStrategy.
2. В классе HashMapStorageStrategy должно быть создано и инициализировано поле data типа HashMap.
3. В классе HashMapStorageStrategy должен быть корректно реализован метод containsKey.
4. В классе HashMapStorageStrategy должен быть корректно реализован метод containsValue.
5. В классе HashMapStorageStrategy должен быть корректно реализован метод put.
6. В классе HashMapStorageStrategy должен быть корректно реализован метод getValue.
7. В классе HashMapStorageStrategy должен быть корректно реализован метод getKey.
 */
//Создай класс HashMapStorageStrategy, реализующий интерфейс StorageStrategy.
public class HashMapStorageStrategy implements StorageStrategy {
//Добавь в класс поле HashMap<Long, String> data. В нем будут храниться наши данные.
    private HashMap<Long, String> data = new HashMap<>();

    @Override
    public boolean containsKey(Long key) {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return data.containsValue(value);
    }

    @Override
    public void put(Long key, String value) {
        data.put(key, value);
    }

    @Override
    public Long getKey(String value) {
        for (Long key : data.keySet())
            if (data.get(key).equals(value))
        return key;
            return null;
    }

    @Override
    public String getValue(Long key) {
        return data.get(key);
    }
}
