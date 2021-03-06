package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/*
HTML Editor (21)
Для открытия или сохранения файла мы будем использовать JFileChooser из библиотеки swing.
Объекты этого типа поддерживают фильтры, унаследованные от FileFilter.
Сейчас мы напишем свой фильтр:
21.1. Создай публичный класс HTMLFileFilter унаследованный от FileFilter.
21.2. Мы хотим, чтобы окно выбора файла отображало только html/htm файлы или папки.
Переопредели метод accept(File file), чтобы он возвращал true, если переданный файл директория или
содержит в конце имени ".html" или ".htm" без учета регистра.
21.3. Чтобы в окне выбора файла в описании доступных типов файлов отображался текст "HTML и HTM файлы"
переопредели соответствующим образом метод getDescription().

Требования:
1. Класс HTMLFileFilter должен быть создан в отдельном файле.
2. Класс HTMLFileFilter должен наследоваться от FileFilter.
3. Метод accept(File f) класса HTMLFileFilter должен возвращать true, если переданный файл - директория
или содержит в конце имени ".html" или ".htm" без учета регистра.
4. Метод accept(File f) класса HTMLFileFilter должен возвращать false, если переданный файл - НЕ директория
или НЕ содержит в конце имени ".html" или ".htm" без учета регистра.
5. Метод getDescription() класса HTMLFileFilter должен возвращать строку "HTML и HTM файлы".
*/
//Класс HTMLFileFilter должен быть создан в отдельном файле.
//Класс HTMLFileFilter должен наследоваться от FileFilter.
//21.1. Создай публичный класс HTMLFileFilter унаследованный от FileFilter.
public class HTMLFileFilter extends FileFilter {
//Метод accept(File f) класса HTMLFileFilter должен возвращать true, если переданный файл - директория
//или содержит в конце имени ".html" или ".htm" без учета регистра.
//Метод accept(File f) класса HTMLFileFilter должен возвращать false, если переданный файл - НЕ директория
//или НЕ содержит в конце имени ".html" или ".htm" без учета регистра.
//21.2. Мы хотим, чтобы окно выбора файла отображало только html/htm файлы или папки.
//Переопредели метод accept(File file), чтобы он возвращал true, если переданный файл директория или
//содержит в конце имени ".html" или ".htm" без учета регистра.
    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
        else if (!file.isDirectory()) {
            String fileName = file.getName().toLowerCase();
            return fileName.endsWith(".html") || fileName.endsWith(".htm");
        }
        return false;
    }
//Метод getDescription() класса HTMLFileFilter должен возвращать строку "HTML и HTM файлы".
//21.3. Чтобы в окне выбора файла в описании доступных типов файлов отображался текст "HTML и HTM файлы"
//переопредели соответствующим образом метод getDescription().
    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
