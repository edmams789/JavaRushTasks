package com.javarush.task.task17.task1721;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность

Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла.
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines.
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки,
которые есть в forRemoveLines.
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.


Требования:
1. Класс Solution должен содержать public static поле allLines типа List<String>.
2. Класс Solution должен содержать public static поле forRemoveLines типа List<String>.
3. Класс Solution должен содержать public void метод joinData()
который может бросать исключение CorruptedDataException.
4. Программа должна считывать c консоли имена двух файлов.
5. Программа должна считывать построчно данные из первого файла в список allLines.
6. Программа должна считывать построчно данные из второго файла в список forRemoveLines.
7. Метод joinData должен удалить в списке allLines все строки из списка forRemoveLines,
если в allLines содержаться все строки из списка forRemoveLines.
8. Метод joinData должен очистить список allLines и выбросить исключение CorruptedDataException,
если в allLines не содержаться все строки из списка forRemoveLines.
9. Метод joinData должен вызываться в main.
*/

public class Solution {
//1. Класс Solution должен содержать public static поле allLines типа List<String>.
    public static List<String> allLines = new ArrayList<String>();

//2. Класс Solution должен содержать public static поле forRemoveLines типа List<String>.
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {

//4. Программа должна считывать c консоли имена двух файлов.
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            try {
                String fileFirst = reader.readLine();
                String fileSecond = reader.readLine();
//5. Программа должна считывать построчно данные из первого файла в список allLines.
                allLines = Files.readAllLines(Paths.get(fileFirst));

//6. Программа должна считывать построчно данные из второго файла в список forRemoveLines.
                forRemoveLines = Files.readAllLines(Paths.get(fileSecond));
//команда readAllLines сама закрывает потоки после окончания работы

            } catch (IOException e) {
            }

//9. Метод joinData должен вызываться в main.
    Solution solution = new Solution();
    try {
        solution.joinData();
    } catch (CorruptedDataException e) {
    }
    }

//3. Класс Solution должен содержать public void метод joinData()
//который может бросать исключение CorruptedDataException.
    public void joinData() throws CorruptedDataException {

//8. Метод joinData должен очистить список allLines и выбросить исключение CorruptedDataException,
//если в allLines не содержаться все строки из списка forRemoveLines.
        if (allLines.containsAll(forRemoveLines)){//...если в allLines не содержаться все строки из списка forRemoveLines.

//7. Метод joinData должен удалить в списке allLines все строки из списка forRemoveLines,
//если в allLines содержаться все строки из списка forRemoveLines.
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();//очистить список allLines...
            throw new CorruptedDataException();//...и выбросить исключение CorruptedDataException,...
        }
    }
}
//Теперь о том, как по идее должен быть выстроен алгоритм для симуляции транзакций:
//0) Создаем два файла, либо идентичных (всё ОК), либо разных - чтобы симулировать сбой
//1) В main читаем имена файлов и их содержимое
//2) Далее в методе joinData() проводим сравнение данных и, если его нет, бросаем исключение
//
//Потоки здесь в принципе не подразумеваются.

//Эта задача - типичный пример того, как не нужно на пустом месте выдумывать велосипед.
// Всё уже придумано до нас :)
//Считать все строки из файла можно вот таки кодом:
//allLines = Files.readAllLines(Paths.get(bufferedReader.readLine()));
//
//А для проверок и удаления существуют методы containsAll, removeAll и clear.


