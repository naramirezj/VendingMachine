public class CoinBox {

	// private fields that keep track of the number of coins
	private int quarters;
	private int dimes;
	private int nickles;
	private boolean empty;

	/*
	 * Zero-parameter constructor, initializes the deposited coins.
	 */
	public CoinBox() {
		nickles = 0;
		dimes = 0;
		quarters = 0;

	}

	/*
	 * Gets the current value of the deposited coins in dollar format
	 * @return dollars (double)
	 */
	public double currentAmt() {
		double dollars = 0;
		dollars = (nickles * 0.05) + (dimes * 0.10) + (quarters * 0.25);
		return dollars;
	}

	/*
	 * Deposits a quarter
	 */
	public void depositQuarter() {
		quarters++;
	}
	
	/*
	 * Deposits a dime
	 */
	public void depositDime() {
		dimes++;
	}
	
	/*
	 * Deposits a nickel
	 */
	public void depositNickle() {
		nickles++;
	}

	/*
	 * @return quarters (int)
	 */
	public int getQuarterCount() {
		return quarters;
	}
	
	/*
	 * @return dimes (int)
	 */
	public int getDimeCount() {
		return dimes;
	}
	
	/*
	 * @return nickle(int)
	 */
	public int getNickleCount() {
		return nickles;
	}

	/*
	 * Sets quarters to the parameter.
	 * @param num_coins >= 0
	 */
	public void setQuarters(int num_coins) {
		quarters = 0;
		quarters = num_coins;
	}
	
	/*
	 * Sets dimes to the parameter.
	 * @param num_coins >= 0
	 */
	public void setDimes(int num_coins) {
		dimes = 0;
		dimes = num_coins;
	}
	
	/*
	 * Sets nickles to the parameter.
	 * @param num_coins >= 0
	 */
	public void setNickles(int num_coins) {
		nickles = 0;
		nickles = num_coins;
	}

	/*
	 * Transferring coins from a coin box to another coin box.
	 * @param an object CoinBox other
	 */
	public void transferCoinsFrom(CoinBox other) {
		// take from the other box and deposit in this box
		quarters += other.getQuarterCount();
		nickles += other.getNickleCount();
		dimes += other.getDimeCount();
		other.resetBox();

	}

	/*
	 * Resets the number of coins in the coin box to be all zeros.
	 */
	public void resetBox() {
		nickles = 0;
		dimes = 0;
		quarters = 0;
	}
	
	/*
	 * If the CoinBox is empty returns true, false otherwise.
	 * @return the boolean empty
	 */
	public boolean isEmpty() {
		empty = false;
		if (quarters == 0 && nickles == 0 && dimes == 0) {
			empty = true;
		}
		return empty;
	}
}// end class
