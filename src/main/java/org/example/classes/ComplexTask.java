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
            System.out.println("Task " + taskId + " is being executed");
            Thread.sleep(duration);
            System.out.println("Task " + taskId + " completed");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
