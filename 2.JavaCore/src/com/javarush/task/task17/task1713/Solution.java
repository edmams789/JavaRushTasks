package com.javarush.task.task17.task1713;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/* 
Общий список

1. Изменить класс Solution так, чтобы он стал списком. (Необходимо реализовать интерфейс java.util.List).
2. Список Solution должен работать только с целыми числами Long.
3. Воспользуйтесь полем original.
4. Список будет использоваться нитями, поэтому позаботьтесь, чтобы все методы были синхронизированы.


Требования:
1. Класс Solution должен реализовывать интерфейс List<Long>.
2. Класс Solution должен содержать private поле original типа ArrayList<Long>.
3. Все переопределенные методы интерфейса List должны делегировать полномочия методам объекта original.
4. Все методы класса Solution, кроме метода main, должны быть синхронизированы.
*/

public class Solution implements List<Long> {
    public synchronized void trimToSize() {
        original.trimToSize();
    }

    public synchronized void ensureCapacity(int minCapacity) {
        original.ensureCapacity(minCapacity);
    }

    public synchronized int size() {
        return original.size();
    }

    public synchronized boolean isEmpty() {
        return original.isEmpty();
    }

    public synchronized boolean contains(Object o) {
        return original.contains(o);
    }

    public synchronized int indexOf(Object o) {
        return original.indexOf(o);
    }

    public synchronized int lastIndexOf(Object o) {
        return original.lastIndexOf(o);
    }

    public synchronized Object[] toArray() {
        return original.toArray();
    }

    public synchronized <T> T[] toArray(T[] a) {
        return original.toArray(a);
    }

    public synchronized Long get(int index) {
        return original.get(index);
    }

    public synchronized Long set(int index, Long element) {
        return original.set(index, element);
    }

    public synchronized boolean add(Long aLong) {
        return original.add(aLong);
    }

    public synchronized void add(int index, Long element) {
        original.add(index, element);
    }

    public synchronized Long remove(int index) {
        return original.remove(index);
    }

    public synchronized boolean remove(Object o) {
        return original.remove(o);
    }

    public synchronized void clear() {
        original.clear();
    }

    public synchronized boolean addAll(Collection<? extends Long> c) {
        return original.addAll(c);
    }

    public synchronized boolean addAll(int index, Collection<? extends Long> c) {
        return original.addAll(index, c);
    }

    public synchronized boolean removeAll(Collection<?> c) {
        return original.removeAll(c);
    }

    public synchronized boolean retainAll(Collection<?> c) {
        return original.retainAll(c);
    }

    public synchronized ListIterator<Long> listIterator(int index) {
        return original.listIterator(index);
    }

    public synchronized ListIterator<Long> listIterator() {
        return original.listIterator();
    }

    public synchronized Iterator<Long> iterator() {
        return original.iterator();
    }

    public synchronized List<Long> subList(int fromIndex, int toIndex) {
        return original.subList(fromIndex, toIndex);
    }

    public synchronized void forEach(Consumer<? super Long> action) {
        original.forEach(action);
    }

    public synchronized Spliterator<Long> spliterator() {
        return original.spliterator();
    }

    public synchronized boolean removeIf(Predicate<? super Long> filter) {
        return original.removeIf(filter);
    }

    public synchronized void replaceAll(UnaryOperator<Long> operator) {
        original.replaceAll(operator);
    }

    public synchronized void sort(Comparator<? super Long> c) {
        original.sort(c);
    }

    public synchronized boolean containsAll(Collection<?> c) {
        return original.containsAll(c);
    }

    public synchronized Stream<Long> stream() {
        return original.stream();
    }

    public synchronized Stream<Long> parallelStream() {
        return original.parallelStream();
    }

    private ArrayList<Long> original = new ArrayList<Long>();

    public static void main(String[] args) {

    }
}
//Но там ниже ребята писали это и решение действительно в 3 действия:
//1)Alt+Insert - делегировать;
//2)Ctrl+R - заменить "public" на "public synchronized"
//3)Поправить лишнюю замену