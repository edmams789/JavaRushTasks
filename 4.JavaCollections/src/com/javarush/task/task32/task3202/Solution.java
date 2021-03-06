package com.javarush.task.task32.task3202;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/* 
Читаем из потока
Реализуй логику метода getAllDataFromInputStream. Он должен вернуть StringWriter, содержащий все данные
из переданного потока.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.

Требования:
1. Публичный статический метод getAllDataFromInputStream (InputStream) должен существовать.
2. Метод getAllDataFromInputStream (InputStream) должен возвращать StringWriter.
3. Метод getAllDataFromInputStream (InputStream) должен вернуть StringWriter, который содержит все
данные из переданного потока.
4. Возвращаемый объект ни при каких условиях не должен быть null.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }
//Публичный статический метод getAllDataFromInputStream (InputStream) должен существовать.
    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();

        try {
            while (is.available() > 0) {
                byte[] buf = new byte[1024];
                int len = is.read(buf);
                String s = new String(buf, 0, len);
                writer.append(s);
            }
        } catch (Exception e) {
            return new StringWriter();
        }

        return writer;
    }
}
//Как преобразовать InputStream в строку в Java?
//Использование  ByteArrayOutputStream  и  inputStream.read  ( JDK) (решение с наилучшей производительностью).
//ByteArrayOutputStream result = new ByteArrayOutputStream();
//byte[] buffer = new byte[1024];
//int length;
//while ((length = inputStream.read(buffer)) != -1) {
//    result.write(buffer, 0, length);
//}
//// StandardCharsets.UTF_8.name() > JDK 7
//return result.toString("UTF-8");

//try / catch тут на фиг не нужен. Вы что, не видите в методе "throws IOException"? Создаем объект
// типа StringWriter. Если is == null - то сразу возвращаем объект типа StringWriter (он пока пустой).
// Потом пока поток is доступен - читаем из него и сразу пишем в объект типа StringWriter.
// В конце его и возвращаем.