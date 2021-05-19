package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович

В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013

Требования:
1. Класс Solution должен содержать публичную константу PEOPLE типа List<Person>,
которая должна быть сразу проинициализирована.
2. Программа НЕ должна считывать данные с консоли.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна заполнить список PEOPLE данными из файла.
6. Программа должна правильно работать с двойными именами, например Анна-Надежда.
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        StringBuilder name = new StringBuilder();
        while (reader.ready()){
            String[] str = reader.readLine().split(" ");
            for (int i = 0, j = str.length - 3; i < j; name.append(str[i++]).append(" "));
            name.setLength(name.length() - 1);
            PEOPLE.add(
                    new Person(name.toString(),
                    new Date(Integer.parseInt(str[str.length - 1]) - 1900,
                    Integer.parseInt(str[str.length - 2]) - 1,
                    Integer.parseInt(str[str.length - 3]))));
            name.setLength(0);
        }
        reader.close();
    }}
//Чот смотрю у всех какой-то взрыв с регулярками и форматами.
//Решил по проще.
//try(BufferedReader reader=new BufferedReader(new FileReader(args[0]))){
//	StringBuilder name=new StringBuilder();
//	while(reader.ready()){
//		String[] line=reader.readLine().split(" ");
//		for(int i=0,j=line.length-3; i<j; name.append(line[i++]).append(" "));
//		name.setLength(name.length()-1);
//		PEOPLE.add(
//			new Person(name.toString()
//				,new Date(
//					 Integer.parseInt(line[line.length-1])-1900	//год
//					,Integer.parseInt(line[line.length-2])-1	//месяц
//					,Integer.parseInt(line[line.length-3])		//день
//				)));
//		name.setLength(0);
//	}
//}catch(IOException e){}
//
//И кстати если в имени будут присутствовать числа, то все ваши регулярки с \\d полягут на дно.
//Или даже если в имени будут присутствовать сдвоенные пробелы
//
//Видима валидатор тут на easy левеле...

//SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
//while (reader.ready()) {

//    String line = reader.readLine();
//    name = line.replaceAll("\\d", "").trim();
//    date = line.replace(name, "").trim();
//    PEOPLE.add(new Person(name, sdf.parse(date))); }

//PEOPLE.add(new Person(stringBuilder.toString(), new Date(year - 1900, month - 1, date)));
//
//
//Эта строчка прекрасна блин! Здесь прекрасно все!

//Проверяйте добавляемое имя на длину символов. Если в конце имени будет лишний пробел - проверку не пройдет.
//
//В конструкторе даты (год считая от 1900, месяц считая от 0, день ).
//Находим год, месяц, день. В конструкторе от года отнимаем 1900, от номера месяца отнимаем 1.
//
//Короткое решение
//String s = bufferedReader.readLine();
//String name = s.split("\\d")[0];
//String birthday = s.split(name)[1];
//name = name.split("\\s$")[0];

//собрал все строки из файла в промежуточный ArrayList<String>, а потом вот:
//Pattern p = Pattern.compile("(\\D+) (\\d+ \\d+ \\d+)"); // две группы: имя(1) и дата(2)
//        for (int i = 0; i < peoples.size(); i++) {
//            Matcher m = p.matcher(peoples.get(i)); // прогоняем каждую строку матчером
//            while (m.find()) {
//                SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
//                PEOPLE.add(new Person(m.group(1).toString(), sdf.parse(m.group(2).toString())));
//            }
//        }
//наверное можно было и без промежуточного списка, сразу внутри цикла чтения while, но неохота,
// и так строчки длинные..

//SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
//while (reader.ready()) {
//    String line = reader.readLine();
//    name = line.replaceAll("\\d", "").trim();
//    date = line.replace(name, "").trim();
//    PEOPLE.add(new Person(name, sdf.parse(date))); }