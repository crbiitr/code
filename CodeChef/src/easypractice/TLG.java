package easypractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TLG {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());  
		int player1Score=0, player2Score=0;
		int winner=0,winnerLead=0;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			String input[] = s.split(" ");
			player1Score+= Integer.parseInt(input[0]);
			player2Score+= Integer.parseInt(input[1]);
			boolean player1HasHighScore = false;
			player1HasHighScore = player1Score>player2Score?true:false;
			winnerLead = Math.abs(player1Score-player2Score);
			if(winnerLead>max) {
				max = winnerLead;
				if(player1HasHighScore) {
					winner = 1;
				} else {
					winner = 2;
				}
			}
		}
		System.out.print(winner + " " + max);

	}

}
