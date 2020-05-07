// -----------------------------------------------------------------------------------------------
// Written by: Gianfranco Dumoulin
// Date: April 14 2019
// Purpose: This is the driver class(1 of 3 classes) for a game called Golf. 
// Essentially, the point of the game is to flip over cards in your 3x3 board. The objective is to
// accumulate the lowest value cards possible or to try to combine 3 cards in a row to zero out their value.
// The game will end when a player flips all their cards or when there are no more cards in the deck.
// -----------------------------------------------------------------------------------------------

import java.util.Scanner;
public class Golf {
	public static void main(String[] args) {
		// variable that loops the game, will always equal 0.
		int l = 0;
		// variable to store player integer inputs
		int p;
		// variables for row and column inputs
		int r0; int c0;
		int r1; int c1;
		int r2; int c2;
		int r3; int c3;
		int r4; int c4;
		// variable to hold the character value of a specific card while it switches with another card
		char temp;
		
		// created the object for DeckAndDiscard
		DeckAndDiscard game1 = new DeckAndDiscard();
		
		// Welcome banner
		Scanner w = new Scanner(System.in);
		System.out.println("\t\t-------****-------****-------****-------****-----****-----"
				+ "\n\t\t\tWelcome to Franco's Card Golf Game!"
				+ "\n\t\t-------****-------****-------****-------****-----****-----");
		System.out.print("\nTo win this game you need some luck with the cards and a bit of strategy."
				+ "\nJust like the outdoor game of golf, the card game known as Golf has a goal of "
				+ "\nkeeping the score as low as possible."
				+ "\nOkay .. Let's start the game! May the best golfer win!!!");
		// getting the names of the players
		System.out.println("\n\n\nWhat is the name of 1st player:");
		String player1Name = w.next();
		Player player1 = new Player(player1Name);
		
		System.out.println("What is the name of 2nd player:");
		String player2Name = w.next();
		Player player2 = new Player(player2Name);
		System.out.print("\n");
		// dealing 9 cards to each player
		game1.hand(player1.defboard);
		game1.hand(player2.defboard);
		// prompting the user to pick 2 cards they want to flip
		System.out.print(player1.getname1() + " time to decide which 2 cards you want to turn over"
				+ "\nWhich card to you want to flip (row col) ");
		r1 = w.nextInt();
		c1 = w.nextInt();
		// updating the boolean value of that position on the board
		player1.turn(r1, c1);
		
		// asking user for the 
		System.out.print("Which card do you want to flip (row col) ");
		r2 = w.nextInt();
		c2 = w.nextInt();
		
		// validating user input
		while (player1.isTurned(r2, c2) == true) {
			System.out.print("\nThat card is already flipped, please choose a different card. (row col) ");
			r2= w.nextInt();
			c2 = w.nextInt();
		}
		player1.turn(r2, c2); // updating turnedOver boolean value to reflect user input
		
		player1.board[r1][c1] = player1.cardAt(r1, c1); // replacing * with the actual character of a card for player 1
		player1.board[r2][c2] = player1.cardAt(r2, c2); // replacing * with the actual character of a card for player 1
		
		// prompting user for 2 cards to flip over
		System.out.print("\n" + player2.getname1() + " time to decide which 2 cards you want to turn over"
				+ "\nWhich card do you want to flip (row col) ");
		r3 = w.nextInt();
		c3 = w.nextInt();
		player2.turn(r3, c3);;
		// prompting user for 2 cards to flip over
		System.out.print("Which card do you want to flip (row col) ");
		r4 = w.nextInt();
		c4 = w.nextInt();
		// data validating to make sure the card isn't flipped already
		while (player2.isTurned(r4, c4) == true) {
			System.out.print("\nThat card is already flipped, please choose a different card. (row col) ");
			r4= w.nextInt();
			c4 = w.nextInt();
		}
		player2.turn(r4, c4);
		// flipping the cards
		player2.board[r3][c3] = player2.cardAt(r3, c3);
		player2.board[r4][c4] = player2.cardAt(r4, c4);
		
		
		// loop that keeps the game running infinitely
		while ( l == 0) {
			// if statement that checks if all the cards are turned over for either player, if allTurned() is true, the game ends
			if (player1.allTurned() || player2.allTurned()) {
				break;
			// if statement that checks if there are any cards in the deck, if there are no more, the game ends
			} if (game1.cardsLeft == 54) {
				break;
			}
// 			prints what's in the discard pile and the current board in the following format
//			Discard pile has X
//			Player's turn:
//			--------------------------------
//			Here is your board. 
//			*  *  *   
//			*  *  *   
//			*  *  *  
//			Do you want the card on the discard pile(0) or a new card(1)
//			Proceeds to offer the player different options depending on which choices they make
			System.out.print("\nDiscard pile has " + game1.discardPile[(game1.discardPileIndex)-1] + 
					"\n" + player1.getname1() + "'s turn:"
							+ "\n--------------------------------"
							+ "\nHere is your board." );
			for (int x = 0; x<3; x++) {
				System.out.println(" ");
				for (int i = 0; i<3; i++) {
					System.out.print(player1.board[x][i] + "  ");
				}
			}
			System.out.print("\nDo you want the card on the discard pile(0) or a new card(1) ");
			p = w.nextInt();
			// if discard pile card is chosen
			if (p == 0) {
				System.out.print(player1.getname1() + ", do you want to replace a flipped card(0) or a facedown card(1) ");
				p = w.nextInt();
				if (p == 1) {
					System.out.print("Which facedown card do you want to flip (row col)? ");
					r0 = w.nextInt();
					c0 = w.nextInt();
					// data validations
					while (player1.isTurned(r0, c0) == true) {
						System.out.print("\nThat card is already flipped, please choose a different card. (row col) ");
						r0 = w.nextInt();
						c0 = w.nextInt();
					}
					temp = player1.defboard[r0][c0];
					player1.defboard[r0][c0] = game1.discardPile[game1.discardPileIndex-1];
					game1.discardPile[game1.discardPileIndex-1] = temp;
					player1.board[r0][c0] = player1.defboard[r0][c0];
					player1.turn(r0, c0);
				} else if (p == 0) {
					System.out.print("Which flipped card do you want to replace (row col)? ");
					r0 = w.nextInt();
					c0 = w.nextInt();
					while (player1.isTurned(r0, c0) == false) {
						System.out.print("\nThat card has not been flipped yet, please choose a different card. (row col) ");
						r0 = w.nextInt();
						c0 = w.nextInt();
					}
					temp = player1.defboard[r0][c0];
					player1.defboard[r0][c0] = game1.discardPile[game1.discardPileIndex-1];
					game1.discardPile[game1.discardPileIndex-1] = temp;
					player1.board[r0][c0] = player1.defboard[r0][c0];
					player1.turn(r0, c0);
				}
				// if the player requests a new card
			} else if (p==1) {
				char card = game1.pickACard();
				System.out.println("The card you are playing is " + card);
				System.out.print("\nReplace a card(0) or toss it(1)? ");
				int tossOrNot = w.nextInt();
				if (tossOrNot == 0) {
					System.out.print(player1.getname1() + ", do you want to replace a flipped card(0) or a facedown card(1) ");
					p = w.nextInt();
					if (p == 1) {
						System.out.print("Which facedown card do you want to flip (row col)? ");
						r0 = w.nextInt();
						c0 = w.nextInt();
						while (player1.isTurned(r0, c0) == true) {
							System.out.print("\nThat card is already flipped, please choose a different card. (row col) ");
							r0 = w.nextInt();
							c0 = w.nextInt();
						}
						player1.board[r0][c0] = player1.defboard[r0][c0];
						player1.turn(r0, c0);
						for (int x = 0; x<3; x++) {
							if (x>0) {
								System.out.println(" ");
							}
							for (int i = 0; i<3; i++) {
								System.out.print(player1.board[x][i] + "  ");
							}
						}
						System.out.print("\nReplace the " + player1.defboard[r0][c0] + " with the " + card + "(0) or toss the " + card + "(1)? ");
						tossOrNot = w.nextInt();
						if (tossOrNot == 0) {
							temp = player1.defboard[r0][c0];
							player1.defboard[r0][c0] = card;
							player1.board[r0][c0] = player1.defboard[r0][c0];
							player1.turn(r0, c0);
							game1.discard(temp);
						} else if (tossOrNot == 1) {
							game1.discard(card);
						}
					} else if (p == 0) {
						System.out.print("Which flipped card do you want to replace (row col)? ");
						r0 = w.nextInt();
						c0 = w.nextInt();
						while (player1.turnedOver[r0][c0] == false) {
							System.out.print("\nThat card has not been flipped yet, please choose a different card. (row col) ");
							r0 = w.nextInt();
							c0 = w.nextInt();
						}
						char temp1 = player1.defboard[r0][c0];
						player1.defboard[r0][c0] = game1.discardPile[game1.discardPileIndex-1];
						game1.discardPile[game1.discardPileIndex-1] = temp1;
						player1.board[r0][c0] = player1.defboard[r0][c0];	
						player1.turn(r0, c0);
					}
				} else if (tossOrNot == 1) {
					game1.discard(card);
				}
			}
				///////////	
			// if statement that checks if all the cards are turned over for either player, if allTurned() is true, the game ends
			if (player1.allTurned() || player2.allTurned()) {
				break;
			}
			// if statement that checks if there are any cards in the deck, if there are no more, the game ends 
			if (game1.cardsLeft == 54) {
				break;
			}
				System.out.print("\nDiscard pile has " + game1.discardPile[(game1.discardPileIndex)-1] + 
						"\n" + player2.getname1() + "'s turn:"
								+ "\n--------------------------------"
								+ "\nHere is your board." );
				for (int x = 0; x<3; x++) {
					System.out.println(" ");
					for (int i = 0; i<3; i++) {
						System.out.print(player2.board[x][i] + "  ");
					}
				}
				System.out.print("\nDo you want the card on the discard pile(0) or a new card(1) ");
				p = w.nextInt();
				if (p == 0) {
					System.out.print(player2.getname1() + ", do you want to replace a flipped card(0) or a facedown card(1) ");
					p = w.nextInt();
					if (p == 1) {
						System.out.print("Which facedown card do you want to flip (row col)? ");
						r0 = w.nextInt();
						c0 = w.nextInt();
						while (player2.isTurned(r0, c0) == true) {
							System.out.print("\nThat card is already flipped, please choose a different card. (row col) ");
							r0 = w.nextInt();
							c0 = w.nextInt();
						}
						temp = player2.defboard[r0][c0];
						player2.defboard[r0][c0] = game1.discardPile[game1.discardPileIndex-1];
						game1.discardPile[game1.discardPileIndex-1] = temp;
						
						player2.board[r0][c0] = player2.defboard[r0][c0];
						player2.turn(r0, c0);
					} else if (p == 0) {
						System.out.print("Which flipped card do you want to replace (row col)? ");
						r0 = w.nextInt();
						c0 = w.nextInt();
						while (player2.isTurned(r0, c0) == false) {
							System.out.print("\nThat card has not been flipped yet, please choose a different card. (row col) ");
							r0 = w.nextInt();
							c0 = w.nextInt();
						}
						temp = player2.defboard[r0][c0];
						player2.defboard[r0][c0] = game1.discardPile[game1.discardPileIndex-1];
						game1.discardPile[game1.discardPileIndex-1] = temp;
						player2.board[r0][c0] = player2.defboard[r0][c0];
						player2.turn(r0, c0);
					}
				} else if (p==1) {
					char cardPicked0 = game1.pickACard();
					System.out.println("The card you are playing is " + cardPicked0);
					System.out.print("\nReplace a card(0) or toss it(1)? ");
					int tossOrNot0 = w.nextInt();
					if (tossOrNot0 == 0) {
						System.out.print(player2.getname1() + ", do you want to replace a flipped card(0) or a facedown card(1) ");
						p = w.nextInt();
						if (p == 1) {
							System.out.print("Which facedown card do you want to flip (row col)? ");
							r0 = w.nextInt();
							c0 = w.nextInt();
							while (player2.isTurned(r0, c0) == true) {
								System.out.print("\nThat card is already flipped, please choose a different card. (row col) ");
								r0 = w.nextInt();
								c0 = w.nextInt();
							}
							player2.board[r0][c0] = player2.defboard[r0][c0];
							player2.turn(r0, c0);
							for (int x = 0; x<3; x++) {
								if (x>0) {
									System.out.println(" ");
								}
								for (int i = 0; i<3; i++) {
									System.out.print(player2.board[x][i] + "  ");
								}
							}
							System.out.print("\nReplace the " + player2.defboard[r0][c0] + " with the " + cardPicked0 + "(0) or toss the " + cardPicked0 + "(1)? ");
							tossOrNot0 = w.nextInt();
							if (tossOrNot0 == 0) {
								temp = player2.defboard[r0][c0];
								player2.defboard[r0][c0] = cardPicked0;
								player2.board[r0][c0] = player2.defboard[r0][c0];
								player2.turn(r0, c0);
								game1.discard(temp);
							} else if (tossOrNot0 == 1) {
								game1.discard(cardPicked0);
							}
						} else if (p == 0) {
							System.out.print("Which flipped card do you want to replace (row col)? ");
							r0 = w.nextInt();
							c0 = w.nextInt();
							while (player2.isTurned(r0, c0) == false) {
								System.out.print("\nThat card has not been flipped yet, please choose a different card. (row col) ");
								r0 = w.nextInt();
								c0 = w.nextInt();
							}
							temp = player2.defboard[r0][c0];
							player2.defboard[r0][c0] = game1.discardPile[game1.discardPileIndex-1];
							game1.discardPile[game1.discardPileIndex-1] = temp;
							player2.board[r0][c0] = player2.defboard[r0][c0];
							player2.turn(r0, c0);
						}
					} else if (tossOrNot0 == 1) {
						game1.discard(cardPicked0);
					}
				}
			}
		if (player1.allTurned()) {
			System.out.println("\n" + player1.getname1() + " has turned over all their cards.");
		} else if (player2.allTurned()) {
			System.out.println("\n" + player2.getname1() + " has turned over all their cards.");
		} else {
			System.out.println("There are no more cards in the deck.");
		}
		System.out.println("Time to calculate points! Here are your boards with all cards turned \nover\n"
							+ "\n" + player1.getname1() + "\t\t" + player2.getname1()
							+ "\n-----------------------------------------------------");
		
		for (int x=0; x<3; x++) {
			for (int o = 0; o<3; o++) {
				player1.flip(x, o);
			}
		}
		for (int x=0; x<3; x++) {
			for (int o = 0; o<3; o++) {
				player2.flip(x, o);
			}
		}
		
		
		for (int z=0; z<3; z++) {
			System.out.print("\n");
			for (int x = 0; x<6; x++) {
				if (x<3) { 
				System.out.print(player1.board[z][x] + "   ");
				} else if (x>=3) {
					if (x==3) {
						System.out.print("\t");
					}
					System.out.print(player2.board[z][x-3] + "   " );
				}
			}
		}
		// checks for any three in a row combinations for each player
		game1.bonus(player1);
		game1.bonus(player2);
		// prints the final points via the calculatePts method
		System.out.println("\n\nFinal results"
				+ "\n  " + player1.getname1() + " scored " + player1.calculatePts() 
				+ "\n  " + player2.getname1() + " scored " + player2.calculatePts());
		// checking to see who won by comparing the final scores
		if (player1.calculatePts() < player2.calculatePts()) {
			System.out.println("\nCONGRATULATIONS!!!!!The winner is " + player1.getname1()
					+ "\n-----------------------------------------------------");
		} else if (player1.calculatePts() > player2.calculatePts()) {
			System.out.println("\nCONGRATULATIONS!!!!!The winner is " + player2.getname1()
			        + "\n-----------------------------------------------------");
		} else if (player1.calculatePts() == player2.calculatePts()) {
			System.out.println("\nYou seem to be equally matched, IT'S A DRAW!!!!"
					+ "\n-----------------------------------------------------");
		}
		// displaying the cards the left in the deck
		System.out.println("Just for information sake, here are the cards remaining in the deck:\n");
		game1.displayDeck();
		// displaying the cards in the discard pile
		System.out.println("\n\nHere are the cards in the discard pile:\n");
		game1.displayDiscardPile();
		// closing the scanner
		w.close();
		// exit message
		System.out.println("\n\nThat's it! Program ending now!");
		System.exit(0);
	}
}

	
	

