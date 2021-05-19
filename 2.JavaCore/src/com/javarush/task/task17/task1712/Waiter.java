package com.javarush.task.task17.task1712;

public class Waiter implements Runnable {
    public boolean continueWorking = true;

    @Override
    public void run() {
        Manager manager = Manager.getInstance();

        while (continueWorking || !manager.getDishesQueue().isEmpty()) {
            if (!manager.getDishesQueue().isEmpty()) {       //относим готовый заказ
                Dishes dishes = manager.getDishesQueue().poll();
                System.out.println("Официант отнес заказ для стола №" + dishes.getTableNumber());
            } else {                                         //берем новый заказ
                Table table = manager.getNextTable();
                Order order = table.getOrder();
                System.out.println("Получен заказ от стола №" + order.getTableNumber());
                manager.getOrderQueue().add(order);
            }
            try {
                Thread.sleep(100);  //walking to the next table
            } catch (InterruptedException e) {
            }
        }
    }
}
//... Читайте условия по порядку и вы поймете что да как.
//Достаточно было запустить эту задачу через ctrl shift f10 и в консоли поиском ctrl+f
// отыскать строку sout из условий if, которая не выводится. Зачем нам ее отыскивать?
// Просто для того, что если у нас есть вывод в консоль, и валидатору что-то там не нравится
// значит какая - то строка не выводится. А значит нужно понять почему она не выводится.
// Строк у нас не так много.
//...
//Так выходит что у нас вообще ни разу не выводится "Официант отнес заказ ... " из класса Waiter ,
// соответственно !manager.getDishesQueue().isEmpty() в if - всегда остается false.
// Этот блок кода всегда не выполняется. Вы даже можете перезапустить программу.
// Очередь всегда пуста. Из-за чего эта очередь с готовыми блюдами может быть пуста?
// Из за того что туда ничего не поместили. Повар блюдо то приготовил,
// но официант почему-то его отнести не смог. У нас очередь с готовыми блюдами всегда остается пустой.
// И как же мы ее должны пополнять?
//Наверное делать это мы должны так же как и официант manager.getOrderQueue().add(order)
// пополняя очередь заказов, но только пополнять то должен повар.