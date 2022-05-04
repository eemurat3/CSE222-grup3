package tests;
import java.util.*;
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
	
	public int compareTo(Test other){
		return getID().compareTo(other.getID());
	}
}
