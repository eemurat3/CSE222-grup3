package systems;

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
    private String id = "";
    // Id eklencek
    

    public Appointment(Polyclinic polyclinic, Doctor doctor, Patient patient, Date date, String id) {
        this.polyclinic = polyclinic;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.id = id;
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

    public boolean getDischarged() {return isTreated;}

    public String getId() {return id;}

    public void setId(String newId) {id = newId;}


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
        "patient=" + patient + ", note =" + note + ", date=" + date + ", \n prescription=" + prescription +'}';
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

    public static void main(String[] args) {
    	Doctor dr1 = new Doctor("a","A","1",35,"aaa","aa");
    	Doctor dr2 = new Doctor("d","D","4",40,"ddd","dd");
    	Patient p1 = new Patient("b","B","2",20);
        Patient p2 = new Patient("f","F","6",20);
    	Polyclinic pol1 = new Polyclinic("c",3);
    	Polyclinic pol2 = new Polyclinic("e",5);
    	Date d = new Date();
        Date d2 = new Date();
    	
    	/* ---- Constructor Test ---- */
    	Appointment ap1 = new Appointment(pol1,dr1,p1,d,"123");
    	
    	System.out.println("Constructor Tests");
    	System.out.println(ap1.toString());
    	
    	/* ---- Modifying Test ---- */
    	ap1.setDoctor(dr2);
    	ap1.setPolyclinic(pol2);
        ap1.setPatient(p2);
        ap1.setPrescription("asdfgg");
        ap1.setNote("efgcsf");
        ap1.setDate(d2);
        ap1.setId("9");
    	
    	System.out.println("Modifying Tests");
    	System.out.println(ap1.toString());
    	
    }

    
}
