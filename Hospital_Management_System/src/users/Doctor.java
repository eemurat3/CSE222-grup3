package users;

import java.util.Date;
import java.util.PriorityQueue;


import departments.Polyclinic;
import systems.Appointment;
import systems.HMSystem;
import systems.Prescription;
import tests.BloodTest;
import tests.Test;



/**
 *
 * @author Ahmet Usluoglu
 * Doctor class extends worker class.
 */
public class Doctor extends Worker
{
    private Secreter secreter;
    private PriorityQueue<Appointment> appointments;

    public Doctor(String name, String surname, String id, int age,String email , String password) 
    {
        super(name, surname, id, age, email ,  password);
        appointments = new PriorityQueue<>();
    }

    /**
     * This function returns the secreter.
     * 
     * @return The secreter object.
     */
    public Secreter getSecreter() {
        return secreter;
    }

    /**
     * This function sets the secreter variable to the secreter parameter.
     * 
     * @param secreter The secreter object that will be used to encrypt and decrypt the data.
     */
    public void setSecreter(Secreter secreter) {
        this.secreter = secreter;
    }

    /**
     * This function displays the patient's prescriptions, doctors, and records
     * 
     * @param patient The patient object that is being displayed.
     */
    public void displayPatientInfo(Patient patient) 
    {
        patient.displayPrescriptions();
        patient.displayDoctors();
        patient.displayRecords();
        
    }

    public boolean addAppointment(Appointment appo) {
        //Add to doctor's appointments
        appointments.offer(appo);
        
        return true;
    }

    /**
     * This function returns the first appointment in the queue 
     * @return The appointment at the top of the stack.
     */
    public Appointment getAppointment()
    {
        return appointments.peek();
    }
    
    /**
     * This function takes a patient, a prescription and a note as parameters and adds the prescription
     * to the patient's list of prescriptions
     * @param patient Patient object
     * @param pres Prescription object
     * @param note String
     */

    public void givePrescription(String prescriptionID,String patientID,String medicine,String instructions,String note) {
        secreter.prescriptions.add(new Prescription(prescriptionID,patientID,medicine,instructions,note));
    }
   
    /**
     * It sets the note of the appointment, sets the discharged status to true, removes the appointment
     * from the queue and adds it to the database
     * 
     * @param appo Appointment
     * @param note String
     */
    public void dischargePatient(Appointment appo , String note) {
        appo.setNote(note);
        appointments.peek().setDischarged(true);
        appointments.remove();
    }

    /**
     * > This function request a test from a technician
     * 
     * @param technician The patient object that is requesting the test.
     * @param test The test to be requested
     */
    public void requestTest(Technician technician ,Test test)
    {
        technician.addTest(test);
    }

     /**
     * > This function request a test from a technician
     * 
     * @param technicianID The patient object that is requesting the test.
     * @param test The test to be requested
     */
    public void requestTest(String technicianID ,Test test)
    {
        for(Worker t : HMSystem.workers){
            if(t.getId().equals(technicianID)){
                requestTest((Technician) t, test);
                break;
            }
        }
    }

    /**
     * This function prints the names of all the patients who have an appointment with the doctor
     */
    public void waitingPatients() {
        for (Appointment item : appointments) {
            System.out.println(item.getPatient().getName());
        }
    }
    
    /**
     * If the object is the same object, or if the object is the same type and has the same id, then
     * the objects are equal
     * 
     * @param obj The object to compare with.
     */
    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Doctor other = (Doctor) obj;
        if (getId() == other.getId()) {
            return true;
        }
        return true;
    }

    /**
     * It creates a doctor, adds an appointment to it, displays the patient's info, gives a
     * prescription to the patient, requests a test from the patient, discharges the patient, adds 100,
     * 1000 and 10000 appointments to the doctor and displays the time it takes to add them
     */
    public static void main(String[] args) 
    {
        System.out.print("\n\n\t\t\t DOCTOR UNIT TESTING STARTS \n\n");
        Doctor dr1 = new Doctor("name", "surname", "id", 30, "email", "password");
        System.out.print("\n");
        System.out.print("Doctor 1 created = "+dr1 + "\n");

        Appointment appo1 = new Appointment(new Polyclinic("Radiology",7), dr1, new Patient("name", "surname", "id", 30), new Date(), "11111");
        System.out.println("\nAppointment 1 created = "+appo1);
        dr1.addAppointment(appo1);
        System.out.println("\nAppointment 1 added to doctor 1 = "+dr1.appointments);

        dr1.displayPatientInfo(dr1.getAppointment().getPatient());
        System.out.println("\nFirst patient at appointment list is shown = "+dr1.getAppointment().getPatient());

        dr1.givePrescription("234","123","med","inst","note");
        System.out.println("\nAdded Prescription to the patient at the top of the list = "+dr1.getAppointment().getPatient().displayPrescriptions());
        
        dr1.requestTest("2332", new BloodTest());
        System.out.println("\nBloodtest requested from patient = "+dr1.getAppointment().getPatient().getTests());

        dr1.dischargePatient(appo1, "note");
        System.out.println("\nPatient Discharged = "+dr1.appointments);

        System.out.println("\n\t\tAdding Operation\n");


        long start = System.nanoTime(); 
        for(int i = 0; i < 100; i++)
        {
            dr1.addAppointment(appo1);
        }
        long end1 = System.nanoTime(); 
        long sum = (end1 - start);
        
        System.out.println("\nAdded 100 appointments to doctor 1 = " + sum/1000 + "ns");

        
        
        start = System.nanoTime(); 
        for(int i = 0; i < 100; i++)
        {
            dr1.appointments.remove();
        }
        end1 = System.nanoTime(); 
        long sum1 = (end1 - start);
        
        
        
        
        dr1.appointments.clear();

        start = System.nanoTime(); 
        for(int i = 0; i < 1000; i++)
        {
            dr1.addAppointment(appo1);
        }
        end1 = System.nanoTime(); 
        sum = (end1 - start);
        
        System.out.println("\nAdded 1000 appointments to doctor 1 = " + sum/1000 + "ns");


        start = System.nanoTime(); 
        for(int i = 0; i < 1000; i++)
        {
            dr1.appointments.remove();
        }
        end1 = System.nanoTime(); 
        long sum2 = (end1 - start);
        
        dr1.appointments.clear();

        start = System.nanoTime(); 
        for(int i = 0; i < 10000; i++)
        {
            dr1.addAppointment(appo1);
        }
        end1 = System.nanoTime(); 
        sum = (end1 - start);

        start = System.nanoTime(); 
        for(int i = 0; i < 10000; i++)
        {
            dr1.appointments.remove();
        }
        end1 = System.nanoTime(); 
        long sum3 = (end1 - start);
        
        dr1.appointments.clear();
        
        System.out.println("\nAdded 10000 appointments to doctor 1 = " + sum/1000 + "ns");
        

        System.out.println("\n\t\tRemoving Operation\n");

        System.out.println("\nRemoved 100 appointments to doctor 1 = " + sum1/1000 + "ns");
        System.out.println("\nRemoved 1000 appointments from doctor 1 = " + sum2/1000 + "ns");
        System.out.println("\nRemoved 10000 appointments from doctor 1 = " + sum3/1000 + "ns");

        
        System.out.print("\n\n\t\t\t DOCTOR UNIT TESTING ENDS \n\n");

    }

}
