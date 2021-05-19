package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/*
Найти класс по описанию
Описание класса:
1. Реализует интерфейс List;
2. Является приватным статическим классом внутри популярного утилитного класса;
3. Доступ по индексу запрещен - кидается исключение IndexOutOfBoundsException.
Используя рефлекшн (метод getDeclaredClasses), верни подходящий тип в методе getExpectedClass.

Требования:
1. Метод getExpectedClass должен использовать метод getDeclaredClasses подходящего утилитного класса.
2. Метод getExpectedClass должен вернуть правильный тип.
3. Метод main должен вызывать метод getExpectedClass.
4. Метод main должен вывести полученный класс на экран.
*/
public class Solution {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() throws IllegalAccessException, InstantiationException {

        Class[] classes = Collections.class.getDeclaredClasses();
        for (Class clazz : classes){

            if (Modifier.isPrivate(clazz.getModifiers()))
                if (Modifier.isStatic(clazz.getModifiers()))
                {
                if (List.class.isAssignableFrom(clazz))
                {
                    try {
                        Constructor constructor = clazz.getDeclaredConstructor();
                        constructor.setAccessible(true);

                        List list = (List) constructor.newInstance();
                        list.get(0);
                    } catch (IndexOutOfBoundsException e){
                        // вернуть класс
                        return clazz;
                    } catch (NoSuchMethodException e){

                    } catch (InvocationTargetException e){

                    }
                }
            }
        }
        return null;
    }
}
/*
Для тех, кто, как и я не понял, что нужно делать.
Есть некий класс (спойлеры ниже) в котором есть вложенные классы – коллекции.
Один из этих вложенных классов-коллекций соответствует требованиям в задачи:
1.	Этот класс или его класс родитель имплементирует класс List
2.	Этот класс приватный и статический
3.	У этого класса есть приватный метод get(int i) который, если к нему обратиться выкидывает эксепшен
«InvocationTargetException», в тексте которого есть текст «IndexOutOfBoundsException»
Дальше спойлеры, рекомендую не читать, а попробовать решить самим.
Порядок действий (решается через reflection):
1.	Получаем (getDeclaredClasses) и обходим все классы у класса Collections
2.	Для каждого класса проверяем:
a.	Имплементирует ли этот класс или его родитель (getSuperclass) интерфейс List (getInterfaces)
b.	Является ли этот класс приватным (Modifier.isPrivate(clazz.getModifiers()))
c.	Является ли этот класс статическим (Modifier.isStatic(clazz.getModifiers()))
d.	Получаем метод get (getDeclaredMethod("get", int.class)) и устанавливаем ему доступность setAccessible(true)
e.	Получаем конструктор (getDeclaredConstructor) и устанавливаем ему доступность  setAccessible(true)
f.	Выполняем метод (invoke()) с созданным новым инстансом через конструктор (newInstance()) и любым параметром int
g.	Если отловили InvocationTargetException и в getCause() содержится "IndexOutOfBoundsException"
– это наш класс, его и возвращаем.
 */

/*
Стоит задача вывести в консоль поля объекта, их типы и значения. В принципе ничего сложного - делаю это так:
Field[] m = SomeClass.getClass().getDeclaredFields();
		for (Field met : m) {
			met.setAccessible(true);
			System.out.println(met.toString() +"  -   "+met.get(SomeClass));
		}
Но как сделать чтобы выводились и поля вложенного класса, если такой имеется?

for (Class<?> class1 : MyClass.class.getDeclaredClasses()) {
            for (Field field : class1.getDeclaredFields()) {
                System.out.println(field);
            }
        }
Google Вам в помощь
 */