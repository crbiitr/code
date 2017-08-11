package com.java.OtherImportantQuestions;

/**
 * Created by chetan on 13/3/17.
 * Simple Solution : http://code.geeksforgeeks.org/jtBvEm
 * https://www.youtube.com/watch?v=_Uq1dmgZj0I
 * https://dl.dropboxusercontent.com/u/14935294/ProgrammingVideos/4-Print_Valid_Parenthesis_Combinations/ParenthesisPrint.java
 */
public class AllCombinationsOfBalancedParentheses {
    public static void main(String[] args) {
        int n = 3;
        StringBuilder sb = new StringBuilder();

        printParentheses(n,n,"");
    }

    //define method header
    //left and right remains are keeping track of how many remaining parenthesis left for printing
    //currentString is used to keep track of the current printout for each recursive call
    public static void printParentheses(int leftRemain, int rightRemain, String currentString) {

        //firstly check if there is need to go further
        if (rightRemain == 0) { //all printed out
            System.out.println(currentString.toString());
            return;
        }

        //now coming to the recursive part
        if (leftRemain>0) { //more left parenthesis left for printing

            //choice 1, print another left parenthesis
            printParentheses(leftRemain-1,rightRemain,currentString+("("));

            //choice 2, print right parenthesis if valid
            if (leftRemain<rightRemain) //which means more left parenthesis have been used
                printParentheses(leftRemain,rightRemain-1,currentString+(")"));
        } else { //now there are only right parenthesis left
            printParentheses(leftRemain,rightRemain-1,currentString+(")"));
        }
    }
}
