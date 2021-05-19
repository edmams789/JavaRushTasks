package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки

Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words.
Закрыть потоки.

Пример:
words содержит слова А, Б, В

Строки:
В Б А Д //3 слова из words, не подходит
А Б А Д //3 слова из words, не подходит
Д А Д //1 слово из words, не подходит
Д А Б Д //2 слова - подходит, выводим
Д А А Д //2 слова - подходит, выводим


Требования:
1. Класс Solution должен содержать публичное статическое поле words типа List<String>,
которое должно быть сразу проинициализировано.
2. Класс Solution должен содержать статический блок, в котором добавляются три или больше слов
в список words.
3. Программа должна считывать имя файла с консоли (используй BufferedReader).
4. BufferedReader для считывания данных с консоли должен быть закрыт.
5. Программа должна считывать содержимое файла (используй FileReader).
6. Поток чтения из файла (FileReader) должен быть закрыт.
7. Программа должна выводить в консоль все строки из файла, которые содержат всего 2 слова из списка words.
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
    /*  выдает правильный ответ, но не принимает валидатором
        while (bufferedReader.ready()){
            String str = bufferedReader.readLine();
            if (str == null) break;
            int count = 0;
            for (String s : words) if (str.contains(s)) count++;
            if (count == 2) System.out.println(str);
        }*/
        String line;
        while ((line = bufferedReader.readLine()) != null){
            int count = 0;
            for (String str : words){
                Pattern pattern = Pattern.compile("\\b" + str + "\\b");
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) count++;
            }
            if (count == 2) System.out.println(line);
        }
        fileReader.close();
    }
}
//C:\Users\Александр\Desktop\fileTwo.txt

//public class Solution {
//    public static List<String> words = new ArrayList<String>();
//
//    static {
//        words.add("file");
//        words.add("view");
//        words.add("V");
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String filename = reader.readLine();
//        reader.close();
//        reader = new BufferedReader(new FileReader(filename));
//
//        String line;
//        while ((line = reader.readLine()) != null) {
//            int count = 0;
//            for (String word : words) {
//                Pattern p = Pattern.compile("\\b"+word+"\\b");
//                Matcher m = p.matcher(line);
//                if (m.find()) count++;
//            }
//            if (count == 2) System.out.println(line);
//        }
//        reader.close();
//    }
//}

//а я, по старинке, счетчиком)))
//while (fr.ready()) {
//    String str = fr.readLine();
//    List<String> list = new ArrayList<>(Arrays.asList(str.split(" ")));
//    int count = 0;
//    for (String s : words) count += Collections.frequency(list, s);
//    if (count == 2) System.out.println(str);
//}