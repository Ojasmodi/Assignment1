package product;

import constants.TaxConstants;

public class Item  {

	private String itemName;
	private double itemPrice;
	private String itemType;
	private double itemQuantity;
	private double itemTax = 0.0;

	// function to get type of item based on user's choice
	public String getItemTypeFromItemNumber(int itemNumber) {
		String itemType = "";
		switch (itemNumber) {
		case 1:
			itemType = "Raw";
			break;
		case 2:
			itemType = "Manufactured";
			break;
		case 3:
			itemType = "Imported";
			break;
		default:
			itemType = "Wrong item type.";
			System.out.println("Invalid response. Please choose from choices 1 to 3.");
		}
		return itemType;
	}

	// getters and setters for properties of class Item

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public double getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(double itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

}
