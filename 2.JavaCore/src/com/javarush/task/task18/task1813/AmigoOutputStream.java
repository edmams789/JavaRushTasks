package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream

1 Измени класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream.
Используй наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 Вызвать метод flush().
2.2 Дописать следующий текст "JavaRush © All rights reserved.", используй метод getBytes().
2.3 Закрыть поток методом close().


Требования:
1. Метод main изменять нельзя.
2. Класс AmigoOutputStream должен наследоваться от класса FileOutputStream.
3. Класс AmigoOutputStream должен принимать в конструкторе объект типа FileOutputStream.
4. Все методы write(), flush(), close() в классе AmigoOutputStream должны делегировать
свое выполнение объекту FileOutputStream.
5. Метод close() должен сначала вызвать метод flush(), затем дописать текст, затем закрыть поток.
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    FileOutputStream fileOutputStream;
//3. Класс AmigoOutputStream должен принимать в конструкторе объект типа FileOutputStream.
    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        this.fileOutputStream = fileOutputStream;
    }
//4. Все методы write(), flush(), close() в классе AmigoOutputStream должны делегировать
//свое выполнение объекту FileOutputStream.
    @Override
    public void write(int b) throws IOException{
        fileOutputStream.write(b);
    }
    @Override
    public void write(byte[] b) throws IOException{
        fileOutputStream.write(b);
    }
    @Override
    public void write(byte[] b,int off,int len) throws IOException{
        fileOutputStream.write(b,off,len);
    }
//5. Метод close() должен сначала вызвать метод flush(), затем дописать текст, затем закрыть поток.
    @Override
    public void close() throws IOException{
        fileOutputStream.flush();
        write("JavaRush © All rights reserved.".getBytes());
        fileOutputStream.close();
    }
    @Override
    public void flush() throws IOException{
        fileOutputStream.flush();
    }
    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }
}

//Никак не пойму зачем мы в конструкторе вызываем suoer(fileName).

//Затем, что мы пытаемся сделать поведение AmigoOutputStream как у FileOutputStream — для этого
// вызываем его конструктор.

//валидотор оборзевший. заставил переопределять все 3 метода write. Зато прошло
//public class AmigoOutputStream extends FileOutputStream{
//    public static String fileName = "C:/tmp/result.txt";
//    public FileOutputStream outputStream;
//
//    public AmigoOutputStream(FileOutputStream outputStream) throws FileNotFoundException {
//        super("s");
//        this.outputStream = outputStream;
//    }
//    public void close() throws IOException {
//        this.outputStream.flush();
//        String data =  "JavaRush © All rights reserved.";
//        InputStream is = new ByteArrayInputStream(data.getBytes());
//        byte[] buffer = new byte[is.available()];
//        is.read(buffer);
//        this.outputStream.write(buffer);
//        is.close();
//        outputStream.close();

//    }
//    public void flush() throws IOException {
//        outputStream.flush();
//    }
//    public void write(byte[] b) throws IOException {
//        outputStream.write(b);
//    }
//    public void write(byte[] b, int off, int len) throws IOException {
//        outputStream.write(b, off, len);
//    }
//    public void write(int b) throws IOException {
//        outputStream.write(b);
//    }
//
//
//    public static void main(String[] args) throws FileNotFoundException {
//       new AmigoOutputStream(new FileOutputStream(fileName));
//    }
//
//}

//Подскажите мне, что я неправ :(
//
//Требования 2 и 3 противоречат друг другу
//
//Судя по заданию, конструктор должен быть такой
//
//FileOutputStream fos;
//
//public AmigoOutputStream(FileOutputStream fos) throws FileNotFoundException {
//    super(fileName);
//    this.fos = fos;
//}
//
//
//Мы тут создаем два (????) FileOutputStream: один наш fos, другой родительский
//Затем родительский ("C:/tmp/result.txt") вообще не используем, т.к везде os.write(b); а не super.write(b);
//
//Имхо (еще раз - может я неправ), нужно или использовать родительский объект, если мы от него наследуемся,
// или внутренний (тогда наследование не нужно ввобще)

//Не придумывайте, при создание объекта класса, который наследуется от другого класса, вначале создается объект родитель, а лишь потом искомый объект. Были даже лекции и задачки на эту тему. Из наследника к объекту родительского класса вы можете обращаться через ссылку -> super.
//
//Поэтому Роман тут прав, это задача нелогична и требует от нас зачем-то создания двух одинаковых объектов.
//
//Правильнее было бы наследовать наш класс от базового класса FileOutputStream'а, от абстрактного OutputStream
//В таком случае задачка была бы более похоже на часть паттерна "Обертка". Тогда бы она имела вид:
//public class AmigoOutputStream extends OutputStream {
//    public static String fileName = "C:/tmp/result.txt";
//    private OutputStream wrapped;
//
//
//    public AmigoOutputStream(OutputStream stream) {
//        this.wrapped = stream;
//    }
//
//    @Override
//    public void write(int b) throws IOException {
//        wrapped.write(b);
//    }
//
//    @Override
//    public void close() throws IOException {
//        wrapped.flush();
//        String textForAdd = "JavaRush © All rights reserved.";
//        wrapped.write(textForAdd.getBytes());
//        wrapped.close();
//    }
//
//
//    public static void main(String[] args) throws FileNotFoundException {
//        new AmigoOutputStream(new FileOutputStream(fileName));
//    }
//}
//
//
//Хотя из-за этой нелогичности, во мне появилось желание разобраться с этим паттерном,
// узнать что он из себя представляет и где используется. Интересная штука, скажу я вам :)

//Опять читаем условие:
//Все методы write(), flush(), close() в классе AmigoOutputStream должны делегировать свое выполнение объекту FileOutputStream.
//
//Судя по условию, всего 3 метода, ну лично я подумал именно так. Оказалось только 3 метода write.
//
//public void write(byte[] b, int off, int len) throws IOException {
//    fileOutputStream.write(b, off, len);
//}
//public void write(byte[] b) throws IOException {
//    fileOutputStream.write(b);
//}
//public void write(int b) throws IOException {
//    fileOutputStream.write(b);
//}
//
//
//тут про getBytes - https://metanit.com/java/tutorial/6.3.php

