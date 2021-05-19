package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(5)
Добавлять в дерево элементы мы можем, теперь займись удалением:

Необходимо реализовать метод remove(Object o), который будет удалять элемент дерева имя которого было полученного в качестве параметра.

Если переданный объект не является строкой, метод должен бросить UnsupportedOperationException.

Если в дереве присутствует несколько элементов с переданным именем - можешь удалить только первый найденный.

Не забывай сверять поведение своего дерева с картинкой:


Что будет если удалить из дерева элементы "3", "4", "5" и "6", а затем попытаемся добавить новый елемент?

В таком случае элементы "1" и "2" должны восстановить возможность иметь потомков (возможно придется внести изменения в метод add()).

Требования:
1. После удаления последнего добавленного элемента из дерева с помощью метода remove, метод size должен возвращать N-1.
2. После удаления второго элемента добавленного в дерево, метод size должен возвращать N/2 + 1 (для случаев где N > 2 и является степенью двойки), N - размер дерева до удаления.
3. Если переданный объект не является строкой, метод remove() должен бросить UnsupportedOperationException.
4. Если ни один элемент не способен иметь потомков, необходимо восстановить такую возможность.
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
//Любое дерево начинается с корня, поэтому не забудь в класс CustomTree добавить
//поле root типа Entry<String> c модификатором доступа по умолчанию.
//В классе CustomTree должно существовать поле root типа Entry.
    Entry<String> root;
    private int size;

//Инициируй его в конструкторе CustomTree, имя (elementName) не важно.
    public CustomTree() {
        root = new Entry<>("elementName");
        root.parent = null;
        root.leftChild = null;
        root.rightChild = null;
        size = 0;
    }

        //  void checkChildren(){}

//реализовать метод getParent(String s) - возвращает имя родителя элемента дерева,
//имя которого было полученного в качестве параметра.
//Метод getParent должен возвращать имя родителя для любого элемента дерева.
//    public String getParent(String s) {
//        return null;
//    }

//Класс CustomTree.Entry должен быть объявлен с модификатором доступа по умолчанию.
//Класс CustomTree.Entry должен поддерживать интерфейс Serializable.
        static class Entry<T> implements Serializable {
//В классе CustomTree.Entry должно существовать поле elementName типа String.
            String elementName;
//В классе CustomTree.Entry должно существовать поле availableToAddLeftChildren типа boolean.
//В классе CustomTree.Entry должно существовать поле availableToAddRightChildren типа boolean.
            boolean availableToAddLeftChildren, availableToAddRightChildren;
//В классе CustomTree.Entry должно существовать поле parent типа Entry.
//В классе CustomTree.Entry должно существовать поле leftChild типа Entry.
//В классе CustomTree.Entry должно существовать поле rightChild типа Entry.
            Entry<T> parent, leftChild, rightChild;

//В классе CustomTree.Entry должен быть корректно реализован конструктор с одним параметром типа String (смотри условие).
            public Entry(String elementName) {
                this.elementName = elementName;
                availableToAddLeftChildren = true;
                availableToAddRightChildren = true;
            }

//В классе CustomTree.Entry должен корректно реализован метод isAvailableToAddChildren (смотри условие).
//Реализуй публичный метод boolean isAvailableToAddChildren, возвращающий дизъюнкцию полей
// availableToAddLeftChildren и availableToAddRightChildren.
            public boolean isAvailableToAddChildren() {
                return availableToAddLeftChildren || availableToAddRightChildren;
            }

        }

//Если необходимо, можешь вводить дополнительные методы и поля, не указанные в задании.
//1. При попытке вызвать метод get(int index) должно возникать исключение типа UnsupportedOperationException.
        @Override
        public String get ( int index){
        throw new UnsupportedOperationException();
    }
//переопределить метод size() - возвращает текущее количество элементов в дереве.
        @Override
        public int size () {
        return size;
    }
//2. При попытке вызвать метод set(int index, String element) должно возникать исключение типа UnsupportedOperationException.
        @Override
        public String set ( int index, String element){
        throw new UnsupportedOperationException();
    }
//3. При попытке вызвать метод add(int index, String element) должно возникать исключение типа UnsupportedOperationException.
        @Override
        public void add ( int index, String element){
        throw new UnsupportedOperationException();
    }
