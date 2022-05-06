package users;

import tests.BloodTest;
import tests.CovidTest;
import tests.RadiologicalTest;
import tests.Test;

public class Technician extends Worker {


    // A constructor for the Technician class.
    public Technician(String name, String surname, String id, int age, String username, String password) {
        super(name, surname, id, age, username, password);
    }

    /**
     * This function takes a new CovidTest object and a BinarySearchTree of CovidTest objects and adds
     * the new CovidTest object to the BinarySearchTree of CovidTest objects
     * 
     * @param newTest a CovidTest object
     * @param covidTests BinarySearchTree of type Test
     */
    public void takeCovidTest(CovidTest newTest, BinarySearchTree<Test> covidTests) {

        covidTests.add(newTest);
    }

    /**
     * This function takes a RadiologicalTest object and a BinarySearchTree object as parameters and
     * adds the RadiologicalTest object to the BinarySearchTree object
     * 
     * @param newTest The new test that is being added to the tree.
     * @param radiologicalTests a BinarySearchTree of type Test
     */
    public void takeRadiologicalTest(RadiologicalTest newTest, BinarySearchTree<Test> radiologicalTests) {

        radiologicalTests.add(newTest);
    }

    /**
     * This function takes a blood test and a binary search tree of blood tests as parameters and adds
     * the blood test to the binary search tree
     * 
     * @param newTest The new blood test that is being added to the tree.
     * @param bloodTests BinarySearchTree<Test>
     */
    public void takeBloodTest(BloodTest newTest, BinarySearchTree<Test> bloodTests) {

        bloodTests.add(newTest);
    }

    /**
     * This function displays the inorder traversal of the binary search tree
     * 
     * @param covidTests BinarySearchTree<Test>
     */
    public void displayCovidTests(BinarySearchTree<Test> covidTests) {

        System.out.println(covidTests.inorder());
    }

    /**
     * This function displays the radiological tests in the order of the test name
     * 
     * @param radiologicalTests BinarySearchTree<Test>
     */
    public void displayRadiologicalTests(BinarySearchTree<Test> radiologicalTests) {
        
        System.out.println(radiologicalTests.inorder());
    }

    /**
     * This function displays the blood tests in order
     * 
     * @param bloodTests BinarySearchTree<Test>
     */
    public void displayBloodTests(BinarySearchTree<Test> bloodTests) {

        System.out.println(bloodTests.inorder());
    }

    /**
     * This function takes in a CovidTest object and a BinarySearchTree of CovidTest objects. It then
     * deletes the CovidTest object from the BinarySearchTree and adds a new CovidTest object with the
     * same ID and test result
     * 
     * @param updateTest The test that is being updated
     * @param covidTests BinarySearchTree of type Test
     */
    public void updateCovidTest(CovidTest updateTest, BinarySearchTree<Test> covidTests) {
        

        if (covidTests.deleteS(updateTest) != null) {
            covidTests.add(new CovidTest(updateTest.getID(), updateTest.getTestResult()));
        }

    }

    /**
     * This function takes in a RadiologicalTest object and a BinarySearchTree object as parameters. It
     * then deletes the RadiologicalTest object from the BinarySearchTree object and adds the
     * RadiologicalTest object back into the BinarySearchTree object
     * 
     * @param updateTest The test that is being updated
     * @param radiologicalTests BinarySearchTree of type Test
     */
    public void updateRadiologicalTest(RadiologicalTest updateTest, BinarySearchTree<Test> radiologicalTests) {

        if (radiologicalTests.deleteS(updateTest) != null) {
            radiologicalTests.add(new RadiologicalTest(updateTest.getID(), updateTest.getTestResult(), updateTest.getTestType()));
        }
                     
    }

    /**
     * If the blood test is found, delete it and add a new one with the same ID
     * 
     * @param updateTest The test that is being updated
     * @param bloodTests BinarySearchTree of type Test
     */
    public void updateBloodTest(BloodTest updateTest, BinarySearchTree<Test> bloodTests) {

        if (bloodTests.deleteS(updateTest) != null) {
            bloodTests.add(new BloodTest(updateTest.getID()));
        }
    }
    
}
