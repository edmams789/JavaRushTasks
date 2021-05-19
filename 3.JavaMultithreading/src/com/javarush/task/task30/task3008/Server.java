package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
Чат (11)
Пришло время написать главный метод класса Handler, который будет вызывать все вспомогательные методы, написанные ранее.
Реализуем метод void run() в классе Handler.

Он должен:
1. Выводить сообщение, что установлено новое соединение с удаленным адресом, который можно получить с помощью метода getRemoteSocketAddress().
2. Создавать Connection, используя поле socket.
3. Вызывать метод, реализующий рукопожатие с клиентом, сохраняя имя нового клиента.
4. Рассылать всем участникам чата информацию об имени присоединившегося участника (сообщение с типом USER_ADDED).
Подумай, какой метод подойдет для этого лучше всего.
5. Сообщать новому участнику о существующих участниках.
6. Запускать главный цикл обработки сообщений сервером.
7. Обеспечить закрытие соединения при возникновении исключения.
8. Отловить все исключения типа IOException и ClassNotFoundException, вывести в консоль информацию, что произошла ошибка при обмене данными с удаленным адресом.
9. После того как все исключения обработаны, если п.11.3 отработал и возвратил нам имя, мы должны удалить запись для этого имени из connectionMap и разослать всем остальным участникам сообщение с типом USER_REMOVED и сохраненным именем.
10. Последнее, что нужно сделать в методе run() - вывести сообщение, информирующее что соединение с удаленным адресом закрыто.

Наш сервер полностью готов. Попробуй его запустить.

Требования:
1. Метод run() должен выводить на экран сообщение о том, что было установлено соединение с удаленным адресом (используя метод getRemoteSocketAddress()).
2. Метод run() должен создавать новое соединение (connection) используя в качестве параметра поле socket.
3. Метод run() должен вызывать метод serverHandshake() используя в качестве параметра только что созданное соединение; результатом будет имя пользователя (userName).
4. Метод run() должен вызывать метод sendBroadcastMessage() используя в качестве параметра новое сообщение (MessageType.USER_ADDED, userName).
5. Метод run() должен вызывать метод notifyUsers() используя в качестве параметров connection и userName.
6. Метод run() должен вызывать метод serverMainLoop используя в качестве параметров connection и userName.
7. Прежде чем завершиться, метод run() должен удалять из connectionMap запись соответствующую userName, и отправлять всем участникам чата сообщение о том, что текущий пользователь был удален.
8. Метод run() должен корректно обрабатывать исключения IOException и ClassNotFoundException.
 */
public class Server { //основной класс сервера
//Статическое поле Map<String, Connection> connectionMap, где ключом будет имя клиента,
//а значением - соединение с ним
//Инициализацию поля из п.7.1 с помощью подходящего Map из библиотеки java.util.concurrent,
//т.к. работа с этим полем будет происходить из разных потоков и нужно обеспечить потокобезопасность
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();
//Статический метод void sendBroadcastMessage(Message message), который должен отправлять сообщение
//message всем соединениям из connectionMap
    public static void sendBroadcastMessage(Message message) {
        try {
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
                pair.getValue().send(message);
            }
//Если при отправке сообщение произойдет исключение IOException, нужно отловить его и сообщить пользователю,
//что не смогли отправить сообщение
        } catch (IOException e) {
            System.out.println("Сообщение не отправлено");
        }
    }
    public static void main(String[] args) throws IOException {
//Запрашивать порт сервера, используя ConsoleHelper
        int port = ConsoleHelper.readInt();
//Создавать серверный сокет java.net.ServerSocket, используя порт из предыдущего пункта
        ServerSocket serverSocket = new ServerSocket(port);
//Выводить сообщение, что сервер запущен
        System.out.println("Сервер запущен!");
        try {
//В бесконечном цикле слушать и принимать входящие сокетные соединения только что созданного серверного сокета
            while (true) {
//Создавать и запускать новый поток Handler, передавая в конструктор сокет из предыдущего пункта
//После создания потока обработчика Handler переходить на новый шаг цикла
    new Handler(serverSocket.accept()).start();
        }
//Если исключение Exception все же произошло, поймать его и вывести сообщение об ошибке
            } catch (IOException e) {
//Предусмотреть закрытие серверного сокета в случае возникновения исключения
                serverSocket.close();
        }
    }
