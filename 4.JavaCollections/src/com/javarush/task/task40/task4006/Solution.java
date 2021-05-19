package com.javarush.task.task40.task4006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет

Перепиши реализацию метода getSite, он должен явно создавать и использовать сокетное соединение Socket с сервером.
Адрес сервера и параметры для GET-запроса получи из параметра url.
Порт используй дефолтный для http (80).
Классы HttpURLConnection, HttpClient и т.д. не использовать.
Не оставляй закомементированный код.

Требования:
1. Метод getSite должен создавать объект класса Socket с правильными параметрами (String host, int port).
2. Метод getSite должен записать в OutputStream правильный запрос.
3. Метод getSite должен выводить на экран InputStream сокета.
4. Метод getSite не должен использовать HttpURLConnection или HttpClient.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {
        try {
//Метод getSite должен создавать объект класса Socket с правильными параметрами (String host, int port)
            //Порт используй дефолтный для http (80)
            Socket socket = new Socket(url.getHost(), url.getDefaultPort());
//получаем OutputStream, чтобы писать в него данные запроса
            OutputStream outputStream = socket.getOutputStream();

            String request = "GET "+url.getFile()+" HTTP/1.1\r\n";
            request +="Host: "+url.getHost()+"\r\n\r\n";

            outputStream.write(request.getBytes());
            outputStream.flush();

            //Output Stream – Выходной поток
            //BufferedReader - Буферизованный читатель
            //InputStreamReader - Считыватель входного потока
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String responseLine;

            while ((responseLine = bufferedReader.readLine()) != null) {
                System.out.println(responseLine); //responseLine - Линия ответа
            }
            bufferedReader.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//Ерунду какую-то наоставляли в комментах.
//Вот реальная помощь тебе, ищущий:
// "GET "+url.getFile()+" HTTP/1.1\r\n";
// "Host: "+url.getHost()+"\r\n\r\n";

/*
HTTP/1.1 301 Moved Permanently
Server: nginx
Date: Thu, 12 Dec 2019 12:37:48 GMT
Content-Type: text/html
Content-Length: 178
Connection: keep-alive
Location: https://javarush.ru/social.html

<html>
<head><title>301 Moved Permanently</title></head>
<body bgcolor="white">
<center><h1>301 Moved Permanently</h1></center>
<hr><center>nginx</center>
</body>
</html>
 */