package com.javarush.task.task25.task2513;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
/*
Обеспечение отсутствия прерывания важной операции
Разберись, что делает программа.
Запусти 10 раз и посмотри в какие моменты происходит "проверка".
Попробуй добиться выполнения "проверки" после каждого изменения баланса,
для этого в moveMoney() вызови Thread.yield().

Требования:
1. Класс Solution должен содержать класс Account.
2. Метод moveMoney() должен перечислять сумму amount с счета from на счет to.
3. Запусти программу 10 раз и обрати внимание когда происходит проверка.
4. В методе moveMoney() добавь вызовы Thread.yield().
5. Снова запусти программу 10 раз, и убедись, что Thread.yield() никак не повлиял на результат работы.
 */
public class Solution {

    private static final Random RANDOM = new Random();

    public static synchronized void moveMoney(Account from, Account to, int amount) {
        int transactionNumber = RANDOM.nextInt(5000);
//yield() – текущая нить «пропускает свой ход». Нить из состояния running переходит в состояние ready,
// а Java-машина приступает к выполнению следующей нити. Состояния running & ready – это подсостояния
// состояния RUNNABLE.
        Thread.yield();
        System.out.printf("Транзакция №%d: списание $%d со счета №%d. Баланс: %d.%n",
                transactionNumber, amount, from.getNumber(), from.getBalance());
        from.setBalance(from.getBalance() - amount);

        System.out.printf("Транзакция №%d: зачисление $%d на счет №%d. Баланс: %d.%n",
                transactionNumber, amount, to.getNumber(), to.getBalance());
        to.setBalance(to.getBalance() + amount);
    }

    static class Account {
        private int number;
        private int balance;
        private boolean balanceChanged;

        public Account(int number, int balance) {
            this.number = number;
            this.balance = balance;
        }

        public int getNumber() {
            return number;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
            this.balanceChanged = true;
        }

        public void checkBalance() {
            System.out.println(this.number + ": проверка...");
            this.balanceChanged = false;
        }
    }

    public static void main(String[] args) {
        Account a1 = new Account(44444444, 3000);
        Account a2 = new Account(77777, 10);
        Account a3 = new Account(111, 0);

        Set<Account> accounts = new HashSet<>();
        Collections.addAll(accounts, a1, a2, a3);

        Thread operationThread = new Thread(() -> {
            for (int i = 1; i <= 1000; i *= 10) {
                moveMoney(a1, a2, i);
            }
        });

        Thread controlThread = new Thread(() -> {
            while (operationThread.isAlive()) {
                accounts.stream().filter(a -> a.balanceChanged).forEach(Account::checkBalance);
            }
        });

        controlThread.start();
        operationThread.start();
    }
}
