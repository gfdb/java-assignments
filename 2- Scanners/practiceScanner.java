// ***********************************************************************************************************************************
// Written by: Gianfranco Dumoulin
// Date: February 8th, 2019
// Purpose: to output a specific season and corresponding message based on user input
// ***********************************************************************************************************************************

import java.util.Scanner;

public class Assignment1Q2 {
	public static void main(String[] args) {
		// "requestedDate" will be the variable name for the scanner
		Scanner requestedDate = new Scanner(System.in);
		
		// "day" will be the input for the day of the year
		// "month" will be the input for the month of the year
		
		int day, month;
			String season = null;
				String suffixa = null;
		// Opening header message
		System.out.print("************************************************************"
				+ "****************************************\n                         "
				+ "  Welcome to Franco\'s season finding program!\n***************"
				+ "*******************************************************************"
				+ "******************\n");
		System.out.print("\n\nPlease enter a month and day of the year as mm dd: ");
		// function to read the input for the month and day
		month = requestedDate.nextInt();
			day = requestedDate.nextInt();
				requestedDate.close();
		
		// The following if statement is checking if the month is between 1 and 3.
		// If it is the output will be winter and the corresponding phrase will be printed.
		if(1 <= month && month <= 3) {
			season = "Winter. Wear a jacket, it's cold in Canada!"; 
					if( month == 3 && 21 <= day )
						season = "Spring, the snow goes and the flowers grow!";
		} else if(4 <= month && month <= 6) {
			season = "Spring, the snow goes and the flowers grow!";
					if( month == 6 && 21 <= day )
						season = "Summer. Stop playing on the computer, go outside, it's beautiful!";
		} else if (7 <= month && month <= 9) {
			season = "Summer. Stop playing on the computer, go outside, it's beautiful!";
				if ( month == 9 && 21 <= day ) 
						season = "Fall. The leaves fall like my GPA!";
		} else if(10 <= month && month <= 12) {
			season = "Fall. The leaves fall like my GPA!"; 
					if( month == 12 && 21 <= day )
						season = "Winter. Wear a jacket, it's cold in Canada!";
		}
		// the following if/else statements are used to assign a suffix
		// to the selected month
				if ( 4 <= month && month <= 12) {
					suffixa = "th";
			} else if ( month == 1) {
					suffixa = "st";
			} else if ( month == 2) {
					suffixa = "nd";
			} else if ( month == 3 ){
					suffixa = "rd";
			}
			
			
			System.out.println("The " + day + " day of the " + month + suffixa + " month of the year " + "is during " + season);

			}
	}