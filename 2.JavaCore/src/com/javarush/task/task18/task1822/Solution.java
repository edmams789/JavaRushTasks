package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла

Считать с консоли имя файла.
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде,
в котором она записана в файле.
Программа запускается с одним параметром: id (int).
Закрыть потоки.

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity
где id - int.
productName - название товара, может содержать пробелы, String.
price - цена, double.
quantity - количество, int.

Информация по каждому товару хранится в отдельной строке.

Требования:
1. Программа должна считать имя файла с консоли.
2. Создай для файла поток для чтения.
3. Программа должна найти в файле и вывести информацию о id, который передается первым параметром.
4. Поток для чтения из файла должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        int id = Integer.parseInt(args[0]);
        BufferedReader fileRead = new BufferedReader(new FileReader(fileName));
        String s = null;

        while((s = fileRead.readLine()) != null){
                String[] str = s.split(" ");
                if (str[0].equals(String.valueOf(id))){
                    System.out.println(s);
                }        }
        fileRead.close();
    }
}
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
//        String filemame = reader.readLine();
//        int id = Integer.parseInt(args[0]);
//        BufferedReader fread = new BufferedReader(new FileReader(filemame));
//        String s =null;
//        while ((s= fread.readLine())!=null){
//            String[] str = s.split(" ");
//            if(str[0].equals(String.valueOf(id))){
//                System.out.println(s);
//            }
//        }
//        fread.close();
//
//    }
//}

//            while((line = read.readLine()) != null){
//                String[] numbers = line.split(" ");
//
//                for(String num : numbers)
//                {
//                    try {
//                        int a = Math.round(Float.parseFloat(String.valueOf(num)));
//                        writer.write(a + " ");
//                    } catch (NumberFormatException e) {
//                        System.out.println(e);
//                    }}}}
//        catch (IOException e){
//            System.err.println(e);
//        }
//            fileInputStream.close();
//            fileOutputStream.close();
//            }
//    }