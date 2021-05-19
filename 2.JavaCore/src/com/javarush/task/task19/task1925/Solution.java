package com.javarush.task.task19.task1925;

/* 
Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.

Пример выходных данных в файл2:
длинное,короткое,аббревиатура

Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать через запятую во второй файл все слова из первого файла длина которых
строго больше 6(используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
      //  BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        //BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
     //   FileWriter fileWriter = new FileWriter(args[1]);
    //    StringBuilder sb = new StringBuilder();
      //  String line;
       // while ((line = reader.readLine()) != null){
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null){
            String[] str = line.split(" ");
            for (String s : str) {
                if (s.length() > 6)
                    sb.append(s).append(",");
             //   sb.append(s).append(",");
            }
            String res = sb.toString();
                    writer.write(res.length() -1);
            }
        reader.close();
        writer.close();



//        while (reader.ready()){
//            String data = reader.readLine();
            //data = data.replaceAll("\\W","");
//            String[] str = data.split(" ");
//            reader.close();
//            for (String s : str){
//                if (s.length() > 6){
//                    sb.append(s).append(",");
//                }
//            }
        //    writer.write(stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()).toString());
//        }
//        String line = sb.toString();
//        line = line.substring(0, line.length() - 1);
//        fileWriter.write(line);
//        fileWriter.close();

    }

}
//StringBuilder sb = new StringBuilder();
//        while (reader.ready()) {
//            String data = reader.readLine();
//            String[] lines = data.split(" ");
//            for (String s : lines) {
//                if (s.length() > 6) { // добавляем в строку только слова с кол-вом символов >6
//                    sb.append(s).append(",");
//                }
//            }
//        }
//        String line = sb.toString();
//        line = line.substring(0, line.length() - 1); // убираем запятую на конце
//        writer.write(line);

//Зачем тут выдумывать сложные регулярки? Весь код:
//try ( BufferedReader brf = new BufferedReader( new FileReader( args[0] ) );
//      BufferedWriter bwf = new BufferedWriter( new FileWriter( args[1] ) ) ) {
//    String tmp = brf.lines()
//            .flatMap( s -> Arrays.stream( s.split(" ") ) )
//            .filter( s -> s.length() > 6 )
//            .collect(Collectors.joining(","));
//    bwf.write(tmp);
//}