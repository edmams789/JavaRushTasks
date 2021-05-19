package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
    }

    @Override
    public void run() {
        State new_state, last_state  = null;

        do {
            new_state = target.getState();
            //   State new_state = target.getState();
            if (new_state != last_state) {
                System.out.println(new_state);
                last_state = new_state;

            }

        } while (new_state != State.TERMINATED);

    }
}
