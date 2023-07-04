package in.arulajun.validation;

import in.arulajun.fitness.exception.ValidationException;
import in.arulajun.fitness.model.Task;
import util.StringUtil;

public class TaskValidator {
	
	public static void validate(Task task) throws ValidationException {
		if (task == null) {
			throw new ValidationException("Invalid task");
		}

		StringUtil.rejectIfInvalidString(task.getName(), "Name");
	}

}
