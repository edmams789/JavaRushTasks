package com.javarush.task.task19.task1907;

/* 
Считаем слово

Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.

Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        int count = 0;
        //while ((line = bufferedReader.readLine()) != null){

        while (bufferedReader.ready()) {
//            StringBuffer stringBuffer = new StringBuffer();
//            stringBuffer.append(" ");
            String[] str = bufferedReader.readLine().split("\\bworld\\b");

//            String str = bufferedReader.readLine().replaceAll("\\bworld\\b", "");
            for (String s : str) {
                if (s.equals("world")){
                    count++;
                    System.out.println(s);
                }
            }

//            StringBuffer stringBuffer = new StringBuffer();
//            stringBuffer.append(" ");
//            Pattern pattern1 = Pattern.compile("\\bworld\\b");
//            for (Pattern p : pattern1) {
//                if (p.equals("world"))
//                    i++;

            }
//    while (bufferedReader.ready()) {
//        String[] str = bufferedReader.readLine().split("\\bworld\\b");
//        for (int i = 0; i < str.length; i++) {
//            if (str[i].equals("world"))
//                count++;
//        }
//    }
//while (buffer.ready()){
//            String[] wordsInLine = buffer.readLine().split("\\pP");
//            for (int i=0; i<wordsInLine.length; i++){
//                if (wordsInLine[i].equals("world"))
//                    count++;
//            }
//        }
//String[] world = file.split("\\bworld\\b");
//        System.out.println(world.length - 1);
//Т.е не сами слова, а то что от них осталось)

//в while прочел построково содержимое файла, сразу сплитил в массив по следующему регулярному выражению:
//String[] s = scanner.nextLine().split("\\W");
//
//там же в while пропускал в цикле все элементы массива (т.е. слова) и сравнивал с искомым "world"
// плюсуя счетчик при совпадении. Все принялось

//            for (String s : str)
//                if (s.equals("world"))
//                    i++;
       // }
        fileReader.close();
        System.out.println(count);

    }
}
//1. Не считает потому что матчер ищет то что ты ему написал:
//[Сначала следует символ, не составляющий слово] потом идет слово world [в конце следует символ,
// не составляющий слово]
//
//В начале файла никаких символов перед словом world нет, поэтому он его пропускает.
// В конце, следовательно тоже последний символ(если слово "world" последнее) стоит буква "d",
// что тоже пропускается матчером как не подходящее на 100% под выражение. Нужно использовать
// "\\bworld\\b". \\b обозначает, что это отдельное слово, никаких символов до и после нет.
// (напр. zworld worldass не проходят)
//
//2. "worldworld" - это не то же самое что два слова "world". По крайней мере, с точки зрения выражения
// \\b. Кстати, в данном случае можно не заключать управляющие операторы регулярных выражений
// в квадратные скобки!
//Pattern.compile("\\Wworld\\W");

//String[] arr = freader.readLine().split("\\W");
//count = count + Collections.frequency(new ArrayList<String >(Arrays.asList(arr)),"world" )

//На всякий случай. Решение через такую конструкцию не проходит, хотя и выводит правильный результат:
//System.out.println(sb.toString().split("world",-1).length-1);
//Пришлось делать через регулярные выражения(оно и грамотнее пожалуй =))

//Эта задача показывает как много разных вариантов в решении может быть и все они будут правильными:
//1. Я через буфер считывал файл строками, добавлял пробел и собирал в одну. Потом split по регулярному
// выражению \\bworld\\b и от получившегося массива брал его размер и вычитал 1
//2. Lex решил через использование класса Matcher и построчного считывания
//3. Irina и Aleksei Dobrovolskii проверяли через регулярные выражения на символы, обрамляющие запрос по
// негативному и позитивному сценарию
//4. Shamil ,судя по примеру, собирал отдельные слова чисто из символов ASCII относящихся к буквам и
// проверял на точное соответствие получившихся слов
//5. Oleg Savenko собрал файл в строку и заменил на пустой символ (удалил) по регулярному выражению
// \\bworld\\b. Затем посчитал разницу длин строк и разделил на длину запроса