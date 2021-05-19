package com.javarush.task.task27.task2708;

public class Apartment {
    private String location;
    private final RealEstate realEstate;

    public Apartment(RealEstate realEstate) {
        this.realEstate = realEstate;
        setLocation(String.valueOf(Math.random() * 10));
    }

    public synchronized String getLocation() {
        return location;
    }

    public synchronized void setLocation(String location) {
        this.location = location;
    }
//4. Метод revalidate класса Apartment должен быть объявлен без модификатора synchronized.
    public void revalidate(boolean isEmpty) {
        if (isEmpty)
            realEstate.up(this);
    }
}
