package View;

import Controller.ControllerTTT;
import java.util.Scanner;

/*
 * Responsible for starting a tic tac toe game, printing the game board,
 * prompting, accepting, and handing user input to controller.
 */
public class ViewTTT {
    public ViewTTT(){
        controller = new ControllerTTT();
        while(playGame());
    }
    public boolean playGame(){

        Scanner input = new Scanner(System.in);
        System.out.println("Enter player one's name, they will play as 'X'");
        String playerOne = input.nextLine();
        System.out.println("Enter player two's name, they will play as 'O'");
        String playerTwo = input.nextLine();

        controller.startGame(playerOne, playerTwo);

        int ch;
        while(!controller.isGameOver()){
            do{
                if(controller.outOfBounds()){
                    System.out.println("Selected move out of bounds. Select a move within the bounds.");
                }
                if(controller.spaceTaken()){
                    System.out.println("Selected move already taken. Select a move that is not taken.");
                }
                printBoard();
                System.out.println(controller.getTurn() + "'s turn, enter your move: ");
                ch = input.nextInt();
            }while (!controller.isValidInput(ch));
        }

        System.out.println();
        String result = controller.GetFinalResult();

        if(result != null){
           System.out.println(result + " has won!");
        }
        else{
            System.out.println("Game has ended in a draw.");
        }

        printBoard();

        String playAgain;
        input.nextLine();
        System.out.println("Would you like to play again? Enter 'yes' to play again, 'no' to exit.");

        do{
            playAgain = input.nextLine();
            playAgain.toLowerCase();

            if(playAgain.equals("yes")){
                controller.resetGame();
                return true;
            }
            else if(playAgain.equals("no")){
                return false;
            }
            else{
                System.out.println("Invalid input. To play again enter 'yes', to exit enter 'no'.");
            }
        }while(true);
    }

    public void printBoard(){
        String [][] board = controller.getBoard();
        System.out.println();

        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                System.out.print(board[row][col]);
                if(col+1 != board[0].length){
                    System.out.print('|');
                }
            }
            System.out.println();
            if(row+1 != board.length){
                System.out.println("------");
            }
        }
        System.out.println();
    }

    private ControllerTTT controller;
}
