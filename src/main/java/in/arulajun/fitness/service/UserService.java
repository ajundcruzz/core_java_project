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

}
