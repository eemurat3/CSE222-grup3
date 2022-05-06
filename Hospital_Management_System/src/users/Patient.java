package users;

import java.sql.Date;
import java.util.ArrayList;

import departments.*;
import systems.*;
import tests.*;
import java.util.Date;

public class Patient extends User
{
    private ArrayList<Test> tests = new ArrayList<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private ArrayList<Prescription> prescriptions = new ArrayList<>();
    private boolean discharged = false;

    public Patient(String name, String surname, String id, int age) {
        super(name, surname, id, age);
    }
    /*DISCHARGED*/ 
    public boolean isDischarged() {
        return discharged;
    }

    public void setDischarged(boolean discharged) {
        this.discharged = discharged;
    }

    /* TEST */
    public ArrayList<Test> getTests() {
        return tests;
    }

    public void setTests(ArrayList<Test> tests) {
        this.tests = tests;
    }

    public void addTest(Test test){
        if(test == null)
            throw new NullPointerException();

        tests.add(test);
    }

    /* APPOINTMENT */
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void addAppointment(Appointment app){
        if(app == null)
            throw new NullPointerException();
        appointments.add(app);
    }

    /* PRESCRIPTION */
    public ArrayList<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(ArrayList<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public void addPrescription(Prescription pres){
        if(pres == null)
            throw new NullPointerException();
        prescriptions.add(pres);
    }

    /* DISPLAYS */
    public String displayRecords(){
        StringBuilder strB = new StringBuilder();
        for(int i = 0 ; i < appointments.size() ; i++){
            strB.append((i+1) + ": " + appointments.get(i)).append("\n");
        }
        return strB.toString();
    }

    public String displayPrescriptions(){
        StringBuilder strB = new StringBuilder();
        for(int i = 0 ; i < prescriptions.size() ; i++){
            strB.append((i+1) + ": " + prescriptions.get(i)).append("\n");
        }
        return strB.toString();
    }

    
    public ArrayList<Doctor> displayDoctors(){
        ArrayList<Doctor> list = new ArrayList<>();
        for(int i = 0 ; i < HMSystem.workers.size() ; i++){
            if(HMSystem.workers.get(i) instanceof Doctor)
                list.add((Doctor)HMSystem.workers.get(i));
        }
        return list;
    }

    @Override
    public int compareTo(User other) {
        return super.compareTo(other);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    // Driver code
    public static void main(String args[])
    {
    
        /********************************* Constructor ******************************************/

            System.out.println("\nTesting Constructor \n");

            Patient pat1 = new Patient("a", "A", "1", 10);
            Patient pat2 = new Patient("b", "B", "2", 20);
            Patient pat3 = new Patient("c", "C", "3", 30);
            Patient pat4 = new Patient("d", "D", "4", 40);
            Patient pat5 = new Patient("e", "E", "5", 50);

            System.out.println(pat1.toString());
            System.out.println(pat2.toString());
            System.out.println(pat3.toString());
            System.out.println(pat4.toString());
            System.out.println(pat5.toString());

            System.out.println("\n");

        /********************************* Discharged ******************************************/
            
            System.out.println("\nTesting Discharged related methods \n");

            System.out.println("pat1.isDischarged(): " + pat1.isDischarged());
            pat1.setDischarged(true);
            System.out.println("pat1 set as discharged");
            System.out.println("pat1.isDischarged(): " + pat1.isDischarged());
            pat1.setDischarged(false);
            System.out.println("pat1 set as not discharged");
            System.out.println("pat1.isDischarged(): " + pat1.isDischarged());

            System.out.println("\n");

        /********************************** TEST ********************************************/

            System.out.println("\nTesting Tests related methods \n");

            ArrayList<Test> tests = new ArrayList<Test>();
            tests.add(new BloodTest("1"));
            tests.add(new BloodTest("1"));
            tests.add(new BloodTest("1"));
            tests.add(new CovidTest("1"));
            tests.add(new CovidTest("1"));
            tests.add(new CovidTest("1"));
            tests.add(new RadiologicalTest("1"));
            tests.add(new RadiologicalTest("1"));
            tests.add(new RadiologicalTest("1"));

            System.out.println("tests:");
            for (int i = 0 ; i < tests.size() ; i++) {
                System.out.println((i+1) + ": " + tests.get(i).toString());
            }

            System.out.println("\ntests setted as tests of patient pat1\n");
            pat1.setTests(tests);
            System.out.println("tests of patient pat1 is returned to returned_tests\n");
            ArrayList<Test> returned_tests = pat1.getTests();

            System.out.println("returned_tests:");
            for (int i = 0 ; i < returned_tests.size() ; i++) {
                System.out.println((i+1) + ": " + returned_tests.get(i).toString());
            }

            System.out.println("\nfew tests added to tests of patient pat1\n");

            pat1.addTest(new BloodTest("1"));
            pat1.addTest(new CovidTest("1"));
            pat1.addTest(new RadiologicalTest("1"));


            System.out.println("tests of patient pat1 is returned to returned_tests\n");
            returned_tests = pat1.getTests();

            System.out.println("returned_tests:");
            for (int i = 0 ; i < returned_tests.size() ; i++) {
                System.out.println((i+1) + ": " + returned_tests.get(i).toString());
            }

            System.out.println("\n");

        /********************************* APPOINTMENT ***************************************/

            System.out.println("\nTesting Appointments related methods \n");

            Polyclinic poly = new Polyclinic();
            Doctor doc = new Doctor("doc_n", "doc_sn", "doc_id", 999, "doc_m", "doc_p");

            ArrayList<Appointment> appointments = new ArrayList<Appointment>();
            appointments.add(new Appointment(poly, doc, pat1, new Date(), "1"));
            appointments.add(new Appointment(poly, doc, pat1, new Date(), "2"));
            appointments.add(new Appointment(poly, doc, pat1, new Date(), "3"));
            appointments.add(new Appointment(poly, doc, pat1, new Date(), "4"));

            System.out.println("appointments:");
            for (int i = 0 ; i < appointments.size() ; i++) {
                System.out.println((i+1) + ": " + appointments.get(i).toString());
            }

            System.out.println("\nappointments setted as appointments of patient pat1\n");
            pat1.setAppointments(appointments);
            System.out.println("appointments of patient pat1 is returned to returned_appointments\n");
            ArrayList<Appointment> returned_appointments = pat1.getAppointments();

            System.out.println("returned_appointments:");
            for (int i = 0 ; i < returned_appointments.size() ; i++) {
                System.out.println((i+1) + ": " + returned_appointments.get(i).toString());
            }

            System.out.println("\nfew appointments added to appointments of patient pat1\n");

            appointments.add(new Appointment(poly, doc, pat1, new Date(), "5"));
            appointments.add(new Appointment(poly, doc, pat1, new Date(), "6"));


            System.out.println("appointments of patient pat1 is returned to returned_appointments\n");
            returned_appointments = pat1.getAppointments();

            System.out.println("returned_appointments:");
            for (int i = 0 ; i < returned_appointments.size() ; i++) {
                System.out.println((i+1) + ": " + returned_appointments.get(i).toString());
            }

            /* testing displayRecords */
            System.out.println("\npat1.displayRecords(): \n" + pat1.displayRecords());

            System.out.println("\n");
                
        /********************************* PRESCRIPTION ********************************/

            System.out.println("\nTesting Prescriptions related methods \n");

            ArrayList<Prescription> prescriptions = new ArrayList<Prescription>();
            prescriptions.add(new Prescription("medicine1", "instructions1", "note1"));
            prescriptions.add(new Prescription("medicine2", "instructions2", "note2"));
            prescriptions.add(new Prescription("medicine3", "instructions3", "note3"));
            prescriptions.add(new Prescription("medicine4", "instructions4", "note4"));

            System.out.println("prescriptions:");
            for (int i = 0 ; i < prescriptions.size() ; i++) {
                System.out.println((i+1) + ": " + prescriptions.get(i).toString());
            }

            System.out.println("\nprescriptions setted as prescriptions of patient pat1\n");
            pat1.setPrescriptions(prescriptions);
            System.out.println("prescriptions of patient pat1 is returned to returned_prescriptions\n");
            ArrayList<Prescription> returned_prescriptions = pat1.getPrescriptions();

            System.out.println("returned_prescriptions:");
            for (int i = 0 ; i < returned_prescriptions.size() ; i++) {
                System.out.println((i+1) + ": " + returned_prescriptions.get(i).toString());
            }

            System.out.println("\nfew prescriptions added to prescriptions of patient pat1\n");

            prescriptions.add(new Prescription("medicine5", "instructions5", "note5"));
            prescriptions.add(new Prescription("medicine6", "instructions6", "note6"));


            System.out.println("prescriptions of patient pat1 is returned to returned_prescriptions\n");
            returned_prescriptions = pat1.getPrescriptions();

            System.out.println("returned_prescriptions:");
            for (int i = 0 ; i < returned_prescriptions.size() ; i++) {
                System.out.println((i+1) + ": " + returned_prescriptions.get(i).toString());
            }

            /* testing displayPrescriptions */
            System.out.println("\npat1.displayPrescriptions(): \n" + pat1.displayPrescriptions());


            System.out.println("\n");

        /*********************************** DISPLAYS *************************************/

            System.out.println("\nTesting displayDoctors \n");

            ArrayList<Doctor> docs = pat1.displayDoctors();

            System.out.println("\npat1.displayDoctors(): \n");
            for (int i = 0 ; i < docs.size() ; i++) {
                System.out.println((i+1) + ": " + docs.get(i).toString());
            }

            System.out.println("\nDoctor added");

            HMSystem.workers.add(new Doctor("doc_n1", "doc_sn", "doc_id", 999, "doc_m", "doc_p"));

            docs = pat1.displayDoctors();

            System.out.println("\npat1.displayDoctors(): \n");
            for (int i = 0 ; i < docs.size() ; i++) {
                System.out.println((i+1) + ": " + docs.get(i).toString());
            }

            System.out.println("\nDoctor added");

            HMSystem.workers.add(new Doctor("doc_n2", "doc_sn", "doc_id", 999, "doc_m", "doc_p"));

            docs = pat1.displayDoctors();

            System.out.println("\npat1.displayDoctors(): \n");
            for (int i = 0 ; i < docs.size() ; i++) {
                System.out.println((i+1) + ": " + docs.get(i).toString());
            }

            System.out.println("\nDoctor removed");

            HMSystem.workers.remove(0);

            docs = pat1.displayDoctors();

            System.out.println("\npat1.displayDoctors(): \n");
            for (int i = 0 ; i < docs.size() ; i++) {
                System.out.println((i+1) + ": " + docs.get(i).toString());
            }

            System.out.println("\n");
                
        /************************************** Override ************************************/

            System.out.println("\nTesting Override related methods \n");

            System.out.println("\nTesting compareTo\n");

            System.out.println("pat1.compareTo(pat2): " + pat1.compareTo(pat2));
            System.out.println("pat2.compareTo(pat1): " + pat2.compareTo(pat1));
            System.out.println("pat1.compareTo(pat1): " + pat1.compareTo(pat1));
            System.out.println("pat2.compareTo(pat2): " + pat1.compareTo(pat1));

            System.out.println("\nTesting toString\n");

            System.out.println("pat1.toString(): " + pat1.toString());
            System.out.println("pat2.toString(): " + pat2.toString());
            System.out.println("pat3.toString(): " + pat3.toString());
            System.out.println("pat4.toString(): " + pat4.toString());

        /**********************************************************************************/
    }
}
