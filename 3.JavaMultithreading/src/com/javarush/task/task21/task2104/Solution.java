package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации
этих методов(детали уточни у своего любимого поисковика).
Обе строки first и last должны принимать участие в сравнении с помощью метода equals и вычислении
hashcode.
Метод main не участвует в тестировании.

Требования:
1. Хешкоды одинаковых объектов должны быть равны.
2. Метод equals должен проверять равен ли переданный объект текущему(сравнение через ==).
3. Метод equals должен проверять является ли переданный объект объектом класса Solution.
4. Метод equals должен возвращать true в случае, если поля first и last равны у переданного объекта
и текущего(не забудь что они могут быть равны null).
5. Должно быть обеспечено корректное поведение HashSet с типом элементов Solution.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }
        @Override
    public boolean equals(Object o) {
        if (!(o instanceof Solution)) //if (n.getClass() != this.getClass()) return false;
            return true;
        //    if (o instanceof Solution) //validator does not accept
        //        return true;
        if (o == this)
            return true;
        if (o == null)
            return false;

        Solution solution = (Solution) o;
      //  return n.first.equals(first) && n.last.equals(last);
        return Objects.equals(first, solution.first) &&
                Objects.equals(last, solution.last);
    }

    public int hashCode() {
    //    return 31 * first.hashCode() + last.hashCode();
        return Objects.hash(first, last);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
//Требование:
//3. Метод equals должен проверять является ли переданный объект объектом класса Solution.
//Означает использование:
//if (!(o instanceof Solution)) return false;
//
//Если бы требование были таким:
//3. Метод equals должен проверять является ли класс переданного объекта классом Solution.
//То нужно было бы использовать:
//if (getClass() != o.getClass()) return false;
