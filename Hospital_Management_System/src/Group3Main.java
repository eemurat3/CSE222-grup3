import departments.Lab;
import systems.HMSystem;
import unit_tests.TestAdvisor;
import unit_tests.ut_polyclinic;
import users.Doctor;
import users.Patient;
import users.Worker;

public class Group3Main {

    public static void main(String[] args) {
        
        //HMSystem myHospital = new HMSystem();

        Doctor.main(args);
        Lab.main(args);
        TestAdvisor.main(args);
        Patient.main(args);
        ut_polyclinic.main(args);
        BloodTest.main(args);
        Appointment.main(args);
    }
}
