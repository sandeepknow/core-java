package com.defy.ds;

import java.util.Scanner;

public class PalindromeCheck {

	public static void main(String[] a) {

		Scanner in = new Scanner(System.in);

		String str = in.nextLine();

		boolean palindrome = isPalindrome(str);
		System.out.printf("Enetered String '%s' is Palindrome : %b", str, palindrome);

	}

	static boolean isPalindrome(String inputString) {
		int i = 0, j = inputString.length() - 1;

		while (i < j) {
			if (inputString.charAt(i) != inputString.charAt(j))
				return false;

			i++;
			j--;
		}
		return true;
	}
}
