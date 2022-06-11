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
    }

    public void addTest(Test newTest) {
        //Add test to Lab department
        Lab lab = (Lab) getDepartment();
        lab.addWaitingTest(newTest); 
    }

    public void takeTest(){
        Lab lab = (Lab) getDepartment();

        //Remove test from waiting tests
        Test t = lab.removeWaitingTest();

        //Add test to old tests
        lab.addOldTest(t);

        //Add test to patient's tests
        TreeIterator<User> it = HMSystem.users.getIterator();

        while(it.hasNext()){
            User current = it.next().getData();

            if(current.getId().equals(t.getPatientID())){
                ((Patient) current).addTest(t);
                break;
            }
        }
    }

    /**
     * The function `displayTests()` displays all the tests in the lab
     */
    public void displayAllTests(){
        Lab lab = (Lab) getDepartment();

        System.out.println(lab.getAllTests().inorder());
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
        
        TreeIterator<Test> it = lab.getAllTests().getIterator();

        while(it.hasNext()){
            Test current = it.next().getData();

            if(current.getTestID().equals(testID)){
                updateTest(current, newTest);
                break;
            }
        }
    }
    
}
