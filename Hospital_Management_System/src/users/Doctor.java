package users;


import java.io.IOException;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.UUID;

import systems.Appointment;
import systems.Prescription;



/**
 *
 * @author Ahmet Usluoglu
 */
public class Doctor extends Worker
{
 
    private PriorityQueue<Appointment> appointments;

    public Doctor(String name, String surname, String id, int age,String email , String password) 
    {
        super(name, surname, id, age, email ,  password);
        appointments = new PriorityQueue<>();
        // HMSystem.appointmets.add(appointment);
    }

    public void displayPatientInfo(Patient patient) 
    {
        patient.displayPrescriptions();
        patient.displayDoctors();
        patient.displayRecords();
        
    }

    public boolean addAppointment(Appointment appo) {
        appointments.offer(appo);
        // HMSystem.appointmets.add(appointment);
        // HMSystem.addAppointmentToDataBase(app);
        return true;
    }
    
    public void givePrescription(Patient patient, Prescription pres , String note) {
        
        pres.setNote(note);
        patient.addPrescription(pres);
        //HMSystem.addAppointmentToDataBase(appo);
    }
   
    public void dischargePatient(Appointment appo , String note) {
        appo.setNote(note);
        appointments.peek().setDischarged(true);
        appointments.remove();
        //HMSystem.addAppointmentToDataBase(appo);
    }


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

    public static void main(String[] args) 
    {
        Doctor dr1 = new Doctor("name", "surname", "id", 30, "email", "password");
        System.out.print("\n");
        System.out.print(dr1);
    }

    public void waitingPatients() {
        for (Appointment item : appointments) {
            System.out.println(item.getPatient().getName());
        }
    }
    
}
