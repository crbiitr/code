package com.java.generics;

class NumericFuns<T extends Number> {
	
	T num;
	public NumericFuns(T n) {
		num = n;
	}
	
	// Return the reciprocal.
	double reciprocal() {
		return 1 / num.doubleValue();
	}
	// Return the fractional component.
	double fraction() {
		return num.doubleValue() - num.intValue();
	}

	boolean absEqual(NumericFuns<?> ob) {
		if(Math.abs(num.doubleValue()) == Math.abs(ob.num.doubleValue())) return true;
		return false;
	}
}

public class BoundAndWildcardDemo {

	public static void main(String [] args) {
		
		NumericFuns<Integer> iOb = new NumericFuns<Integer>(6);
		NumericFuns<Double> dOb = new NumericFuns<Double>(-6.0);
		NumericFuns<Long> lOb = new NumericFuns<Long>(5L);
		
		System.out.println("Testing iOb and dOb.");
		if(iOb.absEqual(dOb))
			System.out.println("Absolute values are equal.");
		else
			System.out.println("Absolute values differ.");
		
		System.out.println();
		System.out.println("Testing iOb and lOb.");
		if(iOb.absEqual(lOb))
			System.out.println("Absolute values are equal.");
		else
			System.out.println("Absolute values differ.");

	}
}
