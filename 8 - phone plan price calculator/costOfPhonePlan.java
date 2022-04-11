// -----------------------------------------------------------------------------------------------
// Written by: Gianfranco Dumoulin
// Date: March 7 2019
// Purpose: calculates the cost
// of three phone plan options ( A, B, and C) based on a number of options selected by the user.
// The phone plan options are all 2 year options and calculate the cost based on if the user wants a 
// line for the phone, to purchase the phone outright or not, and which phone the user chooses. 
// -----------------------------------------------------------------------------------------------


import java.util.Scanner;

public class CostOfPhonePlan {

	public static void main(String[] args) {

		// variable for the cost of the phone for outright and different plans

		double costOfPhone;
		double costOfPhoneA;
		double costOfPhoneB;
		double costOfPhoneC;

		double outrightPixel3 = 1269.00;
		double outrightNote9 = 1599.00;
		double outrightiPhone = 1809.99;

		// Phone prices for plan A

		double pixel3A = 779.00;
		double note9A = 1189.00;
		double iPhoneA = 1339.00;

		// Phone prices for plan B

		double pixel3B = 429.00;
		double note9B = 839.00;
		double iPhoneB = 939.00;

		// Phone prices for plan C

		double pixel3C = 0.00;
		double note9C = 639.00;
		double iPhoneC = 819.99;

		// declaring the variables for plan A, B, C
		double planA;
		double planB;
		double planC;

		// total costs for plan a b c

		double totalA = 0;
		double totalB = 0;
		double totalC = 0;

		Scanner x = new Scanner(System.in);

		System.out.println("                    CellPhoneHub Plans                   \n"
				+ "---------------------------------------------------------\n");

		// variable for the number of phone lines requested (numLines)
		System.out.print("Please enter the number of phone lines you need (1-5): ");
		int numLines = x.nextInt();


		// cost for 2 years 
		planA = 70 * 24;
		planB = 89 * 24;
		planC = 120 * 24;

	// this is the beginning of the algorithm and it will loop based on the number of phone lines the user wants, if the user
	// wants two lines it will loop twice. number of lines = number of times loop is executed
		
		for (int z = 1; z <= numLines; z++) {
			
			// opening message for each line based on how many times the loop has been executed(z)
			System.out.print("\n\nLine " + z + " Info:\n");
			
			// needAphone is the variable that determines whether or not the user wants a phone with that line
			System.out.print("Do you need a phone with this line (y/n): ");
			String needAphone = x.next();

			if (needAphone.equalsIgnoreCase("Y")) {

				System.out.print("Do you want to purchase the phone outright (y/n): ");
				String outright = x.next();

				//phoneSelect is the variable that identifies which kind of phone the user select
				System.out.print("Please enter 1 for Google, 2 for Samsung or 3 for iPhone: ");
				int phoneSelect = x.nextInt();

				if (outright.equalsIgnoreCase("Y")) {

					switch (phoneSelect) {

					case 1:
						costOfPhone = outrightPixel3;
						break;
					case 2:
						costOfPhone = outrightNote9;
						break;
					case 3:
						costOfPhone = outrightiPhone;
						break;
					// default is not necessary since we assume perfect user but it's included to
					// avoid an error/crash
					default:
						costOfPhone = 0;
						break;

					}
					if (z > 1) {
						totalA += planA + costOfPhone - 240;
						totalB += planB + costOfPhone - 240;
						totalC += planC + costOfPhone - 240;
					} else {
						totalA += planA + costOfPhone;
						totalB += planB + costOfPhone;
						totalC += planC + costOfPhone;
					}
				} else {

					switch (phoneSelect) {

					case 1:
						costOfPhoneA = pixel3A;
						costOfPhoneB = pixel3B;
						costOfPhoneC = pixel3C;
						break;
					case 2:
						costOfPhoneA = note9A;
						costOfPhoneB = note9B;
						costOfPhoneC = note9C;
						break;
					case 3:
						costOfPhoneA = iPhoneA;
						costOfPhoneB = iPhoneB;
						costOfPhoneC = iPhoneC;
						break;
					// default is not necessary since we assume perfect user but it's included to
					// avoid an error/crash
					default:
						costOfPhoneA = 0;
						costOfPhoneB = 0;
						costOfPhoneC = 0;
						break;
					}
					if (z > 1) {
						totalA = totalA + planA + costOfPhoneA - 240;
						totalB = totalB + planB + costOfPhoneB - 240;
						totalC = totalC + planC + costOfPhoneC - 240;
					} else {
						totalA = totalA + planA + costOfPhoneA;
						totalB = totalB + planB + costOfPhoneB;
						totalC = totalC + planC + costOfPhoneC;
					}

				}
			} else {
				if (z > 1) {
					totalA += (planA) - 480;
					totalB += (planB) - 480;
					totalC += (planC) - 480;
				} else {
					totalA += (planA) - 240;
					totalB += (planB) - 240;
					totalC += (planC) - 240;
				}
			}
		}

		System.out.println("\nTotal cost for 2 years with plan A will be $" + totalA);
		System.out.println("Total cost for 2 years with plan B will be $" + totalB);
		System.out.println("Total cost for 2 years with plan C will be $" + totalC);

		x.close(); 
	}

}
