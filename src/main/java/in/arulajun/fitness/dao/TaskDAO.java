package in.arulajun.fitness.dao;

import java.util.Set;

import in.arulajun.fitness.interfaces.TaskInterface;
import in.arulajun.fitness.model.Task;

public class TaskDAO implements TaskInterface{

	@Override
	public void create(Task newTask) {
		Set<Task> taskList = TaskList.listOfTasks;
		taskList.add(newTask);
		
	}

	@Override
	public Task findById(int id) {
		Set<Task> taskList = TaskList.listOfTasks;
		Task taskMatch = null;

		for (Task task : taskList) {
			if (task.getId() == id) {
				taskMatch = task;
				break;
			}
		}
		return taskMatch;
	}

	@Override
	public void update(Task updatedTask) {
		Set<Task> taskList = TaskList.listOfTasks;
		for (Task task : taskList) {
			if (task.getId() == updatedTask.getId()) {
				task.setName(updatedTask.getName());
				task.setDueDate(updatedTask.getDueDate());
				break;
			}
		}
	}

	@Override
	public Set<Task> findAll() {
		Set<Task> userTask = TaskList.listOfTasks;
		return userTask;
	}

	@Override
	public void delete(int TaskId) {
		Set<Task> taskList = TaskList.listOfTasks;
		for (Task task : taskList) {
			if (task == null) {
				continue;
			}
			if (task.getId() == TaskId) {
				task.setActive(false);
				break;
			}
		}
	}
}
