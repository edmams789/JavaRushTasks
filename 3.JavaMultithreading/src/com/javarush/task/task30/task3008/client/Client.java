package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.*;

import java.io.IOException;
import java.net.Socket;

/*
Чат (17)
Последний, но самый главный метод класса SocketThread - это метод void run().
Добавь его. Его реализация с учетом уже созданных методов выглядит очень просто.

Давай напишем ее:
1) Запроси адрес и порт сервера с помощью методов getServerAddress() и getServerPort().
2) Создай новый объект класса java.net.Socket, используя данные, полученные в предыдущем пункте.
3) Создай объект класса Connection, используя сокет из п.17.2.
4) Вызови метод, реализующий "рукопожатие" клиента с сервером (clientHandshake()).
5) Вызови метод, реализующий основной цикл обработки сообщений сервера.
6) При возникновении исключений IOException или ClassNotFoundException сообщи главному потоку о проблеме, используя notifyConnectionStatusChanged() и false в качестве параметра.

Клиент готов, можешь запустить сервер, несколько клиентов и проверить как все работает.


Требования:
1. В методе run() должно быть установлено и сохранено в поле connection соединение с сервером (для получения адреса сервера и порта используй методы getServerAddress() и getServerPort()).
2. В методе run() должен быть вызван метод clientHandshake().
3. В методе run() должен быть вызван метод clientMainLoop().
4. При возникновении исключений IOException или ClassNotFoundException в процессе работы метода run(), должен быть вызван метод notifyConnectionStatusChanged() с параметром false.
5. Заголовок метода run() должен соответствовать условию задачи.
 */
/*
Клиент, в начале своей работы, должен запросить у пользователя адрес и порт сервера,
подсоединиться к указанному адресу, получить запрос имени от сервера, спросить имя у пользователя,
отправить имя пользователя серверу, дождаться принятия имени сервером.
После этого клиент может обмениваться текстовыми сообщениями с сервером.
Обмен сообщениями будет происходить в двух параллельно работающих потоках.
Один будет заниматься чтением из консоли и отправкой прочитанного серверу, а второй поток будет
получать данные от сервера и выводить их в консоль.
 */
//Создай пакет client. В дальнейшем все классы, отвечающие за реализацию клиентов, создавай в этом пакете.
//Создай класс Client.
//Класс Client должен быть создан в пакете client.

public class Client {

//Добавь метод public static void main(String[] args).
//Он должен создавать новый объект типа Client и вызывать у него метод run().
//Метод main() должен создавать новый объект типа Client и вызывать у него метод run().

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

//Создай внутренний класс SocketThread унаследованный от Thread в классе Client.
//Он будет отвечать за поток, устанавливающий сокетное соединение и читающий сообщения сервера.
//В классе Client должен быть создан публичный класс SocketThread унаследованный от Thread.

    public class SocketThread extends Thread {

//Напишем реализацию класса SocketThread.
//Начнем с простых вспомогательных методов.

//Добавь методы, которые будут доступны классам потомкам и не доступны остальным классам вне пакета:
//1) void processIncomingMessage(String message) - должен выводить текст message в консоль.
//Метод processIncomingMessage() должен выводить на экран сообщение полученное в качестве параметра.

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

//2) void informAboutAddingNewUser(String userName) - должен выводить в консоль информацию о том,
//что участник с именем userName присоединился к чату.
//Метод informAboutAddingNewUser() должен выводить на экран сообщение о том что пользователь
// подключился к чату.

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage("Пользователь " + userName + " присоединился к чату");
        }

//3) void informAboutDeletingNewUser(String userName) - должен выводить в консоль, ч
//то участник с именем userName покинул чат.
//Метод informAboutDeletingNewUser() должен выводить на экран сообщение о том что пользователь покинул чат.

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage("Пользователь " + userName + " покинул чат");
        }

