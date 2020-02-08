package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToeView {
    
    private final Scanner keyboard;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView() {
        
        /* Initialize scanner (for console keyboard) */
        
        keyboard = new Scanner(System.in);
        
    }
	
    public TicTacToeMove getNextMove(boolean isXTurn) {
        
        /* Prompt the player to enter the row and the column of their next move.
           Return as a TicTacToeMove object. */
        
        // INSERT YOUR CODE HERE

        //initialize variables and objects
        int row = -1;
        int column = -1;
        TicTacToeMove nextMove = null;
        
        if (isXTurn) {
            System.out.println("Player 1 (X) Move: ");
            System.out.println("Enter the row and column numbers, seperated by a space: ");  
        }
        else {
            System.out.println("Player 2 (O) Move: ");
            System.out.println("Enter the row and column numbers, seperated by a space: ");
        }
        
        //get the user's row and column
        row = keyboard.nextInt();
        column = keyboard.nextInt();
                
        //create TicTacToeMove object
        nextMove = new TicTacToeMove(row, column);
       
        return nextMove;
    }

    public void showInputError() {

        System.out.println("Entered location is invalid, already marked, or out of bounds.");

    }

    public void showResult(String r) {

        System.out.println(r + "!");

    }
    
    public void showBoard(String board) {
        
        System.out.println("\n\n" + board);
        
    }
	
}
