package users;
/**
 *
 * @author Yusuf Talha Altun
 */
public class Secreter extends Worker{
    public Secreter(String name, String surname, String id, int age,String email , String password) {
        super(name, surname, id, age, email ,  password);
    }

    public void prescribePatient(Patient patient, Prescription pres , String note) throws IOException{
        patient.addPrescription(pres);
    }

    public void displayQueue(Doctor doctor){
        doctor.waitingPatients();
    }
}