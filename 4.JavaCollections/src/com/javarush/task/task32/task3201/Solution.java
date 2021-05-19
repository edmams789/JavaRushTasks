package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
В метод main приходят три параметра:
1) fileName - путь к файлу;
2) number - число, позиция в файле;
3) text - текст.
Записать text в файл fileName начиная с позиции number.
Запись должна производиться поверх старых данных, содержащихся в файле.
Если файл слишком короткий, то записать в конец файла.
Используй RandomAccessFile и его методы seek и write.

Требования:
1. В методе main класса Solution необходимо использовать RandomAccessFile.
2. В методе main класса Solution программа должна записывать данные в файл при помощи метода write класса RandomAccessFile.
3. Запись в файл должна происходить с указанной позиции с заменой содержимого.
4. Если файл слишком короткий, то запись text должна происходить в конец файла.
*/
public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        long position = Integer.parseInt(args[1]);
        String text = args[2];

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
//Если файл слишком короткий, то записать в конец файла.
        position = position > raf.length() ? raf.length() : position;
        raf.seek(position);
        raf.write(text.getBytes());
        raf.close();
    }
}
//возник вопрос, чем различаются методы:
//1) raf.writeBytes(string)
//2) raf.write(string.getBytes())
//3) raf.writeChars(string)
//4) raf.writeUTF(string)
//
//попробовал и получил такие 4 результата:
//1) всегда одному символу соотносит один байт;
//2) записывает столько байтов на каждый символ, сколько потребуется по правилам кодировки;
//3) превращает любой символ в двухбайтную последовательность (char). таким образом,
// если символ укладывается в один байт, то будет дополнительно записан один нулевой байт
//4) похож на второй, но отмечает начало строки двумя символами: 0x00 и 0x07 (не понял, зачем)
//
//в нашем случае правильный - второй.