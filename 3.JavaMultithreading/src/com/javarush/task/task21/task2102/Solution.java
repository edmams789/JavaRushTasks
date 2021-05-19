package com.javarush.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* 
Сравниваем модификаторы
Реализовать логику метода isModifierSet, который проверяет, содержит ли переданный
параметр allModifiers значение конкретного модификатора specificModifier.

P.S. Перед выполнением задания ознакомься с классом Modifier и реализацией методов isPublic,
isStatic и т.п.


Требования:
1. Метод isModifierSet должен быть статическим.
2. Метод isModifierSet должен возвращать значение типа boolean.
3. Метод isModifierSet должен принимать два параметра типа int.
4. Метод isModifierSet должен возвращать корректное значение в соответствии с условием задачи(true,
если заданный модификатор присутствует в allModifiers, иначе false).
*/
public class Solution {
    public static void main(String[] args) {
        int classModifiers = Solution.class.getModifiers();
        System.out.println(isModifierSet(classModifiers, Modifier.PUBLIC));   //true
        System.out.println(isModifierSet(classModifiers, Modifier.STATIC));   //false

        int methodModifiers = getMainMethod().getModifiers();
        System.out.println(isModifierSet(methodModifiers, Modifier.STATIC));      //true
    }

    public static boolean isModifierSet(int allModifiers, int specificModifier) {

        return (allModifiers & specificModifier) > 0;

       // return false;
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}
//Решение для обычных пацанов:
//return Modifier.toString(allModifiers).contains(Modifier.toString(specificModifier));
//
//Решение для технарей:
//return (allModifiers & specificModifier) == specificModifier;

//В общем, как я понял, модификаторы устанавливаются числом int (как и права доступа к файлам).
//В двоичном представлении это будет выглядеть, как нужная единичка на своём месте, типа такого:
//01000000 - у единичного модификатора и
//11100001 - у списка всех модификаторов класса-метода.
//То есть надо логическим AND (&) сравнить все модификаторы класса-метода и конкретный модификатор.
//int mod = allModifiers & specificModifier;
//
//на выходе получим цифру модификатора, если такой модификатор есть в списке всех и ноль, если нет.
//В нужном месте (где у обоих двоичных представлений стоит 1 - 01000000 и 11100001)логическое & вернет единичку, это значит, что модификатор присутствует.
//Дальше уже дело техники проверить на то, ноль у нас или больше нуля:
//return (mod > 0);
//
//Но, я ввел ещё доп. проверку на всякий случай:
//switch (mod) {
//            case Modifier.PRIVATE:  return true;
//            case Modifier.PUBLIC:  return true;
//            case Modifier.STATIC: return true;
//        }
//
//Все модификаторы я перечислять не стал, оставил только эти три - Валька и так съел.

//Мама родная, как же у вас все сложно! В предыдущей задаче(там где маска подсети) мы не зря выводили и сравнивали побитово цифры.
//01001110 &
//01000010 =
//01000010 // Здесь остаются только повторяющиеся байты.
//
//Так вот:  давайте представим, что набор нулей и единичек - это что-то типа мини-контейнера - если 0, модификатора нет, если 1 - есть.
//каждый бит отвечает за наличие опред. модификатора, например(не обязательно именно эти байты и модификаторы, это не важно):
//modifiersOfThisClass формально возвращает нам не интеджер, а закодированный в нем набор бит, отражающий  наличие(или отсутствие) всех модификаторов, которые нашлись у всех членов класса(а, modifiersOfMethod, соответственно у метода)
//01000010
//0[PUBLIC нету] 1 [STATIC есть] 0 0 0 0[PROTECTED, TRANSIENT, PRIVATE и SYNCHRONIZED отсутствуют] 1 [NATIVE есть] 0 [STRICT отсутствует]
//
//Modifier.STATIC показывает, какой именно байт отвечает в данном случае за наличие static. напр. 01000000 говорит, что за статик отвечает второй по счету байт.
//Сравниваем, есть ли модификатор в общем наборе модификаторов класса(или метода):
//01001100 & // Модиф-ы класса
//01000000 = // Второй байт, где именно находится единица для STATIC.У нас совпадает, в выводе будет:
//01000000
//
//А, например
//01001100 &
//00100000 // Другой модификатор, который отсутствует в классе
//00000000 // При сравнении выдает нам 0.
//
//
//Поэтому сравнив (allModifiers & specificModifier) != 0; узнаем, если не равно 0 то модификатор в наборе байт есть!