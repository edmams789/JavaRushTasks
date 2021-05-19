package com.javarush.task.task28.task2810;

/*
Aggregator (11)
В Model есть метод selectCity, в него передается название города, для которого выбираются вакансии.
Очевидно, что этот метод будет вызываться контроллером, т.к. он принимает решение, какую модель использовать.

1. Добавь в Controller новое поле Model model.

2. Удали метод scan() из Controller, его логика переместилась в модель.

3. Удали конструктор, toString и поле providers из контроллера.

4. Создай конструктор в Controller с аргументом Model.
На некорректные данные брось IllegalArgumentException

5. В Controller создай публичный метод void onCitySelect(String cityName),
в котором вызови нужный метод модели.

6. Удали код из метода main. Этот код уже не валидный.


Требования:
1. В классе Controller добавь новое поле Model model.
2. Удали из Controller метод scan, метод toString, конструктор и поле providers.
3. Добавь в Controller новый конструктор с аргументом Model.
На некорректные данные брось IllegalArgumentException.
4. Создай в Controller публичный метод void onCitySelect(String cityName),
в котором вызови нужный метод модели.
5. Удали старый код из метода main.
 */

import com.javarush.task.task28.task2810.model.Model;

//1. Создай класс Controller, в нем будет содержаться бизнес логика.
public class Controller {

//2. Удали из Controller метод scan, метод toString, конструктор и поле providers.
 //   private Provider[] providers;

//    public Controller(Provider... providers) {
//        if (providers.length == 0) {
//            throw new IllegalArgumentException();
//        }
//        this.providers = providers;
//    }
//    @Override
//    public String toString() {
//        return "Controller{" +
//                "providers=" + Arrays.toString(providers) +
//                '}';
//    }
//    public void scan() {
//        ArrayList<Vacancy> vacancies = new ArrayList<>();
//
//        for (Provider provider : providers) {
//            vacancies.addAll(provider.getJavaVacancies(null));
//        }
//        System.out.println(vacancies.size());
//    }
    private Model model;

    public Controller(Model model) {
        if (model == null) {
            throw new IllegalArgumentException();
        }
        this.model = model;
    }
    public void onCitySelect(String cityName) {
        model.selectCity(cityName);
    }
}
