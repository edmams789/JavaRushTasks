package com.javarush.task.task20.task2018;

import java.io.*;

/* 
Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найди проблему и исправь ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
В сигнатуре класса В ошибки нет :).
В методе main ошибок нет.

Требования:
1. Класс B должен быть потомком класса A.
2. Класс B должен поддерживать интерфейс Serializable.
3. Класс A не должен поддерживать интерфейс Serializable.
4. Класс A не должен поддерживать интерфейс Externalizable.
5. Программа должна выполняться без ошибок.
6. При десериализации должны корректно восстанавливаться значение полей nameA и nameB.
*/
public class Solution implements Serializable {

    public static class A {

        protected String nameA = "A";
        protected A(){}
        public A(String nameA) {
            this.nameA += nameA;
        }
    }

    public class B extends A implements Serializable {

        private String nameB;

        public B(String nameA, String nameB) {
            super(nameA);
            this.nameA += nameA;
            this.nameB = nameB;
        }
        private void writeObject(ObjectOutputStream stream) throws IOException {

            stream.defaultWriteObject();
            stream.writeObject(nameA);
            stream.writeObject(nameB);

        }
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            nameA = (String) stream.readObject();
            nameB = (String) stream.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        Solution solution = new Solution();
        B b = solution.new B("B2", "C33");
        System.out.println("nameA: " + b.nameA + ", nameB: " + b.nameB);

        oos.writeObject(b);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);

        B b1 = (B)ois.readObject();
        System.out.println("nameA: " + b1.nameA + ", nameB: " + b1.nameB);
    }
}
//короче,
//1. Solution имплементирует Serializable
//2. В класс A добавляется пустой конструктор
//3. В класс B добавляется private void writeObject(ObjectOutputStream stream) throws IOException
// с 3-мя строками .defaultWriteObject; .writeObject(nameA); .stream.writeObject(nameB);
//4. В класс B добавляется private void readObject(ObjectInputStream stream)
// throws IOException, ClassNotFoundException с 3-мя строками соответствующими
// строками .defaultReadObject и .readObject

//private void writeObject(ObjectOutputStream oos) throws Exception{
//            oos.defaultWriteObject();
//            oos.writeObject(nameA);
//        }
//
//        private void readObject(ObjectInputStream ois) throws  Exception{
//            ois.defaultReadObject();
//            nameA = (String) ois.readObject();
//        }
//
//необходимо сериализовать Solution, и добавить эти методы, после их добавления при
// сериализации\десериализации используется не стандартный механизм, а эти методы,
// в них мы сначала вызываем defaultWriteObject()\defaultReadObject(), это как я понял
// делается как раз для стандартной сериализации, т.е если вызвать только их, то мы получим
// при сохранении: nameA: AB2B2, nameB: C33, а при восстановлении: nameA: A, nameB: C33
// потому что B сериализуемый, а A нет, поэтому nameA нужно сериализовать\десериализовать
// вручную oos.writeObject(nameA)\nameA = (String) ois.readObject(); соответственно,
// не знаю правильно ли я понял, но понял вот так
//и да, для понимания полезно прочитать Эккеля глава 18, подпункт "Альтернатива для Externalizable"