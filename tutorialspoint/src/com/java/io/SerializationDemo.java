package com.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NonLiving {}
class Vehicle extends NonLiving {
	String color = "brown";
	String make = "lexus";
	
}
class Car extends Vehicle implements Serializable{
	private String company;
	
	public Car() {
		color = "red";
		make = "123";
		company = "Maruti";
	}
	
	public Car(String co, String mk, String cm) {
		color = co;
		make = mk;
		company = cm;
	}
	
	public void display() {
		System.out.println("color: " + color + "  make: " + make + "  company: " + company);
	}
}

class SerializationDemo {
	public static void main(String []args) throws IOException 
	{
		Car c = new Car("blue","234","Honda");
		Car c1 = new Car();
		System.out.println("Before----->");
		c.display();
		try {
			FileOutputStream fout = new FileOutputStream("/tmp/car.ser");
			ObjectOutputStream oo = new ObjectOutputStream(fout);
			oo.writeObject(c);
			oo.close();
			//fout.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream fin = new FileInputStream("/tmp/car.ser");
			ObjectInputStream oi = new ObjectInputStream(fin);
//			c = (Car) oi.readObject();
			c1 = (Car) oi.readObject();
			oi.close();
			//fin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("After----->");
		c1.display();
	}

}
