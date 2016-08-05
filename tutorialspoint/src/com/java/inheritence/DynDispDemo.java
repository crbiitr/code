package com.java.inheritence;

class Sup {
	void who() {
		System.out.println("who() in sup");
	}
}

class Sub1 extends Sup {
	void who() {
		System.out.println("who() in sub1");
	}
	
	void Display() {
		System.out.println("Display in Sub1");
	}
}

class Sub2 extends Sup {
	void who() {
		System.out.println("who() in sub2");
	}
	
	void Display() {
		System.out.println("Display in Sub2");
	}
}

public class DynDispDemo {

	public static void main(String [] args) {
		
		Sup superObj = new Sup();
		Sub1 sub1Obj = new Sub1();
		Sub2 sub2Obj = new Sub2();
		
		Sup supRef ;
		
		supRef = superObj;
		supRef.who();
		
		supRef = sub1Obj;
		supRef.who();
		
		supRef = sub2Obj;
		supRef.who();
		
	}
}
