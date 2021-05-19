package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Самые редкие байты

Ввести с консоли имя файла.
Найти байт или байты с минимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.

Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с минимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        long[] arrayBytes = new long[256];

        while (inputStream.available() > 0) arrayBytes[inputStream.read()]++;
        inputStream.close();

        for (int i = 0; i < 256; i++) {
            if (arrayBytes[i] == 1)
                System.out.print(i + " ");
        }
    }
}
//FileInputStream inputStream=new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
//long[] arr=new long[256];
//while(inputStream.available()>0)
//    arr[inputStream.read()]++;
//inputStream.close();
//for(int i=0;i<256;i++)
//    if(arr[i]==1)
//        System.out.print(i+" ");

//Пробовал решать задачу разными изученными методами (функциональное программирование не из их числа),
// пришёл к выводу, что лучшей структурой данных для подобного типа задач является словарь т.е. Map.
//Только он позволяет заполнить себя буквально в 2 строки:
//while (fis.available() > 0) {
//            input = fis.read();
//            map.put(input, map.getOrDefault(input, 0) + 1);
//}
//
//Учитывая, что в данной конкретной задаче в качестве ключей используются целые числа в пределах 1 байта,
// хорошо работает хак с массивом типа int[256] (см. в комментах ниже). Но это решение не универсальное.

//ufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        FileInputStream fis = new FileInputStream(reader.readLine());
//        Map<Integer, Integer> map = new HashMap<>();
//        try{
//            while (fis.available() > 0) {
//                map.merge(fis.read(),1,Integer::sum); //сразу добавляем в map и увеличиваем счетчик
//            }
//            map.forEach((integer, integer2) -> {
//                if (integer2 == Collections.min(map.values())) System.out.print(integer + " ");
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            fis.close();
//        }

//Найти байт или байты с минимальным количеством повторов -
//
//- оказывается это если встретил байт один раз (я сначала искал все повторяющиеся,
// а из них уже те, которые повторяются меньше всех).
//Понял, прочитав комментарии и решил не через For циклы как предыдущую, а HashMap.
//
//{
//        BufferedReader Fae = new BufferedReader(new InputStreamReader(System.in));
//        String FileName = Fae.readLine();
//        Fae.close();
//        Map<Byte, Integer> Dat = new HashMap<>();
//        ArrayList<Byte> list=new ArrayList<>();
//
//        //String FileName = "E:/result.txt";
//        FileInputStream inputStream = new FileInputStream(FileName);
//        while (inputStream.available() > 0) //пока остались непрочитанные байты
//        {
//            list.add((byte)inputStream.read()); //прочитать очередной байт и записать в list
//        }
//        inputStream.close(); // закрываем поток
//        int count;
//        for (int i = 0; i < list.size(); i++) {
//            count = Collections.frequency(list, list.get(i));
//            Dat.put(list.get(i),count);
//        }
//
//            int min = Collections.min(Dat.values());
//            for (Map.Entry<Byte,Integer> pair: Dat.entrySet()) {
//                if(pair.getValue() == min)
//                    System.out.print(pair.getKey() + " ");
//            }
//        }