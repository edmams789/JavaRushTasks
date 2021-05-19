package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;
import com.javarush.task.task39.task3913.query.UserQuery;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
Парсер логов (2)
Реализуй интерфейс UserQuery у класса LogParser:
2.1. Метод getAllUsers() должен возвращать всех пользователей.
2.2. Метод getNumberOfUsers() должен возвращать количество уникальных пользователей.
2.3. Метод getNumberOfUserEvents() должен возвращать количество событий от определенного пользователя.
2.4. Метод getUsersForIP() должен возвращать пользователей с определенным IP.
Несколько пользователей могут использовать один и тот же IP.
2.5. Метод getLoggedUsers() должен возвращать пользователей, которые делали логин.
2.6. Метод getDownloadedPluginUsers() должен возвращать пользователей, которые скачали плагин.
2.7. Метод getWroteMessageUsers() должен возвращать пользователей, которые отправили сообщение.
2.8. Метод getSolvedTaskUsers(Date after, Date before) должен возвращать пользователей, которые решали
любую задачу.
2.9. Метод getSolvedTaskUsers(Date after, Date before, int task) должен возвращать пользователей,
которые решали задачу с номером task.
2.10. Метод getDoneTaskUsers(Date after, Date before) должен возвращать пользователей, которые решили
любую задачу.
2.11. Метод getDoneTaskUsers(Date after, Date before, int task) должен возвращать пользователей,
которые решили задачу с номером task.

Требования:
1. Класс LogParser должен поддерживать интерфейс UserQuery.
2. Метод getAllUsers() должен возвращать множество содержащее всех пользователей.
3. Метод getNumberOfUsers(Date, Date) должен возвращать количество уникальных пользователей за выбранный период.
4. Метод getNumberOfUserEvents(String, Date, Date) должен возвращать количество событий от переданного
пользователя за выбранный период.
5. Метод getUsersForIP(String, Date, Date) должен возвращать множество содержащее пользователей,
которые работали с переданного IP адреса за выбранный период.
6. Метод getLoggedUsers(Date, Date) должен возвращать множество содержащее пользователей,
которые были залогинены за выбранный период.
7. Метод getDownloadedPluginUsers(Date, Date) должен возвращать множество содержащее пользователей,
которые скачали плагин за выбранный период.
8. Метод getWroteMessageUsers(Date, Date) должен возвращать множество содержащее пользователей,
которые отправили сообщение за выбранный период.
9. Метод getSolvedTaskUsers(Date, Date) должен возвращать множество содержащее пользователей,
которые решали любую задачу за выбранный период.
10. Метод getSolvedTaskUsers(Date, Date, int task) должен возвращать множество содержащее пользователей,
которые решали задачу с номером task за выбранный период.
11. Метод getDoneTaskUsers(Date, Date) должен возвращать множество содержащее пользователей, которые
решили любую задачу за выбранный период.
12. Метод getDoneTaskUsers(Date, Date, int task) должен возвращать множество содержащее пользователей,
которые решили задачу с номером task за выбранный период.
 */
public class LogParser implements IPQuery, UserQuery {

    private List<String> linesList;
    private Path logDir;

    public LogParser(Path logDir) {
        this.logDir = logDir;
        linesList = getLinesList();
    }

    private List<String> getLinesList() {
        String[] files = logDir.toFile().list((dir, name) -> name.endsWith(".log"));
        if (files == null) {
            return null;
        }

        List<String> lines = new ArrayList<>();

        for (String file : files) {
            try {
                lines.addAll(Files.readAllLines(Paths.get(logDir + File.separator + file), Charset.defaultCharset()));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lines;
    }
//addStringEntity - добавить строковый объект
    private void addStringEntity(Date after, Date before, Set<String> enteties, String[] parts, int part) {
        long lineDateTime = getDate(parts[2]).getTime();

        if (isCompatibleDate(lineDateTime, after, before)) {
            enteties.add(parts[part]);
        }
    }

    private Date getDate(String part) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date date = null;
        try {
            date = dateFormat.parse(part);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private boolean isCompatibleDate(long lineDateTime, Date after, Date before) {
        if (after == null && before == null) {
            return true;
        } else if (after == null) {
            return lineDateTime <= before.getTime();
        } else if (before == null) {
            return lineDateTime >= after.getTime();
        } else {
            return lineDateTime >= after.getTime() && lineDateTime <= before.getTime();
        }
    }


//Метод getNumberOfUniqueIPs(Date, Date) должен возвращать количество уникальных IP адресов за выбранный
//период.
    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {

        return getUniqueIPs(after, before).size(); //получить уникальные IP-адреса
    }
//Метод getUniqueIPs(Date, Date) класса LogParser должен возвращать множество, содержащее все не
//повторяющиеся IP адреса за выбранный период.
    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> uniqueIPs = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");

            addStringEntity(after, before, uniqueIPs, parts, 0);
        }
        return uniqueIPs;
    }
//Метод getIPsForUser(String, Date, Date) класса LogParser должен возвращать IP адреса, с которых работал
//переданный пользователь за выбранный период.
    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> iPsForUser = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");

            if (user.equals(parts[1])) {
                addStringEntity(after, before, iPsForUser, parts, 0);
            }
        }
        return iPsForUser;
    }
