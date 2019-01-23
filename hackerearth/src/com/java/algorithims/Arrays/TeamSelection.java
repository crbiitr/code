package com.java.algorithims.Arrays;

import java.util.*;

/**
 * Created by B0204104 on 21/11/18.
 */
public class TeamSelection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] A = new int[length];
        int[] B = new int[length];
        for (int i = 0; i < length; i++) {
            A[i] = scanner.nextInt();
        }

        for (int i = 0; i < length; i++) {
            B[i] = scanner.nextInt();
        }

        List<Team> teams = new LinkedList<>();

        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (A[i] < A[j]) {
                    teams.add(new Team(A[i], B[j], 0));
                }
            }
        }

        Iterator<Team> iterator = teams.listIterator();
        List<Team> listNew = new LinkedList<>();
        while (iterator.hasNext()) {
            Team team = iterator.next();
            for (int i = 0; i < length; i++) {
                if (team.getPlayer2() < B[i] && team.getPlayer3()==0) {
                    team.setPlayer3(B[i]);
                } else if(team.getPlayer2() < B[i] && team.getPlayer3()!=0){
                    listNew.add(new Team(team.getPlayer1(),team.getPlayer2(),B[i]));
                }
            }
        }


        Iterator<Team> iterator1 = teams.listIterator();
        int result = 0;
        while (iterator1.hasNext()) {
            Team team = iterator1.next();
            if (team.getPlayer3() != 0) {
                result++;
            }
        }
        System.out.println(result+listNew.size());
    }

}


class Team {
    private int player1;
    private int player2;
    private int player3;

    public Team() {
    }

    public Team(int player1, int player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Team(int player1, int player2, int player3) {
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
    }

    public int getPlayer1() {
        return player1;
    }

    public void setPlayer1(int player1) {
        this.player1 = player1;
    }

    public int getPlayer2() {
        return player2;
    }

    public void setPlayer2(int player2) {
        this.player2 = player2;
    }

    public int getPlayer3() {
        return player3;
    }

    public void setPlayer3(int player3) {
        this.player3 = player3;
    }
}
