package com.company.phaserFoo;

import java.util.concurrent.Phaser;

public class PhaserThread implements Runnable {
    Phaser phaser;
    PhaserFoo foo;

    public PhaserThread(Phaser phaser) {
        foo = new PhaserFoo();
        this.phaser = phaser;
        this.phaser.register();
    }

    @Override
    public void run() {
        if (phaser.getPhase() == 0) {
            foo.first();
            phaser.arriveAndDeregister();
        }
        else if (phaser.getPhase() == 1) {
            foo.second();
            phaser.arriveAndDeregister();
        }
        else {
            foo.third();
            phaser.arriveAndDeregister();
        }
    }
}
