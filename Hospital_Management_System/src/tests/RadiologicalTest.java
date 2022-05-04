package tests;

/**
 * @author S. Burak YASAR
 */

public class RadiologicalTest extends Test{
    

    private String testResult;

    /*MR,PET,BT,X-RAY etc. and body parts Example test type: head MR*/
    private String testType;

    /** Constructor
    *@param patientID patient id
    */

    public RadiologicalTest(String patientID){
        super(patientID);
    }

    /** Default Constructor*/

    public RadiologicalTest(){super(0);}

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
        
        return "Test Type: " + testType + "\nTest Result: " + testResult;
    }


}
