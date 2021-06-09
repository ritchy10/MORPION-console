package Model;

/*
 * Represents a single player in a game of tic tac toe.
 * Stores the player's name, and their mark, either 'X', or 'O'.
 */
public class Player {
    public Player(String name, char mark){
        this.name = name;
        this.mark = mark;
    }
    public void playerInit(String name, char mark){
        this.name = name;
        this.mark = mark;
    }
    public String getName(){
        return name;
    }
    public String getMark(){
        return String.valueOf(this.mark);
    }
    private String name;
    private char mark;
}
