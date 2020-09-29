package com.defy.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MonthEnum {
	public static void main(String[] a) {
		List<String> monthList = Arrays.asList("FEBRUARY", "JANUARY", "DECEMBER", "APRIL", "MARCH", "JUNE", "MAY",
				"JULY", "SEPTEMBER", "AUGUST", "OCTOBER");
		monthList.stream().forEach(System.out::println);
		System.out.println("=======================================");

		// Here using valueOf(String value), stream each value is changed from String to
		// Enum type and then
		// Applying sorted on the list of Enum elements rather than String values.

//		List<Months> sortedMonths = monthList.stream().map(x -> Months.valueOf(x)).sorted()
//				.collect(Collectors.toList());
		List<Months> sortedMonths = monthList.stream().map(x -> Enum.valueOf(Months.class, x)).sorted()
				.collect(Collectors.toList());
//		List<String> sortedMonths = monthList.stream().sorted().collect(Collectors.toList());
		sortedMonths.stream().forEach(System.out::println);
	}
}

enum Months {

	JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;

}
