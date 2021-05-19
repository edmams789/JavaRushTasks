package com.javarush.task.task25.task2509;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public abstract class SocketTask<T> implements CancellableTask<T> {
    private Socket socket;

    protected synchronized void setSocket(Socket socket) {
        this.socket = socket;
    }

    public synchronized void cancel() {
        //close all resources here - закройте все ресурсы здесь
        try {
            socket.close();
        } catch (IOException e){

        }
    }

    public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this) {
            public boolean cancel(boolean mayInterruptIfRunning) {
                //close all resources here by using proper SocketTask method
                // закрываем все ресурсы, используя правильный метод SocketTask
                //call super-class method in finally block
                // вызов метода суперкласса в блоке finally
        try {
            socket.close();

        } catch (IOException e) {

        } finally {
            super.cancel(true);
        }

//Проверь, закрываешь ли ты ресурсы класса SocketTask.
                return false;
            }
        };
    }
}
//Для решения задачи достаточно посмотреть доки по классу Socket (3 метода, закрывающих ресурсы)
// и по классу FutureTask (1 метод).
//
//Socket - хранит IP-адрес и номер порта, умеет устанавливать соединение и предоставляет входной
// и выходной поток (http://www.quizful.net/post/java-socket-programming)
//
//ThreadPoolExecutor - создает трэды и позволяет их использовать много раз для разных задач.
// Операция создания трэда очень дорогостоящая, поэтому выгодно использовать их многократно.
// Например, надо выполнить 100 задач. Если создавать 100 трэдов, то это большой расход ресурсов.
// Можно создать пул из 10 трэдов, передать туда 100 задач и эти 100 задач будут выполняться на 10 трэдах
// в порядке очередности.
//http://wikijava.it-cache.net/index.php@title=Glava_17_Thinking_in_Java_4th_edition.html (от начала до
// раздела "Исполнители" включительно)
//Callable - более сложный аналог Runnable, который умеет возвращать результат работы трэда.
// Результат возвращается экзекутором в виде не самого результата, а объекта Future.
// Чтобы получить непосредственный результат, надо вызвать метод get() у объекта Future - при этом
// программа остановится и будет ждать до тех пор, пока результат не будет получен (т.е. get - это join()
// с результ-ом).
//http://wikijava.it-cache.net/index.php@title=Glava_17_Thinking_in_Java_4th_edition.html
// (раздел "Возврат значений из задач").
//
//RunnableFuture (он же FutureTask в качестве реализации) - это Future с методом run().
// Т.е. объект Future сам что-то вычисляет в отдельном трэде, сам же выдает результат через get().
// Как я понял, это нужно если мы хотим получать результат из самого объекта, а не через экзекутер.
// И плюс в своем FutureTask можно переопределить метод cancel(), чтобы отменять задачу корректно.
//https://coderanch.com/t/619322/java/RunnableFuture-good-case
//
//Усвоив все это, смысла задачи так и не понял :(