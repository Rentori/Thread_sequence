package com.company.phaserFoo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserFoo {
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
        Phaser phaser = new Phaser(1);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(new PhaserThread(phaser));
        phaser.arriveAndAwaitAdvance();

        executorService.execute(new PhaserThread(phaser));
        phaser.arriveAndAwaitAdvance();

        executorService.execute(new PhaserThread(phaser));
        phaser.arriveAndAwaitAdvance();

        executorService.shutdown();
    }
}
