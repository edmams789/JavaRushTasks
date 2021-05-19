package com.javarush.task.task19.task1906;

/* 
Четные символы
Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным порядковым номером (нумерация начинается с 1).

Пример первого файла:
text in file
Вывод во втором файле:
eti ie
Закрыть потоки ввода-вывод


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна записывать во второй файл все байты из первого файла с четным порядковым номером
(используй FileWriter).
6. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = reader.readLine();
        String fileTwo = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(fileOne);
        FileWriter fileWriter = new FileWriter(fileTwo);
        byte b = 0;
        while (fileReader.ready()){
            int data = fileReader.read();
          //  if (data % 2 == 0 )
            if ((b ^= 1) == 0)
              fileWriter.write(data);
        }
        fileReader.close();
        fileWriter.close();
    }
}
//Нет всё происходит чётно. Только вот считывание должно быть всегда, а запись должна быть чётной.
// А тут получается всё запишется рано или поздно.
//Я кстати по другому на чётность проверял:
//byte b=0;
//int c;
//while(reader.ready()){
//	c=reader.read();
//	if((b^=1)==0)
//		writer.write(c);
//}
//writer.close();
//reader.close();

//Бинарная инверсия. При каждой операции b^=1 переменная b меняется то на ноль то на единицу.
//Гуглите побитовые операции.

//возьмём строку - "0123456789"
//в цикле(сперва чтение потом пропуск):
//data=fileReader.read(); // считает  из строки "0"   // на следующем шаге цикла считает 2 ..и т.д. -- 4,6,8...
////data можно использовать например для записи в файл
//fileReader.skip(1); // пропустит  "1" // на следующем шаге цикла пропустит 3 .. т.д. -- 5,7...
////  в файл запишется строка "0248"

//в цикле(сперва пропуск потом чтение):
//fileReader.skip(1); // пропустит  "0" // на следующем шаге цикла пропустит 2 .. т.д. -- 4,6...
//data=fileReader.read(); // считает  из строки "1"   // на следующем шаге цикла считает 3 ..и т.д. -- 5,7...
////  в файл запишется строка "13579"