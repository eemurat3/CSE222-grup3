package users;

import departments.Department;

/**
 *
 * @author Muhammed Akif Sevilgen
 * Worker class extends user class and is a parent class to all staff that works in the hospital.
 */
public class Worker extends User
{
    private String username;
    private String password;
    private Department department;
    private static Integer idCount = 0;
    

    // A constructor.
    public Worker(String name, String surname, String id, int age,String username , String password) {
        super(name, surname, idCount.toString(), age);
        setUsername(username);
        setPassword(password);
        idCount++;
    }

    /**
     * > This function returns the department of the employee
     * 
     * @return The department object.
     */
    public Department getDepartment() {
        return department;
    }
    
    public void setAll(String name, String surname, String id, int age,String username , String password) {
        setName(name);
        setSurname(surname);
        setId(id);
        setAge(age);
        setUsername(username);
        setPassword(password);
    }    

    /**
     * This function sets the department of the employee.
     * 
     * @param department The department that the employee belongs to.
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * This function returns the username of the user
     * 
     * @return The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * This function sets the username of the user
     * 
     * @param username The username of the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This function returns the password of the user
     * 
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * This function sets the password of the user
     * 
     * @param password The password to use for the connection.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * If the current user is less than the other user, return -1, if the current user is greater than
     * the other user, return 1, otherwise return 0.
     * 
     * @param other The other user to compare to.
     * @return The super class's compareTo method is being returned.
     */
    @Override
    public int compareTo(User other) {
    	return super.compareTo(other);
    }

    /**
     * The toString() method returns a string representation of the object
     * 
     * @return The super.toString() method is being returned.
     */
    @Override
    public String toString() {
        return super.toString() + ", Username: " + username;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Worker other = (Worker) obj;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }
}
