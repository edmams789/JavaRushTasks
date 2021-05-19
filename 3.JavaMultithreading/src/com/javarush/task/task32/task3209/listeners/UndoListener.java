package com.javarush.task.task32.task3209.listeners;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
//11.2. Добавь класс UndoListener реализующий интерфейс UndoableEditListener в пакет listeners.
//Этот класс будет следить за правками, которые можно отменить или вернуть.
//Класс UndoListener должен быть создан в отдельном файле.
public class UndoListener implements UndoableEditListener {
//11.3. Добавь в класс UndoListener:
//11.3.1. Поле UndoManager undoManager.
//Класс UndoListener должен содержать приватное поле UndoManager undoManager.
    private UndoManager undoManager;

//11.3.2. Конструктор, который принимает UndoManager и инициализирует поле класса.
//Конструктор UndoListener(UndoManager undoManager) должен корректно инициализировать поле undoManager.
    public UndoListener(UndoManager undoManager) {
        this.undoManager = undoManager;
    }
//11.3.3. Метод undoableEditHappened(UndoableEditEvent e). Он должен из переданного события получать правку
//и добавлять ее в undoManager.
//Метод undoableEditHappened(UndoableEditEvent e) в классе UndoListener должен из переданного события
//получать правку и добавлять ее в undoManager.
//Метод public void undoableEditHappened(UndoableEditEvent e) должен из переданного события получать
// правку(getEdit()) и добавлять ее в undoManager(addEdit()).
        @Override
    public void undoableEditHappened(UndoableEditEvent undoableEditEvent) {
        undoManager.addEdit(undoableEditEvent.getEdit());

    }
}



