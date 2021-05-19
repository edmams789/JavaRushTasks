package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.*;

/*
AmigoSet (6)
Открой исходники HashSet (если у тебя нет исходников джавы, то скачай их и подключи), сравни со своим кодом.
Быстро это можно сделать сравнив через буфер. Скопируй код класса HashSet в буфер.
Зайди в класс AmigoSet, далее правая кнопка мыши -> Compare with Clipboard.

Ты только что реализовал сет, аналогичный HashSet. Теперь будешь знать, как внутри устроен HashSet.
Молодец, теперь коллекции тебе не страшны!

Требования:
1. Поздравляю, ты написал собственную реализацию множества и изучил HashSet во всех деталях!
 */
//Наш класс имеет описание - class AmigoSet<E>.
//Кроме того, он расширяет AbstractSet, который описан как class AbstractSet<E> т.е. тоже имеет дженерик.
//Да еще наш класс имплементирует интерфейс Set, также с дженериком - interface Set<E>.
public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
//Создай приватную константу Object PRESENT, которую инициализируй объектом Object, это будет наша заглушка
    private static final Object PRESENT = new Object();
//Создай private transient поле HashMap<E,Object> map. Список ключей будет нашим сэтом,
//а вместо значений будем пихать в мапу заглушку PRESENT
    private transient HashMap<E,Object> map;
//Создай конструктор без параметров, в котором инициализируй поле map.
    public AmigoSet() {
        map = new HashMap<E,Object>();
    }
//Создай конструктор с одним параметром Collection<? extends E> collection.
    public AmigoSet(Collection<? extends E> collection) {
//Вычисли свою Capacity по такой формуле: максимальное из 16 и округленного в большую сторону
//значения (collection.size()/.75f)
        int capacity = Math.max(16, (int)(collection.size()/0.75f +1));
//Для инициализации поля map воспользуйся конструктором, в который передается Capacity.
        map = new HashMap<E,Object>(capacity);
//Добавь все элементы из collection в нашу коллекцию.
        addAll(collection);
    }
    //Метод iterator должен возвращать итератор для множества ключей (keySet()) поля map.
//"Итератор в java может быть реализован для любого объекта, внутренняя структура которого
// подразумевает перебор, при этом можно изменить сигнатуру обсуждаемых методов."
    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }
//Метод size должен возвращать то же, что и метод size поля map.
    @Override
    public int size() {
        return map.size();
    }
//Метод isEmpty должен возвращать true, если map не содержит ни одного элемента, иначе - false.
    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }
//Метод remove должен удалять из map полученный в качестве параметра элемент.
    @Override
    public boolean remove(Object o) {
        return PRESENT == map.remove(o);
    }
//Метод clear должен вызывать метод clear объекта map.
    @Override
    public void clear() {
        map.clear();
    }
//Метод add должен добавлять новый элемент в map используя полученный параметр в качестве ключа и
//объект PRESENT в качестве значения.
    @Override
    public boolean add(E e) {
//Метод add должен возвращать true в случае, если новый элемент был успешно добавлен, иначе - false
        return null == map.put(e, PRESENT);
    }
//Метод contains должен возвращать true, если map содержит анализируемый элемент, иначе - false.
//    @Override
//    public boolean containsAll(Collection<?> collection) {
//        return map.containsKey(collection);
//    }
//Напиши свою реализацию метода Object clone(), сделай поверхностное клонирование.
//В классе AmigoSet метод clone должен иметь уровень доступа public.
    @Override
    public Object clone() throws CloneNotSupportedException {
    try {
        AmigoSet copy = (AmigoSet) super.clone();
        copy.map = (HashMap) map.clone();
        return copy;
    } catch (Exception e) {
//В случае возникновения исключений в процессе клонирования должно быть брошено исключение InternalError.
        throw new InternalError(e);
    }
    }
//В классе AmigoSet должен содержаться private метод writeObject с одним параметром типа ObjectOutputStream.
    private void writeObject(ObjectOutputStream out) throws IOException {
//В методе writeObject должен быть вызван метод defaultWriteObject на объекте типа ObjectOutputStream
//полученном в качестве параметра.
        out.defaultWriteObject();
//Для сериализации:
//* сериализуй capacity и loadFactor у объекта map, они понадобятся для десериализации.
//Т.к. эти данные ограничены пакетом, то воспользуйся утилитным классом HashMapReflectionHelper, чтобы достать их.
        out.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        out.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        out.writeInt(map.keySet().size());
//Для сериализации:
//* сериализуй сет
        for (E e : map.keySet()) {
            out.writeObject(e);
        }
    }
//В классе AmigoSet должен содержаться private метод readObject с одним параметром типа ObjectInputStream.
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//В методе readObject должен быть вызван метод defaultReadObject на объекте типа ObjectInputStream
//полученном в качестве параметра.
        in.defaultReadObject();
//Для десериализации:
//* вычитай все данные
        int capacity = in.readInt();
        float loadFactor = in.readFloat();
        int size = in.readInt();
//Для десериализации:
//* создай мапу используя конструктор с capacity и loadFactor
        map = new HashMap<>(capacity, loadFactor);
        for (int i = 0; i < size; i++) {
            map.put((E) in.readObject(), PRESENT);
        }
    }
}
//Все это время мы просто реализовывали оригинальный HashSet.
// Он реально просто использует HashMap с заглушкой... Моя жизнь никогда не станет прежней.

/*
1) в методе сериализации при записи размера вы используете map.keySet().size():
out.writeInt(map.keySet().size());
2) в методе десериализации в текущую ссылку map кладем новую мапу:
map = new HashMap<>(capacity, loadFactor);
 */

/*
Testing code
public static void main(String[] args) throws IOException, ClassNotFoundException {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("ddd");
        hashSet.add("rrrr");
        AmigoSet amigoSet = new AmigoSet(hashSet);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(amigoSet);
        objectOutputStream.close();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        AmigoSet amigoSet1 = (AmigoSet)  objectInputStream.readObject();
        System.out.println(amigoSet.equals(amigoSet1));
        System.out.println(amigoSet);
        System.out.println("________");
        System.out.println(amigoSet1);
    }
 */