package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;
/*
5. Измени метод refresh в UsersView так, чтобы он отображал "All users:" либо "All deleted users:"
в зависимости от того, какие пользователи находятся в списке.
Добавь в необходимые методы модели изменение displayDeletedUserList.

Требования:
6. Метод refresh в классе UsersView должен быть изменен согласно условию.
 */
public class UsersView implements View {

    private Controller controller;
    //3. Реализуй логику метода refresh:
    @Override
    public void refresh(ModelData modelData) {
        if (modelData.isDisplayDeletedUserList()){

            System.out.println("All deleted users:");
        } else
            System.out.println("All users:");


        //3.2. Выведи в консоль всех пользователей, которые есть в modelData.
        // Перед каждым пользователем сделай отступ в виде табуляции.
        for (User user : modelData.getUsers()){
            String str = String.format("User{name='%s', id=%d, level=%d}", user.getName(),user.getId(),user.getLevel());
            System.out.println("\t" + str);
        }

        //3.3. В конце выведи визуальный разделитель данных
        //===================================================
        System.out.println("===================================================");

    }
    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }
    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }
    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }

}
