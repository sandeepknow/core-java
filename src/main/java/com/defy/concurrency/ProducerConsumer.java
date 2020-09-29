package com.defy.concurrency;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumer {

	public static void main(String[] a) throws InterruptedException {
		ResourceQueue queue = new ResourceQueue(2);

		Thread producer = new Thread() {

			@Override
			public void run() {
				try {
					queue.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread consumer = new Thread() {

			@Override
			public void run() {
				try {
					queue.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		producer.start();
		consumer.start();

		producer.join();
		consumer.join();
	}

}

class ResourceQueue {
	List<Integer> queue;
	int size;
	int val = 1;

	ResourceQueue(int size) {
		this.size = size;
		queue = new LinkedList<Integer>();
	}

	void produce() throws InterruptedException {
		while (true) {
			synchronized (this) {
				if (queue.size() >= size) {
					wait();
				}
				
				queue.add(val);
				System.out.println("Added to queue " + val);
				val++;
				notify();
				Thread.sleep(1000); 
			}
		}
	}

	void consume() throws InterruptedException {
		while (true) {
			synchronized (this) {
				if (queue.size() == 0) {
					wait();
				}
				int consumed = ((LinkedList<Integer>) queue).poll();
				System.out.println("Consumed from queue " + consumed);
				notify();
				
				Thread.sleep(1000); 
			}
		}
	}

}
