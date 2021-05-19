package com.javarush.task.task29.task2908;

import java.util.concurrent.*;

/* Argument and Value are generic types*/
public class CacheComputeManager<Argument, Value> implements Computable<Argument, Value> {
    private final ConcurrentHashMap<Argument, Future<Value>> cache = new ConcurrentHashMap<>();
    private final Computable<Argument, Value> computable;

    public CacheComputeManager(Computable<Argument, Value> computable) {
        this.computable = computable;
    }

    @Override
    public Value compute(final Argument arg) throws InterruptedException {
        Future<Value> f = cache.get(arg);
        if (f == null) {
            FutureTask<Value> ft = createFutureTaskForNewArgumentThatHasToComputeValue(arg);
            cache.putIfAbsent(arg, ft);
            f = ft;
            ft.run();
            System.out.print(arg + " will be cached  ");
        } else {
            System.out.print(arg + " taken from cache  ");
        }
        try {
            return f.get();
        } catch (CancellationException e) {
            cache.remove(arg, f);
        } catch (ExecutionException e) {
            throw new RuntimeException(e.getCause());
        }
        return null;
    }
//создать будущую задачу для нового аргумента, который должен вычислять ценность (значение, стоимость)
    public FutureTask<Value> createFutureTaskForNewArgumentThatHasToComputeValue(final Argument arg) {

//return new FutureTask<>(() -> computable.compute(arg));
// ==
        return new FutureTask<>(new Callable<Value>() {
            @Override
            public Value call() throws Exception {
                return computable.compute(arg);
            }
        });
//
    }
}
//Для тех кто не понял зачем нужен FutureTask.
//При использовании Callable и Future, нам необходимо было для каждого объекта Callable создавать объект
// принимающий результат работы Future. Таким образом мы были вынуждены хранить и обрабатывать два списка:
// один список задач (Callable) и второй с результатами (Future). FutureTask позволяет одновременно
// контролировать запуск задачи, её состояние и результат всего одним объектом, который к тому же
// запускается на исполнение методом run() как объекта Runnable.
//Таким образом, создав объект Callable и поместив его в FutureTask, можно в дальнейшем работать в только
// с эти объектом не вспоминая о Callable вообще.
//
//Про интерфейсы http://java-online.ru/concurrent-callable.xhtml
//Про FutureTask http://java-online.ru/concurrent-future.xhtml

// - Никого не смущает что Argument и Value нигде не описаны?
// - это дженерики, вместо Argument и Value могли быть A, V, T, E и т.д.
// Компилятор не запрещает использовать осмысленные имена.

//тем кто надеялся решить одной строкой
//return new FutureTask<>(() -> computable.compute(arg));
//
//разворачиваем лямбду в анонимный класс (alt+enter), валидатор живет ещё во времена 7й джавы...

/*
есть интерфейс Computable, в котором есть метод compute ("вычислить")

есть специальный класс CacheComputeManager, который будет волшебным образом вычислять и хранить
в кэше(в нашем случаев мапе),то что ему передали (конструктор говорит, что передавать можно что угодно,
но помеченные интейфесо Computable)

для демонстрации нам нарисавали 2 класса:
1/ Square - смотрим на реализацию compute (Это просто квадрат числа)
2/ Copyright (тут возвразает строчка по типу "All rights reserved (c) 3012-3147", чтобы ее вывести
есть внутренний класс Period, куда мы передаем год начало, год конца))

теперь класс CashComputeManager:
1/ тут два поля:
computable - переданный объект
cash - мапа из пакета из util.concurrent.*; в которой готовые решения

2/ два метода:
метод compute
который либо берет из cash'a готовое решение (из мапы),
либо вычисляет

метод createFutureTaskForNewArgumentThatHaveToComputeValue
создает будущее для Callabe; (вычисляет)

- Зачем это все?
если какая-то операция выполняется значительное время, то, возможно, имеет смысл закэшировать её результат.
если же есть большая вероятность, что за результатом одной и той же операции приходит зразу несколько потоков практически одновременно,
и тем более если эта операция внутри может блокироваться, то надо сделать так,
чтобы операция выполнилась только один раз, и все потоки сразу получили этот результат
 */