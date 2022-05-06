package users;

public class Technician extends Worker {


    public Technician(String name, String surname, String id, int age, String username, String password) {
        super(name, surname, id, age, username, password);
    }

    public void takeCovidTest(CovidTest newTest, BinarySearchTree<Test> covidTests) {

        covidTests.add(newTest);
    }

    public void takeRadiologicalTest(RadiologicalTest newTest, BinarySearchTree<Test> radiologicalTests) {

        radiologicalTests.add(newTest);
    }

    public void takeBloodTest(BloodTest newTest, BinarySearchTree<Test> bloodTests) {

        bloodTests.add(newTest);
    }

    public void displayCovidTests(BinarySearchTree<Test> covidTests) {

        System.out.println(covidTests.inorder());
    }

    public void displayRadiologicalTests(BinarySearchTree<Test> radiologicalTests) {
        
        System.out.println(radiologicalTests.inorder());
    }

    public void displayBloodTests(BinarySearchTree<Test> bloodTests) {

        System.out.println(bloodTests.inorder());
    }

    public void updateCovidTest(CovidTest updateTest, BinarySearchTree<Test> covidTests) {
        

        if (covidTests.deleteS(updateTest) != null) {
            covidTests.add(new CovidTest(updateTest.getID(), updateTest.getTestResult()));
        }

    }

    public void updateRadiologicalTest(RadiologicalTest updateTest, BinarySearchTree<Test> radiologicalTests) {

        if (radiologicalTests.deleteS(updateTest) != null) {
            radiologicalTests.add(new RadiologicalTest(updateTest.getID(), updateTest.getTestResult(), updateTest.getTestType()));
        }
                     
    }

    public void updateBloodTest(BloodTest updateTest, BinarySearchTree<Test> bloodTests) {

        if (bloodTests.deleteS(updateTest) != null) {
            bloodTests.add(new BloodTest(updateTest.getID()));
        }
    }
    
}
