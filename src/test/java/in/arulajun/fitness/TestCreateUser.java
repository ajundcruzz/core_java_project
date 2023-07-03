package in.arulajun.fitness;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import in.arulajun.fitness.model.User;
import in.arulajun.fitness.service.UserService;

public class TestCreateUser {
	@Test
	public void testCreateUserWithValidData() {
		
		UserService userService = new UserService();
		User newUser = new User();
		newUser.setId(5555);
		newUser.setFirstName("Arul");
		newUser.setLastName("Ajun");
		newUser.setEmail("ajundcruzz55@gmail.com");
		newUser.setPassword("Ajunajun55");
		newUser.setActive(true);
		assertDoesNotThrow(()->{
		userService.create(newUser);
	});
	}
	@Test
		public void testCreateUserWithInvalidData() {
			
			UserService userService = new UserService();
			 Exception exception = assertThrows(Exception.class,()->{
				userService.create(null);
			});
			 String exceptedMessage = "Invalid User Input";
			 String actualMessageString = exception.getMessage();
			 
			 assertTrue(exceptedMessage.equals(actualMessageString));
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
		

		 Exception exception = assertThrows(Exception.class,()->{
			userService.create(null);
		});
		 
		 String exceptedMessage = "Email can not null or empty";
		 String actualMessageString = exception.getMessage();
		 
		 assertTrue(exceptedMessage.equals(actualMessageString));
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
		

		 Exception exception = assertThrows(Exception.class,()->{
			userService.create(null);
		});
		 
		 String exceptedMessage = "Email can not null or empty";
		 String actualMessageString = exception.getMessage();
		 
		 assertTrue(exceptedMessage.equals(actualMessageString));
}
}
