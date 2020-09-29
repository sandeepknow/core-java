package com.defy;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool {

	int sizeOfPool;
	WorkerThread[] pool;
	BlockingQueue<Runnable> queue;

	public MyThreadPool(int sizeOfPool) {

		this.sizeOfPool = sizeOfPool;
		pool = new WorkerThread[sizeOfPool];
		queue = new LinkedBlockingQueue<Runnable>();

		for (int i = 0; i < sizeOfPool; i++) {
			pool[i] = new WorkerThread();
			pool[i].start();
		}
	}

	void execute(Runnable task) {

		synchronized (queue) {
			queue.add(task);
			queue.notify();
		}
	}

	class WorkerThread extends Thread {

		@Override
		public void run() {
			Runnable task;

			while (true) {
				synchronized (queue) {

					while (queue.isEmpty()) {

						try {
							queue.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					task = (Runnable) queue.poll();
				}
				try {
					task.run();
				} catch (RuntimeException e) {

				}
			}

		}
	}
}
