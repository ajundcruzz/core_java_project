package in.arulajun.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.arulajun.fitness.model.User;

public class UserValidator {
	
	public static void validate(User user)throws Exception {
		
		if(user == null) {
			throw new Exception("invalid user input");
		}
		if(user.getEmail() == null || "".equals(user.getEmail().trim())){
			throw new Exception("Email can not null or empty");
		}
		if (user.getPassword() == null || user.getPassword().isBlank()) {
			throw new IllegalArgumentException("password cannot be null or empty");
		}
		if (user.getFirstName() == null || user.getFirstName().isBlank()) {
			throw new IllegalArgumentException("name cannot be null or empty");
		}

}
}
