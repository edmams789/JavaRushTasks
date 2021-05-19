package com.javarush.task.task29.task2909.car;

public class Truck extends Car {
    public Truck(int numberOfPassengers) {
        super(Car.TRUCK, numberOfPassengers);
    }
//12.3. Замена магического числа символьной константой. Замени магические числа в методе getMaxSpeed()
//на константные переменные метода:
//MAX_TRUCK_SPEED, MAX_SEDAN_SPEED и MAX_CABRIOLET_SPEED.
//Требования:
// 4. Необходимо переопределить метод getMaxSpeed() в классе Truck. В методе нужно использовать константную
//переменную метода MAX_TRUCK_SPEED, значение которой равно 80.
    @Override
    public int getMaxSpeed() {
        return Car.MAX_TRUCK_SPEED;
    }
}
