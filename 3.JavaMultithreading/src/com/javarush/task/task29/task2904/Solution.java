package com.javarush.task.task29.task2904;

/* 
Особенности автобоксинга
Исправь ошибку в методе getValueByIndex().
Читай доп. статью про особенности автобоксинга.

Требования:
1. Метод getValueByIndex() должен возвращать объект типа Integer из массива array,
если элемент с индексом index есть в массиве.
2. Метод getValueByIndex() должен возвращать объект типа Double, равный -1,
если в массиве array нет элемента с индексом index.
3. Метод main() не изменять.
4. Программа должна вывести две строки: "-1.0, class java.lang.Double" и "3, class java.lang.Integer".
*/
public class Solution {
    private Integer[] array = new Integer[]{1, 2, 3, 4};

    public static void main(String[] args) {
        Number value1 = new Solution().getValueByIndex(5); //-1.0, class java.lang.Double expected
        Number value2 = new Solution().getValueByIndex(2); //3, class java.lang.Integer expected

        System.out.println(value1 + ", " + value1.getClass().toString());
        System.out.println(value2 + ", " + value2.getClass().toString());
    }

    Number getValueByIndex(int index) {
        return (index >= 0 && index < array.length) ? array[index] : (Number) new Double(-1);
    }
}
//Короче из советов ниже 2 рабочих варианта:
//1) привести явно Double к Number и тогда будет приведение обеих сторон к Double,
// а будет к Integer (так как он более точный чем Number), но этот Number который был получен из
// Double будет хранить в себе информацию что он является объектом типа Double;
//2) переписать через if/else и не будет всяких подводных приведений типов.