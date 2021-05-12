package com.company.cdlFoo;

import java.util.concurrent.CountDownLatch;

public class CDLThread implements Runnable {
    CDLFoo foo;
    String threadName;
    CountDownLatch countDownLatch;

    public CDLThread(CountDownLatch countDownLatch, String threadName) {
        this.countDownLatch = countDownLatch;
        this.threadName = threadName;
        foo = new CDLFoo();
    }

    @Override
    public void run() {
        if (countDownLatch.getCount() == 3) {
            foo.first();
            countDownLatch.countDown();
        }
        else if (countDownLatch.getCount() == 2) {
            foo.second();
            countDownLatch.countDown();
        }
        else  {
            foo.third();
            countDownLatch.countDown();
        }
    }
}
