package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

/*
Shortener (14)
Мы много раз тестировали наши стратегии с помощью метода testStrategy() класса Solution.
Пришло время написать настоящие юнит тесты с использованием junit.
14.1. Прочитай что такое юнит тесты.
14.2. Скачай и подключи библиотеку Junit 4.12. Разберись как ей пользоваться.
Библиотека Junit зависит от библиотеки hamcrest-core. Подключи и ее. Используй версию 1.3.
14.3. Добавь класс FunctionalTest в пакет tests. В этом классе мы проверим функциональность наших стратегий.
14.4. Добавь в класс FunctionalTest метод testStorage(Shortener shortener). Он должен:
14.4.1. Создавать три строки. Текст 1 и 3 строк должен быть одинаковым.
14.4.2. Получать и сохранять идентификаторы для всех трех строк с помощью shortener.
14.4.3. Проверять, что идентификатор для 2 строки не равен идентификатору для 1 и 3 строк.

Подсказка: метод Assert.assertNotEquals.

14.4.4. Проверять, что идентификаторы для 1 и 3 строк равны.

Подсказка: метод Assert.assertEquals.

14.4.5. Получать три строки по трем идентификаторам с помощью shortener.
14.4.6. Проверять, что строки, полученные в предыдущем пункте, эквивалентны оригинальным.

Подсказка: метод Assert.assertEquals.

14.5. Добавь в класс FunctionalTest тесты:
14.5.1. testHashMapStorageStrategy()
14.5.2. testOurHashMapStorageStrategy()
14.5.3. testFileStorageStrategy()
14.5.4. testHashBiMapStorageStrategy()
14.5.5. testDualHashBidiMapStorageStrategy()
14.5.6. testOurHashBiMapStorageStrategy()
Каждый тест должен иметь аннотацию @Test, создавать подходящую стратегию, создавать объект класса Shortener на базе этой стратегии и вызывать метод testStorage для него.
Запусти и проверь, что все тесты проходят.

ищите  - org.junit.vintage:junit-vintage-engine:4.12.0

Требования:
1. Класс FunctionalTest должен быть добавлен в созданный пакет tests.
2. В методе testStorage должны быть трижды вызваны методы getId и getString.
3. Тестовые методы перечисленные в условии задачи должны быть отмечены только аннотацией @Test.
4. В каждом тестовом методе должен содержаться вызов метода testStorage.
 */
//Добавь класс FunctionalTest в пакет tests. В этом классе мы проверим функциональность наших стратегий.
public class FunctionalTest {
//Добавь в класс FunctionalTest метод testStorage(Shortener shortener). Он должен:
    public void testStorage(Shortener shortener){
//Создавать три строки. Текст 1 и 3 строк должен быть одинаковым.
        String s1 = Helper.generateRandomString();;
        String s2 = Helper.generateRandomString();;
        String s3 = s1;

//14.4.2. Получать и сохранять идентификаторы для всех трех строк с помощью shortener.
        Long id1 = shortener.getId(s1);
        Long id2 = shortener.getId(s2);
        Long id3 = shortener.getId(s3);

//14.4.3. Проверять, что идентификатор для 2 строки не равен идентификатору для 1 и 3 строк.
//Подсказка: метод Assert.assertNotEquals.
        Assert.assertNotEquals(id2, id1);
        Assert.assertNotEquals(id2, id3);

//14.4.4. Проверять, что идентификаторы для 1 и 3 строк равны.
//Подсказка: метод Assert.assertEquals.
        Assert.assertEquals(s1, s3);

//14.4.5. Получать три строки по трем идентификаторам с помощью shortener.
//14.4.6. Проверять, что строки, полученные в предыдущем пункте, эквивалентны оригинальным.
//Подсказка: метод Assert.assertEquals.
        Assert.assertEquals(s1, shortener.getString(id1));
        Assert.assertEquals(s2, shortener.getString(id2));
        Assert.assertEquals(s3, shortener.getString(id3));
    }
//Добавь в класс FunctionalTest тесты:
//14.5.1. testHashMapStorageStrategy()
        @Test
    public void testHashMapStorageStrategy(){
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(hashMapStorageStrategy);
        testStorage(shortener);
        }
//testOurHashMapStorageStrategy()
@Test
public void testOurHashMapStorageStrategy()
{
    StorageStrategy ourHashMapStorageStrategy = new OurHashMapStorageStrategy();
    Shortener shortener = new Shortener(ourHashMapStorageStrategy);
    testStorage(shortener);
}
//testFileStorageStrategy()
    @Test
    public void testFileStorageStrategy()
    {
        FileStorageStrategy fileStorageStrategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(fileStorageStrategy);
        testStorage(shortener);
    }
//testHashBiMapStorageStrategy()
    @Test
    public void testHashBiMapStorageStrategy()
    {
        HashBiMapStorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(hashBiMapStorageStrategy);
        testStorage(shortener);
    }
//testDualHashBidiMapStorageStrategy()
    @Test
    public void testDualHashBidiMapStorageStrategy()
    {
        DualHashBidiMapStorageStrategy dualHashBidiMapStorageStrategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(dualHashBidiMapStorageStrategy);
        testStorage(shortener);
    }
//testOurHashBiMapStorageStrategy()
    @Test
    public void testOurHashBiMapStorageStrategy()
    {
        OurHashBiMapStorageStrategy ourHashBiMapStorageStrategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(ourHashBiMapStorageStrategy);
        testStorage(shortener);
    }
}
