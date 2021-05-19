package com.javarush.task.task14.task1412;

/* 
Реализовать метод printMainInfo
1. Напиши реализацию метода printMainInfo, чтобы:
1.1. Если в метод передают объект типа Drawable, у этого объекта вызывался метод draw.
1.2. Если в метод передают объект типа Movable, у этого объекта вызывался метод move.


Требования:
1. Класс Solution должен содержать реализацию метода printMainInfo с одним параметром типа Object.
2. Метод printMainInfo должен быть статическим.
3. Метод printMainInfo должен иметь самый широкий уровень доступа(public).
4. Метод printMainInfo должен вызывать у переданного ему в качестве параметра объекта метод draw,
если этот объект реализует интерфейс Drawable.
5. Метод printMainInfo должен вызывать у переданного ему в качестве параметра объекта метод move,
если этот объект реализует интерфейс Movable.
*/

public class Solution {
    public static void main(String[] args) {
        Object obj = new Circle(); //Circle = Круг
        Movable movable = (Movable) obj; //movable = движимое
        Drawable drawable = new Rectangle(); //drawable = рисуем, Rectangle = Прямоугольник

        printMainInfo(drawable);
        printMainInfo(movable);
    }

    public static void printMainInfo(Object object) {
        //напишите тут ваш код
        if (object instanceof Drawable)
            ((Drawable) object).draw();
        else if (object instanceof Movable)
            ((Movable) object).move();

    }

    static interface Movable {

        void move();
    }

    static class Circle implements Movable {

        public void draw() {
            System.out.println("Can be drawn"); //Can be drawn = Можно нарисовать
        }

        public void move() {
            System.out.println("Can be moved"); //Can be moved = Можно переместить
        }

    }

    static interface Drawable {
        void draw();
    }

    static class Rectangle implements Drawable {
        public void draw() {
            System.out.println("Can be drawn");
        }

        public void move() {
            System.out.println("Can be moved");
        }
    }
}
