package org.example;

public class LiveLock {
    private static volatile int count = 0;

    public static void main(String[] args) {
        Runnable inc = new Runnable() {
            public void run() {
                while (true) {
                    count++;
                }
            }
        };

        Runnable dec = new Runnable() {
            public void run() {
                while (true) {
                    count--;
                }
            }
        };

        Thread t1 = new Thread(inc);
        Thread t2 = new Thread(dec);

        t1.start();
        t2.start();
    }

}
