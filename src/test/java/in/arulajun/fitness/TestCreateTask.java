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
	public void testCreateTaskWithValidData() {

		TaskService taskService = new TaskService();
		Task newTask = new Task();
		newTask.setId(5555);
		newTask.setName("Move front");
		newTask.setDueDate("2023-12-12");
		newTask.setActive(true);
		assertDoesNotThrow(() -> {
			taskService.create(newTask);
		});
	}
	
	@Test
	public void testCreateTaskWithInvalidData() {

		TaskService taskService = new TaskService();
		
		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.create(null);
		});
		String exceptedMessage = "Invalid task";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}
	
	@Test
	public void testTaskNameEmpty() {

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
	public void testTaskNameNull() {

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
	
	  @Test
			public void testCreateTaskWithDueDateNull() {
			 TaskService taskService = new TaskService();
			    Task newTask = new Task();
		 		newTask.setId(5555);
		 		newTask.setDueDate(null);
		 		newTask.setName("Practice");
		 		newTask.setActive(true);
				
				Exception exception = assertThrows(Exception.class,()->{
					taskService.create(newTask);
				});
				String expectedMessage = "DueDate cannot be null or empty";
				String actualMessage = exception.getMessage();
				
				assertTrue(expectedMessage.equals(actualMessage));
			}	
		    @Test
			public void testCreateUserWithDueDateEmpty() {
		    	TaskService taskService = new TaskService();
		    	Task newTask = new Task();
		 		newTask.setId(5555);
		 		newTask.setDueDate("");
		 		newTask.setName("Practice");
		 		newTask.setActive(true);
				
				Exception exception = assertThrows(Exception.class,()->{
					taskService.create(newTask);
				});
				String expectedMessage = "DueDate cannot be null or empty";
				String actualMessage = exception.getMessage();
				
				assertTrue(expectedMessage.equals(actualMessage));
			}
		    @Test
			public void testCreateUserWithDueDatePassedDate() {
		    	TaskService taskService = new TaskService();
		    	Task newTask = new Task();	
		 		newTask.setId(5555);
		 		newTask.setDueDate("2023-06-26");
		 		newTask.setName("Practice");
		 		newTask.setActive(true);
				
				Exception exception = assertThrows(Exception.class,()->{
					taskService.create(newTask);
				});
				String expectedMessage = "Due date should be in the future";
				String actualMessage = exception.getMessage();
				
				assertTrue(expectedMessage.equals(actualMessage));
			}
		    
		    @Test
			public void testCreateTaskWithDueDateParseDate() {
		    	TaskService taskService = new TaskService();
		    	Task newTask = new Task();
		 		newTask.setId(1);
		 		newTask.setDueDate("26-07-2023");
		 		newTask.setName("Practice");
		 		newTask.setActive(true);
				
				Exception exception = assertThrows(Exception.class,()->{
					taskService.create(newTask);
				});
				String expectedMessage = "Invalid date format or Invalid Date";
				String actualMessage = exception.getMessage();
				
				assertTrue(expectedMessage.equals(actualMessage));
		    }
		    @Test
			public void testCreateTaskWithDueDateInvalidDate() {
		    	TaskService taskService = new TaskService();
		    	Task newTask = new Task();
		 		newTask.setId(1);
		 		newTask.setDueDate("2023-02-31");
		 		newTask.setName("Practice");
		 		newTask.setActive(true);
				
				Exception exception = assertThrows(Exception.class,()->{
					taskService.create(newTask);
				});
				String expectedMessage = "Invalid date format or Invalid Date";
				String actualMessage = exception.getMessage();
				
				assertTrue(expectedMessage.equals(actualMessage));
			}
		    
}
