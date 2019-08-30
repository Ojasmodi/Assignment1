package ItemType;

import constants.TaxConstants;
import product.Item;

public class Imported implements ItemType {

	@Override
	public double calculateTaxForItems(Item item) {
		double itemTax;
		double itemPrice = item.getItemPrice();
		System.out.println(itemPrice);
		itemTax = (TaxConstants.TAX_FOR_IMPORTED_ITEMS * itemPrice) / 100;
		double tempNetprice = itemTax + itemPrice;
		System.out.println(itemTax);
		
		// adding surcharge for the item
		if (tempNetprice <= 100)
			itemTax += TaxConstants.SURCHARGE_FOR_UPTO_HUNDRED_RUPEES;
		else if (tempNetprice > 100 && tempNetprice <= 200)
			itemTax += TaxConstants.SURCHARGE_FOR_MORE_THAN_HUNDRED_TO_TWO_HUNDRED_RUPEES;
		else
			itemTax = tempNetprice + (TaxConstants.SURCHARGE_FOR_MORE_THAN_TWO_HUNDRED_RUPEES * tempNetprice) / 100;
		return itemTax;
	}

}
