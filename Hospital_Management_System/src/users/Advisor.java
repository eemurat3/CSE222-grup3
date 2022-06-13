package users;

import java.util.*;

import departments.Reception;
import systems.Appointment;
import systems.HMSystem;

/**
 * It's a class that extends the Worker class and adds a priority queue of patients.
 */
public class Advisor extends Worker {

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

    public boolean addPatient(String name,String surname,String id,int age) {
        HMSystem.users.add(new Patient(name, surname, id, age));
        return true;
    }
    
  
    public boolean addAppointment(Doctor doctor,Appointment appointment){
        //Add to doctor's appointments
        doctor.addAppointment(appointment);

        //Add to patient's appointments
        appointment.getPatient().addAppointment(appointment);

        //Add to HMSystem appointments
        HMSystem.appointments.add(appointment);

        //Add to Reception class appointments
        Reception reception = new Reception(getDepartment().getName(), getDepartment().getId());
        reception.addAppointment(appointment);

        return false;
    }

    /**
     * This function takes the patients in the queue and displays them in a string
     * 
     * @return A string of the patients in the queue.
     */
    public List<Doctor> displayDoctorList() {
        ArrayList<Doctor> doctors = new ArrayList<>();

        for(Worker w :HMSystem.workers){
            if(w instanceof Doctor){
                doctors.add((Doctor) w);
            }
        }

        return doctors;
    }

    /**
     * The toString() method returns a string representation of the object
     * @return The role of the advisor and the super class toString method.
     */
    @Override
    public String toString() {
        return  super.toString();
    }

}
