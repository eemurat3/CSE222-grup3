import java.util.Date;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Scanner;

import departments.Department;
import departments.Lab;
import departments.Polyclinic;
import departments.Reception;
import systems.Appointment;
import systems.HMSystem;
import systems.Prescription;
import tests.BloodTest;
import tests.CovidTest;
import tests.RadiologicalTest;
import unit_tests.TestAdvisor;
import unit_tests.TestTechnician;
import unit_tests.ut_polyclinic;
import users.Advisor;
import users.Doctor;
import users.Manager;
import users.Nurse;
import users.Patient;
import users.Secreter;
import users.Technician;
import users.Worker;
import util.Edge;
import util.ListGraph;

/**
 * Main Class for running the Group 3's CSE222-Project implementation of Hospital Management System. 
 */
public class Group3Main {

    /**
     * The main function is the entry point of the program
     */
    public static void main(String[] args) 
    {
        
        String testID = "name";
        int age = 0;
        Date date = new Date();


        Polyclinic polyclinic1 = new Polyclinic("polyclinic1", 1);
        Polyclinic polyclinic2 = new Polyclinic("polyclinic2", 2);
        Polyclinic polyclinic3 = new Polyclinic("polyclinic3", 3);


        ListGraph graphNav = new ListGraph(false);
        graphNav.insert(new Edge(polyclinic1, polyclinic2,15));
        graphNav.insert(new Edge(polyclinic2, polyclinic3,25));

        

        Doctor doctor1 = new Doctor("Ali", "doctorSurname", "doc1", 33, "doc1@mail.com", "pass");
        Doctor doctor2 = new Doctor("doctor2", "doctorSurname", "doc2", 55, "doc2@mail.com", "pass");
        Doctor doctor3 = new Doctor("doctor3", "doctorSurname", "doc3", 45, "doc3@mail.com", "pass");
        Doctor doctor4 = new Doctor("doctor4", "doctorSurname", "doc4", 69, "doc4@mail.com", "pass");
        Doctor doctor5 = new Doctor("doctor5", "doctorSurname", "doc5", 34, "doc5@mail.com", "pass");
        Doctor doctor6 = new Doctor("doctor6", "doctorSurname", "doc6", 37, "doc6@mail.com", "pass");
        Doctor doctor7 = new Doctor("Zeynep", "doctorSurname", "doc7", 47, "doc7@mail.com", "pass");
        Doctor doctor8 = new Doctor("Ahmet", "doctorSurname", "doc8", 55, "doc8@mail.com", "pass");
        Doctor doctor9 = new Doctor("Zuhtu", "doctorSurname", "doc9", 52, "doc9@mail.com", "pass");
        Doctor doctor10 = new Doctor("Abdullah", "doctorSurname", "doc10", 31, "doc10@mail.com", "pass");


        Secreter secreter1 = new Secreter("secreter1", "secreterSurname", "sec1", 25, "sec1@mail.com", "pass");
        Secreter secreter2 = new Secreter("secreter2", "secreterSurname", "sec2", 32, "sec2@mail.com", "pass");
        Secreter secreter3 = new Secreter("secreter3", "secreterSurname", "sec3", 28, "sec3@mail.com", "pass");
        Secreter secreter4 = new Secreter("secreter4", "secreterSurname", "sec4", 27, "sec4@mail.com", "pass");
        Secreter secreter5 = new Secreter("secreter5", "secreterSurname", "sec5", 26, "sec5@mail.com", "pass");
        Secreter secreter6 = new Secreter("secreter6", "secreterSurname", "sec6", 21, "sec6@mail.com", "pass");
        Secreter secreter7 = new Secreter("secreter7", "secreterSurname", "sec7", 33, "sec7@mail.com", "pass");
        Secreter secreter8 = new Secreter("secreter8", "secreterSurname", "sec8", 34, "sec8@mail.com", "pass");
        Secreter secreter9 = new Secreter("secreter9", "secreterSurname", "sec9", 50, "sec9@mail.com", "pass");
        Secreter secreter10 = new Secreter("secreter10", "secreterSurname", "sec10", 48, "sec10@mail.com", "pass");

        Nurse nurse1 = new Nurse("nurse1", "nurseSurname", "nrs1", 25, "nrs1@mail.com", "pass");
        Technician technician1 = new Technician("technician1", "technicianSurname", "tech1", 30,"tech1@mail.com", "pass");
        
        int patID = 1;
        age = 1;
        Patient patient1 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient2 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient3 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient4 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient5 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient6 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient7 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient8 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient9 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient10 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient11 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient12 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient13 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient14 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient15 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient16 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient17 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient18 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient19 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient20 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient21 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient22 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient23 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient24 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient25 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient26 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient27 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient28 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient29 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        Patient patient30 = new Patient("patientName" + Integer.toString(patID++), "patientSurname", Integer.toString(patID), age++);
        
        
        Advisor advisor1 = new Advisor("advisor1", "advisorSurname", "adv1", 40, "adv@mail.com", "pass");
        advisor1.setDepartment(polyclinic1);
        Advisor advisor2 = new Advisor("advisor2", "advisorSurname", "adv2", 41, "adv@mail.com", "pass");
        advisor2.setDepartment(polyclinic2);
        Advisor advisor3 = new Advisor("advisor3", "advisorSurname", "adv3", 42, "adv@mail.com", "pass");
        advisor3.setDepartment(polyclinic3);
        

        Manager manager = new Manager("managerName", "managerSurname", "manager", 61, "manager@mail.com", "admin");

        Lab lab = new Lab("departmentName", 1);
        Reception reception = new Reception("departmentName", 2);

        int apID = 1;
        
        Appointment appointment1 = new Appointment(polyclinic1, doctor1, patient1, date,Integer.toString(apID++));
        Appointment appointment2 = new Appointment(polyclinic1, doctor1, patient2, date,Integer.toString(apID++));
        Appointment appointment3 = new Appointment(polyclinic1, doctor2, patient3, date,Integer.toString(apID++));
        Appointment appointment4 = new Appointment(polyclinic1, doctor2, patient4, date,Integer.toString(apID++));
        Appointment appointment5 = new Appointment(polyclinic1, doctor3, patient5, date,Integer.toString(apID++));
        Appointment appointment6 = new Appointment(polyclinic1, doctor3, patient6, date,Integer.toString(apID++));
        Appointment appointment7 = new Appointment(polyclinic1, doctor3, patient7, date,Integer.toString(apID++));
        Appointment appointment8 = new Appointment(polyclinic1, doctor3, patient8, date,Integer.toString(apID++));
        Appointment appointment9 = new Appointment(polyclinic1, doctor3, patient9, date,Integer.toString(apID++));
        
        Appointment appointment10 = new Appointment(polyclinic2, doctor4, patient10, date,Integer.toString(apID++));
        Appointment appointment11 = new Appointment(polyclinic2, doctor4, patient11, date,Integer.toString(apID++));
        Appointment appointment12 = new Appointment(polyclinic2, doctor4, patient12, date,Integer.toString(apID++));
        Appointment appointment13 = new Appointment(polyclinic2, doctor5, patient13, date,Integer.toString(apID++));
        Appointment appointment14 = new Appointment(polyclinic2, doctor5, patient14, date,Integer.toString(apID++));
        Appointment appointment15 = new Appointment(polyclinic2, doctor5, patient15, date,Integer.toString(apID++));
        Appointment appointment16 = new Appointment(polyclinic2, doctor6, patient16, date,Integer.toString(apID++));
        Appointment appointment17 = new Appointment(polyclinic2, doctor6, patient17, date,Integer.toString(apID++));
        Appointment appointment18 = new Appointment(polyclinic2, doctor6, patient18, date,Integer.toString(apID++));
        Appointment appointment19 = new Appointment(polyclinic2, doctor6, patient19, date,Integer.toString(apID++));

        Appointment appointment20 = new Appointment(polyclinic3, doctor7, patient20, date,Integer.toString(apID++));
        Appointment appointment21 = new Appointment(polyclinic3, doctor7, patient21, date,Integer.toString(apID++));
        Appointment appointment22 = new Appointment(polyclinic3, doctor7, patient22, date,Integer.toString(apID++));
        Appointment appointment23 = new Appointment(polyclinic3, doctor8, patient23, date,Integer.toString(apID++));
        Appointment appointment24 = new Appointment(polyclinic3, doctor8, patient24, date,Integer.toString(apID++));
        Appointment appointment25 = new Appointment(polyclinic3, doctor8, patient25, date,Integer.toString(apID++));
        Appointment appointment26 = new Appointment(polyclinic3, doctor9, patient26, date,Integer.toString(apID++));
        Appointment appointment27 = new Appointment(polyclinic3, doctor9, patient27, date,Integer.toString(apID++));
        Appointment appointment28 = new Appointment(polyclinic3, doctor10, patient28, date,Integer.toString(apID++));
        Appointment appointment29 = new Appointment(polyclinic3, doctor10, patient29, date,Integer.toString(apID++));
        Appointment appointment30 = new Appointment(polyclinic3, doctor10, patient30, date,Integer.toString(apID++));
        
        
        

        //TODO her hasta icin recete ve testler yapilmali ve eklenmeli
        Prescription prescription = new Prescription("prescID", patient1.getId(), "Med", "Inst", "newNote");
        
        CovidTest covidTest = new CovidTest(patient1.getId(), testID);
        BloodTest bloodTest = new BloodTest(patient1.getId(), testID);
        RadiologicalTest radiologicalTest = new RadiologicalTest(patient1.getId(), testID);

        // Doctor set secreter
        doctor1.setSecreter(secreter1);
        doctor2.setSecreter(secreter2);
        doctor3.setSecreter(secreter3);
        doctor4.setSecreter(secreter4);
        doctor5.setSecreter(secreter5);
        doctor6.setSecreter(secreter6);
        doctor7.setSecreter(secreter7);
        doctor8.setSecreter(secreter8);
        doctor9.setSecreter(secreter9);
        doctor10.setSecreter(secreter10);


        // Doctor set polyclinic
        doctor1.setDepartment(polyclinic1);
        doctor2.setDepartment(polyclinic1);
        doctor3.setDepartment(polyclinic1);

        doctor4.setDepartment(polyclinic2);
        doctor5.setDepartment(polyclinic2);
        doctor6.setDepartment(polyclinic2);

        doctor7.setDepartment(polyclinic3);
        doctor8.setDepartment(polyclinic3);
        doctor9.setDepartment(polyclinic3);
        doctor10.setDepartment(polyclinic3);


        //doctor appointment

        doctor1.addAppointment(appointment1);
        doctor1.addAppointment(appointment2);

        doctor2.addAppointment(appointment3);
        doctor2.addAppointment(appointment4);

        doctor3.addAppointment(appointment5);
        doctor3.addAppointment(appointment6);
        doctor3.addAppointment(appointment7);
        doctor3.addAppointment(appointment8);
        doctor3.addAppointment(appointment9);


        doctor4.addAppointment(appointment10);
        doctor4.addAppointment(appointment11);
        doctor4.addAppointment(appointment12);

        doctor5.addAppointment(appointment13);
        doctor5.addAppointment(appointment14);
        doctor5.addAppointment(appointment15);

        doctor6.addAppointment(appointment16);
        doctor6.addAppointment(appointment17);
        doctor6.addAppointment(appointment18);
        doctor6.addAppointment(appointment19);
        


        doctor7.addAppointment(appointment20);
        doctor7.addAppointment(appointment21);
        doctor7.addAppointment(appointment22);

        doctor8.addAppointment(appointment23);
        doctor8.addAppointment(appointment24);
        doctor8.addAppointment(appointment25);

        doctor9.addAppointment(appointment26);
        doctor9.addAppointment(appointment27);

       
        doctor10.addAppointment(appointment28);
        doctor10.addAppointment(appointment29);
        doctor10.addAppointment(appointment30);
        
        //patient appointment


        
        patient1.addAppointment(appointment1);
        patient2.addAppointment(appointment2);
        patient3.addAppointment(appointment3);
        patient4.addAppointment(appointment4);
        patient5.addAppointment(appointment5);
        patient6.addAppointment(appointment6);
        patient7.addAppointment(appointment7);
        patient8.addAppointment(appointment8);
        patient9.addAppointment(appointment9);

        patient10.addAppointment(appointment10);
        patient11.addAppointment(appointment11);
        patient12.addAppointment(appointment12);
        patient13.addAppointment(appointment13);
        patient14.addAppointment(appointment14);
        patient15.addAppointment(appointment15);
        patient16.addAppointment(appointment16);
        patient17.addAppointment(appointment17);
        patient18.addAppointment(appointment18);
        patient19.addAppointment(appointment19);

        patient20.addAppointment(appointment20);
        patient21.addAppointment(appointment21);
        patient22.addAppointment(appointment22);
        patient23.addAppointment(appointment23);
        patient24.addAppointment(appointment24);
        patient25.addAppointment(appointment25);
        patient26.addAppointment(appointment26);
        patient27.addAppointment(appointment27);
        patient28.addAppointment(appointment28);
        patient29.addAppointment(appointment29);
        patient30.addAppointment(appointment30);
        

        //patient prescription

        patient1.addPrescription(prescription);
        patient2.addPrescription(prescription);
        patient3.addPrescription(prescription);
        patient4.addPrescription(prescription);
        patient5.addPrescription(prescription);
        patient6.addPrescription(prescription);
        patient7.addPrescription(prescription);
        patient8.addPrescription(prescription);
        patient9.addPrescription(prescription);

        patient10.addPrescription(prescription);
        patient11.addPrescription(prescription);
        patient12.addPrescription(prescription);
        patient13.addPrescription(prescription);
        patient14.addPrescription(prescription);
        patient15.addPrescription(prescription);
        patient16.addPrescription(prescription);
        patient17.addPrescription(prescription);
        patient18.addPrescription(prescription);
        patient19.addPrescription(prescription);

        patient20.addPrescription(prescription);
        patient21.addPrescription(prescription);
        patient22.addPrescription(prescription);
        patient23.addPrescription(prescription);
        patient24.addPrescription(prescription);
        patient25.addPrescription(prescription);
        patient26.addPrescription(prescription);
        patient27.addPrescription(prescription);
        patient28.addPrescription(prescription);
        patient29.addPrescription(prescription);
        patient30.addPrescription(prescription);

        //patient test

        patient1.addTest(covidTest);
        patient2.addTest(covidTest);
        patient3.addTest(covidTest);
        patient4.addTest(covidTest);
        patient5.addTest(covidTest);
        patient6.addTest(covidTest);
        patient7.addTest(covidTest);
        patient8.addTest(covidTest);
        patient9.addTest(covidTest);

        patient10.addTest(covidTest);
        patient11.addTest(covidTest);
        patient12.addTest(covidTest);
        patient13.addTest(covidTest);
        patient14.addTest(covidTest);
        patient15.addTest(covidTest);
        patient16.addTest(covidTest);
        patient17.addTest(covidTest);
        patient18.addTest(covidTest);
        patient19.addTest(covidTest);

        patient20.addTest(covidTest);
        patient21.addTest(covidTest);
        patient22.addTest(covidTest);
        patient23.addTest(covidTest);
        patient24.addTest(covidTest);
        patient25.addTest(covidTest);
        patient26.addTest(covidTest);
        patient27.addTest(covidTest);
        patient28.addTest(covidTest);
        patient29.addTest(covidTest);
        patient30.addTest(covidTest);
        
        

        //secreter prescription
        secreter1.addPrescription(prescription);
        secreter2.addPrescription(prescription);
        secreter3.addPrescription(prescription);
        secreter4.addPrescription(prescription);
        secreter5.addPrescription(prescription);
        secreter6.addPrescription(prescription);
        secreter7.addPrescription(prescription);
        secreter8.addPrescription(prescription);
        secreter9.addPrescription(prescription);
        secreter10.addPrescription(prescription);

        
        // secreter doctor
        secreter1.setDoctor(doctor1);
        secreter2.setDoctor(doctor2);
        secreter3.setDoctor(doctor3);
        secreter4.setDoctor(doctor4);
        secreter5.setDoctor(doctor5);
        secreter6.setDoctor(doctor6);
        secreter7.setDoctor(doctor7);
        secreter8.setDoctor(doctor8);
        secreter9.setDoctor(doctor9);
        secreter10.setDoctor(doctor10);


        //polyclinic doctor
        polyclinic1.addDoctor(doctor1);
        polyclinic1.addDoctor(doctor2);
        polyclinic1.addDoctor(doctor3);

        polyclinic2.addDoctor(doctor4);
        polyclinic2.addDoctor(doctor5);
        polyclinic2.addDoctor(doctor6);
        
        polyclinic3.addDoctor(doctor7);
        polyclinic3.addDoctor(doctor8);
        polyclinic3.addDoctor(doctor9);
        polyclinic3.addDoctor(doctor10);


        polyclinic1.addNurse(nurse1);

        //polyclinic add patients
        polyclinic1.addPatients(patient1);
        polyclinic1.addPatients(patient2);
        polyclinic1.addPatients(patient3);
        polyclinic1.addPatients(patient4);
        polyclinic1.addPatients(patient5);
        polyclinic1.addPatients(patient6);
        polyclinic1.addPatients(patient7);
        polyclinic1.addPatients(patient8);
        polyclinic1.addPatients(patient9);

        polyclinic2.addPatients(patient10);
        polyclinic2.addPatients(patient11);
        polyclinic2.addPatients(patient12);
        polyclinic2.addPatients(patient13);
        polyclinic2.addPatients(patient14);
        polyclinic2.addPatients(patient15);
        polyclinic2.addPatients(patient16);
        polyclinic2.addPatients(patient17);
        polyclinic2.addPatients(patient18);
        polyclinic2.addPatients(patient19);

        polyclinic3.addPatients(patient20);
        polyclinic3.addPatients(patient21);
        polyclinic3.addPatients(patient22);
        polyclinic3.addPatients(patient23);
        polyclinic3.addPatients(patient24);
        polyclinic3.addPatients(patient25);
        polyclinic3.addPatients(patient26);
        polyclinic3.addPatients(patient27);
        polyclinic3.addPatients(patient28);
        polyclinic3.addPatients(patient29);

        //polyclinic secreter
        polyclinic1.addSecreter(secreter1);
        polyclinic1.addSecreter(secreter2);
        polyclinic1.addSecreter(secreter3);

        polyclinic2.addSecreter(secreter4);
        polyclinic2.addSecreter(secreter5);
        polyclinic2.addSecreter(secreter6);
        
        polyclinic3.addSecreter(secreter7);
        polyclinic3.addSecreter(secreter8);
        polyclinic3.addSecreter(secreter9);
        polyclinic3.addSecreter(secreter10);



        lab.addClinicalTechnician(technician1);
        lab.addOldTest(covidTest);
        lab.addWaitingTest(radiologicalTest);
        lab.addWaitingTest(bloodTest);




        HMSystem myHospital = new HMSystem();

        myHospital.getdepartments().add(polyclinic1);
        myHospital.getdepartments().add(polyclinic2);
        myHospital.getdepartments().add(polyclinic3);
        
        myHospital.getworkers().add(doctor1);
        myHospital.getworkers().add(doctor2);
        myHospital.getworkers().add(doctor3);
        myHospital.getworkers().add(doctor4);
        myHospital.getworkers().add(doctor5);
        myHospital.getworkers().add(doctor6);
        myHospital.getworkers().add(doctor7);
        myHospital.getworkers().add(doctor8);
        myHospital.getworkers().add(doctor9);
        myHospital.getworkers().add(doctor10);

        myHospital.getworkers().add(nurse1);

        myHospital.getworkers().add(technician1);

        myHospital.getworkers().add(advisor1);
        myHospital.getworkers().add(advisor2);
        myHospital.getworkers().add(advisor3);

        myHospital.getworkers().add(secreter1);
        myHospital.getworkers().add(secreter2);
        myHospital.getworkers().add(secreter3);
        myHospital.getworkers().add(secreter4);
        myHospital.getworkers().add(secreter5);
        myHospital.getworkers().add(secreter6);
        myHospital.getworkers().add(secreter7);
        myHospital.getworkers().add(secreter8);
        myHospital.getworkers().add(secreter9);
        myHospital.getworkers().add(secreter10);

        myHospital.getworkers().add(manager);

        myHospital.getusers().add(doctor1);
        myHospital.getusers().add(doctor2);
        myHospital.getusers().add(doctor3);
        myHospital.getusers().add(doctor4);
        myHospital.getusers().add(doctor5);
        myHospital.getusers().add(doctor6);
        myHospital.getusers().add(doctor7);
        myHospital.getusers().add(doctor8);
        myHospital.getusers().add(doctor9);
        myHospital.getusers().add(doctor10);

        myHospital.getusers().add(nurse1);

        myHospital.getusers().add(technician1);

        myHospital.getusers().add(advisor1);
        myHospital.getusers().add(advisor2);
        myHospital.getusers().add(advisor3);

        myHospital.getusers().add(secreter1);
        myHospital.getusers().add(secreter2);
        myHospital.getusers().add(secreter3);
        myHospital.getusers().add(secreter4);
        myHospital.getusers().add(secreter5);
        myHospital.getusers().add(secreter6);
        myHospital.getusers().add(secreter7);
        myHospital.getusers().add(secreter8);
        myHospital.getusers().add(secreter9);
        myHospital.getusers().add(secreter10);

        myHospital.getusers().add(manager);


        myHospital.getusers().add(patient1);
        myHospital.getusers().add(patient2);
        myHospital.getusers().add(patient3);
        myHospital.getusers().add(patient4);
        myHospital.getusers().add(patient5);
        myHospital.getusers().add(patient6);
        myHospital.getusers().add(patient7);
        myHospital.getusers().add(patient8);
        myHospital.getusers().add(patient9);

        myHospital.getusers().add(patient10);
        myHospital.getusers().add(patient11);
        myHospital.getusers().add(patient12);
        myHospital.getusers().add(patient13);
        myHospital.getusers().add(patient14);
        myHospital.getusers().add(patient15);
        myHospital.getusers().add(patient16);
        myHospital.getusers().add(patient17);
        myHospital.getusers().add(patient18);
        myHospital.getusers().add(patient19);

        myHospital.getusers().add(patient20);
        myHospital.getusers().add(patient21);
        myHospital.getusers().add(patient22);
        myHospital.getusers().add(patient23);
        myHospital.getusers().add(patient24);
        myHospital.getusers().add(patient25);
        myHospital.getusers().add(patient26);
        myHospital.getusers().add(patient27);
        myHospital.getusers().add(patient28);
        myHospital.getusers().add(patient29);
        myHospital.getusers().add(patient30);


        myHospital.getpatients().add(patient1);
        myHospital.getpatients().add(patient2);
        myHospital.getpatients().add(patient3);
        myHospital.getpatients().add(patient4);
        myHospital.getpatients().add(patient5);
        myHospital.getpatients().add(patient6);
        myHospital.getpatients().add(patient7);
        myHospital.getpatients().add(patient8);
        myHospital.getpatients().add(patient9);

        myHospital.getpatients().add(patient10);
        myHospital.getpatients().add(patient11);
        myHospital.getpatients().add(patient12);
        myHospital.getpatients().add(patient13);
        myHospital.getpatients().add(patient14);
        myHospital.getpatients().add(patient15);
        myHospital.getpatients().add(patient16);
        myHospital.getpatients().add(patient17);
        myHospital.getpatients().add(patient18);
        myHospital.getpatients().add(patient19);

        myHospital.getpatients().add(patient20);
        myHospital.getpatients().add(patient21);
        myHospital.getpatients().add(patient22);
        myHospital.getpatients().add(patient23);
        myHospital.getpatients().add(patient24);
        myHospital.getpatients().add(patient25);
        myHospital.getpatients().add(patient26);
        myHospital.getpatients().add(patient27);
        myHospital.getpatients().add(patient28);
        myHospital.getpatients().add(patient29);
        myHospital.getpatients().add(patient30);


        myHospital.getappointments().add(appointment1);
        myHospital.getappointments().add(appointment2);
        myHospital.getappointments().add(appointment3);
        myHospital.getappointments().add(appointment4);
        myHospital.getappointments().add(appointment5);
        myHospital.getappointments().add(appointment6);
        myHospital.getappointments().add(appointment7);
        myHospital.getappointments().add(appointment8);
        myHospital.getappointments().add(appointment9);

        myHospital.getappointments().add(appointment10);
        myHospital.getappointments().add(appointment11);
        myHospital.getappointments().add(appointment12);
        myHospital.getappointments().add(appointment13);
        myHospital.getappointments().add(appointment14);
        myHospital.getappointments().add(appointment15);
        myHospital.getappointments().add(appointment16);
        myHospital.getappointments().add(appointment17);
        myHospital.getappointments().add(appointment18);
        myHospital.getappointments().add(appointment19);

        myHospital.getappointments().add(appointment20);
        myHospital.getappointments().add(appointment21);
        myHospital.getappointments().add(appointment22);
        myHospital.getappointments().add(appointment23);
        myHospital.getappointments().add(appointment24);
        myHospital.getappointments().add(appointment25);
        myHospital.getappointments().add(appointment26);
        myHospital.getappointments().add(appointment27);
        myHospital.getappointments().add(appointment28);
        myHospital.getappointments().add(appointment29);
        myHospital.getappointments().add(appointment30);

        myHospital.gettests().add(covidTest);
        myHospital.gettests().add(bloodTest);
        myHospital.gettests().add(radiologicalTest);

        myHospital.addAlltoPMap();
        myHospital.addAlltoWMap();

        myHospital.navigationDepartments = graphNav;
        
   
        boolean flag = true;
        while(flag)
        {
            try{
                mainMenu(myHospital);
                flag = false;
            }catch(Exception e)
            {
                System.out.println(e+ "\n Invalid input try again.");
            }
    
        }
    }

