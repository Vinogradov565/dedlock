package org.example;

public class Deadlock {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                synchronized (lock1) {
                    System.out.println("Thread 1: Holding lock 1...");
                    try { Thread.sleep(10); } catch (InterruptedException e) {}
                    System.out.println("Thread 1: Waiting for lock 2...");
                    synchronized (lock2) {
                        System.out.println("Thread 1: Holding locks 1 and 2...");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                synchronized (lock2) {
                    System.out.println("Thread 2: Holding lock 2...");
                    try { Thread.sleep(10); } catch (InterruptedException e) {}
                    System.out.println("Thread 2: Waiting for lock 1...");
                    synchronized (lock1) {
                        System.out.println("Thread 2: Holding locks 1 and 2...");
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }

}

