package in.arulajun.fitness.service;

import java.time.format.DateTimeParseException;
import java.util.Set;

import in.arulajun.fitness.dao.TaskDAO;
import in.arulajun.fitness.exception.ValidationException;
import in.arulajun.fitness.model.Task;
import in.arulajun.fitness.validation.TaskValidator;

public class TaskService {
	public Set<Task> getAll() {
		TaskDAO taskDao = new TaskDAO();
		Set<Task> taskList = taskDao.findAll();
		for (Task task : taskList) {
			System.out.println(task);
		}
		return taskList;
	}
	public void create(Task newTask) throws Exception {
		try {
			TaskValidator.validate(newTask);
		} catch (DateTimeParseException e) {
			throw new ValidationException("Invalid date format or Invalid Date");
		}
		TaskValidator.validate(newTask);
		TaskDAO taskDao = new TaskDAO();
		taskDao.create(newTask);
	}
	public void update(int id, Task updateTask) throws Exception {
		TaskValidator.validate(updateTask);
		TaskDAO taskDao = new TaskDAO();
		taskDao.update(id, updateTask);
	}
	
	
	public void delete(int taskId) {
		TaskDAO taskDao = new TaskDAO();
		taskDao.delete(taskId);
	}
	public Task findById(int taskId) {
		TaskDAO taskDao = new TaskDAO();
		Task task = taskDao.findById(taskId);
		return task;
	}
}
