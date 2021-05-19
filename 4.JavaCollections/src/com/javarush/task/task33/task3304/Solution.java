package com.javarush.task.task33.task3304;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Конвертация из одного класса в другой используя JSON
НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.6.1

Два класса имеют одинаковые поля, но не имеют общий суперкласс. Пример, классы First и Second.
Реализовать логику метода convertOneToAnother, который должен возвращать объект класса resultClassObject,
значения полей которого равны значениям полей в объекте one.
Используй объект типа ObjectMapper.
Известно, что у классов есть JSON аннотация, у которой значение property равно имени класса в нижнем регистре.
На примере класса First, это className="first"
Классы First и Second не участвуют в тестировании, они предоставлены в качестве тестовых данных.

Требования:
1. Метод convertOneToAnother должен возвращать объект класса resultClassObject значения полей которого
равны значениям полей объекта one.
2. В методе convertOneToAnother должен быть создан объект типа ObjectMapper.
3. Метод convertOneToAnother должен быть статическим.
4. Метод convertOneToAnother должен быть публичным.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.USE_ANNOTATIONS);

        return mapper.convertValue(one, resultClassObject);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=First.class,  name="first"))
    public static class First {
        public int i;
        public String name;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=Second.class, name="second"))
    public static class Second {
        public int i;
        public String name;
    }
}
/*
Задачка для меня вообще показалась сложной(((
Для тех кто не доконца понимает что от него хотят в задании:
в метод передаются объект одного класса который нужно будет "преобразовать" и класс в который нужно будет
преобразовать переданный объект. Известно что при сериализации оба класса будут иметь одинаковое по названию
свойство (в данном случае - className="first"). Доступа к исходникам данных классов у нас якобы нет,
по этому менять/добавлять/убирать аннотации Json мы не можем.
   В общем нужно в методе convertOneToAnother(Object one, Class resultClassObject)  используя только
   переданные аргументы и если нужно будет, то использовать то что при сериализации у объектов будет
   поле className.

   Если читать комменты ниже, то в итоге можно наткнуться как на подсказку, так и на готовое решение.
   У меня приняло вариант "отключения аннотаций". Но так же ниже использовал готовый рабочий вариант
   буквально "подмены значения поля className в строке - результате сериализации объекта, с последующей
   десериализацией как обычно".
 */
/*
Ребята парсить строку и менять прередаваемые данные это колхоз.
Достаточно дать понять мапперу, что при сериализации аннотации у классов учитывать не надо.
Для этого у ObjectMapper есть метод disable() c кучей интересных ключей.
Советую ознакомиться. Чтение перечня этих ключей пронзает душу и позволяет понять с каким количеством костылей
пришлось смириться авторам библиотеки, чтобы сделать ее по настоящему кроссплатформенной. :)
 */