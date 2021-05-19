package com.javarush.task.task18.task1810;

/* 
DownloadException

1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки работы с файлами.
2.2 Выбросить исключение DownloadException.


Требования:
1. Программа должна считать имена файлов с консоли.
2. Для чтения из файлов используй поток FileInputStream.
3. Программа должна работать, пока введенный файл не окажется меньше 1000 байт.
4. Программа должна завершиться исключением DownloadException.
5. Поток FileInputStream должен быть закрыт.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            FileInputStream fileInputStream = new FileInputStream(reader.readLine());
            if (fileInputStream.available() < 1000){
                fileInputStream.close();
                reader.close();
                throw new DownloadException();
            }
            fileInputStream.close();
        }
    }
    public static class DownloadException extends Exception {

    }
}
//Чтобы валидатор не зависал нужно после каждой итерации цикла закрывать поток!
//while (true) {
//           fileInputStream = new FileInputStream(reader.readLine());
//          if (fileInputStream.available() < 1000){
//           fileInputStream.close();
//           reader.close();
//           throw new DownloadException();
//          }
//          fileInputStream.close(); // ОБЯЗАТЕЛЬНО, ИНАЧЕ НЕ ПРИНИМАЕТ
//       }


//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
//FileInputStream inputStream;
//while((inputStream=new FileInputStream(reader.readLine())).available()>999){
//}
//inputStream.close();
//throw new DownloadException();


//if(inputStream.available()<1000){
//                   reader.close();
//                   inputStream.close();
//                   throw new DownloadException();}

//do {
//            String filename = reader.readLine(); // "c:/tmp/data.txt"; // тут вводим имя файла
//            FileInputStream filestream = new FileInputStream(filename); // создаем новый поток чтения
//
//            if (filestream.available() < 1000){  // если кол-во байтов меньше 1000
//                filestream.close(); // закрыть поток
//                throw new DownloadException(); // бросить исключение
//            }
//        } while (true); // вводить новые имена пока файл не будет меньше 1000