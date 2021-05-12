package hW5D.eCommmerce.business.validationRules;

import java.util.regex.Pattern;

import hW5D.eCommmerce.entities.concretes.User;

public class UserValidation {
	public static boolean validation(User user) {
		boolean validateStatus = true;

		String mailPattern = "[a-z0-9]+@[a-z0-9]+\\\\.[a-z]+";

		if (user.getFirstName().length() <= 2) {
			System.out.println("Adýnýz en az iki karakterden oluþmalýdýr.");
			validateStatus = false;
		}
		if (user.getLastName().length() <= 2) {
			System.out.println("Soyadýnýz en az iki karakterden oluþmalýdýr.");
			validateStatus = false;
		}
		if (user.getPassword().length() <= 6) {
			System.out.println("Þifreniz en az altý karakterden oluþmalýdýr.");
			validateStatus = false;
		}
		if (Pattern.matches(mailPattern, user.geteMail())) {
			System.out.println("Email adresiniz doðru deðildir.");
			validateStatus = false;
		}

		return validateStatus;

	}

}
