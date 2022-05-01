package departments;
/**
 * 
 * @author Murat Kaymaz
 *
 */
import java.util.ArrayList;
import users.Worker;
public abstract class Department {
	/**
	 * Department name
	 */
	private String name;
	/**
	 * Department id
	 */
	private int id;
	/**
	 * Department worker list
	 */
	private private ArrayList<Worker> workers;
	
	/**
	 * Default constructor
	 */
	Department() {
		id = -1;
		name = "none";
		workers = new ArrayList<>();
	}
	/**
	 * Constructor
	 * @param name : department name
	 * @param id   : department id
	 */
	Department(String _name, int _id) {
		id = _id;
		name = _name;
	}
	/**
	 * Set the department id
	 * @param _id : department id value
	 */
	public void setId(int _id) {
		id = _id;
	} 
	/**
	 * Get the Department id
	 * @return : department id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Set the department name
	 * @param _name : department name
	 */
	public void setName(String _name) {
		name = _name;
	}
	/**
	 * Get the department name
	 * @return : department name value
	 */
	public String getName() {
		return name;
	}
	/**
	 * set the department worker list
	 */
	public void setWorkers(ArrayList<Worker> _workers) {
		workers = _workers;
	}
	/**
	 * Get the department worker list
	 * @return : department worker list
	 */
	public  ArrayList<Worker> getWorkers() {
		return workers;
	}
	
	@Override
    public String toString() {
        return "Departments{ name : "+name + "id : " + id + '}';
    }
	
}
