package users;

/**
 *
 * @author Muhammed Akif Sevilgen
 */
public class Worker extends User
{
    private String username;
    private String password;

    // A constructor.
    public Worker(String name, String surname, String id, int age,String username , String password) {
        super(name, surname, id, age);
        setUsername(username);
        setPassword(password);
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
}
