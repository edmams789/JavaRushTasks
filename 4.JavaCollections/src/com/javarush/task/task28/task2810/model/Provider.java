package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Provider {
    private Strategy strategy;

    public Provider(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

//В Provider создай метод List<Vacancy> getJavaVacancies(String searchString). Оставь пока метод пустым.

    public List<Vacancy> getJavaVacancies(String searchString) {

//Вернись в метод getJavaVacancies класса Provider, реализуй его логику из расчета, что всех данных хватает.

        List<Vacancy> vacancies = new ArrayList<>();

    //    for (Provider provider : providers)
        if (strategy == null) {
            return Collections.emptyList();
        }

        return strategy.getVacancies(searchString);
    }
}
