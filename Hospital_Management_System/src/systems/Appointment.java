package systems;

import java.util.Date;

import departments.Polyclinic;
import users.Doctor;
import users.Patient;

/**
 *
 * @author Buse Erbilgic
 */
/**
 * Appointment is a class that represents an appointment between a doctor and a patient.
 */
public class Appointment implements Comparable<Appointment>
{
    private Polyclinic polyclinic;
    private Doctor doctor;
    private Patient patient;
    private Date date;
    private String note = "No note";
    private boolean isTreated = false;
    private String id = "";
	private static Integer idcount = 0;
    

    /** 
    * A constructor.
    */
    public Appointment(Polyclinic polyclinic, Doctor doctor, Patient patient, Date date, String id) {
        this.polyclinic = polyclinic;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.id = idcount.toString();
        idcount++;
    }

    public Appointment(Polyclinic polyclinic, Doctor doctor, Patient patient, Date date) {
        this.polyclinic = polyclinic;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.id = idcount.toString();
        idcount++;
    }

    /**
     * Returns the polyclinic that this doctor works in.
     * 
     * @return The polyclinic object.
     */
    public Polyclinic getPolyclinic() {return polyclinic;}

    /**
     * This function sets the polyclinic of the doctor.
     * 
     * @param polyclinic The polyclinic that the doctor is working in.
     */
    public void setPolyclinic(Polyclinic polyclinic) {this.polyclinic = polyclinic;}

    /**
     * This function returns the doctor.
     * 
     * @return The doctor object.
     */
    public Doctor getDoctor() {return doctor;}

    /**
     * This function sets the doctor of the patient.
     * 
     * @param doctor The doctor that the patient is seeing.
     */
    public void setDoctor(Doctor doctor) {this.doctor = doctor;}

    /**
     * This function returns the patient.
     * 
     * @return The patient object.
     */
    public Patient getPatient() {return patient;}

    /**
     * This function sets the patient of the current object to the patient passed in as a parameter.
     * 
     * @param patient The patient object that is being updated.
     */
    public void setPatient(Patient patient) {this.patient = patient;}

    /**
     * This function returns the note.
     * 
     * @return The note variable is being returned.
     */
    public String getNote() {return note;}

    // Setting the note variable to the value of the note parameter.
    public void setNote(String note) {this.note = note;}

    /**
     * This function returns the date.
     * 
     * @return The date of the event.
     */
    public Date getDate() {return date;}

    /**
     * This function sets the date of the object to the date passed in.
     * 
     * @param date The date of the event.
     */
    public void setDate(Date date) {this.date = date;}


    /**
     * This function sets the value of the isTreated variable to the value of the discharged variable.
     * 
     * @param discharged boolean
     */
    public void setDischarged(boolean discharged) {isTreated = discharged;}

    /**
     * Returns true if the patient has been Treated, false otherwise.
     * 
     * @return isTreated
     */
    public boolean getDischarged() {return isTreated;}

    /**
     * It returns the id of the object.
     * 
     * @return The id of the object.
     */
    public String getId() {return id;}

    /**
     * This function sets the id variable to the value of the newId parameter.
     * 
     * @param newId The new ID of the object.
     */
    public void setId(String newId) {id = newId;}


    /**
     * If the date of the current object is greater than the date of the object passed in, return 1. If
     * the date of the current object is less than the date of the object passed in, return -1. If the
     * dates are equal, return 0
     * 
     * @param o The object to be compared.
     */
    @Override
    public int compareTo(Appointment o) {
        if(date.getTime() > o.getDate().getTime())
            return 1;
        if(date.getTime() < o.getDate().getTime())
            return -1;
        return 0;
    }

    /**
     * The toString() method returns a string representation of the object
     * @return The toString method is being returned.
     */
    @Override
    public String toString() {
        return "\n\t\t\tAppointment Informations" + "\nPolyclinic : \n\t" + polyclinic + "\nDoctor : \n\t" + doctor + 
        "\nPatient : \n\t" + patient + "\nNote : \n\t" + note + "\nDate : \n\t" + date;
    }
    
    /**
     * If the date and doctor id are the same, then the appointment is the same
     * @param obj The object to compare this instance with.
     */
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

    /**
     * The function creates a new appointment and then modifies the appointment's attributes
     */
    public static void main(String[] args) {
        System.out.print("\n\n\t\t\t APPOINTMENT UNIT TESTING STARTS \n\n");

    	Doctor dr1 = new Doctor("a","A","1",35,"aaa","aa");
    	Doctor dr2 = new Doctor("d","D","4",40,"ddd","dd");
    	Patient p1 = new Patient("b","B","2",20);
        Patient p2 = new Patient("f","F","6",20);
    	Polyclinic pol1 = new Polyclinic("c",3);
    	Polyclinic pol2 = new Polyclinic("e",5);
    	Date d = new Date();
        Date d2 = new Date();
    	
        System.out.println("------------ Test of Appointment Class ---------------");
    	/* ---- Constructor Test ---- */
    	Appointment ap1 = new Appointment(pol1,dr1,p1,d,"123");
    	
    	System.out.println("Constructor Tests");
    	System.out.println(ap1.toString());
    	
    	/* ---- Modifying Test ---- */
    	ap1.setDoctor(dr2);
    	ap1.setPolyclinic(pol2);
        ap1.setPatient(p2);
        ap1.setNote("efgcsf");
        ap1.setDate(d2);
        ap1.setId("9");
    	
    	System.out.println("Modifying Tests");
    	System.out.println(ap1.toString());
        System.out.print("\n\n\t\t\t APPOINTMENT UNIT TESTING ENDS \n\n");
    	
    }
}
