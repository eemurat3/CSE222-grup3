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
    static private List<Appointment> appointments = new ArrayList<>();
    static private List<Department> departments = new ArrayList<>();
    static private SkipList<Patient> patients = new SkipList<Patient>();
    static private List<Worker> workers = new ArrayList<>();
    static private BinarySearchTree<User> users = new BinarySearchTree<>();
    static private Queue<Test> tests = new LinkedList<>();
    static private HashMap<String,Worker> wMap = new HashMap<>();
    static private HashMap<String,Patient> pMap = new HashMap<>();
    static public ListGraph navigationDepartments = new ListGraph(false);

    /**
     * It returns the HashMap wMap.
     * 
     * @return A HashMap of type String and Worker.
     */
    public static HashMap<String,Worker> getwmap(){return wMap;}

    /**
     * Return the tests.
     * 
     * @return The queue of tests.
     */
    public static Queue<Test> gettests(){return tests;}

    /**
     * This function returns the users BinarySearchTree.
     * 
     * @return The users binary search tree.
     */
    public static BinarySearchTree<User> getusers(){return users;}

    /**
     * This function returns a list of workers.
     * 
     * @return A list of workers.
     */
    public static List<Worker> getworkers(){return workers;}

    /**
     * This function returns the patients SkipList.
     * 
     * @return The patients SkipList.
     */
    public static SkipList<Patient> getpatients(){return patients;}

    /**
     * This function returns a list of departments.
     * 
     * @return A list of departments.
     */
    public static List<Department> getdepartments(){return departments;}

   /**
    * This function returns a list of all the appointments in the database
    * 
    * @return The list of appointments.
    */
    public static List<Appointment> getappointments(){return appointments;}

    /**
     * This function returns the navigationDepartments list
     * 
     * @return The list of departments.
     */
    public static ListGraph getnavigationDepartments(){return navigationDepartments;}
    


    /**
     * This function adds all the workers in the workers arraylist to the wMap hashmap
     */
    public void addAlltoWMap()
    {
        for (Worker item : workers) {
            wMap.put(item.getUsername(), item);
        }
    }

   /**
    * This function adds all the patients in the patients arraylist to the pMap hashmap
    */
    public void addAlltoPMap()
    {
        for (Patient item : patients) {
            pMap.put(item.getId(),item);
        }
    }

    // A generic method that returns an object from a list.
    /**
     * This function takes in a String ID and a List of type E, and returns an object of type E that
     * has the same ID as the String ID
     * 
     * @param ID The ID of the user you want to return
     * @param list The list of users
     * @return A generic object.
     */
    public <E> E returnUser(String ID, List<E> list){
        for(int i = 0; i < list.size(); i++){
            if(((User) list.get(i)).getId().compareTo(ID) == 0){
                return list.get(i);
            }
        }
        return null;
    }

   /**
    * This function takes in a string ID and a skiplist of patients. It iterates through the skiplist
    * and returns the patient with the matching ID
    * 
    * @param ID The ID of the patient to be returned
    * @param skiplist the skiplist that contains the patient
    * @return The patient with the ID that is passed in.
    */
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


    /**
     * It returns an ArrayList of Polyclinic objects from the departments ArrayList
     * 
     * @return ArrayList<Polyclinic>
     */
    public ArrayList<Polyclinic> polycList()
    {
        ArrayList<Polyclinic> pList = new ArrayList<>();
        for (Department item : departments) {
            if(item.getClass() == Polyclinic.class)
                pList.add((Polyclinic)item);
        }
        return pList;
    }
    
    /**
     * It takes a Scanner object as input, and returns an integer
     * 
     * @param input Scanner object
     * @return The method is returning an integer.
     */
    public int getInt(Scanner input) {
        int retval = 0;
        try {
            retval = Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.print("INVALID INPUT! Please Try Again: ");
            retval = getInt(input);
        }
        return retval;
    }     
    
    /**
     * It's a menu for the manager.
     * </code>
     * 
     * @param manager The manager who is logged in
     */
    public void managerMenu(Manager manager)throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int input = 0;
        System.out.println("\nSIGNED IN AS A MANAGER");
        
        while (true) {
            System.out.println("\nChoose Option Below: ");
            System.out.println("1) Add a New Staff");
            System.out.println("2) Remove a Staff");
            System.out.println("3) Add a New Department");
            System.out.println("4) Remove a Department");
            System.out.println("5) Display a Patient's Info");
            System.out.println("6) Edit a Staff");
            System.out.println("7) Display All Staff");
            System.out.println("8) Add a New Road Between Departments");
            System.out.println("9) Display All Roads");
            System.out.println("10) Exit");
            System.out.print("Select: ");
            input = getInt(sc);

            if (input == 1) {
                
                for (Department dep : departments)
                    System.out.println(dep.getName());
                
                System.out.print("Select a Department to Add New Staff: ");
                String tempName = sc.nextLine();

                int index = 0;

                for (Department dep : departments) {
                    if (dep.getName().equals(tempName))
                        break;
                    index++;
                }

                if (index == departments.size())
                    System.out.println("Entered Department Is Not Available!");
                else {

                    int type = -1;
                  
                    if (departments.get(index).getClass() == Reception.class)
                        type = 3;
                    else if (departments.get(index).getClass() == Lab.class)
                        type = 4;
                    else {
                        System.out.print("Enter The Type Of The New Staff");
                        while (type > 2 || type < 0) {
                            System.out.print("(0: Doctor, 1: Nurse, 2: Secreter): ");
                            type = getInt(sc);
                        }                           
                    }

                    System.out.print("Enter a Name For The New Staff: ");
                    String name = sc.nextLine();
    
                    System.out.print("Enter a Surname For The New Staff: ");
                    String surname = sc.nextLine();
                    
                    System.out.print("Enter an Age For The New Staff: ");
                    int age = getInt(sc);
                    
                    System.out.print("Enter a Username For The New Staff: ");
                    String username = sc.nextLine();
                    
                    System.out.print("Enter a Password For The New Staff: ");
                    String password = sc.nextLine();
    
                    if (type == 0) {
                        Doctor d = new Doctor(name, surname, "0", age, username, password);
                        Polyclinic poly = (Polyclinic) departments.get(index);
                        poly.addDoctor(d);
                        workers.add(d);                        

                    }
                    else if (type == 1) {
                        Nurse n = new Nurse(name, surname, "0", age, username, password);
                        Polyclinic poly = (Polyclinic) departments.get(index);
                        poly.addNurse(n);
                        workers.add(n);
                    }
                    else if (type == 2) {
                        Secreter s = new Secreter(name, surname, "0", age, username, password);
                        Polyclinic poly = (Polyclinic) departments.get(index);
                        poly.addSecreter(s);
                        workers.add(s);
                    }
                    else if (type == 3) {
                        Advisor a = new Advisor(name, surname, "0", age, username, password);
                        Reception recept = (Reception) departments.get(index);
                        recept.addAdvisorStaff(a);
                        workers.add(a);
                    }
                    else if (type == 4) {
                        Technician t = new Technician(name, surname, "0", age, username, password);
                        Lab lab = (Lab) departments.get(index);
                        lab.addClinicalTechnician(t);
                        workers.add(t);
                    }
    
                    workers.get(workers.size()-1).setDepartment(departments.get(index));
                }
            }
            else if (input == 2) {
                System.out.print("Enter an ID For Remove a Staff: ");
                String id = sc.nextLine();
                
                int index = 0;
                for (Worker worker : workers) {
                    if (worker.getId().equals(id))
                        break;
                    index++;
                }

                if (index != workers.size())
                    workers.remove(index);
            }
            else if (input == 3) {
                System.out.print("Enter a Name For The New Department: ");
                String name = sc.nextLine();

                System.out.print("Enter an ID For The New Department: ");
                int id = getInt(sc);
                
                int type = -1;
                while (type > 2 || type < 0) {
                    System.out.print("Enter The Type of The New Department(0:Lab, 1:Polyclinic, 2:Reception): ");
                    type = getInt(sc);
                }

                if (type == 0)
                    departments.add(new Lab(name, id));
                else if (type == 1)
                    departments.add(new Polyclinic(name, id));
                else if (type == 2)
                    departments.add(new Reception(name, id));
            }
            else if (input == 4) {
                System.out.print("Enter an ID For Remove a Department: ");
                int id = getInt(sc);
                
                int index = 0;
                for (Department dp : departments) {
                    if (dp.getId() == id)
                        break;
                    index++;
                }

                if (index != departments.size())
                    departments.remove(index);
            }
            else if (input == 5) {
                System.out.print("Enter an ID For Display a Patient: ");
                String id = sc.nextLine(); 
                
                for (Patient patient : patients) {
                    if (patient.getId().equals(id)) {
                        System.out.println(patient.displayPrescriptions());
                        System.out.println(patient.displayDoctors());
                        System.out.println(patient.displayRecords());   
                        System.out.println(patient);
                    }
                }
            }
            else if (input == 6) {
                System.out.print("Enter an ID For Edit a Staff: ");
                String id = sc.nextLine(); 

                int index = 0;
                for (Worker worker : workers) {
                    if (worker.getId().equals(id))
                        break;
                    index++;
                }
                
                if (index != workers.size()) {
                    System.out.print("Enter a Name For The New Staff: ");
                    String name = sc.nextLine();
    
                    System.out.print("Enter a Surname For The New Staff: ");
                    String surname = sc.nextLine();
                    
                    System.out.print("Enter an Age For The New Staff: ");
                    int age = getInt(sc);
                    
                    System.out.print("Enter a Username For The New Staff: ");
                    String username = sc.nextLine();
                    
                    System.out.print("Enter a Password For The New Staff: ");
                    String password = sc.nextLine();
                    
                    workers.get(index).setAll(name, surname, id, age, username, password);
                }
            }
            else if (input == 7) {
                System.out.println("\nDoctors:");
                for (Worker it : workers)
                    if (it.getClass() == Doctor.class)
                        System.out.println("\t" + it);
                
                System.out.println("\nNurses:");
                for (Worker it : workers)
                    if (it.getClass() == Nurse.class)
                        System.out.println("\t" + it);
                
                System.out.println("\nSecretaries:");
                for (Worker it : workers)
                    if (it.getClass() == Secreter.class)
                        System.out.println("\t" + it);
                
                System.out.println("\nTechnicians:");
                for (Worker it : workers)
                    if (it.getClass() == Technician.class)
                        System.out.println("\t" + it);
                
                System.out.println("\nAdvisors:");
                for (Worker it : workers)
                    if (it.getClass() == Advisor.class)
                        System.out.println("\t" + it);
            }

            else if(input == 8){
                Department source = null;
                Department destination = null;

                System.out.println("\nDepartments:");

                for(Department dp : departments){
                    System.out.println(dp.getName());
                }
                
                System.out.println("\nSource Department Name : ");
                String sourceName = sc.nextLine();

                System.out.println("Destination Department Name : ");
                String destinationName = sc.nextLine();

                System.out.println("Meter (Weight) : ");
                Double weight = sc.nextDouble();

                for(Department dp : departments){
                    if(dp.getName().equals(sourceName))
                        source = dp;
                    if(dp.getName().equals(destinationName))
                        destination = dp;
                }
                
                if(destination != null && source != null)
                    navigationDepartments.insert(new Edge(source, destination,weight));
            }
            else if(input == 9){
                    System.out.println(navigationDepartments);
            }
            else if (input == 10)
                return;
        }
    }
    
    /**
     * This function is a menu for a technician to add tests, take tests, display old tests, display
     * waiting tests, or exit.
     * </code>
     * 
     * @param tech Technician object
     */
    public void technicianMenu(Technician tech)throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int input = 0;
        System.out.println("\nSIGNED IN AS A TECHNICIAN");

        while (true) {
            System.out.println("\nChoose Option Below: ");
            System.out.println("1) Add New Test");
            System.out.println("2) Take Test");
            System.out.println("3) Display Old Tests");
            System.out.println("4) Display Waiting Tests");
            System.out.println("5) EXIT");
            System.out.print("Select: ");
            input = getInt(sc);

            if (input == 1) {
                
                int type = -1;
                while (type > 2 || type < 0) {
                    System.out.print("Enter Test Type(0: Blood, 1: Covid, 2: Radiological): ");
                    type = getInt(sc);
                }

                System.out.print("Enter Patient ID: ");
                String patientID = sc.nextLine();

                if (type == 0)
                    tech.addTest(new BloodTest(patientID, "testID"));
                else if (type == 1)
                    tech.addTest(new CovidTest(patientID, "testID"));
                else
                    tech.addTest(new RadiologicalTest(patientID, "testID"));
            }
            else if (input == 2)
                System.out.println("REMOVED TEST: " + tech.takeTest());
            else if (input == 3)
                tech.displayOldTests();
            else if (input == 4)
                tech.displayWaitingTests();
            else if (input == 5)
                return;

        }
    }    

    /**
     * This function is used to display the menu for the doctor and it takes the doctor object as a
     * parameter
     * 
     * @param doctor Doctor object
     */
    public void doctorMenu(Doctor doctor)throws Exception{
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
            System.out.println("8) Display Secreter Info");
            System.out.println("9) Log out");

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
                String med = sc.nextLine();
                System.out.println("\nEnter Instructions for Patient : ");
                String inst = sc.nextLine();
                System.out.println("\nEnter note for Patient : ");
                String note = sc.nextLine();
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
                System.out.println("\t\t\tSecreter's Informations");
                System.out.println("Name : " + doctor.getSecreter().getName()); 
                System.out.println("Surname : " + doctor.getSecreter().getSurname());
                System.out.println("E-Mail : " + doctor.getSecreter().getUsername());
            }
            else if(input == 9){
                System.out.println("Exiting...");
                loop = false;
            }
            else{
                System.out.println("Entered Input is Wrong, Please Try Again");
            }
        }
    }

    /**
     * It's a menu for an advisory staff
     * 
     * @param adv Advisor
     */
    public void ADVMenu(Advisor adv)throws Exception{
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
                        adv.displayDoctorList().forEach(System.out::println);
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
                adv.displayDoctorList().forEach(System.out::println);
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

    /**
     * The function takes a nurse object as a parameter and displays a menu for the nurse to choose
     * from
     * 
     * @param nurse the nurse object that is logged in
     */
    public void NurseMenue(Nurse nurse)throws Exception{
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

    /**
     * It's a menu for a secreter to choose from a list of options
     * 
     * @param secreter Secreter object
     */
    public void secreterMenu(Secreter secreter)throws Exception{
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

    /**
     * It's a menu for patients
     */
    public void patientMenu() throws Exception
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
            System.out.println("\nCHOOSE AN OPTION BETWEEN 1 AND 8\n");
            System.out.println("1) Display Patient Info");
            System.out.println("2) Get an Appointment");
            System.out.println("3) See Appointments");
            System.out.println("4) See Medications");
            System.out.println("5) See Test Results");
            System.out.println("6) Navigation");
            System.out.println("7) Previous Page");
            System.out.println("8) Close");

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

                Collections.sort(tempPolyclinic.getDoctors(),new Comparator<Doctor>() {
                    @Override
                    public int compare(Doctor o1, Doctor o2) {
                        
                        return o1.getName().compareTo(o2.getName());
                    }
                });

                for (int i = 0; i < tempPolyclinic.getDoctors().size(); i++) 
                    System.out.println(i + " - " + tempPolyclinic.getDoctors().get(i).toString());
                
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
                
                if(currPatient.getAppointments().isEmpty())
                    System.out.println("There is no any appointment");
                else
                    System.out.println(currPatient.getAppointments());
            }
            else if(input == 4){
                
                if(currPatient.getPrescriptions().isEmpty())
                    System.out.println("There is no any prescriptions");
                else
                    System.out.println(currPatient.getPrescriptions());
                
            }
            else if(input == 5){
                if(currPatient.getTests().isEmpty())
                    System.out.println("There is no any test");
                else
                    System.out.println(currPatient.getTests());
                
            }
            else if(input == 6){
                Department source = null;
                Department destination = null;

                System.out.println("\nDepartments:");

                for(Department dp : departments){
                    System.out.println(dp.getName());
                }

                sc.nextLine();

                System.out.println("\nSource Department Name : ");
                String sourceName = sc.nextLine();

                System.out.println("Destination Department Name : ");
                String destinationName = sc.nextLine();

                for(Department dp : departments){
                    if(dp.getName().equals(sourceName))
                        source = dp;
                    if(dp.getName().equals(destinationName))
                        destination = dp;
                }
                
                System.out.println("Source Name : " + sourceName);
                System.out.println("Destination Name : " + destinationName);

                if(destination != null && source != null)
                    System.out.println("Distance : " + navigationDepartments.dijkstra(source, destination));
                else{
                    System.out.println("There is no road between this departments");
                }
                
                
            }
            else if(input == 7){
                System.out.println("Going Back...");
                loop = false;

            }
            else if(input == 8){
               System.exit(0);
               System.out.println("Goodbye");
            }
            else{
                System.out.println("Entered Input is Wrong, Please Try Again");
            }
        }
        
    }
    

}
