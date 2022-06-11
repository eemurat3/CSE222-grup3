package users;

import javax.print.Doc;


import systems.Prescription;

/**
 *
 * @author Yusuf Talha Altun
 * Secreter Class extends Worker Class.
 */
public class Secreter extends Worker{

    //TODO prescription list ekle , doktor bu listeye prescription ekleyecek ve secreter bu prescriptionları patientlara ekleyebilir.



    // A constructor.
    public Secreter(String name, String surname, String id, int age,String email , String password) 
    {
        super(name, surname, id, age, email ,  password);
    }

    /**
     * This function prescribes a patient a prescription with a note
     * 
     * @param patient The patient object
     * @param pres Prescription object
     * @param note String
     */
    public void prescribePatient(Patient patient, Prescription pres , String note) 
    {
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

    public static void main(String[] args) {
        System.out.print("\n\n\t\t\t SECRETER TESTING STARTS \n\n");


        System.out.println("\n\n\n------------ Testing Secreter------------\n");
        
        String name = "name";
        String surname = "surname";
        String id = "id";
        int age = 30;
        String email = "email";
        String password = "password";
        Doctor doc = new Doctor(name, surname, id, age, email, password);
        Patient patient = new Patient(name, surname, id, age);
        Prescription pres = new Prescription("medicine", "instruction", "note");

        long startTime = System.nanoTime();
        testPrescribePatient(100, patient, pres, "note");
        long endTime = System.nanoTime();
        System.out.println("Running time for prescribing to a patient in the 100 elements : " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        testPrescribePatient(1000, patient, pres, "note");
        endTime = System.nanoTime();
        System.out.println("Running time for prescribing to a patient in the 1000 elements : " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        testPrescribePatient(10000, patient, pres, "note");
        endTime = System.nanoTime();
        System.out.println("Running time for prescribing to a patient in the 10000 elements : " + (endTime - startTime) + " ns");



        startTime = System.nanoTime();
        testDisplayQueue(100, doc);
        endTime = System.nanoTime();
        System.out.println("Running time for displaying queue in the 100 elements : " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        testDisplayQueue(1000, doc);
        endTime = System.nanoTime();
        System.out.println("Running time for displaying queue in the 1000 elements : " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        testDisplayQueue(10000, doc);
        endTime = System.nanoTime();
        System.out.println("Running time for displaying queue in the 10000 elements : " + (endTime - startTime) + " ns");
        System.out.print("\n\n\t\t\t SECRETER TESTING ENDS \n\n");

    }
    public static void testPrescribePatient(int counter, Patient patient, Prescription pres, String note){
        Secreter sec = new Secreter("name", "surname", "id", 30, "email", "password");
        for(int i = 0 ; i < counter ; i++){
            sec.prescribePatient(patient, pres, note);
        }

    }

    public static void testDisplayQueue(int counter, Doctor doctor){
        Secreter sec = new Secreter("name", "surname", "id", 30, "email", "password");
        for(int i = 0 ; i < counter ; i++){
            sec.displayQueue(doctor);
        }
    }
}