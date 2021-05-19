package com.javarush.task.task38.task3811;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//1. должна быть публичная и доступна во время выполнения программы.
@Target(ElementType.TYPE)
public @interface Ticket {
    //3. должна содержать enum Priority c элементами LOW, MEDIUM, HIGH.
    public enum Priority {LOW, MEDIUM, HIGH}

    //4. должна содержать свойство priority - по умолчанию Priority.MEDIUM.
    Priority priority() default Priority.MEDIUM;

    //5. должна содержать свойство tags - массив строк, пустой по умолчанию.
    String[] tags() default {};

    //6. должна содержать свойство createdBy - строку, равную "Amigo" по умолчанию.
    String createdBy() default "Amigo";
}

//2. должна применяться только к новым типам данных.

