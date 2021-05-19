package com.javarush.task.task26.task2613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
CashMachine (4)
1. Выберем операцию, с которой мы сможем начать.
Подумаем. В банкомате еще денег нет, поэтому INFO и WITHDRAW протестить не получится.
Начнем с операции DEPOSIT - поместить деньги.
Считаем с консоли код валюты, потом считаем номинал и количество банкнот, а потом добавим их в манипулятор.

2. Чтобы считать код валюты, добавим статический метод String askCurrencyCode() в ConsoleHelper.
Этот метод должен предлагать пользователю ввести код валюты, проверять, что код содержит 3 символа.
Если данные некорректны, то сообщить об этом пользователю и повторить.
Если данные валидны, то перевести код в верхний регистр и вернуть.

3. Чтобы считать номинал и количество банкнот, добавим статический метод
String[] getValidTwoDigits(String currencyCode) в ConsoleHelper.
Этот метод должен предлагать пользователю ввести два целых положительных числа.
Первое число - номинал, второе - количество банкнот.
Никаких валидаторов на номинал нет. Т.е. 1200 - это нормальный номинал.
Если данные некорректны, то сообщить об этом пользователю и повторить.

Пример вводимых данных:
200 5

4. В классе CurrencyManipulator создай метод void addAmount(int denomination, int count),
который добавит введенные номинал и количество банкнот.

5. Пора уже увидеть приложение в действии.
В методе main захардкодь логику пункта 1.
Кстати, чтобы не было проблем с тестами на стороне сервера, добавь в метод main первой строчкой
Locale.setDefault(Locale.ENGLISH);
Запускаем, дебажим, смотрим.


Требования:
1. Класс ConsoleHelper должен иметь статический метод String askCurrencyCode().
2. Класс ConsoleHelper должен иметь статический метод String[] getValidTwoDigits(String currencyCode).
3. Класс CurrencyManipulator должен иметь метод void addAmount(int denomination, int count).
4. Метод main класса CashMachine должен считывать с консоли код валюты, потом считывать номинал и
количество банкнот, а потом добавлять их в манипулятор.
 */
public class ConsoleHelper {

    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String str = bis.readLine();
        return str;
    }
//Чтобы считать код валюты, добавим статический метод String askCurrencyCode() в ConsoleHelper.
    public static String askCurrencyCode() throws IOException {
//Этот метод должен предлагать пользователю ввести код валюты, проверять, что код содержит 3 символа.
        String code = null;

        writeMessage("Please choice currency code:");
        while (true) {
            code = readString();
            if (code.length() == 3)
                break;
            else
                writeMessage("Error, Please choice again:");

//            String cod = bis.readLine();
//
//        if (cod.length() != 3) {
//            System.out.println("Данные не корректны.");
//            System.out.println("Введите код валюты: ");
//
//        }
        }
            return code.toUpperCase();

// {
//            String code = null;
//            writeMessage("Please choice currency code:");
//            while (true) {
//                code = readString();
//                if (code.length() == 3)
//                    break;
//                else
//                    writeMessage("Error, Please choice again:");
//
//            }
//            return code.toUpperCase();
//        }


//Если данные некорректны, то сообщить об этом пользователю и повторить.

//Если данные валидны, то перевести код в верхний регистр и вернуть.

    }
//3. Чтобы считать номинал и количество банкнот, добавим статический метод
//String[] getValidTwoDigits(String currencyCode) в ConsoleHelper.
    public static String[] getValidTwoDigits(String currencyCode) throws IOException {
//        String[] input = new String[0];
//        System.out.println("Введите номинал: ");
//        int nom = Integer.parseInt(bis.readLine());
//        System.out.println("Введите количество банкнот: ");
//        int col = Integer.parseInt(bis.readLine());
//        if (nom == 0 || col == 0) {
//            System.out.println("Данные не корректны.");
//
//        }
//        return input;
      //  System.out.println("Введите номинал и количество банкнот: ");
        writeMessage("Input nominal and total:");

        String[] input;
        while (true) {
            input = readString().split(" ");

            int nominal = 0;
            int total = 0;
            try {
                nominal = Integer.parseInt(input[0]);
                total = Integer.parseInt(input[1]);
            } catch (Exception e) {
              //  System.out.println("Данные не корректны.");
                writeMessage("Error, Repeat again:");
                continue;
            }
            if (nominal <= 0 || total <= 0) {
            //    System.out.println("Данные не корректны.");
                writeMessage("Error, Repeat again:");
                continue;
            }
            break;
        }
        return input;
    }

    public static Operation askOperation() {
        return null;
    }
}

//Этот метод должен предлагать пользователю ввести два целых положительных числа.
//Первое число - номинал, второе - количество банкнот.
//Никаких валидаторов на номинал нет. Т.е. 1200 - это нормальный номинал.
//Если данные некорректны, то сообщить об этом пользователю и повторить.