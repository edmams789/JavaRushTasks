package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends UniversityPerson {

    private int numberOfStudents;

    public Teacher(String name, int age, int numberOfStudents) {
        super(false);
        this.name = name;
        this.age = age;
        this.numberOfStudents = numberOfStudents;
    }
    @Override
    public String getPosition() {
        return "Преподаватель";
    }
    public void live() {
        teach();
    }

    public void teach() {
    }
//    public void printData() {
//        System.out.println("Преподаватель: " + name);
//    }
}