package com.defy.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class ForkJoinPoolAvgTask extends RecursiveTask<Double> {
	
	private static final long serialVersionUID = 1101845571362650107L;
	
	int[] arr;
	int start;
	int end;

	ForkJoinPoolAvgTask(int[] arr, int start, int end) {
		this.arr = arr;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Double compute() {
		
		int size = end - start + 1;

		if (size > 4) {
			int mid = (end + start) / 2;
			ForkJoinPoolAvgTask task1 = new ForkJoinPoolAvgTask(arr, start, mid);
			ForkJoinPoolAvgTask task2 = new ForkJoinPoolAvgTask(arr, mid + 1, end);
			task1.fork();
			task2.fork();
			Double avg1 = task1.join();
			Double avg2 = task2.join();
			return (avg1 + avg2) / 2;

		} else {
			return calculateAvg();
		}
	}

	private Double calculateAvg() {
		System.out.println(Thread.currentThread());
		Double sum = 0.0;
		for (int i = start; i <= end; i++) {
			sum = sum + arr[i];
		}
		Double avg = sum / (end - start + 1);
		return avg;
	}

}

public class ForkJoinPoolAvg {

	public static void main(String[] arr) {
		ForkJoinPool pool = ForkJoinPool.commonPool();
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24 };
		int start = 0;
		int end = array.length - 1;
		ForkJoinPoolAvgTask task = new ForkJoinPoolAvgTask(array, start, end);
		Double average = pool.invoke(task);
		System.out.println("average is " + average);
	}
}
