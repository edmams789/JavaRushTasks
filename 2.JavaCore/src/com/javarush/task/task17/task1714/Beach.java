package com.javarush.task.task17.task1714;

/* 
Comparable

Реализуйте интерфейс Comparable<Beach> в классе Beach. Пляжи(Beach) будут использоваться нитями,
поэтому позаботьтесь, чтобы все методы были синхронизированы.
Реализовать метод compareTo так, чтобы он при сравнении двух пляжей выдавал число,
которое показывает что первый пляж лучше (положительное число)
или второй пляж лучше (отрицательное число), и насколько он лучше.


Требования:
1. Класс Beach должен содержать три поля: String name, float distance, int quality.
2. Класс Beach должен реализовывать интерфейс Comparable<Beach>.
3. Метод compareTo класса Beach как минимум должен учитывать качество пляжа и дистанцию.
4. Все методы класса Beach, кроме метода main, должны быть синхронизированы.
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }
    public synchronized String getName() {
        return name;
    }
    public synchronized void setName(String name) {
        this.name = name;
    }
    public synchronized float getDistance() {
        return distance;
    }
    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }
    public synchronized int getQuality() {
        return quality;
    }
    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }
        @Override
    public synchronized int compareTo(Beach a){

        return Integer.compare(quality, a.quality) - Float.compare(distance, a.distance);
    }
    public static void main(String[] args) {
        Beach a = new Beach("a", 150, 5);
        Beach b = new Beach("b", 100, 3);

        int i = a.compareTo(b);
        System.out.println(i);
    }
}
//просто взрыв мозга,
//решение в одну строчку "return Integer.compare(quality, a.quality) - Float.compare(distance, a.distance);"
//но 5 попыток, чтобы понять, что валидатор принимает решение только с "-"
//но как ? например при таких пляжах
//
//Beach a = new Beach("a", 16, 9 );
//Beach b = new Beach ("b", 15, 2);
//
//System.out.println(a.compareTo(b));   -> = 0
//System.out.println(b.compareTo(a));  -> =  0
//
//как они могут быть равны ? я лучше проеду доп 1 км, на пляж с рейтингом 9!

//public static void main(String[] args) {
//    // для понимания вот вам 2 пляжа
//    // beach1 за 100 метров и качеством 5
//    // beach2 за 101 метр и качеством 4
//    Beach beach1 = new Beach("b1", 100, 5);
//    Beach beach2 = new Beach("b2", 101, 4);
//
//    int i = beach1.compareTo(beach2);
//    // узнаем сравнением beach1 К beach2
//
//    System.out.println(i);
//    // выводим в консоль, чтобы понять на ск-ко лучше, на 2.
//}