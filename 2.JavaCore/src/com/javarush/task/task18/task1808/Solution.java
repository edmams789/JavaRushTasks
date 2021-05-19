package com.javarush.task.task18.task1808;

/* 
Разделение файла

Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
3. Первую половину байт из первого файла нужно записать во второй файл.
4. Вторую половину байт из первого файла нужно записать в третий файл.
5. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());

        int a = inputStream.available();
        byte[] buffer = new byte[(a + 1) / 2];
        int count = inputStream.read(buffer);

        outputStream.write(buffer, 0, count);
        outputStream.close();
        outputStream = new FileOutputStream(reader.readLine());
        buffer = new byte[a / 2];
        count = inputStream.read(buffer);
        outputStream.write(buffer, 0, count);

        inputStream.close();
        outputStream.close();
    }
}
//public static void main(String[] args) throws IOException{
//	BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
//	FileInputStream inputStream=new FileInputStream(reader.readLine());
//	FileOutputStream outputStream=new FileOutputStream(reader.readLine());
//
//	//обработка данных
//	int a=inputStream.available();
//	byte[] buffer=new byte[(a+1)/2];
//	int count=inputStream.read(buffer);
//
//	//записи по файлам
//	outputStream.write(buffer,0,count);
//	outputStream.close();
//	outputStream=new FileOutputStream(reader.readLine());
//	buffer=new byte[a/2];
//	count=inputStream.read(buffer);
//	outputStream.write(buffer,0,count);
//
//	//конечное освобождение памяти
//	inputStream.close();
//	outputStream.close();
//}
//В коде 1 поток на чтение, и 2 на запись. Для потоков записи используется одна переменная.
//• Первый раз, когда мы записываем первую (бОльшую) половину файла1 в файл2.
//• Второй раз, когда мы закрыли запись в файл2, переменная стала свободной (ненужной),
// и поэтому может использоваться  для создания нового потока в файл3 оставшейся половины.