package com.javarush.task.task23.task2305;

/* 
Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.

Требования:
1. В классе Solution должен быть реализован метод getTwoSolutions.
2. Метод getTwoSolutions должен быть статическим.
3. Метод getTwoSolutions должен быть публичным.
4. Метод getTwoSolutions должен возвращать массив типа Solution заполненный согласно заданию.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution[] solutions = new Solution[2];
        for (int i = 0; i < solutions.length; i++){
            solutions[i] = new Solution();
            solutions[i].innerClasses[0] = solutions[i].new InnerClass();
            solutions[i].innerClasses[1] = solutions[i].new InnerClass();
        }
        return solutions;
    }

    public static void main(String[] args) {

    }
}
//кто мне объяснит в чём разница
//Solution[] solutions = new Solution[2];
////НЕ РАБОТАЕТ:
//for(Solution x : solutions){
//            x = new Solution();
//            x.innerClasses[0] = x.new InnerClass();
//            x.innerClasses[1] = x.new InnerClass();
//        }
////РАБОТАЕТ:
//        for (int i = 0; i < solutions.length; i++) {
//            solutions[i] = new Solution();
//            solutions[i].innerClasses[0] = solutions[i].new InnerClass();
//            solutions[i].innerClasses[1] = solutions[i].new InnerClass();
//        }
//
//разница только в том, что  в первом случае я использую foreach, а во втором fori(изменено)
//всё
//но при попытке вывести объект solutions[0].innerClasses[0] - в первом случае выдаёт ошибку NullPointer(изменено)
//а во втором выводит нужный объект

//цикл for each нельзя использовать, если планируется изменять элементы коллекции (они неизменяемые)ю
// Нужно использовать или итераторы или обычный цикл.

//1.создаем массив типа Solution.
//2.инициализируем каждый элемент массива (new Solution).
//3.инициализируем каждый элемент массива внутреннего класса (new InnerClass) через созданный экземпляры класса Solution.
//
//Часть лекции относящийся к этой задаче:
//"Нельзя создать объект Door внутри статического метода в классе Car: негде взять ссылку на объект типа Car,
// который неявно передается в конструктор типа Door."