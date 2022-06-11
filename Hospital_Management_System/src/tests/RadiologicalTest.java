package tests;

/**
 * @author S. Burak YASAR
 */

/**
 * The RadiologicalTest class is a subclass of the Test class. 
 */
public class RadiologicalTest extends Test{
    

    private String testResult;

    /*MR,PET,BT,X-RAY etc. and body parts Example test type: Head MR*/
    private String radiologicalTestType;

    /** Constructor
    *@param patientID patient id
    */
    public RadiologicalTest(String patientID,String testID){
        super(patientID,testID,2);
    }
    
    // A constructor.
    public RadiologicalTest(String patientID,String testID,String testResult, String radiologicalTestType){
        super(patientID,testID,2);
        this.testResult = testResult;
        this.radiologicalTestType = radiologicalTestType;
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
    public void setTestType(String radiologicalTestType){
        this.radiologicalTestType = radiologicalTestType;
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

    public String getRadiologicalTestType(){
        return radiologicalTestType;
    }


    /** Returns String representation of test result
    *@return returns test result
    */
    public String toString(){
        
        return "\nPatient ID:" + getPatientID() + " Test Type: " + radiologicalTestType + "\tTest Result: " + testResult;
    }

    /**
     * The main function is used to test the RadiologicalTest class
     */
    public static void main(String[] args) {
        System.out.print("\n\n\t\t\t RADIOLOGICAL  TEST UNIT TESTING STARTS \n\n");

        System.out.println("------------ Test of RadiologicalTest ---------------\n");
        
        String patientId1 = "123456";
        String patientId2 = "573497538464";

        /**Constructor test */

        RadiologicalTest test1 = new RadiologicalTest(patientId1,"234234");
        RadiologicalTest test2 = new RadiologicalTest(patientId2,"657657");
       
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
        System.out.print("\n\n\t\t\t RADIOLOGICAL  TEST UNIT TESTING ENDS \n\n");

    }


}
