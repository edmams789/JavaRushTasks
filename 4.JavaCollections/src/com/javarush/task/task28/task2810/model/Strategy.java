package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.List;

public interface Strategy {

//Добавь в интерфейс метод getVacancies(String searchString), который будет возвращать список вакансий.

    List<Vacancy> getVacancies(String searchString);
}
