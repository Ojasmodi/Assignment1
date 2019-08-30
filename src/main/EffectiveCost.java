package main;

import java.util.*;

import ItemType.ItemType;
import ItemType.Manufactured;
import ItemType.Raw;
import constants.ConsoleMessages;
import product.Item;
import validations.InputValidation;

public class EffectiveCost {

	public static void main(String[] args) {
		System.out.println("Enter item details...");
		getInputFromUser();
	}

	// method for getting user Input
	public static void getInputFromUser() {
		Scanner sc = new Scanner(System.in);
		List<Item> items = new ArrayList<>();
		char choice;
		String itemName;
		double itemQuantity;
		double itemPrice;
		String itemType = "";
		String inputValue;
		do {
			Item item = new Item();
			do {
				System.out.println("Enter a valid item name.");
				itemName = getInputForItemValue();
			} while (!InputValidation.isValidName(itemName));
			item.setItemName(itemName);
			System.out.println("Enter a valid item price.");
			inputValue = getInputForItemValue();
			while (true) {
				try {
					itemPrice = Double.parseDouble(inputValue);
					break;
				} catch (NumberFormatException e) {
					System.out.println(ConsoleMessages.INVALID_MESSAGE);
				}
				inputValue = getInputForItemValue();
			}
			item.setItemPrice(itemPrice);
			System.out.println("Enter valid item quantity.");
			inputValue = getInputForItemValue();
			while (true) {
				try {
					itemQuantity = Double.parseDouble(inputValue);
					break;
				} catch (NumberFormatException e) {
					System.out.println(ConsoleMessages.INVALID_MESSAGE);
				}
				inputValue = getInputForItemValue();
			}
			item.setItemQuantity(itemQuantity);
			int itemNumber = 0;
			do {
				System.out.println("Enter item-type number.-\n 1.Raw\n 2.Manufactured\n 3.Imported");
				inputValue = getInputForItemValue();
				while (true) {
					try {
						itemNumber = Integer.parseInt(inputValue);
						break;
					} catch (Exception e) {
						System.out.println(ConsoleMessages.INVALID_MESSAGE);
					}
					inputValue = getInputForItemValue();
				}
				itemType = item.getItemTypeFromItemNumber(itemNumber);
			} while (itemType.equals("Wrong item type."));
			item.setItemType(itemType);
			items.add(item);
			System.out.println("Do you want to add more item(y/n)?");
			choice = sc.next().charAt(0);
		} while (choice == 'y' || choice == 'Y');
		calculatePriceForItems(items);
		sc.close();
	}

	// method to check whether the input entered contains space or if any enter
	// is pressed or not
	private static String getInputForItemValue() {
		Scanner sc = new Scanner(System.in);
		String inputString = sc.nextLine();
		while (inputString != null && inputString.trim().length() == 0) {
			if (inputString.isEmpty() || inputString.trim().length() == 0)
				System.out.println("Please enter a value.");
			else
				break;
			inputString = sc.nextLine();
		}
		return inputString;
	}

	// method for calculating the total price( itemPrice + tax) for all items
	private static void calculatePriceForItems(List<Item> items) {

		double itemTax;
		Iterator<Item> iterator=items.iterator();
		 while (iterator.hasNext()) {
			Item item = iterator.next();
			String itemType = item.getItemType();
			ItemType typeOfItem;
			if (itemType.equals("Raw"))
				typeOfItem = new Raw();
			else if (itemType.equals("Manufactured"))
				typeOfItem = new Manufactured();
			else
				typeOfItem = new Manufactured();
			itemTax = typeOfItem.calculateTaxForItems(item);
			System.out.println("Item name- " + item.getItemName());
			System.out.println("Item price- " + item.getItemPrice());
			System.out.println("Tax per item- " + itemTax);
			System.out.print("Final price for whole item.- ");
			System.out.println((item.getItemPrice() + itemTax) * item.getItemQuantity());
			System.out.println();
		}
	}
}
