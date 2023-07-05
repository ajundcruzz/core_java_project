package in.arulajun.fitness;

import in.arulajun.fitness.model.Task;
import in.arulajun.fitness.model.User;
import in.arulajun.fitness.service.TaskService;
import in.arulajun.fitness.service.UserService;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			UserService userService = new UserService();

			User newUser = new User();
			newUser.setId(5555);
			newUser.setFirstName("Arul");
			newUser.setLastName("Ajun");
			newUser.setEmail("ajundcruzz55@gmail.com");
			newUser.setPassword("Ajunajun55");
			newUser.setActive(true);

			userService.create(newUser);
			userService.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			TaskService taskService = new TaskService();

			Task newTask = new Task();
			newTask.setId(5555);
			newTask.setName("Move front");
			newTask.setActive(true);

			taskService.create(newTask);
			taskService.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
