package ItemType;

import constants.TaxConstants;
import product.Item;

public class Manufactured implements ItemType {

	@Override
	public double calculateTaxForItems(Item item) {
		double itemPrice = item.getItemPrice();
		double itemTax;
		itemTax = ((itemPrice * TaxConstants.TAX_FOR_MANUFACTURED_ITEMS) / 100)
				+ (TaxConstants.EXTRA_TAX_FOR_MANUFACTURED_ITEMS
						* (itemPrice + (itemPrice * TaxConstants.TAX_FOR_MANUFACTURED_ITEMS) / 100));
		return itemTax;
	}

}