//Метод getIPsForEvent(Event, Date, Date) класса LogParser должен возвращать IP адреса, с которых было
//произведено переданное событие за выбранный период.
    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> iPsForEvent = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");

            if (event.toString().equals(parts[3].split(" ")[0])) { //event - мероприятие
                addStringEntity(after, before, iPsForEvent, parts, 0);
            }
        }
        return iPsForEvent;
    }
//Метод getIPsForStatus(Status, Date, Date) класса LogParser должен возвращать IP адреса, события с
//которых закончилось переданным статусом за выбранный период.
    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> iPsForStatus = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");

            if (status.toString().equals(parts[4])) {
                addStringEntity(after, before, iPsForStatus, parts, 0);
            }
        }
        return iPsForStatus;
    }


//Метод getAllUsers() должен возвращать множество содержащее всех пользователей.
    @Override
    public Set<String> getAllUsers() {
        Set<String> allUsers = new HashSet<>();

        return null;
    }
//Метод getNumberOfUsers(Date, Date) должен возвращать количество уникальных пользователей за выбранный период.
    @Override
    public int getNumberOfUsers(Date after, Date before) { //получить количество пользователей

        return getLoggedUsers(after, before).size(); //получить зарегистрированных пользователей
    }
//Метод getNumberOfUserEvents(String, Date, Date) должен возвращать количество событий от переданного
//пользователя за выбранный период.
    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        return 0;
    }
//Метод getUsersForIP(String, Date, Date) должен возвращать множество содержащее пользователей,
//которые работали с переданного IP адреса за выбранный период.
    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> usersForIP = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");

            if (ip.equals(parts[0])) {

                addStringEntity(after, before, usersForIP, parts, 0);
            }
        }
        return usersForIP;
    }
//Метод getLoggedUsers(Date, Date) должен возвращать множество содержащее пользователей,
//которые были залогинены за выбранный период.
    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> loggedUsers = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");


            }

        return loggedUsers;
    }
//Метод getDownloadedPluginUsers(Date, Date) должен возвращать множество содержащее пользователей,
//которые скачали плагин за выбранный период.
    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> downloadedPluginUsers = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");


            }

        return downloadedPluginUsers;
    }
//Метод getWroteMessageUsers(Date, Date) должен возвращать множество содержащее пользователей,
//которые отправили сообщение за выбранный период.
    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> wroteMessageUsers = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");


            }

        return wroteMessageUsers;
    }
//Метод getSolvedTaskUsers(Date, Date) должен возвращать множество содержащее пользователей,
//которые решали любую задачу за выбранный период.
    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> solvedTaskUsers = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");


            }

        return getDoneTaskUsers(after, before); //выполнить задачу пользователей
    }
//Метод getSolvedTaskUsers(Date, Date, int task) должен возвращать множество содержащее пользователей,
//которые решали задачу с номером task за выбранный период.
    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> solvedTaskUsers = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");


            }

        return getDoneTaskUsers(after, before, task);
    }
//Метод getDoneTaskUsers(Date, Date) должен возвращать множество содержащее пользователей, которые
//решили любую задачу за выбранный период.
    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> doneTaskUsers = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");


            }
        return getDoneTaskUsers(after, before);
    }
//Метод getDoneTaskUsers(Date, Date, int task) должен возвращать множество содержащее пользователей,
//которые решили задачу с номером task за выбранный период.
    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> doneTaskUsers = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");


            }

        return doneTaskUsers;
    }
}










