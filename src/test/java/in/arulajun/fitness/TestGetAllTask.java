package in.arulajun.fitness;

import java.util.Set;

import org.junit.jupiter.api.Test;

import in.arulajun.fitness.model.Task;
import in.arulajun.fitness.model.User;
import in.arulajun.fitness.service.TaskService;
import in.arulajun.fitness.service.UserService;

public class TestGetAllTask {
	@Test
	public void getAllTask() {
		TaskService taskService = new TaskService();
		Set<Task> arr = taskService.getAll();
		System.out.println(arr);
	}
	@Test

	public void getFindById() {
		TaskService taskService = new TaskService();
		Task arr = taskService.findById(1);
		System.out.println(arr);
	}
	@Test
	public void testDelete() {
		TaskService taskService = new TaskService();
		Task newTask = new Task();
		
		taskService.delete(2);
	}
   @Test

	public void testUpdateTask() throws Exception {
		TaskService taskService = new TaskService();
		Task newTask = new Task();
		newTask.setName("Completed Task");
		newTask.setDueDate("2023-10-29");
		taskService.update(3, newTask);
	}
}
