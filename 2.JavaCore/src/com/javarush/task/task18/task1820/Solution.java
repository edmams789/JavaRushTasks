package com.javarush.task.task18.task1820;

/* 
Округление чисел

Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.

Принцип округления:
3.49 => 3
3.50 => 4
3.51 => 4
-3.49 => -3
-3.50 => -3
-3.51 => -4


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения. Для второго - поток для записи.
3. Считать числа из первого файла, округлить их и записать через пробел во второй.
4. Должны соблюдаться принципы округления, указанные в задании.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();;

    //    FileInputStream fileInputStream = new FileInputStream(fileName1);
    //    FileOutputStream fileOutputStream = new FileOutputStream(fileName2);

    //    reader.close();

        try (
             BufferedReader read = new BufferedReader(new FileReader(new File(fileName1)));
             BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName2)))
        ){
            String line;

            while((line = read.readLine()) != null){
                String[] numbers = line.split(" ");

                for(String num : numbers)
                {
                    try {
                        int a = Math.round(Float.parseFloat(String.valueOf(num)));
                        writer.write(a + " ");
                    } catch (NumberFormatException e) {
                        System.out.println(e);
                    }}}}
        catch (IOException e){
            System.err.println(e);
        }
//            fileInputStream.close();
//            fileOutputStream.close();
            }
    }
//А это что за err ?
// System.err.println(e);
// - Поток в который выводятся ошибки. В IDEA текст из потока err выводится красным цветом

//потоки не закрыл
// - потоки здесь не нужно закрывать, так как они закрываются автоматически в try -with-resources
