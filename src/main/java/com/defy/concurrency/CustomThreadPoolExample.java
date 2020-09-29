package com.defy.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPoolExample {

}

class CustomThread {
	int size;
	WorkerThread[] workers;
	BlockingQueue<Runnable> queue = null;

	CustomThread(int size) {
		this.size = size;
		queue = new LinkedBlockingQueue<Runnable>();
		for (int i = 0; i < size; i++) {
			workers[i] = new WorkerThread();
			workers[i].start();
		}
	}

	void execute(Runnable task) {
		synchronized (queue) {
			queue.add(task);
			queue.notify();
		}
	}

	class WorkerThread extends Thread {

		Runnable task;

		@Override
		public void run() {
			synchronized (queue) {
				if (queue.isEmpty()) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				task = (Runnable) queue.poll();
				task.run();
			}
		}
	}
}
