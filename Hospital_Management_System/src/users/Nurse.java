package users;

import java.util.Date;
import systems.Appointment;
import systems.HMSystem;
import systems.Prescription;
import util.TreeIterator;
import departments.Polyclinic;

/**
 *
 * @author Ahmet Usluoglu
 * Nurse Class Extends Worker Class
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
    
    public void updatePatientInfo(Patient patient, String appointmentID, String note) 
    {  
        for(Appointment i : patient.getAppointments()){
            if(i.getId().equals(appointmentID)){
                i.setNote(note);
            }
        }
    }

    /**
     * This function updates the patient's information by calling the updatePatientInfo function in the
     * Patient class
     * 
     * @param patientID The ID of the patient
     * @param appointmentID The appointment ID of the appointment that the patient is attending.
     * @param note The note that the doctor wants to add to the patient's file.
     */
    public void updatePatientInfo(String patientID, String appointmentID, String note) 
    {  
        TreeIterator<User> it = HMSystem.getusers().getIterator();

        while(it.hasNext()){
            User current = it.next().getData();

            if(current.getId().equals(patientID)){
                updatePatientInfo((Patient) current,appointmentID,note);
                break;
            }
        }
    }
    
    /**
     * This function displays the patient's prescriptions, doctors, and records
     * @param patient the patient object that is being displayed
     */
    public void displayPatientInfo(Patient patient) 
    {
        System.out.println(patient.displayPrescriptions());
        System.out.println(patient.displayDoctors());
        System.out.println(patient.displayRecords());   
    }

    /**
     * This function displays the prescriptions of a patient
     * @param patient The patient whose prescriptions are to be displayed.
     */
    public void displayPatientMed(Patient patient) 
    {
        System.out.println(patient.displayPrescriptions());
        
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
        System.out.println(patient.displayRecords());
    }

    public static void main(String [] args) {
        System.out.print("\n\n\t\t\t NURSE TESTING STARTS \n\n");

        System.out.println("\n********Nurse Unit test************ \n");
        Nurse test = new Nurse("nurse","nurses","11",25,"nurse@nurse.com","nurses");
        Patient patient = new Patient("patient", "patient1", "10", 25);
        Prescription prescription = new Prescription("0","0","try", "newpres", "prescription update");
        Doctor doctor= new Doctor("doctor","xyz","1",25,"xyz@gtu.uedu.tr","xyz");
        Polyclinic pol1 = new Polyclinic("e",5);
        Date d = new Date();
        patient.addPrescription(prescription);
        Appointment app = new Appointment(pol1,doctor,patient,d,"123");
        System.out.println("Get Nurse İnformation");
        System.out.println(test.toString());
        patient.addAppointment(app);
        System.out.println("Get Patient İnformation");
        test.displayPatientRecords(patient);
        System.out.println("Get Patient prescription");
        test.displayPatientMed(patient);
        System.out.print("\n\n\t\t\t NURSE TESTING ENDS \n\n");

    }

}
