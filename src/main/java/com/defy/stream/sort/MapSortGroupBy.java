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

public class MapSortGroupBy {

//	Map<K, V>.Entry<K, V>put(1, "one");

	public static void main(String[] arg) {
		List<Employee> randomMap = new ArrayList<>();

		MapSortGroupBy mapSort = new MapSortGroupBy();
		mapSort.addToList(randomMap);

	}

	void addToList(List<Employee> emplList) {
		emplList.add(new Employee(1, "One", 10000, 1));
		emplList.add(new Employee(2, "two", 20000, 1));
		emplList.add(new Employee(3, "three", 30000, 1));
		emplList.add(new Employee(4, "Four", 40000, 2));
		emplList.add(new Employee(5, "Five", 50000, 2));
		emplList.add(new Employee(6, "Six", 60000, 2));
		emplList.add(new Employee(7, "Seven", 70000, 3));
		emplList.add(new Employee(8, "Eight", 80000, 3));
		emplList.add(new Employee(9, "Nine", 90000, 3));
		emplList.add(new Employee(10, "Ten", 100000, 4));
		emplList.add(new Employee(11, "Eleven", 110000, 4));
		emplList.add(new Employee(12, "Twelve", 120000, 4));

		System.out.println("=======List=========");
		emplList.stream().forEach(x -> printKeyValue(x));
		System.out.println("=======Grouped By Dept-Id=========");

		// Group by dept-id and return Map with key as dept-id and list of employees per deptid
		Map<Integer, List<Employee>> empMap = emplList.stream().collect(Collectors.groupingBy(Employee::getDeptId));
		System.out.println(empMap);

		// Group by dept-id and return Map with key as dept-id and set of employee name only, per deptid
		Map<Integer, Set<String>> empMap2 = emplList.stream().collect(
				Collectors.groupingBy(Employee::getDeptId, Collectors.mapping(Employee::getName, Collectors.toSet())));
		System.out.println(empMap2);
		
		//Calculate Average, Group By Department Id
		Map<Integer, Double> avgByDeptId = emplList.stream().collect(
				Collectors.groupingBy(Employee::getDeptId, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(avgByDeptId);
		
		// Group by dept-id and return Map with key as dept-id and list of employees per deptid
		Double avgDouble = emplList.stream().collect(Collectors.averagingDouble(x -> x.getSalary()));
		System.out.println(avgDouble);
		Double avgInt = emplList.stream().collect(Collectors.averagingInt(x -> x.getSalary()));
		System.out.println(avgInt);
		Double avgLong = emplList.stream().collect(Collectors.averagingLong(x -> x.getSalary()));
		System.out.println(avgLong);

	}

	void printKeyValue(Employee emp) {
		System.out.println("Name: " + emp.getName());
	}
}

class Employee {

	int empId;
	String name;
	int salary;
	int deptId;

	public Employee(int empId, String name, int salary, int deptId) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.deptId = deptId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "emp id=" + empId + " name=" + Optional.ofNullable(name).orElse("\" \"") + " salary=" + salary
				+ " deptId=" + deptId;
	}

}
