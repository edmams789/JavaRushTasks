package com.javarush.task.task36.task3601;

public class View {
    //Пожар Показать событие данных
    public void fireShowDataEvent() {
        Controller controller = new Controller();
      //  Model model = new Model();
        System.out.println(controller.onShowDataList());
    }
}
//Метод fireShowDataEvent() должен вызывать метод onShowDataList() у контроллера.