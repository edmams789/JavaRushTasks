package com.javarush.task.task34.task3410.model;

import java.awt.*;

/*
Sokoban (2)
Основа заложена, теперь перейдем к ее наполнению. Игровой процесс можно представить как взаимодействие
игровых объектов GameObject. У нас их будет несколько видов: ящик Box, дом Home
(место куда нужно поместить ящик), стена Wall и игрок Player.
2.1. Добавь абстрактный класс GameObject в пакет model.
2.2. Добавь в класс GameObject поля: int x, int y, int width и int height. Это будет позиция и
размер объекта для отрисовки.
2.3. Добавь сеттеры и геттеры для полей класса.
2.4. Добавь в класс Model публичную статическую константу int FIELD_CELL_SIZE = 20,
это будет размер ячейки игрового поля. Все игровые объекты будут занимать одну ячейку игрового поля.
Именно этот размер будет участвовать в расчёте движения и столкновений объектов. Размер,
который будет храниться внутри объекта, будет использоваться только при его отрисовке.
2.5. Добавь в класс GameObject два конструктора:
2.5.1. GameObject(int x, int y)
2.5.2. GameObject(int x, int y, int width, int height)
Конструкторы должны инициализировать все поля класса. Если width и height не переданы,
используй FIELD_CELL_SIZE в качестве ширины и высоты.
2.6. Добавь абстрактный метод void draw(Graphics graphics) в класс GameObject.
Этот метод будет реализован в каждом типе игровых объектов по-своему.
Другими словами, каждый тип игровых объектов будет знать, как он должен рисоваться и
будет сам себя рисовать в графический контекст graphics.
Graphics - это абстрактный класс из библиотеки java.awt.

Требования:
1. Добавь абстрактный класс GameObject в пакет model.
2. Добавь в класс GameObject поля: int x, int y, int width и int height.
3. Добавь сеттеры и геттеры для полей класса GameObject.
4. Добавь в класс Model публичную статическую константу int FIELD_CELL_SIZE = 20.
5. Добавь в класс GameObject два конструктора: GameObject(int x, int y) и
GameObject(int x, int y, int width, int height). Конструкторы должны инициализировать все поля класса,
согласно условию задачи.
6. Добавь абстрактный метод void draw(Graphics graphics) в класс GameObject.
 */
public abstract class GameObject {
    private int x, y, width, height;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
//Конструкторы должны инициализировать все поля класса. Если width и height не переданы,
//используй FIELD_CELL_SIZE в качестве ширины и высоты.
        this.width = Model.FIELD_CELL_SIZE;
        this.height = Model.FIELD_CELL_SIZE;
    }

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void draw(Graphics graphics);
}
