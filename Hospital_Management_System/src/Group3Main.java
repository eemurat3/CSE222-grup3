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



        Doctor doctor1 = new Doctor("doctor1", "doctorSurname", "doc1", 33, "doc1@mail.com", "pass");
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

        myHospital.departments.add(polyclinic1);
        myHospital.departments.add(polyclinic2);
        myHospital.departments.add(polyclinic3);
        
        myHospital.workers.add(doctor1);
        myHospital.workers.add(doctor2);
        myHospital.workers.add(doctor3);
        myHospital.workers.add(doctor4);
        myHospital.workers.add(doctor5);
        myHospital.workers.add(doctor6);
        myHospital.workers.add(doctor7);
        myHospital.workers.add(doctor8);
        myHospital.workers.add(doctor9);
        myHospital.workers.add(doctor10);

        myHospital.workers.add(nurse1);

        myHospital.workers.add(technician1);

        myHospital.workers.add(advisor1);
        myHospital.workers.add(advisor2);
        myHospital.workers.add(advisor3);

        myHospital.workers.add(secreter1);
        myHospital.workers.add(secreter2);
        myHospital.workers.add(secreter3);
        myHospital.workers.add(secreter4);
        myHospital.workers.add(secreter5);
        myHospital.workers.add(secreter6);
        myHospital.workers.add(secreter7);
        myHospital.workers.add(secreter8);
        myHospital.workers.add(secreter9);
        myHospital.workers.add(secreter10);

        myHospital.workers.add(manager);

        myHospital.users.add(doctor1);
        myHospital.users.add(doctor2);
        myHospital.users.add(doctor3);
        myHospital.users.add(doctor4);
        myHospital.users.add(doctor5);
        myHospital.users.add(doctor6);
        myHospital.users.add(doctor7);
        myHospital.users.add(doctor8);
        myHospital.users.add(doctor9);
        myHospital.users.add(doctor10);

        myHospital.users.add(nurse1);

        myHospital.users.add(technician1);

        myHospital.users.add(advisor1);
        myHospital.users.add(advisor2);
        myHospital.users.add(advisor3);

        myHospital.users.add(secreter1);
        myHospital.users.add(secreter2);
        myHospital.users.add(secreter3);
        myHospital.users.add(secreter4);
        myHospital.users.add(secreter5);
        myHospital.users.add(secreter6);
        myHospital.users.add(secreter7);
        myHospital.users.add(secreter8);
        myHospital.users.add(secreter9);
        myHospital.users.add(secreter10);

        myHospital.users.add(manager);


        myHospital.users.add(patient1);
        myHospital.users.add(patient2);
        myHospital.users.add(patient3);
        myHospital.users.add(patient4);
        myHospital.users.add(patient5);
        myHospital.users.add(patient6);
        myHospital.users.add(patient7);
        myHospital.users.add(patient8);
        myHospital.users.add(patient9);

        myHospital.users.add(patient10);
        myHospital.users.add(patient11);
        myHospital.users.add(patient12);
        myHospital.users.add(patient13);
        myHospital.users.add(patient14);
        myHospital.users.add(patient15);
        myHospital.users.add(patient16);
        myHospital.users.add(patient17);
        myHospital.users.add(patient18);
        myHospital.users.add(patient19);

        myHospital.users.add(patient20);
        myHospital.users.add(patient21);
        myHospital.users.add(patient22);
        myHospital.users.add(patient23);
        myHospital.users.add(patient24);
        myHospital.users.add(patient25);
        myHospital.users.add(patient26);
        myHospital.users.add(patient27);
        myHospital.users.add(patient28);
        myHospital.users.add(patient29);
        myHospital.users.add(patient30);


        myHospital.patients.add(patient1);
        myHospital.patients.add(patient2);
        myHospital.patients.add(patient3);
        myHospital.patients.add(patient4);
        myHospital.patients.add(patient5);
        myHospital.patients.add(patient6);
        myHospital.patients.add(patient7);
        myHospital.patients.add(patient8);
        myHospital.patients.add(patient9);

        myHospital.patients.add(patient10);
        myHospital.patients.add(patient11);
        myHospital.patients.add(patient12);
        myHospital.patients.add(patient13);
        myHospital.patients.add(patient14);
        myHospital.patients.add(patient15);
        myHospital.patients.add(patient16);
        myHospital.patients.add(patient17);
        myHospital.patients.add(patient18);
        myHospital.patients.add(patient19);

        myHospital.patients.add(patient20);
        myHospital.patients.add(patient21);
        myHospital.patients.add(patient22);
        myHospital.patients.add(patient23);
        myHospital.patients.add(patient24);
        myHospital.patients.add(patient25);
        myHospital.patients.add(patient26);
        myHospital.patients.add(patient27);
        myHospital.patients.add(patient28);
        myHospital.patients.add(patient29);
        myHospital.patients.add(patient30);


        myHospital.appointments.add(appointment1);
        myHospital.appointments.add(appointment2);
        myHospital.appointments.add(appointment3);
        myHospital.appointments.add(appointment4);
        myHospital.appointments.add(appointment5);
        myHospital.appointments.add(appointment6);
        myHospital.appointments.add(appointment7);
        myHospital.appointments.add(appointment8);
        myHospital.appointments.add(appointment9);

        myHospital.appointments.add(appointment10);
        myHospital.appointments.add(appointment11);
        myHospital.appointments.add(appointment12);
        myHospital.appointments.add(appointment13);
        myHospital.appointments.add(appointment14);
        myHospital.appointments.add(appointment15);
        myHospital.appointments.add(appointment16);
        myHospital.appointments.add(appointment17);
        myHospital.appointments.add(appointment18);
        myHospital.appointments.add(appointment19);

        myHospital.appointments.add(appointment20);
        myHospital.appointments.add(appointment21);
        myHospital.appointments.add(appointment22);
        myHospital.appointments.add(appointment23);
        myHospital.appointments.add(appointment24);
        myHospital.appointments.add(appointment25);
        myHospital.appointments.add(appointment26);
        myHospital.appointments.add(appointment27);
        myHospital.appointments.add(appointment28);
        myHospital.appointments.add(appointment29);
        myHospital.appointments.add(appointment30);

        myHospital.tests.add(covidTest);
        myHospital.tests.add(bloodTest);
        myHospital.tests.add(radiologicalTest);

        myHospital.addAlltoPMap();
        myHospital.addAlltoWMap();

        mainMenu(myHospital);

        /*
        Doctor.main(args);
        TestAdvisor.main(args);
        Nurse.main(args);
        Patient.main(args);
        TestTechnician.main(args);
        Secreter.main(args);
        Manager.main(args);


        BloodTest.main(args);
        CovidTest.main(args);
        RadiologicalTest.main(args);
       
        Appointment.main(args);
        
        Lab.main(args);
        Reception.main(args);
        ut_polyclinic.main(args);*/
        

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
                Worker temp = HMSystem.wMap.get(mail);

                if(temp == null)
                    System.out.println("Invalid mail.");
                else if(temp.getPassword().compareTo(password) == 0)
                {
                    if(temp.getClass() == Doctor.class)
                        myHospital.doctorMenu((Doctor)temp);
                    
                    else if(temp.getClass() == Advisor.class)
                        myHospital.ADVMenu((Advisor)temp);
                
                    else if(temp.getClass() == Secreter.class)
                        myHospital.secreterMenu((Secreter)temp);
                
                    else if(temp.getClass() == Nurse.class)
                        myHospital.NurseMenue((Nurse)temp);
                    
                    else if(temp.getClass() == Manager.class)
                        myHospital.managerMenu((Manager)temp);
                    
                    else if(temp.getClass() == Technician.class)
                        myHospital.technicianMenu((Technician)temp);
                    
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
                }catch(InputMismatchException e){System.out.println(e+ "\n Invalid input try again.");}
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

