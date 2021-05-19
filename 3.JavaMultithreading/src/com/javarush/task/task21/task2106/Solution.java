package com.javarush.task.task21.task2106;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Ошибка в equals/hashCode
Исправьте ошибки реализаций методов equals и hashCode для класса Solution.

Требования:
1. Хешкоды одинаковых объектов должны быть равны.
2. Метод equals должен проверять равен ли переданный объект равен текущему (сравнение через ==).
3. Метод equals должен проверять является ли переданный объект объектом класса Solution.
4. Метод equals должен проверять значения всех полей у переданного объекта и текущего
(учти что некоторые из них могут быть равны null).
5. Должно быть обеспечено корректное поведение HashSet с типом элементов Solution.
6. В классе Solution должен быть реализован метод hashCode.
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }


    public static void main(String[] args) {
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution1 = (Solution) o;
        return anInt == solution1.anInt &&
                Double.compare(solution1.aDouble, aDouble) == 0 &&
                Objects.equals(string, solution1.string) &&
                Objects.equals(date, solution1.date) &&
                Objects.equals(solution, solution1.solution);
    }
    @Override
    public int hashCode() {
        return Objects.hash(anInt, string, aDouble, date, solution);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (o == null) return false;
//        if (this == o) return true;
//        if (!(o instanceof Solution)) return false;
//        Solution solution1 = (Solution) o;

        //Solution n = (Solution) o;
        //return Objects.equals(first, n.first) && Objects.equals(last, n.last);


//        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
//        if (anInt != solution1.anInt) return false;
//        if (date != null ? !date.equals(solution1.date) : solution1.date == null) return false;
//        if (solution != null ? !solution.equals(solution1.solution) : solution1.solution == null) return false;
//        if (string != null ? !string.equals(solution1.string) : solution1.string == null) return false;

//        return true;

}
