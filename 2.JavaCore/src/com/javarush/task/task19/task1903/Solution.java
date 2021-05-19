package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов

Адаптируй IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры).
Обратите внимание на формат вывода фамилии и имени человека.


Требования:
1. Класс Solution должен содержать public static поле countries типа Map<String, String>.
2. В статическом блоке класса Solution инициализируй поле countries тестовыми данными согласно заданию.
3. Класс IncomeDataAdapter должен реализовывать интерфейсы Customer и Contact.
4. Класс IncomeDataAdapter должен содержать приватное поле data типа IncomeData.
5. Класс IncomeDataAdapter должен содержать конструктор с параметром IncomeData.
6. В классе IncomeDataAdapter реализуй методы интерфейсов Customer и Contact
используя подсказки в виде комментариев в интерфейсах.
*/

//В классе IncomeDataAdapter реализуй методы интерфейсов Customer и Contact используя подсказки
// в виде комментариев в интерфейсах.
//Метод getCountryName() должен вернуть страну из countries, по ключу getCountryCode() объекта data.

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
//2. В статическом блоке класса Solution инициализируй поле countries тестовыми данными согласно заданию.
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");



        for (Map.Entry<String, String> pair : countries.entrySet()){
//            String key = pair.getKey();
            String value = pair.getValue();
        }
    }
    public static void main(String[] args) {
//        IncomeData data = new IncomeData() {
//            public String getCountryCode() { return "Ukraine"; }
//            public String getCompany() { return "JavaRush Ltd."; }
//            public String getContactFirstName() { return "Ivan"; }
//            public String getContactLastName() { return "Ivanov"; }
//            public int getCountryPhoneCode() { return 38; }
//            public int getPhoneNumber() { return 501234567; }
//        };
//        IncomeDataAdapter a = new IncomeDataAdapter(data);
//
//        System.out.println(a.getCompanyName());
//        System.out.println(a.getCountryName());
//        System.out.println(a.getName());
//        System.out.println(a.getPhoneNumber());
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }
//IncomeDataAdapter incomeDataAdapter = new IncomeDataAdapter(data);
        @Override
        public String getCompanyName() {
            return data.getCompany();
        }
        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }
        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }
        @Override
        public String getPhoneNumber() {
            String phone = String.format("%010d",data.getPhoneNumber());
            return String.format("+%d(%s)%s-%s-%s", data.getCountryPhoneCode(), phone.substring(0, 3), phone.substring(3, 6),phone.substring(6, 8), phone.substring(8, 10));
//Форматирование номера через MaskFormatter валидатор принял.

//Спасибо за интересный способ! Возьму на вооружение
//Сам сделал через String.format . Валидатор принял с первого раза. На всякий случай оставлю здесь.
//@Override
//        public String getPhoneNumber() {
//            // add zeros up to 10 symbols number
//            String number10Symbols = String.format("%010d", data.getPhoneNumber());
//
//            // convert code and number to phone number style +12(345)-678-98-76
//            String phoneFormat = String.format("+%d(%s)%s-%s-%s",
//                    data.getCountryPhoneCode(),
//                    number10Symbols.substring(0, 3),
//                    number10Symbols.substring(3, 6),
//                    number10Symbols.substring(6, 8),
//                    number10Symbols.substring(8, 10));
//            return phoneFormat;
//        }

//String.format("%010d", data.getPhoneNumber());
//
//% - спец символ
//0 - чем дополняем
//10 - сколько цифр
//d - место для подстановки нашего значения

//String prolonged = String.format("%010d", data.getPhoneNumber());
//            return String.format("+%d(%3s)%3s-%2s-%2s",data.getCountryPhoneCode(), prolonged.substring(0, 3), prolonged.substring(3, 6), prolonged.substring(6, 8), prolonged.substring(8, 10));



//public String getPhoneNumber() {
//            String s = "" + data.getPhoneNumber();
//            while (s.length() < 10) {
//                s = 0 + s;
//            }
//            return String.format(
//                    "+%d(%s)%s-%s-%s",
//                    data.getCountryPhoneCode(),
//                    s.substring(0, 3),
//                    s.substring(3, 6),
//                    s.substring(6, 8),
//                    s.substring(8, 10)
//            );
//        }

//Для формирования строки с номером телефона можно попробовать такой вариант
//
//return "+" + data.getCountryPhoneCode() + String.format(
//                "%010d",
//                data.getPhoneNumber()
//            ).replaceFirst(
//                "(\\d{3})(\\d{3})(\\d{2})(\\d{2})",
//                "($1)$2-$3-$4"
//            );
        }
    }
    public static interface IncomeData {
        String getCountryCode();        //For example: UA
        String getCompany();            //For example: JavaRush Ltd.
        String getContactFirstName();   //For example: Ivan
        String getContactLastName();    //For example: Ivanov
        int getCountryPhoneCode();      //For example: 38
        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.
        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan
        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}
//Менять задуманную в заготовке задачи инициализацию Map нельзя.
//То есть вот это:
//public static Map<String, String> countries = new HashMap<String, String>();
//    static {
//        countries.put("UA", "Ukraine");
//        countries.put("RU", "Russia");
//        countries.put("CA", "Canada");
//    }
//
//менять на менее любительское вот это:
//public static Map<String, String> countries;
//    static {
//        Map<String, String> map = new HashMap<>();
//        map.put("UA", "Ukraine");
//        map.put("RU", "Russia");
//        map.put("CA", "Canada");
//        Solution.countries = Collections.unmodifiableMap(map);
//    }
//
//нельзя, во избежание появления странных коментариев валидатора, вводящих в полное недоумение,
// типа:
//
//Метод getName() должен вернуть строку состоящую из фамилии и имени, которые разделены запятой
// (смотри примеры).
// Фамилию нужно взять из getContactLastName(), а имя из getContactFirstName() объекта data.
//
//После возвращения инициализации Map к исходному виду задача была принята
// (без каких бы то ни было манипуляций с getName() или с чем угодно еще).
