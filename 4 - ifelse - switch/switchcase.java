// -----------------------------------------------------------------------------------------------
// Author: Gianfranco Dumoulin
// Date: March 7 2019
// Purpose: requests a day of the week 
// and then outputs a chore for the day requested using switch statements
// -----------------------------------------------------------------------------------------------

import java.util.Scanner;

public class Assignment2Q1switch {

	public static void main(String[] args) {
		
		Scanner x = new Scanner(System.in);
		
		// prompting user input 
		
		System.out.print("Please enter the day of the week as a character {M, T, W, J, F}: ");
		String requestedDay = x.next();
		x.close();
		
		
		// determining what to output based on the user input 
		switch (requestedDay.toLowerCase()) {
		case "m": 
			System.out.print("Today's Monday. Please put the garbage out.");
		break;
		case "t": 
			System.out.print("Today's Tuesday. Please move the car.");
		break;
		case "w": 
			System.out.print("Today's Wednesday. Please put the recycle bag out.");
		break;
		case "j": 
			System.out.print("Today's Thursday. No chore today!!!");
		break;
		case "f": 
			System.out.print("Today's Friday. Please put the garbage out.");
		break;
		default: 
			System.out.print("You have entered an invalid input.");
		break;
		}
	}

}
