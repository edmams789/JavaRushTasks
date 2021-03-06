package com.javarush.task.task30.task3008;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;

/*
Чат (5)
Клиент и сервер будут общаться через сокетное соединение.
Одна сторона будет записывать данные в сокет, а другая читать.
Их общение представляет собой обмен сообщениями Message.
Класс Connection будет выполнять роль обертки над классом java.net.Socket,
которая должна будет уметь сериализовать и десериализовать объекты типа Message в сокет.
Методы этого класса должны быть готовы к вызову из разных потоков.

Добавь в класс Connection:
1) Final поля:
а) Socket socket
б) ObjectOutputStream out
в) ObjectInputStream in

2) Конструктор, который должен принимать Socket в качестве параметра и инициализировать поля класса.
Для инициализации полей in и out используй соответствующие потоки сокета.
Конструктор может бросать исключение IOException.
Создать объект класса ObjectOutputStream нужно до того, как будет создаваться объект класса ObjectInputStream,
иначе может возникнуть взаимная блокировка потоков, которые хотят установить соединение через класс Connection.
Более подробно об этом ты можешь прочитать в спецификации класса ObjectInputStream.

3) Метод void send(Message message) throws IOException.
Он должен записывать (сериализовать) сообщение message в ObjectOutputStream.
Этот метод будет вызываться из нескольких потоков.
Позаботься, чтобы запись в объект ObjectOutputStream была возможна только одним потоком в
определенный момент времени,
остальные желающие ждали завершения записи.
При этом другие методы класса Connection не должны быть заблокированы.

4) Метод Message receive() throws IOException, ClassNotFoundException.
Он должен читать (десериализовать) данные из ObjectInputStream.
Сделай так, чтобы операция чтения не могла быть одновременно вызвана несколькими потоками,
при этом вызов других методы класса Connection не блокировать.

5) Метод SocketAddress getRemoteSocketAddress(), возвращающий удаленный адрес сокетного соединения.

6) Метод void close() throws IOException, который должен закрывать все ресурсы класса.

Класс Connection должен поддерживать интерфейс Closeable.


Требования:
1. Класс Connection должен поддерживать интерфейс Closeable.
2. В классе Connection должно быть создано private final поле socket типа Socket.
3. В классе Connection должно быть создано private final поле out типа ObjectOutputStream.
4. В классе Connection должно быть создано private final поле in типа ObjectInputStream.
5. В классе Connection должен быть создан конструктор с одним параметром типа Socket инициализирующий
поля класса в соответствии с условием задачи.
6. В классе Connection должен быть корректно реализован метод send c одним параметром типа Message.
7. В классе Connection должен быть корректно реализован метод receive без параметров.
8. Метод getRemoteSocketAddress класса Connection должен возвращать удаленный адрес сокетного соединения.
9. Метод close класса Connection должен закрывать потоки чтения, записи и сокетное соединение.
 */
public class Connection implements Closeable { //класс соединения между клиентом и сервером
    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }
//Метод void send(Message message) throws IOException.
//Он должен записывать (сериализовать) сообщение message в ObjectOutputStream.
//Этот метод будет вызываться из нескольких потоков.
//Позаботься, чтобы запись в объект ObjectOutputStream была возможна только одним потоком в
//определенный момент времени,
//остальные желающие ждали завершения записи.
//При этом другие методы класса Connection не должны быть заблокированы.
    public void send(Message message) throws IOException{
//Метод send не должен содержать модификатор synchronized в строке объявления
        synchronized (this.out) {
            out.writeObject(message);
        }
//Внутри метода send должен содержаться synchronized блок по объекту out, а в нем должен быть вызван
// метод writeObject на объекте out.
    }
//Метод Message receive() throws IOException, ClassNotFoundException.
//Он должен читать (десериализовать) данные из ObjectInputStream.
//Сделай так, чтобы операция чтения не могла быть одновременно вызвана несколькими потоками,
//при этом вызов других методы класса Connection не блокировать.
    public Message receive() throws IOException, ClassNotFoundException {
        synchronized (this.in) {
            return (Message) in.readObject();
        }
//Внутри метода receive должен содержаться synchronized блок по объекту in, а в нем должен быть вызван метод readObject на объекте in
//Метод receive не должен содержать модификатор synchronized в строке объявления
//Метод receive должен возвращать сообщение Message полученное из ObjectInputStream с помощью метод readObject.
    }
//Метод SocketAddress getRemoteSocketAddress(), возвращающий удаленный адрес сокетного соединения
    public SocketAddress getRemoteSocketAddress() {
        return socket.getRemoteSocketAddress();
//Метод getRemoteSocketAddress класса Connection должен возвращать удаленный адрес сокетного соединения
    }
    @Override
    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
//Метод close класса Connection должен закрывать потоки чтения, записи и сокетное соединение
    }
}
