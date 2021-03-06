package com.javarush.task.task30.task3008.client;
/*
Чат (21)
У меня есть отличнейшая новость для тебя. Компонент представление (View) уже готов.
Я добавил класс ClientGuiView.
Он использует библиотеку javax.swing.
Ты должен как следует разобраться в каждой строчке этого класса.
Если тебе все понятно - это замечательно, если нет - обязательно найди ответы на свои вопросы с помощью дебага, документации или поиска в Интернет.

Осталось написать компонент контроллер (Controller):
1. Создай класс ClientGuiController унаследованный от Client.
2. Создай и инициализируй поле, отвечающее за модель ClientGuiModel model.
3. Создай и инициализируй поле, отвечающее за представление ClientGuiView view.
Подумай, что нужно передать в конструктор при инициализации объекта.
4. Добавь внутренний класс GuiSocketThread унаследованный от SocketThread.
Класс GuiSocketThread должен быть публичным.
В нем переопредели следующие методы:
а) void processIncomingMessage(String message) - должен устанавливать новое сообщение у модели и вызывать обновление вывода сообщений у представления.
б) void informAboutAddingNewUser(String userName) - должен добавлять нового пользователя в модель и вызывать обновление вывода пользователей у отображения.
в) void informAboutDeletingNewUser(String userName) - должен удалять пользователя из модели и вызывать обновление вывода пользователей у отображения.
г) void notifyConnectionStatusChanged(boolean clientConnected) - должен вызывать аналогичный метод у представления.
5. Переопредели методы в классе ClientGuiController:
а) SocketThread getSocketThread() - должен создавать и возвращать объект типа GuiSocketThread.
б) void run() - должен получать объект SocketThread через метод getSocketThread() и вызывать у него метод run().
Разберись, почему нет необходимости вызывать метод run() в отдельном потоке, как мы это делали для консольного клиента.
в) getServerAddress(), getServerPort(), getUserName().
Они должны вызывать одноименные методы из представления (view).
6. Реализуй метод ClientGuiModel getModel(), который должен возвращать модель.
7. Реализуй метод main(), который должен создавать новый объект ClientGuiController и вызывать у него метод run().
Запусти клиента с графическим окном, нескольких консольных клиентов и убедись, что все работает корректно.


Требования:
1. В пакете client должен быть корректно объявлен класс ClientGuiController и вложенный в него класс GuiSocketThread.
2. В классе ClientGuiController должны быть корректно объявлены и инициализированы поля перечисленные в условии задачи.
3. Метод processIncomingMessage() должен быть реализован в классе GuiSocketThread в соответствии с условием задачи.
4. Метод informAboutAddingNewUser() должен быть реализован в классе GuiSocketThread в соответствии с условием задачи.
5. Метод informAboutDeletingNewUser() должен быть реализован в классе GuiSocketThread в соответствии с условием задачи.
6. Метод notifyConnectionStatusChanged() должен быть реализован в классе GuiSocketThread в соответствии с условием задачи.
7. Метод getSocketThread() в классе ClientGuiController должен возвращать новый объект типа GuiSocketThread.
8. Метод run() в классе ClientGuiController должен получать объект SocketThread через метод getSocketThread() и вызывать у него метод run().
9. Методы getServerAddress(), getServerPort(), getUserName() в классе ClientGuiController должны вызывать соответствующие методы у объекта view.
10. Метод getModel() в классе ClientGuiController должен возвращать значение поля model.
11. Метод main() в классе ClientGuiController должен создавать новый объект типа ClientGuiController и вызывать у него метод run().
12. Класс ClientGuiController должен быть потомком класса Client.
 */
//Осталось написать компонент контроллер (Controller):
//1. Создай класс ClientGuiController унаследованный от Client.
//1. В пакете client должен быть корректно объявлен класс ClientGuiController и вложенный в него класс GuiSocketThread.
//12. Класс ClientGuiController должен быть потомком класса Client.

public class ClientGuiController extends Client {

//7. Реализуй метод main(), который должен создавать новый объект ClientGuiController и вызывать у него метод run().
//11. Метод main() в классе ClientGuiController должен создавать новый объект типа ClientGuiController
// и вызывать у него метод run().

