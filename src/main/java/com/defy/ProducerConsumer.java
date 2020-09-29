package com.defy;

import java.util.LinkedList;

public class ProducerConsumer {

	public static void main(String[] a) throws InterruptedException {
		Buffer queue = new Buffer(2);
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
					;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		producer.start();
		consumer.start();

		producer.join();
		producer.join();

	}

	static class Buffer {
		
		LinkedList<Integer> data;
		int size;

		Buffer(int size) {
			this.size = size;
			data = new LinkedList<Integer>();
		}

		void produce() throws InterruptedException {
			int value = 0;
			while (true) {
				synchronized (this) {
					if (data.size() >= size) {

						wait();
					}
					data.add(value);
					System.out.println("Produced : " + value);
					value++;

					// Notify Consumer
					notify();
					Thread.sleep(2000);
				}
			}
		}

		void consume() throws InterruptedException {
			while (true) {
				synchronized (this) {
					if (data.size() == 0) {

						wait();
					}
					int value = data.poll();
					System.out.println("Consumed : " + value);

					// Notify Producer
					notify();
					Thread.sleep(2000);
				}
			}
		}

	}
}
