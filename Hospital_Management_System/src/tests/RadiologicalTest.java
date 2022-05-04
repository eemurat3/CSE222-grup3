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
        
        return "Patient ID:" + getID() + "\n" + "Test Type: " + testType + "\nTest Result: " + testResult;
    }

    public static void main(String[] args) {

        System.out.println("------------ Test of RadiologicalTest ---------------\n");
        
        String patientId1 = "123456";

        /**Constructor test */

        RadiologicalTest test1 = new RadiologicalTest(patientId1);

       
        /**Setter test */

        test1.setTestResult("png");
        test1.setTestType("Head MR");


        /**Getter test */

        System.out.println("Get Test Result: " + test1.getTestResult());      
        System.out.println("Get Test Type: " + test1.getTestType());

        System.out.println();

        /** stringTo Test */
        System.out.println(test1);
        
    }


}
