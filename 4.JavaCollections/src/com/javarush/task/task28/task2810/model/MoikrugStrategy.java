package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import javax.swing.text.Document;
import java.util.ArrayList;
import java.util.List;

/*
Aggregator (16)
Ты молодец, большая работа позади! Теперь тебе легко будет мониторить вакансии для трудоустройства :)

Сейчас Aggregator использует только одну стратегию сбора вакансий - с ХэдХантера.

1. По аналогии с HHStrategy добавь стратегию для Мой круг.

Назови класс MoikrugStrategy, реализуй метод getVacancies.
Вот тебе пример ссылки:
https://moikrug.ru/vacancies?q=java+Dnepropetrovsk

Пример ссылки на вакансию:
https://moikrug.ru/vacancies/560164256

2. В методе main создай провайдер для MoikrugStrategy. Передай этот провайдер в конструктор Model.

Это удобно сделать, т.к. модель принимает много провайдеров.
Остальную логику менять не нужно. Видишь, как легко расширять функционал?
От правильной архитектуры зависит многое.

ВНИМАНИЕ: ОСОБЕННОСТИ ТЕСТИРОВАНИЯ!

HTML код странички c вакансиями с Моего круга, как и ХэдХантера, может меняться.
Чтобы эта задача прошла тестирование,
при реализации задания воспользуйся закешированной версией страницы:
http://javarush.ru/testdata/big28data2.html.

Это необходимо для тестирования данного задания,
после его сдачи проверь работу MoikrugStrategy на реальном сайте.

Требования:
1. В пакете model создай новый класс MoikrugStrategy, который реализует интерфейс Strategy.
2. В классе MoikrugStrategy добавь приватную статическую константу URL_FORMAT, по аналогии с HHStrategy.
3. В классе MoikrugStrategy создай protected метод getDocument(String searchString, int page).
Реализуй его по аналогии с HHStrategy.
4. Метод getVacancies класса MoikrugStrategy должен получать содержимое страниц
с помощью метода getDocument. Начни с 0 страницы.
5. Из объекта Document получи список html-элементов с вакансиями. Для каждого элемента
создай объект вакансии и добавь его в возвращающий методом список.
6. Нужно последовательно обработать все страницы результатов поиска. Как только страницы
с вакансиями закончатся, прерви цикл и верни список найденных вакансий.
7. У каждой вакансии должно быть заполнено поле title полученными из html-элемента данными о названии вакансии.
8. У каждой вакансии должно быть заполнено поле url полученной из html-элемента ссылкой на вакансию.
9. У каждой вакансии должно быть заполнено поле companyName полученными из html-элемента данными о компании.
10. У каждой вакансии должно быть заполнено поле siteName значением сайта, на котором вакансия была найдена.
11. Поле city у вакансии должно быть заполнено, если в html-элементе присутствовал тег с данными о городе.
Иначе поле должно быть инициализировано пустой строкой.
12. Поле salary у вакансии должно быть заполнено, если в html-элементе присутствовал тег с зарплатой.
Иначе поле должно быть инициализировано пустой строкой.
13. В методе main в модель добавь новый провайдер, инициализированный стратегией MoikrugStrategy.
 */
public class MoikrugStrategy implements Strategy {

    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        int page = 0;
        Document document = null;
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) {

        String myURL = String.format(URL_FORMAT, searchString, page);
        Document document = null;

//        try {
//            document = Jsoup.connect(myURL)
//                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36")
//                    .referrer("no-referrer-when-downgrade")
//                    .get();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return document;

    }
}