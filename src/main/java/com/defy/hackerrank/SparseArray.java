package com.defy.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SparseArray {

	// Complete the matchingStrings function below.
	static int[] matchingStrings(String[] strings, String[] queries) {
		int[] matching = new int[queries.length]; 
		for(int i = 0; i< queries.length; i++) {
			matching[i]=matchString(strings, queries[i]);
		}
		
		return matching;
	}

	static int matchString(String[] strings, String query) {

		int counter = 0;
		for (int i = 0; i < strings.length; i++) {
			if(query.equals(strings[i]))
				counter++;
		}
		return counter;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int stringsCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] strings = new String[stringsCount];

		for (int i = 0; i < stringsCount; i++) {
			String stringsItem = scanner.nextLine();
			strings[i] = stringsItem;
		}

		int queriesCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] queries = new String[queriesCount];

		for (int i = 0; i < queriesCount; i++) {
			String queriesItem = scanner.nextLine();
			queries[i] = queriesItem;
		}

		int[] res = matchingStrings(strings, queries);

		for (int i = 0; i < res.length; i++) {
			bufferedWriter.write(String.valueOf(res[i]));

			if (i != res.length - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
