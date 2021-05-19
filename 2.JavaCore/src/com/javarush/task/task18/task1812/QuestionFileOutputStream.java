package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream

Используя шаблон проектирования Wrapper (Decorator) расширь функциональность AmigoOutputStream.
В классе QuestionFileOutputStream при вызове метода close() должна быть реализована следующая
функциональность:
1. Вывести в консоль фразу "Вы действительно хотите закрыть поток? Д/Н".
2. Считайте строку.
3. Если считанная строка равна "Д", то закрыть поток.
4. Если считанная строка не равна "Д", то не закрывать поток.

Требования:
1. Интерфейс AmigoOutputStream изменять нельзя.
2. Класс QuestionFileOutputStream должен реализовывать интерфейс AmigoOutputStream.
3. Класс QuestionFileOutputStream должен инициализировать в конструкторе поле типа AmigoOutputStream.
4. Все методы QuestionFileOutputStream должны делегировать свое выполнение объекту AmigoOutputStream.
5. Метод close() должен спрашивать у пользователя "Вы действительно хотите закрыть поток? Д/Н".
6. Метод close() должен закрывать поток только в случае, если считает с консоли ответ "Д".
*/

//2. Класс QuestionFileOutputStream должен реализовывать интерфейс AmigoOutputStream.
public class QuestionFileOutputStream implements AmigoOutputStream {

    private AmigoOutputStream original;

    public QuestionFileOutputStream(AmigoOutputStream original) {
        this.original = original;
    }

    @Override
    public void flush() throws IOException {
        original.flush();
    }

    @Override
    public void write(int b) throws IOException {
        original.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        original.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        original.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        if ("Д".equals(new BufferedReader(new InputStreamReader(System.in)).readLine()))

        original.close();
    }

    public static void main(String[] args) {

      //  AmigoOutputStream amigoOutputStream = new QuestionFileOutputStream();


       // QuestionFileOutputStream outputStream = new QuestionFileOutputStream();

    }
}
//public class QuestionFileOutputStream implements AmigoOutputStream {
//
//    private AmigoOutputStream original;
//
//    public QuestionFileOutputStream(AmigoOutputStream original) {
//        this.original = original;
//    }
//
//    @Override
//    public void flush() throws IOException {
//        original.flush();
//    }
//
//    @Override
//    public void write(int b) throws IOException {
//        original.write(b);
//    }
//
//    @Override
//    public void write(byte[] b) throws IOException {
//        original.write(b);
//    }
//
//    @Override
//    public void write(byte[] b, int off, int len) throws IOException {
//        original.write(b, off, len);
//    }
//
//    @Override
//    public void close() throws IOException {
//        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
//        if ("Д".equals(new BufferedReader(new InputStreamReader(System.in)).readLine()))
//
//        original.close();
//    }
//
//    public static void main(String[] args) {
//        AmigoOutputStream amigoOutputStream = new QuestionFileOutputStream()
//
//
//       // QuestionFileOutputStream outputStream = new QuestionFileOutputStream();
//
//    }
//}

//"Д".equals(reader.readLine())

//создаем приватную переменную AmigoOutputStream потом альт + инсерт  конструктор, еще раз альт + инсерт
// делегировать методы , и потом в методе клосе пишем  то что требуется в условии

//дабожемой, не надо переусложнять, начиная с Java 7 когда switch научили работать со String,
// в подобных случаях или при реазлизации всяких СRUD, просто делаете:
//swich(reader.readline()){
//         case "Н": return;
//         case "Д": component.close()
//}

////3. Класс QuestionFileOutputStream должен инициализировать в конструкторе поле типа AmigoOutputStream.
//    public QuestionFileOutputStream(AmigoOutputStream amigoOutputStream) {
//        this.original = amigoOutputStream;
//    }
//
//   // public QuestionFileOutputStream() {
//
// //   }
//
////Подскажите, пожалуйста, почему методы в QuestionFileOutputStream обязательно должны быть public?
//
////"Все методы и переменные интерфейса неявно объявляются как public."
////
////Так что все методы interface AmigoOutputStream являются public, но писать это в интерфейсе не нужно.
//// А когда уже class QuestionFileOutputStream реализует AmigoOutputStream то надо каждому методу явно
//// прописать public.
//    @Override
//    public void flush() throws IOException {original.flush();}
//    @Override
//    public void write(int b) throws IOException {original.write(b);}
//    @Override
//    public void write(byte[] b) throws IOException {original.write(b);}
//    @Override
//    public void write(byte[] b, int off, int len) throws IOException {original.write(b, off, len);}
//    @Override
//    public void close() throws IOException {
//
//        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
//  //      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//  //           if ("Д".equals(System.in.read());
//        if ("Д".equals(new BufferedReader(new InputStreamReader(System.in)).readLine()))
//
//            original.close();
//
//    }
//
//    public static void main(String[] args) {
//    AmigoOutputStream amigoOutputStream = new QuestionFileOutputStream(AmigoOutputStream original);