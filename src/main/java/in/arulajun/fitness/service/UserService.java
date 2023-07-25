package in.arulajun.fitness.service;

import java.util.Set;

import in.arulajun.fitness.dao.UserDAO;
import in.arulajun.fitness.model.User;
import in.arulajun.fitness.validation.UserValidator;

public class UserService {
	public Set<User> getAll() {
		UserDAO userDao = new UserDAO();
		Set<User> userList = userDao.findAll();
		for (User user : userList) {
			System.out.println(user);
		}
		return userList;
	}
	public User findById(int userId) {
		UserDAO userDao = new UserDAO();
		return userDao.findById(userId);	
	}
	
	public void create(User newUser) throws Exception {
		UserValidator.validate(newUser);
		UserDAO userDao = new UserDAO();
		userDao.create(newUser);
	}
	
	public void update(int id, User updatedUser) {
		UserDAO userDao = new UserDAO();
		userDao.update(id, updatedUser);	
	}
	
	public void delete(int userId) {
		UserDAO userDao = new UserDAO();
		userDao.delete(userId);
	}
}
