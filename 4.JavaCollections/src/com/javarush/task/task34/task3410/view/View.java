package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.Controller;

import javax.swing.*;
//Тебе пришел измененный код класса View, который создает объект поля Field и настраивает правильным
//образом представление View
public class View extends JFrame {
    private Controller controller;
    private Field field;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void init() {
        field = new Field(this);
        add(field);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Сокобан");
        setVisible(true);
    }
}
