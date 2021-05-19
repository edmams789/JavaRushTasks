package com.javarush.task.task32.task3209.actions;


import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

//Класс SubscriptAction должен быть создан в отдельном файле.
//8.1. Напиши в пакете actions заглушки для следующих классов:
//8.1.4. Класс SubscriptAction, который отвечает за стиль текста "Подстрочный знак".
//Его также унаследуй его от StyledEditorKit.StyledTextAction.
public class SubscriptAction extends StyledEditorKit.StyledTextAction {
//7. Конструктор без параметров класса SubscriptAction должен вызывать конструктор суперкласса
//с параметром StyleConstants.Subscript.
    public SubscriptAction() {
        super(StyleConstants.Subscript.toString());
    }
//8. Метод actionPerformed(ActionEvent actionEvent) класса SubscriptAction должен использовать метод
//setSubscript у StyleConstants с параметрами: SimpleAttributeSet и
//!StyleConstants.isSubscript(mutableAttributeSet).
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JEditorPane editor = getEditor(actionEvent);
        if (editor != null) {
            MutableAttributeSet mutableAttributeSet = getStyledEditorKit(editor).getInputAttributes();
            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
            StyleConstants.setSubscript(simpleAttributeSet, !StyleConstants.isSubscript(mutableAttributeSet));
            setCharacterAttributes(editor, simpleAttributeSet, false);
        }
    }
}
//Убедись, что метод actionPerformed(ActionEvent actionEvent) вызывает метод setSubscript у StyleConstants
// с параметрами: SimpleAttributeSet и !StyleConstants.isSubscript(mutableAttributeSet).

//public class StrikeThroughAction extends StyledEditorKit.StyledTextAction {
//
//    public StrikeThroughAction() {
//        super(StyleConstants.StrikeThrough.toString());
//    }
//
//    public void actionPerformed(ActionEvent actionEvent) {
//        JEditorPane editor = getEditor(actionEvent);
//        if (editor != null) {
//            MutableAttributeSet mutableAttributeSet = getStyledEditorKit(editor).getInputAttributes();
//            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
//            StyleConstants.setStrikeThrough(simpleAttributeSet, !StyleConstants.isStrikeThrough(mutableAttributeSet));
//            setCharacterAttributes(editor, simpleAttributeSet, false);
//        }
//    }
//}