package in.arulajun.fitness.interfaces;

import java.util.Set;

import in.arulajun.fitness.model.Task;
import in.arulajun.fitness.model.User;

public interface Base<T> {
	public abstract <T> T  findAll();
	public abstract void create(T object);
	public abstract void update(int id, T object);
	public abstract void delete(int id);
	public abstract <T> T findById(int id);
}