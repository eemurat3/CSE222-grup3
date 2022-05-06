import departments.Lab;
import systems.HMSystem;
import unit_tests.TestAdvisor;
import unit_tests.ut_polyclinic;
import users.Doctor;
import users.Manager;
import users.Patient;
import users.Secreter;
import users.Worker;

public class Group3Main {

    public static void main(String[] args) {
        
        //HMSystem myHospital = new HMSystem();

        Doctor.main(args);
        Lab.main(args);
        TestAdvisor.main(args);
        Patient.main(args);
        ut_polyclinic.main(args);
        Secreter.main(args);
        Manager.main(args);
    }
}
