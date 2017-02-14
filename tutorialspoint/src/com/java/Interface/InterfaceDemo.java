package com.java.Interface;

interface A { 
//	int x;//The blank final field x may not have been initialized
	int x=4;
	String temp = "Chetan";
	void meth1();
	void meth2();
}

interface B extends A{ 
	void meth3();
	void meth4();
}
//class MyClass implements B{
//
//		public void meth1() {
//			System.out.println("in meth1()");
//		}
//		
//		public void meth2() {
//			System.out.println("in meth2()");
//		}
//		
//		public void meth3() {
//			System.out.println("in meth3()");
//		}
//		
//		public void meth4() {
//			System.out.println("in meth4()");
//		}
//}

class InterfaceDemo implements B{

	public void meth1() {
		System.out.println("in meth1()");
	}

	
	public void meth2() {
		System.out.println("in meth2()");
	}
	
	public void meth3() {
		System.out.println("in meth3()");
	}
	
	public void meth4() {
		System.out.println("in meth4()");
	}
	
	public static void main(String [] args) {
//		MyClass m = new MyClass();
		
		InterfaceDemo I = new InterfaceDemo();
		I.meth1();
	}
}
