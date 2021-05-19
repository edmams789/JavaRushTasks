package com.javarush.task.task32.task3209;
/*
HTML Editor (19)
Реализуем метод actionPerformed(ActionEvent actionEvent) у представления, этот метод наследуется от
интерфейса ActionListener и будет вызваться при выборе пунктов меню, у которых наше представление указано
в виде слушателя событий.
19.1. Получи из события команду с помощью метода getActionCommand(). Это будет обычная строка.
По этой строке ты можешь понять какой пункт меню создал данное событие.
19.2. Если это команда "Новый", вызови у контроллера метод createNewDocument().
В этом пункте и далее, если необходимого метода в контроллере еще нет - создай заглушки.
19.3. Если это команда "Открыть", вызови метод openDocument().
19.4. Если "Сохранить", то вызови saveDocument().
19.5. Если "Сохранить как..." - saveDocumentAs().
19.6. Если "Выход" - exit().
19.7. Если "О программе", то вызови метод showAbout() у представления.
Проверь, что заработали пункты меню Выход и О программе.

Требования:
1. Метод actionPerformed(ActionEvent actionEvent) должен получать из события команду с помощью
метода getActionCommand().
2. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Новый",
метод должен вызывать у контроллера createNewDocument().
3. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Открыть",
метод должен вызывать у контроллера openDocument().
4. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Сохранить",
метод должен вызывать у контроллера saveDocument().
5. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Сохранить как...",
метод должен вызывать у контроллера saveDocumentAs().
6. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Выход",
метод должен вызывать у контроллера exit().
7. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "О программе",
метод должен вызывать у представления showAbout().
 */
import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Класс View должен быть создан в отдельном файле.
//Класс View должен быть унаследован от JFrame и реализовывать интерфейс ActionListener.
public class View extends JFrame implements ActionListener {
//В классе View должен быть метод public void actionPerformed(ActionEvent e).
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
//Реализуем метод actionPerformed(ActionEvent actionEvent) у представления, этот метод наследуется от
//интерфейса ActionListener и будет вызваться при выборе пунктов меню, у которых наше представление указано
//в виде слушателя событий.
//19.1. Получи из события команду с помощью метода getActionCommand(). Это будет обычная строка.
//По этой строке ты можешь понять какой пункт меню создал данное событие.
        String command = actionEvent.getActionCommand();
//19.2. Если это команда "Новый", вызови у контроллера метод createNewDocument().
//В этом пункте и далее, если необходимого метода в контроллере еще нет - создай заглушки.
        switch (command) {
            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                controller.exit();
                break;
            case "О программе":
                showAbout();
                break;
        }
//19.3. Если это команда "Открыть", вызови метод openDocument().
//19.4. Если "Сохранить", то вызови saveDocument().
//19.5. Если "Сохранить как..." - saveDocumentAs().
//19.6. Если "Выход" - exit().
//19.7. Если "О программе", то вызови метод showAbout() у представления.
//Проверь, что заработали пункты меню Выход и О программе.
//
//Требования:
//1. Метод actionPerformed(ActionEvent actionEvent) должен получать из события команду с помощью
//метода getActionCommand().
//2. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Новый",
//метод должен вызывать у контроллера createNewDocument().
//3. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Открыть",
//метод должен вызывать у контроллера openDocument().
//4. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Сохранить",
//метод должен вызывать у контроллера saveDocument().
//5. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Сохранить как...",
//метод должен вызывать у контроллера saveDocumentAs().
//6. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Выход",
//метод должен вызывать у контроллера exit().
//7. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "О программе",
//метод должен вызывать у представления showAbout().
    }
//В классе View должно быть приватное поле Controller controller, а также сеттер и геттер к нему.
    private Controller controller;

    public Controller getController() {
        return controller;
    }
    public void setController(Controller controller) {
        this.controller = controller;
    }
