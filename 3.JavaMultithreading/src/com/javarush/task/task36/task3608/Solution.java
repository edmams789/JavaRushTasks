package com.javarush.task.task36.task3608;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.FakeModel;
import com.javarush.task.task36.task3608.model.MainModel;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;
/*
MVC (9)
Это последнее задание по MVC.

1. Следуя принципу MVC аналогично реализации предыдущих методов сделай следующее:
напиши логику обновления пользователя. После обновления должен отображаться список пользователей.

Распредели методы по классам MVC, используя следующие сигнатуры публичных методов:
void fireEventUserChanged(String name, long id, int level)
void onUserChange(String name, long id, int level)
void changeUserData(String name, long id, int level)

где name и level - это новые значения для пользователя с выбранным id.

Примечание: метод, который ты собираешься добавить в Вью нужно добавить в EditUserView.

2. Добавь в main вызов fireEventUserChanged перед вызовом метода fireEventShowDeletedUsers().

3. Добавь в интерфейс Model метод, который ты поместил в Модель, реализуй его в FakeModel:
выброси UnsupportedOperationException.

Требования:
1. Необходимо определить правильное расположение метода fireEventUserChanged(String name, long id, int level)
и реализовать этот метод.
2. Необходимо определить правильное расположение метода onUserChange(String name, long id, int level) и
реализовать этот метод.
3. Необходимо определить правильное расположение метода void changeUserData(String name, long id, int level)
и реализовать этот метод.
4. В методе main необходимо вызвать метод fireEventUserChanged(String, long, int) перед вызовом метода
fireEventShowDeletedUsers().
5. Интерфейс Model должен содержать объявление метода, который ты ранее реализовал в классе MainModel.
6. В классе FakeModel в теле метода, помещенного в интерфейс Model, необходимо бросить
UnsupportedOperationException.
 */
public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        EditUserView editUserView = new EditUserView();
        Controller controller = new Controller();

        usersView.setController(controller);
        editUserView.setController(controller);

        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        usersView.fireEventShowAllUsers();
        usersView.fireEventOpenUserEditForm(126L);
        editUserView.fireEventUserChanged("IvanovEdit", 123L, 5);
        editUserView.fireEventUserDeleted(124L);



        usersView.fireEventShowDeletedUsers();

    }
}
//Вызов метода fireEventUserChanged(String, long, int) должен быть расположен перед
// вызовом метода fireEventShowDeletedUsers().