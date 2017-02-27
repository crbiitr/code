package com.java.inheritance;

class TwoDShap {
	double height;
	double weight;
	
	void showDimension() {
		System.out.println("Dimension is :: " + weight + "x" + height );
	}
}

class Triangle extends TwoDShap {
	String style;
	
	double area() {
		return weight*height/2;
	}
	
	void showStyle () {
		System.out.println("Triangle style is :: "  + style);
	}
}



public class Shape {

	public static void main(String args[]) {
		
		Triangle t1 = new Triangle();
		Triangle t2 = new Triangle();
		
		t1.weight = 4.0;
		t1.height = 2.0;
		t1.style = "isoscele";
		
		t2.weight = 5.0;
		t2.height = 5;
		t2.style = "right";
		
		System.out.println("Info for t1 triangle\n");
		t1.showDimension();
		t1.showStyle();
		System.out.println("area of t1 :: " + t1.area());
		
		System.out.println("\n\nInfo for t2 triangle\n");
		t2.showDimension();
		t2.showStyle();
		System.out.println("area of t2 :: " + t2.area());
		
	}
}
