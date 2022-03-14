import java.text.DecimalFormat;

public class Display {
	// possible private data fields	
	private DecimalFormat df = new DecimalFormat("#.00"); //formatting decimal places to two
	public Display() {
	
	}
	
	/*
	 * Prints to the terminal a message passed in from calling method
	 * @param String message
	 */
	public void show(String message) {
		System.out.println(message);	
	}
	
	/*
	 * Prints to the terminal a message passed in from calling method
	 * @param String message
	 */
	public void error(String message) {
		System.out.println("Error: " + message);
	}
	
	/*
	 * Informs the user of change returned
	 * @param three ints, corresponding to quarters, dimes, and nickels
	 */
	public void takeChange(int q, int d, int n) {
		System.out.println("Please take your change:");
		System.out.println(q + " quarters " + d + " dimes " + n + " nickels.");
	}
	
	/*
	 * Informs the user of incorrect ID entered or sold out brand
	 */
	public void soldOut() {
		System.out.println("Sorry, incorrect ID entered or that brand is sold out.");
	}
	
	/*
	 * 	Not exact change to give message
	 */
	public void notExactChange() {
		System.out.println("Sorry, cannot make exact change!");
	}
	
	/*
	 * 	Message before inventory appears
	 */
	public void Choices() {
		System.out.println("Current selection:");
	}
	
	/*
	 * 	Displaying prices
	 */
	public void priceDis(double a, double b) {
		System.out.println("Price: $" + df.format(a) + " Deposited: $" + df.format(b));
	}
	
	/*
	 * 	Successful sale message
	 */
	public void succesful() {
		System.out.println("Sale succesful! Please take your soda.");
	}



}