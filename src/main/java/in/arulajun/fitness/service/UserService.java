package in.arulajun.fitness.service;

import in.arulajun.fitness.dao.UserDAO;
import in.arulajun.fitness.model.User;

public class UserService {
	
	public User[] getAll(){
		
		UserDAO userDao = new UserDAO();
		
		User[] userList = userDao.findAll();
		
		for(int i = 0; i < userList.length; i++) {
			
			System.out.println(userList[i]);
		}
		
		
		return userList;
	}
public void create() {
		
		User newUser = new User();
		newUser.setId(5555);
		newUser.setFirstName("Arul");
		newUser.setLastName("Ajun");
		newUser.setEmail("ajundcruzz55@gmail.com");
		newUser.setPassword("Ajunajun55");
		newUser.setActive(true);
		
		UserDAO userDao = new UserDAO();
		userDao.create(newUser);
		
		
		
	}

}
