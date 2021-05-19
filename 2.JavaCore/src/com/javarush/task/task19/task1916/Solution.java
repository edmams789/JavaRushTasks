package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* 
Отслеживаем изменения

Считать с консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
Пустые строки даны в примере для наглядности.
В оригинальном и редактируемом файлах пустых строк нет!

Пример 1:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
строка4                            REMOVED строка4
строка5         строка5            SAME строка5
                строка0            ADDED строка0
строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
                строка4            ADDED строка4
строка5         строка5            SAME строка5
строка0                            REMOVED строка0

Пример 2:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
                строка0            ADDED строка0

Пустые строки в примере означают, что этой строки нет в определенном файле.


Требования:
1. Класс Solution должен содержать класс LineItem.
2. Класс Solution должен содержать enum Type.
3. Класс Solution должен содержать публичное статическое поле lines типа List<LineItem>,
которое сразу проинициализировано.
4. В методе main(String[] args) программа должна считывать имена файлов с консоли
(используй BufferedReader).
5. В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
6. Программа должна считывать содержимое первого и второго файла (используй FileReader).
7. Потоки чтения из файлов (FileReader) должны быть закрыты.
8. Список lines должен содержать объединенную версию строк из файлов, где для каждой строки указана
одна из операций ADDED, REMOVED, SAME.
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        FileReader fileReader1 = new FileReader(file1);
        FileReader fileReader2 = new FileReader(file2);

        BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);

      //  while (fileReader1.ready() && fileReader2.ready()){
      //  while (bufferedReader1.ready() && bufferedReader2.ready()){


//Ушло пол дня...
//
//- создаем и считываем в 2 ArrayList-а строки из 2-х файлов
//- ПОПАРНО сравниваем значения  (т.е. list1.get(0) сравниваем с list2.get(0))
//   - если equals, то это тип SAME
//   - иначе сравниваем: list1.get(1) совпадает ли с list2.get(0) , если да - REMOVED
//   - иначе: list1.get(0) совпадает ли с list2.get(1) , если да - ADDED
//- удаляем значения, которые уже проверили и внесли в lines
//
//В конце проверяем не осталось ли в list1 и list2 значений, если да:
//- все из list1 - REMOVED
//- все из list2 - ADDED

            String line1 = bufferedReader1.readLine();
            String line2 = bufferedReader2.readLine();

            while (bufferedReader1.ready() && bufferedReader2.ready()){
//- создаем и считываем в 2 ArrayList-а строки из 2-х файлов
                List<String> list1 = new ArrayList<>();
                list1.add(line1);
                List<String> list2 = new ArrayList<>();
                list2.add(line2);
//                for (int i = 0; i < list1.size(); i++)
//                System.out.println(list1.get(i));

                if (list1.get(0).equals(list2.get(0))){
                    lines.add(new LineItem(Type.SAME, line1));
//                } else if (list1.get(1).equals(list2.get(0))){
//                    lines.add(new LineItem(Type.REMOVED, line1));
//                } else if (list1.get(0).equals(list2.get(1))){
//                    lines.add(new LineItem(Type.ADDED, line2));
                }
                for (LineItem text : lines){
                    System.out.println(text);
                }
//                for (String line : list1){
//                    System.out.println(line);
//                }
            }

        fileReader1.close();
        fileReader2.close();
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
//C:\Users\Александр\Desktop\file1.txt
//C:\Users\Александр\Desktop\file2.txt

//Пока что самая интересная задача за 19 уровней. 2 часа потратил на разработку, отладку и тестирование, но сдал с 1 раза.
//1. Для сравнения используем null-безопасный Objects.equals().
//2. Объявляем переменные line1, line2. Считываем в них по 1 строке из каждого файла.
//3. Объявляем nextLine1, nextLine2. Устанавливаем им значение null (для п. 5.2).
//4. Начинаем цикл while (line1 != null || line2 != null)
//5. Если строки равны:
//5.1. Добавляем запись в lines.
//5.2. Считываем следующие строки в line из nextLine (если там есть значение) или из файлов.
//5.3. Конец итерации.
//6. Если строки не равны:
//6.1. Считываем строки в nextLine из каждого файла.
//6.2. Если line1 равна nextLine2, значит в первом файле не хватает строки (была добавлена):
//6.2.1. Добавляем вторую строку в lines.
//6.2.2. Синхронизируем строки для следующей итерации: line2 = nextLine2, обnullяем nextLine2.
//6.2.3. nextLine1 хранит строку, которая понадобится через 1 итерацию.
//6.3. Если line2 равна nextLine1, значит во втором файле не хватает строки (была удалена):
//6.3.1. Добавляем первую строку в lines.
//6.3.2. Синхронизируем строки для следующей итерации: line1 = nextLine1, обnullяем nextLine1.
//6.3.3. nextLine2 хранит строку, которая понадобится через 1 итерацию.
//6.4. Конец итерации. Гарантировано попадаем в пункт 5.