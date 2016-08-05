package com.java.threads;

public class RaceDemo {

	public static void main(String [] args) {
		Racer racer = new Racer();
		Thread tortoiseThread = new Thread(racer,"Tortoise");
		Thread hare = new Thread(racer,"Hare");
		
		tortoiseThread.start();
		hare.start();
	}
}
