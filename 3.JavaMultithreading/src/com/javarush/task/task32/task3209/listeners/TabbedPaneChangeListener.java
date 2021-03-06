package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
HTML Editor (5)
5.1. Объяви класс TabbedPaneChangeListener реализующий интерфейс ChangeListener в пакете listeners.
Этот класс будет слушать и обрабатывать изменения состояния панели вкладок.
Реализуй в этом классе:
5.1.1. Конструктор, принимающий представление в виде параметра и сохраняющий во внутреннее поле view класса.
5.1.2. Переопредели метод из интерфейса ChangeListener, он должен вызывать метод selectedTabChanged()
у представления. Последнего метода еще нет, сделай для него заглушку.
5.2. Объяви класс ExceptionHandler. Это будет наш обработчик исключительных ситуаций, который ты в
дальнейшем сможешь переопределить.
Пока добавь в него статический метод log(Exception e), который будет выводить в консоль краткое описание
проблемы (используй метод toString у переданного исключения).

Требования:
1. Класс View должен содержать метод public void selectedTabChanged().
2. Класс TabbedPaneChangeListener должен быть создан в отдельном файле.
3. Класс TabbedPaneChangeListener должен содержать поле View view.
4. Класс TabbedPaneChangeListener должен содержать конструктор с одним параметром, инициализирующий поле view.
5. Класс TabbedPaneChangeListener должен содержать метод public void stateChanged(ChangeEvent e).
6. Класс ExceptionHandler должен быть создан в отдельном файле.
7. Класс ExceptionHandler должен содержать метод public static void log(Exception e).
 */
//2. Класс TabbedPaneChangeListener должен быть создан в отдельном файле.

//5.1. Объяви класс TabbedPaneChangeListener реализующий интерфейс ChangeListener в пакете listeners.
//Этот класс будет слушать и обрабатывать изменения состояния панели вкладок.

public class TabbedPaneChangeListener implements ChangeListener {
//Реализуй в этом классе:

//Класс TabbedPaneChangeListener должен содержать поле View view.
    private View view;
//Класс TabbedPaneChangeListener должен содержать конструктор с одним параметром, инициализирующий поле view.
//5.1.1. Конструктор, принимающий представление в виде параметра и сохраняющий во внутреннее поле view класса.
    public TabbedPaneChangeListener(View view) {
        this.view = view;
    }
//Класс TabbedPaneChangeListener должен содержать метод public void stateChanged(ChangeEvent e).
    @Override
    public void stateChanged(ChangeEvent e) {
        view.selectedTabChanged();
    }
//5.1.2. Переопредели метод из интерфейса ChangeListener, он должен вызывать метод selectedTabChanged()
//у представления. Последнего метода еще нет, сделай для него заглушку.

//    @Override
//    public void stateChanged(ChangeEvent changeEvent) {
//
//        view.selectedTabChanged() {}
}
//1 Поле View view в классе TabbedPaneChangeListener должно быть обязательно private
//2 В пункте 5.2. выводить через System.out.println(); но через toString(!)

//Я просто написал System.out.println(e) и приняло.

//