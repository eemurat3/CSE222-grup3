package departments;
/**
 *
 * @author harunerenozkaya
 *
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import tests.BloodTest;
import tests.Test;
import util.BinarySearchTree;
import users.Technician;
import util.TreeIterator;

/**
 * The Lab class is a subclass of the Department class. 
 */
public class Lab extends Department {

    /**
	 * Clinical Technician List
	 */
    private ArrayList<Technician> clinicalTechnicians;

    /**
	 * Waitining Test Queue
	 */
    private Queue<Test> tests;
    

    /**
	 * All Test BST
	 */
    private BinarySearchTree<Test> allTests;

    

    /**
     * No parameter Contructor
     */
    public Lab(String departmentName,int departmentID){
        super(departmentName,departmentID,0);

        clinicalTechnicians = new ArrayList<Technician>();
        tests = new LinkedList<>();
        allTests = new BinarySearchTree<>();
    }

    /**
     * Constructor
     * @param clinicalTechnicians takes a clinical technician list
     * @param tests takes a test queue
     * @param allTests takes a test list as Binary Search Tree
     */
    public Lab(String departmentName,int departmentID,ArrayList<Technician> clinicalTechnicians,Queue<Test> tests,BinarySearchTree<Test> allTests){
        super(departmentName,departmentID,0);
        
        this.clinicalTechnicians = clinicalTechnicians;
        this.tests = tests;
        this.allTests = allTests;
    }

    /**
     * This function returns a queue of tests.
     * 
     * @return The queue of tests.
     */
    public Queue<Test> getWaitingTests() {
        return tests;
    }

    /**
     * This function sets the tests variable to the tests parameter.
     * 
     * @param tests The tests that are waiting to be run.
     */
    public void setWaitingTests(Queue<Test> tests) {
        this.tests = tests;
    }

    /**
     * This function returns the BinarySearchTree of all tests.
     * 
     * @return The BinarySearchTree of all tests.
     */
    public BinarySearchTree<Test> getAllTests() {
        return allTests;
    }

    /**
     * This function sets the value of the allTests variable to the value of the parameter allTests
     * 
     * @param allTests This is the Binary Search Tree that contains all the tests.
     */
    public void setAllTests(BinarySearchTree<Test> allTests) {
        this.allTests = allTests;
    }

    /**
     * Get test by test id
     * @param  testID which is unique code for test
     */
    public Test getTest(String testID){
        TreeIterator<Test> i = allTests.getIterator();

        while(i.hasNext()){
            Test currentItem = ((Test) i.next().getData());

            if(currentItem.getTestID().equals(testID))
                return currentItem;
        }

        return null;
    }

    /**
     * Add new test
     * @param test which is Test object
     */
    public void addWaitingTest(Test test){
        tests.add(test);
    }

    public void addOldTest(Test oldTest){
        allTests.add(oldTest);
    }

    /**
     * Remove a test by object
     * @param test which is Test object
     */
    public Test removeWaitingTest(){
        return tests.poll();
    }

    public void removeOldTest(Test oldTest){
        allTests.remove(oldTest);
    }

    public void removeOldTest(String testID){
        removeOldTest(getTest(testID));
    }

    /**
     * Get clinical technician by technician id
     * @param  technicianID which is unique code for technician
     * @return founded technician object
     */
    public Technician getClinicalTechnician(String technicianID){

        for(Technician i : clinicalTechnicians){
            if(i.getId().equals(technicianID))
                return i;
        }

        return null;

    }

    /**
     * Add new clinical technician
     * @param test which is Technician object
     */
    public void addClinicalTechnician(Technician technician){
        clinicalTechnicians.add(technician);
    }

    /**
     * Remove a clinical technician by object
     * @param test which is Technician object
     */
    public void removeClinicalTechnician(Technician technician){
        clinicalTechnicians.remove(technician);
    }

    /**
     * Remove a clinical technician by technician id
     * @param  technicianID which is unique code for technician
     */
    public void removeClinicalTechnician(String technicianID){
        for(int i = 0; i < clinicalTechnicians.size(); i++){
            if(clinicalTechnicians.get(i).getId().equals(technicianID))
                clinicalTechnicians.remove(i);

        }
    }

