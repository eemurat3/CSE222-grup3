package departments;
/**
 *
 * @author harunerenozkaya
 *
 */

import java.util.ArrayList;
import java.util.TreeMap;

import tests.Test;
import users.Technician;

public class Lab extends Department {
    /**
	 * clinical technician list
	 */
    private ArrayList<Technician> clinicalTechnicians;
    /**
	 * test tree
	 */
    private TreeMap<String,Test> tests;



    public Lab(){
        clinicalTechnicians = new ArrayList<Technician>();
        tests = new TreeMap<String,Test>();
    }

    public Lab(ArrayList<Technician> clinicalTechnicians,TreeMap<String,Test> tests){
        this.clinicalTechnicians = clinicalTechnicians;
        this.tests = tests;
    }

    /**
     * Get test by test id
     * @param  testID which is unique code for test
     */
    public void getTest(String testID){
        tests.get(testID);
    }

    /**
     * Add new test
     * @param test which is Test object
     */
    public void addTest(Test test){
        tests.put(test.getID(), test);
    }

    /**
     * Remove a test by object
     * @param test which is Test object
     */
    public void removeTest(Test test){
        tests.remove(test.getID(),test);
    }

    /**
     * Remove a test by testID
     * @param  testID which is unique code for test
     */
    public void removeTest(String testID){
        tests.remove(testID);
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
}
