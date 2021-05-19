package com.javarush.task.task22.task2201;

public class StringForFirstThreadTooShortException extends RuntimeException {
}
//ВАЖНО:
//В классах исключений (именно в тех, которые открываются в новом окне) с помощью alt+ins вставляла метод getCause() и добавляла туда StringIndexOutOfBoundsException
//public class StringForFirstThreadTooShortException extends RuntimeException {
//    @Override
//    public synchronized Throwable getCause() {
//        return new StringIndexOutOfBoundsException("String index out of range: -1");
//    }
//}
//</code