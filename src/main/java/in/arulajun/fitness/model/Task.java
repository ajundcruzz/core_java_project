package in.arulajun.fitness.model;

public class Task {
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
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

	@Override
	public String toString() {
		return "Task [id=" + id + ", Name=" + Name + ", dueDate=" + dueDate
				+ ", isActive=" + isActive + "]";
	}

	int id;
	String Name;
	String dueDate;
	boolean isActive = true;
	

}