//Класс View должен содержать метод public void init().
//2.1. Добавь в контроллер и представление по методу init(), пока без реализаций. Они будут отвечать за
//инициализацию контроллера и представления.
    public void init() {
//Реализуй метод init() класса View, согласно задания.
//4.3. Реализуй метод init() представления. Он должен:
//4.3.1. Вызывать инициализацию графического интерфейса initGui().
        initGui();
//4.3.2. Добавлять слушателя событий нашего окна. В качестве подписчика создай и используй объект класса FrameListener.
//В качестве метода для добавления подписчика используй подходящий метод из класса Window от которого
//наследуется и наш класс через классы JFrame и Frame.
        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
//4.3.3. Показывать наше окно. Используй метод setVisible с правильным параметром.
//На этом этапе приложение при запуске должно показывать окно, которое можно растягивать, разворачивать,
//закрыть и т.д.
    setVisible(true);
    }
//Класс View должен реализовывать метод public void exit().
//2.4. Добавь в представление метод exit(), он должен вызывать exit() у контроллера.
    public void exit() {
        controller.exit();
    }

//1. Класс View должен содержать приватное проинициализированое поле JTabbedPane tabbedPane.
//3.1.1. JTabbedPane tabbedPane - это будет панель с двумя вкладками.
    private JTabbedPane tabbedPane = new JTabbedPane();
//2. Класс View должен содержать приватное проинициализированое поле JTextPane htmlTextPane.
//3.1.2. JTextPane htmlTextPane - это будет компонент для визуального редактирования html.
//Он будет размещен на первой вкладке.
    private JTextPane htmlTextPane = new JTextPane();
//3. Класс View должен содержать приватное проинициализированое поле JEditorPane plainTextPane.
//3.1.3. JEditorPane plainTextPane - это будет компонент для редактирования html в виде текста, он будет
//отображать код html (теги и их содержимое).
    private JEditorPane plainTextPane = new JEditorPane();
//4.1. Объяви методы initMenuBar() и initEditor() в классе View. Они будут отвечать за инициализацию меню и
//панелей редактора.
//Класс View должен содержать метод public void initMenuBar().
    public void initMenuBar() {
//9.1. Реализуй метод initMenuBar(). Он должен:
//9.1.1. Создавать новый объект типа JMenuBar. Это и будет наша панель меню.
//1. В методе initMenuBar() должно создаваться новое меню (объект типа JMenuBar).
        JMenuBar jMenuBar = new JMenuBar();

//9.1.2. С помощью MenuHelper инициализировать меню в следующем порядке: Файл, Редактировать, Стиль,
//Выравнивание, Цвет, Шрифт и Помощь.
//В методе initMenuBar() c помощью MenuHelper должно быть проинициализировано меню в следующем порядке:
//Файл, Редактировать, Стиль, Выравнивание, Цвет, Шрифт и Помощь.
    MenuHelper.initFileMenu(this, jMenuBar);
    MenuHelper.initEditMenu(this, jMenuBar);
    MenuHelper.initStyleMenu(this, jMenuBar);
    MenuHelper.initAlignMenu(this, jMenuBar);
    MenuHelper.initColorMenu(this, jMenuBar);
    MenuHelper.initFontMenu(this, jMenuBar);
    MenuHelper.initHelpMenu(this, jMenuBar);
//9.1.3. Добавлять в верхнюю часть панели контента текущего фрейма нашу панель меню, аналогично тому,
//как это мы делали с панелью вкладок.
//В методе initMenuBar() должно добавляться новосозданное меню в верхнюю часть панели контента текущего
//фрейма, используя метод getContentPane().
    getContentPane().add(jMenuBar, BorderLayout.NORTH);
//Запусти приложение, теперь ты должен видеть панель с меню вверху окна. Некоторые из пунктов меню
//(например: Вырезать, Копировать, Вставить, Стиль (частично), Выравнивание, Цвет, Шрифт)
//должны уже работать. Убедись, что все работает и только затем продолжи разработку.
    }
