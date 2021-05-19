package com.javarush.task.task35.task3513;
/*
Создай интерфейс Move с одним void методом move. Отметь интерфейс аннотацией @FunctionalInterface,
которая будет сигнализировать о том что в этом интерфейсе будет только один абстрактный метод.
 */
//14.2. Интерфейс Move должен быть отмечен аннотацией @FunctionalInterface.
@FunctionalInterface
public interface Move {
//14.1. В интерфейсе Move должен присутствовать один абстрактный void метод move.
    void move();
}
