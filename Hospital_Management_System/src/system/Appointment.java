package system;

import java.util.Date;

import departments.Polyclinic;
import users.Doctor;
import users.Patient;

/**
 *
 * @author Buse Erbilgic
 */
public class Appointment implements Comparable<Appointment>
{
    private Polyclinic polyclinic;
    private Doctor doctor;
    private Patient patient;
    private Date date;
    private String prescription = "None";
    private String note = "No note";
    private boolean isTreated = false;
    

    public Appointment(Polyclinic polyclinic, Doctor doctor, Patient patient, Date date) {
        this.polyclinic = polyclinic;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }

    public Polyclinic getPolyclinic() {return polyclinic;}

    public void setPolyclinic(Polyclinic polyclinic) {this.polyclinic = polyclinic;}

    public Doctor getDoctor() {return doctor;}

    public void setDoctor(Doctor doctor) {this.doctor = doctor;}

    public Patient getPatient() {return patient;}

    public void setPatient(Patient patient) {this.patient = patient;}

    public String getNote() {return note;}

    public void setNote(String note) {this.note = note;}

    public Date getDate() {return date;}

    public void setDate(Date date) {this.date = date;}

    public String getPrescription() {return prescription;}

    public void setPrescription(String prescription) {this.prescription = prescription;}

    public void setDischarged(boolean discharged) {isTreated = discharged;}

    

    @Override
    public int compareTo(Appointment o) {
        if(date.getTime() > o.getDate().getTime())
            return 1;
        if(date.getTime() < o.getDate().getTime())
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "Appointment{" + "Polyclinic =" + polyclinic + ", Doctor =" + doctor + ", \n" +
        "patient=" + patient + ", note=" + note + ", date=" + date + ", \nprescription=" + prescription +'}';
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
        
        final Appointment other = (Appointment) obj;
        if (date == other.date && doctor.getId() == other.doctor.getId()) {
            return true;
        }
        return true;
    }

    
}
