package com.javarush.task.task32.task3209;
/*
HTML Editor (23)
23.1. Напишем метод для сохранения открытого файла saveDocument().
Метод должен работать также, как saveDocumentAs(), но не запрашивать файл у пользователя, а использовать currentFile.
Если currentFile равен null, то вызывать метод saveDocumentAs().
23.2. Пришло время реализовать метод openDocument().
Метод должен работать аналогично методу saveDocumentAs(), в той части, которая отвечает за выбор файла.

Подсказка: Обрати внимание на имя метода для показа диалогового окна.

Когда файл выбран, необходимо:
23.2.1. Установить новое значение currentFile.
23.2.2. Сбросить документ.
23.2.3. Установить имя файла в заголовок у представления.
23.2.4. Создать FileReader, используя currentFile.
23.2.5. Вычитать данные из FileReader-а в документ document с помощью объекта класса HTMLEditorKit.
23.2.6. Сбросить правки (вызвать метод resetUndo представления).
23.2.7. Если возникнут исключения - залогируй их и не пробрасывай наружу.
Проверь работу пунктов меню Сохранить и Открыть.

Требования:
1. Метод saveDocument() в контроллере должен переключать представление на html вкладку.
2. Метод saveDocument() в контроллере должен создавать FileWriter на базе currentFile, если currentFile != null.
3. Метод saveDocument() в контроллере должен используя HTMLEditorKit переписывать данные из документа document в объект FileWriter-а, если currentFile != null.
4. Метод saveDocument() в контроллере должен вызывать метод saveDocumentAs(), если currentFile == null.
5. Метод saveDocument() в контроллере не должен кидать исключения, а логировать через ExceptionHandler.
6. Метод openDocument() в контроллере должен переключать представление на html вкладку.
7. Метод openDocument() в контроллере должен создавать новый объект для выбора файла JFileChooser.
8. Метод openDocument() в контроллере должен устанавливать объекту класса JFileChooser в качестве фильтра объект HTMLFileFilter.
9. Метод openDocument() в контроллере должен, используя метод showOpenDialog() у JFileChooser показывать диалоговое окно "Open File" для выбора файла.
10. Метод openDocument() в контроллере должен установить новое значение currentFile, если пользователь подтвердит выбор файла.
11. Метод openDocument() в контроллере должен сбросить документ, если пользователь подтвердит выбор файла.
12. Метод openDocument() в контроллере должен устанавливать имя файла в качестве заголовка окна представления, если пользователь подтвердит выбор файла.
13. Метод openDocument() в контроллере должен создавать FileReader на базе currentFile, если пользователь подтвердит выбор файла.
14. Метод openDocument() в контроллере должен используя HTMLEditorKit вычитать данные из FileReader-а в документ document, если пользователь подтвердит выбор файла.
15. Метод openDocument() в контроллере должен сбросить правки, если пользователь подтвердит выбор файла.
16. Метод openDocument() в контроллере не должен кидать исключения, а логировать через ExceptionHandler.
 */
import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

