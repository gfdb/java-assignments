// -----------------------------------------------------------------------------------------------
// Written by: Gianfranco Dumoulin Bertucci
// Date: March 25 2019
// Purpose: calculates the GPA
// of a person by prompting the user for 3 key inputs, Name of a course, the credits its worth, 
// and their grade in the course. It stores each of these variables in arrays and the arrays and 
// the data in them are used to calculator multiple options. The purpose is to calculate the GPA
// as well as all the other functions.
// ----------------------------------------------------------------------------------------------

import java.util.Scanner;

public class GpaCalculator {
	


	public static void main(String[] args) {
		
		Scanner x = new Scanner(System.in);
		
		// allows up to 50 different courses to be input into the system
		
		// Array used to store the names of each course
		String courseInput[] = new String[50];
		// Array used to store the number of credit of each course
		Double numCreditsInput[] = new Double[50];
		// Array used to store the letter grade of each course 
		String letterGradeInput[] = new String[50];
		// Array used to validate user input for letterGrade
		String grades[] = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "FNS"};
		// Array used to store the value of numGrade
		Double numGradeInput[] = new Double[50];
		
		// variable used to store the name of the course from the scanner
		String course;
		// variable used to store the name of the letterGrade from the scanner
		String letterGrade;
		// variable used to store the sum of the numGrade and numCredits
		double z = 0;
		// variable used to store the number of credits in a specific course
		double numCredits = 0;
		// variable used to store the sum of the number of credits
		double totNumCredits = 0;
		// variable used to store the value of the original input for gpa
		double gpa = 0;
		// variable used to store the value of (gpa * credits) + z
		double w = 0;
		// variable used to store the sum of credits and totNumCredits
		double y = 0;;
		// variable used to store the value of the newGPA
		double newGPA = 0;
		
		// openning message
		System.out.print("******************************************************"
				+ "\n*** Welcome to the best GPA calculator ever..      ***"
				+ "\n*** The program will ask you first to enter the    ***"
				+ "\n*** number of credits you have accumulated so far. ***"
				+ "\n\n*** If this is your very first semester, please    *** "
				+ "\n*** enter 0.                                       ***"
				+ "\n******************************************************");
		System.out.print("\n Please enter how many credits you have accumulated so"
				+ "\n far not including your current semester: ");
		int credits = x.nextInt();
		
		// data validation for the number of credits 
		while (credits < 0) {
			System.out.print("\n ERROR: number of past credits has to be a positive number.\n");
			System.out.print("\n Please enter how many credits you have accumulated so"
					+ "\n far not including your current semester: ");
			credits = x.nextInt();
		}
		
		// data validation for if it is the student's first year
		if (credits > 0) {
			System.out.print(" Please enter your current GPA: ");
			gpa = x.nextDouble();
		
		// data validation for gpa value to be between 4 and 4.3
		while ( 0 > gpa || gpa > 4.3) {
			System.out.print("\n ERROR: a valid GPA is between 0 to 4.3 inclusive.\n");
			System.out.print("\n Please enter your current GPA: ");
			gpa = x.nextDouble();
		 }
		}
		
		// prompting user for number of courses (max 50)
		System.out.print(" Please enter how many courses do you want to add to the GPA calculator: ");
		int numCourses = x.nextInt();
		
		// data validation for numCourses
		while (numCourses < 0) {
			System.out.print("\n ERROR: number of courses has to be a positive number.\n");
			System.out.print("\n Please enter how many courses do you want to add to the GPA calculator: ");
			numCourses = x.nextInt();
		}
		
