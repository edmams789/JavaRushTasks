package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправь ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.

Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные - writeObject
3) сериализовать класс Solution - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5

Требования:
1. Поле stream должно быть объявлено с модификатором transient.
2. В методе writeObject(ObjectOutputStream out) не должен быть вызван метод close у потока
полученного в качестве параметра.
3. В методе readObject(ObjectInputStream in) не должен быть вызван метод close у потока
полученного в качестве параметра.
4. В методе readObject(ObjectInputStream in) поле stream должно быть инициализировано новым объектом
типа FileOutputStream с параметрами(fileName, true).
5. В конструкторе класса Solution поле stream должно быть инициализировано новым объектом
типа FileOutputStream с параметром(fileName).
*/
public class Solution implements Serializable, AutoCloseable {
//1. Поле stream должно быть объявлено с модификатором transient.
    transient private FileOutputStream stream;
    private String fileName;
//5. В конструкторе класса Solution поле stream должно быть инициализировано новым объектом
//типа FileOutputStream с параметром(fileName).
    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\r\n".getBytes());
        stream.flush();
    }
//2. В методе writeObject(ObjectOutputStream out) не должен быть вызван метод close у потока
//полученного в качестве параметра.
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
      //  out.close();
    }
//3. В методе readObject(ObjectInputStream in) не должен быть вызван метод close у потока
//полученного в качестве параметра.
//4. В методе readObject(ObjectInputStream in) поле stream должно быть инициализировано новым объектом
//типа FileOutputStream с параметрами(fileName, true).
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
//        in.close();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution("C:\\Users\\Александр\\Desktop\\fileTwo.txt");
        solution.writeObject("SomeTextHElloWORLD");

        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);
        oos.writeObject(solution);

    }
}
//Кароч, забудьте всё что вы прочитали до этого по этой задаче - сейчас я вам раскидаю всё по полочкам.
//
//Проблема:
//Мы не можем сериализовать текущий объект класса Solution, потому что FileOutputStream не является
// сериализуймым.
//
//Подготовка:
//1. Добавьте полю stream модификатор transient - исключим его, иначе будет ругаться на это поле.
//2. Методы close() в writeObject, readObject надо убрать - если оставить получим
// java.io.IOException: Stream Closed - кто знает почему - отпишитесь!
//3. Поправить строчку - вы же на винде и хотите чтобы строки корректно переносились.
//stream.write("\r\n".getBytes());
//
//
//Далее задача звучит следующим образом:
//необходимо сериализовать и десериализовать объект класса Solution, который содержит не сериализуемое
// поле stream - при этом чтобы поток сохранился и мы могли с ним работать.
//Hint: надо хранить просто имя файла, а при чтение объекта в методе readObject восстановить переменную
// stream, которая после десериализации равна null, чтобы можно было продолжить писать в файл.
//1) Добавляем поле:
//private String fileName;
//2) Инициализируем его в конструкторе
//this.fileName = fileName;
//3) Восстанавливаем в методе readObject, с модификатором append = true, чтобы файл не перезаписывался.
//stream = new FileOutputStream(fileName, true);
//Важно уточнение: не запутайтесь - сериализация и десериализация это одно, а поток который мы храним
// в Solution это совсем другое - и к сериализации он не имеют отношения.

//в лекциях была ссылка на статью про рефлексию - очень занятное чтиво. Из stream можно вытащить приватное поле path следующим образом:
//
//Field field = FileOutputStream.class.getDeclaredField("path");
//field.setAccessible(true);
//String path = (String) field.get(stream);
//
//Но, как ни странно, такой вариант валидатор не принимает - нужно создать специально обученный String,
// хранящий имя файла.

//тут проблема не в том что поток private - а в том что он не Serializable.

//чередная задача, где сначала бесишься, что не можешь догнать что требуют
//а затем пишешь проверочный код и начинаешь разбираться что к чему
//не сразу дошло что у stream и у ObjectOutputStream разные файлы для сохранения данных
//
//        Solution sol = new Solution("file1.txt"); // в этот файл пишем нашу строку
//        sol.writeObject("Это данные");            // методом writeObject(String string)
//
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.txt")); // а в
//        этот файл сериализуются данные класса Solution

//Ребят, что-то у вас с пониманием ноль какой-то. Попытаюсь объяснить:
//В сериализуемом классе могут быть служебные методы чтения и записи, вы их работой почти не управляете
// (ну, кроме описания что дополнительно синхронизовать), вы их вручную не вызываете,
// они вызываются автоматически, при синхронизации объекта java машиной, а не вами.
//
//Вам надо просто сериализовать объект, например так:
//ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\test.txt"));
//oos.writeObject(solution);
//
//Вам не надо вызывать метод writeObject у solution (solution.writeObject) - это сделает сама java
// машина, вы вызываете специальный одноимённый метод потока writeObject, куда передаёте сериализуемый
// объект. А сама машина уже передаст этот поток дальше внутрь объекта.
//Потому и нельзя закрывать потоки внутри объекта типа out.close(); что этим прервётся работа внешнего
// потока, и сериализация не отработает. То есть в данной задачи вызовы in.close(); и out.close();
// и призваны, чтобы вы поковырялись,

//Простыми словами, что от нас хотят:
//Необходимо сериализовать обьект класса Solution таким образом, чтобы после десериализации также
// был восстановлен и FileOutputStream stream и указывал на тот же самый файл.
//Вопросы:
//1) Зачем нужен метод public void writeObject(String string) ?
//Чтобы просто тупо записать какие-нибудь данные в наш файл до сериализации. А уже после десериализации
// мы должны зайти в этот же самый файл и проверить, чтобы наш поток FileOutputStream stream,
// который мы восстановили, отработал. =>
// => 2)Как узнать что он отработал ?
//Для этого, нам нужно записать снова какие нибудь данные в наш файл, да не просто записать, а так
// чтобы они добавились к уже существующим ранее (в тот же самый файл).
//Вот к примеру объект до сериализации, соответсвенно в файле будет это строчка:
//Solution sol = new Solution("/Users/s3r3n1ty/Desktop/Text.txt");
//       sol.writeObject("SomeTextHElloWORLD");
//
//Ну а уже после десириализации, получив новый обьект мы напишем например:
//sol2.writeObject("WellDone from sol2 object");
//
//Итого в файле будет две эти строчки, это будет означать, что мы наш обьект и поле-поток восстановили
// корректно. Для проверки я пользовался ByteArrayOutputStream, записав обьект в него и восстановив
// уже из массива байтов после.
//ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
//       ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);
//       oos.writeObject(sol);
//Как же нам восстановить наш поток FileOutputStream в уже новом обьекте, если поле stream не
// сериализуемо, мы пометитили его как transient:
//Нужно создать "какое-то" еще одно поле в классе, чтобы в методе readObject мы могли корректно
// поднять новый поток к тому нашему файлу.
//private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//      in.defaultReadObject();
//      stream = new FileOutputStream(fileName,true); }
//
//Зачем нам нужен интерфейс AutoCloseable ? Попробуйте зайти внутрь него и посмотреть какой метод
// там лежит. У нас есть приватное поле-поток, а его нужно закрыть.