package users;

import tests.*;

public class Technician extends Worker {

    BinarySearchTree<Test> covidTests = new BinarySearchTree<Test>();
    BinarySearchTree<Test> radiologicalTests = new BinarySearchTree<Test>();
    BinarySearchTree<Test> bloodTests = new BinarySearchTree<Test>();

    public Technician(String name, String surname, String id, int age, String username, String password) {
        super(name, surname, id, age, username, password);
    }

    public void takeCovidTest(CovidTest newTest) {

        covidTests.add(newTest);
    }

    public void takeRadiologicalTest(RadiologicalTest newTest) {

        radiologicalTests.add(newTest);
    }

    public void takeBloodTest(BloodTest newTest) {

        bloodTests.add(newTest);
    }

    public void displayCovidTests() {

        System.out.println(covidTests);
    }

    public void displayRadiologicalTests() {
        
        System.out.println(radiologicalTests);
    }

    public void displayBloodTests() {

        System.out.println(bloodTests);
    }

    public void updateCovidTest(CovidTest updateTest) {
        
        CovidTest removeObject = new CovidTest(updateTest.getID());

        if (covidTests.remove(removeObject)) {
            covidTests.add(updateTest);
        }

    }

    public void updateRadiologicalTest(RadiologicalTest updateTest) {

        RadiologicalTest removeObject = new RadiologicalTest(updateTest.getID());

        if (radiologicalTests.remove(removeObject)) {
            radiologicalTests.add(updateTest);
        }
                     
    }

    public void updateBloodTest(BloodTest updateTest) {
        
        BloodTest removeObject = new BloodTest(updateTest.getID());

        if (bloodTests.remove(removeObject)) {
            bloodTests.add(updateTest);
        }
    }
    
}
