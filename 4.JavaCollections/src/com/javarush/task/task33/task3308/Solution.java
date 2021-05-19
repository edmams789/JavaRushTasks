package com.javarush.task.task33.task3308;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/* 
Создание класса по строке xml

Восстанови класс по переданной строке xml.
Класс должен быть в отдельном файле.
Метод getClassName должен возвращать восстановленный класс.
Метод main не участвует в тестировании.

Требования:
1. Класс Shop должен быть создан в отдельном файле.
2. В классе Shop должно быть создано поле goods типа Goods.
3. В классе Shop должно быть создано поле count типа int.
4. В классе Shop должно быть создано поле profit типа double.
5. В классе Shop должен быть создан массив строк secretData.
6. В классе Shop должен содержаться вложенный статический класс Goods.
7. В классе Shop.Goods должен быть создан список строк names.
8. Все поля класса Shop должны быть публичными.
9. Метод getClassName класса Solution должен возвращать класс Shop.
*/
public class Solution {
    public static void main(String[] args) throws JAXBException {
        String xmlData =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                        "<shop>\n" +
                        "    <goods>\n" +
                        "        <names>S1</names>\n" +
                        "        <names>S2</names>\n" +
                        "    </goods>\n" +
                        "    <count>12</count>\n" +
                        "    <profit>123.4</profit>\n" +
                        "    <secretData>String1</secretData>\n" +
                        "    <secretData>String2</secretData>\n" +
                        "    <secretData>String3</secretData>\n" +
                        "    <secretData>String4</secretData>\n" +
                        "    <secretData>String5</secretData>\n" +
                        "</shop>";

        StringReader reader = new StringReader(xmlData);

        JAXBContext context = JAXBContext.newInstance(getClassName());
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Object o = unmarshaller.unmarshal(reader);

        System.out.println(o.toString());
    }

    public static Class getClassName() {
        return Shop.class;  //your class name
    }
}
/*
Задача решается написание класса Shop.
Теперь разберемся с аннотациями
@XmlRootElement
@XmlType(name = "shop")

Говорит, что класс Shop главный элемент, который содержит в себе всё остальное
Все остальные поля аннотаций не требуют.
Однако стоит обратить внимание на СПИСОК names в под-классе Goods.
1. Если не отметить его никакими аннотациями, то содержимое списка не востановится при десериализации, другими словами код:
for (String goods : shop.goods.names)
{
    System.out.println(goods);
}

выдаст нам пустую строку.
Но стоит пометить лист @XmlElement, то десериализация пройдет как нужно.
2. Если у вас в классе Goods список names не будет инициализирован, то при десериализации он автоматически станет ArrayList, т.е. код
System.out.println(shop.goods.names.getClass());

выдаст строку
class java.util.ArrayList

Но стоит в классе Goods инициализировать список например new LinkedList<>(), то при десериализации получим список нужного типа и ранее приведенный код выведет:
class java.util.LinkedList


P.S. Всем добра :)
 */