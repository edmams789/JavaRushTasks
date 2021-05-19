package com.javarush.task.task30.task3001;

import java.math.BigInteger;

/*
Конвертер систем счислений
Реализуй логику метода convertNumberToOtherNumberSystem, который должен переводить число number.getDigit(),
из одной системы счисления (numberSystem) в другую (expectedNumberSystem).
Брось NumberFormatException, если переданное число некорректно, например, число "120" с системой счисления 2.
Валидация для - number.getDigit() - целое не отрицательное.
Метод main не участвует в тестировании.

Требования:
1. Метод convertNumberToOtherNumberSystem (Number, NumberSystem), возвращающий тип Number, должен существовать.
2. Должно бросаться исключение NumberFormatException, если переданное число некорректно в заданной системе счисления.
3. Необходимо корректно реализовать метод convertNumberToOtherNumberSystem - перевод числа в указанную
систему счисления.
4. Enum NumberSystemType должен поддерживать интерфейс NumberSystem.
5. В enum-е NumberSystemType должно присутствовать 11 значений оснований систем счисления. Основания:
2, 3, 4, 5, 6, 7, 8, 9, 10, 12 и 16.
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337 (ожидаемый)

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        //напишите тут ваш код
        BigInteger bigInteger = new BigInteger(number.getDigit(), number.getNumberSystem().getNumberSystemIntValue());
        String ans = bigInteger.toString(expectedNumberSystem.getNumberSystemIntValue());
        return new Number(expectedNumberSystem, ans);
    }
}
//В начале проверяем изначальное число-параметр, чтобы дальше по коду пройти.
//if (baseNum.contains(".") || baseNum.isEmpty() || baseNum.contains("-")) throw new NumberFormatException();
//
//Долго сидел, не мог понять, как мне сразу проверить, что число отрицательное, в итоге через знак "-".
//Дальше в помощь BigInteger.toString(два параметра)

//BigInteger bi = new BigInteger(number.getDigit(), number.getNumerationSystem().getNumerationSystemIntValue());
//String ans = bi.toString(expectedNumerationSystem.getNumerationSystemIntValue());
//return new Number(expectedNumerationSystem, ans);

//Две строчки решения, чётка))
//На заметку
//Используйте BigInteger, при создании нового объекта в параметрах вторым параметром используйте кодировку ЭТОГО числа.
//Чтобы получить это число в другой кодировке используйте ToString, но в параметрах укажите требуемую кодировку.
//Удачи!))