package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/* 
Самые частые байты

Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.

Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с максимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
//1. Программа должна считывать имя файла с консоли.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//2. Для чтения из файла используй поток FileInputStream.
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        long[] arrayBytes = new long[256];
    //    ArrayList<Integer> data = new ArrayList<>();
        while (inputStream.available() > 0) arrayBytes[inputStream.read()]++;

        long maxRepeat = 0;
        for (int i = 0; i < arrayBytes.length; i++) {
            if (arrayBytes[i]>maxRepeat) maxRepeat = arrayBytes[i];
        }
//3. В консоль через пробел должны выводиться все байты из файла с максимальным количеством повторов.
        for (int i = 0; i < arrayBytes.length; i++) {
            if (arrayBytes[i] == maxRepeat)
//4. Данные в консоль должны выводится в одну строку.
                System.out.print(i + " ");
        }
//5. Поток чтения из файла должен быть закрыт.
        inputStream.close();
    }
}
//Можно без коллекций , с использованием только одного массива long[256].
// Ссылка про побайтовое чтение из файла:
// https://javarush.ru/groups/posts/1468-pobaytovaja-rabota-s-faylami
//
//В кратце: создаем массив long с длиной 256 (т.к. все байты у нас будут возвращены методом read
// в диапазоне 0-255). По умолчанию все элементы массива будут равны 0.
// Далее считываем байты из файла и для ячейки под номером соответсвующим возвращенному методом read
// значению, увеличиваем лежащее там число на 1:
//while (fis.available()>0) array[fis.read()]++;
//
//В итоге получаем массив где значение каждого элемента соответствует числу повторений байта равного
// порядковому номеру этого элемента.
//ну а дальше находим максимальное количество повторений и выводим номера элементов значение которых
// ему соответсвует:
//
//long maxRepeat = 0;
//        for (int i = 0; i <array.length  ; i++) {
//            if (array[i]>maxRepeat) maxRepeat = array[i];
//        }
//        for (int i = 0; i <array.length ; i++) {
//            if (array[i]==maxRepeat) System.out.print(i + " ");
//        }
//
//Все, использовали один массив и два if. Абсолютно подручные средства.

//Решила так:
//1. Сначала все считанные байты заносим в ArrayList;
//2. Затем создаем HashMap, куда заносим в ключи список из ArrayList,
// а в значения количество повторов (Collections.frequency);
//3. Находим максимальное значение;
//4. Пробегаем по значениям мапы, если значение равно максимальному значению,
// то System.out.print(ключ + " ");

//{
//int i = inputStream.read();
//data.add(inputStream.read());
//    data.add(i);
//}
//HashMap<Integer, Integer> map = new HashMap<>();
//map.put()