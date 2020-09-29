package com.defy.prime;

public class CheckPrime {

	public static void main(String[] arr) {
		long first = System.currentTimeMillis();
		printPrime();
		long second = System.currentTimeMillis();
		System.out.println("Time taken in millis " + (second - first));
		long third = System.currentTimeMillis();
		printPrimeEfficient();
		long fourth = System.currentTimeMillis();
		System.out.println("Time taken in millis in Efficient " + (fourth - third));

	}

	static void printPrime() {
		int counter = 0;
		for (int i = 2; i < 1000; i++) {
			boolean isPrime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0)
					isPrime = false;
			}
			if (isPrime) {
				System.out.printf("%d", i);
				counter++;
				if (counter == 10) {
					System.out.print(" is 10th Prime number.");
				}
				System.out.println("");
			}

		}

	}
	
	static void printPrimeEfficient() {
		int counter = 0;
		for (int i = 2; i < 1000; i++) {
			boolean isPrime = true;
			for (int j = 2; j < i/2; j++) {
				if (i % j == 0)
					isPrime = false;
			}
			if (isPrime) {
				System.out.printf("%d", i);
				counter++;
				if (counter == 10) {
					System.out.print(" is 10th Prime number.");
				}
				System.out.println("");
			}
		}
	}

}
