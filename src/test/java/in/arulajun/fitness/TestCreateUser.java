package in.arulajun.fitness;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.arulajun.fitness.exception.ValidationException;
import in.arulajun.fitness.model.User;
import in.arulajun.fitness.service.UserService;

public class TestCreateUser {
	@Test
	public void testCreateUserWithValidData() {

		UserService userService = new UserService();
		User newUser = new User();

		newUser.setFirstName("vv");
		newUser.setLastName("vicky");
		newUser.setEmail("vicky06@gmail.com");
		newUser.setPassword("vicky5");

		assertDoesNotThrow(() -> {
			userService.create(newUser);
		});
	}

	@Test
	public void testCreateUserWithInvalidData() {

		UserService userService = new UserService();

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(null);
		});
		String exceptedMessage = "Invalid user input";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}

	@Test
	public void testUserEmailNull() {

		UserService userService = new UserService();

		User newUser = new User();

		newUser.setId(5555);
		newUser.setFirstName("Arul");
		newUser.setLastName("Ajun");
		newUser.setEmail(null);
		newUser.setPassword("Ajunajun55");
		newUser.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});

		String exceptedMessage = "Email cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}

	@Test
	public void testUserEmailEmpty() {

		UserService userService = new UserService();

		User newUser = new User();

		newUser.setId(5555);
		newUser.setFirstName("Arul");
		newUser.setLastName("Ajun");
		newUser.setEmail(" ");
		newUser.setPassword("Ajunajun55");
		newUser.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});

		String exceptedMessage = "Email cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}

	@Test
	public void testUserPasswordEmpty() {

		UserService userService = new UserService();

		User newUser = new User();

		newUser.setId(5555);
		newUser.setFirstName("Arul");
		newUser.setLastName("Ajun");
		newUser.setEmail("ajundcruzz55@gmail.com");
		newUser.setPassword("");
		newUser.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});

		String exceptedMessage = "Password cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}

	@Test
	public void testUserPasswordNull() {

		UserService userService = new UserService();

		User newUser = new User();

		newUser.setId(5555);
		newUser.setFirstName("Arul");
		newUser.setLastName("Ajun");
		newUser.setEmail("ajundcruzz55@gmail.com");
		newUser.setPassword(null);
		newUser.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});

		String exceptedMessage = "Password cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}

	@Test

	public void testCreateUserWithFirstNameNull() {
		UserService userService = new UserService();
		User newUser = new User();
		newUser.setId(1);
		newUser.setFirstName(null);
		newUser.setLastName("Ajun");
		newUser.setEmail("ajundcruzz55@gmail.com");
		newUser.setPassword("ajunajun55");
		newUser.setActive(true);

		Exception exception = assertThrows(Exception.class, () -> {
			userService.create(newUser);
		});
		String expectedMessage = "FirstName cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test

	public void testCreateUserWithFirstNameEmpty() {
		UserService userService = new UserService();
		User newUser = new User();
		newUser.setId(1);
		newUser.setFirstName("");
		newUser.setLastName("Ajun");
		newUser.setEmail("ajundcruzz55@gmail.com");
		newUser.setPassword("ajunajun55");
		newUser.setActive(true);

		Exception exception = assertThrows(Exception.class, () -> {
			userService.create(newUser);
		});
		String expectedMessage = "FirstName cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(expectedMessage.equals(actualMessage));
	}
}
