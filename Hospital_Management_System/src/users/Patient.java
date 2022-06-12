package users;

import java.util.ArrayList;

import departments.*;
import systems.*;
import tests.*;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Muhammed Akif Sevilgen
 * Patient Class Extends User class.
 */
public class Patient extends User
{
    private ArrayList<Test> tests = new ArrayList<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private ArrayList<Prescription> prescriptions = new ArrayList<>();
    private boolean discharged = false;

    // Creating a constructor for the Patient class.
    public Patient(String name, String surname, String id, int age) {
        super(name, surname, id, age);
    }


    //DISCHARGED

    /**
     * This function returns a boolean value that indicates whether the patient has been discharged or
     * not
     * 
     * @return The boolean value of discharged.
     */
    public boolean isDischarged() {
        return discharged;
    }

    /**
     * This function sets the value of the discharged variable to the value of the discharged parameter
     * 
     * @param discharged boolean
     */
    public void setDischarged(boolean discharged) {
        this.discharged = discharged;
    }

    // TEST 

    /**
     * This function returns an ArrayList of Test objects
     * 
     * @return The tests arraylist.
     */
    public ArrayList<Test> getTests() {
        return tests;
    }

    /**
     * This function sets the tests variable to the tests parameter
     * 
     * @param tests An ArrayList of Test objects.
     */
    public void setTests(ArrayList<Test> tests) {
        this.tests = tests;
    }

    /**
     * This function adds a test to the list of tests
     * 
     * @param test The test to add to the list of tests.
     */
    public void addTest(Test test){
        if(test == null)
            throw new NullPointerException();

        tests.add(test);
    }

    // APPOINTMENT

    /**
     * This function returns an ArrayList of Appointment objects
     * 
     * @return The appointments arraylist is being returned.
     */
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * This function sets the appointments of the current object to the appointments passed in as a
     * parameter
     * 
     * @param appointments ArrayList of Appointment objects
     */
    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    /**
     * This function adds an appointment to the list of appointments
     * 
     * @param app The appointment to be added to the list.
     */
    public void addAppointment(Appointment app){
        if(app == null)
            throw new NullPointerException();
        appointments.add(app);
    }

    //Prescriptions

    /**
     * This function returns an ArrayList of Prescription objects
     * 
     * @return The ArrayList of Prescriptions.
     */
    public ArrayList<Prescription> getPrescriptions() {
        return prescriptions;
    }

    /**
     * This function sets the prescriptions of a patient
     * 
     * @param prescriptions ArrayList of Prescription objects
     */
    public void setPrescriptions(ArrayList<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    /**
     * This function adds a prescription to the list of prescriptions
     * 
     * @param pres Prescription
     */
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

    /**
     * This function takes the prescriptions arraylist and displays it in a numbered list
     * 
     * @return The string builder is being returned.
     */
    public String displayPrescriptions(){
        StringBuilder strB = new StringBuilder();
        for(int i = 0 ; i < prescriptions.size() ; i++){
            strB.append((i+1) + ": " + prescriptions.get(i)).append("\n");
        }
        return strB.toString();
    }

    
    /**
     * It loops through the workers arraylist and checks if the current worker is a doctor, if so it
     * adds it to the list
     * 
     * @return An ArrayList of Doctor objects.
     */
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
        System.out.print("\n\n\t\t\t PATIENT TESTING STARTS \n\n");
    
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
            tests.add(new BloodTest("1","2353452354"));
            tests.add(new BloodTest("23","32342"));
            tests.add(new BloodTest("234","2312321"));
            tests.add(new CovidTest("3454","3453453"));
            tests.add(new CovidTest("323","234243234"));
            tests.add(new CovidTest("234423","4565345"));
            tests.add(new RadiologicalTest("56756","2341234"));
            tests.add(new RadiologicalTest("345","235235"));
            tests.add(new RadiologicalTest("34535","2342315"));

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

            pat1.addTest(new BloodTest("1","2353452354"));
            pat1.addTest(new CovidTest("323","234243234"));
            pat1.addTest(new RadiologicalTest("34535","2342315"));


            System.out.println("tests of patient pat1 is returned to returned_tests\n");
            returned_tests = pat1.getTests();

            System.out.println("returned_tests:");
            for (int i = 0 ; i < returned_tests.size() ; i++) {
                System.out.println((i+1) + ": " + returned_tests.get(i).toString());
            }

            System.out.println("\n");

        /********************************* APPOINTMENT ***************************************/

            System.out.println("\nTesting Appointments related methods \n");

            Polyclinic poly = new Polyclinic("dsfdsff",2342);
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
            prescriptions.add(new Prescription("234234","234234111","medicine1", "instructions1", "note1"));
            prescriptions.add(new Prescription("2342234","21321311123","medicine2", "instructions2", "note2"));
            prescriptions.add(new Prescription("2342111","5555","medicine3", "instructions3", "note3"));
            prescriptions.add(new Prescription("2222","11111","medicine4", "instructions4", "note4"));

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

            prescriptions.add(new Prescription("12111","23235","medicine5", "instructions5", "note5"));
            prescriptions.add(new Prescription("11231","3333","medicine6", "instructions6", "note6"));


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
        System.out.print("\n\n\t\t\t PATIENT TESTING ENDS \n\n");

    }

    
    
}
