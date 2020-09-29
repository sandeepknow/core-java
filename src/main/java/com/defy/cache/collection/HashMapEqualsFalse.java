package com.defy.cache.collection;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapEqualsFalse {

	public static void main(String[] a) {
		HashMap<Student, Integer> map = new HashMap<Student, Integer>();
		
		map.put(new Student(1, "one"), 1);
		map.put(new Student(2, "two"), 2);
		map.put(new Student(3, "three"), 3);
		Set<Entry<Student,Integer>> entrySet = map.entrySet();
		map.values().stream().forEach(System.out::println);

		System.out.println(map.get(new Student(1, "one")));
		System.out.println(map.get(new Student(2, "two")));
		System.out.println(map.get(new Student(3, "three")));
	}
}

class Student {
	int rollno;
	String name;

	public Student(int rollno, String name) {
		super();
		this.rollno = rollno;
		this.name = name;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}
}
