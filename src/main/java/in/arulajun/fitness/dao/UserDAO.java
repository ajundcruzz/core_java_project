package in.arulajun.fitness.dao;

import in.arulajun.fitness.model.User;

public class UserDAO {
	
	public User[] findAll() {
		User[] userList = UserList.listOfUsers;
		return userList;
	}
	
	public void create() {
		
		User newUser = new User();
		newUser.setId(241532);
		newUser.setFirstName("Arul");
		newUser.setLastName("Ajun");
		newUser.setEmail("ajundcruzz55@gmail.com");
		newUser.setPassword("nanthanAjun55");
		newUser.setActive(true);
		
		UserList.listOfUsers[0] = newUser;
		
	}

}