//Класс View должен содержать метод public void initEditor().
    public void initEditor() {
//Реализуй метод инициализации панелей редактора initEditor(). Он должен:
//6.1. Устанавливать значение "text/html" в качестве типа контента для компонента htmlTextPane.
//Найди и используй подходящий метод.
//В методе initEditor() для компонента htmlTextPane должен устанавливаться тип контента "text/html"
// через сеттер setContentType.
         htmlTextPane.setContentType("text/html");

//6.2. Создавать новый локальный компонент JScrollPane на базе htmlTextPane.
//2. В методе initEditor() должен создаваться новый локальный компонент JScrollPane
// через конструктор принимающий htmlTextPane.

//6.3. Добавлять вкладку в панель tabbedPane с именем "HTML" и компонентом из предыдущего пункта.
//В методе initEditor() для компонента tabbedPane должна добавляться вкладка
// с именем "HTML" и созданным компонентом JScrollPane на базе htmlTextPane.
        tabbedPane.addTab("HTML", new JScrollPane(htmlTextPane));

//6.4. Создавать новый локальный компонент JScrollPane на базе plainTextPane.
//В методе initEditor() должен создаваться новый локальный компонент JScrollPane
// через конструктор принимающий plainTextPane.

//6.5. Добавлять еще одну вкладку в tabbedPane с именем "Текст" и компонентом из предыдущего пункта.
//В методе initEditor() для компонента tabbedPane должна добавляться вкладка
// с именем "Текст" и созданным компонентом JScrollPane на базе plainTextPane.
    //    tabbedPane.add("Текст", plainTextPane);
        tabbedPane.addTab("Текст", new JScrollPane(plainTextPane));
        
//6.6. Устанавливать предпочтительный размер панели tabbedPane.
//В методе initEditor() для компонента tabbedPane должен устанавливаться
// предпочтительный размер панели, через сеттер setPreferredSize.
        tabbedPane.setPreferredSize(new Dimension(1200, 700));
//6.7. Создавать объект класса TabbedPaneChangeListener и устанавливать его в качестве слушателя изменений
// в tabbedPane.
//В методе initEditor() для компонента tabbedPane должен добавляться
// слушатель TabbedPaneChangeListener через метод addChangeListener.
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));

//6.8. Добавлять по центру панели контента текущего фрейма нашу панель с вкладками.
//8. Метод initEditor() должен добавлять по центру панели контента текущего
// фрейма нашу панель с вкладками, через getContentPane().add().

//Получить панель контента текущего фрейма можно с помощью метода getContentPane(),
// его реализация унаследовалась от JFrame.
//Подумай, метод с какими параметрами необходимо вызвать, чтобы панель с вкладками
// отображалась по центру панели контента текущего фрейма.
//После запуска приложения можно будет увидеть текущие результаты: две независимые
// закладки (HTML и Текст), в каждой из которых можно набирать свой текст.

        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }
//Класс View должен реализовывать метод public void initGui().
//4.2. Объяви в представлении метод initGui(). Он будет инициализировать графический интерфейс.
//Вызови из него инициализацию меню initMenuBar(), инициализацию редактора initEditor() и метод pack(),
//реализацию которого мы унаследовали от класса JFrame.
//Разберись что делает метод pack().
    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }
//Класс View должен содержать метод public void selectedTabChanged().
//Реализуй метод selectedTabChanged() представления.
//Этот метод вызывается, когда произошла смена выбранной вкладки. Итак:
    public void selectedTabChanged() {
//Метод selectedTabChanged() должен проверить, какая вкладка сейчас оказалась выбранной.
//18.1. Метод должен проверить, какая вкладка сейчас оказалась выбранной.
        if (tabbedPane.getSelectedIndex() == 0) {
//Если индекс вкладки равен 0 - метод selectedTabChanged() должен получить текст из plainTextPane и
//установить его в контроллер с помощью метода setPlainText().
//18.2. Если выбрана вкладка с индексом 0 (html вкладка), значит нам нужно получить текст из plainTextPane
//и установить его в контроллер с помощью метода setPlainText.
        controller.setPlainText(plainTextPane.getText());
//Если индекс вкладки равен 1 - метод selectedTabChanged() должен получить текст у контроллера с
//помощью метода getPlainText() и установить его в панель plainTextPane.
//18.3. Если выбрана вкладка с индексом 1 (вкладка с html текстом), то необходимо получить текст у
//контроллера с помощью метода getPlainText() и установить его в панель plainTextPane.
        } else {
            plainTextPane.setText(controller.getPlainText());
        }
//Метод selectedTabChanged() должен сбросить правки.
//18.4. Сбросить правки (вызвать метод resetUndo представления).
        resetUndo();
    }
