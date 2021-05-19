package com.javarush.task.task32.task3209.listeners;
/*
HTML Editor (10)
Наш редактор будет поддерживать механизм отмены/возврата (undo/redo) действий в редакторе.
Реализуй класс UndoMenuListener. Этот слушатель будет следить за меню, а если конкретнее,
то за моментом, когда меню редактирования будет выбрано пользователем.
В этот момент он будет запрашивать у представления можем ли мы сейчас отменить или вернуть какое-то
действие, и в зависимости от этого делать доступными или не доступными пункты меню "Отменить" и "Вернуть".
10.1. Добавь в класс UndoMenuListener следующие поля:
10.1.1. Представление View view.
10.1.2. Пункт меню "Отменить" JMenuItem undoMenuItem.
10.1.3. Пункт меню "Вернуть" JMenuItem redoMenuItem.
10.2. Реализуй конструктор UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem),
он должен инициализировать поля класса.
10.3. Реализуй метод menuSelected(MenuEvent menuEvent). Он будет вызываться перед показом меню. Он должен:
10.3.1. Спрашивать у представления можем ли мы отменить действие с помощью метода boolean canUndo().
Пока у представления нет такого метода, поэтому добавь заглушку, которая всегда возвращает false.
10.3.2. Делать доступным или не доступным пункт меню undoMenuItem в зависимости от того, что нам вернуло
представление.

Подсказка: используй метод setEnabled().

10.3.3. Аналогично поступи и для пункта меню redoMenuItem, добавив метод-заглушку canRedo() в представление.
Запусти программу и убедись, что пункты меню Отменить и Вернуть недоступны.

Требования:
1. Класс UndoMenuListener должен содержать поле представления View view.
2. Класс UndoMenuListener должен содержать поле JMenuItem undoMenuItem.
3. Класс UndoMenuListener должен содержать поле JMenuItem redoMenuItem.
4. Конструктор UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem)
должен корректно инициализировать поля класса.
5. Класс View должен содержать public boolean метод canUndo(), возвращающий false.
 */
import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

//6. Класс UndoMenuListener должен быть создан в отдельном файле.
//8.2. Напиши в пакете listeners заглушки для классов:
//8.2.1. UndoMenuListener, он должен реализовывать интерфейс MenuListener и иметь конструктор
//UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem).
//Чем он будет заниматься узнаешь чуть позже.
public class UndoMenuListener implements MenuListener {
    private View view;
    private JMenuItem undoMenuItem;
    private JMenuItem redoMenuItem;
//10.1. Добавь в класс UndoMenuListener следующие поля:
//10.1.1. Представление View view.
//10.1.2. Пункт меню "Отменить" JMenuItem undoMenuItem.
//10.1.3. Пункт меню "Вернуть" JMenuItem redoMenuItem.

    public UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem) {
        this.view = view;
        this.undoMenuItem = undoMenuItem;
        this.redoMenuItem = redoMenuItem;
    }
//10.2. Реализуй конструктор UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem),
//он должен инициализировать поля класса.
    @Override
    public void menuSelected(MenuEvent menuEvent) {
//10.3. Реализуй метод menuSelected(MenuEvent menuEvent). Он будет вызываться перед показом меню. Он должен:
//10.3.1. Спрашивать у представления можем ли мы отменить действие с помощью метода boolean canUndo().
//Пока у представления нет такого метода, поэтому добавь заглушку, которая всегда возвращает false.
//10.3.2. Делать доступным или не доступным пункт меню undoMenuItem в зависимости от того, что нам вернуло
//представление.
//
//Подсказка: используй метод setEnabled().
//
        if (view.canUndo()) {
            undoMenuItem.setEnabled(true);
        } else if (!view.canUndo()) {
            undoMenuItem.setEnabled(false);
        }
//10.3.3. Аналогично поступи и для пункта меню redoMenuItem, добавив метод-заглушку canRedo() в представление.
//Запусти программу и убедись, что пункты меню Отменить и Вернуть недоступны.
        if (view.canRedo()) {
            redoMenuItem.setEnabled(true);
        } else if (!view.canRedo()) {
            redoMenuItem.setEnabled(false);
        }
    }
    @Override
    public void menuDeselected(MenuEvent menuEvent) {

    }
    @Override
    public void menuCanceled(MenuEvent menuEvent) {

    }
}
