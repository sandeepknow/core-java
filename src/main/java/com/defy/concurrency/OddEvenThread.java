package com.defy.concurrency;

public class OddEvenThread {

	public static void main(String[] a) throws InterruptedException {
		OddEvenWriter writer = new OddEvenWriter();

		Thread odd = new Thread() {
			@Override
			public void run() {
				try {
					writer.writeOdd();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread even = new Thread() {
			@Override
			public void run() {
				try {
					writer.writeEven();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		odd.start();
		even.start();

		odd.join();
		even.join();

	}
}

class OddEvenWriter {

	volatile boolean isOdd = true;
	int oddValue = 1;
	int evenValue = 2;

	void writeOdd() throws InterruptedException {
		while (oddValue < 10) {
			synchronized (this) {
				if (!isOdd) {
					wait();

				}
				System.out.println(oddValue);
				System.out.println(Thread.currentThread());
				isOdd = false;
				oddValue = oddValue + 2;
				notify();
			}
		}

	}

	void writeEven() throws InterruptedException {
		while (evenValue < 11) {
			synchronized (this) {
				if (isOdd) {
					wait();

				}
				System.out.println(evenValue);
				System.out.println(Thread.currentThread());
				isOdd = true;
				evenValue = evenValue + 2;
				notify();
			}
		}
	}
}
