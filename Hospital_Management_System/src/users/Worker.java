package users;

/**
 *
 * @author Muhammed Akif Sevilgen
 */
public class Worker extends User
{
    private String username;
    private String password;

    public Worker(String name, String surname, String id, int age,String username , String password) {
        super(name, surname, id, age);
        setUsername(username);
        setPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int compareTo(User other) {
    	return super.compareTo(other);
    }

    @Override
    public String toString() {
        return super.toString() + ", Username: " + username;
    }
}
