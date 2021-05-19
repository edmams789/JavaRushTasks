package com.javarush.task.task25.task2515;

import java.util.List;

public class SpaceShip extends BaseObject {
    public SpaceShip(double x, double y) {
        super(x, y, 3);
    }
    private double dx = 0;
    public void moveLeft() {
        dx = -1;
    }
    public void moveRight() {
        dx = 1;
    }
    public void move() {
        x += dx;
        checkBorders(x - radius, x + radius, y - radius, y + radius);
    }
    public void draw(Canvas canvas) {

    }
    public void fire() {
        Space.game.getRockets().add(new Rocket(x - 2, y));
        Space.game.getRockets().add(new Rocket(x + 2, y));
    }
}
