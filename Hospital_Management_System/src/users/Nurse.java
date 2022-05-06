package users;

import java.util.Date;
import java.util.UUID;

import systems.Appointment;

/**
 *
 * @author Ahmet Usluoglu
 */
public class Nurse extends Worker{
    
    // A constructor.
    public Nurse(String name, String surname, String id, int age ,String email , String password) {
        super(name, surname, id, age, email ,  password);
    }
    
    /**
     * This function updates the patient information by adding a note to the appointment
     * @param patient Patient object
     * @param appo Appointment object
     * @param note String
     */
    public void updatePatientInfo(Patient patient, Appointment appo, String note) 
    {   
        appo.setNote("Note");
    	patient.addAppointment(appo);
    }
    
    /**
     * This function displays the patient's prescriptions, doctors, and records
     * @param patient the patient object that is being displayed
     */
    public void displayPatientInfo(Patient patient) 
    {
        patient.displayPrescriptions();
        patient.displayDoctors();
        patient.displayRecords();
        
    }

    /**
     * This function displays the prescriptions of a patient
     * @param patient The patient whose prescriptions are to be displayed.
     */
    public void displayPatientMed(Patient patient) 
    {
        patient.displayPrescriptions();
        
    }
    
    /**
     * This function displays the doctors of a patient
     * @param patient The patient object that is being passed in.
     */
    public void displayPatientDoctors(Patient patient) 
    {
        patient.displayDoctors();
        
    }
    
    /**
     * The function displayPatientRecords() takes a Patient object as an argument and calls the
     * displayRecords() function on that object
     * @param patient The patient whose records are to be displayed.
     */
    public void displayPatientRecords(Patient patient) 
    {
        patient.displayRecords();
        
    }

}
