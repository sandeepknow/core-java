package com.defy.algo;

public class NoOfOccurance {

	public static void main(String[] a) {
		int[] inputArray = { 1, 1, 2, 2, 3, 3, 4, 4, 5 };
		int count = findUnique(inputArray);
		System.out.println("No of unique numbers " + count);
	}

	static int findUnique(int[] array) {
		if (array.length == 0)
			return -1;
		int unique = 1;
		int size = array.length;
		for (int i = 1; i < size; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == j)
					unique++;
				if (array[i] == array[j])
					break;

			}

		}
		return unique;
	}
}
