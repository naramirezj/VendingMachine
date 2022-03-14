import java.text.DecimalFormat;

public class BrandInventory {
// This class keeps track of the information for each separate brand stocked
// in the vending machine.  The machine will keep an ArrayList of these objects.
	
	// private data fields
    private String ID;
    private double price;
    private int items;
    private DecimalFormat df = new DecimalFormat("#.00"); //formatting to two decimal places
    
    /* Constructor, sets ID, price, and the number of items.
	 */
	public BrandInventory(String ID, double price, int numItems) {
            this.ID = ID;
            this.price = price;
            items = numItems;
		
	}
	/* 
	 * @returns ID (String)
	 */
	public String getID() {
            return ID;

	}
	/* 
	 * @returns price (double)
	 */
	public double getPrice() {
            return price;

	}
	/* 
	 * @returns items (int)
	 */
	public int getCount() {
            return items;

	}
	
	/*
	 *  Updates the available number of sodas after a successful purchase.
	 */
	  public void reduceOnHand() {
              items--;
              

	  }
	
	/* @return true if the number on hand for this brand has dropped to 0.
	 */
	public boolean isSoldOut() {
            return(items == 0);

	}
	
	/* @return a string containing the ID of the brand and the formatted price of each soda.
	*/
	public String toString() {
            return (ID + ": $" + df.format(price));
	}
	

}
