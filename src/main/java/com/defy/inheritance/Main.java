package com.defy.inheritance;

//filename: Main.java 
class Base {
	{
		System.out.println("Base class Object initializer");
	}
	static {
		System.out.println("Base class Static initializer");
	}
	Base(String s) {
		System.out.println("Base Class - User Defined Constructor Called ");
	}
	
}

class Derived extends Base {
	{
		System.out.println("Derived class Object initializer");
	}
	static {
		System.out.println("Derived class Static initializer");
	}
	Derived() {
		super("");
		System.out.println("Derived Class Constructor Called ");
	}
}

public class Main {
	public static void main(String[] args) {
		Derived d = new Derived();
		System.out.println("================================================= ");
		Derived d2 = new Derived();
	}
}