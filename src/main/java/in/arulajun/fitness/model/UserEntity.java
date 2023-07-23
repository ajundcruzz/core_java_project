package in.arulajun.fitness.model;

public abstract class UserEntity implements Comparable<UserEntity> {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int id;
    private boolean isActive = true;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String fullName () {
		return firstName.concat(" ").concat(lastName);
	}
    
    @Override
    public int compareTo(UserEntity other) {
		return Integer.compare(this.id, other.getId());
    }

    @Override
    public String toString() {
        return "UserEntity [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
                + password + ", id=" + id + ", isActive=" + isActive + "]";
    }

}