//Класс Controller должен быть создан в отдельном файле.
public class Controller {
//В классе Controller должны быть приватные поля: View view, HTMLDocument document, File currentFile.
    private View view;
    private HTMLDocument document;
    private File currentFile;
//Класс Controller должен содержать конструктор с одним параметром, инициализирующий поле view.
    public Controller(View view) {
        this.view = view;
    }
//В классе Controller должен быть создан метод public static void main (String[] args).
    public static void main(String[] args) {
//2.2. Теперь напишем в классе Controller метод main().
//Он должен:
//2.2.1. Создавать объект представления.
        View view = new View();
//2.2.2. Создавать контроллер, используя представление.
        Controller controller = new Controller(view);
//2.2.3. Устанавливать у представления контроллер.
        view.setController(controller);
//2.2.4. Инициализировать представление.
        view.init();
//2.2.5. Инициализировать контроллер. Контроллер должен инициализироваться после представления.
        controller.init();
    }
//Класс Controller должен содержать метод public void init().
//2.1. Добавь в контроллер и представление по методу init(), пока без реализаций. Они будут отвечать за
//инициализацию контроллера и представления.
    public void init() {
//Метод init() в контроллере должен вызывать метод создания нового документа.
//20.2. Реализуй метод инициализации init() контроллера.
//Он должен просто вызывать метод создания нового документа.
        createNewDocument();
//Проверь работу пункта меню Новый.
    }
//Класс Controller должен реализовывать метод public void exit().
//2.3. Добавь в контроллер метод exit(), он должен вызывать статический метод exit у класса System.
//2.3.1. Метод exit в классе Controller не должен быть статическим.
    public void exit() {
        System.exit(0);
    }
//14.2. Добавь в класс контроллера геттер для модели, в нашем случае это поле document.
//2. Класс Controller должен содержать геттер для поля document.
    public HTMLDocument getDocument() {
        return document;
    }
//Класс Controller должен содержать публичный метод resetDocument(), который будет сбрасывать текущий документ.
//Добавь в контроллер метод resetDocument(), который будет сбрасывать текущий документ. Он должен:
    public void resetDocument() {
//Метод resetDocument() должен удалять у текущего документа document слушателя правок через метод
// removeUndoableEditListener().
//15.1. Удалять у текущего документа document слушателя правок которые можно отменить/вернуть
// (найди подходящий для этого метод, унаследованный от AbstractDocument).
//Слушателя нужно запросить у представления (метод getUndoListener()).
//Не забудь проверить, что текущий документ существует (не null).
        if (document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
//Метод resetDocument() должен создавать новый документ по умолчанию через метод createDefaultDocument().
//15.2. Создавать новый документ по умолчанию и присваивать его полю document.
//Подсказка: воспользуйся подходящим методом класса HTMLEditorKit.
            document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
//Метод resetDocument() должен добавлять новому документу слушателя правок через метод addUndoableEditListener().
//15.3. Добавлять новому документу слушателя правок.
            document.addUndoableEditListener(view.getUndoListener());
//Метод resetDocument() должен вызывать у представления метод update().
//15.4. Вызывать у представления метод update().
            view.update();
    }
//1. Класс Controller должен содержать публичный метод setPlainText(String text), который будет записывать
//переданный текст с html тегами в документ document.
//Добавь метод setPlainText(String text) в контроллер.
//Он будет записывать переданный текст с html тегами в документ document. При его реализации:
    public void setPlainText(String text) {
//Метод setPlainText(String text) должен сбрасывать документ через метод resetDocument().
//16.1. Сбрось документ.
        resetDocument();
//Метод setPlainText(String text) должен создавать новый StringReader на базе переданного параметра.
//16.2. Создай новый реадер StringReader на базе переданного текста.
        StringReader stringReader = new StringReader(text);
//Метод setPlainText(String text) должен вызывать метод read() у объекта HTMLEditorKit.
//16.3. Вызови метод read() из класса HTMLEditorKit, который вычитает данные из реадера в документ document.
        try {
            new HTMLEditorKit().read(stringReader, document, 0);
        } catch (Exception e) {
//Если в методе setPlainText(String text) возникнет исключительная ситуация, то исключение должно
//логироваться через метод log у класса ExceptionHandler.
//16.4. Проследи, чтобы метод не кидал исключения. Их необходимо просто логировать.
            ExceptionHandler.log(e);
        }
    }
//Класс Controller должен содержать публичный метод String getPlainText().
//Добавь метод String getPlainText() в контроллер. Он должен получать текст из документа со всеми html тегами.
    public String getPlainText() {
//В методе getPlainText() должен создаваться объект класса StringWriter.
//17.1. Создай объект StringWriter.
        StringWriter stringWriter = new StringWriter();
//17.2. Перепиши все содержимое из документа document в созданный объект с помощью метода write класса HTMLEditorKit.
        try {
//Метод getPlainText() должен вызывать метод write() у объекта HTMLEditorKit.
            new HTMLEditorKit().write(stringWriter, document, 0, document.getLength());
//17.3. Как обычно, метод не должен кидать исключений.
//Если в методе getPlainText() возникнет исключительная ситуация,
        } catch (Exception e) {
// то исключение должно логироваться через метод log у класса ExceptionHandler.
            ExceptionHandler.log(e);
        }
//5. Метод getPlainText() должен возвращать текст из документа со всеми html тегами.
        return stringWriter.toString();
    }
//20.1. Реализуй метод создания нового документа createNewDocument() в контроллере. Он должен:
    public void createNewDocument() {
//Метод createNewDocument() в контроллере должен выбирать html вкладку у представления.
//20.1.1. Выбирать html вкладку у представления.
        view.selectHtmlTab();
//Метод createNewDocument() в контроллере должен сбрасывать текущий документ.
//20.1.2. Сбрасывать текущий документ.
        resetDocument();
//Метод createNewDocument() в контроллере должен устанавливать новый заголовок окна.
//20.1.3. Устанавливать новый заголовок окна, например: "HTML редактор". Воспользуйся методом setTitle(),
//который унаследован в нашем представлении.
        view.setTitle("HTML редактор");
//Метод createNewDocument() в контроллере должен сбрасывать правки в Undo менеджере.
//20.1.4. Сбрасывать правки в Undo менеджере. Используй метод resetUndo представления.
        view.resetUndo();
//Метод createNewDocument() в контроллере должен обнулить currentFile.
//20.1.5. Обнулить переменную currentFile.
        currentFile = null;
    }

    public void openDocument() {
//23.2. Пришло время реализовать метод openDocument().
//Метод должен работать аналогично методу saveDocumentAs(), в той части, которая отвечает за выбор файла.
//
//Подсказка: Обрати внимание на имя метода для показа диалогового окна.
//
//6. Метод openDocument() в контроллере должен переключать представление на html вкладку.
        view.selectHtmlTab();
//Когда файл выбран, необходимо:
//23.2.1. Установить новое значение currentFile.
//7. Метод openDocument() в контроллере должен создавать новый объект для выбора файла JFileChooser.
        JFileChooser jFileChooser = new JFileChooser();
//8. Метод openDocument() в контроллере должен устанавливать объекту класса JFileChooser в качестве
// фильтра объект HTMLFileFilter.
        jFileChooser.setFileFilter(new HTMLFileFilter());
//9. Метод openDocument() в контроллере должен, используя метод showOpenDialog() у JFileChooser
// показывать диалоговое окно "Open File" для выбора файла.
        int n = jFileChooser.showOpenDialog(view);
//10. Метод openDocument() в контроллере должен установить новое значение currentFile, если пользователь
// подтвердит выбор файла.
        if (n == JFileChooser.APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();

//23.2.2. Сбросить документ.
//11. Метод openDocument() в контроллере должен сбросить документ, если пользователь подтвердит выбор файла.
            resetDocument();
//23.2.3. Установить имя файла в заголовок у представления.
//12. Метод openDocument() в контроллере должен устанавливать имя файла в качестве заголовка окна представления,
// если пользователь подтвердит выбор файла.
            view.setTitle(currentFile.getName());
//23.2.4. Создать FileReader, используя currentFile.
//13. Метод openDocument() в контроллере должен создавать FileReader на базе currentFile,
// если пользователь подтвердит выбор файла.
        try (FileReader fileReader = new FileReader(currentFile)) {
//23.2.5. Вычитать данные из FileReader-а в документ document с помощью объекта класса HTMLEditorKit.
//14. Метод openDocument() в контроллере должен используя HTMLEditorKit вычитать данные из FileReader-а
// в документ document, если пользователь подтвердит выбор файла.
            new HTMLEditorKit().read(fileReader, document, 0);
//23.2.6. Сбросить правки (вызвать метод resetUndo представления).
//15. Метод openDocument() в контроллере должен сбросить правки, если пользователь подтвердит выбор файла.
            view.resetUndo();
        } catch (Exception e) {
//23.2.7. Если возникнут исключения - залогируй их и не пробрасывай наружу.
//16. Метод openDocument() в контроллере не должен кидать исключения, а логировать через ExceptionHandler.
            ExceptionHandler.log(e);
        }
//Проверь работу пунктов меню Сохранить и Открыть.
    }
}
    public void saveDocument() {
//23.1. Напишем метод для сохранения открытого файла saveDocument().
//Метод должен работать также, как saveDocumentAs(), но не запрашивать файл у пользователя, а использовать currentFile.
//Если currentFile равен null, то вызывать метод saveDocumentAs().
//Требования:
//1. Метод saveDocument() в контроллере должен переключать представление на html вкладку.
        view.selectHtmlTab();
//2. Метод saveDocument() в контроллере должен создавать FileWriter на базе currentFile,
// если currentFile != null.
        try {
            if (currentFile != null) {
            FileWriter fileWriter = new FileWriter(currentFile);
//3. Метод saveDocument() в контроллере должен используя HTMLEditorKit переписывать данные из документа
// document в объект FileWriter-а, если currentFile != null.
            new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
        }
        else if (currentFile == null) {
//4. Метод saveDocument() в контроллере должен вызывать метод saveDocumentAs(), если currentFile == null.
        saveDocumentAs();
        }
    } catch (Exception e) {
//5. Метод saveDocument() в контроллере не должен кидать исключения, а логировать через ExceptionHandler.
            ExceptionHandler.log(e);
    }
}

    public void saveDocumentAs() {
//Реализуем в контроллере метод для сохранения файла под новым именем saveDocumentAs().
//Реализация должна:
//22.1. Переключать представление на html вкладку.
//Метод saveDocumentAs() в контроллере должен переключать представление на html вкладку.
        view.selectHtmlTab();
//22.2. Создавать новый объект для выбора файла JFileChooser.
//Метод saveDocumentAs() в контроллере должен создавать новый объект для выбора файла JFileChooser.
        JFileChooser jFileChooser = new JFileChooser();
//22.3. Устанавливать ему в качестве фильтра объект HTMLFileFilter.
//Метод saveDocumentAs() в контроллере должен устанавливать объекту класса JFileChooser в
// качестве фильтра объект HTMLFileFilter.
        jFileChooser.setFileFilter(new HTMLFileFilter());
//22.4. Показывать диалоговое окно "Save File" для выбора файла.
//Метод saveDocumentAs() в контроллере должен, используя метод showSaveDialog() у JFileChooser
// показывать диалоговое окно "Save File" для выбора файла.
        int n = jFileChooser.showSaveDialog(view);
//22.5. Если пользователь подтвердит выбор файла:
//22.5.1. Сохранять выбранный файл в поле currentFile.
//5. Метод saveDocumentAs() в контроллере должен сохранять выбранный файл в поле currentFile,
// если пользователь подтвердит выбор файла.
        if (n == JFileChooser.APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();

//22.5.2. Устанавливать имя файла в качестве заголовка окна представления.
//Метод saveDocumentAs() в контроллере должен устанавливать имя файла в качестве заголовка окна
// представления, если пользователь подтвердит выбор файла.
        view.setTitle(currentFile.getName());
//22.5.3. Создавать FileWriter на базе currentFile.
//Метод saveDocumentAs() в контроллере должен создавать FileWriter на базе currentFile,
// если пользователь подтвердит выбор файла.
        try (FileWriter fileWriter = new FileWriter(currentFile)) {
//22.5.4. Переписывать данные из документа document в объекта FileWriter-а аналогично тому,
// как мы это делали в методе getPlainText().
//Метод saveDocumentAs() в контроллере должен используя HTMLEditorKit переписывать данные из
// документа document в объект FileWriter-а, если пользователь подтвердит выбор файла.
            new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
        } catch (Exception e) {
//22.6. Метод не должен кидать исключения.
//Метод saveDocumentAs() в контроллере не должен кидать исключения, а логировать через ExceptionHandler.
            ExceptionHandler.log(e);
        }
//Проверь работу пункта меню Сохранить как...

    }

//Убедись, что метод saveDocumentAs() НЕ переписывает данные из документа document в объект FileWriter-а
// если пользователь НЕ подтвердит выбор файла.



    }
}