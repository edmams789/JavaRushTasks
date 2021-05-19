package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел

1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно.
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла, считать содержимое файла.
3. Заменить все числа на слова используя словарь map.
4. Результат вывести на экран.
5. Закрыть потоки.

Пример данных в файле:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода в консоль:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.

Требования:
1. Класс Solution должен содержать публичное статическое поле map типа Map<Integer, String>,
которое должно быть сразу проинициализировано.
2. Программа должна считывать имя файла с консоли (используй BufferedReader).
3. BufferedReader для считывания данных с консоли должен быть закрыт.
4. Программа должна считывать содержимое файла (используй FileReader).
5. Поток чтения из файла (FileReader) должен быть закрыт.
6. Программа должна выводить в консоль все строки из файла, но числа должны быть заменены на слова
из словаря map.
7. Класс Solution должен содержать статический блок, в котором добавляются в map тринадцать пар.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fileReader);

//        StringBuilder stringBuilder = new StringBuilder();
//        String s = stringBuilder.toString();
//
//            for (Map.Entry<Integer, String> pair : map.entrySet()){
//                Pattern pattern = Pattern.compile(String.valueOf(pair.getKey()));
//                Matcher matcher = pattern.matcher(s);
//                s = s.replaceAll("\\b" + String.valueOf(pair.getKey()) + "\\b", pair.getValue());
//            }
        String s;
        Matcher m;
        while (br.ready()) {
            s = br.readLine();
            for (Map.Entry<Integer, String> pair : map.entrySet()) {
                m = Pattern.compile("((^| )" + pair.getKey() + "( |$))").matcher(s);
                while (m.find())
                    s = s.replaceAll(m.group(1), m.group(2) + pair.getValue() + m.group(3));
            }
            System.out.println(s);
            fileReader.close();
        }}}

//В итоге решил через StringBuilder.  Хоть потратил много времени, но какое же приятное ощущение, что сделал с 1 попытки до прочтения подсказок.
//
//String s = sb.toString();
//
//for (Map.Entry<Integer, String> entry : map.entrySet()){
//    Pattern pt = Pattern.compile(String.valueOf(entry.getKey()));
//    Matcher m = pt.matcher(s);
//    s = s.replaceAll("\\b" + String.valueOf(entry.getKey()) + "\\b", entry.getValue());
//}
//System.out.println(s);

//Обращаю вимание:
//while(fileReader.ready()){
//	s=fileReader.readLine();
//	for(Map.Entry<Integer,String> pair : map.entrySet())
//		s=s.replaceAll("\\b"+pair.getKey()+"\\b",pair.getValue());
//	System.out.println(s);
//}
//
//Хоть и валидатор хавает это.
//Но! Вот такая вот строка обработается не правильно имхо:
//+1 2 .2 3. \5 9" -1  $1
//
//+один два .два три. \пять девять" -один  $один
//
//Мне кажется это более верный вариант:
//Matcher m;
//while(fileReader.ready()){
//	s=fileReader.readLine();
//	for(Map.Entry<Integer,String> pair : map.entrySet()){
//		m=Pattern.compile("((^| )"+pair.getKey()+"( |$))").matcher(s);
//		while(m.find())
//			s=s.replaceAll(m.group(1), m.group(2)+pair.getValue()+m.group(3));
//	}
//	System.out.println(s);
//}

//У матчера есть замечательный метод appendReplacement, который позволяет в буфере динамически делать
// измениения:
//StringBuffer replacements = new StringBuffer();
//            while (m.find()) {
//                Integer i = Integer.parseInt(m.group());
//                if (map.containsKey(i)) {
//                    m.appendReplacement(replacements, map.get(i));
//                }
//            }
//            m.appendTail(replacements);
//m.appendReplacement - билдит новую строку с подстановкой значения из 2 параметра вместо найденного.
//m.appendTail  - добавляет хвост, все, что не было учитано в билде.