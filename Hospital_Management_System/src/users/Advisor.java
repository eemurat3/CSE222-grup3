package users;

import java.util.*;

/**
 * It's a class that extends the Worker class and adds a priority queue of patients.
 */
public class Advisor extends Worker {
    
    //TODO 
    //Kendi patient list tutmayacak doktorların appointment liste ekleyecek , silinecek . 
    // PriorityQueue<Patient> patients = new PriorityQueue<>();

	// A constructor for the Advisor class.
    public Advisor(String name, String surname, String id, int age, String username, String password) {
        super(name, surname, id, age, username, password);
    }
    
 
    /**
     * If the patient is not already in the list, add the patient to the list
     * 
     * @param nextPatient The patient to be added to the list.
     * @return A boolean value.
     */
    //TODO genel patient arraye ekleyecek
    public boolean addPatient() {
        return false;
    }
    
    //TODO doctorun appointmenına ekleyecek
    public boolean addAppointment(Patient nextPatient){
        return false;
    }



    //TODO advisor patient silemesin
    /**
     * It removes the patient from the list.
     * 
     * @param nextPatient The patient to remove from the list.
     * @return A boolean value.
     */
    public boolean removePatient(Patient nextPatient) {
      return false;
    }


    //TODO display doctor list
    /**
     * This function takes the patients in the queue and displays them in a string
     * 
     * @return A string of the patients in the queue.
     */
    public String displayQueue() {
        return null;
    }

    /**
     * The toString() method returns a string representation of the object
     * @return The role of the advisor and the super class toString method.
     */
    @Override
    public String toString() {
        return  "Role: Advisor, " + super.toString();
    }

}
