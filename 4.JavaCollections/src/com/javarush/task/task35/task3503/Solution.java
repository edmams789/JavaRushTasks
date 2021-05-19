package com.javarush.task.task35.task3503;

/* 
Несколько суперклассов для дженерика
Дан класс Solution, параметризированный T.
Ограничьте параметр T.
T должен быть наследником класса ClassForGenerics и одновременно реализовывать интерфейс InterfaceForGenerics.
Менять можно только класс Solution.

Требования:
1. Класс Solution должен быть параметризирован типом который является наследником класса ClassForGenerics
и одновременно реализовывать интерфейс InterfaceForGenerics.
2. Интерфейс InterfaceForGenerics не должен расширять другие интерфейсы.
3. Класс ClassForGenerics не должен поддерживать интерфейс InterfaceForGenerics.
4. Класс Solution не должен быть наследником класса ClassForGenerics.
*/
public class Solution<T extends ClassForGenerics & InterfaceForGenerics> {
    public static void main(String[] args) {
        Solution<TestClassGood> testClassSolution = new Solution<>();
        testClassSolution.check();

        //!!! Следующие оба варианта не должны работать, закомментируй их:
//        Solution<TestClassWrong1> wrong1Solution = new Solution<>();
//        wrong1Solution.check();
//
//        Solution<TestClassWrong2> wrong2Solution = new Solution<>();
//        wrong2Solution.check();
    }

    public void check() {
        System.out.println("Works!");
    }

    public static class TestClassGood extends ClassForGenerics implements InterfaceForGenerics {

    }

    public static class TestClassWrong1 extends ClassForGenerics {

    }

    public static class TestClassWrong2 implements InterfaceForGenerics {

    }

}
//Чтобы уменьшить зависимость от класса, я хочу отправить параметр (используя универсальный класс) в конструктор, который расширяет некоторый класс и реализует интерфейс, например
//
//public interface SomeInterface{
//    public void someMethod();
//}
//
//public class MyFragment extends Fragment implements SomeInterface{
//    //implementation
//}
//
////here is classs, that I need to create. T must extend Fragment and implements
////SomeInterface. But, I'm afraid, if I'll use MyFragment directly, it will create a
////dependence of SomeClass from MyFragment.
//
//public class SomeClass /*generic?*/ {
//    public SomeClass(T parent);
//}
//Является ли это возможным?
//
//Далее, используя мой класс T, я хочу создать представления, используя T.getActivity () в качестве Context.

/*
T должен расширить Fragment и реализовать SomeInterface

В этом случае вы можете объявить SomeClassследующее:

public class SomeClass<T extends Fragment & SomeInterface>
Это потребует, чтобы объект типа Tрасширялся Fragmentи реализовывался SomeInterface.

Далее, используя мой класс T, я хочу создать представления, используя T.getActivity () в качестве Context.

Я не знаком с Android, но если getActivity()объявлен открытый метод экземпляра, Fragmentтогда будет вполне
возможно вызвать его для экземпляра T, поскольку компилятор будет знать, что все Ts должны наследовать
этот метод.
 */