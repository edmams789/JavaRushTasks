package com.javarush.task.task39.task3911;

import java.util.*;

public class Software {
    int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
//1. Метод rollback должен возвращать false, если желаемая версия не была найдена в versionHistoryMap.
        if (!versionHistoryMap.containsKey(rollbackVersion))
            return false;
//2. Метод rollback должен удалять из versionHistoryMap только версии ПО, следующие за той,
// которую передали в качестве параметра.
        Iterator<Integer> iterator = versionHistoryMap.keySet().iterator();
        while (iterator.hasNext()) //Проверяет, есть ли еще элементы впереди.
            if (iterator.next()>rollbackVersion) //Возвращает следующий элемент.
                iterator.remove(); //Удаляет текущий элемент
//3. Метод rollback должен устанавливать currentVersion в соответствие с новым значением и
// возвращать true в случае успешного отката.
        currentVersion = rollbackVersion;
//4. Метод rollback не должен изменять currentVersion и versionHistoryMap, если откат невозможен.
        return true;
    }
}
