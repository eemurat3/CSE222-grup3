package systems;
import tests.*;

import java.util.*;

import departments.*;
import users.*;
import util.*;
import systems.*;
import tests.*;
import java.time.*;

/**
 * HMSystem is a class that contains all the data structures that are used in the program
 */
public class HMSystem 
{
    static public List<Appointment> appointments = new ArrayList<>();
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
                //TODO patient parametresi 
                doctor.addAppointment(new Appointment((Polyclinic) doctor.getDepartment(), doctor, new Patient("name","surname","002",12), new Date()));
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
                //TODO Generate prescription id
                doctor.givePrescription("234","23412",med,inst,note);
            }
            else if(input == 5){
                doctor.dischargePatient(doctor.getAppointment(), "You are healthy!");
            }
            else if(input == 6){
                //TODO select technician ID
                //TODO select patient
                //TODO generate test id
                doctor.requestTest("2133", new CovidTest("234","234"));
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

    public void ADVMenu(Advisor adv){
        Scanner sc = new Scanner(System.in);
        int count = 15;
        int input;
        boolean loop = true, loop2 = true;

        System.out.println("\nSIGNED IN AS AN ADVISORY STAFF\n\n");

        while(loop){
            System.out.println("CHOOSE AN OPTION\n");
            System.out.println("1) Register New Patient");
            System.out.println("2) Make Appoinment to Existed Patient");
            System.out.println("3) Display Doctors");
            System.out.println("4) Log Out");
            
            input = sc.nextInt();
            if(input == 1){
                Patient nPatient = new Patient("x","y",Integer.toString(count),count++);
                patients.add(nPatient);
                loop2 = true;
                while(loop2){    
                    System.out.println("1) Display Doctors");
                    System.out.println("2) Make Appoinment");
                    input = sc.nextInt();

                    if(input == 2){
                        System.out.println("\nEnter Doctor ID: ");
                        sc.nextLine();
                        String doc = sc.nextLine();     
                        Doctor d = (Doctor) returnUser(doc, workers);
                        Appointment apt = new Appointment((Polyclinic)(d).getDepartment(),d, nPatient, new Date());
                        adv.addAppointment(d, apt);
                        loop2 = false;
                    }
                    else if(input == 1){
                        System.out.println(adv.displayDoctorList());
                    }
                    else{
                        System.out.println("Invalid input, try again!\n");
                    }
                }
            }
            else if(input == 2){
                System.out.println("\nEnter Patient ID: ");
                sc.nextLine();
                String pt = sc.nextLine();   
                Patient patient = (Patient) returnUser(pt, patients);

                System.out.println("\nEnter Doctor ID: ");
                String doc = sc.nextLine();     
                Doctor d = (Doctor) returnUser(doc, workers);

                Appointment apt = new Appointment((Polyclinic)(d).getDepartment(),d, patient, new Date());
                adv.addAppointment(d, apt);
            }
            else if(input == 3){
                System.out.println(adv.displayDoctorList());
            }
            else if(input == 4){
                System.out.println("Exiting...");
                loop = false;
            }
            else{
                System.out.println("Invalid input, try again!\n");
            }
        }

        sc.close();
    }

    // A generic method that returns an object from a list.
    public <E> E returnUser(String ID, List<E> list){
        for(int i = 0; i < list.size(); i++){
            if(((User) list.get(i)).getId().compareTo(ID) == 0){
                return list.get(i);
            }
        }
        return null;
    }



}