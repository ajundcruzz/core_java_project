package in.arulajun.fitness.dao;

import in.arulajun.fitness.model.Task;

public class TaskDAO {
	
	public Task[] findAll() {
		Task[] taskList = TaskList.listOfTasks;
		return taskList;
	}

	/**
	 * 
	 * @param newUser
	 */

	public void create(Task newTask) {

		Task[] arr = TaskList.listOfTasks;

		for (int i = 0; i < arr.length; i++) {
			Task Task = arr[i];
			if (Task == null) {
				arr[i] = newTask;
				break;
			}
		}
	}

	public void update(Task updatedTask) {
		Task[] array = TaskList.listOfTasks;

		for (int i = 0; i < array.length; i++) {
			Task Task = array[i];
			if (Task == null) {
				continue;
			}
			if (Task.getId() == updatedTask.getId()) {

				Task.setFirstName(updatedTask.getFirstName());
				Task.setLastName(updatedTask.getLastName());
				Task.setDueDate(null);

				break;
			}
		}
	}

	public void delete(int id) {
		Task[] array = TaskList.listOfTasks;
		for (int i = 0; i < array.length; i++) {
			Task Task = array[i];
			if (Task == null) {
				continue;
			}
			if (Task.getId() == id) {
				array[i].setActive(false);
				break;
			}
		}
	}

	// Find by id
	public Task findById(int userId) {
		Task[] arr = TaskList.listOfTasks;
		Task taskMatch = null;
		for (int i = 0; i < arr.length; i++) {
			Task Task = arr[i];
			if (Task == null) {
				continue;
			}
			if (Task.getId() == userId) {
				taskMatch = Task;
				break;
			}
		}
		return taskMatch;
	}

}
