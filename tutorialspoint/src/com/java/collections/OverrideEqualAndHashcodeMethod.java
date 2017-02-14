package com.java.collections;

public class OverrideEqualAndHashcodeMethod {

	private String color;
	private String stripPattern;
	private int height;
	
	public OverrideEqualAndHashcodeMethod(String color, String stripPattern, int height) {
		this.color = color;
		this.stripPattern = stripPattern;
		this.height = height;
	}
	
	String getColor() {
		return color;
	}

	void setColor(String color) {
		this.color = color;
	}

	String getStripPattern() {
		return stripPattern;
	}

	void setStripPattern(String stripPattern) {
		this.stripPattern = stripPattern;
	}

	int getHeight() {
		return height;
	}

	void setHeight(int height) {
		this.height = height;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
//		if(this == null) result = true;
		if(obj == null || obj.getClass() != this.getClass()) result = false;
		else {
			OverrideEqualAndHashcodeMethod OEAHM = (OverrideEqualAndHashcodeMethod) obj;
			if(this.color == OEAHM.color && this.stripPattern == OEAHM.stripPattern) result = true;
		}
		
		return result;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + (this.color != null ?this.color.hashCode():0);
		result = prime * result + this.stripPattern.hashCode(); // Note: always check null check, hear that check is not using 
		
		return result;
	} 
	
	public static void main(String[] args) {

		OverrideEqualAndHashcodeMethod obj1 = new OverrideEqualAndHashcodeMethod("Yellow", "Dense", 3);
		OverrideEqualAndHashcodeMethod obj2 = new OverrideEqualAndHashcodeMethod("Yellow", "Dense", 2);
		OverrideEqualAndHashcodeMethod obj3 = new OverrideEqualAndHashcodeMethod("White", "Sparse", 4);

		System.out.println("Result of obj1.equals(obj2)  :: " + obj1.equals(obj2));
		System.out.println("Result of obj1.equals(obj3)  :: " + obj1.equals(obj3));
		
		System.out.println("hash code of obj1  ::  "  + obj1.hashCode());
		System.out.println("hash code of obj2  ::  "  + obj2.hashCode());
		System.out.println("hash code of obj3  ::  "  + obj3.hashCode());
	}

}
