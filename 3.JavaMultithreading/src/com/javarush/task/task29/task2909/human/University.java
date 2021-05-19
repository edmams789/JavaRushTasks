package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
6.2. Добавление параметра. Добавить параметр с типом double в метод getStudentWithAverageGrade(),
чтобы было понятно с каким средним балом нужен студент.
Реализуй метод getStudentWithAverageGrade().

2. Необходимо добавить параметр с типом double в метод getStudentWithAverageGrade() класса University
и реализовать метод.
3. Необходимо удалить параметр из метода getStudentWithMaxAverageGrade(double) класса University
и реализовать метод.
4. Необходимо разделить метод getStudentWithMinAverageGradeAndExpel
на Student getStudentWithMinAverageGrade() и void expel(Student student) и реализовать эти два метода.
 */
public class University {

    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        return students
                .stream()
                .filter(x -> averageGrade == x.getAverageGrade())
                .findFirst()
                .get();
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        return Collections.max(students, Comparator.comparingDouble(Student::getAverageGrade));
    }

//    public void getStudentWithMinAverageGradeAndExpel() {
//        //TODO:
//    }
    public Student getStudentWithMinAverageGrade() {
        return Collections.min(students, Comparator.comparingDouble(Student::getAverageGrade));
    }
    public void expel(Student student) {
        students.remove(student);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
//public Student getStudentWithAverageGrade(double averageGrade) {
//        //TODO:
//        return students
//                .stream()
//                .filter(x -> averageGrade == x.getAverageGrade())
//                .findFirst()
//                .get();
//    }
//
//    public Student getStudentWithMaxAverageGrade() {
//        //TODO:
//        return students
//                .stream()
//                .max((x,y) -> Double.compare(x.getAverageGrade(),y.getAverageGrade()))
//                .get();
//    }
//
//    public Student getStudentWithMinAverageGrade(){
//        //TODO:
//        return students
//                .stream()
//                .min((x,y) -> Double.compare(x.getAverageGrade(),y.getAverageGrade()))
//                .get();
//    }