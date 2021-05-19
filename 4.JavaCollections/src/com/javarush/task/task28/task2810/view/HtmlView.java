package com.javarush.task.task28.task2810.view;

//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
 /*
Aggregator (15)
В классе HtmlView остался один пустой метод getUpdatedFileContent. В этом задании я опишу,
что он должен делать.

1. В HtmlView создай protected метод Document getDocument() throws IOException, в котором
распарси файл vacancies.html используя Jsoup. Кодировка файла "UTF-8", используй поле filePath.

2. Получи элемент, у которого есть класс template.
Сделай копию этого объекта, удали из нее атрибут "style" и класс "template".
Используй этот элемент в качестве шаблона для добавления новой строки в таблицу вакансий.

3. Удали все добавленные ранее вакансии. У них единственный класс "vacancy".
В файле backup.html это одна вакансия - Junior Java Developer.
Нужно удалить все теги tr, у которых class="vacancy".
Но тег tr, у которого class="vacancy template", не удаляй.
Используй метод remove.

4. В цикле для каждой вакансии:
4.1. склонируй шаблон тега, полученного в п.2. Метод clone.
4.2. получи элемент, у которого есть класс "city". Запиши в него название города из вакансии.
4.3. получи элемент, у которого есть класс "companyName". Запиши в него название компании из вакансии.
4.4. получи элемент, у которого есть класс "salary". Запиши в него зарплату из вакансии.
4.5. получи элемент-ссылку с тегом a. Запиши в него название вакансии(title).
Установи реальную ссылку на вакансию вместо href="url".
4.6. добавь outerHtml элемента, в который ты записывал данные вакансии,
непосредственно перед шаблоном <tr class="vacancy template" style="display: none">
5. Верни html код всего документа в качестве результата работы метода.
6. В случае возникновения исключения, выведи его стек-трейс и верни строку "Some exception occurred".
7. Запусти приложение, убедись, что все вакансии пишутся в файл vacancies.html.

Требования:
1. В классе HtmlView добавь метод protected Document getDocument()
в котором распарси файл vacancies.html используя Jsoup.
2. Реализуй метод getUpdatedFileContent(). Для начала, получи распарсеную страницу
с помощью метода getDocument().
3. Получи элемент, у которого есть класс template. Сделай копию этого объекта,
удали из нее атрибут "style" и класс "template".
4. Удали из страницы все добавленные ранее вакансии с классом "vacancy".
Элемент с классом "vacancy template" должен остаться.
5. Перед объектом template для каждой вакансии добавь на страницу отдельный html-элемент,
используя копию template. Верни html-код всей страницы в качестве результата работы метода.
6. Для каждой вакансии должен быть корректно заполнен элемент-ссылка
с названием вакансии(title) и http-ссылкой на нее(href).
7. Для каждой вакансии должен быть корректно заполнен элемент с классом "city".
8. Для каждой вакансии должен быть корректно заполнен элемент с классом "companyName".
9. Для каждой вакансии должен быть корректно заполнен элемент с классом "salary".
10. В случае возникновения исключения, выведи его стек-трейс и верни строку "Some exception occurred".
  */
//public class HtmlView implements View {
//
//    private Controller controller;
//
//    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";
//
//    @Override
//    public void update(List<Vacancy> vacancies) {
//        System.out.println(vacancies.size());
//        updateFile(getUpdatedFileContent(vacancies));
//    }

//    @Override
//    public void setController(Controller controller) {
//        this.controller = controller;
//    }
//
//    public void userCitySelectEmulationMethod() {
//        controller.onCitySelect("Odessa");
//    }

//2. Реализуй метод getUpdatedFileContent(). Для начала, получи распарсеную страницу
//с помощью метода getDocument().

//Получи элемент, у которого есть класс template.
//Сделай копию этого объекта, удали из нее атрибут "style" и класс "template".
//Используй этот элемент в качестве шаблона для добавления новой строки в таблицу вакансий.

