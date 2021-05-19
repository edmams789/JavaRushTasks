package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
1. Даны IP-адрес и маска подсети, необходимо вычислить адрес сети - реализуй метод getNetAddress.
Используйте операцию поразрядной конъюнкции (логическое И).

Пример:
IP-адрес: 11000000 10101000 00000001 00000010 (192.168.1.2)
Маска подсети: 11111111 11111111 11111110 00000000 (255.255.254.0)
Адрес сети: 11000000 10101000 00000000 00000000 (192.168.0.0)

2. Реализовать метод print, который выведет в консоль данные в двоичном коде. Для IP-адреса(192.168.1.2)
должна быть выведена строка "11000000 10101000 00000001 00000010"
3. Метод main не участвует в тестировании


Требования:
1. Метод getNetAddress должен вычислять и возвращать адрес сети согласно переданным параметрам
(IP-адрес и маска подсети).
2. Метод getNetAddress должен быть статическим и публичным.
3. Метод print должен быть статическим и публичным.
4. Метод print должен преобразовывать переданный ему IP адрес в двоичный код и выводить на экран(как в условии).
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        return new byte[]{
            (byte)(ip[0] & mask[0]),
            (byte)(ip[1] & mask[1]),
            (byte)(ip[2] & mask[2]),
            (byte)(ip[3] & mask[3])

        };
    }

    public static void print(byte[] bytes) {
        System.out.println(Integer.toBinaryString(bytes[0] | -512).substring(24)
                   + " " + Integer.toBinaryString(bytes[1] | -512).substring(24)
                   + " " + Integer.toBinaryString(bytes[2] | -512).substring(24)
                   + " " + Integer.toBinaryString(bytes[3] | -512).substring(24));
    }
}
//public static byte[] getNetAddress(byte[] ip, byte[] mask) {
//    return new byte[]{
//             (byte)(ip[0] & mask[0])
//            ,(byte)(ip[1] & mask[1])
//            ,(byte)(ip[2] & mask[2])
//            ,(byte)(ip[3] & mask[3])
//    };
//}
//public static void print(byte[] bytes) {
//    System.out.println(
//                 Integer.toBinaryString(bytes[0] | -512).substring(24)
//            +" "+Integer.toBinaryString(bytes[1] | -512).substring(24)
//            +" "+Integer.toBinaryString(bytes[2] | -512).substring(24)
//            +" "+Integer.toBinaryString(bytes[3] | -512).substring(24)
//    );
//}
//512 это 1000000000 в двоичной. Число удобно тем, что имеет 9 нулей.
// Удобно склеивать не нарушая результат. int имеет 32 разряда, но первые нули отбрасываются, поэтому,
// чтобы оставить в длинном представлении нужно, чтобы /\евый разряд был единицей. Поскольку он знаковый,
// то ставим -512 И получается, что это равно 10000000000000000000001000000000 В Java в отрицательных
// числах /\евые биты представляются единицами. Поэтому выведя -512 в консоль мы увидим в представлении:
// 11111111111111111111111000000000 Теперь через побитовое "или" можно склеивать короткое 11000000
// (как пример) и длинное -512: Получается: 00000000000000000000001100000000 (левая часть условно
// дописывается нулями при операции) 11111111111111111111111000000000 =================================
// 11111111111111111111111100000000 Склеивание с длинным числом дает нам привести число, например 2,
// которое в двоичном равно 10, к длинному виду 11111111111111111111111000000010 И теперь через
// substring отбрасываем первые 24 бита, чтоб выглядело как требуют в задаче. Вот и всё.