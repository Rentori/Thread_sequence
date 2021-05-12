package com.company.cdlFoo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CDLFoo {
    public void first() {
        System.out.print("first");
    }
    public void second() {
        System.out.print("second");
    }
    public void third() {
        System.out.print("third");
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService es = Executors.newFixedThreadPool(1);

        es.execute(new CDLThread(countDownLatch, "B"));
        es.execute(new CDLThread(countDownLatch, "A"));
        es.execute(new CDLThread(countDownLatch, "C"));

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        es.shutdown();
    }
}
