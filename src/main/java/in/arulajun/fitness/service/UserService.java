package in.arulajun.fitness.service;

import java.util.Set;

import in.arulajun.fitness.dao.UserDAO;
import in.arulajun.fitness.model.User;
import in.arulajun.validation.UserValidator;

public class UserService {

	public Set<User> getAll() {

		UserDAO userDao = new UserDAO();

		Set<User> userList = userDao.findAll();

		for (User user : userList) {
			System.out.println(user);
		}

		return userList;
	}

	public void create(User newUser)throws Exception {
		UserValidator.validate(newUser);
		UserDAO userDao = new UserDAO();
		userDao.create(newUser);
	}

	public void update() {

		User updatedUser = new User();
		
		updatedUser.setId(5555);
		updatedUser.setFirstName("Arul");
		updatedUser.setLastName("Ajun");
		updatedUser.setEmail("ajundcruzz55@gmail.com");
		updatedUser.setPassword("Ajunajun55");
		updatedUser.setActive(true);
		
		UserDAO userDao = new UserDAO();
		userDao.update(updatedUser);

	}
	
	public void delete() {

		User deleteUser = new User();
		
		deleteUser.setId(5555);
		deleteUser.setFirstName("Arul");
		deleteUser.setLastName("Ajun");
		deleteUser.setEmail("ajundcruzz55@gmail.com");
		deleteUser.setPassword("Ajunajun55");
		deleteUser.setActive(true);
		
		UserDAO userDao = new UserDAO();
		userDao.update(deleteUser);

	}
	
	public User findById(int newId) {
		
		UserDAO userDao = new UserDAO();

		return userDao.findById(1);

	}

}
