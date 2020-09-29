package com.defy.stream.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class MapSortGroupBy2 {

//	Map<K, V>.Entry<K, V>put(1, "one");

	public static void main(String[] arg) {
		List<Employee> randomMap = new ArrayList<>();

		MapSortGroupBy2 mapSort = new MapSortGroupBy2();
		mapSort.addToList(randomMap);

	}

	void addToList(List<Employee> empList) {
		empList.add(new Employee(1, "One", 10000, 1));
		empList.add(new Employee(2, "two", 20000, 1));
		empList.add(new Employee(3, "three", 30000, 1));
		empList.add(new Employee(4, "Four", 40000, 2));
		empList.add(new Employee(5, "Five", 50000, 2));
		empList.add(new Employee(6, "Six", 60000, 2));
		empList.add(new Employee(7, "Seven", 70000, 3));
		empList.add(new Employee(8, "Eight", 80000, 3));
		empList.add(new Employee(9, "Nine", 90000, 3));
		empList.add(new Employee(10, "Ten", 100000, 4));
		empList.add(new Employee(11, "Eleven", 110000, 4));
		empList.add(new Employee(12, "Twelve", 120000, 4));

		System.out.println("=======List=========");
		empList.stream().forEach(x -> printKeyValue(x));
		System.out.println("=======Grouped By Dept-Id=========");

		// Group by dept-id and return Map with key as dept-id and list of employees per
		// deptid
		Map<Integer, List<Employee>> groupedByDeptId = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDeptId));
		System.out.println(groupedByDeptId);

		// Group by dept-id and return Map with key as dept-id and set of employee name
		// only, per deptid
		Map<Integer, Set<String>> deptIdNames = empList.stream().collect(
				Collectors.groupingBy(Employee::getDeptId, Collectors.mapping(Employee::getName, Collectors.toSet())));
		System.out.println(deptIdNames);

		// Calculate Average, Group By Department Id
		Map<Integer, Double> avgByDeptId = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDeptId, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(avgByDeptId);

		// Group by dept-id and return Map with key as dept-id and list of employees per
		// deptid
		Double avgSalry = empList.stream().collect(Collectors.averagingDouble(Employee::getSalary));

		List<String> ls = new ArrayList<String>();
		ls.add("aa");
		ls.add("aa");
		ls.add("bb");
		ls.add("cc");
		ls.add("dd");
		ls.add("ee");
		ls.add("ee");
		ls.add("aa");
		ls.add("aa");

		Map<String, Long> occurance = ls.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		System.out.println("occurance: " + occurance);
	}

	void printKeyValue(Employee emp) {
		System.out.println("Name: " + emp.getName());
	}
}
