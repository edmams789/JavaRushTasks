package com.javarush.task.task19.task1904;

import java.util.Date;

public class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;

    public Person(String s, String s1, String s2, Date d) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", firstName, middleName, lastName, birthDate.toString());
    }
}
//