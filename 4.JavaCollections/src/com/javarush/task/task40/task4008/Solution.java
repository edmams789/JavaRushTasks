package com.javarush.task.task40.task4008;

/*
Работа с Java 8 DateTime API

Выполни задание, используя Java 8 DateTime API.
Реализуй метод printDate(String date).
Он должен в качестве параметра принимать дату (в одном из 3х форматов)
и выводить ее в консоль в соответствии с примером:

1) Для "9.10.2017 5:56:45" вывод должен быть:
День: 9
День недели: 1
День месяца: 9
День года: 282
Неделя месяца: 3
Неделя года: 42
Месяц: 10
Год: 2017
AM или PM: PM
Часы: 5
Часы дня: 5
Минуты: 56
Секунды: 45

2) Для "21.4.2014":
День: 21
День недели: 1
День месяца: 21
День года: 111
Неделя месяца: 4
Неделя года: 17
Месяц: 4
Год: 2014

3) Для "17:33:40":
AM или PM: PM
Часы: 5
Часы дня: 17
Минуты: 33
Секунды: 40


Требования:
1. Если в метод printDate передана дата в формате "дата время", он должен вывести:
День, День недели, День месяца, День года, Неделя месяца, Неделя года, Месяц, Год, AM или PM, Часы, Часы дня, Минуты, Секунды.
2. Если в метод printDate передана дата в формате "дата", он должен вывести:
День, День недели, День месяца, День года, Неделя месяца, Неделя года, Месяц, Год.
3. Если в метод printDate передана дата в формате "время", он должен вывести:
AM или PM, Часы, Часы дня, Минуты, Секунды.
4. Используй статический метод parse классов LocalDate и LocalTime.
*/

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        String[] splt = date.split(" ");
        String sdate = null;
        String stime = null;

        if (splt.length == 1) {
            sdate = splt[0].contains(".") ? splt[0] : null;
            stime = splt[0].contains(":") ? splt[0] : null;
        }
        if (splt.length == 2) {
            sdate = splt[0].contains(".") ? splt[0] : null;
            stime = splt[1].contains(":") ? splt[1] : null;
        }

        DateTimeFormatter formatter;
        if (sdate != null) {
            formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
            LocalDate dateTime = LocalDate.parse(sdate, formatter);
            System.out.println("День: " + dateTime.getDayOfMonth());
            System.out.println("День недели: " + dateTime.getDayOfWeek().getValue());
            System.out.println("День месяца: " + dateTime.getDayOfMonth());
            System.out.println("День года: " + dateTime.getDayOfYear());
            System.out.println("Неделя месяца: " + dateTime.get(WeekFields.of(Locale.getDefault()).weekOfMonth()));
            System.out.println("Неделя года: " + dateTime.get(WeekFields.of(Locale.getDefault()).weekOfYear()));
            System.out.println("Месяц: " + dateTime.getMonthValue());
            System.out.println("Год: " + dateTime.getYear());
        }
        if (stime != null) {
            formatter = DateTimeFormatter.ofPattern("H:m:s");
            LocalTime dateTime = LocalTime.parse(stime, formatter);
            System.out.println("AM или PM: " + (dateTime.get(ChronoField.AMPM_OF_DAY) == 0 ? "AM" : "PM"));
            System.out.println("Часы: " + dateTime.get(ChronoField.HOUR_OF_AMPM));
            System.out.println("Часы дня: " + dateTime.getHour());
            System.out.println("Минуты: " + dateTime.getMinute());
            System.out.println("Секунды: " + dateTime.getSecond());
        }
    }
}
//форматировать надо так:
//
//DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("d.M.yyyy");
//DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("H:m:s");

//localDate.get(ChronoField.ALIGNED_WEEK_OF_MONTH)
//localDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR)
//либо так
//localDate.get(WeekFields.of(Locale.getDefault()).weekOfMonth()))
//и еще куча вариантов.