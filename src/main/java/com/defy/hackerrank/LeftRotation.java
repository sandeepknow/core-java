package com.defy.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

class Result {

	/*
	 * Complete the 'rotateLeft' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER d 2. INTEGER_ARRAY arr
	 */

	public static List<Integer> rotateLeft(int d, List<Integer> list) {
		// Write your code here
		int counter = 0;
		int[] arr = convertListToArrayInteger(list);
		while (counter < d) {
			rotateLeftOnce(arr);
			counter++;
		}
		
		return Arrays.stream(arr).boxed().collect(Collectors.toList());
	}

	public static void rotateLeftOnce(int[] arr) {
		// Write your code here

		int temp = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			temp = arr[i];
			arr[i] = arr[i + 1];
			arr[i + 1] = temp;
		}
	}

	public static int[] convertListToArrayInteger(List<Integer> list) {
		int size = list.size();
		int[] result = new int[size];
		Integer[] temp = list.toArray(new Integer[size]);
		for (int n = 0; n < size; ++n) {
			result[n] = temp[n];
		}
		return result;
	}

}

public class LeftRotation {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int d = Integer.parseInt(firstMultipleInput[1]);

		String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		List<Integer> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrTemp[i]);
			arr.add(arrItem);
		}

		List<Integer> result = Result.rotateLeft(d, arr);

		for (int i = 0; i < result.size(); i++) {
			bufferedWriter.write(String.valueOf(result.get(i)));

			if (i != result.size() - 1) {
				bufferedWriter.write(" ");
			}
		}

		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
