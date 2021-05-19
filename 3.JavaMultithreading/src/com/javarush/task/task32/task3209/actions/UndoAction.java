package com.javarush.task.task32.task3209.actions;

import com.javarush.task.task32.task3209.View;
import javax.swing.*;
import java.awt.event.ActionEvent;

/*

 */
//Класс UndoAction должен быть создан в отдельном файле.
//8.1. Напиши в пакете actions заглушки для следующих классов:
//8.1.1. Класс отмены действия UndoAction. Он должен наследоваться от AbstractAction и
//содержать конструктор UndoAction(View view).
public class UndoAction extends AbstractAction {
    private View view;

    public UndoAction(View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
//6. Метод actionPerformed(ActionEvent actionEvent) класса UndoAction должен вызывать метод undo() у представления.
        view.undo();
    }
}
