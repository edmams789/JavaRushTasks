package com.javarush.task.task13.task1306;

/* 
Баг в initializeIdAndName
1. Подумать, что в программе неправильно.
2. Вынести реализацию метода initializeIdAndName в класс User.
3. initializeIdAndName в классе User должен возвращать тип User.
4. Поправить программу, чтобы компилировалась и работала.


Требования:
1. Интерфейс DBObject должен содержать только объявление метода initializeIdAndName без реализации.
2. Реализуй метод initializeIdAndName в классе User.
3. Метод initializeIdAndName в классе User должен иметь тип возвращаемого значения User.
4. Метод initializeIdAndName должен присваивать значения полям id и name объекта типа User
в соответствии с переданными ему параметрами и возвращать этот объект.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(Matrix.NEO);
        System.out.println(Matrix.TRINITY);
    }

    static class Matrix {
        public static DBObject NEO = new User().initializeIdAndName(1, "Neo");
        public static DBObject TRINITY = new User().initializeIdAndName(2, "Trinity");
    }

    interface DBObject {
        DBObject initializeIdAndName(long id, String name);

    }

    static class User implements DBObject {
        long id;
        String name;

        public User initializeIdAndName(long id, String name) {
            this.id = id;
            this.name = name;
            return this;
        }

        @Override
        public String toString() {
            return String.format("The user's name is %s, id = %d", name, id);
        }
    }

}
//Команда "new User().initializeIdAndName(1, "Neo");" работает так:
//1) Сначала создается объект типа "User": new User();
//2) У только что созданного объекта типа "User" вызываем метод initializeIdAndName(1, "Neo")
//
//Работа метода initializeIdAndName(1, "Neo"):
//1) Метод не статический, поэтому в него неявно передается ссылка на объект,
// от которого и вызываем этот метод, т.е. в нашем случае на только что созданный объект.
//2) Объект, от которого вызван метод, доступен в этом методе через ключевое слово "this".
//3) Т.о., в этом методе мы устанавливаем значения полей "id" и "name" у нашего созданного объекта
// и в конце возвращаем этот объект.
//
//Всё.
//Переменная "NEO" типа "DBObject" содержит ссылку на объект типа "User",
// у которого поле id = 1; поле name = "Neo".

//Метод initializeIdAndName в классе User должен иметь тип возвращаемого значения User.
// Это значит что в сигнатуре метода меняем DBObject на User