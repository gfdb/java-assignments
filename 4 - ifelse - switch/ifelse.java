// -----------------------------------------------------------------------------------------------
// Author: Gianfranco Dumoulin Bertucci
// Date: March 7 2019
// Purpose: requests a day of the week 
// and then outputs a chore for the day requested using switch statements
// -----------------------------------------------------------------------------------------------

import java.util.Scanner;

public class IfElse {

	public static void main(String[] args) {
		
		Scanner x = new Scanner(System.in);
		
		// prompting user input 
		
		System.out.print("Please enter the day of the week as a character {M, T, W, J, F}: ");
		String requestedDay = x.next();
		x.close();
		
		// Monday
		if (requestedDay.equalsIgnoreCase("m")) {
			
			System.out.print("Today's Monday. Please put the garbage out.");
			
		// Tuesday
		} else if (requestedDay.equalsIgnoreCase("t")) {
			
			System.out.print("Today's Tuesday. Please move the car.");
			
		// Wednesday	
		} else if (requestedDay.equalsIgnoreCase("w")) {
			
			System.out.print("Today's Wednesday. Please put the recycle bag out.");
			
		// Thursday
		} else if (requestedDay.equalsIgnoreCase("j")) {
			
			System.out.print("Today's Thursday. No chore today!!!");
			
		// Friday
		} else if (requestedDay.equalsIgnoreCase("f")) {
			
			System.out.print("Today's Friday. Please put the garbage out.");
		
		// Default
		} else {
			
			System.out.print("You have entered an invalid input.");
		}

	}

}
