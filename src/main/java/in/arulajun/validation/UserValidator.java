package in.arulajun.validation;

import in.arulajun.fitness.exception.ValidationException;
import in.arulajun.fitness.model.User;
import util.StringUtil;

public class UserValidator {

	public static void validate(User user) throws ValidationException {
		if (user == null) {
			throw new ValidationException("Invalid user input");
		}

//		if(user.getEmail() == null || "".equals(user.getEmail().trim())) {
//			throw new ValidationException("Email cannot be null or empty");
//		}
//		
//		if (user.getPassword() == null || "".equals(user.getPassword().trim())) {
//			throw new ValidationException("Password cannot be null or empty");
//		}
//		
//		if (user.getfName() == null || "".equals(user.getfName().trim())) {
//			throw new ValidationException("First name cannot be null or empty");
//		}

		StringUtil.rejectIfInvalidString(user.getEmail(), "Email");
		StringUtil.rejectIfInvalidString(user.getPassword(), "Password");
		StringUtil.rejectIfInvalidString(user.getFirstName(), "First Name");
	}
}
