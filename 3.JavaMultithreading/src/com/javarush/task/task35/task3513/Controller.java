package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*

 */
//8.3. Сделай класс Controller потомком класса KeyAdapter.
public class Controller extends KeyAdapter { //Controller - будет следить за нажатием клавиш во время игры.
    private Model model;
    private View view;
//8.4. Добавь в класс Controller метод getGameTiles вызывающий такой же метод у модели.
    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }
//8.5. Добавь в класс Controller метод getScore возвращающий текущий счет (model.score).
    public int getScore() {
        return model.score;
    }
//Для начала нам понадобится конструктор, он будет принимать один параметр типа Model, инициализировать
// поле model, а также сохранять в поле view новый объект типа View с текущим контроллером(this) в
// качестве параметра конструктора.
//9.2. Конструктор класса Controller с одним параметром типа Model должен быть реализован в соответствии
// с условием задачи.
    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);
    }
//Далее, нам нужен метод resetGame, который позволит вернуть игровое поле в начальное состояние.
// Необходимо обнулить счет, установить флаги isGameWon и isGameLost у представления в false и вызывать
// метод resetGameTiles у модели.
//9.3. Метод resetGame должен возвращать игру в начальное состояние, как описано в условии задачи.
    public void resetGame() {
        model.score = 0;
        view.isGameWon = false;
        view.isGameLost = false;
        model.resetGameTiles();
    }
//Примечание: устанавливай значение полей напрямую, без использования сеттеров.
//Добавим приватную константу int WINNING_TILE = 2048. Она будет определять вес плитки при достижении
// которого игра будет считаться выигранной.
//9.1. В классе Controller должна быть создана приватная статическая константа int WINNING_TILE = 2048.
    private static int WINNING_TILE = 2048;
//Ну а теперь, самое главное! Для того чтобы иметь возможность обрабатывать пользовательский ввод,
// необходимо переопределить метод keyPressed с одним параметром типа KeyEvent.
    @Override
    public void keyPressed(KeyEvent event) {
//Логика метода должна быть следующей:
//1. Если была нажата клавиша ESC - вызови метод resetGame.
//9.4. Метод keyPressed должен вызывать метод resetGame в случае, если была нажата клавиша ESC.
        if (event.getKeyCode() == KeyEvent.VK_ESCAPE)
            resetGame();
//2. Если метод canMove модели возвращает false - установи флаг isGameLost в true.
//9.5. Метод keyPressed должен устанавливать флаг isGameLost в true в случае, если ход невозможен.
        if (!model.canMove())
            view.isGameLost = true;
//3. Если оба флага isGameLost и isGameWon равны false - обработай варианты движения:
        if (!view.isGameLost && !view.isGameWon) {
//9.6. Метод keyPressed должен вызывать корректные методы перемещения игрового поля, в случае если была
// нажата подходящая клавиша и оба флага isGameLost и isGameWon равны false.
//P.S. Для получения кода нажатой клавиши используй метод getKeyCode класса KeyEvent.
        switch (event.getKeyCode()) {
//а) для клавиши KeyEvent.VK_LEFT вызови метод left у модели;
            case KeyEvent.VK_LEFT:
                model.left();
                break;
//б) для клавиши KeyEvent.VK_RIGHT вызови метод right у модели;
            case KeyEvent.VK_RIGHT:
                model.right();
                break;
//в) для клавиши KeyEvent.VK_UP вызови метод up у модели;
            case KeyEvent.VK_UP:
                model.up();
                break;
//г) для клавиши KeyEvent.VK_DOWN вызови метод down у модели.
            case KeyEvent.VK_DOWN:
                model.down();
                break;
        }
    }
//4. Если поле maxTile у модели стало равно WINNING_TILE, установи флаг isGameWon в true.
//9.7. Метод keyPressed должен устанавливать флаг isGameWon равным true в случае, если значения полей
// model.maxTile и WINNING_TILE стали равны после передвижения.
        if (model.maxTile == WINNING_TILE)
            view.isGameWon = true;
//5. В самом конце, вызови метод repaint у view.
//9.8. Метод keyPressed должен вызывать метод repaint у объекта сохраненного в поле view.
            view.repaint();
//Также добавим в метод keyPressed класса Controller вызов метода rollback по нажатию на клавишу Z
// (код - KeyEvent.VK_Z).
//12.1. Метод keyPressed класса Controller должен вызывать метод rollback у модели в случае, если была
// нажата клавиша с кодом KeyEvent.VK_Z.
        if (event.getKeyCode() == KeyEvent.VK_Z)
            model.rollback();
//Не забудь добавить в метод keyPressed класса Controller вызов метода randomMove по нажатию
//на клавишу R (код - KeyEvent.VK_R).
//13.2. Метод keyPressed класса Controller должен вызывать метод randomMove у модели в случае,
//если была нажата клавиша с кодом KeyEvent.VK_R.
        if (event.getKeyCode() == KeyEvent.VK_R)
            model.randomMove();
//После реализации метода autoMove добавим его вызов в метод keyPressed класса Controller по нажатию
// на клавишу A (код - KeyEvent.VK_A).
//16.3. Метод keyPressed класса Controller должен вызывать метод autoMove у модели в случае, если была
// нажата клавиша с кодом KeyEvent.VK_A.
        if (event.getKeyCode() == KeyEvent.VK_A)
            model.autoMove();
    }
    public View getView() {
        return view;
    }
}
