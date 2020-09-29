package com.defy.inheritance;

import java.util.HashSet;
import java.util.Set;

class A {
	static final Set<Class<?>> classes = new HashSet<>();

	A() {
		if (!classes.add(getClass())) {
			throw new IllegalStateException(
					"One Instance per Hirarchy Allowed, Instance of class " + getClass() + "Already created");
		}
	}
}

class B extends A {

}

class C extends B {

}

public class OnePerHierarchy {

	public static void main(String[] arg) {
		A a1 = new A();
		B b1 = new B();
		C c1 = new C();
		A a2 = new A();
		B b2 = new B();
		C c2 = new C();

	}
}
