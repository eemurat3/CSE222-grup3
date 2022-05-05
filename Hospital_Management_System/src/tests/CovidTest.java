package tests;
import java.io.*;


/**
 * @author S. Burak YASAR
 */

public class CovidTest extends Test{
    
    private boolean testResult;

    /** Constructor
    *@param patientID patient id
    */

    public CovidTest(String patientID){
        super(patientID);
        testResult = false;
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
        
        return   "Patient ID:" + getID() + "\n" + ((testResult == true) ? "Covid Test Result: Positive" :
        "Covid Test Result: Negative");
    }

    public static void main(String[] args) {

        System.out.println("------------ Test of RadiologicalTest ---------------\n");
        
        String patientId1 = "123456";
        String patientId2 = "1474744784784";


        /**Constructor test */

        CovidTest test1 = new CovidTest(patientId1);
        CovidTest test2 = new CovidTest(patientId2);


        /**Setter test */

        test1.setTestResult(true);
        test2.setTestResult(false);

        /**Getter test */

        System.out.println("Get Result: " + test1.getTestResult());
        System.out.println();
        
        System.out.println("Get Result: " + test2.getTestResult());
        System.out.println();
        
        /** stringTo Test */

        System.out.println(test1);
        System.out.println();
        System.out.println(test2);
        
        
    }


}
