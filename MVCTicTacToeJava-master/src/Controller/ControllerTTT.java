package Controller;

import Model.ModelTTT;
import Model.GameStatus;

/*
 * Accepts, and sends user input from the view to the model. Responds to the view with model's response to the uesr input.
 */
public class ControllerTTT {

    public ControllerTTT(){
        model = new ModelTTT();
    }

    //Starts game by initializing players with their names and marks through ModelTTT object.
    public void startGame(String playerOne, String playerTwo){
       model.playerInit(playerOne, playerTwo);
    }

    //Returns false if the input was invalid. If valid move returns true, and sets mark at selected position.
    public boolean isValidInput(int move){
        return model.placeMove(move);
    }

    //Returns true if the game has ended because of a win or draw.
    public boolean isGameOver(){
        if(model.getStatus().equals(GameStatus.WINNER) || model.getStatus().equals(GameStatus.DRAW)){
            return true;
        }
        return false;
    }

    //Returns the name of player whose turn it is.
    public  String getTurn(){
        return model.getTurn();
    }

    //Returns true if input was out of bounds.
    public  boolean outOfBounds(){

        return model.getStatus().equals(GameStatus.OUTOFBOUNDS);
    }

    //Returns true if input was previously selected.
    public  boolean spaceTaken(){
        return model.getStatus().equals(GameStatus.SPACETAKEN);
    }

    //Returns a copy of the tic tac toe board for the view to display.
    public String [][] getBoard(){
        return model.returnBoard();
    }

    //Returns name of the winner, or null if draw.
    public String GetFinalResult(){
        return model.getWinnerName();
    }

    //Resets the model to the default values of a new game of tic tac toe.
    public void resetGame(){
        model.defaultValues();
    }

    //All the data, and logic of the tic tac toe game.
    private ModelTTT model;
}
