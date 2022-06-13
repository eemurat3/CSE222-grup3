package tests;

/**
 * @author H. Tuğçe Yavuz
 */
/**
 * The Test class is an abstract class that implements the Comparable interface and will be used for Lab test patients need.
 */
public abstract class Test implements Comparable <Test> {
	private String testID;
	private String patientID;
	private int testType;
	private static Integer idcount = 0;

	//0 Blood Test
	//1 Covid Test
	//2 Radiological Test

	/**
  	*  Constructor For Test Class
  	*  @param patientID number 
  	*/
  	public Test(String patientID,String testID,int testType){
		this.patientID = patientID;
		this.testID = idcount.toString();
		this.testType = testType;
		idcount++;
	}

	
  	/**
	   * > This function returns the test type
	   * 
	   * @return The testType variable is being returned.
	   */
	  public int getTestType() {
		return testType;
	}

	/**
	 * This function sets the testType variable to the value of the testType parameter.
	 * 
	 * @param testType The type of test to run.  This is a bitmask of the following values:
	 */
	public void setTestType(int testType) {
		this.testType = testType;
	}

	public String getTestID() {
		return testID;
	}

	public void setTestID(String testID) {
		this.testID = testID;
	}

	/**
  	* getter method for patient ID number
  	* @return patient ID number
  	*/
  	public String getPatientID(){return patientID;}
  
  	/**
  	* setter method for patient ID number
  	* @param patient ID number
  	*/
  	public void setPatientID(String newID){patientID = newID;}
  
	
	/**
	 * The compareTo() function compares the ID of the current object to the ID of the object passed in as
	 * a parameter
	 * 
	 * @param other The other object to compare to.
	 * @return The ID of the test.
	 */
	public int compareTo(Test other){
		return getTestID().compareTo(other.getTestID());
	}
}