		// data validation for maximum number of courses the system can accept
		while (numCourses > 50) {
			System.out.print("\n ERROR: the maximum number of courses the system can handle is 50.\n");
			System.out.print("\n Please enter how many courses do you want to add to the GPA calculator: ");
			numCourses = x.nextInt();
		}
		// main algorithm: is a loop that Prompts user for the name of the course, the number of credits of the course, and their grade in the course
		// loops for the number of courses the user requested to add
			for (int i = 0; i < numCourses; i++ ) {
				
				System.out.print(" Please enter the name of course number " + (i+1) + ": ");
				course = x.next();
				courseInput[i] = course;
				
				System.out.print(" Please enter the number of credits of course number " + (i+1) + ": ");
				numCredits = x.nextDouble();
				numCreditsInput[i] = numCredits;
				while (numCredits < 0) {
					System.out.print("\n ERROR: course credit has to be a positive number.");
					System.out.print("\n\n Please enter the number of credits of course number " + (i+1) + ": ");
					numCredits = x.nextDouble();
					numCreditsInput[i] = numCredits;
				}
				
				System.out.print(" Please enter the letter grade of course number " + (i+1) + ": ");
				letterGrade = x.next();
				letterGradeInput[i] = letterGrade;
				
				// data validation for letterGrade
				
				boolean contains = Arrays.stream(grades).anyMatch(letterGrade::equals);
				
				while (contains == false) {
					System.out.print("\n ERROR: course grade has to be one of the following..."
							+ "\n\n A+, A, A-, B+, B, B-, C+, C, C-, D+, D, D-, FNS");
					System.out.print("\n Please enter the letter grade of course number " + (i+1) + ": ");
					letterGrade = x.next();
					letterGradeInput[i] = letterGrade;
					
					contains = Arrays.stream(grades).anyMatch(letterGrade::equals);
				}

				System.out.print("\n");
				
				// converting letterGrade to a double value from a string
				switch (letterGrade) {
				
					case "A+":
						numGradeInput[i] = 4.30;
						break;
					case "A":
						numGradeInput[i] = 4.00;
						break;
					case "A-":
						numGradeInput[i] = 3.70;
						break;
					case "B+":
						numGradeInput[i] = 3.30;
						break;
					case "B":
						numGradeInput[i] = 3.00;
						break;
					case "B-":
						numGradeInput[i] = 2.70;
						break;
					case "C+":
						numGradeInput[i] = 2.30;
						break;
					case "C":
						numGradeInput[i] = 2.00;
						break;
					case "C-":
						numGradeInput[i] = 1.70;
						break;
					case "D+":
						numGradeInput[i] = 1.30;
						break;
					case "D":
						numGradeInput[i] = 1.00;
						break;
					case "D-":
						numGradeInput[i] = 0.70;
						break;
					case "FNS":
						numGradeInput[i] = 0.00;
						break;
					default:
						numGradeInput[i] = 0.00;
						break;
					
				}
				// calculations for newGPA according to the assignment instruction
				z += (numGradeInput[i]*numCreditsInput[i]);
				totNumCredits += numCreditsInput[i]; 
				
			}
			
			// option menu for the 5 options
			String optionMessage = (" Please choose one of the following options"
					+ "\n Press 1: to display the courses in the system"
					+ "\n Press 2: to display the new GPA"
					+ "\n Press 3: to delete a course"
					+ "\n Press 4: to add a program"
					+ "\n Press 5: to exit program");
			
		System.out.println(optionMessage);
		int optionSelection = x.nextInt();
		
