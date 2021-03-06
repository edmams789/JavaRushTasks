package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
HTML Editor (3)
*/
//Класс FrameListener должен быть создан в отдельном файле.
//3.2. Добавь класс FrameListener в пакет listeners. Он должен:
//3.2.1. Быть унаследован от WindowAdapter.
public class FrameListener extends WindowAdapter {
//Класс FrameListener должен содержать приватное поле View view.
//3.2.2. Иметь поле View view.
    private View view;
//Класс FrameListener должен содержать конструктор с одним параметром, инициализирующий поле view.
//3.2.3. В конструкторе принимать View и инициализировать внутреннее поле.
    public FrameListener(View view) {
        this.view = view;
    }
//В классе FrameListenerМетод должен быть метод windowClosing(WindowEvent windowEvent).
//3.2.4. Иметь переопределенный метод windowClosing(WindowEvent windowEvent), который должен вызывать exit()
//у представления.
    @Override
    public void windowClosing(WindowEvent windowEvent) {
        super.windowClosing(windowEvent);
        view.exit();
    }
}
