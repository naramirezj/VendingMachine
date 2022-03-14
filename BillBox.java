public class BillBox {

    /* private data fields  */
    private double cash;
	
    /* Constructor
	 */
    public BillBox() {
        cash = 0;

	}
    
    /* Deposits one bill in the BillBox
	 * @returns void
	 */
	public void depositBill() {
            cash ++;

	}
    	
	/* Resets the deposited bill in the current transaction
	 * @returns void
	 */
	public void resetBills() {
            cash = 0;
	}
	
	/*
	 * Returns the deposited bills
	 * @return the number of recently deposited bills 
	 */
	public double getCurrentBills() {
            return cash;
	}
	
	
}
