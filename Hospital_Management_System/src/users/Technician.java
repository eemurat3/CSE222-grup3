package users;

import departments.Lab;
import systems.HMSystem;
import tests.Test;
import util.*;

/**
 * Technician Class extends Worker Class.
 */
public class Technician extends Worker {


    // A constructor for the Technician class.

    public Technician(String name, String surname, String id, int age, String username, String password) {
        super(name, surname, id, age, username, password);
        setDepartment(new Lab("lab", 0));
    }

    public void addTest(Test newTest) {
        //Add test to Lab department
        Lab lab = (Lab) getDepartment();
        lab.addWaitingTest(newTest); 
    }

    public Test takeTest(){
        Lab lab = (Lab) getDepartment();

        if (lab.getWaitingTests().size() == 0)
            return null;

        //Remove test from waiting tests
        Test t = lab.removeWaitingTest();

        //Add test to old tests
        lab.addOldTest(t);

        //Add test to patient's tests
        TreeIterator<User> it = HMSystem.users.getIterator();

        while(it.hasNext()){
            User current = it.next().getData();

            if (current.getClass() == Patient.class) {
                if(current.getId().equals(t.getPatientID())){
                    ((Patient) current).addTest(t);
                    break;
                }                
            }
        }

        return t;
    }

    /**
     * The function `displayTests()` displays all the tests in the lab
     */
    public void displayOldTests(){
        Lab lab = (Lab) getDepartment();

        System.out.println(lab.getOldTests().inorder());
    }

    /**
     * This function displays the waiting tests of the lab.
     */
    public void displayWaitingTests(){
        Lab lab = (Lab) getDepartment();

        System.out.println(lab.getWaitingTests());
    }

    /**
     * > This function updates a test in the lab's test list
     * 
     * @param test The test to be updated
     * @param newTest The new test that will replace the old one.
     */
    public void updateTest(Test test , Test newTest){
        test.setPatientID(newTest.getPatientID());
        test.setTestID(newTest.getTestID());
        test.setTestType(newTest.getTestType());
    }

    /**
     * > This function updates a test in the lab's test list
     * 
     * @param testID The ID of the test to be updated
     * @param newTest The new test object that will replace the old one.
     */
    public void updateTest(String testID , Test newTest){
        Lab lab = (Lab) getDepartment();
        
        TreeIterator<Test> it = lab.getOldTests().getIterator();

        while(it.hasNext()){
            Test current = it.next().getData();

            if(current.getTestID().equals(testID)){
                updateTest(current, newTest);
                break;
            }
        }


        for (Test iTest : lab.getWaitingTests()) {
            Test current = iTest;

            if (iTest.getTestID().equals(testID)) {
                updateTest(current, newTest);
                break;
            }
        }        
    }

    public Test getTest(String testID) {
        Lab lab = (Lab) getDepartment();

        return lab.getTest(testID);
    }
    
}
