# Tic-Tac-Toe
Command line Tic-Tac-Toe(TTT) game. Implemented in an MVC pattern with Java. 

# To run the game
* In the 'src' directory run the following commands:
* javac TicTacToe.java
* java TicTacToe

# Classes
* ModelTTT(MTT)
* Player
* ControllerTTT(CTT)
* ViewTTT(VTT)

* ModelTTT, and Player
	* Logic, and data required to play a game of TTT. Represent game board, players, validates input, determines winner, etc. 

* ControllerTTT
   * Communicates user input from VTT object to MTT object. Responds to VTT object with MTT's response.

* ViewTTT
	* Responsible for prompting, and accepting user input. Hands user input to CTT, accepts CTT response, and prompts user with appropriate message. Displays game board, and winner. 
