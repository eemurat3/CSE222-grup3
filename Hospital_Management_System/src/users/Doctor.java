package users;


import java.io.IOException;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.UUID;

import departments.Polyclinic;
import systems.Appointment;
import systems.Prescription;
import tests.BloodTest;
import tests.Test;



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

    public Appointment getAppointment()
    {
        return appointments.peek();
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

    public void requestTest(Patient patient, Test test)
    {
        patient.addTest(test);
    }

    public void waitingPatients() {
        for (Appointment item : appointments) {
            System.out.println(item.getPatient().getName());
        }
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
        System.out.print("\n\n\t\t\t DOCTOR UNIT TESTING STARTS \n\n");
        Doctor dr1 = new Doctor("name", "surname", "id", 30, "email", "password");
        System.out.print("\n");
        System.out.print("Doctor 1 created = "+dr1 + "\n");

        PriorityQueue<Appointment> appoints = new PriorityQueue<>();
        Appointment appo1 = new Appointment(new Polyclinic("Radiology",7), dr1, new Patient("name", "surname", "id", 30), new Date(), "11111");
        System.out.println("\nAppointment 1 created = "+appo1);
        dr1.addAppointment(appo1);
        System.out.println("\nAppointment 1 added to doctor 1 = "+dr1.appointments);

        dr1.displayPatientInfo(dr1.getAppointment().getPatient());
        System.out.println("\nFirst patient at appointment list is shown = "+dr1.getAppointment().getPatient());

        dr1.givePrescription(dr1.getAppointment().getPatient(), new Prescription("newMed", "newInst", "newNote"), "Additional note");
        System.out.println("\nAdded Prescription to the patient at the top of the list = "+dr1.getAppointment().getPatient().displayPrescriptions());
        
        dr1.requestTest(dr1.getAppointment().getPatient(), new BloodTest());
        System.out.println("\nBloodtest requested from patient = "+dr1.getAppointment().getPatient().getTests());

        dr1.dischargePatient(appo1, "note");
        System.out.println("\nPatient Discharged = "+dr1.appointments);

        long start = System.nanoTime(); 
        for(int i = 0; i < 100; i++)
        {
            appo1 = new Appointment(new Polyclinic("Radiology",7), dr1, new Patient("name"+ i, "surname" + i, "id" + i, 30), new Date(), "11111" + i);
            dr1.addAppointment(appo1);
        }
        long end1 = System.nanoTime(); 
        long sum = (end1 - start);
        
        System.out.println("\nAdded 100 appointments to doctor 1 = " + sum/1000 + "ns");

        dr1.appointments.clear();

        start = System.nanoTime(); 
        for(int i = 0; i < 1000; i++)
        {
            appo1 = new Appointment(new Polyclinic("Radiology",7), dr1, new Patient("name"+ i, "surname" + i, "id" + i, 30), new Date(), "11111" + i);
            dr1.addAppointment(appo1);
        }
        end1 = System.nanoTime(); 
        sum = (end1 - start);
        
        System.out.println("\nAdded 1000 appointments to doctor 1 = " + sum/1000 + "ns");

        dr1.appointments.clear();

        start = System.nanoTime(); 
        for(int i = 0; i < 10000; i++)
        {
            appo1 = new Appointment(new Polyclinic("Radiology",7), dr1, new Patient("name"+ i, "surname" + i, "id" + i, 30), new Date(), "11111" + i);
            dr1.addAppointment(appo1);
        }
        end1 = System.nanoTime(); 
        sum = (end1 - start);
        
        System.out.println("\nAdded 10000 appointments to doctor 1 = " + sum/1000 + "ns");
        
        
        System.out.print("\n\n\t\t\t DOCTOR UNIT TESTING ENDS \n\n");

    }

}
