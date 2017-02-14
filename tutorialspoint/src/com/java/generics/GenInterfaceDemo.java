package com.java.generics;

interface Containment<T> {
	
	boolean contain(T o);
}

// Any class that implements a generic interface must itself be generic.
class MyClass<T>  implements Containment<T> {
	
	T[] arrRef;
	public MyClass(T[] o) {
		arrRef = o;
	}
	// implements contain method
	public boolean contain(T o) {
		for(T x : arrRef) {
			if(x.equals(o)) return true;
		}
		return false;
	}
}

public class GenInterfaceDemo{

	public static void main(String[] args) {
			Integer x[] = {1,2,3};
			MyClass<Integer> ob = new MyClass<Integer>(x);
			if(ob.contain(2))
				System.out.println(" 2 is Present in ob");
			else 
				System.out.println(" 2 does not Present in ob");

			if(ob.contain(5))
				System.out.println(" 5 is Present in ob");
			else 
				System.out.println(" 5 does not Present in ob");

			// The following is illegal because ob is an Integer Containment and 9.25 is a Double value. 
//			if(ob.contain(5.2))		// Illegal!
//				System.out.println(" 5.2 is Present in ob"); 
	}

}
