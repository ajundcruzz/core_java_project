package in.arulajun.fitness.interfaces;

import java.util.Set;

import in.arulajun.fitness.model.User;

public interface UserInterface extends Base<User>{
	
	public abstract	Set<User> findAll();
	public abstract User findById(int id);
}