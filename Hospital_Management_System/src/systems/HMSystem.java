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
                //TODO patient parametresi 
                doctor.addAppointment(new Appointment((Polyclinic) doctor.getDepartment(), doctor, new Patient("name","surname","002",12), new Date()));
            }   //TODO Date classi sikintili, appointmentin id'si yok(default 0), doctorun polyclinic'ine ulasamiyoruz 
            else if(input == 3){        
                System.out.println(doctor.getAppointment().toString());
            }
            else if(input == 4){
                //TODO hastaya recete verip, display patient info'ya girince verilen recete gozukmuyor
                sc.nextLine();
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
                    System.out.println("\n1) Display Doctors");
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
            String id = sc.nextLine();
            Patient patient = (Patient) returnUser(id, patients);  
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
                            String name = sc.nextLine();
                            patient.setName(name);

                        }
                        else if(input == 2){
                            sc.nextLine();
                            System.out.print("Enter The new Surname: ");
                            String surname = sc.nextLine();
                            patient.setSurname(surname);
                            
                        }
                        else if(input == 3){
                            sc.nextLine();
                            System.out.print("Enter The new ID: ");
                            String ID = sc.nextLine();
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
                //TODO sekreterin appointments'e erisimi yok
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