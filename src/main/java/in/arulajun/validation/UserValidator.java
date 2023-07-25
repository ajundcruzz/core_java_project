package in.arulajun.validation;

import in.arulajun.fitness.exception.ValidationException;
import in.arulajun.fitness.model.User;
import util.StringUtil;

public class UserValidator {

	public static void validate(User user) throws ValidationException {
		if (user == null) {
			throw new ValidationException("Invalid user input");
		}

		StringUtil.rejectIfInvalidString(user.getEmail(), "Email");
		StringUtil.rejectIfInvalidString(user.getPassword(), "Password");
		StringUtil.rejectIfInvalidString(user.getFirstName(), "First Name");
	}
}
