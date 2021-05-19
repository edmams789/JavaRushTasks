package com.javarush.task.task36.task3609;

public class CarModel {
    private String brand;
    private String model;
    private int speed;
    private int maxSpeed;

//    public void increaseSpeed(int seconds) {
//        if (speed < maxSpeed) {
//            speed += (3.5 * seconds);
//        }
//        if (speed > maxSpeed) {
//            speed = maxSpeed;
//        }
//    }
//
//    public void decreaseSpeed(int seconds) {
//        if (speed > 0) {
//            speed -= (12 * seconds);
//        }
//        if (speed < 0) {
//            speed = 0;
//        }
//    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}

/*
Задача извращает ваши неокрепшие знания о MVC.
По требованиям условия и валидатора можно решить что надо в лоб перенести методы в контроллер.
Не надо так делать!
Бизнес логика должна остаться в модели!
Переименуйте методы в модели например в setSpeedUp и setSpeedDown.
Вызовите их в контроллере, будут волки сыты, овцы целы.
 */
