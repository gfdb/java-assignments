// -----------------------------------------------------------------------------------------------
// Written by: Gianfranco Dumoulin
// Date: March 7 2019
// Purpose: calculates the cost
// of the mortgage insurance, total loan amount and mortgage payments per month 
// based on the asking price, amortization period, interest rate, down payment and mortgage mode.
// It is intended to provide information to someone looking to purchase a house through a bank. 
// -----------------------------------------------------------------------------------------------

import java.util.Scanner;

public class Assignment2Q2 {

	public static void main(String[] args) {
		
		Scanner m = new Scanner(System.in);
		
		System.out.print("                    Mortgage Calculator                    "
				+ "\n----------------------------------------------------------------\n\n");
		

		
		
		System.out.print("Please enter the asking price for the house: ");  // asking price
		double askingPrice = m.nextDouble();
		
		System.out.print("Please enter the loan amortization period in years: "); // amortization period
		int amort = m.nextInt();
		
		System.out.print("Please enter the interest rate offered by the bank: "); // interest rate
		double interest = m.nextDouble();
		
		System.out.print("Please enter the down payment amount in dollars: "); // down payment
		double downPayment = m.nextDouble();
		
		while ( downPayment < ( askingPrice * 0.05 )) {  // checking and forcing down payment to be 5% of asking price 
			
			System.out.print("Please enter the down payment amount in dollars: ");
			downPayment = m.nextInt();
		}
		
		System.out.print("Please enter the mode of mortgage payments monthly (M/m) or bi-weekly (B/b): "); // mode of mortgage payments
		String mmp = m.next();
		
		while ( (!(mmp.equalsIgnoreCase("M"))) && (!(mmp.equalsIgnoreCase("B")))){  // checking and forcing either b or m
			
			System.out.print("Please enter the mode of mortgage payments monthly (M/m) or bi-weekly (B/b): ");
			 mmp = m.next();
			 
		}
		// percentage of down payment variable
		double percentDP;
		
		percentDP = (downPayment/askingPrice)*100;
		
		
		// variable for mortgage insurance interest rates ( miir )
		double mmir = 0;
		
		// mortgage insurance interests rate conditions
		if ( 5 <= percentDP && percentDP < 10) {
			mmir = 0.04;
		} else if ( 10 <= percentDP && percentDP < 15) {
			mmir = 0.031;
		} else if ( 15 <= percentDP && percentDP < 20) {
			mmir = 0.028;
		} else if ( 20 < percentDP) {
			mmir = 1;
		}
		
		// variable for Mortgage insurance (mInsurance)
		
		double mInsurance = (askingPrice - downPayment) * mmir;
		
		// variable for loan amount (lamount)
		
		double lamount = (askingPrice - downPayment + mInsurance);
		
		// Converting from monthly and bi-weekly to 12 times per year and 26 times per year
		int bm;
		
		if (mmp.equalsIgnoreCase("M")){
			bm = 12;
		} else {
			bm = 26;
		}
		
		
		// variable r for monthly/bi-weekly interest rate
		
		double r = (interest/100)/bm;
		
		// variable n for number of payments
		
		int n = amort * bm;
		
		// varibles for mortgage payments (mPayemnts)
		
		double mPayments = lamount * ((r * Math.pow((1+r), n) / (Math.pow((1+r), n) - 1)));
		
		// format to only print 5 decimals
		String mPaymentsS = Double.toString(mPayments);
		mPaymentsS = String.format("%.05f", mPayments);
		
		
		System.out.print("\nMortgage Result\n---------------\n");
		System.out.println("Your mortgage insurance will be $" + mInsurance);
		System.out.println("Your total loan amount will be $" + lamount);
		System.out.println("Your mortgage payments will be $" + mPaymentsS);

		
		
	}

}