//9.2. Добавь конструктор класса View. Он должен устанавливать внешний вид и поведение (look and feel)
//нашего приложения такими же, как это определено в системе.
//Конструктор не должен кидать исключений, только логировать их с помощью ExceptionHandler.
//
//Подсказа: для реализации задания используй класс UIManager.
//В конструкторе класса View, через класс UIManager, должен устанавливаться внешний вид и поведение
//(look and feel).
    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
//11.5.3. Реализуй методы boolean canUndo() и boolean canRedo() используя undoManager.
//Класс View должен содержать public boolean метод canUndo(), возвращающий false.
    public boolean canUndo() {
//6. Реализация метода canUndo() класса View должна использовать undoManager.
        return undoManager.canUndo();
    }
    public boolean canRedo() {
//7. Реализация метода canRedo() класса View должна использовать undoManager.
        return undoManager.canRedo();
    }
//11.1. Добавь в представление поле UndoManager undoManager. Разберись для чего используется этот класс.
//Проинициализируй поле класса новым объектом.
//1. Класс View должен содержать приватное поле UndoManager undoManager, которое должно быть сразу проинициализовано.
    private UndoManager undoManager = new UndoManager();

//11.4. Добавь в представление поле UndoListener undoListener, проинициализируй его используя undoManager.
//2. Класс View должен содержать приватное поле UndoListener undoListener, которое должно быть сразу
// проинициализовано через поле undoManager.
    private UndoListener undoListener = new UndoListener(undoManager);

//11.5.4. Реализуй геттер для undoListener.
//3. Класс View должен содержать геттер к полю UndoListener undoListener.
    public UndoListener getUndoListener() {
        return undoListener;
    }
//11.5. Добавь в представление методы:
//11.5.1. void undo() - отменяет последнее действие. Реализуй его используя undoManager.
//Метод не должен кидать исключений, логируй их.
//4. Класс View должен содержать public void метод undo().
    public void undo() {
        try {
            undoManager.undo();
        } catch (CannotUndoException e) {
            ExceptionHandler.log(e);
        }
    }
//11.5.2. void redo() - возвращает ранее отмененное действие. Реализуй его по аналогии с предыдущим пунктом.
//5. Класс View должен содержать public void метод redo().
    public void redo() {
        try {
            undoManager.redo();
        } catch (CannotRedoException e) {
            ExceptionHandler.log(e);
        }
    }
//11.5.5. Добавь и реализуй метод void resetUndo(), который должен сбрасывать все правки в менеджере undoManager.
//8. Класс View должен содержать public void метод resetUndo(), который должен сбрасывать все правки в
//менеджере undoManager.
    public void resetUndo() {
        undoManager.discardAllEdits();
    }
//13.1. Добавь в представление метод boolean isHtmlTabSelected(). Он должен возвращать true,
//если выбрана вкладка, отображающая html в панели вкладок (подсказка: ее индекс 0).
//Класс View должен содержать публичный метод boolean isHtmlTabSelected(), определяющий текущую вкладку.
    public boolean isHtmlTabSelected() {
        return tabbedPane.getSelectedIndex() == 0;
    }
//14.1. Добавь в класс представления метод selectHtmlTab(). Он должен:
//Класс View должен содержать публичный метод selectHtmlTab(), который должен выбирать вкладку и
//сбрасывать все правки.
    public void selectHtmlTab() {
//14.1.1. Выбирать html вкладку (переключаться на нее).
        tabbedPane.setSelectedIndex(0);
//14.1.2. Сбрасывать все правки с помощью метода, который ты реализовал ранее.
        resetUndo();
    }
//14.3. Добавь в представление метод update(), который должен получать документ у контроллера и
//устанавливать его в панель редактирования htmlTextPane.
//3. Класс View должен содержать публичный метод update(), который должен устанавливать документ в
//панель редактирования.
    public void update() {
        htmlTextPane.setDocument(controller.getDocument());
    }
//14.4. Добавь в представление метод showAbout(), который должен показывать диалоговое окно с информацией о
//программе. Информацию придумай сам, а вот тип сообщения должен быть JOptionPane.INFORMATION_MESSAGE.
//4. Класс View должен содержать публичный метод showAbout(), который должен показывать диалоговое окно с
//информацией о программе.
    public void showAbout() {
        JOptionPane.showMessageDialog(this, "HTML Editor", "About", JOptionPane.INFORMATION_MESSAGE);
    }


}










