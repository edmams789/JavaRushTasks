package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполни карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуй логику записи в файл и чтения из файла для карты properties.

Требования:
1. Метод fillInPropertiesMap должен считывать данные с консоли.
2. Метод fillInPropertiesMap должен создавать FileInputStream, передавая считанную строку
в качестве параметра.
3. Метод fillInPropertiesMap должен вызывать метод load передавая только что созданный FileInputStream
в качестве параметра.
4. Метод save должен сохранять карту properties в полученный в качестве параметра объект типа OutputStream.
5. Метод load должен восстанавливать состояние карты properties из полученного
в качестве параметра объекта типа InputStream.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
//В методе fillInPropertiesMap считайте имя файла с консоли и заполни карту properties данными из файла.
    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
//1. Метод fillInPropertiesMap должен считывать данные с консоли.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
//2. Метод fillInPropertiesMap должен создавать FileInputStream, передавая считанную строку в качестве параметра.
        FileInputStream fileInputStream = new FileInputStream(fileName);
//3. Метод fillInPropertiesMap должен вызывать метод load передавая только что созданный FileInputStream в качестве параметра.
        load(fileInputStream);
    }
//4. Метод save должен сохранять карту properties в полученный в качестве параметра объект типа OutputStream.
    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties proper = new Properties();
            proper.putAll(properties); //команда для заполнения Properties файла из мапа
            proper.store(outputStream, null); //сохранение
            outputStream.close();
    }
//5. Метод load должен восстанавливать состояние карты properties из полученного в качестве параметра объекта типа InputStream.
    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties proper = new Properties();
        proper.load(inputStream); //заполнение файла из памяти
        //а вот положить все в мап придется через цикл
        for (String name : proper.stringPropertyNames()){
            properties.put(name, proper.getProperty(name));
        }
    }
    public static void main(String[] args) {
    }
}
//1. http://samoychiteli.ru/document30164.html - методы класса Properties на русском
//2. https://javadevblog.com/primer-raboty-s-properties-v-java.html - пример загрузки свойств
//И продублирую уже приведенную ссылку, по преобразованию Properties в Map:
//3. https://stackoverflow.com/questions/17209260/converting-java-util-properties-to-hashmapstring-string