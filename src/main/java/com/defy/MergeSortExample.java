package com.defy;

public class MergeSortExample {

	void mergSort(int[] arr) {

		int size = arr.length;
		if(size<2) return;
		
		int mid = size / 2;

		int[] leftArray = new int[mid];
		int[] rightArray = new int[size - mid];

		for (int i = 0; i < mid; i++)
			leftArray[i] = arr[i];

		for (int j = 0; j < size - mid; j++)
			rightArray[j] = arr[j];
		mergSort(leftArray);
		mergSort(rightArray);
		merge(arr, leftArray, rightArray);
		
		
	}

	void merge(int[] parent, int[] left, int[] right) {

		int k = 0, i = 0, j = 0;
		while (left.length > i && right.length > j) {
			if (left[i] < right[j]) {
				parent[k] = left[i];
				i++;
			} else {
				parent[k] = right[j];
				j++;
			}
			k++;
		}
		while (left.length > i) {
			parent[k] = left[i];
			i++;
			k++;
		}
		while (right.length > j) {
			parent[k] = left[j];
			j++;
			k++;
		}

//		return parent;
	}
}
