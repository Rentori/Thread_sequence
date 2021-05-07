package com.company;

import java.util.concurrent.Semaphore;

public class Foo {
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
        Foo foo = new Foo();
        new Thread(new FooThread(foo, "C")).start();
        new Thread(new FooThread(foo, "B")).start();
        new Thread(new FooThread(foo, "A")).start();
    }
}

class FooThread implements Runnable {
    String name;
    Foo foo;

    FooThread(Foo foo, String name) {
        this.foo = foo;
        this.name = name;
    }

    @Override
    public void run() {
        switch (name) {
            case "A" -> foo.first();
            case "B" -> foo.second();
            case "C" -> foo.third();
        }
    }
}