//Добавь В класс Server приватный статический вложенный класс Handler, унаследованный от Thread.
    private static class Handler extends Thread {
//Добавь В класс Handler поле socket типа Socket.
        private Socket socket;
//Добавь В класс Handler конструктор, принимающий в качестве параметра Socket и инициализирующий им соответствующее поле класса.
        public Handler(Socket socket) {
            this.socket = socket;
        }
//Этап первый - это этап рукопожатия (знакомства сервера с клиентом).
//Реализуем его с помощью приватного метода
//String serverHandshake(Connection connection) throws IOException, ClassNotFoundException.
//Метод в качестве параметра принимает соединение connection, а возвращает имя нового клиента.
private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
    Message userName;

    while (true) {
//Метод serverHandshake должен отправлять запрос имени используя метод send класса Connection.
//Реализация метода должна:
//Сформировать и отправить команду запроса имени пользователя
        connection.send(new Message(MessageType.NAME_REQUEST));
        // connection.send(new Message(MessageType.NAME_REQUEST, "Введите имя:"));
//Реализация метода должна:
//Получить ответ клиента
        userName = connection.receive();
//Реализация метода должна:
//Проверить, что получена команда с именем пользователя
//Требования:
//До тех пор, пока тип сообщения полученного в ответ не будет равен MessageType.USER_NAME,
//запрос имени должен быть выполнен снова.
        if (userName.getType() == MessageType.USER_NAME) {
//Реализация метода должна:
//Достать из ответа имя, проверить, что оно не пустое и пользователь с таким именем еще не подключен (используй connectionMap)
//Требования:
//В случае, если в ответ пришло пустое имя, запрос имени должен быть выполнен снова.
            if (!userName.getData().isEmpty()) {
//Требования:
//5. В случае, если имя уже содержится в connectionMap, запрос имени должен быть выполнен снова.
                if (!connectionMap.containsKey(userName.getData())) {
//Реализация метода должна:
//5) Добавить нового пользователя и соединение с ним в connectionMap
//Требования:
//6. После успешного проведения всех проверок, метод serverHandshake должен добавлять новую пару
//(имя, соединение) в connectionMap и отправлять сообщение о том, что имя было принято.
                    connectionMap.put(userName.getData(), connection);
//Реализация метода должна:
//6) Отправить клиенту команду информирующую, что его имя принято
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    // connection.send(new Message(MessageType.NAME_ACCEPTED, "Вы добавлены в чат!"));
//Реализация метода должна:
//8) Вернуть принятое имя в качестве возвращаемого значения
//Требования:
//7. Метод serverHandshake должен возвращать имя нового клиента с которым было установлено соединение.
                    return userName.getData();
                }
                    }
                }
            }
        }