//4. При попытке вызвать метод String remove(int index) должно возникать исключение типа UnsupportedOperationException.
        @Override
        public String remove ( int index){
        throw new UnsupportedOperationException();
    }
//5. При попытке вызвать метод subList(int fromIndex, int toIndex) должно возникать исключение типа UnsupportedOperationException.
        @Override
        public List<String> subList ( int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }
//6. При попытке вызвать метод removeRange(int fromIndex, int toIndex) должно возникать исключение типа UnsupportedOperationException.
        @Override
        protected void removeRange ( int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }
//7. При попытке вызвать метод addAll(int index, Collection<? extends String> c) должно возникать исключение типа UnsupportedOperationException.
        @Override
        public boolean addAll ( int index, Collection<? extends String > c){
        throw new UnsupportedOperationException();
    }
        @Override
        public boolean add (String s){
        boolean result = false;
        Queue<Entry<String>> queue = new ArrayDeque<>();
        queue.add(root);
        Entry<String> node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.rightChild == null) {
                node.availableToAddRightChildren = true;
            }
            if (node.leftChild == null) {
                node.availableToAddLeftChildren = true;
            }
            if (node.isAvailableToAddChildren()) {
                if (node.parent == null) {
                    node.parent = node;
                }
                if (node.availableToAddLeftChildren) {
                    node.leftChild = new Entry<>(s);
                    node.leftChild.parent = node;
                    node.availableToAddLeftChildren = false;
                    result = true;
                    break;
                }
                if (node.availableToAddRightChildren) {
                    node.rightChild = new Entry<>(s);
                    node.rightChild.parent = node;
                    node.availableToAddRightChildren = false;
                    result = true;
                    break;
                }
            } else {
                queue.add(node.leftChild);
                queue.add(node.rightChild);
            }
        }
        size++;
        return result;
    }

        public String getParent (String s){
        Entry<String> parent = getEntryParent(s);
        return parent != null ? parent.elementName : null;
    }

        private Entry<String> getEntryParent (String s){
        Queue<Entry<String>> queue = new ArrayDeque<>();
        queue.add(root);
        Entry<String> node;
        Entry<String> parent = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.elementName.equalsIgnoreCase(s)) {
                parent = node.parent;
                break;
            } else {
                if (node.leftChild != null) {
                    queue.add(node.leftChild);
                }
                if (node.rightChild != null) {
                    queue.add(node.rightChild);
                }
            }
        }
      //  return parent != null ? parent.elementName : null;
        return parent;
    }

        public boolean remove (Object o){
        if (!(o instanceof String)) {
            throw new UnsupportedOperationException();
        }
        boolean isModify = false;
        String str = (String) o;
        Entry<String> parent = getEntryParent(str);
        ArrayDeque<Entry<String>> queueA = new ArrayDeque<>();
        ArrayDeque<Entry<String>> queueB = new ArrayDeque<>();
        int count = 0;
        if (parent.rightChild != null && parent.rightChild.elementName.equalsIgnoreCase(str)) {
            queueA.add(parent.rightChild);
            queueB.add(parent.rightChild);
        }
        if (parent.leftChild != null && parent.leftChild.elementName.equalsIgnoreCase(str)) {
            queueA.add(parent.leftChild);
            queueB.add(parent.leftChild);
        }
        Entry<String> node;
        while (!queueA.isEmpty()) {
            node = queueA.poll();
            if (node.leftChild != null) {
                queueA.add(node.leftChild);
                queueB.add(node.leftChild);
            }
            if (node.rightChild != null) {
                queueA.add(node.rightChild);
                queueB.add(node.rightChild);
            }
        }
        count = queueB.size();
        while (!queueB.isEmpty()) {
            node = queueB.pollLast();
            if (node != null) {
                node.parent = null;
                node.leftChild = null;
                node.rightChild = null;
            }
        }
        if (parent.rightChild != null && parent.rightChild.elementName.equalsIgnoreCase(str)) {
            parent.rightChild = null;
            isModify = true;
        }
        if (parent.leftChild != null && parent.leftChild.elementName.equalsIgnoreCase(str)) {
            parent.leftChild = null;
            isModify = true;
        }
        size -= count;
        return isModify;
    }

    }

//https://habr.com/ru/post/144850/