    public static void main(String[] args) {
        ClientGuiController clientGuiController = new ClientGuiController();
        clientGuiController.run();
    }

//2. Создай и инициализируй поле, отвечающее за модель ClientGuiModel model.
//2. В классе ClientGuiController должны быть корректно объявлены и инициализированы
// поля перечисленные в условии задачи.

    private ClientGuiModel model;

//3. Создай и инициализируй поле, отвечающее за представление ClientGuiView view.
//Подумай, что нужно передать в конструктор при инициализации объекта.

    private ClientGuiView view;

    public ClientGuiController() {
        this.model = new ClientGuiModel();
        this.view = new ClientGuiView(this);
    }

//4. Добавь внутренний класс GuiSocketThread унаследованный от SocketThread.
//Класс GuiSocketThread должен быть публичным.

    public class GuiSocketThread extends SocketThread {

//В нем переопредели следующие методы:
//а) void processIncomingMessage(String message) - должен устанавливать новое сообщение у модели и
// вызывать обновление вывода сообщений у представления.
//3. Метод processIncomingMessage() должен быть реализован в классе GuiSocketThread
// в соответствии с условием задачи.

        @Override
        protected void processIncomingMessage(String message) {
            model.setNewMessage(message);
            view.refreshMessages();
        }

//б) void informAboutAddingNewUser(String userName) - должен добавлять нового пользователя в модель и вызывать обновление вывода пользователей у отображения.
//4. Метод informAboutAddingNewUser() должен быть реализован в классе GuiSocketThread
// в соответствии с условием задачи.
        @Override
        protected void informAboutAddingNewUser(String userName) {
            model.addUser(userName);
            view.refreshUsers();
        }
//в) void informAboutDeletingNewUser(String userName) - должен удалять пользователя из модели и вызывать обновление вывода пользователей у отображения.
//5. Метод informAboutDeletingNewUser() должен быть реализован в классе GuiSocketThread
// в соответствии с условием задачи.
        @Override
        protected void informAboutDeletingNewUser(String userName) {
            model.deleteUser(userName);
            view.refreshUsers();
        }
//г) void notifyConnectionStatusChanged(boolean clientConnected) - должен вызывать аналогичный метод у представления.
//6. Метод notifyConnectionStatusChanged() должен быть реализован в классе GuiSocketThread
// в соответствии с условием задачи.
        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }
//5. Переопредели методы в классе ClientGuiController:
//а) SocketThread getSocketThread() - должен создавать и возвращать объект типа GuiSocketThread.
//7. Метод getSocketThread() в классе ClientGuiController должен возвращать новый объект
// типа GuiSocketThread.
    @Override
    protected SocketThread getSocketThread() {
        return new GuiSocketThread();
    }
//б) void run() - должен получать объект SocketThread через метод getSocketThread() и вызывать у него
// метод run().
//Разберись, почему нет необходимости вызывать метод run() в отдельном потоке, как мы это делали для консольного клиента.
//8. Метод run() в классе ClientGuiController должен получать объект SocketThread через
// метод getSocketThread() и вызывать у него метод run().
    @Override
    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.run();
    }
//в) getServerAddress(), getServerPort(), getUserName().
//Они должны вызывать одноименные методы из представления (view).
//9. Методы getServerAddress(), getServerPort(), getUserName() в классе ClientGuiController должны вызывать
// соответствующие методы у объекта view.
    @Override
    protected String getServerAddress() {
        return view.getServerAddress();
    }
    @Override
    protected int getServerPort() {
        return view.getServerPort();
    }
    @Override
    protected String getUserName() {
        return view.getUserName();
    }
//6. Реализуй метод ClientGuiModel getModel(), который должен возвращать модель.
//10. Метод getModel() в классе ClientGuiController должен возвращать значение поля model.

    public ClientGuiModel getModel() {
        return model;
    }
//Запусти клиента с графическим окном, нескольких консольных клиентов и убедись, что все работает корректно.
}
