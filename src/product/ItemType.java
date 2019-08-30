package product;

import product.Item;

public interface ItemType {

	public double calculateTaxForItems(Item item);

	public double calculateTaxForManufacturedItems(Item item);

	public double calculateTaxForImportedItems(Item item);

	double calculateTaxForRawItems(Item item);

}
// interface for type of Item with its declared methods to calculate tax for
// different types of items