		// data validation for options menu
		while (optionSelection > 5 || optionSelection < 1) {
			System.out.println(" Menu option has to be between 1 and 5 inclusive.");
			System.out.println(optionMessage);
			optionSelection = x.nextInt();
		}
		// loop for option menu to display after each time an option is selected
		while (optionSelection != 6) {
			
		
		switch (optionSelection) {
		case 1: // option 1 to display course number, name, credit and grade
			System.out.println(" Your current gpa is: " + gpa);
			System.out.println(" Your accumulated credits so far: " + credits);
			System.out.println(" Course Number\t\tCourse Name\t Course Credit\t Course Grade");
			for (int p=0; p<numCourses; p++){
				System.out.println((p+1)+ "\t\t\t " + courseInput[p] + "\t\t" + numCreditsInput[p] + "\t\t" + letterGradeInput[p]);
			}
			break;
		case 2: // option to to recalculate newGPA and print it
			 w = (gpa*credits) + z;
			 y = credits + totNumCredits;
			 newGPA = w/y;
			System.out.print(" Your new GPA is : " + newGPA);
			break;
		case 3: // option 3 to delete a course by using arrays and a loop to move every input after a value is removed, also recalculates z and totNumCredits
			System.out.println(" Course Number\t\tCourse Name\t Course Credit\t Course Grade");
			for (int p=0; p<numCourses; p++){
				System.out.println((p+1)+ "\t\t\t " + courseInput[p] + "\t\t" + numCreditsInput[p] + "\t\t" + letterGradeInput[p]);
			}
			System.out.print("Please enter the course number you want to delete: ");
			int deleteNumber = x.nextInt();
			
			for (int q=deleteNumber; q < numCourses; q++) {
				
			courseInput[q-1] = courseInput[q];
			
			numCreditsInput[q-1] = numCreditsInput[q];
			
			letterGradeInput[q-1] = letterGradeInput[q];
			}
			numCourses = numCourses-1;
			
			z -= (numGradeInput[deleteNumber-1]*numCreditsInput[deleteNumber-1]);
			totNumCredits -= numCreditsInput[deleteNumber-1];
			
			break;
		case 4: // adding a course to the system the same way as in the main for loop, also converts letterGrade to a double value and recalculates the z and totNumCredits
			numCourses = numCourses+1;
			System.out.print(" Please enter the name of course number " + (numCourses) + ": ");
			course = x.next();
			courseInput[numCourses-1] = course;
			
			System.out.print(" Please enter the number of credits of course number " + (numCourses) + ": ");
			numCredits = x.nextDouble();
			numCreditsInput[numCourses-1] = numCredits;
			
			System.out.print(" Please enter the letter grade for course number " + (numCourses) + ": ");
			letterGrade = x.next();
			letterGradeInput[numCourses-1] = letterGrade;
			
			switch (letterGrade) {
			
			case "A+":
				numGradeInput[numCourses-1] = 4.30;
				break;
			case "A":
				numGradeInput[numCourses-1] = 4.00;
				break;
			case "A-":
				numGradeInput[numCourses-1] = 3.70;
				break;
			case "B+":
				numGradeInput[numCourses-1] = 3.30;
				break;
			case "B":
				numGradeInput[numCourses-1] = 3.00;
				break;
			case "B-":
				numGradeInput[numCourses-1] = 2.70;
				break;
			case "C+":
				numGradeInput[numCourses-1] = 2.30;
				break;
			case "C":
				numGradeInput[numCourses-1] = 2.00;
				break;
			case "C-":
				numGradeInput[numCourses-1] = 1.70;
				break;
			case "D+":
				numGradeInput[numCourses-1] = 1.30;
				break;
			case "D":
				numGradeInput[numCourses-1] = 1.00;
				break;
			case "D-":
				numGradeInput[numCourses-1] = 0.70;
				break;
			case "FNS":
				numGradeInput[numCourses-1] = 0.00;
				break;
			default:
				numGradeInput[numCourses-1] = 0.00;
				break;
			}
			
			z += (numGradeInput[numCourses-1]*numCreditsInput[numCourses-1]);
			totNumCredits += numCreditsInput[numCourses-1];
			break;
		case 5: // terminates the program and closing message
			System.out.println("\nYou have requested to shut down the program. Thank you and goodbye.");
			System.exit(0);
			break;
			default:
				System.out.println("If you see this message, you have broken the program. Please restart and try again.");
				break;
			
		}
		System.out.println("\n"+optionMessage);
		optionSelection = x.nextInt();
		
		// data validation for options menu
				while (optionSelection > 5 || optionSelection < 1) {
					System.out.println(" Menu option has to be between 1 and 5 inclusive.");
					System.out.println(optionMessage);
					optionSelection = x.nextInt();
				}
		}
		x.close();
	}

}
