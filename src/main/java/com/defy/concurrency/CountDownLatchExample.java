package com.defy.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

	public static void main(String[] a) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(3);

		Waiter      waiter      = new Waiter(latch);
		Decrementer decrementer1 = new Decrementer(latch);
		Decrementer decrementer2 = new Decrementer(latch);
		Decrementer decrementer3 = new Decrementer(latch);


		new Thread(decrementer1).start();
		new Thread(decrementer2).start();
		new Thread(decrementer3).start();
		new Thread(waiter)     .start();

		Thread.sleep(4000);
	}
}


class Waiter implements Runnable{

    CountDownLatch latch = null;

    public Waiter(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Waiter Released");
    }
}

class Decrementer implements Runnable {

    CountDownLatch latch = null;

    public Decrementer(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {

        try {
            Thread.sleep(1000);
            for(int i=0; i<20; i++) {
            	System.out.println(i);
            }
            System.out.println(Thread.currentThread());
            this.latch.countDown();            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}