//4) void notifyConnectionStatusChanged(boolean clientConnected) - этот метод должен:
//Метод notifyConnectionStatusChanged() должен устанавливать значение поля clientConnected
//внешнего объекта Client равным полученному параметру.
//Метод notifyConnectionStatusChanged() должен вызвать метод notify() на внешнем объекте Client.

        protected void notifyConnectionStatusChanged(boolean clientConnected) {

//а) Устанавливать значение поля clientConnected внешнего объекта Client в соответствии
//с переданным параметром.

            Client.this.clientConnected = clientConnected;

//б) Оповещать (пробуждать ожидающий) основной поток класса Client.
//Подсказка: используй синхронизацию на уровне текущего объекта внешнего класса и метод notify().
//Для класса SocketThread внешним классом является класс Client.

            synchronized (Client.this) {
                Client.this.notify();
            }
        }

//1) Добавь protected метод clientHandshake() throws IOException, ClassNotFoundException.
//Этот метод будет представлять клиента серверу.
//4. Метод clientHandshake() должен принимать сообщения от сервера до тех пор, пока тип сообщения
// равен MessageType.NAME_REQUEST.

        protected void clientHandshake() throws IOException, ClassNotFoundException {

//Он должен:
//В цикле получать сообщения, используя соединение connection.

        while (true) {
            Message message = connection.receive();

//Если тип полученного сообщения NAME_REQUEST (сервер запросил имя), запросить ввод имени
// пользователя с помощью метода getUserName(), создать новое сообщение с типом MessageType.USER_NAME
// и введенным именем, отправить сообщение серверу.
//Метод clientHandshake() должен отправлять новое сообщение (MessageType.USER_NAME, getUserName())
// используя connection, если тип принятого сообщения равен MessageType.NAME_REQUEST.

            if (message.getType() == MessageType.NAME_REQUEST) {
                String clientName = getUserName();
                connection.send(new Message(MessageType.USER_NAME, clientName));
            }
//Если тип полученного сообщения MessageType.NAME_ACCEPTED (сервер принял имя), значит сервер принял
// имя клиента, нужно об этом сообщить главному потоку, он этого очень ждет.
//Сделай это с помощью метода notifyConnectionStatusChanged(), передав в него true.
//После этого выйди из метода.
//Метод clientHandshake() должен вызывать метод notifyConnectionStatusChanged(true) и завершаться,
// если тип принятого сообщения равен MessageType.NAME_ACCEPTED.

            else if (message.getType() == MessageType.NAME_ACCEPTED) {
                notifyConnectionStatusChanged(true);
                break;
            }
//г) Если пришло сообщение с каким-либо другим типом, кинь исключение
// IOException("Unexpected MessageType").
//Метод clientHandshake() должен бросать исключение IOException, если тип принятого сообщения
// не MessageType.NAME_ACCEPTED или не MessageType.NAME_REQUEST.

           else throw new IOException("Unexpected MessageType");
        }
    }
//Добавь protected метод void clientMainLoop() throws IOException, ClassNotFoundException.
//Этот метод будет реализовывать главный цикл обработки сообщений сервера. Внутри метода:

        protected void clientMainLoop() throws IOException, ClassNotFoundException {

//Размести код из предыдущих пунктов внутри бесконечного цикла.
//Цикл будет завершен автоматически если произойдет ошибка (будет брошено исключение) или поток,
// в котором работает цикл, будет прерван.

            while (true) {

//Получи сообщение от сервера, используя соединение connection.
//Метод clientMainLoop() должен принимать сообщения от сервера до тех пор, пока тип сообщения
// равен MessageType.TEXT, MessageType.USER_REMOVED или MessageType.USER_ADDED.

                Message message = connection.receive();

//Если это текстовое сообщение (тип MessageType.TEXT), обработай его с помощью метода
// processIncomingMessage().
//Метод clientMainLoop() должен обрабатывать полученное сообщение с помощью метода
// processIncomingMessage(), если тип принятого сообщения равен MessageType.TEXT.

                if (message.getType() == MessageType.TEXT)
                    processIncomingMessage(message.getData());

//Если это сообщение с типом MessageType.USER_ADDED, обработай его с помощью метода
// informAboutAddingNewUser().
//Метод clientMainLoop() должен обрабатывать полученное сообщение с помощью метода
// informAboutAddingNewUser(), если тип принятого сообщения равен MessageType.USER_ADDED.

                else if (message.getType() == MessageType.USER_ADDED)
                    informAboutAddingNewUser(message.getData());

//г) Если это сообщение с типом MessageType.USER_REMOVED, обработай его с помощью метода
// informAboutDeletingNewUser().
//8. Метод clientMainLoop() должен обрабатывать полученное сообщение с помощью метода
// informAboutDeletingNewUser(), если тип принятого сообщения равен MessageType.USER_REMOVED.

                else if (message.getType() == MessageType.USER_REMOVED)
                    informAboutDeletingNewUser(message.getData());

//Если клиент получил сообщение какого-либо другого типа, брось исключение
// IOException("Unexpected MessageType").
//Метод clientMainLoop() должен бросать исключение IOException, если тип принятого сообщения не
// MessageType.TEXT, MessageType.USER_REMOVED или не MessageType.USER_ADDED.

                else throw new IOException("Unexpected MessageType");
            }
        }

