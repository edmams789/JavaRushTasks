package com.javarush.task.task24.task2407;

import java.util.Arrays;

/*
В работе вам иногда будет нужно закастить класс к какому-нибудь интерфейсу (тут Sayable),
который не реализован в текущем классе
 */

/*
*
Реализация интерфейса используя локальный класс
В классе Cat реализуй логику метода toSayable, которая описана в джавадоке.

Требования:
1. В классе Cat должен быть реализован публичный метод toSayable с одним параметром типа int.
2. Метод toSayable должен возвращать объект типа Sayable.
3. Если полученный параметр меньше 1, метод say() должен вернуть строку формата: "name спит.",
где name - имя текущего кота.
4. Если полученный параметр больше либо равен 1, метод say() должен вернуть строку формата: "name говорит мяяяу!", где name - имя текущего кота, а количество букв "я" в слове "мяяяу" равно полученному параметру.
5. Программа должна выводить данные на экран.
*/

public class Cat implements Pet {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    /**
     * Это - механизм адаптирования к другому интерфейсу - Sayable
     * Внутри метода toSayable создайте class CatPet, реализующий интерфейс Sayable
     * Логика метода say:
     * Если i < 1, то вывести на экран, что кот спит. Пример, "Васька спит."
     * Иначе вывести фразу: "имя_кота говорит мяу!". Пример для i=3, "Васька говорит мяяяу!"
     * <p/>
     * <b>Пример вывода:</b>
     * Мурзик спит.
     * Васька говорит мяяу!
     * Кошка говорит мяяяяяу!
     * Мышь пищит.
     * Томас говорит мяу!
     * <p/>
     * @param i количество букв 'я' в слове мяу
     * @return экземпляр класса CatPet
     */
    public Sayable toSayable(final int i) {
        class CatPet implements Sayable{
//            String str = "я";
//            String repeated = str.repeat(num);
//            System.out.println(name + " говорит м" + repeated + "у!");
//            final int num = i;

            @Override
            public String say() {
//
//                if (i < 1) System.out.println(name + " спит.");
//            else {
//                    char[] chars = new char[i];
//                    Arrays.fill(chars, 'я');
//                    return String.format("%s говорит м%sу!", name, new String(chars));
//                }
                 return (i < 1) ? name + " спит." : name + " говорит м" + String.format("%" + i + "s","я").replaceAll("\\s","я") + "у!";
            }

        }

        return new CatPet();
    }
}
//https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string-in-java
//String str = "abc";
//String repeated = str.repeat(3);
//
//repeated.equals("abcabcabc");

//return (i < 1) ? name + " спит." : name + " говорит м" + String.format("%"+ i +"s","я").replaceAll("\\s","я") + "у!";

//Вот еще вариант со stackoverflow
//char[] chars = new char[i];
//Arrays.fill(chars, 'я');
//return String.format("%s говорит м%sу!", name, new String(chars));
//
//по скорости он должен быть лучше replace и StringBuilder

//Умножение/повторение строки
//new String(new char[i]).replace("\0", "я")
//
//Где i сколько раз повторить строку