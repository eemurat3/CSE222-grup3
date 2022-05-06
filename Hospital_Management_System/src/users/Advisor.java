package users;

import java.util.*;

/**
 * It's a class that extends the Worker class and adds a priority queue of patients.
 */
public class Advisor extends Worker {
    
    PriorityQueue<Patient> patients = new PriorityQueue<>();

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
    public boolean addPatient(Patient nextPatient) {
        
        for (Patient iPatient : patients)
            if (iPatient.getId() == nextPatient.getId())
                return false;

        patients.add(nextPatient);
        return true;
    }

    /**
     * It removes the patient from the list.
     * 
     * @param nextPatient The patient to remove from the list.
     * @return A boolean value.
     */
    public boolean removePatient(Patient nextPatient) {
        return patients.remove(nextPatient);
    }

    /**
     * This function takes the patients in the queue and displays them in a string
     * 
     * @return A string of the patients in the queue.
     */
    public String displayQueue() {
        
        StringBuilder sb = new StringBuilder();

        sb.append("Patients in queue: \n\n");

        for (Patient iPatient : patients) {
            sb.append("\t" + iPatient + "\n");
        }

        return new String(sb);
    }

    @Override
    public String toString() {
        return  "Role: Advisor, " + super.toString();
    }

}
