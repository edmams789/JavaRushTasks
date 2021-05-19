package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
1. Найти пример реализации паттерна Singleton с ленивой реализацией(lazy initialization).
Используй свой любимый поисковик(например google).
2. По образу и подобию в отдельных файлах создай три класса синглтона Sun, Moon, Earth.
3. Реализуй интерфейс Planet в классах Sun, Moon, Earth.
4. В статическом блоке класса Solution вызови метод readKeyFromConsoleAndInitPlanet.
5. Реализуй функционал метода readKeyFromConsoleAndInitPlanet:
5.1. С консоли считай один параметр типа String.
5.2. Если параметр равен одной из констант интерфейса Planet, создай соответствующий объект
и присвой его Planet thePlanet, иначе обнулить Planet thePlanet.


Требования:
1. Класс Sun не должен позволять создавать объекты своего типа извне класса.
2. Класс Sun должен содержать приватное статическое поле instance типа Sun.
3. В классе Sun должен быть реализован публичный статический метод getInstance
возвращающий значение поля instance.
4. Метод getInstance в классе Sun должен ВСЕГДА возвращать один и тот же объект.
5. Поле instance должно быть инициализировано после первого обращения к методу getInstance, но не раньше.
6. Класс Moon не должен позволять создавать объекты своего типа извне класса.
7. Класс Moon должен содержать приватное статическое поле instance типа Moon.
8. В классе Moon должен быть реализован публичный статический метод getInstance
возвращающий значение поля instance.
9. Метод getInstance в классе Moon должен ВСЕГДА возвращать один и тот же объект.
10. Поле instance должно быть инициализировано после первого обращения к методу getInstance, но не раньше.
11. Класс Earth не должен позволять создавать объекты своего типа извне класса.
12. Класс Earth должен содержать приватное статическое поле instance типа Earth.
13. В классе Earth должен быть реализован публичный статический метод getInstance
возвращающий значение поля instance.
14. Метод getInstance в классе Earth должен ВСЕГДА возвращать один и тот же объект.
15. Поле instance должно быть инициализировано после первого обращения к методу getInstance, но не раньше.
16. Метод readKeyFromConsoleAndInitPlanet должен быть вызван в статическом блоке класса Solution.
17. Метод readKeyFromConsoleAndInitPlanet должен считывать одну строку с клавиатуры.
18. Метод readKeyFromConsoleAndInitPlanet должен корректно обновлять значение переменной thePlanet
в соответствии с условием задачи.
19. Классы Sun, Moon и Earth должны быть созданы в отдельных файлах.
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {


        String s = reader.readLine();
        if (s.equals(Planet.SUN))
            thePlanet = Sun.getInstance();
        else if (s.equals(Planet.MOON))
            thePlanet = Moon.getInstance();
        else if (s.equals(Planet.EARTH))
            thePlanet = Earth.getInstance();
        else
            thePlanet = null;
    } catch (IOException e){

        }
    }
}


//public final class Singleton {
//    private Singleton() {}
//
//    private static class Holder {
//        private static final Singleton _instance = new Singleton();
//    }
//
//    public static Singleton getInstance() {
//        return Holder._instance;
//    }
//}

//Объект будет проинициализирован при первом вызове метода getInstance().
// То есть мы перенесли проблему с синхронизацией на уровень загрузчика классов (class loader).

//public final class Singleton {
//    private static volatile Singleton _instance = null;
//
//    private Singleton() {}
//
//    public static synchronized Singleton getInstance() {
//        if (_instance == null)
//            synchronized (Singleton.class) {
//                if (_instance == null)
//                    _instance = new Singleton();
//            }
//        return _instance;
//    }
//}