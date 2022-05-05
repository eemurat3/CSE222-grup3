package users;

import java.util.*;

public class Advisor extends Worker {
    

    PriorityQueue<Patient> patients = new PriorityQueue<>();

	public Advisor(String name, String surname, String id, int age, String username, String password) {
        super(name, surname, id, age, username, password);
    }

    public void addPatient(Patient nextPatient) {
        patients.add(nextPatient);
    }

    public void removePatient(Patient nextPatient) {
        patients.remove(nextPatient);
    }

}
