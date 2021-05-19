package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;
/*
8.3. Замена исключения проверкой условия. Перепиши метод removeStudent(int index), чтобы он удалял
студента из списка студентов только, если он там есть. Метод не должен кидать исключение.
8.4. Удаление управляющего флага. Перепиши метод findDimaOrSasha(), сохранив логику его работы.
В методе не должны использоваться флаги типа found, воспользуйся оператором break.

Требования:
3. Необходимо изменить метод removeStudent(int index) класса StudentsDataBase, чтобы он не бросал
исключение.
4. Необходимо изменить метод findDimaOrSasha() класса StudentsDataBase, сохранив логику его работы.
Из метода нужно удалить флаг boolean found и воспользоваться оператором break.
 */
public class StudentsDataBase {
    public static List<Student> students = new ArrayList<>();

    public static void addInfoAboutStudent(Student student) {
        students.add(student);
        printInfoAboutStudent(student);
    }

    public static void printInfoAboutStudent(Student student) {
        System.out.println("Имя: " + student.getName() + " Возраст: " + student.getAge());
    }

  //  public static void removeStudent(int index) throws IndexOutOfBoundsException {
    public static void removeStudent(int index) {
        if (index < students.size() && index >= 0)
        students.remove(index);
    }

//    public static void findDimaOrSasha() {
//        boolean found = false;
//        for (int i = 0; i < students.size(); i++) {
//            if (!found) {
//                if (students.get(i).getName().equals("Dima")) {
//                    System.out.println("Студент Dima есть в базе.");
//                    found = true;
//                }
//
//                if (students.get(i).getName().equals("Sasha")) {
//                    System.out.println("Студент Sasha есть в базе.");
//                    found = true;
//                }
//            }
//        }
//    }
    public static void findDimaOrSasha() {
      //  boolean found = false;
        for (int i = 0; i < students.size(); i++) {
           // if (!found) {
                if (students.get(i).getName().equals("Dima")) {
                    System.out.println("Студент Dima есть в базе.");
                  //  found = true;
                    break;

                }
                if (students.get(i).getName().equals("Sasha")) {
                    System.out.println("Студент Sasha есть в базе.");
                  //  found = true;
                    break;
                }
            }
        }
    }
//ну почему же почему нельзя юзать Stream API и класс Optional????????
//поизучал тут вне рамок джавараша функциональную джаву и теперь просто бесит писать как раньше кучу кода,
// когда можно написать пару строк, но валидатор не принимает, говорит неправильно.
//Вот как можно было Диму с Сашей удалить красиво:
//Optional<Student> studentDimaOrSasha  = students.stream()
//                .filter(student -> student.getName().equals("Dima") || student.getName().equals("Sasha"))
//                .findAny();
//if (studentDimaOrSasha.isPresent()) {
//     System.out.println(String.format("Студент %s есть в базе.", studentDimaOrSasha.get().getName()));
//}
//
//можно ещё короче, но похоже джавараш пока ещё не поддерживает функционалку.
