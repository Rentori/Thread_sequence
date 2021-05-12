package com.company.cbFoo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CBThread implements Runnable {
    CBFoo cbFoo;
    CyclicBarrier cyclicBarrier;

    CBThread(CyclicBarrier cyclicBarrier) {
        cbFoo = new CBFoo();
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        if (cyclicBarrier.getNumberWaiting() == 0) {
            cbFoo.first();
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
        else if (cyclicBarrier.getNumberWaiting() == 1) {
            cbFoo.second();
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
        else if (cyclicBarrier.getNumberWaiting() == 2) {
            cbFoo.third();
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
