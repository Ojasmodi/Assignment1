package ItemType;

import constants.TaxConstants;
import product.Item;
import ItemType.ItemType;

public class Raw implements ItemType {

	@Override
	public double calculateTaxForItems(Item item) {
		double itemTax;
		double itemPrice = item.getItemPrice();
		itemTax = (itemPrice * TaxConstants.TAX_FOR_RAW_ITEMS) / 100;
		return itemTax;
	}

}
