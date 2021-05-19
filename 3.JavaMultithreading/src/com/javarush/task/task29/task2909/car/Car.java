package com.javarush.task.task29.task2909.car;

import java.util.Date;
/*
Рефакторинг (12)
12.1. Объединение условных операторов.
12.1.1. Добавь внутренний метод, сообщающий, могут ли быть перевезены пассажиры boolean
canPassengersBeTransferred() в класс Car.
Метод должен возвращать true, если водитель доступен isDriverAvailable и есть топливо fuel.
12.1.2. Перепиши метод getNumberOfPassengersCanBeTransferred(), объединив условные операторы
(используй метод canPassengersBeTransferred()).
12.2. Объединение дублирующихся фрагментов в условных операторах. Перепиши метод startMoving(),
чтобы в нем не было повторяющихся вызовов функций.
12.3. Замена магического числа символьной константой. Замени магические числа в методе getMaxSpeed()
на константные переменные метода:
MAX_TRUCK_SPEED, MAX_SEDAN_SPEED и MAX_CABRIOLET_SPEED.
12.4. Замена условного оператора полиморфизмом.
12.4.1. Переопредели метод getMaxSpeed() в подклассах, избавившись от условного оператора.
12.4.2. Метод getMaxSpeed() в классе Car сделай абстрактным.


Требования:
1. Необходимо создать приватный метод boolean canPassengersBeTransferred() в классе Car и реализовать его.
2. Необходимо изменить метод getNumberOfPassengersCanBeTransferred(), объединив условные операторы
(используй метод canPassengersBeTransferred()).
3. Необходимо изменить метод startMoving(), чтобы в нем не было повторяющихся вызовов метода
fastenDriverBelt().
4. Необходимо переопределить метод getMaxSpeed() в классе Truck. В методе нужно использовать константную
переменную метода MAX_TRUCK_SPEED, значение которой равно 80.
5. Необходимо переопределить метод getMaxSpeed() в классе Sedan. В методе нужно использовать константную
переменную метода MAX_SEDAN_SPEED, значение которой равно 120.
6. Необходимо переопределить метод getMaxSpeed() в классе Cabriolet. В методе нужно использовать
константную переменную метода MAX_CABRIOLET_SPEED, значение которой равно 90.
7. Метод getMaxSpeed() в классе Car необходимо сделать абстрактным.
 */

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    public static final int MAX_TRUCK_SPEED = 80;
    public static final int MAX_SEDAN_SPEED = 120;
    public static final int MAX_CABRIOLET_SPEED = 90;

    double fuel; //топливо

    public double summerFuelConsumption; //Расход топлива летом
    public double winterFuelConsumption; //Расход топлива зимой
    public double winterWarmingUp; //прогрев зимой

    private int type;

    private boolean driverAvailable; //Доступный водитель
    private int numberOfPassengers; //количество пассажиров

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }
    public void fill(double numberOfLiters) throws Exception { // fill - заполнить, numberOfLiters - количество литров
        if (numberOfLiters < 0)
            throw new Exception();
        fuel += numberOfLiters;
    }
    public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
        return date.after(summerStart) && date.before(summerEnd) ;
    }
    public double getWinterConsumption(int length) { //length - расстояние
        return length * winterFuelConsumption + winterWarmingUp;
    }
    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }

    public static Car create(int type, int numberOfPassengers) {
        Car car;
        switch (type) {
            case Car.TRUCK: {
                car = new Truck(numberOfPassengers);
            }
            break;
            case Car.SEDAN: {
                car = new Sedan(numberOfPassengers);
            }
            break;
            case Car.CABRIOLET: {
                car = new Cabriolet(numberOfPassengers);
            }
            break;
            default: {
                car = null;
            }
        }
        return car;
    }
    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption; //потребление
        if (!isSummer(date, SummerStart, SummerEnd)) {
            consumption = getWinterConsumption(length);
        } else {
            consumption = getSummerConsumption(length);
        }
        return consumption;
    }
//12.1.2. Перепиши метод getNumberOfPassengersCanBeTransferred(), объединив условные операторы
//(используй метод canPassengersBeTransferred()).
//Требования:
//2. Необходимо изменить метод getNumberOfPassengersCanBeTransferred(), объединив условные операторы
//(используй метод canPassengersBeTransferred()).
    public int getNumberOfPassengersCanBeTransferred() { //получить количество пассажиров, которых можно перевести
//        if (!isDriverAvailable())
//            return 0;
//        if (fuel <= 0)
//            return 0;
//        return numberOfPassengers;

//        if (!isDriverAvailable() && fuel <= 0) return 0;//wrong
        if (!canPassengersBeTransferred())
            return 0;

        return numberOfPassengers;
    }
    public boolean isDriverAvailable() {
        return driverAvailable;
    }
    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }
//12.2. Объединение дублирующихся фрагментов в условных операторах. Перепиши метод startMoving(),
//чтобы в нем не было повторяющихся вызовов функций.
//Требования:
//3. Необходимо изменить метод startMoving(), чтобы в нем не было повторяющихся вызовов метода
//fastenDriverBelt().
    public void startMoving() {
//        if (numberOfPassengers > 0) {
//            fastenPassengersBelts();
//            fastenDriverBelt();
//        } else {
//            fastenDriverBelt();
//        }
        if (numberOfPassengers > 0) {
            fastenPassengersBelts(); //пристегните ремни пассажира
        }
        fastenDriverBelt(); //пристегнуть ремень безопасности
    }
    public void fastenPassengersBelts() {
    }
    public void fastenDriverBelt() {
    }
    public abstract int getMaxSpeed();
//    {
//        if (type == TRUCK)
//            return 80;
//        if (type == SEDAN)
//            return 120;
//        return 90;
//    }
//12.1.1. Добавь внутренний метод, сообщающий, могут ли быть перевезены пассажиры boolean
//canPassengersBeTransferred() в класс Car.
//Метод должен возвращать true, если водитель доступен isDriverAvailable и есть топливо fuel.
//Требования:
//1. Необходимо создать приватный метод boolean canPassengersBeTransferred() в классе Car и реализовать его.
    private boolean canPassengersBeTransferred() { //Пассажиры могут быть переведены
//        if (isDriverAvailable() && fuel > 0) //wrong
//            return true;
        return isDriverAvailable() && fuel > 0;
    }
}