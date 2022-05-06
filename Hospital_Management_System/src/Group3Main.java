import departments.Lab;
import systems.HMSystem;
import unit_tests.TestAdvisor;
import users.Doctor;
import users.Patient;
import users.Worker;
import users.Patient;

public class Group3Main {

    public static void main(String[] args) {
        
        //HMSystem myHospital = new HMSystem();

        Doctor.main(args);
        Lab.main(args);
        TestAdvisor.main(args);
        Patient.main(args);
    }
}
