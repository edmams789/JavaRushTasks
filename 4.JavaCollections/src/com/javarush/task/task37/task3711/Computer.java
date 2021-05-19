package com.javarush.task.task37.task3711;

public class Computer  {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void run() {
        cpu.calculate();
        memory.allocate();
        hardDrive.storeData();
    }

}
//1. В классе Computer должны быть созданы и инициализированы поля типов CPU, Memory и HardDrive.
//2. В методе run класса computer должны быть вызваны методы calculate, allocate и storeData у
// объектов CPU, Memory и HardDrive.