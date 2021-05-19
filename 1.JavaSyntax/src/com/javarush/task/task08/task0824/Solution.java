package com.javarush.task.task08.task0824;

/* 
Собираем семейство
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось:
два дедушки, две бабушки, отец, мать, трое детей.
3. Выведи все объекты Human на экран (Подсказка: используй метод toString() класса Human).

Требования:
1. Программа должна выводить текст на экран.
2. Класс Human должен содержать четыре поля.
3. Класс Human должен содержать один метод.
4. Класс Solution должен содержать один метод.
5. Программа должна создавать объекты и заполнять их так, чтобы получилось:
два дедушки, две бабушки, отец, мать, трое детей и выводить все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

//father.children.add(child1);

        ArrayList<Human> children = new ArrayList<>();

//        Human grandfather1 = new Human("Grandfather1", true, 65, children);
//        Human grandmother1 = new Human("Grandmother1", false, 50, children);
//        Human grandfather2 = new Human("Grandfather2", true, 70, children);
 //       Human grandmother2 = new Human("Grandmother2", false, 55, children);
//        Human father = new Human("Father", true, 45, children);
//        Human mother = new Human("Mother", false, 25, children);
//        Human child1 = new Human("Child1", true, 6, null);
      //  Human child2 = new Human("Child2", false, 7, null);
      //  Human child3 = new Human("Child3", true, 8, null);

 //       grandfather1.children.add(father);
//        grandmother1.children.add(father);
//        grandfather2.children.add(mother);
//        grandmother2.children.add(mother);
//        father.children.add(child1);
//        mother.children.add(child1);
//        child1.children.add(null);

    }
// ArrayList<Human> children = new ArrayList<>();
//Human papa = new Human("Kolya", true, 60, children );
//
//вся суть задачи... но намучалась пипец
    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        public ArrayList<Human> children;


//    public Human(String name, boolean sex, int age, ArrayList<Human> children) {

//        this.name = name;
//        this.age = age;
//        this.sex = sex;
//        this.children = children;
//        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) { //
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
//Не понял зачем конструктор здесь? Он только проблем добавляет.
//Просто создаете объекты в main, например:
//Human grandmother2 = new Human();
//        grandmother2.name = "Nadya";
//        grandmother2.sex = false;
//        grandmother2.age = 63;
//        grandmother2.children.add(mother);
//и печатаете:
//        System.out.println(grandmother2.toString());
//Ну и так далее.
//Начать надо только с детей, потом родители, дедки-бабки.
//Кода правда много, может кто красивей конечно может...