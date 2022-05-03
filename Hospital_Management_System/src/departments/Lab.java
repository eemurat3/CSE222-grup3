package departments;
/**
 *
 * @author murat Kaymaz
 *
 */
import users.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
public class Polyclinic extends Department {
    /**
     * polyclinic doctor list
     */
    private ArrayList<Doctor> doctors = new ArrayList<>();
    /**
     * polyclinic nurse list
     */
    private ArrayList<Nurse> nurses = new ArrayList<>();
    /**
     * polyclinic secreter list
     */
    private ArrayList<Secreter> secreters = new ArrayList<>();
    /***
     * polyclinic patient queue
     */
    private Queue<Patient> patients = new PriorityQueue<>();
    /**
     * default constructor
     */
    Polyclinic() {
		/*doctors   = ;
	    nurses    = new ArrayList<Nurse>();
	    secreters = new ArrayList<Secreter>();
	    patients  = new Queue<Patient>();*/
    }
    /**
     * add new doctor to polyclinc
     * @param d : new doctor
     */
    public void addDoctor(Doctor d) {
        doctors.add(d);
    }
    /**
     * add new nurse to polyclinc
     * @param n : new nurse
     */
    public void addNurse(Nurse n) {
        nurses.add(n);
    }
    /**
     * add new secreter to polyclinc
     * @param s : new secreter
     */
    public void addSecreter(Secreter s) {
        secreters.add(s);
    }
    /**
     * add new patients to patients queue
     * @param p : new patient
     */
    public void addPatients(Patient p) {
        patients.add(p);
    }
    /**
     * get the doctors list of the polyclinic
     * @return : doctors list
     */
    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }
    /**
     * get the nurses list of the polyclinic
     * @return : nurses list
     */
    public ArrayList<Nurse> getNurses() {
        return nurses;
    }
    /**
     * get the secreters list of the polyclinic
     * @return : secreters list
     */
    public ArrayList<Secreter> getSecreters() {
        return secreters;
    }
    /**
     * get the patients queue of the polyclinic
     * @return : patients Queue
     */
    public Queue<Patient>  getPatients() {
        return patients;
    }

}
