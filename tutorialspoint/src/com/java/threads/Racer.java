package com.java.threads;

public class Racer implements Runnable{
	public static String winner;
	
	void race() {
		for(int distance = 1; distance <= 100; distance++) {
			System.out.println("Distance covered by " + Thread.currentThread().getName() +" is "+ distance + " meter.");
			boolean isRaceWon = this.isRaceWon(distance);
			
			if(isRaceWon) {
				break;
			}
		}
	}
	
	private boolean isRaceWon(int totalDistace) {
		boolean isRaceWon = false;
		
		if((Racer.winner == null) && (totalDistace == 100)) {
			String winnerName = Thread.currentThread().getName();
			Racer.winner = winnerName;
			System.out.println("Winner is " + Racer.winner);
			isRaceWon = true;
		} else if(Racer.winner == null) {
			isRaceWon = false;
		} else if(Racer.winner != null) {
			isRaceWon = true;
		}
		
		return isRaceWon;
	}
	
	public void run() {
		this.race();
	}

}
