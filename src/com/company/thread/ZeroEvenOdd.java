package com.company.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ZeroEvenOdd {

    private volatile int n;

    private final Lock lock = new ReentrantLock();

    private final Condition zero = lock.newCondition();

    private final Condition even = lock.newCondition();

    private final Condition odd = lock.newCondition();

    private volatile int count = 0; //计数

    private volatile int step = 1;

    private volatile int lStep = 1;

    private volatile int cur = 0;

    public static void main(String[] args) throws Exception {

        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
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
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            if (cur != 0) zero.await(); //挂起
            if (count < 2 * n) {
                printNumber.accept(0);
            } else {
                even.signalAll();
                odd.signalAll();
                lock.unlock();
                return;
            }
            cur = 1;
            count++;

            if (lStep % 2 == 0)
                odd.signalAll();
            else
                even.signalAll();

            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            if (cur != 1) even.await(); //挂起
            if (count < 2 * n) {
                printNumber.accept(step);
            } else {
                zero.signalAll();
                lock.unlock();
                return;
            }
            lStep = step;
            cur = 0;
            count++;
            step++;
            zero.signalAll();
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            if (cur != 2) odd.await(); //挂起
            if (count < 2 * n) {
                printNumber.accept(step);
            } else {
                zero.signalAll();
                lock.unlock();
                return;
            }
            lStep = step;
            cur = 0;
            count++;
            step++;
            zero.signalAll();
            lock.unlock();
        }
    }

    private static class IntConsumer {
        public void accept(int a) {
            System.out.println(Thread.currentThread().getName() + "-" + a);
        }
    }

}
