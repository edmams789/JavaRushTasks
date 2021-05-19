package com.javarush.task.task18.task1821;

/* 
Встречаемость символов

Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).

Пример:
','=44, 's'=115, 't'=116.

Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.

Пример вывода:
, 19
- 7
f 361


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
4. Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
5. Поток для чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);

        byte[] symbols = new byte[fileInputStream.available()];
        fileInputStream.read(symbols);

        Arrays.sort(symbols);

        HashMap<Byte, Integer> map = new HashMap<Byte, Integer>();

        int count;


        for (byte x : symbols) {
            count = 0;

            for (byte x1 : symbols) {
                if (x == x1) {
                    count++;
                }
            }

            if (!map.containsKey(x)) {
                map.put(x, count);
                System.out.println((char) x + " " + count);
            }
        }
        fileInputStream.close();
    }
}
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
//        int c;
//        while ((c = reader.read()) != -1) {
//            int x = (char) c;
//            int z = 1;
//            for (Map.Entry<Integer, Integer> integer : map.entrySet()) {
//                if (integer.getKey() == x) {
//                    z += integer.getValue();
//                }
//            }
//            map.put(x, z);
//        }
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            System.out.println(((char) (int) entry.getKey()) + " " + entry.getValue());
//        }
//        reader.close();
//    }
//}