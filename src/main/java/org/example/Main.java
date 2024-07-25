package org.example;

import org.example.classes.ComplexTaskExecutor;

public class Main {
    public static void main(String[] args) {
        Runnable testRunnable = () -> {
            System.out.println(Thread.currentThread().getName() + " начал тест");

            ComplexTaskExecutor taskExecutor = new ComplexTaskExecutor(5);
            taskExecutor.executeTasks();

            System.out.println(Thread.currentThread().getName() + " прошел тест");
        };

        Thread thread1 = new Thread(testRunnable, "TestThread-1");
        Thread thread2 = new Thread(testRunnable, "TestThread-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}