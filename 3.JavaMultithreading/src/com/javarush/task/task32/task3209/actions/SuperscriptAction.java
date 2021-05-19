package com.javarush.task.task32.task3209.actions;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

//Класс SuperscriptAction должен быть создан в отдельном файле.
//8.1. Напиши в пакете actions заглушки для следующих классов:
//8.1.5. Класс SuperscriptAction. Он будет отвечать за стиль "Надстрочный знак". Добавь ему
//правильный родительский класс.
public class SuperscriptAction extends StyledEditorKit.StyledTextAction {
//9. Конструктор без параметров класса SuperscriptAction должен вызывать конструктор суперкласса
//с параметром StyleConstants.Superscript.
    public SuperscriptAction() {
        super(StyleConstants.Superscript.toString());
    }
//10. Метод actionPerformed(ActionEvent actionEvent) класса SuperscriptAction должен использовать метод
//setSuperscript у StyleConstants с параметрами: SimpleAttributeSet и
//!StyleConstants.isSuperscript(mutableAttributeSet).
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JEditorPane editor = getEditor(actionEvent);
        if (editor != null) {
            MutableAttributeSet mutableAttributeSet = getStyledEditorKit(editor).getInputAttributes();
            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
            StyleConstants.setSuperscript(simpleAttributeSet, !StyleConstants.isSuperscript(mutableAttributeSet));
            setCharacterAttributes(editor, simpleAttributeSet, false);
        }
    }
}

