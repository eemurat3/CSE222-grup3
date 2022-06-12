import java.util.Date;
import java.util.PriorityQueue;

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
        String name = "name";
        String surname = "name";
        String id = "name";
        String email = "name";
        String password = "name";
        String testID = "name";
        int age = 0;
        Date date = new Date();


        Doctor doctor = new Doctor(name, surname, id, age++, email, password);
        Nurse nurse = new Nurse(name, surname, id, age++, email, password);
        Technician technician = new Technician(name, surname, id, age++," username", password);
        Patient patient = new Patient(name, surname, id, age++);
        Secreter secreter = new Secreter(name, surname, id, age++, email, password);
        Advisor advisor = new Advisor(name, surname, id, age++, "username", password);

        Manager manager = new Manager(name, surname, id, age++, email, password);

        Polyclinic polyclinic = new Polyclinic("departmentName", 0);
        Lab lab = new Lab("departmentName", 1);
        Reception reception = new Reception("departmentName", 2);

        Appointment appointment = new Appointment(polyclinic, doctor, patient, date);
        Prescription prescription = new Prescription("prescID", patient.getId(), "Med", "Inst", "newNote");
        
        CovidTest covidTest = new CovidTest(patient.getId(), testID);
        BloodTest bloodTest = new BloodTest(patient.getId(), testID + "-1");
        RadiologicalTest radiologicalTest = new RadiologicalTest(patient.getId(), testID + "-2");


        doctor.addAppointment(appointment);
        doctor.setSecreter(secreter);

        patient.addAppointment(appointment);
        patient.addPrescription(prescription);
        patient.addTest(covidTest);
        

        secreter.addPrescription(prescription);

        polyclinic.addDoctor(doctor);
        polyclinic.addNurse(nurse);
        polyclinic.addPatients(patient);
        polyclinic.addSecreter(secreter);

        lab.addClinicalTechnician(technician);
        lab.addOldTest(covidTest);
        lab.addWaitingTest(radiologicalTest);
        lab.addWaitingTest(bloodTest);

        reception.addAdvisorStaff(advisor);
        reception.addAppointment(appointment);

        HMSystem myHospital = new HMSystem();

        myHospital.departments.add(polyclinic);
        
        myHospital.workers.add(doctor);
        myHospital.workers.add(nurse);
        myHospital.workers.add(technician);
        myHospital.workers.add(advisor);
        myHospital.workers.add(secreter);
        myHospital.workers.add(manager);

        myHospital.users.add(manager);
        myHospital.users.add(doctor);
        myHospital.users.add(nurse);
        myHospital.users.add(technician);
        myHospital.users.add(advisor);
        myHospital.users.add(secreter);
        myHospital.users.add(patient);

        myHospital.patients.add(patient);

        myHospital.appointments.add(new PriorityQueue<>());
        myHospital.appointments.get(0).add(appointment);

        myHospital.tests.add(covidTest);
        myHospital.tests.add(bloodTest);
        myHospital.tests.add(radiologicalTest);

        

        myHospital.doctorMenu(new Doctor("name", "surname", "id", 32, "email", "password"));

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
}

