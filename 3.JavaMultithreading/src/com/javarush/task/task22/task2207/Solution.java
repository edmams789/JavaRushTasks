package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Использовать StringBuilder.
Кодировка файла - UTF-8.

Пример содержимого файла
рот тор торт о
о тот тот тот

Вывод:
рот тор
о о
тот тот


Требования:
1. Метод main должен считывать имя файла с клавиатуры.
2. В методе main должен быть использован StringBuilder.
3. В классе Solution должен содержаться вложенный класс Pair с методами equals, hashCode и toString.
Удалять или изменять эти методы нельзя.
4. В классе Pair должен быть объявлен конструктор без параметров (или конструктор по умолчанию).
5. Список result должен быть заполнен корректными парами согласно условию задачи.
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = reader.readLine();
//        FileReader fileReader = new FileReader(fileName);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        StringBuilder stringBuilder = new StringBuilder();
//        while (bufferedReader.ready()) {
//            stringBuilder.append(bufferedReader.readLine() + " ");
//        }
//        String[] str = stringBuilder.toString().trim().split(" ");//преобразовать stringBuilder обратно в строку (toString()) и поделить пробелами
//
//        for (int i = 0; i < str.length; i++){
//            String buf = new StringBuilder(str[i]).reverse().toString();
//            for (int j = i + 1; j < str.length; j++){
//                if (buf.equals(str[j])){
//                    Pair pair = new Pair();
//                    pair.first = str[i];
//                    pair.second = str[j];
//                    boolean b = true;
//                    for (int y = 0; y < result.size(); y++){
//                        if (pair.first.equals(result.get(y).first) || pair.first.equals(result.get(y).second));
//                            b = false;
//                    }
//                    if (b)
//                        result.add(pair);
//                    b = false;
//                }
//            }
//        }
//        for (int q = 0; q < result.size(); q++)
//            System.out.println(result.get(q));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(name));
        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready()) {
            stringBuilder.append(fileReader.readLine() + " ");
        }
        //System.out.println(stringBuilder.toString());
        String[] words = stringBuilder.toString().trim().split(" ");

        for(int i=0;i<words.length;i++)
        {
            String buf = new StringBuilder(words[i]).reverse().toString();
            for(int j=i+1;j<words.length;j++)
            {
                if(buf.equals(words[j]))
                {
                    Pair p = new Pair();
                    p.first = words[i];
                    p.second = words[j];
                    boolean b=true;
                    for(int k=0;k<result.size();k++) {
                        if((p.first.equals(result.get(k).first)) || (p.first.equals(result.get(k).second)))
                            b=false;
                    }
                    if(b)
                        result.add(p);
                    b = false;

                }
            }
        }
        for(int k=0;k<result.size();k++) {
            System.out.println(result.get(k));
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
//C:\Users\Александр\Desktop\fileOne.txt

//List<String> list = new LinkedList<>(Arrays.asList(stringBuilder.toString().trim().split(" ")));

//Ой, да ладно, хорошая задачка, помогает почесать мозги) Делов-то. Читаем построчно из файла,
// загоняем в стрингбилдер(не забываем пробел после считывания очередной строки!), сплитим по пробелам,
// проходимся по полученному массиву двумя циклами: внешний цикл берет конкретное слово, сравнивает
// со всеми другими словами, только перевернутыми. Если найдено соответствие любого слова из пары,
// то брейк, иначе - добавляем. Потом берет второе слово, опять со всеми словами сравниваем...
//Только помните: СтрингБилдер - изменяемый! Вызов метода .reverse() не вернет вам новую перевернутую
// строку, а изменит текущую строку насовсем! Создавайте новый объект, чтобы хранить перевернутую строку.