//Последний, но самый главный метод класса SocketThread - это метод void run().
//Добавь его. Его реализация с учетом уже созданных методов выглядит очень просто.
//5. Заголовок метода run() должен соответствовать условию задачи.

        public void run() {

//1) Запроси адрес и порт сервера с помощью методов getServerAddress() и getServerPort().
//В методе run() должно быть установлено и сохранено в поле connection соединение с сервером
//(для получения адреса сервера и порта используй методы getServerAddress() и getServerPort()).

            String host = getServerAddress();
            int port = getServerPort();

//2) Создай новый объект класса java.net.Socket, используя данные, полученные в предыдущем пункте.

            try {
                Socket socket = new Socket(host, port);

//3) Создай объект класса Connection, используя сокет из п.2.

                Client.this.connection = new Connection(socket);

//4) Вызови метод, реализующий "рукопожатие" клиента с сервером (clientHandshake()).
//В методе run() должен быть вызван метод clientHandshake().

                clientHandshake();

//5) Вызови метод, реализующий основной цикл обработки сообщений сервера.
//В методе run() должен быть вызван метод clientMainLoop().

                clientMainLoop();

//6) При возникновении исключений IOException или ClassNotFoundException сообщи главному потоку о проблеме,
//используя notifyConnectionStatusChanged() и false в качестве параметра.
//4. При возникновении исключений IOException или ClassNotFoundException в процессе работы метода run(),
//должен быть вызван метод notifyConnectionStatusChanged() с параметром false.

            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
//Клиент готов, можешь запустить сервер, несколько клиентов и проверить как все работает.
        }
    }
//Создай поле Connection connection в классе Client.
//Используй модификатор доступа, который позволит обращаться к этому полю из класса потомков,
//но запретит обращение из других классов вне пакета.
//В классе Client должно быть создано protected поле connection типа Connection.

        protected Connection connection;

//Добавь приватное поле-флаг boolean clientConnected в класс Client.
//Проинициализируй его значением false.
//В классе Client должно быть создано private volatile поле clientConnected типа boolean.

        private volatile boolean clientConnected = false;

//String getServerAddress() - должен запросить ввод адреса сервера у пользователя и вернуть введенное значение.
//Адрес может быть строкой, содержащей ip, если клиент и сервер запущен на разных машинах или 'localhost',
//если клиент и сервер работают на одной машине.
//Метод getServerAddress() должен возвращать строку (адрес сервера), считанную с консоли.

        protected String getServerAddress() {
            ConsoleHelper.writeMessage("Введите адрес сервера.");
            return ConsoleHelper.readString();
        }
//int getServerPort() - должен запрашивать ввод порта сервера и возвращать его.
//Метод getServerPort() должен возвращать число (порт сервера), считанное с консоли.

        protected int getServerPort() {
            ConsoleHelper.writeMessage("Введите адрес порта.");
            return ConsoleHelper.readInt();
        }
//String getUserName() - должен запрашивать и возвращать имя пользователя.
//Метод getUserName() должен возвращать строку (имя пользователя), считанную с консоли.

        protected String getUserName() {
            ConsoleHelper.writeMessage("Введите имя пользователя.");
            return ConsoleHelper.readString();
        }
