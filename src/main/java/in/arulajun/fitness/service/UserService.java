package in.arulajun.fitness.service;

import in.arulajun.fitness.dao.UserDAO;
import in.arulajun.fitness.model.User;

public class UserService {

	public User[] getAll() {

		UserDAO userDao = new UserDAO();

		User[] userList = userDao.findAll();

		for (int i = 0; i < userList.length; i++) {

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

		User newUser2 = new User();
		newUser2.setId(333);
		newUser2.setFirstName("Arul");
		newUser2.setLastName("Abilash");
		newUser2.setEmail("abilash03@gmail.com");
		newUser2.setPassword("Abi03");
		newUser2.setActive(true);

		UserDAO userDao2 = new UserDAO();
		userDao.create(newUser2);

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
	
	public void findById() {

		User findById = new User();
		
		findById.setId(5555);
		findById.setFirstName("Arul");
		findById.setLastName("Ajun");
		findById.setEmail("ajundcruzz55@gmail.com");
		findById.setPassword("Ajunajun55");
		findById.setActive(true);
		
		UserDAO userDao = new UserDAO();
		userDao.update(findById);

	}

}
