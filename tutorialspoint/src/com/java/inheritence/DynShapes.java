package com.java.inheritence;

class TwoDShape {
	
	private double weight;
	private double height;
	private String name;
	
	TwoDShape() {
		weight = height= 0.0;
		name = "null";
	}
	
	TwoDShape (double w, double h, String s) {
		weight = w;
		height = h;
		name = s;
	}
	
	TwoDShape(double x, String n) {
		weight = height = x;
		name = n;
	}
	
	TwoDShape(TwoDShape obj) {
		weight = obj.weight;
		height = obj.height;
		name = obj.name;
	}
	
	double getHeight () {
		return height;
	}
	double getWeight() {
		return weight;
	}
	void setHeight(double h) {
		height = h;
	}
	void setWidth(double w) {
		weight = w;
	}
	String getName() {
		return name;
	}
	
	void showDim() {
		System.out.println("Dimension is :: " +weight+ "x" + height);
	}
	
	double area() {
		System.out.println("area() must be overridden");
		return 0.0;
	}
	
}

class Trianglee extends TwoDShape {
	
	private String style;
	Trianglee () {
		super();
		style = "null";
	}
	
	Trianglee(String s, double w, double h) {
		super(w,h,"triangle");
		style = s;
	}
	
	Trianglee(double x) {
		super(x, "triangle");
		style = "isosceles";
	}
	
	Trianglee(Trianglee obj) {
		super(obj);
		style = obj.style;
	}
	
	double area() {
		return getWeight() * getHeight() /2;
	}
	
	void showStyle() {
		System.out.println("Triangle is of style :: " + style);
	}
}
public class DynShapes {

}
