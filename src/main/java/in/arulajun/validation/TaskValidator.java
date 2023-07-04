package in.arulajun.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import in.arulajun.fitness.exception.ValidationException;
import in.arulajun.fitness.model.Task;
import util.StringUtil;

public class TaskValidator {
	
	public static void validate(Task task) throws ValidationException {
		if (task == null) {
			throw new ValidationException("Invalid task");
		}
        StringUtil.rejectIfInvalidString(task.getName(), "Name");
        StringUtil.rejectIfInvalidString(task.getDueDate(), "DueDate");
        
        String date = task.getDueDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dueDate = LocalDate.parse(date, formatter);
        
        LocalDate currentDate = LocalDate.now();
        if (dueDate.equals(currentDate) || dueDate.isBefore(currentDate)) {
            throw new ValidationException("Due date should be in the future");
        }
	}

}
