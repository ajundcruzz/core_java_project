package in.arulajun.fitness.service;

import java.time.format.DateTimeParseException;

import in.arulajun.fitness.dao.TaskDAO;
import in.arulajun.fitness.exception.ValidationException;
import in.arulajun.fitness.model.Task;
import in.arulajun.validation.TaskValidator;

public class TaskService {
	
	public Task[] getAll() {

		TaskDAO taskDao = new TaskDAO();

		Task[] taskList = taskDao.findAll();

		for (int i = 0; i < taskList.length; i++) {

			System.out.println(taskList[i]);
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

	public void update() {

		Task updatedTask = new Task();
		
		updatedTask.setId(5555);
		updatedTask.setName("Move front");
		updatedTask.setDueDate("2023-12-12");
		updatedTask.setActive(true);
		
		TaskDAO taskDao = new TaskDAO();
		taskDao.update(updatedTask);

	}
	
	public void delete() {

		Task deleteTask = new Task();
		
		deleteTask.setId(5555);
		deleteTask.setName("Move front");
		deleteTask.setDueDate("2023-12-12");
		deleteTask.setActive(true);
		
		TaskDAO taskDao = new TaskDAO();
		taskDao.update(deleteTask);

	}
	
	public void findById() {

		Task findById = new Task();
		
		findById.setId(5555);
		findById.setName("Move front");
		findById.setDueDate("2023-12-12");
		findById.setActive(true);
		
		TaskDAO taskDao = new TaskDAO();
		taskDao.update(findById);

	}


}
