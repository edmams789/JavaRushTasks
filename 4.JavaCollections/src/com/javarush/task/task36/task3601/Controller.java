package com.javarush.task.task36.task3601;

import java.util.List;

public class Controller {
//на Показать список данных
    public List<String> onShowDataList() {
        Model model = new Model();
        return model.getStringDataList();
    }
}
//Метод onShowDataList() должен быть перенесен в класс Controller.