package Model;

/*
 *  Represents a game of tic tac toe with a 3x3 2D char array
 *  Defines data, logic, and computations necessary for a tic tac toe game
 */
public class ModelTTT{

    public ModelTTT(){
        defaultValues();
    }

    //Sets board, and all other data to the values of a new game.
    public void defaultValues(){
        status = GameStatus.VALID;
        xTurn = true;
        winnerName = null;
        totalMoves = 0;
        int ch = 1;
        for(int i = 0; i < this.board_size_x; i++){
            for(int j = 0; j < this.board_size_y; j++){
                board[i][j] = (ch >=10 ? "" : "0") +Integer.toString(ch);
                ch++;
            }
        }

    }

    //Returns a copy of the current game board.
    public String[][] returnBoard(){
        String [][] copy = new String[this.board_size_x][this.board_size_y];
        for(int i = 0; i < this.board_size_x; i++){
            for(int j = 0; j < this.board_size_y; j++){
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }

    //Sets the names, and marks of both players.
    public void playerInit(String nameOne, String nameTwo){
        playerX = new Player(nameOne, 'X');
        playerO = new Player(nameTwo, 'O');
    }

    //Returns true if board was successfully updated with player's move, false otherwise.
    //Sets status to SPACETAKEN, VALID, WINNER, or DRAW according to the result of the player's move.
    public boolean updateBoard(int row, int col){
        if(board[row][col].equals( String.valueOf('X')) || board[row][col].equals(String.valueOf('O'))){
            status = GameStatus.SPACETAKEN;
            return false;
        }
        totalMoves++;
        if(xTurn){
            board[row][col] = playerX.getMark();
            //xTurn = false;
        }
        else{
            board[row][col] = playerO.getMark();
            //xTurn = true;
        }
        if(true){
            checkForEndOfGame(row,col);
        }else{
            status = GameStatus.VALID;
        }
        xTurn = !xTurn;
        return true;
    }

    /*
     * If the player has selected a valid move returns true, places move, and sets status to VALIDMOVE
     * If the player selected an invalid move returns false, and sets status to the type of invalid move,
     * either OUTOFBOUNDS, or SPACETAKEN.
     */
    public boolean placeMove(int move){
    	if(move>this.board_size_x*this.board_size_y) {
    		this.status=GameStatus.OUTOFBOUNDS;
    		return false;
    	}
    	int x,y;
    	x=(move-1)/this.board_size_x;
    	y=(move-1) % this.board_size_y;
    	return updateBoard(x,y);
    	

    }

    public GameStatus getStatus() {
        return status;
    }

    public String getTurn(){
        return xTurn ? playerX.getName() : playerO.getName();
    }

    public String getWinnerName() {
        return winnerName;
    }

    //If the game has ended sets status to WINNER, or DRAW accordingly. Otherwise sets status to VALID
    private void checkForEndOfGame(int row, int col){

        //Get mark of current players turn
        String mark = board[row][col];

        //Check if horizontal win
        if(this.horizontal_win(row, col)){
           status = GameStatus.WINNER;
        }

        //Check for vertial win
        else if(this.vertical_win(row, col)){
            status = GameStatus.WINNER;
        }
        
        //Check for diagonal win
        else if(this.diagonal_win(row, col)){
            status = GameStatus.WINNER;
        }
       
        //Check for anti-diagnol win
        else if(this.inverse_diagonal_win(row, col)){
            status = GameStatus.WINNER;
        }
        
        //Check if game has ended in a draw
        else if(totalMoves == MAX_MOVES){
            status = GameStatus.DRAW;
        }
        
        //Set status to valid move
        else{
           status = GameStatus.VALID;
        }
        if(status.equals(GameStatus.WINNER)){
            winnerName = xTurn ? playerX.getName() : playerO.getName();
        }
    }
    
    private Boolean horizontal_win(int row,int col) {
    	int n=1;
    	int i=1;
    	String mark=board[row][col];
    	while(in_board(row,col-i) && board[row][col-i].equals(mark) ) {
    		i++;
    		n++;
    	}
    	i=1;
    	while(in_board(row,col+i) && board[row][col+i].equals(mark) ) {
    		i++;
    		n++;
    	}
    	if(n==this.mark_to_win) {
    		return true;
    	}
    	
    	return false;
    }
    
    private Boolean vertical_win(int row, int col) {
    	int n=1;
    	int i=1;
    	String mark=board[row][col];
    	while(in_board(row-i,col) && board[row-i][col].equals(mark) ) {
    		i++;
    		n++;
    	}
    	i=1;
    	while(in_board(row+i,col) && board[row+i][col].equals(mark) ) {
    		i++;
    		n++;
    	}
    	if(n==this.mark_to_win) {
    		return true;
    	}
    	
    	return false;
    }
    
    public boolean diagonal_win(int row, int col) {
    	int n=1;
    	int i=1;
    	String mark=board[row][col];
    	while(in_board(row-i,col+i) && board[row-i][col+i].equals(mark) ) {
    		i++;
    		n++;
    	}
    	i=1;
    	while(in_board(row+i,col-i) && board[row+i][col-i].equals(mark) ) {
    		i++;
    		n++;
    	}
    	if(n==this.mark_to_win) {
    		return true;
    	}
    	
    	return false;
    }
    
    public boolean inverse_diagonal_win(int row, int col) {
    	int n=1;
    	int i=1;
    	String mark=board[row][col];
    	while(in_board(row+i,col+i) && board[row+i][col+i].equals(mark) ) {
    		i++;
    		n++;
    	}
    	i=1;
    	while(in_board(row+i,col-i) && board[row+i][col-i].equals(mark) ) {
    		i++;
    		n++;
    	}
    	if(n==this.mark_to_win) {
    		return true;
    	}
    	
    	return false;
    }
    
    private Boolean in_board(int row, int col) {
    	if(row  >= 0 && row < this.board_size_x && col>=0 && col<this.board_size_y) {
    		return true;
    	}
    	return false;
    }
    //Current status of the game may be one of the following: WINNER, DRAW, VALID, OUTOFBOUNDS, SPACETAKEN.
    private GameStatus status;
    private Player playerX;
    private Player playerO;
    private String winnerName;
    private boolean xTurn;
    private int totalMoves;
    private int board_size_x=10;
    private int board_size_y=10;
    private int mark_to_win=5;
    //Max number of moves allowed in a tic tac toe game.
    private final int MAX_MOVES = 25;
    //Minimum number of moves required for there to be a winner.
    private final int MIN_MOVES_TO_WIN = 9;
    private  String[][] board = new String[this.board_size_x][this.board_size_y];
}
