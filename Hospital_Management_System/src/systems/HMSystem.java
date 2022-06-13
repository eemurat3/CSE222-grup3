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
    static public SkipList<Patient> patients = new SkipList<Patient>();
    static public List<Worker> workers = new ArrayList<>();
    static public BinarySearchTree<User> users = new BinarySearchTree<>();
    static public Queue<Test> tests = new LinkedList<>();
    static public HashMap<String,Worker> wMap = new HashMap<>();
    static public HashMap<String,Patient> pMap = new HashMap<>();
    
    public void addAlltoWMap()
    {
        for (var item : workers) {
            wMap.put(item.getUsername(), item);
        }
    }

    public void addAlltoPMap()
    {
        for (var item : patients) {
            pMap.put(item.getId(),item);
        }
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

    public Patient returnPatient(String ID, SkipList<Patient> skiplist){
        Iterator<Patient> it = skiplist.iterator();
        Patient current;

        while(it.hasNext()){
            current = (Patient) it.next();

            if(current.getId().equals(ID))
                return current;

        }
        
        return null;
    }


    public ArrayList<Polyclinic> polycList()
    {
        ArrayList<Polyclinic> pList = new ArrayList<>();
        for (var item : departments) {
            if(item.getClass() == Polyclinic.class)
                pList.add((Polyclinic)item);
        }
        return pList;
    }

    public void doctorMenu(Doctor doctor){
        Scanner sc = new Scanner(System.in);
        int input;
        boolean loop = true;


        System.out.println("\nSIGNED IN AS A DOCTOR\n\n");
        while(loop){
            System.out.println("\nCHOOSE AN OPTION BETWEEN 1 AND 8\n");
            System.out.println("1) Display Patient Info");
            System.out.println("2) Add Appointment for Patient");
            System.out.println("3) See Current Appointment Information");
            System.out.println("4) Create Prescription and Give it to Secreter");
            System.out.println("5) Discharge Current Patient");
            System.out.println("6) Request Test From Patient");
            System.out.println("7) See All Appointments");
            System.out.println("8) Log out");

            input = sc.nextInt();
            System.out.println("\n");

            if(input == 1){
                doctor.displayPatientInfo(doctor.getAppointment().getPatient());
            }
            else if(input == 2){
                doctor.addAppointment(new Appointment((Polyclinic) doctor.getDepartment(), doctor, doctor.getAppointment().getPatient(), new Date()));
            }    
            else if(input == 3){        
                System.out.println(doctor.getAppointment().toString());
            }
            else if(input == 4){
                sc.nextLine();
                System.out.println("\nEnter Medicine Name for Patient : ");
                String med = sc.next();
                System.out.println("\nEnter Instructions for Patient : ");
                String inst = sc.next();
                System.out.println("\nEnter note for Patient : ");
                String note = sc.next();
                doctor.givePrescription("0",doctor.getAppointment().getPatient().getId(),med,inst,note);
            }
            else if(input == 5){
                doctor.dischargePatient(doctor.getAppointment(), "You are healthy!");
            }
            else if(input == 6){
                //TODO select technician ID
                doctor.requestTest("2133", new CovidTest(doctor.getAppointment().getPatient().getId(),"0"));
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
                System.out.println("Enter Patient's Name: \n");
                String name = sc.next();
                System.out.println("Enter Patient's Surname: \n");
                String surname = sc.next();
                System.out.println("Enter Patient's ID: \n");
                String id = sc.next();
                System.out.println("Enter Patient's Age: \n");
                int age = sc.nextInt();

                Patient nPatient = new Patient(name,surname,id,age);
                patients.add(nPatient);
                loop2 = true;
                while(loop2){    
                    System.out.println("\n1) Display Doctors");
                    System.out.println("2) Make Appoinment");
                    input = sc.nextInt();

                    if(input == 2){
                        System.out.println("\nEnter Doctor ID: ");
                        sc.nextLine();
                        String doc = sc.next();     
                        Doctor d = (Doctor) returnUser(doc, workers);
                        Appointment apt = new Appointment((Polyclinic)(d).getDepartment(),d, nPatient, new Date(),"ID");
                        adv.addAppointment(d, apt);
                        appointments.add(apt);
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
                String pt = sc.next(); 
                sc.nextLine();  
                Patient patient = returnPatient(pt, patients); 

                System.out.println("\nEnter Doctor ID: ");
                String doc = sc.next();     
                Doctor d = (Doctor) returnUser(doc, workers);

                Appointment apt = new Appointment((Polyclinic)(d).getDepartment(),d, patient, new Date(),"ID");
                adv.addAppointment(d, apt);
            }
            else if(input == 3){
                System.out.println(adv.displayDoctorList());
            }
            else if(input == 4){
                System.out.println("\nExiting...");
                loop = false;
            }
            else{
                System.out.println("\nInvalid input, try again!\n");
            }
        }
    }

    public void NurseMenue(Nurse nurse){
        Scanner sc = new Scanner(System.in);
        int input;
        boolean loop = true;

        System.out.println("\nSIGNED IN AS A NURSE\n\n");

        while(loop){
            System.out.println("Enter Patient ID | Enter -1 to Log Out\n");
            String id = sc.next();
            Patient patient = returnPatient(id, patients); 
            if(id.compareTo("-1") == 0){
                System.out.println("Exiting...");
                break;
            }

            if(patient == null){
                System.out.println("Invalid ID, try again!\n");
                continue;
            }
            else{    
                while(true){    
                    System.out.println("CHOOSE AN OPTION\n");
                    System.out.println("1) Update Patient Info");
                    System.out.println("2) Display Patient Info");
                    System.out.println("3) Display Patient Prescriptions");
                    System.out.println("4) Display Patient Appointments");
                    System.out.println("5) Display Patient Tests");
                    System.out.println("6) Log Out");
                    
                    input = sc.nextInt();
                    if(input == 1){
                        System.out.println("CHOOSE A DATA TO UPDATE\n");
                        System.out.println("1) Name ");
                        System.out.println("2) Surname ");
                        System.out.println("3) ID ");
                        System.out.println("4) Age ");
                        input = sc.nextInt();
                        if(input == 1){
                            sc.nextLine();
                            System.out.print("Enter The new Name: ");
                            String name = sc.next();
                            patient.setName(name);

                        }
                        else if(input == 2){
                            sc.nextLine();
                            System.out.print("Enter The new Surname: ");
                            String surname = sc.next();
                            patient.setSurname(surname);
                            
                        }
                        else if(input == 3){
                            sc.nextLine();
                            System.out.print("Enter The new ID: ");
                            String ID = sc.next();
                            patient.setId(ID);
                            
                        }
                        else if(input == 4){
                            sc.nextLine();
                            System.out.print("Enter The new Age: ");
                            int age = sc.nextInt();
                            patient.setAge(age);
                            
                        }
                        else
                            System.out.println("Invalid input, try again!\n");
                        
                    }
                    else if(input == 2){
                        System.out.println("\nName: " + patient.getName());
                        System.out.println("Surname: " + patient.getSurname());
                        System.out.println("ID: " + patient.getId());
                        System.out.println("Age: " + patient.getAge());
                    }
                    else if(input == 3){
                        if(patient.getPrescriptions() != null) System.out.println(patient.getPrescriptions());
                        else System.out.println("Patient doesn't have any prescription");
                    }
                    else if(input == 4){
                        if(patient.getAppointments() != null) System.out.println(patient.getAppointments());
                        else System.out.println("Patient doesn't have any appointment");
                    }
                    else if(input == 5){
                        if(patient.getTests() != null) System.out.println(patient.getTests());
                        else System.out.println("Patient doesn't have any test");
                    }
                    else if(input == 6){
                        System.out.println("Exiting...");
                        sc.nextLine();
                        break;
                    }
                    else{
                        System.out.println("Invalid input, try again!\n");
                    }
                }
            }
        }
    }

    public void secreterMenu(Secreter secreter){
        Scanner sc = new Scanner(System.in);
        int input;
        boolean loop = true;

        System.out.println("\nSIGNED IN AS A SECRETER\n\n");
        while(loop){
            System.out.println("\nCHOOSE AN OPTION BETWEEN 1 AND 8\n");
            System.out.println("1) Give Prescription to a Patient");
            System.out.println("2) Display Patient Queue");
            System.out.println("3) Log out");

            input = sc.nextInt();
            System.out.println("\n");

            if(input == 1){
                secreter.prescribePatient();
            }
            else if(input == 2){
                secreter.displayQueue();
            }
            else if(input == 3){        
                System.out.println("Exiting...");
                loop = false;
            }
            else{
                System.out.println("Entered Input is Wrong, Please Try Again");
            }
        }
    }

    public void patientMenu() throws InputMismatchException
    {   

        Scanner sc = new Scanner(System.in);
        int input;
        boolean loop = true;
        Patient currPatient = null;
        String patientID;
       
        while (true) {
            
            System.out.println("CHOOSE AN OPTION BETWEEN 1 AND 2\n");
            System.out.println("1) Sign-Up");
            System.out.println("2) Sign-In");
            System.out.println("3) Exit");

            input = sc.nextInt();

            if(input == 1){
                System.out.println("Enter Patient's Name: \n");
                String name = sc.next();
                System.out.println("Enter Patient's Surname: \n");
                String surname = sc.next();
                System.out.println("Enter Patient's ID: \n");
                String id = sc.next();
                System.out.println("Enter Patient's Age: \n");
                int age = sc.nextInt();

                currPatient = new Patient(name, surname, id, age);
                HMSystem.patients.add(currPatient);
                pMap.put(currPatient.getId(), currPatient);
                break;
            }
            else if(input == 2){
                
                System.out.print("Patient ID:");
                patientID = sc.next();
                
                addAlltoPMap();
                Patient temp = pMap.get(patientID);
                
                if(temp == null)
                    System.out.println("Invalid ID.");
                else{
                    currPatient = temp; 
                    break;
                }
                       
            }

            else return;
        
        }

        System.out.println("\nSIGNED IN AS Patient\n\n");
        while(loop){
            System.out.println("CHOOSE AN OPTION BETWEEN 1 AND 8\n");
            System.out.println("1) Display Patient Info");
            System.out.println("2) Get an Appointment");
            System.out.println("3) See Appointments");
            System.out.println("4) See Medications");
            System.out.println("5) See Test Results");
            System.out.println("6) Previous Menu");
            System.out.println("7) Close");

            input = sc.nextInt();

            if(input == 1){
                System.out.println("Patient's info: "+currPatient);
            }
            else if(input == 2)
            {
                System.out.println("\nPolyclinic List \n");
                for (int i = 0; i < polycList().size(); i++) {
                    System.out.println(i + " - " + polycList().get(i).getName());
                }

                System.out.println("Choose a Polyclinic: \n");
                int polID = sc.nextInt();
                Polyclinic tempPolyclinic = polycList().get(polID);

                for (int i = 0; i < tempPolyclinic.getDoctors().size(); i++) {
                    System.out.println(i + " - " + tempPolyclinic.getDoctors().get(i).toString());
                }
                
                System.out.println("Choose a Doctor: \n");
                int docID = sc.nextInt();
                Doctor tempDoctor = tempPolyclinic.getDoctors().get(docID);
                
                
                System.out.println("Enter a Date: \n");
                int date = sc.nextInt();
                
                //TODO input check doctor and polyclinic

                Appointment appo = new Appointment(tempPolyclinic, tempDoctor, currPatient, new Date(date),"ID");
                ((Doctor)(HMSystem.workers.get(0))).addAppointment(appo);
                currPatient.addAppointment(appo);
                appointments.add(appo);
            
            
            }   
            else if(input == 3){
                System.out.println(currPatient.getAppointments());
            }
            else if(input == 4){
                System.out.println(currPatient.getPrescriptions());
                
            }
            else if(input == 5){
                System.out.println(currPatient.getTests());
                
            }
            else if(input == 6){
                
                System.out.println("Going Back...");
                loop = false;
            }
            else if(input == 7){
               System.exit(0);
               System.out.println("Goodbye");

            }
            else{
                System.out.println("Entered Input is Wrong, Please Try Again");
            }
        }
        
    }
    




}