package com.defy.concurrency;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolTest {

	public static void main(String[] args) {
		int[] array = yourMethodToGetData(500000);
//		int[] array = { 1, 2, 5, 7, 8, 9, 6, 11, 56, 79, 12345, 67, 86, 54, 34, 53, 32, 35, 78, 90, 59, 40, 89, 91, 22,
//				24, 35, 61, 71, 3465, 239, 11, 114, 215, 654, 6457, 8921, 32678, 9019, 8021, 8721, 8645, 1, 2, 5, 7, 8, 9, 6, 11, 56, 79, 12345, 67, 86, 54, 34, 53, 32, 35, 78, 90, 59, 40, 89, 91, 22,
//				24, 35, 61, 71, 3465, 239, 11, 114, 215, 654, 6457, 8921, 32678, 9019, 8021, 8721, 8645, 1, 2, 5, 7, 8, 9, 6, 11, 56, 79, 12345, 67, 86, 54, 34, 53, 32, 35, 78, 90, 59, 40, 89, 91, 22,
//				24, 35, 61, 71, 3465, 239, 11, 114, 215, 654, 6457, 8921, 32678, 9019, 8021, 8721, 8645 };

		ForkJoinPool pool = new ForkJoinPool();
		Integer max = pool.invoke(new FindMaxTask(array, 0, array.length));
		System.out.println(max);
	}

	static int[] yourMethodToGetData(int size) {

		int[] temp = new int[size];
		Random rand = new Random(); // instance of random class
		int upperbound = 10;

		// generate random values from 0-24

		for (int i = 0; i < size; i++) {
			temp[i] = i * rand.nextInt(upperbound);
		}
		return temp;
	}
}

class FindMaxTask extends RecursiveTask<Integer> {

	private int[] array;
	private int start, end;

	public FindMaxTask(int[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		if (end - start <= 3000) {
			int max = -99;
			for (int i = start; i < end; i++) {
				max = Integer.max(max, array[i]);
			}
			return max;

		} else {
			int mid = (end - start) / 2 + start;
			FindMaxTask left = new FindMaxTask(array, start, mid);
			FindMaxTask right = new FindMaxTask(array, mid + 1, end);

			ForkJoinTask.invokeAll(right, left);
			int leftRes = left.getRawResult();
			int rightRes = right.getRawResult();

			return Integer.max(leftRes, rightRes);
		}
	} // end of compute

}
