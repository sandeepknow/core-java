package com.defy.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HackerEarth {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String readTest = br.readLine(); // Reading input from STDIN

		int testcases = Integer.valueOf(readTest);

		String secondLine = br.readLine(); // Reading input from STDIN
		String[] secondArr = secondLine.split(" ");

		String arrayLine = br.readLine(); // Reading input from STDIN
		String[] valuesStr = arrayLine.split(" ");

		int arraySize = Integer.valueOf(secondArr[0]);
		int maxValue = Integer.valueOf(secondArr[1]);

		int[] arrayValues = Arrays.stream(valuesStr).mapToInt(Integer::parseInt).toArray();
		int seconds = 0;
		while(Arrays.stream(arrayValues).parallel().filter( x -> x < maxValue).findAny().isPresent()) {
			arrayValues = Arrays.stream(arrayValues).map(x -> x + 1).toArray();
			seconds = seconds + 1;
		}		

		System.out.println("Hi, " + seconds + "."); // Writing output to STDOUT

	}
}
