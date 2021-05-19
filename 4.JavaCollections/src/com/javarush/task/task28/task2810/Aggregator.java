package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.HHStrategy;
import com.javarush.task.task28.task2810.model.Model;
import com.javarush.task.task28.task2810.model.MoikrugStrategy;
import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.view.HtmlView;

/*

 */
public class Aggregator {
    public static void main(String[] args) {
//3. Для запуска нужно еще обновить метод main в Aggregator.
//3.1. Создай вью, модель, контроллер.
        HtmlView view = new HtmlView();

        Provider provider = new Provider(new HHStrategy());
        Provider providerMoikrug = new Provider(new MoikrugStrategy());

        Model model = new Model(view, provider, providerMoikrug);
    //    Model model = new Model(view, new Provider(new HHStrategy()));
        Controller controller = new Controller(model);
//3.2. Засэть во вью контроллер.
        view.setController(controller);
//3.3. Вызови у вью метод userCitySelectEmulationMethod.
        view.userCitySelectEmulationMethod();
    }
}
