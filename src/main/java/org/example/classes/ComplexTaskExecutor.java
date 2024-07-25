package org.example.classes;

import java.util.concurrent.*;

public class ComplexTaskExecutor {
    private final int numberOfTasks;
    private final CyclicBarrier barrier;
    private final ExecutorService executorService;

    public ComplexTaskExecutor(int numberOfTasks) {
        this.numberOfTasks = numberOfTasks;
        this.barrier = new CyclicBarrier(numberOfTasks, () -> System.out.println("Задачи закончились. Объединение результатов..."));
        this.executorService = Executors.newFixedThreadPool(numberOfTasks);
    }

    public void executeTasks() {
        for (int i = 0; i < numberOfTasks; i++) {
            final int taskId = i;
            executorService.submit(() -> {
                ComplexTask task = new ComplexTask(taskId);
                task.execute();
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

