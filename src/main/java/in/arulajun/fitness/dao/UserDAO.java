package in.arulajun.fitness.dao;

import java.util.Set;

import in.arulajun.fitness.interfaces.UserInterface;
import in.arulajun.fitness.model.User;

public class UserDAO implements UserInterface {
	@Override
	public Set<User> findAll() {
		Set<User> userList = UserList.listOfUsers;
		return userList;
	}

	@Override
	public User findById(int userId) {
		Set<User> userList = UserList.listOfUsers;
		User userMatch = null;

		for (User user : userList) {
			if (user.getId() == userId) {
				userMatch = user;
				break;
			}
		}
		return userMatch;
	}

	@Override
	public void update(User updatedUser) {
		Set<User> userList = UserList.listOfUsers;
		for (User user : userList) {
			if (user.getId() == updatedUser.getId()) {
				user.setFirstName(updatedUser.getFirstName());
				user.setLastName(updatedUser.getLastName());
				user.setPassword(updatedUser.getPassword());

				break;
			}
		}

	}

	@Override
	public void delete(int userId) {
		Set<User> userList = UserList.listOfUsers;
		for (User user : userList) {
			if (user == null) {
				continue;
			}
			if (user.getId() == userId) {
				user.setActive(false);
				break;
			}
		}
	}

	@Override
	public void create(User newUser) {
		// TODO Auto-generated method stub
		Set<User> arr = UserList.listOfUsers;
		arr.add(newUser);
	}

}