package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
Напиши класс Human с 6 полями.
Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. В классе Human должно быть 6 полей.
3. Все поля класса Human должны быть private.
4. В классе Human должно быть 10 конструкторов.
5. Все конструкторы класса Human должны быть public.
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private boolean sex;
        private int id;
        private int height;
        private int weight;

        public Human(String name) { }
        public Human(String name, int age) { }
        public Human(String name, int age, boolean sex) { }
        public Human(String name, int age, boolean sex, int id) { }
        public Human(String name, int age, int id) { }
        public Human(boolean sex, int height, int weight) { }
        public Human(String name, int age, boolean sex, int id, int height) { }
        public Human(String name, int age, int height, int weight) { }
        public Human(String name, int age, boolean sex, int id, int height, int weight) { }
        public Human(int id, int height, int weight) { }

    }
}
//public static class Human {
//    private static String name;
//    private static String profession;
//    private static int age;
//    private static int sex;
//    private static Human mama;
//    private static Human papa;
//
//    public Human(String name, int age, int sex) {  }
//    public Human(String name, int age, int sex, String profession) {}
//    public Human(String name, int age, String profession) {}
//    public Human(String name, int sex) {}
//    public Human(int age, int sex) {}
//    public Human(int age, int sex, String profession) {}
//    public Human(String name, int age, int sex, Human mama, Human papa) {}
//    public Human(String name, Human mama) {}
//    public Human(String name, int age, Human mama) {}
//    public Human(String name, String profession, Human mama) {}
//}