package in.arulajun.fitness;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.arulajun.fitness.exception.ValidationException;
import in.arulajun.fitness.model.Task;
import in.arulajun.fitness.service.TaskService;

public class TestCreateTask {

	@Test
	public void testCreateUserWithValidData() {

		TaskService taskService = new TaskService();
		Task newTask = new Task();
		newTask.setId(5555);
		newTask.setName("Move front");
		newTask.setDueDate("2023/12/12");
		newTask.setActive(true);
		assertDoesNotThrow(() -> {
			taskService.create(newTask);
		});
	}
	
	@Test
	public void testCreateUserWithInvalidData() {

		TaskService taskService = new TaskService();
		
		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.create(null);
		});
		String exceptedMessage = "Invalid task";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}
	
	@Test
	public void testUserNameEmpty() {

		TaskService taskService = new TaskService();
		
		Task newTask = new Task();
		
		newTask.setId(5555);
		newTask.setName("");
		newTask.setDueDate("2023/12/12");
		newTask.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.create(newTask);
		});

		String exceptedMessage = "Name cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}
	
	@Test
	public void testUserNameNull() {

		TaskService taskService = new TaskService();
		
		Task newTask = new Task();
		
		newTask.setId(5555);
		newTask.setName(null);
		newTask.setDueDate("2023/12/12");
		newTask.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.create(newTask);
		});

		String exceptedMessage = "Name cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}

}
