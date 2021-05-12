package com.company.semaphoreFoo;

import java.util.concurrent.Semaphore;

public class SemFoo {
    Semaphore semaphoreA = new Semaphore(1);
    Semaphore semaphoreB = new Semaphore(0);
    Semaphore semaphoreC = new Semaphore(0);

    public void first() {
        try {
            semaphoreA.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("first");
        semaphoreB.release();
    }

    public void second() {
        try {
            semaphoreB.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("second");
        semaphoreC.release();
    }

    public void third() {
        try {
            semaphoreC.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("third");
    }

    public static void main(String[] args) {
        SemFoo foo = new SemFoo();
        new Thread(new FooThread(foo, "C")).start();
        new Thread(new FooThread(foo, "B")).start();
        new Thread(new FooThread(foo, "A")).start();
    }
}

