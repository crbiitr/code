package com.java.chetan.Enum;

enum Transportation {
	CAR(65), TRUCK(55), AIRPLANE(600), TRAIN(70), BOAT(22);
	
	private int speed;
	Transportation(int s) {speed = s;}
	int getSpeed() {return speed;}
}
public class EnumUses2 {
	public static void main(String []args) {
		
		Transportation tp; // constructor call here once for each constant that specified 
//		tp = Transportation.valueOf("AIRPLANE");
//		System.out.println("Speed of an airplane is : " + tp.getSpeed() + " miles per hour\n");
		System.out.println("Speed of an airplane is : " + Transportation.AIRPLANE.getSpeed() + " miles per hour\n");
		System.out.println("All transport speeds are : ");
		for( Transportation t : Transportation.values()) {
			System.out.println(t + " speed is : " + t.getSpeed() + " miles per hour.");
		}
	}

}
