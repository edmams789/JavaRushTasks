package com.javarush.task.task35.task3513;

import javax.swing.*;

/*
2048 (10)
Пора приступить к реализации метода main в классе Main, чтобы иметь возможность наконец-то запустить
игру и отдохнуть!

Метод main нам нужен только для того чтобы запустить приложение, все внутренности мы уже реализовали.
Для этого мы создадим в нем модель и контроллер, а также объект типа JFrame. Для примера я назову его
game, но ты можешь выбрать любое другое имя.

У нашей игры (объекта типа JFrame) мы должны будем вызвать некоторые методы для того чтобы все корректно
отображалось на экране:

game.setTitle("2048");
game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
game.setSize(450, 500);
game.setResizable(false);

game.add(controller.getView());


game.setLocationRelativeTo(null);
game.setVisible(true);

Обрати внимание на метод add в который мы передаем представление из контроллера. У нас еще нет геттера
для поля view в классе Controller. Не забудь его добавить.

P.S. Результатом выполнения этого задания будет рабочая версия игры 2048, если у тебя вдруг что-то не
работает, или работает не так как ожидалось, обязательно разберись и исправь прежде чем переходить к
следующим задачам.


Требования:
1. В классе Controller должен быть создан корректный геттер для поля view.
2. В методе main класса Main должна быть создана новая модель и контроллер на базе этой модели.
3. В методе main класса Main должен быть создан объект типа JFrame.
4. В методе main класса Main на объекте JFrame должны быть выполнены методы перечисленные в условии задачи.
 */
public class Main { //Main - будет содержать только метод main и служить точкой входа в наше приложение.
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        JFrame game = new JFrame();

        game.setTitle("2048");
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setSize(450, 500);
        game.setResizable(false);

        game.add(controller.getView());


        game.setLocationRelativeTo(null);
        game.setVisible(true);
    }
}
