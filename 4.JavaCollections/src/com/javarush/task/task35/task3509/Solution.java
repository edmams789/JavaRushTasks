package com.javarush.task.task35.task3509;

import java.util.*;
/* 
Collections & Generics
Реализуй вспомогательныe методы в классе Solution, которые должны создавать соответствующую коллекцию
и помещать туда переданные объекты.
Методы newArrayList, newHashSet параметризируй типом T.
Метод newHashMap параметризируй типами К(ключ) и V(значение). Аргументы метода newHashMap
должны принимать списки, в которых содержатся наследники типов K и V.
Возвращаемые коллекции должны быть такого же типа, что и переданные в метод объекты.

Подсказка: в методе newHashMap нужно проверить чтобы списки ключей и значений совпадали по размерам,
в противном случае кинь IllegalArgumentException.

Требования:
1. Метод newArrayList должен быть параметризован типом Т.
2. Метод newArrayList должен возвращать ArrayList, который содержит переданные в метод объекты.
3. Метод newHashSet должен быть параметризован типом Т.
4. Метод newHashSet должен возвращать HashSet, который содержит переданные в метод объекты.
5. Метод newHashMap должен быть параметризован типом K и V.
6. Метод newHashMap должен возвращать HashMap, который содержит переданные в метод ключи и значения.
7. Метод newHashMap должен кидать IllegalArgumentException, если списки ключей и значений не совпадают по размеру.
*/
public class Solution {

    public static void main(String[] args) {
   //     HashMap<Object, Number> map =newHashMap(newArrayList("first", "second"), newArrayList(1,2));
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        //напишите тут ваш код
        return new ArrayList<T>(Arrays.asList(elements));
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        //напишите тут ваш код
        return new HashSet<T>(Arrays.asList(elements));
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        //напишите тут ваш код
//в методе newHashMap нужно проверить чтобы списки ключей и значений совпадали по размерам,
//в противном случае кинь IllegalArgumentException.
        if (keys.size() != values.size()) {
               throw new IllegalArgumentException();
        }
//Метод newHashMap должен возвращать HashMap, который содержит переданные в метод ключи и значения.
      //  return new HashMap<K, V> ();
//    return new HashMap<K, V> (Arrays.asList(keys).size(), Arrays.asList(values).size());
        HashMap<K, V> result = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            result.put(keys.get(i), values.get(i));
        }
        return result;

    }
}
//
/*
Для тех кто как я изначально не понял зачем нужна конструкция:
public static <T> ArrayList<T> newArrayList(T... elements)

и почему нельзя использовать
public static <T> ArrayList newArrayList(T... elements)

Отвечаю:
Если использовать второй вариант, то будет возможен такой код:
ArrayList<String> list = newArrayList(1, 3, 4);

Компилятор ничего не скажет и программа будет выполняться,
хотя мы положили в коллекцию ArrayList<String> коллекцию с элементами другого типа (Integer)
Но как только вы попытаетесь что-то сделать с элементами листа
Например:
for (int i=0; i < list.size(); i++)
{
    System.out.println(list.get(i).getClass().getTypeName());
}

Программа выдаст исключение:
java.lang.Integer cannot be cast to java.lang.String

Поэтому используя первый вариант мы исключаем ошибки еще на компиляции.
 */

/*
- А здесь почему обязательно нужно newHashMap(List<? extends K> keys, List<? extends V> values) ?
Почему не проходит просто newHashMap(List<K> keys, List<V> values) ?

Ведь в отличие от примера в лекции, мы параметризуем конкретными типами.
Непонятно!

- Потому что в задании сказано "принимать списки, в которых содержатся наследники типов K и V."
 */

/*
Обратите внимание что можно решить и без использования for each например:
HashSet<T> result = new HashSet<>(Arrays.asList(elements));

return new HashSet<>(Arrays.asList(elements));
 */