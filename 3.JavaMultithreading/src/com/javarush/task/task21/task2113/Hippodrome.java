package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
Ипподром(16)
Теперь уже точно все.

Добавь вызов метода printWinner в конец метода main.

Запускай и любуйся своей первой компьютерной игрой :)


Требования:
1. Метод printWinner должен быть вызван в методе main после метода run.
 */

public class Hippodrome {
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    static Hippodrome game;

    public static void main(String[] args) throws InterruptedException {

        game = new Hippodrome(new ArrayList<>());

        Horse A = new Horse("лошадь A", 3, 0);
        Horse B = new Horse("лошадь B", 3, 0);
        Horse C = new Horse("лошадь C", 3, 0);

        game.horses.add(A);
        game.horses.add(B);
        game.horses.add(C);

        game.run();

        game.printWinner();
    }

    public List<Horse> getHorses() {
        return horses;
    }

    private List<Horse> horses;

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }

    }
    public void move(){
        horses.forEach(Horse::move);
    }
    public void print(){
        horses.forEach(Horse::print);
        for (int i = 0; i < 10; i++)
            System.out.println();
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public Horse getWinner(){
       // return horses.stream().max(Comparator.comparing(Horse::getDistance)).orElse(null);
        return horses.stream().max(Comparator.comparing(Horse::getDistance)).get();
    }



}
