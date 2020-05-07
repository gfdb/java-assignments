// -----------------------------------------------------------------------------------------------
// Written by: Gianfranco Dumoulin
// Date: April 14 2019
// Purpose: This is 1 of 3 classes for a game called Golf(driver). 
//The purpose of this class is to define multiple methods which can be seen below. 
//The methods are used to simplify the code in the driver class. The deck, and discard pile arrays
//are defined here. This class is primarily for methods which change/alter/or use the arrays mentioned. 
//The DeckAndDiscard object (game1) is created in this class.
// -----------------------------------------------------------------------------------------------
public class DeckAndDiscard {

	// deck of cards
	private char deck[] = new char[54];
	// discard pile
	char discardPile[] = new char[54]; 
	// index of where to add the next card in the discard pile
	int discardPileIndex;
	// index of the next card in the deck
	int nextCard;
	// index of the cards left in the deck
	int cardsLeft;
	// variable for the score
	int w = 0;
	// default constructor
	public DeckAndDiscard(){
	
	// declaring the initial deck variables
	deck[0] =  '2';	deck[11] = 'K';	deck[22] = 'J'; deck[33] = '9';	deck[44] = '7';
	deck[1] =  '3'; deck[12] = 'A';	deck[23] = 'Q';	deck[34] = 'T';	deck[45] = '8';
	deck[2] =  '4';	deck[13] = '2';	deck[24] = 'K';	deck[35] = 'J';	deck[46] = '9';
	deck[3] =  '5';	deck[14] = '3';	deck[25] = 'A';	deck[36] = 'Q';	deck[47] = 'T';
	deck[4] =  '6';	deck[15] = '4';	deck[26] = '2';	deck[37] = 'K';	deck[48] = 'J';
	deck[5] =  '7';	deck[16] = '5';	deck[27] = '3';	deck[38] = 'A';	deck[49] = 'Q';
	deck[6] =  '8';	deck[17] = '6';	deck[28] = '4';	deck[39] = '2';	deck[50] = 'K';
	deck[7] =  '9';	deck[18] = '7';	deck[29] = '5';	deck[40] = '3';	deck[51] = 'A';
	deck[8] =  'T';	deck[19] = '8';	deck[30] = '6';	deck[41] = '4';	deck[52] = '?';
	deck[9] =  'J';	deck[20] = '9';	deck[31] = '7';	deck[42] = '5';	deck[53] = '?';
	deck[10] = 'Q';	deck[21] = 'T';	deck[32] = '8';	deck[43] = '6';	
	
	Shuffle();
	
	discardPileIndex = 0;
	nextCard = 0;
	cardsLeft = 0;
	
	discardPile[0] = deck[0];
	nextCard++;
	discardPileIndex++;
	cardsLeft++;
	
	}
	// shuffles the deck by swapping two random cards out of 54 2000 times
	public void Shuffle() {
		for (int x = 0; x<2000; x++) {
			int random1 = (int)(Math.random() * 54);
			int random2 = (int)(Math.random() * 54);
			
			char t = deck[random1];
			deck[random1] = deck[random2];
			deck[random2] = t;
		}
	}
	// takes the next card in the deck
	public char pickACard() {
		char topCard = deck[nextCard];
		nextCard++;
		cardsLeft++;
		return topCard;
		}
	// puts the card given into the discard pile
	public void discard(char card) {
		discardPile[discardPileIndex] = card;
		discardPileIndex++;
	}
	// displays the cards remaining in the deck
	public void displayDeck() {
		for (int i = cardsLeft; i<deck.length; i++  ) {
			System.out.print(deck[i]+" ");
		}
	}
	// displays the cards in the discard pile
	public void displayDiscardPile() {
		for (int i = 0; i<discardPileIndex; i++  ) {
			System.out.print(discardPile[i]+" ");
		}
	}
	// deals 9 cards into each players boards
	// this method could have been in the player class as well.
	public void hand(char[][] board) {
		for (int x = 0; x<3; x++) {
			for (int i = 0; i<3; i++) {
				board[x][i] = deck[nextCard];
				nextCard++;
				cardsLeft++;
			}
			nextCard++;
			cardsLeft++;
		}
	}
	
	// this method checks for 8 possible 3 in a row combinations, if 3 values are identical in a row, column or diagonal, the values
	// of those entries are set to 0
	// comment on optimizing this method: in the case of a diagonal 3 in a row, no other combinations of 3 in a row are possible
	// and therefore nothing else needs to be checked, if there are 3 in a row vertically, the only check that needs to be done is for 
	// the other verticals, likewise for a horizontal 3 in a row. I don't have the time to optimize the code but if I did, I would
	// implement these features, I also find this quite interesting and that's why I decided to mention it.
	public void bonus(Player name) {
		if (name.defboard[0][0] == name.defboard[1][1] && name.defboard[1][1] == name.defboard[2][2]) { // diagonal
			for (int x=0; x<3; x++) {
				name.defboard[x][x] = 0;
			}
		} 
		if (name.defboard[0][2] == name.defboard[1][1] && name.defboard[1][1] == name.defboard[2][0]) { // diagonal
			name.defboard[0][2] = 0;
			name.defboard[1][1] = 0;
			name.defboard[2][0] = 0;
		}
		if (name.defboard[0][0] == name.defboard[1][0] && name.defboard[1][0] == name.defboard[2][0]) { // first column
			for (int x=0; x<3; x++) {
				name.defboard[x][0] = 0;
			}
		}
		if (name.defboard[0][1] == name.defboard[1][1] && name.defboard[1][1] == name.defboard[2][1]) { // second column
			for (int x=0; x<3; x++) {
				name.defboard[x][1] = 0;
			}
		}
		if (name.defboard[0][2] == name.defboard[1][2] && name.defboard[1][2] == name.defboard[2][2]) { // third column
			for (int x=0; x<3; x++) {
				name.defboard[x][2] = 0;
			}
		}
		if (name.defboard[0][0] == name.defboard[0][1] && name.defboard[0][1] == name.defboard[0][2]) { // first row
			for (int x=0; x<3; x++) {
				name.defboard[0][x] = 0;
			}
		}
		if (name.defboard[1][0] == name.defboard[1][1] && name.defboard[1][1] == name.defboard[1][2]) { // second row
			for (int x=0; x<3; x++) {
				name.defboard[1][x] = 0;
			}
		}
		if (name.defboard[2][0] == name.defboard[2][1] && name.defboard[2][1] == name.defboard[2][2]) { // third row
			for (int x=0; x<3; x++) {
				name.defboard[2][x] = 0;
			}
		}
	}
	
	
	
}
