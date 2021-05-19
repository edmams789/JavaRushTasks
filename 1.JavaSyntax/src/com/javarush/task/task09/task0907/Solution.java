package com.javarush.task.task09.task0907;

/* 
Исключение при работе с числами
Перехватить исключение, возникающее при выполнении кода:
int a = 42 / 0;
Вывести на экран тип перехваченного исключения.


Требования:
1. Программа должна выводить сообщение на экран.
2. В программе должен быть блок try-catch.
3. Программа должна отлавливать исключения конкретного типа, а не все возможные (Exception).
4. Выведенное сообщение должно содержать тип возникшего исключения.
5. Имеющийся код в методе main не удалять.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        {
            try {
                int a = 42 / 0;
                System.out.println(a);
                //напишите тут ваш код
            } catch (ArithmeticException e) {
                System.out.println("ArithmeticException has been caught");
            }
        }




    }
}

//public class ExceptionExample2
//{
//    public static void main(String[] args)
//    {
//        System.out.println("Program starts");
//
//        try
//        {
//            System.out.println("Before method1 calling");
//            method1();
//            System.out.println("After method1 calling. Never will be shown");
//        }
//        catch (Exception e)
//        {
//           System.out.println("Exception has been caught");
//        }
//
//        System.out.println("Program is still running");
//    }
//
//    public static void method1()
//    {
//        int a = 100;
//        int b = 0;
//        System.out.println(a / b);
//    }
//}