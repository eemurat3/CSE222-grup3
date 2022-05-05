package src;

import java.util.*;

public class Advisor extends Worker {
    
    PriorityQueue<Patient> patients = new PriorityQueue<>();

	public Advisor(String name, String surname, String id, int age, String username, String password) {
        super(name, surname, id, age, username, password);
    }

    public boolean addPatient(Patient nextPatient) {
        
        for (Patient iPatient : patients)
            if (iPatient.getId() == nextPatient.getId())
                return false;

        patients.add(nextPatient);
        return true;
    }

    public boolean removePatient(Patient nextPatient) {
        return patients.remove(nextPatient);
    }

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
