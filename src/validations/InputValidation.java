package validations;

import java.util.regex.Pattern;

public class InputValidation {
	
  // method to verify that item_name contains only alphanumeric characters
	
	public static boolean isValidName(String itemName) {
		if (Pattern.matches("\\w*", itemName))
			return true;
		System.out.println("Invalid name.");
		return false;
	}

}
