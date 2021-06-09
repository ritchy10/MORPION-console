package Model;

/*
 * Represents the current status of the game.
 * VALID - move selected by the user was valid
 * OUTOFBOUNDS - move selected by the user was invalid, and not wihin the bounds of the board. 1-9.
 * SPACETAKEN - move selected  by user was previously selected, and thus cannot be selected again.
 * DRAW - game is over, and has ended in a draw.
 * WINNER - game is over, and has one winner.
 */
public enum GameStatus {
    VALID, OUTOFBOUNDS, SPACETAKEN, DRAW, WINNER
}

