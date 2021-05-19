package com.javarush.task.task40.task4005;


import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/* 
Сокетный сервер и клиент

Есть сервер, он принимает входящие сообщения от клиентов и отвечает им echo.
Есть клиенты, они считывают сообщения с клавиатуры и отправляют их серверу.
Программа запускается, но не работает.
Разберись в чем проблема, внеси минимальные изменения в код, чтобы все заработало.

Требования:
1. Класс Client не изменяй.
2. Класс Server не изменяй.
3. Внеси необходимые изменения в класс Connection.
4. Поля в классе Connection не изменяй.
*/

public class Connection implements Closeable {
    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;


    public Connection(Socket socket) throws Exception {
        this.socket = socket;
        this.out = new ObjectOutputStream(socket.getOutputStream());

        this.in = new ObjectInputStream(socket.getInputStream());
      //  this.out = new ObjectOutputStream(socket.getOutputStream());
    }

    public void send(String message) throws Exception {
        out.writeObject(message);
    }

    public String receive() throws Exception {
        return (String) in.readObject();
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
    }
}
/*
Создать ObjectOutputStream перед ObjectInputStream
Если вы пишете код, который передает данные в двух направлениях, используя ObjectInputStream и ObjectOutputStream, будьте осторожны, чтобы сначала создать ObjectOutputStream.
Если вместо этого вы сначала создадите ObjectInputStream, оба конца будут блокироваться и в конечном итоге потерпят неудачу в конструкторе. Это связано с тем, что конструктор входного потока ожидает поступления исходной строки байтов из ObjectOutputStream open(). В однонаправленном случае, когда одна сторона пишет, а другая читает, все идет гладко. Однако в двунаправленном случае, если обе стороны пытаются сначала построить входной поток, обе ожидают, пока другая сторона создаст выходной поток, и ни одна из них не может продолжить.

Если ваша обработка исключений позволяет устанавливать связь после сбоя при построении входного потока, то симптомы этой проблемы заключаются в том, что обе стороны блокируются на определенный период времени, одна получает исключение и переходит к построению ObjectOutputStream. Затем другой конец может создать свой ObjectInputStream, так как последовательность инициализации только что прибыла.

К счастью, это просто. Переместите создание ObjectOutputStream до создания ObjectInputStream. Затем каждый конец передаст последовательность инициализации, прежде чем пытаться открыть свой входной поток. Последовательность инициализации готова и ожидает, поэтому построение входного потока идет нормально, и тогда передача объекта может начаться без какой-либо задержки.
 */