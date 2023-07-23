package in.arulajun.fitness.model;

public class TaskEntity implements Comparable<TaskEntity> {

	String name;
	String dueDate;
	boolean isActive = true;
	int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Task [name=" + name + ", dueDate=" + dueDate + ", isActive=" + isActive + ", id=" + id + "]";
	}

	@Override
	public int compareTo(TaskEntity o) {
		return Integer.compare(this.id, o.getId());
	}

}