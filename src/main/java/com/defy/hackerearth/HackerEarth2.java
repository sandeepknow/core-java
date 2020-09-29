package com.defy.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HackerEarth2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String readTest = br.readLine(); // Reading input from STDIN

		int noOfStuds = Integer.valueOf(readTest);

		String secondLine = br.readLine(); // Reading input from STDIN
		String[] studMarks = secondLine.split(" ");

		int[] studentMarks = Arrays.stream(studMarks).mapToInt(Integer::parseInt).toArray();

		for (int i = 0; i < studentMarks.length; i++) {
			int current = studentMarks[i];
			boolean gt = true;
			for (int j = i + 1; j < studentMarks.length; j++) {
				if (current < studentMarks[j])
					gt = false;
			}
			if(gt)
				System.out.print(current+" ");
		}
//			previous = current;
	}
//		System.out.println("Hi, " + seconds + "."); // Writing output to STDOUT

}
