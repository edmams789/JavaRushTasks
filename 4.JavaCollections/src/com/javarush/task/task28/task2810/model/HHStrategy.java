package com.javarush.task.task28.task2810.model;
/*
Aggregator (8)
Запусти снова программу в дебаг моде.
Скопируй полученное значение document.html() в созданный ранее html файл.
Отформатируй его и найди теги с вакансиями.

Почитай в Сообществе дополнительный материал к лекции про селекторы атрибута.

ВНИМАНИЕ: ОСОБЕННОСТИ ТЕСТИРОВАНИЯ!
HTML код странички ХэдХантера может меняться, чтобы эта задача продолжила работать стабильно
не меняя тесты воспользуйся закешированной версией http://javarush.ru/testdata/big28data.html
Это только для этого пункта, в следующих заданиях используй реальные страницы.

1. В классе HHStrategy создай protected метод
Document getDocument(String searchString, int page) throws IOException.

2. Реализуй следующую логику метода getVacancies в классе HHStrategy:
2.1. Приконнекться к закешированной страничке ХэдХантера используя метод getDocument, нумерация начинается с 0.
2.2. Получи список элементов с атрибутом "vacancy-serp__vacancy". Должно быть до 20 вакансий на странице.
2.3. Если данные в списке из п.2.2 есть, то для каждого элемента:
2.3.1. создать вакансию и заполнить все ее данные, получив данные из текущего элемента.
Если тег с зарплатой присутствует, то заполнить и поле salary, иначе инициализировать поле пустой строкой.
2.4. Выполнить п.2.1-2.3 для следующей страницы ХэдХантера.
2.5. Если закончились страницы с вакансиями, то выйти из цикла.

Исключения игнорировать.
Все вакансии добавить в общий список и вернуть в качестве результата метода.

Подсказка по зарплате:
Поиграйся с URL_FORMAT, добавь туда еще один параметр, чтобы получить вакансии с зарплатами.
Проанализируй полученный html и найди тег для зарплаты.
Не забудь потом вернуть значение URL_FORMAT обратно.


Требования:
1. В классе HHStrategy создай protected метод getDocument(String searchString, int page).
Перенеси туда логику по получению объекта html-страницы Document.
2. Метод getVacancies класса HHStrategy должен получать содержимое страниц с помощью метода getDocument.
Начни с 0 страницы.
3. Из объекта Document получи список html-элементов с атрибутом "vacancy-serp__vacancy".
Для каждого элемента создай объект вакансии и добавь его в возвращающий методом список.
4. Нужно последовательно обработать все страницы результатов поиска.
Как только страницы с вакансиями закончатся, прерви цикл и верни список найденных вакансий.
5. У каждой вакансии должно быть заполнено поле title полученными из html-элемента данными о названии вакансии.
6. У каждой вакансии должно быть заполнено поле url полученной из html-элемента ссылкой на вакансию.
7. У каждой вакансии должно быть заполнено поле city полученными из html-элемента данными о городе.
8. У каждой вакансии должно быть заполнено поле companyName полученными из html-элемента данными о компании.
9. У каждой вакансии должно быть заполнено поле siteName значением сайта, на котором вакансия была найдена.
10. Поле salary у вакансии должно быть заполнено, если в html-элементе присутствовал тег с зарплатой.
Иначе поле должно быть инициализировано пустой строкой.
11. Если ты менял значение поля URL_FORMAT, не забудь вернуть его обратно.
 */

import com.javarush.task.task28.task2810.vo.Vacancy;

import javax.swing.text.Document;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
В пакете model создай класс HHStrategy от Strategy.
Этот класс будет реализовывать конкретную стратегию работы с сайтом ХэдХантер
(http://hh.ua/ и http://hh.ru/).
 */
public class HHStrategy implements Strategy {
//В классе HHStrategy создай приватную строковую константу URL_FORMAT.

    /*
    Я бы изложил условие так:
    1. Возьмите строку "http://hh.ua/search/vacancy?text=java+Киев&page=1". Не вздумайте брать из Интернета!
    2. В следующем задании Вы напишете код: String.format(URL_FORMAT, "Kiev", 3)
    3. Сейчас создайте приватную строковую константу URL_FORMAT. Для этого измените строку из п. 1 так,
    чтобы при её подстановке в п. 2 результат был: "http://hh.ru/search/vacancy?text=java+Kiev&page=3"
     */

    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        Document doc = null;

        int page = 0;

//        try {
//            doc = getDocument(searchString, page);
//            while (true) {
//                Elements elements = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
//                if (elements.size() == 0) {
//                    page = 0;
//                    break;
//                }
//                for (Element element : elements) {
//                    if (element != null) {
//                        Vacancy vacancy = new Vacancy();
//                        vacancy.setTitle(element.getElementsByAttributeValueContaining("data-qa", "title").text());
//                        vacancy.setCity(element.getElementsByAttributeValueContaining("data-qa", "address").text());
//                        vacancy.setCompanyName(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
//                        vacancy.setSiteName(URL_FORMAT);
//                        String urlPage = element.getElementsByAttributeValueContaining("data-qa", "title").attr("href");
//                        vacancy.setUrl(urlPage);
//                        String salary = element.getElementsByAttributeValueContaining("data-qa", "compensation").text();
//                        vacancy.setSalary(salary.length()==0 ? "" : salary);
//                        vacancies.add(vacancy);
//                    }
//                }
//                ++page;
//                doc = getDocument(searchString, page);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return vacancies;
    }
    protected Document getDocument(String searchString, int page) throws IOException {
//1. В классе HHStrategy создай protected метод getDocument(String searchString, int page).
//Перенеси туда логику по получению объекта html-страницы Document.

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
