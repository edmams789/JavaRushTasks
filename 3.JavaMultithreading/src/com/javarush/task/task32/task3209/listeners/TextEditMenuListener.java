package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
/*
HTML Editor (13)
Реализуем класс TextEditMenuListener в пакет listeners.
Этот класс будет работать аналогично классу UndoMenuListener только для других пунктов меню.
Пункты меню, отвечающие за стиль, шрифт, цвет и т.д. должны быть доступны только тогда, когда в нашем
редакторе выбрана первая вкладка.
13.1. Добавь в представление метод boolean isHtmlTabSelected().
Он должен возвращать true, если выбрана вкладка, отображающая html в панели вкладок (подсказка: ее индекс 0).
13.2. Добавь в класс TextEditMenuListener поле View, проинициализируй его в конструкторе класса.
13.3. В классе TextEditMenuListener переопредели метод menuSelected(MenuEvent menuEvent). Он должен:
13.3.1. Из переданного параметра получать объект, над которым было совершено действие. В нашем случае
это будет объект с типом JMenu.
13.3.2. У полученного меню получать список компонентов (пунктов меню).
13.3.3. Для каждого пункта меню вызывать метод setEnabled, передав в качестве параметра результат вызова
метода isHtmlTabSelected() из представления.
Запусти приложение и убедись, что пункты меню стиль, выравнивание, цвет и шрифт доступны только,
когда активна закладка HTML и не доступны для закладки Текст.

Требования:
1. Класс View должен содержать публичный метод boolean isHtmlTabSelected(), определяющий текущую вкладку.
2. Класс TextEditMenuListener должен содержать поле View view.
3. Конструктор класса TextEditMenuListener(View view) должен инициализировать поле view.
4. Метод menuSelected(MenuEvent menuEvent) класса TextEditMenuListener должен устанавливать доступность
пунктов меню стиль, выравнивание, цвет и шрифт в зависимости от выбранной вкладки.
 */

//7. Класс TextEditMenuListener должен быть создан в отдельном файле.
//8.2. Напиши в пакете listeners заглушки для классов:
//8.2.2. TextEditMenuListener. Этот класс также должен реализовывать интерфейс MenuListener.
//Добавь ему конструктор TextEditMenuListener(View view). В следующих заданиях мы рассмотрим его детальнее.
public class TextEditMenuListener implements MenuListener {
//13.2. Добавь в класс TextEditMenuListener поле View, проинициализируй его в конструкторе класса.
//Класс TextEditMenuListener должен содержать поле View view.
    private View view;

    public TextEditMenuListener(View view) {
        this.view = view;
    }
//Метод menuSelected(MenuEvent menuEvent) класса TextEditMenuListener должен устанавливать доступность
//пунктов меню стиль, выравнивание, цвет и шрифт в зависимости от выбранной вкладки.
//13.3. В классе TextEditMenuListener переопредели метод menuSelected(MenuEvent menuEvent). Он должен:
    @Override
    public void menuSelected(MenuEvent menuEvent) {
//13.3.1. Из переданного параметра получать объект, над которым было совершено действие. В нашем случае
//это будет объект с типом JMenu.
        JMenu jMenu = (JMenu) menuEvent.getSource();
//13.3.2. У полученного меню получать список компонентов (пунктов меню).
        Component[] components = jMenu.getMenuComponents();
//13.3.3. Для каждого пункта меню вызывать метод setEnabled, передав в качестве параметра результат вызова
//метода isHtmlTabSelected() из представления.
        for (Component component : components) {
            component.setEnabled(view.isHtmlTabSelected());
        }
//Запусти приложение и убедись, что пункты меню стиль, выравнивание, цвет и шрифт доступны только,
//когда активна закладка HTML и не доступны для закладки Текст.
    }
    @Override
    public void menuDeselected(MenuEvent menuEvent) {

    }
    @Override
    public void menuCanceled(MenuEvent menuEvent) {

    }
}
//
//
