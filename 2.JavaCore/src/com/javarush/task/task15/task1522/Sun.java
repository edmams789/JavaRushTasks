package com.javarush.task.task15.task1522;

public class Sun implements Planet {
    private static Sun instance; // #1. – Нужно добавить в класс приватное статическое поле,
    // содержащее одиночный объект:
    private Sun(){} // #2. – Сделать конструктор класса (конструктор по-умолчанию) приватным
    // (чтобы доступ к нему был закрыть за пределами класса, тогда он не сможет возвращать новые объекты):
    public static Sun getInstance(){ // #3
        if(instance == null){		//если объект еще не создан
            instance = new Sun();	//создать новый объект
        }
        return instance;		// вернуть ранее созданный объект
    }
}

