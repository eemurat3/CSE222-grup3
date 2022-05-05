package departments;
/**
 *
 * @author harunerenozkaya
 *
 */

import java.util.ArrayList;

import tests.BloodTest;
import tests.Test;
import users.BinarySearchTree;
import users.Technician;
import users.TreeIterator;

public class Lab extends Department {
    /**
	 * Clinical Technician List
	 */
    private ArrayList<Technician> clinicalTechnicians;

    /**
	 * Test BST
	 */
    private BinarySearchTree<Test> tests;



    public Lab(){
        clinicalTechnicians = new ArrayList<Technician>();
        tests = new BinarySearchTree<Test>();
    }

    public Lab(ArrayList<Technician> clinicalTechnicians,BinarySearchTree<Test> tests){
        this.clinicalTechnicians = clinicalTechnicians;
        this.tests = tests;
    }

    /**
     * Get test by test id
     * @param  testID which is unique code for test
     */
    public Test getTest(String testID){
        TreeIterator i = tests.getIterator();

        while(i.hasNext()){
            Test currentItem = ((Test) i.next().getData());

            if(currentItem.getID().equals(testID))
                return currentItem;
        }

        return null;
    }

    /**
     * Add new test
     * @param test which is Test object
     */
    public void addTest(Test test){
        tests.add(test);
    }

    /**
     * Remove a test by object
     * @param test which is Test object
     */
    public void removeTest(Test test){
        tests.delete(test);
    }

    /**
     * Remove a test by testID
     * @param  testID which is unique code for test
     */
    public void removeTest(String testID){
        removeTest(getTest(testID));
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

        TreeIterator i = tests.getIterator();
 
        while(i.hasNext()){
            Test currentItem = ((Test) i.next().getData());
         
            result.append(count + ")" + currentItem.getID() + "\n");

            count += 1;
        }

        return result.toString();
    }





    public static void main(String[] args){

        ArrayList<Technician> techniciansT = new ArrayList<>();
        BinarySearchTree<Test>  testsT = new BinarySearchTree<> ();


        

        /* Fill technicians and tests*/

        for(int i=0;i<10;i++){
            techniciansT.add(new Technician("trying1","trying2",String.valueOf(i), 0,"ty", "yt"));
        }
        for(int i=10;i<20;i++){
            testsT.add(new BloodTest(String.valueOf(i)));
        }

		System.out.println("------------ Test of Lab Department ---------------");




		/** Constructor test */
        System.out.println("/** Constructor test */ \n");

        Lab lab = new Lab();
        Lab lab2 = new Lab(techniciansT,testsT);




		/** Initially created test result */
        System.out.println("/** Initially created test result */ \n");

        System.out.println(lab);
        System.out.println(lab2);




		
		/** Modify methods */

        lab.addTest(new BloodTest("11"));
        lab.addTest(new BloodTest("12"));
        lab.addClinicalTechnician(new Technician("kemal", "leman", "11", 0, "ms", "sm"));
        lab.addClinicalTechnician(new Technician("kemal", "leman", "12", 0, "ms", "sm"));
        lab.removeTest("12");
        lab.removeClinicalTechnician("12");





		
		/** Data after modifying */
        System.out.println("/** Data after modifying */\n");

		System.out.println(lab);




        
		/* Performance Testing */
        System.out.println("/* Performance Testing */\n");
        
        //100 item
        //tests

        String[] ID100 = new String[100]; 
		for(int i = 0; i < 100; i++){
			Integer nextint = (int) (3200 * Math.random());
			ID100[i] = nextint.toString();	
		}

        BinarySearchTree<Test>  tests100 = new BinarySearchTree<>();
        ArrayList<Technician> technicians100 = new ArrayList<>();

        double sum;
        double start = 0;
        double end1 = 0; 

        start = System.nanoTime(); 
        for(int i = 0; i < 100; i++){
            tests100.add(new BloodTest(String.valueOf(i)));
        }
        end1 = System.nanoTime(); 
        sum = (end1 - start); 
        
        System.out.println("Run Time for 100 test: " + sum / 1000000000);

        //100 item
        //technicians

        double sumTec;
        double startTec = 0;
        double end1Tec = 0; 

        startTec = System.nanoTime(); 
        for(int i = 0; i < 100; i++){
            technicians100.add(new Technician("a","b",String.valueOf(i), 0, "c", "d"));
        }
        end1Tec = System.nanoTime(); 
        sumTec = (end1Tec - startTec); 
        
        System.out.println("Run Time for 100 technician: " + sumTec / 1000000000);
        
        /*--------------------------------------------*/

        //1000 item
        //tests

        String[] ID1000 = new String[1000]; 
		for(int i = 0; i < 1000; i++){
			Integer nextint = (int) (32000 * Math.random());
			ID1000[i] = nextint.toString();	
		}

        BinarySearchTree<Test> tests1000 = new BinarySearchTree<>();

        double sum2;
        double start2 = 0;
        double end2 = 0; 

        start2 = System.nanoTime(); 
        for(int i = 0; i < 1000; i++){
            tests1000.add(new BloodTest(String.valueOf(i)));
        }
        end2 = System.nanoTime(); 
        sum2 = (end2 - start2); 
        
        System.out.println("Run Time for 1000 test: " + sum2 / 1000000000);


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
        
        System.out.println("Run Time for 1000 technician: " + sum2Tec / 1000000000);

        /*--------------------------------------------*/

        //10000 item
        //tests

        String[] ID10000 = new String[10000]; 
		for(int i = 0; i < 10000; i++){
			Integer nextint = (int) (320000 * Math.random());
			ID10000[i] = nextint.toString();	
		}

        BinarySearchTree<Test> tests10000 = new BinarySearchTree<>();

        double sum3;
        double start3 = 0;
        double end3 = 0; 

        start3 = System.nanoTime(); 
        for(int i = 0; i < 10000; i++){
            tests10000.add(new BloodTest(String.valueOf(i)));
        }
        end3 = System.nanoTime(); 
        sum3 = (end3 - start3); 
        
        System.out.println("Run Time for 10000 test: " + sum3 / 1000000000);

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
        
        System.out.println("Run Time for 10000 technician: " + sum3Tec / 1000000000);
    
	}
}
