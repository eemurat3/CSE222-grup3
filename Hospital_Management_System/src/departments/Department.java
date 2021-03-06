package departments;
/**
 * implementing hospital department class
 * @author Murat Kaymaz
 */


public abstract class Department {
	/**
	 * Department name
	 */
	private String name;
	/**
	 * Department id
	 */
	private int id;

	private int departmentType;

	private static Integer idCount = 0;

	//Manager menüsünde eklerken ayarlayabiliriz
	/**
	 * Constructor
	 * @param name : department name
	 * @param id   : department id
	 */
	public Department(String _name, int _id,int departmentType) {
		id = idCount;
		name = _name;
		this.departmentType = departmentType;
		idCount++;
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
	 * > This function returns the department type of the department
	 * 
	 * @return The departmentType variable is being returned.
	 */
	public int getDepartmentType() {
		return departmentType;
	}

	/**
	 * > This function sets the department type of the department
	 * 
	 * @param departmentType The type of department. This is an integer value.
	 */
	public void setDepartmentType(int departmentType) {
		this.departmentType = departmentType;
	}

	/**
	 * The toString() method returns the string representation of the object
	 * 
	 * @return The name and id of the department.
	 */
	@Override
    public String toString() {
        return "Departments{ name : "+name + "  id : " + id + '}';
    }
	
}
