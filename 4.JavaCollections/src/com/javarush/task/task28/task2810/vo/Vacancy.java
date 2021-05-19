package com.javarush.task.task28.task2810.vo;

/*
Aggregator (3)
Начиная с этого задании ты начнешь писать логику получения данных с сайта.
Эта логика будет полностью сосредоточена в классах, реализующих Strategy.

Провайдер в данном случае выступает в качестве контекста, если мы говорим о паттерне Стратегия.
В провайдере должен быть метод, который будет вызывать метод стратегии для выполнения главной операции.
Этот метод будет возвращать все java вакансии с выбранного сайта (ресурса).

1. В корне задачи создай пакет vo (value object), в котором создай класс Vacancy.
Этот класс будет хранить данные о вакансии.

2. В Provider создай метод List<Vacancy> getJavaVacancies(String searchString). Оставь пока метод пустым.

3. Что есть у вакансии?
Название, зарплата, город, название компании, название сайта, на котором вакансия найдена,
ссылка на вакансию. В классе Vacancy создай соответствующие строковые поля:
title, salary, city, companyName, siteName, url.

4. Создай геттеры и сеттеры для всех полей класса Vacancy.

5. В пакете model создай класс HHStrategy от Strategy.
Этот класс будет реализовывать конкретную стратегию работы с сайтом ХэдХантер
(http://hh.ua/ и http://hh.ru/).


Требования:
1. В корне задачи создай пакет vo, в нем создай класс Vacancy.
2. В классе Provider создай пустой метод getJavaVacancies(String searchString),
который будет возвращать список вакансий.
3. В классе Vacancy создай строковые поля: title, salary, city, companyName, siteName, url.
4. К полям в классе Vacancy создай геттеры и сеттеры.
5. В пакете model создай класс HHStrategy, который реализует интерфейс Strategy.
 */
//1. В корне задачи создай пакет vo (value object), в нем создай класс Vacancy (будет хранить данные о вакансии).

import java.util.Objects;

public class Vacancy {

//3. В классе Vacancy создай строковые поля: title, salary, city, companyName, siteName, url.

    private String title;
    private String salary;
    private String city;
    private String companyName;
    private String siteName;
    private String url;

//4. К полям в классе Vacancy создай геттеры и сеттеры.

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacancy vacancy = (Vacancy) o;
        return Objects.equals(title, vacancy.title) &&
                Objects.equals(salary, vacancy.salary) &&
                Objects.equals(city, vacancy.city) &&
                Objects.equals(companyName, vacancy.companyName) &&
                Objects.equals(siteName, vacancy.siteName) &&
                Objects.equals(url, vacancy.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, salary, city, companyName, siteName, url);
    }
}
