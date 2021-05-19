package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
Инициализируй поле wheels используя данные из loadWheelNamesFromDB.
Выкинь исключение в случае некорректных данных.

Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.

Требования:
1. Enum Wheel в классе Solution менять нельзя.
2. Сигнатуры в классе Car менять нельзя.
3. Во время создания машины нужно вызвать метод loadWheelNamesFromDB.
4. В случае возврата неправильных данных о колесах, нужно кинуть исключение.
5. Инициализируй поле wheels полученными данными.
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here - начальные колеса здесь
            wheels = new ArrayList<>();
            String[] tmp = loadWheelNamesFromDB();
            if (tmp.length != 4) throw new IllegalArgumentException();
            else {
                for (int i = 0; i < tmp.length; i++)
                    wheels.add(Wheel.valueOf(tmp[i]));
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data - этот метод возвращает фиктивные данные
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }
    public static void main(String[] args) {
    }
}
//Неплохая задача. Не пойму, откуда столько ругани. С дуру начал писать вложенный цикл,
// сравнивая колёса в массиве с колёсами в enum! Потом дошло, что это глупость, нужное исключение само
// выбросится.
//
//wheels = new ArrayList<Wheel>();
//
//String[] tmp = loadWheelNamesFromDB();
//
//if (tmp.length!=4)
//    throw new IllegalArgumentException();
//else
//    for (int i = 0; i<tmp.length; i++)
//            wheels.add(Wheel.valueOf(tmp[i]));

//Для будущих поколений:
//1) Инициализируйте wheels
//2) Если количество колёс не соотвествует - выбросьте исключение.
//3) Просто добавьте в wheels колёса.