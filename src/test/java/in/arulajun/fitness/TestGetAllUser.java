package in.arulajun.fitness;

import java.util.Set;

import org.junit.jupiter.api.Test;

import in.arulajun.fitness.model.User;
import in.arulajun.fitness.service.UserService;

public class TestGetAllUser {
	@Test
	public void getAllUser() {
		UserService userService = new UserService();
	
		Set<User> users = userService.getAll();
		
		System.out.print(users);
	}
	@Test
	public void getUserById() {
		UserService userService = new UserService();
		
		User user = userService.findById(1);
		
		System.out.print(user);
	}
	

}
