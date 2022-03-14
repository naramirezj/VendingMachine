import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachine {

	// private data fields
	private ArrayList<BrandInventory> inventory; // this array or ArrayList stores the information for inventory
	private CoinBox depositCoins;
	private CoinBox total_change;
	private BillBox dollars;
	private String ID;
	private double price, object_price;
	private int quantity;
	private boolean sold, change_bool;
	private double nickels, quarters, dimes;
	final double nickel = 0.05;
	final double quarter = 0.25;
	final double dime = 0.10;

	/*
	 * Zero-parameter constructor, initializes all the essential elements of
	 * VendingMachine
	 */
	public VendingMachine() {

		Scanner datain = null;
		inventory = new ArrayList<BrandInventory>();
		depositCoins = new CoinBox();
		total_change = new CoinBox();
		dollars = new BillBox();

		total_change.setQuarters(10); // giving the change box quarters, nickles, and dimes to start with
		total_change.setDimes(10);
		total_change.setNickles(10);

		try {
			datain = new Scanner(new FileReader("config.dat")); // reading file
			while (datain.hasNext()) {
				ID = String.valueOf(datain.nextInt());
				price = datain.nextDouble();
				quantity = datain.nextInt();
				inventory.add(new BrandInventory(ID, price, quantity)); // adding the new created object to the
																		// ArrayList
			}
		} catch (IOException ioe) {
			System.err.println("Cannot open config.dat"); // handling errors and exceptions
		} finally {
			if (datain != null)
				datain.close(); // closing file
		}
	} // end constructor

	/*
	 * Checks that the selected ID is valid and is not sold out
	 * 
	 * @return true if its available, false if not
	 */
	public boolean isAvailable(String purchaseID) {
		sold = true;
		for (BrandInventory product : inventory) {
			if (product.getID().equals(purchaseID)) {
				if (product.isSoldOut())
					sold = false;
			}
		}
		return sold;
	}

	/*
	 * Getting the total amount deposited in both boxes
	 * 
	 * @return the total amount (double)
	 */
	public double getAmtDeposited() {
		return (depositCoins.currentAmt() + dollars.getCurrentBills());
	}

	/*
	 * deposits bills
	 */
	public void acceptBill() {
		dollars.depositBill();
	}

	/*
	 * deposits quarters
	 */
	public void acceptQuarter() {
		depositCoins.depositQuarter();
	}

	/*
	 * deposits dimes
	 */
	public void acceptDime() {
		depositCoins.depositDime();
	}

	/*
	 * deposits nickles
	 */
	public void acceptNickle() {
		depositCoins.depositNickle();
	}

	/*
	 * Divides the change into quarters, nickles, and dimes. Additionally checks if
	 * there is not change available to give.
	 * 
	 * @return boolean if an exact change can be given
	 */
	public boolean makeChange(double dollar_amount) {
		change_bool = true;
		Display change = new Display();
		if (total_change.isEmpty() && depositCoins.isEmpty()) { // check if boxes are empty
			change_bool = false;
		}
		quarters = dollar_amount / quarter;
		dollar_amount %= quarter; // updating quantity each iteration
		dimes = dollar_amount / dime;
		dollar_amount %= dime;
		nickels = dollar_amount / nickel;
		dollar_amount %= nickel;
		if (dollar_amount != 0) {
			change.notExactChange();
			change_bool = false;
		} else {
			change.takeChange((int) quarters, (int) dimes, (int) nickels);
		}

		return change_bool;
	}

	/*
	 * Prints inventory
	 */
	public void printInventory() {
		Display choices = new Display();
		for (BrandInventory product : inventory) {
			choices.show(product.toString());
		}
	}

	/*
	 * Prints choices
	 */
	public void printChoices() {
		Display choices = new Display();
		choices.Choices();
		for (BrandInventory product : inventory) {
			choices.show(product.toString());
		}
	}

	/*
	 * Handles cleaning after the purchase and transfers coins from the deposit
	 * coinbox to the change one.
	 */
	public void completeSale() {
		total_change.transferCoinsFrom(depositCoins);
		dollars.resetBills();
	}

	/*
	 * Gets the price of the object with the inputed purchaseID
	 * 
	 * @param String purchase ID
	 * 
	 * @return the price of the object (boolean)
	 */
	public double getPrice(String purchaseID) {
		object_price = 0;
		for (BrandInventory product : inventory) {
			if (product.getID().equals(purchaseID)) {
				object_price = product.getPrice();
			}
		}
		return object_price;
	}

} // end of class