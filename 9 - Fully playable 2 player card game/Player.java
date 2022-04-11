// -----------------------------------------------------------------------------------------------
// Written by: Gianfranco Dumoulin Bertucci
// Date: April 14 2019
// Purpose: This is 1 of 3 classes for a game called Golf(driver). 
//The purpose of this class is to define multiple methods which can be seen below. 
//The methods are used to simplify the code in the driver class. The board, turnedOver, defboard, and points
//variables are defined here. This class is primarily for methods which change/alter/or use the variables mentioned. 
//Each player object is created in this class.
// -----------------------------------------------------------------------------------------------
public class Player {

	private String name1;
	
	// array for the board with the *'s
	char board[][] = new char[3][3];
	// array for the board of boolean values (true=face-up, false = face-down)
	boolean turnedOver[][] = new boolean[3][3];
	// a different board to hold the values of the 9 cards that were dealt
	char defboard[][] = new char[3][3];
	// variable to hold point values
	int points = 0;
	// default constructor that initializes all the entries for board and turnedOver
	public Player() {
 
		board[0][0] = '*'; board[1][0] = '*'; board[2][0] = '*';
		board[0][1] = '*'; board[1][1] = '*'; board[2][1] = '*';
		board[0][2] = '*'; board[1][2] = '*'; board[2][2] = '*';
		
		turnedOver[0][0] = false; turnedOver[1][0] = false; turnedOver[2][0] = false;
		turnedOver[0][1] = false; turnedOver[1][1] = false; turnedOver[2][1] = false;
		turnedOver[0][2] = false; turnedOver[1][2] = false; turnedOver[2][2] = false;
	}
	// constructor that does the same as the default but takes a String parameter
	public Player(String name1) {
		this.name1 = name1;
 
		board[0][0] = '*'; board[1][0] = '*'; board[2][0] = '*';
		board[0][1] = '*'; board[1][1] = '*'; board[2][1] = '*';
		board[0][2] = '*'; board[1][2] = '*'; board[2][2] = '*';
		
		turnedOver[0][0] = false; turnedOver[1][0] = false; turnedOver[2][0] = false;
		turnedOver[0][1] = false; turnedOver[1][1] = false; turnedOver[2][1] = false;
		turnedOver[0][2] = false; turnedOver[1][2] = false; turnedOver[2][2] = false;
	}
	// returns the value of a card at a specific place
	public char cardAt(int r, int c) {
		 return defboard[r][c];
		
	}
	
	// flips over a card
	public boolean flip(int r, int c) {
		if (board[r][c] == defboard[r][c]) {
			return false;
		} else {
			board[r][c] = defboard[r][c];
			turnedOver[r][c] = true;
			return true;
		}
			
	}
	// updates the boolean value of row/column
	public void turn(int r, int c) {
		turnedOver[r][c] = true;
	}
	// setter
	public void setname1 (String name1) {
		this.name1 = name1;
	}
	//getter
	public String getname1() {
		return name1;
	}
	// checks whether or not all the cards in the deck are turned over
	public boolean allTurned() {
		for (int x = 0; x<3; x++) {
			for (int i = 0; i<3; i++) {
				if (turnedOver[x][i]) {
					continue;
				} else {
					return false;
				}
			}
		}
		return true;
	}
	// checks whether or not a card is face up or face down
	public boolean isTurned(int r, int c) {
		if (turnedOver[r][c] == true) {
			return true;
		} else return false;
	}
	public void setTo(int r, int c, char card) {
		board[r][c] = card;
	}
	// calculates the points at the end of the game
		public int calculatePts() {
			for (int x = 0; x<3; x++) {
				for (int i = 0; i<3; i++) {
					switch(defboard[x][i]) {
					case 0: 
						points += 0;
						break;
					case 'A':
						points += 1;
						break;
					case '2':
						points += 2;
						break;
					case '3': 
						points += 3;
						break;
					case '4':
						points += 4;
						break;
					case '5':
						points += 5;
						break;
					case '6': 
						points += 6;
						break;
					case '7':
						points += 7;
						break;
					case '8':
						points += 8;
						break;
					case '9': 
						points += 9;
						break;
					case 'T':
						points += 10;
						break;
					case 'J':
						points += 10;
						break;
					case 'Q':
						points += 10;
						break;
					case 'K':
						points += 0;
						break;
					case '?':
						points += (-5);
						break;
					}
				}
			}
			return points;
		}
}