    /**
     * This function is used to print out the information of the clinical technicians and the tests
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int count = 0;
        

        result.append("Clicical Technicians : \n");

        for(int i=0;i<clinicalTechnicians.size();i++){
            result.append(i + ")" + clinicalTechnicians.get(i).getId()+"\n");
        }
        result.append("\n");


        result.append("Tests : \n");

        TreeIterator<Test> i = allTests.getIterator();
 
        while(i.hasNext()){
            Test currentItem = ((Test) i.next().getData());
         
            result.append(count + ")" + currentItem.getTestID() + "\n");

            count += 1;
        }

        return result.toString();
    }


    /**
     * The function creates a Lab object and prints it. Then, it adds a test and a technician to the
     * Lab object and removes a test and a technician from the Lab object. Then, it prints the Lab
     * object again. Finally, it performs performance testing on the Lab object
     */
    public static void main(String[] args){

        System.out.print("\n\n\t\t\t LAB UNIT TESTING STARTS \n\n");

        ArrayList<Technician> techniciansT = new ArrayList<>();
        BinarySearchTree<Test>  testsT = new BinarySearchTree<> ();
        Queue<Test> testsQ = new LinkedList<>();




        /* Fill technicians and tests*/

        for(int i=0;i<10;i++){
            techniciansT.add(new Technician("trying1","trying2",String.valueOf(i), 0,"ty", "yt"));
        }
        for(int i=0;i<10;i++){
            testsT.add(new BloodTest(String.valueOf(i),String.valueOf(i*11)));
        }
        for(int i=0;i<10;i++){
            testsQ.add(new BloodTest(String.valueOf(i),String.valueOf(i*13)));
        }

		System.out.println("------------ Test of Lab Department ---------------");




		/** Constructor test */
        System.out.println("/** Constructor test */ \n");

        Lab lab = new Lab("refe",232);
        Lab lab2 = new Lab("we",345,techniciansT,testsQ,testsT);
        




		/** Initially created test result */
        System.out.println("/** Initially created test result */ \n");

        System.out.println(lab);
        System.out.println(lab2);




		
		/** Modify methods */

        lab.addOldTest(new BloodTest("11","234"));
        lab.addOldTest(new BloodTest("12","2355235"));
        lab.addClinicalTechnician(new Technician("kemal", "leman", "11", 0, "ms", "sm"));
        lab.addClinicalTechnician(new Technician("kemal", "leman", "12", 0, "ms", "sm"));
        lab.removeOldTest("12");
        lab.removeClinicalTechnician("12");





		
		/** Data after modifying */
        System.out.println("/** Data after modifying */\n");

		System.out.println(lab);




        
		/* Performance Testing */
        System.out.println("/* Performance Testing */\n");


        String[] ID100 = new String[100]; 
		for(int i = 0; i < 100; i++){
			Integer nextint = (int) (3200 * Math.random());
			ID100[i] = nextint.toString();	
		}
        
        BloodTest dnm = new BloodTest();

        System.out.println("\n\nTesting the Waiting Tests Queue\n\n");


        System.out.println("\n\n\t\tAdding Operation\n\n");


        //100 item
        //tests
        Queue<Test> waitingTests100 = new LinkedList<>();

        double sumw;
        double startw = 0;
        double end1w = 0; 

        startw = System.nanoTime(); 
        for(int i = 0; i < 100; i++){
            waitingTests100.add(dnm);
        }
        end1w = System.nanoTime(); 
        sumw = (end1w - startw); 
        
        System.out.println("Adding 100 tests to queue: " + sumw / 1000);

        
        //1000 item
        //tests
        Queue<Test> waitingTests1000 = new LinkedList<>();

        double sumw2;
        double startw2 = 0;
        double end1w2 = 0; 

        startw2 = System.nanoTime(); 
        for(int i = 0; i < 1000; i++){
            waitingTests1000.add(dnm);
        }
        end1w2 = System.nanoTime(); 
        sumw2 = (end1w2 - startw2); 
        
        System.out.println("Adding 1000 tests to queue: " + sumw2 / 1000);

        //10000 item
        //tests
        Queue<Test> waitingTests10000 = new LinkedList<>();

        double sumw3;
        double startw3 = 0;
        double end1w3 = 0; 

        startw3 = System.nanoTime(); 
        for(int i = 0; i < 10000; i++){
            waitingTests10000.add(dnm);
        }
        end1w3 = System.nanoTime(); 
        sumw3 = (end1w3 - startw3); 
        
        System.out.println("Adding 10000 tests to queue: " + sumw3 / 1000);



        startw = System.nanoTime(); 
        for(int i = 0; i < 100; i++){
            waitingTests100.remove();
        }
        end1w = System.nanoTime(); 
        sumw = (end1w - startw); 
        
        System.out.println("\n\n\t\tRemoving Operation\n\n");

        System.out.println("Removing 100 tests from queue: " + sumw / 1000);

        startw = System.nanoTime(); 
        for(int i = 0; i < 1000; i++){
            waitingTests1000.remove();
        }
        end1w = System.nanoTime(); 
        sumw = (end1w - startw); 
        
        System.out.println("Removing 1000 tests from queue: " + sumw / 1000);

        startw = System.nanoTime(); 
        for(int i = 0; i < 10000; i++){
            waitingTests10000.remove();
        }
        end1w = System.nanoTime(); 
        sumw = (end1w - startw); 
        
        System.out.println("Removing 10000 tests from queue: " + sumw / 1000);

        
        
        System.out.println("\n\nTesting the All Tests list \n\n");
        
        //100 item
        //allTests
        BinarySearchTree<Test>  allTests100 = new BinarySearchTree<>();
        
        double sum;
        double start = 0;
        double end1 = 0; 

        start = System.nanoTime(); 
        for(int i = 0; i < 100; i++){
            allTests100.add(dnm);
        }
        end1 = System.nanoTime(); 
        sum = (end1 - start); 
        
        System.out.println("Run Time for 100 allTest: " + sum / 1000);


        //1000 item
        //allTests

        String[] ID1000 = new String[1000]; 
		for(int i = 0; i < 1000; i++){
			Integer nextint = (int) (32000 * Math.random());
			ID1000[i] = nextint.toString();	
		}

        BinarySearchTree<Test> allTests1000 = new BinarySearchTree<>();

        double sum2;
        double start2 = 0;
        double end2 = 0; 

        start2 = System.nanoTime(); 
        for(int i = 0; i < 1000; i++){
            allTests1000.add(dnm);
        }
        end2 = System.nanoTime(); 
        sum2 = (end2 - start2); 
        
        System.out.println("Run Time for 1000 allTest: " + sum2 / 1000);


        //10000 item
        //allTests

        String[] ID10000 = new String[10000]; 
		for(int i = 0; i < 10000; i++){
			Integer nextint = (int) (320000 * Math.random());
			ID10000[i] = nextint.toString();	
		}

        BinarySearchTree<Test> allTests10000 = new BinarySearchTree<>();

        double sum3;
        double start3 = 0;
        double end3 = 0; 

        start3 = System.nanoTime(); 
        for(int i = 0; i < 10000; i++){
            allTests10000.add(dnm);
        }
        end3 = System.nanoTime(); 
        sum3 = (end3 - start3); 
        
        System.out.println("Run Time for 10000 allTest: " + sum3 / 1000);


        System.out.println("\n\nTesting Technicians Array list \n\n");

        //100 item
        //technicians
        ArrayList<Technician> technicians100 = new ArrayList<>();

        double sumTec;
        double startTec = 0;
        double end1Tec = 0; 

        startTec = System.nanoTime(); 
        for(int i = 0; i < 100; i++){
            technicians100.add(new Technician("a","b",String.valueOf(i), 0, "c", "d"));
        }
        end1Tec = System.nanoTime(); 
        sumTec = (end1Tec - startTec); 
        
        System.out.println("Run Time for 100 technician: " + sumTec / 1000);
        
        /*--------------------------------------------*/

        //1000 item
        //technician

        ArrayList<Technician> technicians1000 = new ArrayList<>();

        double sum2Tec;
        double start2Tec = 0;
        double end2Tec = 0; 

        start2Tec = System.nanoTime(); 
        for(int i = 0; i < 1000; i++){
            technicians1000.add(new Technician("a","b",String.valueOf(i), 0, "c", "d"));
        }
        end2Tec = System.nanoTime(); 
        sum2Tec = (end2Tec - start2Tec); 
        
        System.out.println("Run Time for 1000 technician: " + sum2Tec / 1000);



        /*--------------------------------------------*/
        //10000 item
        //technician

        ArrayList<Technician> technicians10000 = new ArrayList<>();

        double sum3Tec;
        double start3Tec = 0;
        double end3Tec = 0; 

        start3Tec = System.nanoTime(); 
        for(int i = 0; i < 10000; i++){
            technicians10000.add(new Technician("a","b",String.valueOf(i), 0, "c", "d"));
        }
        end3Tec = System.nanoTime(); 
        sum3Tec = (end3Tec - start3Tec); 
        
        System.out.println("Run Time for 10000 technician: " + sum3Tec / 1000);
        System.out.print("\n\n\t\t\t LAB UNIT TESTING ENDS \n\n");

    
	}
}
