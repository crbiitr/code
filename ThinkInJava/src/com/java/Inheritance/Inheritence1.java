package com.java.Inheritance;

class Base {
	public Base() {
		System.out.println("Inside com.java.Inheritance.Base Constructor");
	}
	public void display() {
		System.out.println("Display");
	}
}

public class Inheritence1 extends Base {
	
	public Inheritence1() {
		System.out.println("Inside com.java.Inheritance.Inheritence1");
	}
	
	public static void main(String []args) {
		Inheritence1 in = new Inheritence1();
		in.display();
	}

}