//boolean shouldSendTextFromConsole() - в данной реализации клиента всегда должен возвращать true
//(мы всегда отправляем текст введенный в консоль).
//Этот метод может быть переопределен, если мы будем писать какой-нибудь другой клиент, унаследованный
//от нашего, который не должен отправлять введенный в консоль текст.
//Метод shouldSendTextFromConsole() должен возвращать true.

        protected boolean shouldSendTextFromConsole() {
            return true;
        }

//SocketThread getSocketThread() - должен создавать и возвращать новый объект класса SocketThread.
//Метод getSocketThread() должен возвращать новый объект типа SocketThread.

        protected SocketThread getSocketThread() {
            return new SocketThread();
        }

//void sendTextMessage(String text) - создает новое текстовое сообщение, используя переданный текст и
//отправляет его серверу через соединение connection.
//Если во время отправки произошло исключение IOException, то необходимо вывести информацию об этом
//пользователю и присвоить false полю clientConnected.
//Метод sendTextMessage() должен создавать и отправлять новое текстовое сообщение используя connection
//и устанавливать флаг clientConnected в false, если во время отправки или создания сообщения возникло
//исключение IOException.

        protected void sendTextMessage(String text) {
            try {
                connection.send(new Message(MessageType.TEXT, text));
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Во время отправки сообщения произошла ошибка.");
                clientConnected = false;
            }
        }


//Добавь метод public void run().
//Он должен создавать вспомогательный поток SocketThread, ожидать пока тот установит соединение с
//сервером, а после этого в цикле считывать сообщения с консоли и отправлять их серверу.
//Условием выхода из цикла будет отключение клиента или ввод пользователем команды 'exit'.
//Для информирования главного потока, что соединение установлено во вспомогательном потоке,
//используй методы wait() и notify() объекта класса Client.

    public void run() {

//Реализация метода run должна:
//а) Создавать новый сокетный поток с помощью метода getSocketThread().
//Метод run() должен создавать запускать новый поток, полученный с помощью метода getSocketThread().

        SocketThread socketThread = getSocketThread();

//б) Помечать созданный поток как daemon, это нужно для того, чтобы при выходе из программы
//вспомогательный поток прервался автоматически.
//Поток созданный с помощью метода getSocketThread() должен быть отмечен как демон (setDaemon(true)).

        socketThread.setDaemon(true);

//в) Запустить вспомогательный поток.

        socketThread.start();

//г) Заставить текущий поток ожидать, пока он не получит нотификацию из другого потока.
//Подсказка: используй wait() и синхронизацию на уровне объекта.
//Если во время ожидания возникнет исключение, сообщи об этом пользователю и выйди из программы.
//После запуска нового socketThread метод run() должен ожидать до тех пор, пока не будет пробужден.

        synchronized (this) {
        try {
            this.wait();
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Во время работы произошла ошибка. Программа будет закрыта.");
        }
    }
//д) После того, как поток дождался нотификации, проверь значение clientConnected.
//Если оно true - выведи "Соединение установлено."
//Для выхода наберите команду 'exit'.".
//Если оно false - выведи "Произошла ошибка во время работы клиента.".

        if (clientConnected)
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        else
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");

//е) Считывай сообщения с консоли пока клиент подключен.
//Если будет введена команда 'exit', то выйди из цикла.
//До тех пор, пока флаг clientConnected равен true,с консоли должны считываться сообщения с помощью
//метода ConsoleHelper.readString().

        while (clientConnected) {
            String text = ConsoleHelper.readString();

//Если была введена команда "exit" цикл считывания сообщений должен быть прерван.

            if (text.toLowerCase().equals("exit")) break; //to Lower Case - в нижний регистр

//ж) После каждого считывания, если метод shouldSendTextFromConsole() возвращает true, отправь
//считанный текст с помощью метода sendTextMessage().
//Если метод shouldSentTextFromConsole() возвращает true, должен быть вызван метод sendTextMessage()
//со считанным текстом в качестве параметра.

            if (shouldSendTextFromConsole())
                sendTextMessage(text);
        }
    }
}
