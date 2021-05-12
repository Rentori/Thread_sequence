package com.company.cbFoo;

import com.company.cdlFoo.CDLThread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CBFoo {
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
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        ExecutorService es = Executors.newFixedThreadPool(3);

        es.execute(new CBThread(cyclicBarrier));
        try {
            Thread.sleep(10);
        }catch (InterruptedException e) {
            e.getStackTrace();
        }
        es.execute(new CBThread(cyclicBarrier));
        try {
            Thread.sleep(10);
        }catch (InterruptedException e) {
            e.getStackTrace();
        }
        es.execute(new CBThread(cyclicBarrier));
        es.shutdown();
    }
}
