package com.javarush.task.task15.task1530;

abstract class DrinkMaker {

   abstract void getRightCup(); // - выбрать подходящую чашку
   abstract void putIngredient(); //  - положить ингредиенты
   abstract void pour(); // - залить жидкостью

   public void makeDrink() {
      getRightCup();
      putIngredient();
      pour();
   }
}
