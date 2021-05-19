package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
Реализуй логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов.
2) только цифры и латинские буквы разного регистра.
3) обязательно должны присутствовать цифры, и буквы разного регистра.
Все сгенерированные пароли должны быть уникальные.

Пример правильного пароля:
wMh7smNu

Требования:
1. Класс Solution должен содержать метод getPassword(), который возвращает ByteArrayOutputStream со
сгенерированным паролем.
2. Длина пароля должна составлять 8 символов.
3. Пароль должен содержать хотя бы одну цифру.
4. Пароль должен содержать хотя бы одну латинскую букву нижнего регистра.
5. Пароль должен содержать хотя бы одну латинскую букву верхнего регистра.
6. Пароль не должен содержать других символов, кроме цифр и латинских букв разного регистра.
7. Сгенерированные пароли должны быть уникальными.
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String laters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "1234567890";
        StringBuffer passw = new StringBuffer();

        for (int i=0; i<1; i++) {
            passw.append(laters.charAt((int)(Math.random()*26)));
        }
        for (int i=0; i<1; i++) {
            passw.append(digits.charAt((int)(Math.random()*10)));
        }
        for (int i=0; i<1; i++) {
            passw.append(laters.toUpperCase().charAt((int)(Math.random()*26)));
        }
        for (int i=0; i<1; i++) {
            passw.append(laters.charAt((int)(Math.random()*26)));
        }
        for (int i=0; i<1; i++) {
            passw.append(laters.toUpperCase().charAt((int)(Math.random()*26)));
        }
        for (int i=0; i<2; i++) {
            passw.append(digits.charAt((int)(Math.random()*10)));
        }
        for (int i=0; i<1; i++) {
            passw.append(laters.toUpperCase().charAt((int)(Math.random()*26)));
        }

        try {
            baos.write(passw.toString().getBytes());
        } catch (Exception e)
        {

        }

        return baos;

 //       return null;
    }
}
//хотел сделать через регулярки, долго мучился, оставлю это здесь:
//(?=.*[0-9]) - строка содержит хотя бы одно число;
//(?=.*[a-z]) - строка содержит хотя бы одну латинскую букву в нижнем регистре;
//(?=.*[A-Z]) - строка содержит хотя бы одну латинскую букву в верхнем регистре;
//[0-9a-zA-Z]{8,} - строка состоит не менее, чем из 8 вышеупомянутых символов.

//        String passwordAlphabet = engLower + engUpper + digits;
//        char[] resultArr = new char[8]; //Массив-пароль
//        for (int i = 0; i < resultArr.length; i++)
//            resultArr[i] = passwordAlphabet.charAt(random.nextInt(passwordAlphabet.length()));

/*
(рандом до 26) + 65 - символ UpperCase, полученный int просто отправляем в baos
(рандом до 26) + 97 - символ LowerCase
(рандом до 10) + 48 - символ 0-9
остальные 5 вставляем случайно из (рандом до (26 + 26 + 10)), прибавляя/отнимая соответственно к тому, что получим.
при каждом запуске мейна Math.random() выдает разные значения

- тоже хотел так сделать, но тут же получается что всегда пароль будет начинаться в одинаковом виде,
нет валик конечно примет, но осадочек то останется)
P.S. чтобы не искать значение символов в таблице ASCII  можно писать просто символами
Math.random()*26+'A'
так удобней и вам писать и за вами потом читать)
 */