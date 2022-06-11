package systems;
import tests.*;

import java.util.*;

import departments.*;
import users.*;
<<<<<<< HEAD
import util.*;
=======
import systems.*;
import tests.*;
import java.time.*;
>>>>>>> 69b98ad2f2db0fc070cfcb0a6178e27a4f50accf

/**
 * HMSystem is a class that contains all the data structures that are used in the program
 */
public class HMSystem 
{
    static public List<PriorityQueue<Appointment>> appointments = new ArrayList<>();
    static public List<Department> departments = new ArrayList<>();
    static public List<Patient> patients = new ArrayList<>();
    static public List<Worker> workers = new ArrayList<>();
    
    static public BinarySearchTree<User> users = new BinarySearchTree<>();

    static public Queue<Test> tests = new LinkedList<>();
    

    public void doctorMenu(Doctor doctor){
        Scanner sc = new Scanner(System.in);
        int input;
        boolean loop = true;

        System.out.println("\nSIGNED IN AS A DOCTOR\n\n");
        while(loop){
            System.out.println("CHOOSE AN OPTION BETWEEN 1 AND 8\n");
            System.out.println("1) Display Patient Info");
            System.out.println("2) Add Appointment for Patient");
            System.out.println("3) See Next Appointment");
            System.out.println("4) Give Prescription to Patient");
            System.out.println("5) Discharge Current Patient");
            System.out.println("6) Request Test From Patient");
            System.out.println("7) See All Appointments");
            System.out.println("8) Log out");

            input = sc.nextInt();

            if(input == 1){
                doctor.displayPatientInfo(doctor.getAppointment().getPatient());
            }
            else if(input == 2){
                doctor.addAppointment(new Appointment(new Polyclinic(), doctor, doctor.getAppointment().getPatient(), new Date()));
            }   //ERROR Date classi sikintili, appointmentin id'si yok(default 0), doctorun polyclinic'ine ulasamiyoruz 
            else if(input == 3){
                doctor.getAppointment().toString();
            }
            else if(input == 4){
                System.out.println("\nEnter Medicine Name for Patient : ");
                String med = sc.nextLine();
                System.out.println("\nEnter Instructions for Patient : ");
                String inst = sc.nextLine();
                System.out.println("\nEnter note for Patient : ");
                String note = sc.nextLine();
                doctor.givePrescription(doctor.getAppointment().getPatient(), new Prescription(med, inst, note), note);
            }
            else if(input == 5){
                doctor.dischargePatient(doctor.getAppointment(), "You are healthy!");
            }
            else if(input == 6){
                doctor.requestTest(doctor.getAppointment().getPatient(), new CovidTest(doctor.getAppointment().getPatient().getId()));
            }
            else if(input == 7){
                doctor.waitingPatients();
            }
            else if(input == 8){
                System.out.println("Exiting...");
                loop = false;
            }
            else{
                System.out.println("Entered Input is Wrong, Please Try Again");
            }
        }
        
    }
}