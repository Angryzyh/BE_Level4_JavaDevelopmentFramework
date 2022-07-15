package com.angryzyh.task;

import org.springframework.stereotype.Component;

@Component
public class SpringTask {
    //@Scheduled(cron = "*/5 * * * * ?")
    public void myTask() {
        System.out.println(Thread.currentThread().getName()+"::biuuuuuuuuuuuuuuu~~~~~~~~~~");
    }
}
