package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Рефакторинг (9)
9.2. Замена поля-массива объектом. Замени массив int[] size объектом нового типа Size, содержащим
публичные поля: рост int height и вес int weight. Публичный класс Size объяви внутри класса Human.
9.4.4. Примени в классе Human новый тип BloodGroup.

Требования:
2. Необходимо заменить массив int[] size класса Human объектом нового типа Size.
7. Необходимо изменить тип поля bloodGroup класса Human на BloodGroup, обновить сеттер и геттер.
8. Необходимо удалить из класса Human константы: FIRST, SECOND, THIRD, FOURTH.
 */
public class Human implements Alive {

    private List<Human> children = new ArrayList<>();

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }
    public void addChild(Human child){
        children.add(child);
    }
    public void removeChild(Human child){
        children.remove(child);
    }

    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;

  //  protected int[] size;
    protected Size size;
    public class Size {
        public int height;
        public int weight;
  }



    //    public static final int FIRST = 1;
//    public static final int SECOND = 2;
//    public static final int THIRD = 3;
//    public static final int FOURTH = 4;
  //  private int bloodGroup;
    private BloodGroup bloodGroup;

    public String getPosition() {
        return "Человек";
    }
    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }

//    public void setBloodGroup(int code) {
//        bloodGroup = code;
//    }
//    public int getBloodGroup() {
//        return bloodGroup;
//    }
//    public void setBloodGroup(BloodGroup bloodGroup) {
//        this.bloodGroup = bloodGroup;
//    }
    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }
    public void setBloodGroup(BloodGroup code) {
        this.bloodGroup = code;
    }
//В классе Human ты не обновил сеттер поля bloodGroup.

    public Human(boolean isSoldier) {

        this.id = nextId;
        nextId++;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void live() {}
    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }


}
//не зря же stringFormat проходили)
//System.out.println(String.format("%s: %s",getPosition(),name));