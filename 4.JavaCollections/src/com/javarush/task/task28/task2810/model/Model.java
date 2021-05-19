package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.view.View;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/*
Aggregator (10)
У View есть метод update, в него передается список вакансий для отображения.
Очевидно, что этот метод будет вызываться моделью, т.к. только она получает данные.
Пришло время создать модель.

1. Создай класс Model в пакете model.

2. Добавь два поля - 1) вью, 2) массив провайдеров.

3. Создай конструктор с двумя параметрами - 1) вью, 2) массив провайдеров.
На неправильные данные кинь IllegalArgumentException.

4. Создай публичный метод void selectCity(String city).

5. Реализуй логику метода selectCity:
5.1. получить вакансии с каждого провайдера,
5.2. обновить вью списком вакансий из п.5.1.


Требования:
1. Создай класс Model в пакете model.
2. В классе Model добавь два поля: вью и массив провайдеров.
3. Создай конструктор с двумя параметрами: вью и массив провайдеров.
На неправильные данные кинь IllegalArgumentException.
4. В класс Model добавь метод public void selectCity(String city).
5. Реализуй логику метода selectCity.
Он должен получать вакансии с каждого провайдера и передавать в метод update у вью.
 */
public class Model {

    private View view;
    private Provider[] providers;

    public Model(View view, Provider... providers) {

     //   if (view == null)
     //       throw new IllegalArgumentException();
    //    if (providers == null)
    //        throw new IllegalArgumentException();
     //   if (providers.length == 0)
      //      throw new IllegalArgumentException();
        this.view = view;
        this.providers = providers;
    }
    public void selectCity(String city) {
        view.update(Arrays.stream(providers)
                .map(provider -> provider.getJavaVacancies(city))
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));
    }

}
