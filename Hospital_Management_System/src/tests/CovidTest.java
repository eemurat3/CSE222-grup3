package tests;


/**
 * @author S. Burak YASAR
 */

/**
 * CovidTest is a subclass of Test that shows covid test result.
 */
public class CovidTest extends Test{
    
    private boolean testResult;

    /** Constructor
    *@param patientID patient id
    */
    public CovidTest(String patientID,String testID){
        super(patientID,testID,1);
        testResult = false;
    }
    
    // A constructor.
    public CovidTest(String patientID, String testID,boolean testResult){
        super(patientID,testID,1);
        this.testResult = testResult;
    }     

    /**
     * This function sets the testResult variable to the value of the parameter result
     * 
     * @param result The result of the test.
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
        
        return   "\nPatient ID:" + getPatientID() + ((testResult == true) ? " Covid Test Result: Positive" :
        " Covid Test Result: Negative");
    }

    /**
     * This function is used to test the CovidTest class
     */
    public static void main(String[] args) {

        System.out.print("\n\n\t\t\t COVID TEST UNIT TESTING STARTS \n\n");

        System.out.println("------------ Test of RadiologicalTest ---------------\n");
        
        String patientId1 = "123456";
        String patientId2 = "1474744784784";


        /**Constructor test */

        CovidTest test1 = new CovidTest(patientId1,"32432");
        CovidTest test2 = new CovidTest(patientId2,"234324");


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
        
        System.out.print("\n\n\t\t\t COVID TEST UNIT TESTING ENDS \n\n");
        
    }


}
