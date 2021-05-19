package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
Сериализуй класс Person стандартным способом. При необходимости добавь некоторым полям модификатор transient.


Требования:
1. Класс Person должен поддерживать интерфейс Serializable.
2. Поле fullName должно быть отмечено модификатором transient.
3. Поле greeting должно быть отмечено модификатором transient.
4. Поле outputStream должно быть отмечено модификатором transient.
5. Поле logger должно быть отмечено модификатором transient.
6. Поле firstName НЕ должно быть отмечено модификатором transient.
7. Поле lastName НЕ должно быть отмечено модификатором transient.
8. Поле country НЕ должно быть отмечено модификатором transient.
9. Поле sex НЕ должно быть отмечено модификатором transient.
*/
public class Solution {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greeting;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

      public Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greeting = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws Exception {
        Person person = new Person("Egor", "Stepanovich", "Malasiya", Sex.MALE);
        FileOutputStream fos = new FileOutputStream("your.file.name");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(person);
        fos.close();
        oos.close();

        FileInputStream fis = new FileInputStream("your.file.name");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object object = ois.readObject();
        fis.close();
        ois.close();

        Person newPerson = (Person) object;

    }
}
