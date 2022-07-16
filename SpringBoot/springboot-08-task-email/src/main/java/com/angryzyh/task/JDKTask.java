package com.angryzyh.task;

import java.util.Timer;
import java.util.TimerTask;

public class JDKTask {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("fuckkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkking");
            }
        }, 0, 2000);
    }

    public void run1() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("fuckkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkking");
            }
        };
        timer.schedule(timerTask,0,2000);
    }
}
