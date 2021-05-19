package com.javarush.task.task19.task1915;

/* 
Дублируем текст

Считай с консоли имя файла.
В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна выводить весь текст и на консоль и в файл, имя которого ты считал.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.
Закрой поток файла.

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing

Требования:
1. Класс Solution должен содержать класс TestString.
2. Класс Solution должен содержать публичное статическое поле testString типа TestString, которое сразу проинициализировано.
3. Класс TestString должен содержать публичный void метод printSomething().
4. Метод printSomething() класса TestString должен выводить на экран строку "it's a text for testing".
5. В методе main(String[] args) программа должна считывать имена файлов с консоли
(используй BufferedReader).
6. В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
7. Метод main(String[] args) класса Solution должен создавать поток PrintStream (используй PrintStream
c конструктором принимающим ByteArrayOutputStream).
8. Метод main(String[] args) класса Solution должен подменять и восстанавливать поток вывода в консоль
объекта System.out.
9. Метод main(String[] args) класса Solution должен один раз вызвать метод printSomething() объекта
testString.
10. Метод main(String[] args) класса Solution должен выводить и в консоль и в файл строку выведенную
методом printSomething() (используй FileOutputStream).
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileTwo = reader.readLine();
        reader.close();
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = byteArrayOutputStream.toString();
        System.setOut(consoleStream);
        System.out.println(result);
        FileOutputStream fileOutputStream = new FileOutputStream(fileTwo);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
//Для записи в файл варианта два:
//fileOutputStream.write(byteArrayOutputStream.toByteArray());
//
//И
//byteArrayOutputStream.writeTo(writer);
//
//Результат одинаковый.
//
//toByteArray()
//Creates a newly allocated byte array.
//
//writeTo(OutputStream out)
//Writes the complete contents of this byte array output stream to the specified output stream argument,
// as if by calling the output stream's write method using out.write(buf, 0, count).
