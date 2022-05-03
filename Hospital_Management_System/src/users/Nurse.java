package users;

import java.util.Date;
import java.util.UUID;

import system.Appointment;

/**
 *
 * @author Ahmet Usluoglu
 */
public class Nurse extends Worker{
    
    public Nurse(String name, String surname, String id, int age ,String email , String password) {
        super(name, surname, id, age, email ,  password);
    }
    
    public void updatePatientInfo(Patient patient, Appointment appo, String note) 
    {   
        appo.setNote("Note");
    	patient.addAppointment(appo);
    }
    
    public void displayPatientInfo(Patient patient) 
    {
        patient.displayPrescriptions();
        patient.displayDoctors();
        patient.displayRecords();
        
    }

    public void displayPatientMed(Patient patient) 
    {
        patient.displayPrescriptions();
        
    }
    
    public void displayPatientDoctors(Patient patient) 
    {
        patient.displayDoctors();
        
    }
    
    public void displayPatientRecords(Patient patient) 
    {
        patient.displayRecords();
        
    }
     
    
    

}
