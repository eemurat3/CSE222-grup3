package tests;
/**
 * @author H. Tuğçe Yavuz
 */
public class Test {
  private int patientID;
  
  /**
  * getter method for patient ID number
  * @return patient ID number
  */
  public int getID(){return patientID;}
  
  /**
  * setter method for patient ID number
  * @param patient ID number
  */
  public void setID(int newID){patientID = newID;}
  
  /**
  *  Constructor For Test Class
  *  @param patientID number 
  */
  public Test(int ID){patientID = ID;}

}