//    private String getUpdatedFileContent(List<Vacancy> vacancyList) {
//
//        String fileContent = null;
//        Document doc = null;
//
//        try {
//            doc = getDocument();
//
//            //Получи элемент, у которого есть класс template
//          //  Element elTemplate = doc.select(".template").first();
//            Element elTemplate = doc.getElementsByClass("template").first();
//
//            //Сделай копию этого объекта
//            Element elPattern = elTemplate.clone();
//
//            //удали из нее атрибут "style" и класс "template"
//            elPattern.removeClass("template").removeAttr("style");

//            elPattern.removeAttr("style");
//            elPattern.removeAttr("template");
//            elPattern.toggleClass("template");

//            doc.select("tr[class=vacancy]").remove();

//4. Удали из страницы все добавленные ранее вакансии с классом "vacancy".
//Элемент с классом "vacancy template" должен остаться.

//Удали все добавленные ранее вакансии. У них единственный класс "vacancy".
//В файле backup.html это одна вакансия - Junior Java Developer.
//Нужно удалить все теги tr, у которых class="vacancy".
//Но тег tr, у которого class="vacancy template", не удаляй.
//Используй метод remove.

            //Удали все добавленные ранее вакансии. У них единственный класс "vacancy".
//            doc.getElementsByAttributeValue("class", "vacancy").remove();

//5. Перед объектом template для каждой вакансии добавь на страницу отдельный html-элемент,
//используя копию template. Верни html-код всей страницы в качестве результата работы метода.

        //В цикле для каждой вакансии:
//            for (Vacancy vacancy : vacancyList) {

        //склонируй шаблон тега, полученного в п.2. Метод clone.
//                Element elVacancy = elPattern.clone();

//7. Для каждой вакансии должен быть корректно заполнен элемент с классом "city".

        //получи элемент, у которого есть класс "city". Запиши в него название города из вакансии.
//                elVacancy.getElementsByClass("city").first().text(vacancy.getCity());

//8. Для каждой вакансии должен быть корректно заполнен элемент с классом "companyName".

        //получи элемент, у которого есть класс "companyName". Запиши в него название компании из вакансии.
//                elVacancy.getElementsByClass("companyName").first().text(vacancy.getCompanyName());

//9. Для каждой вакансии должен быть корректно заполнен элемент с классом "salary".

        //получи элемент, у которого есть класс "salary". Запиши в него зарплату из вакансии.
//                elVacancy.getElementsByClass("salary").first().text(vacancy.getSalary());

        //получи элемент-ссылку с тегом a. Запиши в него название вакансии(title).
        //Установи реальную ссылку на вакансию вместо href="url".
//                Element link = elVacancy.getElementsByTag("a").first();

//6. Для каждой вакансии должен быть корректно заполнен элемент-ссылка
//с названием вакансии(title) и http-ссылкой на нее(href).

//                link.text(vacancy.getTitle());
//                link.attr("href", vacancy.getUrl());

        //добавь outerHtml элемента, в который ты записывал данные вакансии,
        //непосредственно перед шаблоном <tr class="vacancy template" style="display: none">
//                elTemplate.before(elVacancy.outerHtml());
//            }
        //Верни html код всего документа в качестве результата работы метода.
//            fileContent = doc.html();

//        } catch (Exception e) {
//10. В случае возникновения исключения, выведи его стек-трейс и верни!!! строку "Some exception occurred".
//            e.printStackTrace();
//            return "Some exception occurred";        }

//        doc.select("tr[class=vacancy]").remove();

//        return fileContent;
//    }

//Он принимает тело файла в виде строки. Нужно его записать в файл, который находится по пути filePath.
//Ты это хорошо умеешь делать, поэтому подробностей тут не будет.
//    private void updateFile(String fileContent) {
//        try {
//            BufferedWriter fWriter = new BufferedWriter(new FileWriter(filePath));
//            fWriter.write(fileContent);
//            fWriter.close();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//1. В классе HtmlView добавь метод protected Document getDocument()
//в котором распарси файл vacancies.html используя Jsoup.

//В HtmlView создай protected метод Document getDocument() throws IOException, в котором
//распарси файл vacancies.html используя Jsoup. Кодировка файла "UTF-8", используй поле filePath.
//     protected Document getDocument() throws IOException{
//        return Jsoup.parse(new File(filePath),"UTF-8");
//     }
//}
