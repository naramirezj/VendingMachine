/*
 *Assignment Name: 
 * Assignment 2:  The Vending Machine
 *Due Date: 
 * March 3th 2022
 *Author:
 * Natalia Ramirez Jimenez
 *Written/Online sources used: 
 * Johnson, B. (2022) Assignment 2:  The Vending Machine.
 * https://johnsonba.cs.grinnell.edu/CSC207/2022S/assignments/encryption.html
 * StackOverflow (2017) Format double to 2 decimal places with leading 0s.
 * https://johnsonba.cs.grinnell.edu/CSC207/2022S/assignments/encryption.html
 * StackOverflow (2010) Creating an Arraylist of Objects.
 * https://stackoverflow.com/questions/3982550/creating-an-arraylist-of-objects
 *Help obtained: 
 * None
 *Academic Honesty Statement: 
 * "I/we confirm that the above list of 
 * sources is complete AND that I/we have not talked to anyone 
 * else (e.g., CSC 207 students) about the solution to this problem."
 */
import java.util.Scanner;

public class VendingMachineSim {

	public static void main(String[] args) {
		boolean runSim = true;
		Display display = new Display();
		// display introduction
		display.show("Welcome! Soda Vending Machine");
		VendingMachine machine = new VendingMachine();
		String response = null;
		Scanner sc = new Scanner(System.in);
		while (runSim) {
			// scanning from terminal
			// initial options
			display.show("Do you want to buy something? (yes or no)");
			// scanning response
			if (sc.hasNext())
				response = sc.nextLine();
			if (response.toLowerCase().equals("yes")) {
				// if yes print choices
				machine.printChoices();
				display.show("Enter the ID number of the beverage you want");
				// scanning the ID for the selected soda from terminal
				Scanner choice = new Scanner(System.in);
				if (choice.hasNext()) {
					String selection = null;
					selection = choice.nextLine();
					// if the ID is available then print the price and amount deposited
					if (machine.isAvailable(selection)) {
						display.priceDis(machine.getPrice(selection), machine.getAmtDeposited());
						while (machine.getPrice(selection) > machine.getAmtDeposited()) { 
							//while the price of the soda is larger than the money deposited
							display.priceDis(machine.getPrice(selection), machine.getAmtDeposited()); //display price
							display.show("Insert bill, quarter, dime, or nickel: ");
							Scanner money = new Scanner(System.in); //scanning form of payment
							String m_type = null;
							if (money.hasNext()) {
								m_type = money.nextLine();
								switch (m_type) {
								case "bill":
									machine.acceptBill();
									break;
								case "quarter":
									machine.acceptQuarter();
									break;
								case "dime":
									machine.acceptDime();
									break;
								case "nickel":
									machine.acceptNickle();
									break;
								default:
									display.error("Please enter a valid option");
									break;
								}
							}
							}
						display.succesful(); //when the loop ends display successful message
						if (machine.getAmtDeposited() >= machine.getPrice(selection)) { //making change
							double change = 0;
							change = (machine.getAmtDeposited() - machine.getPrice(selection));
							machine.makeChange(change);
							machine.completeSale();
						}
					}
					// if ID is not available print the SoldOut message
					// this procedure also tackles wrong inputed IDs
					else {
						display.soldOut();
					}
				}
				//
				response = null;
			} // if "yes"
			else {
				runSim = false;
				display.show("Thank you for visiting the Soda Shack!");
			} //if "no"
		} // while
	} // main



} // class