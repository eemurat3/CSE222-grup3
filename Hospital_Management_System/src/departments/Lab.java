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
    ArrayList<Technician> clinicalTechnicians;
    TreeMap<Integer,Test> tests;


    public Lab(){
        clinicalTechnicians = new ArrayList<Technician>();
    }

    public Lab(ArrayList<Technician> clinicalTechnicians){
        this.clinicalTechnicians = clinicalTechnicians;
    }

    /**
     * Get test by test id
     */
    public void getTest(Integer testID){
        tests.get(testID);
    }

    /**
     * Add new test
     */
    public void addTest(Test test){
        tests.put(test.getID(), test);
    }

    /**
     * Remove a test by object
     */
    public void removeTest(Test test){
        tests.remove(test.getID(),test);
    }

    /**
     * Remove a test by testID
     */
    public void removeTest(Integer testID){
        tests.remove(testID);
    }

    /**
     * Get clinical technician by technician id
     */
    public Technician getClinicalTechnician(Integer technicianID){

        for(Technician i : clinicalTechnicians){
            if(i.id == technicianID)
                return i;

        }
    }

    /**
     * Add new clinical technician
     */
    public void addClinicalTechnician(Technician technician){
        clinicalTechnicians.add(technician);
    }

    /**
     * Remove a clinical technician by object
     */
    public void removeClinicalTechnician(Technician technician){
        clinicalTechnicians.remove(technician);
    }

    /**
     * Remove a clinical technician by technician id
     */
    public void removeClinicalTechnician(String technicianID){
        for(int i = 0; i < clinicalTechnicians.size(); i++){
            if(clinicalTechnicians.get(i).id == technicianID)
                clinicalTechnicians.remove(i);

        }
    }
}
