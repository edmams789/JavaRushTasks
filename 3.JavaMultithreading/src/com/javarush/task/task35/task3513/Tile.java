package com.javarush.task.task35.task3513;

import java.awt.*;
/*
2048 (2)
В игре 2048 поле состоит из 16 плиток, каждая из которых имеет определенный вес.
Кроме веса у плитки еще будет собственный цвет и цвет текста которым будет отображаться вес плитки.
Цвета плиток находятся в диапазоне от светло-серого до красного, а цвет текста будет зависеть от цвета плитки.

Создадим класс Tile описывающий одну плитку.
В нем нам понадобятся:
1. Поле value типа int, уровень доступа по умолчанию.
2. Конструктор с параметром, инициализирующий поле value.
3. Конструктор без параметров (значение поля value должно быть равно нулю).
4. Метод isEmpty, возвращающий true в случае, если значение поля value равно 0, иначе - false.
5. Метод getFontColor, возвращающий новый цвет(объект типа Color) (0x776e65) в случае, если вес плитки
меньше 16, иначе - 0xf9f6f2.
6. Метод getTileColor, возвращающий цвет плитки в зависимости от ее веса в соответствии с нижеприведенными
значениями:
0: (0xcdc1b4);
2: (0xeee4da);
4: (0xede0c8);
8: (0xf2b179);
16: (0xf59563);
32: (0xf67c5f);
64: (0xf65e3b);
128: (0xedcf72);
256: (0xedcc61);
512: (0xedc850);
1024: (0xedc53f);
2048: (0xedc22e);

для любых других значений: (0xff0000).

Вышеперечисленные методы не должны быть приватными.

Требования:
1. В классе Tile должно присутствовать поле value типа int с уровнем доступа по умолчанию.
2. Конструктор класса Tile с одним параметром типа int должен инициализировать поле value.
3. После создания объекта типа Tile с помощью конструктора без параметров, значение поля value должно
быть равно нулю.
4. Метод isEmpty должен возвращать true в случае, если значение поля value равно 0, иначе - false.
5. Метод getFontColor должен быть реализован в соответствии с условием задачи.
6. Метод getTileColor должен возвращать цвет плитки в зависимости от ее веса.
 */
public class Tile {
//2.1. Поле value типа int, уровень доступа по умолчанию.
//В классе Tile должно присутствовать поле value типа int с уровнем доступа по умолчанию.
    int value;
//2.2. Конструктор с параметром, инициализирующий поле value.
//После создания объекта типа Tile с помощью конструктора без параметров, значение поля value должно
//быть равно нулю.
    public Tile() {
        value = 0;
    }
//2.3. Конструктор без параметров (значение поля value должно быть равно нулю).
//Конструктор класса Tile с одним параметром типа int должен инициализировать поле value.
    public Tile(int value) {
        this.value = value;
    }
//2.4. Метод isEmpty должен возвращать true в случае, если значение поля value равно 0, иначе - false.
//Метод isEmpty должен возвращать true в случае, если значение поля value равно 0, иначе - false.
    public boolean isEmpty() {

        return value == 0;
    }
//2.5. Метод getFontColor, возвращающий новый цвет(объект типа Color) (0x776e65) в случае, если вес плитки
//меньше 16, иначе - 0xf9f6f2.
//Метод getFontColor должен быть реализован в соответствии с условием задачи.
    public Color getFontColor() {

        return value < 16 ? new Color(0x776e65) : new Color(0xf9f6f2);
    }
//2.6. Метод getTileColor, возвращающий цвет плитки в зависимости от ее веса в соответствии с нижеприведенными
//значениями:
//Метод getTileColor должен возвращать цвет плитки в зависимости от ее веса.
    public Color getTileColor () {
        Color result;
        switch (value) {
            case 0: {
                result = new Color(0xcdc1b4);
            } break;
            case 2: {
                result = new Color(0xeee4da);
            } break;
            case 4: {
                result = new Color(0xede0c8);
            } break;
            case 8: {
                result = new Color(0xf2b179);
            } break;
            case 16: {
                result = new Color(0xf59563);
            } break;
            case 32: {
                result = new Color(0xf67c5f);
            } break;
            case 64: {
                result = new Color(0xf65e3b);
            } break;
            case 128: {
                result = new Color(0xedcf72);
            } break;
            case 256: {
                result = new Color(0xedcc61);
            } break;
            case 512: {
                result = new Color(0xedc850);
            } break;
            case 1024: {
                result = new Color(0xedc53f);
            } break;
            case 2048: {
                result = new Color(0xedc22e);
            } break;
            default: {
                result = new Color(0xff0000);
            }
        }
        return result;
    }
}