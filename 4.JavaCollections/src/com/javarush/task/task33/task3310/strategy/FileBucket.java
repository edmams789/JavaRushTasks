package com.javarush.task.task33.task3310.strategy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/*
Shortener (9)
Напишем еще одну стратегию, назовем ее FileStorageStrategy.
Она будет очень похожа на стратегию OurHashMapStorageStrategy, но в качестве ведер (англ. buckets) будут файлы.
Я знаю, ты знаешь о каких buckets идет речь, если нет - повтори внутреннее устройство HashMap.
9.1. Создай класс FileBucket в пакете strategy.
9.2. Добавь в класс поле Path path. Это будет путь к файлу.
9.3. Добавь в класс конструктор без параметров, он должен:
9.3.1. Инициализировать path временным файлом. Файл должен быть размещен в директории для временных файлов и иметь случайное имя.

Подсказка: Files.createTempFile.

9.3.2. Создавать новый файл, используя path. Если такой файл уже есть, то заменять его.
9.3.3. Обеспечивать удаление файла при выходе из программы.

Подсказка: deleteOnExit().

9.4. Добавь в класс методы:
9.4.1. long getFileSize(), он должен возвращать размер файла на который указывает path.
9.4.2. void putEntry(Entry entry) - должен сериализовывать переданный entry в файл. Учти, каждый entry может содержать еще один entry.
9.4.3. Entry getEntry() - должен забирать entry из файла. Если файл имеет нулевой размер, вернуть null.
9.4.4. void remove() - удалять файл на который указывает path.
Конструктор и методы не должны кидать исключения.

Требования:
1. В классе FileBucket должно быть создано поле path типа Path.
2. Конструктор без параметров класса FileBucket должен быть реализован в соответствии с условием задачи.
3. Метод getFileSize должен возвращать размер файла на который указывает path.
4. Метод putEntry должен сериализовывать полученный объект типа Entry в файл на который указывает path, чтобы получить OutputStream используй метод Files.newOutputStream.
5. Метод getEntry должен десериализовывать объект типа Entry из файл на который указывает path,
чтобы получить InputStream используй метод Files.newInputStream.
6. Метод remove должен удалять файл на который указывает path с помощью метода Files.delete().
 */
//9.1. Создай класс FileBucket в пакете strategy.
public class FileBucket {
//9.2. Добавь в класс поле Path path. Это будет путь к файлу.
    private Path path;
//9.3. Добавь в класс конструктор без параметров, он должен:
    public FileBucket() {
//9.3.1. Инициализировать path временным файлом.
// Файл должен быть размещен в директории для временных файлов и иметь случайное имя.
//Подсказка: Files.createTempFile.
        try {
            path = Files.createTempFile(null, null);
            Files.deleteIfExists(path);
//9.3.2. Создавать новый файл, используя path. Если такой файл уже есть, то заменять его.
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
//9.3.3. Обеспечивать удаление файла при выходе из программы.
//Подсказка: deleteOnExit().
        path.toFile().deleteOnExit();
    }
//9.4. Добавь в класс методы:
//9.4.1. long getFileSize(), он должен возвращать размер файла на который указывает path.
    public long getFileSize(){
        try {
            return Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
//9.4.2. void putEntry(Entry entry) - должен сериализовывать переданный entry в файл.
// Учти, каждый entry может содержать еще один entry.
    public void putEntry(Entry entry){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path))) {
            objectOutputStream.writeObject(entry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//9.4.3. Entry getEntry() - должен забирать entry из файла. Если файл имеет нулевой размер, вернуть null.
//Метод getEntry должен десериализовывать объект типа Entry из файл на который указывает path,
//чтобы получить InputStream используй метод Files.newInputStream.
    public Entry getEntry(){
        Entry entry = null;

        if (getFileSize() <= 0)
            return entry;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path))) {
            entry = (Entry) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return entry;
    }

//9.4.4. void remove() - удалять файл на который указывает path.
//Конструктор и методы не должны кидать исключения.
    public void remove(){
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
В классе HashMap метод hashCode() используется для вычисления корзины (bucket) и следовательно вычисления индекса.
Bucket -это единственный элемент массива HashMap. Он используется для хранения узлов (Nodes).
Два или более узла могут иметь один и тот -же bucket. В этом случае для связи узлов используется структура
данных связанный список. Bucket -ы различаются по ёмкости (свойство capacity). Отношение между bucket и
capacity выглядит следующим образом:

capacity = number of buckets * load factor

Один bucket может иметь более, чем один узел, это зависит от реализации метода hashCode().
Чем лучше реализованн ваш метод hashCode(), тем лучше будут использоваться ваши bucket -ы.
 */