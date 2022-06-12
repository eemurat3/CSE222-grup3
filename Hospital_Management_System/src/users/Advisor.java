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
    
  
    private boolean addAppointment(Doctor doctor,Appointment appointment){
        //Add to doctor's appointments
        doctor.addAppointment(appointment);

        //Add to patient's appointments
        appointment.getPatient().addAppointment(appointment);

        //TODO Add to HMSystem appointments
        HMSystem.appointments.add(appointment);

        //Add to Reception class appointments
        Reception reception = (Reception) getDepartment();
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
        return  "Role: Advisor, " + super.toString();
    }

    public void ADVMenu(Advisor adv){
        Scanner sc = new Scanner(System.in);
        int input;
        boolean loop = true;

        System.out.println("\nSIGNED IN AS AN ADVISORY STAFF\n\n");

        while(loop){
            System.out.println("CHOOSE AN OPTION BETWEEN 1 AND 4\n");
            System.out.println("1) Make Appointment");
            System.out.println("2) Make Appointment");
            System.out.println("3) Display List of Doctors");
            System.out.println("4) Log Out");
            
            input = sc.nextInt();

            if(input == 1){

            }
            if(input == 2){
                System.out.println("\nEnter Polyclinic Department ID: ");
                String pol = sc.nextLine();
                Polyclinic polyclinic;
                System.out.println("\nEnter Doctor ID: ");
                String doc = sc.nextLine();
                Doctor doctor 
                System.out.println("\nEnter the Date: ");
                String dte = sc.nextLine();
                Date date;

                Appointment apt = new Appointment(polyclinic, doctor, patient, date);
                adv.addAppointment(doctor, apt);
            }
            if(input == 3){
                adv.displayDoctorList();
            }
            if(input == 4){
                System.out.println("Exiting...");
                loop = false;
            }
            else{
                System.out.println("Invalid input, try again!\n");
            }
        }


    }

}
