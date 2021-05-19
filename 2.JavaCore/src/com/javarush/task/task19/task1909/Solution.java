package com.javarush.task.task19.task1909;

/* 
Замена знаков

Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла и заменить все точки "." на знак "!".
Результат вывести во второй файл.
Закрыть потоки.

Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл содержимое первого файла, где заменены все точки "." на знак "!" (Для записи в файл используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
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
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        try {
           // String line;
         //   while ((line = bufferedReader.readLine()) != null){
            while (bufferedReader.ready()){
         //       String str = line.replaceAll("\\.", "!");
            String str = bufferedReader.readLine().replaceAll("\\.", "!");
            //    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(str);
        }
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e){

        }
        fileReader.close();
        fileWriter.close();
    }
}
//fileWriter.write(fileReader.readLine().replaceAll("\\.", "!"));

//Вот так не прошло:
//String result = line.replaceAll(".", "!");
//
//А вот так прошло:
//String result = line.replace(".", "!");
//
//А в чём разница-то?

//replaceAll() заменяет вхождения регулярного выражения, а replace() последовательность символов,
// переданную первым параметром

//Точка . в регулярном выражении означает любой символ. Если вы имеете ввиду именно точку, то необходимо
// это указать при помоши: \\. Называется это экранированием точки. То же касается и других, так
// называемых, метасимволов. Об этом можете подробнее поискать в интернете.
//Что касается методов replace() и replaceAll()  - первый в качестве параметров использует символы,
// второй - регулярные выражения. Поэтому у вас первый метод сработал, а второй должен заменить все
// символы на восклицательный знак.

//C:\Users\Александр\Desktop\fileOne.txt
//C:\Users\Александр\Desktop\fileTwo.txt