//Требования:
//В классе Handler должен быть создан метод private void notifyUsers(Connection connection, String userName).
private void notifyUsers(Connection connection, String userName) throws IOException {
//Метод должен:
//Пройтись по connectionMap.
    for (String pair : connectionMap.keySet()) {
//Метод должен:
//Команду с типом USER_ADDED и именем равным userName отправлять не нужно, пользователь и так имеет информацию о себе
//Требования:
//Метод notifyUsers() НЕ должен отправлять сообщение о добавлении пользователя, если имя пользователя
//совпадает со вторым параметром метода (userName).
        if (!pair.equals(userName)) {
//Метод должен:
//У каждого элемента из connectionMap получить имя клиента, сформировать команду с типом USER_ADDED и полученным именем.
//Отправить сформированную команду через connection.
//Требования:
//Метод notifyUsers() должен отправлять через connection сообщение о том, что был добавлен пользователь с именем name для каждого имени из connectionMap.
            connection.send(new Message(MessageType.USER_ADDED, pair));
        }
    }
}
//Метод serverMainLoop() должен в бесконечном цикле получать сообщения от клиента (используя метод receive() класса Connection).
private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
    String str;
    Message message;
        while (true) {
            //Принимать сообщение клиента
            message = connection.receive();
//Если сообщение, полученное методом serverMainLoop(), имеет тип MessageType.TEXT,
            if (message.getType() == MessageType.TEXT) {
//то должно быть отправлено новое сообщение всем участникам чата используя метод sendBroadcastMessage()
// (форматирование сообщения описано в условии).
                str = userName + ": " + message.getData();
            //  message = MessageFormat.format("{0}: {1}", userName, str);
//Отправлять сформированное сообщение всем клиентам с помощью метода sendBroadcastMessage().
                    sendBroadcastMessage(new Message(MessageType.TEXT, str));
            } else {
//Если принятое сообщение не является текстом, вывести сообщение об ошибке
    ConsoleHelper.writeMessage("Mistake! The message does not contain text!"); //Ошибка! Сообщение не содержит текста!
            }
        }
    }
    @Override
    public void run() {
//Выводить сообщение, что установлено новое соединение с удаленным адресом, который можно получить
//с помощью метода getRemoteSocketAddress().
//Метод run() должен выводить на экран сообщение о том, что было установлено соединение с удаленным
//адресом (используя метод getRemoteSocketAddress()).
    ConsoleHelper.writeMessage("Было установлено соединение с удаленным адресом: " + socket.getRemoteSocketAddress());
//
    String userName = null;
    try {
//Создавать Connection, используя поле socket.
//Метод run() должен создавать новое соединение (connection) используя в качестве параметра поле socket.
        Connection connection = new Connection(socket);
//Вызывать метод, реализующий рукопожатие с клиентом, сохраняя имя нового клиента.
//Метод run() должен вызывать метод serverHandshake() используя в качестве параметра только что
//созданное соединение; результатом будет имя пользователя (userName).
        userName = serverHandshake(connection);
//Рассылать всем участникам чата информацию об имени присоединившегося участника (сообщение с типом USER_ADDED).
//Подумай, какой метод подойдет для этого лучше всего.
//Метод run() должен вызывать метод sendBroadcastMessage() используя в качестве параметра новое
//сообщение (MessageType.USER_ADDED, userName).
        sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
//Сообщать новому участнику о существующих участниках.
//Метод run() должен вызывать метод notifyUsers() используя в качестве параметров connection и userName.
        notifyUsers(connection, userName);
//Запускать главный цикл обработки сообщений сервером.
//Метод run() должен вызывать метод serverMainLoop используя в качестве параметров connection и userName.
        serverMainLoop(connection, userName);
//Отловить все исключения типа IOException и ClassNotFoundException, вывести в консоль информацию,
//что произошла ошибка при обмене данными с удаленным адресом.
//Метод run() должен корректно обрабатывать исключения IOException и ClassNotFoundException.
    } catch (IOException | ClassNotFoundException e) {
        ConsoleHelper.writeMessage("Mistake!");
    }
//Обеспечить закрытие соединения при возникновении исключения.
//Прежде чем завершиться, метод run() должен удалять из connectionMap запись соответствующую userName,
//и отправлять всем участникам чата сообщение о том, что текущий пользователь был удален.
        if (userName != null) {
//После того как все исключения обработаны, если п.11.3 отработал и возвратил нам имя,
//мы должны удалить запись для этого имени из connectionMap
            connectionMap.remove(userName);
//и разослать всем остальным участникам сообщение с типом USER_REMOVED и сохраненным именем.
            sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
        }
//Последнее, что нужно сделать в методе run() - вывести сообщение, информирующее что соединение
//с удаленным адресом закрыто.
        ConsoleHelper.writeMessage("Соединение с удаленным адресом " + socket.getRemoteSocketAddress() + " закрыто." );
//ConsoleHelper.writeMessage(String.format("Соединение с удаленным адресом (%s) закрыто.", socket.getRemoteSocketAddress()));
    }
}
}
