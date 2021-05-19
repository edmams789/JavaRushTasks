package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Зависимость придумать самому.
Метод должен определять, выиграли ли мы (this) бой или нет,
т.е. возвращать true, если выиграли и false - если нет.

Должно выполняться условие:
если cat1.fight(cat2) возвращает true,
то cat2.fight(cat1) должен возвращать false

Требования:
1. Класс Cat должен содержать конструктор без параметров.
2. Класс Cat должен содержать всего три поля: age, weight и strength.
Поля должны быть публичные.
3. В классе Cat должен быть метод fight.
4. В методе fight реализовать механизм драки котов в зависимости от их веса,
возраста и силы.
5. Метод должен возвращать одно и тоже значение, если мы деремся с одним и тем же котом.
6. Если некий кот1 выигрывает у кота кот2, то кот2 должен проигрывать коту кот1.
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }
    public boolean fight(Cat anotherCat) {

        int ageAdvantage = this.age > anotherCat.age ? 1 : 0;
        int weightAdvantage = this.weight > anotherCat.weight ? 1 : 0;
        int strengthAdvantage = this.strength > anotherCat.strength ? 1 : 0;

        int score = ageAdvantage + weightAdvantage + strengthAdvantage;
        return score > 2 ? true : false;             //напишите тут ваш код
    }
        public static void main(String[] args) {
    }}
