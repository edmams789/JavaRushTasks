package com.javarush.task.task29.task2909.user;
/*
Рефакторинг (14)
14.1. Перемещение поля. Замени поля isManAnya и isManRoma полем man в нужном классе.
Добавь сеттер и геттер для нового поля (при выборе имен методов учти тип поля).
14.2. Извлечение класса.
14.2.1. Добавь класс Address в пакет user.
14.2.2. Перенеси поля country, city и house в новый класс.
14.2.3. Добавь сеттеры и геттеры для них.
14.2.4. Перепиши класс User, используя поле класса Address address.
14.3. Встраивание класса. Класс House почти ничего не делает, избавься от него.
14.4. Сокрытие делегирования.
14.4.1. Добавь в класс User метод getBoss().
14.4.2. Перепиши реализацию метода getBossName(User user) класса UserHelper.

Требования:
1. Необходимо заменить поля isManAnya и isManRoma класса UserHelper полем boolean man в классе User.
Так же добавь сеттер и геттер для нового поля.
2. Необходимо добавить класс Address в пакет user.
3. Необходимо перенести поля country, city и house из класса User в класс Address.
4. Необходимо добавить сеттеры и геттеры для полей country, city, house класса Address.
5. В классе User необходимо переписать методы: getAddress, getCountry, setCountry, getCity, setCity.
И нужно добавить в класс приватное поле Address address.
6. Необходимо избавиться от класса House. Поле класса String house нужно перенести в класс Address.
Необходимо обновить геттер и сеттер поля.
7. Необходимо добавить в класс User метод getBoss() и реализовать этот метод.
8. Необходимо изменить реализацию метода getBossName(User user) класса UserHelper
(используй метод getBoss() класса User).
 */
public class User {
    private String name;
    private String surname;
    private int age;
    private Address address;
//    private String country;
//    private String city;
//    private House house;
    private Work work;
    private boolean man;

    public boolean isMan() {
        return man;
    }
    public void setMan(boolean man) {
        this.man = man;
    }
    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() { //
        return address.getCountry();
    }

    public void setCountry(String country) {
        address.setCountry(country);
    }

    public String getCity() { //
        return address.getCity();
    }

    public void setCity(String city) {
        address.setCity(city);
    }

    public String getAddress() {
        //return country + " " + city + " " + house.house;
        return address.getCountry() + " " + address.getCity() + " " + address.getHouse();
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public void printInfo() {
        System.out.println("Имя: " + getName());
        System.out.println("Фамилия: " + getSurname());
    }
    public void printAdditionalInfo() {
        if (getAge() < 16)
            System.out.println("Пользователь моложе 16 лет");
        else
            System.out.println("Пользователь старше 16 лет");
    }
    public String getBoss(){
        return getWork().getBoss();
    }
}
//В классе user уже есть поле Work work. У меня приняло в таком виде:
//public String getBoss(){
//        return work.getBoss();
//хотя я в упор не вижу разницы с return getWork().getBoss()