    public static void mainMenu(HMSystem myHospital)
    {
        System.out.println("\n\t\tHospital Management System");
        Scanner sc = new Scanner(System.in);
        int input;
        boolean loop = true;
        String mail;
        String password;
        
        while(loop){
            System.out.println("\nCHOOSE AN OPTION BETWEEN 1 AND 2\n");
            System.out.println("1) Personel Log-in");
            System.out.println("2) Patient Log-in");
            System.out.println("3) Log out");

            input = sc.nextInt();
            System.out.println("\n");

            if(input == 1)
            {
                System.out.print("Mail:");
                mail = sc.next();
                System.out.println("\n"+mail);
                System.out.print("Password:");
                password = sc.next();
                
                myHospital.addAlltoWMap();
                Worker temp = myHospital.getwmap().get(mail);

                if(temp == null)
                    System.out.println("Invalid mail.");
                else if(temp.getPassword().compareTo(password) == 0)
                {
                    if(temp.getClass() == Doctor.class)
                        try{myHospital.doctorMenu((Doctor)temp);}catch(Exception e){System.out.println(e+ "\n Invalid input try again.");}
                        
                    
                    else if(temp.getClass() == Advisor.class)
                        try{myHospital.ADVMenu((Advisor)temp);}catch(Exception e){System.out.println(e+ "\n Invalid input try again.");}
                
                    else if(temp.getClass() == Secreter.class)
                        try{myHospital.secreterMenu((Secreter)temp);}catch(Exception e){System.out.println(e+ "\n Invalid input try again.");}
                
                    else if(temp.getClass() == Nurse.class)
                        try{myHospital.NurseMenue((Nurse)temp);}catch(Exception e){System.out.println(e+ "\n Invalid input try again.");} 
                    
                    else if(temp.getClass() == Manager.class)
                        try{myHospital.managerMenu((Manager)temp);}catch(Exception e){System.out.println(e+ "\n Invalid input try again.");}
                    
                    else if(temp.getClass() == Technician.class)
                        try{myHospital.technicianMenu((Technician)temp);}catch(Exception e){System.out.println(e+ "\n Invalid input try again.");}
                        
                    
                    else
                        System.out.println("Invalid Mail or Password ");        
                }                      
                else
                    System.out.println("Invalid Password.");

            }
            else if(input == 2)
            {
                try{
                    myHospital.patientMenu();
                }catch(Exception e){System.out.println(e+ "\n Invalid input try again.");}
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
}

