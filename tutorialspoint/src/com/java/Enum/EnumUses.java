package com.java.Enum;

enum Transport {
	CAR, TRUCK, AIRPLANE, TRAIN, BOAT;
}

public class EnumUses {
	public static void main(String [] args) {
		
		Transport tp;
		tp = Transport.AIRPLANE;
		System.out.println("Value of tp is : " + tp);
		
		tp = Transport.TRAIN;
		if(tp == Transport.TRAIN) {
			System.out.println("tp contains TRAIN");
		}
		
//		if(tp == "TRAIN") {} //ERROR, Incompatible operand types Transport and String
		
		switch(tp) {
		    case CAR:
			    System.out.println("A car carries people.");
			    break;
			case TRUCK:
			    System.out.println("A truck carries freight.");
			    break;
			case AIRPLANE:
			    System.out.println("An airplane flies.");
			    break;
			case TRAIN:
			    System.out.println("A train runs on rails.");
			    break;
			case BOAT:
			    System.out.println("A boat sails on water.");
			    break;
			}

		Transport allTransport[] = Transport.values(); //obtain an array of enum constant
		for(Transport t:allTransport) {
			System.out.print("  " + t);
		}
		
		tp = Transport.valueOf("TRAIN");
		System.out.println("\nValue of tp is : " + tp);
		
		// Obtain all ordinal values using ordinal().
		System.out.println("Here are all Transport constants and their ordinal values: ");
		for(Transport t : Transport.values())
			System.out.println(t + " " + t.ordinal());

		
		Transport tp2, tp3, tp4;
		tp2 = Transport.AIRPLANE;
		tp3 = Transport.CAR;
		tp4 = Transport.AIRPLANE;
		
		if(tp2.compareTo(tp3) > 0) {
			System.out.println(tp2 + " comes after " + tp3);
		}
		
		if(tp3.compareTo(tp2) > 0) {
			System.out.println(tp3 + " comes after " + tp2);
		} else {
			System.out.println(tp3 + " comes before " + tp2);
		}
		
		if(tp4.compareTo(tp2) == 0) {
			System.out.println(tp3 + " equals " + tp2);
		}
	}

}
