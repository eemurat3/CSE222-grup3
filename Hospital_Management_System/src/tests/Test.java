package tests;

/**
 * @author H. Tuğçe Yavuz
 */
public abstract class Test implements Comparable <Test> {
 	
	private String patientID;
	
  	/**
  	* getter method for patient ID number
  	* @return patient ID number
  	*/
  	public String getID(){return patientID;}
  
  	/**
  	* setter method for patient ID number
  	* @param patient ID number
  	*/
  	public void setID(String newID){patientID = newID;}
  
  	/**
  	*  Constructor For Test Class
  	*  @param patientID number 
  	*/
  	public Test(String ID){patientID = ID;}
	
	/**
	 * The compareTo() function compares the ID of the current object to the ID of the object passed in as
	 * a parameter
	 * 
	 * @param other The other object to compare to.
	 * @return The ID of the test.
	 */
	public int compareTo(Test other){
		return getID().compareTo(other.getID());
	}
}
