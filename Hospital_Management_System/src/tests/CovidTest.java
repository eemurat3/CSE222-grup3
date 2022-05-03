package tests;


/**
 * @author S. Burak YASAR
 */

public class CovidTest extends Test{
    
    private boolean testResult;

    /** Constructor
    *@param patientID patient id
    */

    public CovidTest(int patientID){
        super(patientID);
        testResult = true;
    }

    /** Set Result
    *@param result test result
    */

    public void setTestResult(boolean result){
        testResult = result;
    }

    /** Get Result
    *@return returns test result
    */

    public boolean getTestResult(){
        return testResult;
    }

    /** Returns String representation of test result
    *@return returns test result
    */

    public String toString(){
        
        return   (testResult == true) ? "Covid Test Result: Positive" :
        "Covid Test Result: Negative";
    }


}
