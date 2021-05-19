package com.javarush.task.task30.task3008;
/*
Чат (3)
Прежде, чем двигаться дальше, нужно разработать протокол общения клиента и сервера.

Сформулируем основные моменты протокола:
- Когда новый клиент хочет подсоединиться к серверу, сервер должен запросить имя клиента.
- Когда клиент получает запрос имени от сервера он должен отправить свое имя серверу.
- Когда сервер получает имя клиента он должен принять это имя или запросить новое.
- Когда новый клиент добавился к чату, сервер должен сообщить остальным участникам о новом клиенте.
- Когда клиент покидает чат, сервер должен сообщить остальным участникам об этом.
- Когда сервер получает текстовое сообщение от клиента, он должен переслать его всем остальным участникам чата.

Добавь для каждого пункта вышеописанного протокола соответствующее значение в enum
MessageType:
1) NAME_REQUEST - запрос имени.
2) USER_NAME - имя пользователя.
3) NAME_ACCEPTED - имя принято.
4) TEXT - текстовое сообщение.
5) USER_ADDED - пользователь добавлен.
6) USER_REMOVED - пользователь удален.


Требования:
1. В перечислении MessageType должен присутствовать элемент NAME_REQUEST.
2. В перечислении MessageType должен присутствовать элемент USER_NAME.
3. В перечислении MessageType должен присутствовать элемент NAME_ACCEPTED.
4. В перечислении MessageType должен присутствовать элемент TEXT.
5. В перечислении MessageType должен присутствовать элемент USER_ADDED.
6. В перечислении MessageType должен присутствовать элемент USER_REMOVED.
 */
public enum MessageType { //enum, который отвечает за тип сообщений пересылаемых между клиентом и сервером
// - Когда новый клиент хочет подсоединиться к серверу, сервер должен запросить имя клиента
    NAME_REQUEST, // - запрос имени
// - Когда клиент получает запрос имени от сервера он должен отправить свое имя серверу
    USER_NAME, // - имя пользователя
// - Когда сервер получает имя клиента он должен принять это имя или запросить новое
    NAME_ACCEPTED, // - имя принято
// - Когда сервер получает текстовое сообщение от клиента, он должен переслать его всем остальным участникам чата
    TEXT, // - текстовое сообщение
// - Когда новый клиент добавился к чату, сервер должен сообщить остальным участникам о новом клиенте
    USER_ADDED, // - пользователь добавлен
// - Когда клиент покидает чат, сервер должен сообщить остальным участникам об этом
    USER_REMOVED // - пользователь удален
}
