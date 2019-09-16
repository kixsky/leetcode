package com.company.thread;

import java.util.concurrent.Semaphore;

public class ZeroEvenOdd1 {

    private int n;
    Semaphore semaphore0 = new Semaphore(1);
    Semaphore semaphore1 = new Semaphore(2);
    Semaphore semaphore2 = new Semaphore(0);

    public static void main(String[] args) throws Exception {

        ZeroEvenOdd1 zeroEvenOdd = new ZeroEvenOdd1(2);
        IntConsumer intConsumer = new IntConsumer();
        Thread t1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

    }

    public ZeroEvenOdd1(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            semaphore0.acquire();

            printNumber.accept(0);

            semaphore1.release();
            semaphore2.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            semaphore2.acquire(3);

            printNumber.accept(i);
            semaphore0.release();
            semaphore1.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            semaphore1.acquire(3);

            printNumber.accept(i);
            semaphore2.release();
            semaphore0.release();
        }
    }

    private static class IntConsumer {
        public void accept(int a) {
            System.out.println(Thread.currentThread().getName() + "-" + a);
        }
    }
}
