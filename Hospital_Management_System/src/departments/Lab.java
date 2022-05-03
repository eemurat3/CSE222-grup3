package departments;
import users.*;
import java.util.*;

public class Lab extends Department {
    ArrayList<Technician> clinicalTechnicians;


    public Lab(){
        clinicalTechnicians = new ArrayList();
    }

    public Lab(ArrayList<Technician> clinicalTechnicians){
        this.clinicalTechnicians = clinicalTechnicians;
    }

    public void getTest(String patientID){

    }

    public void addTest(Test test){

    }

    public void removeTest(Test test){

    }

    public void removeTest(String patientID){

    }

    public void displayClinicalTechnician(String technicianID){

    }

    public void addClinicalTechnician(Technician technician){

    }

    public void removeClinicalTechnician(Technician technician){

    }

    public void removeClinicalTechnician(String technicianID){

    }
}
