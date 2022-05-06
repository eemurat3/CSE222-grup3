package tests;
import java.io.*;

/**
 * @author S. Burak YASAR
 */

public class RadiologicalTest extends Test{
    

    private String testResult;

    /*MR,PET,BT,X-RAY etc. and body parts Example test type: Head MR*/
    private String testType;

    /** Constructor
    *@param patientID patient id
    */

    public RadiologicalTest(String patientID){
        super(patientID);
    }
    
    public RadiologicalTest(String patientID, String testResult, String testType){
        super(patientID);
        this.testResult = testResult;
        this.testType = testType;
    }      


    /** Set Result
    *@param result test result
    */

    public void setTestResult(String result){
        testResult = result;
    }


    /** Set Result
    *@param result test type
    */

    public void setTestType(String type){
        testType = type;
    }



    /** Get Result
    *@return returns test result
    */

    public String getTestResult(){
        return testResult;
    }


    /** Get Result
    *@return returns test type
    */

    public String getTestType(){
        return testType;
    }


    /** Returns String representation of test result
    *@return returns test result
    */

    public String toString(){
        
        return "\nPatient ID:" + getID() + " Test Type: " + testType + "\tTest Result: " + testResult;
    }

    public static void main(String[] args) {

        System.out.println("------------ Test of RadiologicalTest ---------------\n");
        
        String patientId1 = "123456";
        String patientId2 = "573497538464";

        /**Constructor test */

        RadiologicalTest test1 = new RadiologicalTest(patientId1);
        RadiologicalTest test2 = new RadiologicalTest(patientId2);
       
        /**Setter test */

        test1.setTestResult("png");
        test1.setTestType("Head MR");
        
        
        test2.setTestResult("png");
        test2.setTestType("PET Scan");


        /**Getter test */

        System.out.println("Get Test Result: " + test1.getTestResult());      
        System.out.println("Get Test Type: " + test1.getTestType());
        
        System.out.println();
        
        System.out.println("Get Test Result: " + test2.getTestResult());
        System.out.println("Get Test Type: " + test2.getTestType());

        System.out.println();

        
        /** stringTo Test */
        
        System.out.println(test1);
        
        System.out.println();
        
        System.out.println(test2);
    }


}
