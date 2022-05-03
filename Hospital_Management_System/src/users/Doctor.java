package users;


import java.io.IOException;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.UUID;

import system.Appointment;
import system.Prescription;

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
        // Company.appointmets.add(appointment);
    }

    public void displayPatientInfo(Patient patient) 
    {
        patient.displayPrescriptions();
        patient.displayDoctors();
        patient.displayRecords();
        
    }

    public boolean addAppointment(Appointment appo) throws IOException{
        appointments.offer(appo);
        // Company.appointmets.add(appointment);
        // Company.addAppointmentToDataBase(app);
        return true;
    }
    
    public void givePrescription(Patient patient, Prescription pres , String note) throws IOException{
        
        patient.addPrescription(pres);
        //Company.addAppointmentToDataBase(appo);
    }
    public void dischargePatient(Appointment appo , String note) throws IOException{
        appointments.peek().setDischarged(true);
        appointments.remove();
        //Company.addAppointmentToDataBase(appo);
    }
    
}
