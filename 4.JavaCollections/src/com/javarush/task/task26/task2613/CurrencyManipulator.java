package com.javarush.task.task26.task2613;

import java.util.Map;

/*
CashMachine (3)
1. Создай класс CurrencyManipulator, который будет хранить всю информацию про выбранную валюту.
Класс должен содержать:
1.1 String currencyCode - код валюты, например, USD. Состоит из трех букв.
1.2 Map<Integer, Integer> denominations - это Map<номинал, количество>.
Чтобы можно было посмотреть, к какой валюте относится манипулятор, добавим геттер для currencyCode.
Очевидно, что манипулятор никак не может функционировать без названия валюты, поэтому добавим конструктор
с этим параметром и проинициализируем currencyCode.

2. Валют может быть несколько, поэтому нам понадобится фабрика, которая будет создавать и хранить
манипуляторы.
Создай класс CurrencyManipulatorFactory со статическим методом
getManipulatorByCurrencyCode(String currencyCode).
В этом методе будем создавать нужный манипулятор, если он еще не существует,
либо возвращать ранее созданный.
Регистр при поиске манипулятора валюты не должен учитываться.
Подумай, где лучше хранить все манипуляторы? Маленькая подсказка, поле должно называться map.

Сделайте так, чтобы невозможно было создавать объекты CurrencyManipulatorFactory класса.

Требования:
1. Класс CurrencyManipulator должен быть создан в отдельном файле.
2. Класс CurrencyManipulator должен содержать приватное поле String currencyCode.
3. Класс CurrencyManipulator должен содержать приватное поле Map<Integer, Integer> denominations.
4. Класс CurrencyManipulator должен содержать геттер для поля currencyCode.
5. Класс CurrencyManipulator должен содержать конструктор с одним параметром,
инициализирующий поле currencyCode.
6. Класс CurrencyManipulatorFactory должен быть создан в отдельном файле.
7. Класс CurrencyManipulatorFactory должен иметь приватный дефолтный конструктор.
8. Класс CurrencyManipulatorFactory должен содержать приватное статическое поле
Map<String, CurrencyManipulator> map.
9. Класс CurrencyManipulatorFactory должен иметь статический метод
getManipulatorByCurrencyCode(String currencyCode).
 */
//класс CurrencyManipulator будет хранить всю информацию про выбранную валюту
public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {

    }
}
