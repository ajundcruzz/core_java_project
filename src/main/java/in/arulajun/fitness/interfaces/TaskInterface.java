package in.arulajun.fitness.interfaces;

import java.util.Set;

import in.arulajun.fitness.model.Task;

public interface TaskInterface extends Base<Task>{
	public abstract	Set<Task> findAll();
	public abstract Task findById(int id);
}