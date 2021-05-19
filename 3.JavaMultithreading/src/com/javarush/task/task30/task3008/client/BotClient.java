package com.javarush.task.task30.task3008.client;
/*
Чат (19)
Сейчас будем реализовывать класс BotSocketThread, вернее переопределять некоторые его методы,
весь основной функционал он уже унаследовал от SocketThread.

1. Переопредели метод clientMainLoop():
а) С помощью метода sendTextMessage() отправь сообщение с текстом "Привет чатику. Я бот.
Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды."
б) Вызови реализацию clientMainLoop() родительского класса.

2. Переопредели метод processIncomingMessage(String message).
Он должен следующим образом обрабатывать входящие сообщения:
а) Вывести в консоль текст полученного сообщения message.
б) Получить из message имя отправителя и текст сообщения. Они разделены ": ".
в) Отправить ответ в зависимости от текста принятого сообщения.
Если текст сообщения:
"дата" - отправить сообщение содержащее текущую дату в формате "d.MM.YYYY";
"день" - в формате "d";
"месяц" - "MMMM";
"год" - "YYYY";
"время" - "H:mm:ss";
"час" - "H";
"минуты" - "m";
"секунды" - "s".
Указанный выше формат используй для создания объекта SimpleDateFormat. Для получения текущей даты
необходимо использовать класс Calendar и метод getTime().
Ответ должен содержать имя клиента, который прислал запрос и ожидает ответ, например, если Боб отправил
запрос "время", мы должны отправить ответ "Информация для Боб: 12:30:47".

Наш бот готов. Запусти сервер, запусти бота, обычного клиента и убедись, что все работает правильно.
Помни, что message бывают разных типов и не всегда содержат ":"


Требования:
1. Метод clientMainLoop()класса BotSocketThread должен вызывать метод sendTextMessage() у внешнего
объекта BotClient c приветственным сообщением указанном в условии задачи.
2. Метод clientMainLoop() класса BotSocketThread должен вызывать clientMainLoop() у объекта
родительского класса (super).
3. Метод processIncomingMessage() должен выводить на экран полученное сообщение message.
4. Метод processIncomingMessage() должен отправлять ответ с помощью метода sendTextMessage()
(форматирование согласно условию задачи).
5. Метод processIncomingMessage() не должен вызывать метод sendTextMessage() для некорректных запросов.
 */
//Создай новый класс BotClient в пакете client. Он должен быть унаследован от Client.
//В пакете client должен быть создан класс BotClient являющийся потомком класса Client.

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {

//4) Добавь метод main(). Он должен создавать новый объект BotClient и вызывать у него метод run().

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
//В классе BotClient создай внутренний класс BotSocketThread унаследованный от SocketThread.
//Класс BotSocketThread должен быть публичным.
//В классе BotClient должен быть создан внутренний публичный класс BotSocketThread являющийся потомком
// класса SocketThread.

    public class BotSocketThread extends SocketThread {
//Сейчас будем реализовывать класс BotSocketThread, вернее переопределять некоторые его методы,
//весь основной функционал он уже унаследовал от SocketThread.

//1. Переопредели метод clientMainLoop():
//а) С помощью метода sendTextMessage() отправь сообщение с текстом "Привет чатику. Я бот.
//Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды."
//1. Метод clientMainLoop()класса BotSocketThread должен вызывать метод sendTextMessage() у внешнего
//объекта BotClient c приветственным сообщением указанном в условии задачи.
        @Override
    protected void clientMainLoop() throws IOException, ClassNotFoundException {
        sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");

//б) Вызови реализацию clientMainLoop() родительского класса.
//2. Метод clientMainLoop() класса BotSocketThread должен вызывать clientMainLoop() у объекта
//родительского класса (super).

            super.clientMainLoop();
    }

//2. Переопредели метод processIncomingMessage(String message).
//Он должен следующим образом обрабатывать входящие сообщения:





            @Override
        protected void processIncomingMessage(String message) {

//а) Вывести в консоль текст полученного сообщения message.
//3. Метод processIncomingMessage() должен выводить на экран полученное сообщение message.

            ConsoleHelper.writeMessage(message);

//б) Получить из message имя отправителя и текст сообщения. Они разделены ": ".
//4. Метод processIncomingMessage() должен отправлять ответ с помощью метода sendTextMessage()
//(форматирование согласно условию задачи).

    String[] messagePats = message.split(": ");

//в) Отправить ответ в зависимости от текста принятого сообщения.
//Если текст сообщения:
//"дата" - отправить сообщение содержащее текущую дату в формате "d.MM.YYYY";
//"день" - в формате "d";
//"месяц" - "MMMM";
//"год" - "YYYY";
//"время" - "H:mm:ss";
//"час" - "H";
//"минуты" - "m";
//"секунды" - "s".

    if (messagePats.length == 2) {
        String messageAutor = messagePats[0];
        String messageText = messagePats[1].toLowerCase();
        String dateTimeFormat = null;
        switch (messageText) {
            case "дата":
                dateTimeFormat = "d.MM.YYYY";
                break;
            case "день":
                dateTimeFormat = "d";
                break;
            case "месяц":
                dateTimeFormat = "MMMM";
                break;
            case "год":
                dateTimeFormat = "YYYY";
                break;
            case "время":
                dateTimeFormat = "H:mm:ss";
                break;
            case "час":
                dateTimeFormat = "H";
                break;
            case "минуты":
                dateTimeFormat = "m";
                break;
            case "секунды":
                dateTimeFormat = "s";
                break;
        }

//5. Метод processIncomingMessage() не должен вызывать метод sendTextMessage() для некорректных запросов.

        if (dateTimeFormat != null) {

//Указанный выше формат используй для создания объекта SimpleDateFormat. Для получения текущей даты
//необходимо использовать класс Calendar и метод getTime().
//Ответ должен содержать имя клиента, который прислал запрос и ожидает ответ, например, если Боб отправил
//запрос "время", мы должны отправить ответ "Информация для Боб: 12:30:47".

            String reply = String.format("Информация для %s: %s", messageAutor,
                    new SimpleDateFormat(dateTimeFormat).format(Calendar.getInstance().getTime()));

            sendTextMessage(reply);
            }
    }
}
//Наш бот готов. Запусти сервер, запусти бота, обычного клиента и убедись, что все работает правильно.
//Помни, что message бывают разных типов и не всегда содержат ":"
    }
//3) Переопредели методы:
//а) getSocketThread(). Он должен создавать и возвращать объект класса BotSocketThread.
//3. В классе BotClient должен быть переопределен метод getSocketThread() возвращающий новый объект
//класса BotSocketThread.

        @Override
        protected SocketThread getSocketThread() {
            return new BotSocketThread();
        }
//б) shouldSendTextFromConsole(). Он должен всегда возвращать false.
//Мы не хотим, чтобы бот отправлял текст введенный в консоль.
//4. В классе BotClient должен быть переопределен метод shouldSendTextFromConsole() всегда
//возвращающий false.

        @Override
        protected boolean shouldSendTextFromConsole() {
            return false;
        }
//в) getUserName(), метод должен генерировать новое имя бота, например: date_bot_X,
// где X - любое число от 0 до 99.
//Для генерации X используй метод Math.random().
//5. В классе BotClient должен быть переопределен метод getUserName() возвращающий имя бота по
//формату указанному в условии задачи.

        @Override
    protected String getUserName() {
        double x = Math.random() * 100;
        return "date_bot_" + (int) x;
        }
}
