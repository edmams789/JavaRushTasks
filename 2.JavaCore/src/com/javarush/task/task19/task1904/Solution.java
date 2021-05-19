package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
И еще один адаптер

Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
В классе адаптере создать приватное финальное поле Scanner fileScanner.
Поле инициализировать в конструкторе с одним аргументом типа Scanner.

Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950
Петров Петр Петрович 31 12 1957

В файле хранится большое количество людей, данные одного человека находятся в одной строке.
Метод read() должен читать данные только одного человека.


Требования:
1. PersonScanner должен быть интерфейсом.
2. Класс PersonScannerAdapter должен реализовывать интерфейс PersonScanner.
3. Класс PersonScannerAdapter должен содержать приватное поле fileScanner типа Scanner.
4. Класс PersonScannerAdapter должен содержать конструктор с параметром Scanner.
5. Метод close() класса PersonScannerAdapter должен делегировать полномочие такому же методу fileScanner.
6. Метод read() класса PersonScannerAdapter должен читать строку с файла, парсить её,
и возвращать данные только одного человека, в виде объекта класса Person.
*/

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        System.out.println(new PersonScannerAdapter(new Scanner(new File("C:\\Users\\Александр\\Desktop\\test.txt"),"windows-1251")).read());
    //Для теста (в  main):
//        String name = "Иванов Иван Иванович 13 09 1993";
//
//        PersonScannerAdapter adapter = new PersonScannerAdapter(new Scanner(name));
//
//        System.out.println(adapter.read());
    }

    public static class PersonScannerAdapter implements PersonScanner {

        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }
//В конструкторе объекта типа Scanner ты указываешь место с которого будешь читать,
// это может быть клавиатура = new Scanner(System.in) или файл = new Scanner(new File("имя файла")).
// Выглядит это так : Scanner scanner = new Scanner(System.in).
//То есть в конструктор адаптера (в данном случае это класс PersonScannerAdapter)
// ты передаёшь объект типа Scanner, который уже знает от куда ему читать. В данной задаче это
// любой какой-нибудь абстрактный файл, который занесён в конструктор объекта Scanner.
// Какой именно файл тебя не касается, ведь ты  работаешь с переменной типа Scanner,
// которая и без тебя знает от куда ей читать данные.

//6. Метод read() класса PersonScannerAdapter должен читать строку с файла, парсить её,
//и возвращать данные только одного человека, в виде объекта класса Person.
        @Override
        public Person read() throws IOException, ParseException {
         //   String line = fileScanner.nextLine().split("\\s", 4);
            SimpleDateFormat sdf  = new SimpleDateFormat("ddMMyyyy");
            String[] line = fileScanner.nextLine().split(" ", 4);
           // String[] line = fileScanner.nextLine().split(" ");

            Date birthDate = sdf.parse(String.format(line[3], line[4], line[5]));

            return new Person(line[1], line[2], line[0], birthDate);
        }
//5. Метод close() класса PersonScannerAdapter должен делегировать полномочие такому же методу fileScanner.
        @Override
        public void close() throws IOException {
            fileScanner.close();

        }//new SimpleDateFormat("dd/MM/yyyy").parse( String.format("%s/%s/%s", string[3], string[4], string[5]) )
    }
}
//Удалось пройти валидатор с 3й попытки. Обратите особое внимание на реализацию метода read().
//
//1) При создании Person, параметры (Имя, Отчество, Фамилия, датаРождения). А в файле храниться,
// и сканер выводит в другой последовательности (Фамилия, Имя, Отчество, датаРождения).
//2) Инициализация даты рождение необходимо выполнять через SimpleDateFormat
//SimpleDateFormat sdf  = new SimpleDateFormat("dd MM yyyy");
//Date dob = sdf.parse(String.format( "%s %s %s", date, month, year));

//1) Метод read() работает с конкретным объектом fileScanner класса Scanner, который ты передал
// в конструкторе public PersonScannerAdapter(Scanner fileScanner). То есть у тебя уже есть
// конкретный Scanner привязанный к какому-то конкретному InputStream. Это осталось за границей
// твоей задачи, и ты принимаешь это как условие. Важно то, что этот InputStream имеет такую
// структуру, в которой каждая строчка содержит данные одного пользователя. То есть необходимо
// обратится к этому объекту и просто считать первую доступную строку после чего необходимо
// обработать строку в необходимом порядке, сама строка имеет четкую структуру.
//2) Объект Person при создании должен получать данные в такой последовательности
// (Имя, Отчество, Фамилия, датаРождения), а выводит и хранит в исходном файле из которого ты
// считываешь в другой последовательности (Фамилия, Имя, Отчество, датаРождения). Обрати на это внимание.

//Спасибо за более академический вариант задания даты. Правда мне немного больше понравился вариант для
// лентяев, вот реализация: new SimpleDateFormat("dd/MM/yyyy").parse( String.format("%s/%s/%s", string[3],
// string[4], string[5]) ). Получается, что ты создаешь дату просто по маске, которую сам и задаешь.
// Я был еще ленивее и сразу запихнул в парсер даты, форматор строки с аналогичной маской.

//Оказывается что Scanner читает лексемы из некоторого лежащего в основе источника, который вы указываете
// при создании обьекта класса Scanner(это может быть строка, файл и т.д.)
//лексема(token) -это порция ввода, отделенная набором разделителей, которые по умолчанию пробелы.
//Подробно Шилдт (стр 579 -589)
//Ответить
//+4
//Даниленко Виктор40 уровень, Днепр
//10 октября 2017, 15:54
//Scanner вообще довольно полезная вещь на самом деле Это одновременно и ридер + обертка токенизер
// для классов reader или inputStream.
//Но его методы несинхронизированы.
//И он немного медленней читает большие файлы чем BufferedReader. Но именно что немного и большие файлы.
//
//Аналогом использования Scanner может быть:
//new StringTokenizer(new BufferedReader(...).readline());
//который каждую строку разбивает на токены.