package users;

import systems.Prescription;

/**
 *
 * @author Yusuf Talha Altun
 */
public class Secreter extends Worker{
    // A constructor.
    public Secreter(String name, String surname, String id, int age,String email , String password) {
        super(name, surname, id, age, email ,  password);
    }

    /**
     * This function prescribes a patient a prescription with a note
     * 
     * @param patient The patient object
     * @param pres Prescription object
     * @param note String
     */
    public void prescribePatient(Patient patient, Prescription pres , String note) {
        patient.addPrescription(pres);
    }

    /**
     * This function displays the queue of patients waiting to see a doctor
     * 
     * @param doctor The doctor that the patient is going to see.
     */
    public void displayQueue(Doctor doctor){
        doctor.waitingPatients();
    }
}