package org.example.classes;

import java.util.Random;

public class ComplexTask {
    private final int taskId;

    public ComplexTask(int taskId) {
        this.taskId = taskId;
    }

    public void execute() {
        Random random = new Random();
        int duration = random.nextInt(3000);
        try {
            System.out.println("Задача " + taskId + " выполняется");
            Thread.sleep(duration);
            System.out.println("Задача " + taskId + " выполнена");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
