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


        Doctor doctor = new Doctor("doctorName", "doctorSurname", "1", age++, email, password);
        Nurse nurse = new Nurse("nurseName", "nurseSurname", id, age++, email, password);
        Technician technician = new Technician("technicianName", "technicianSurname", id, age++," username", password);
        Patient patient = new Patient("patientName", "patientSurname", "0", age++);
        Patient patient1 = new Patient("patientName1", "patientSurname1", "1", age++);
        Secreter secreter = new Secreter("secreterName", "secreterSurname", id, age++, email, password);
        Advisor advisor = new Advisor("advisorName", "advisorSurname", id, age++, "username", password);
        advisor.setDepartment(new Polyclinic("departmentName", 0));

        Manager manager = new Manager("managerName", "managerSurname", id, age++, email, password);

        Polyclinic polyclinic = new Polyclinic("departmentName", 0);
        Lab lab = new Lab("departmentName", 1);
        Reception reception = new Reception("departmentName", 2);

        Appointment appointment = new Appointment(polyclinic, doctor, patient, date);
        Appointment appointment1 = new Appointment(polyclinic, doctor, patient1, date);
        Prescription prescription = new Prescription("prescID", patient.getId(), "Med", "Inst", "newNote");
        
        CovidTest covidTest = new CovidTest(patient.getId(), testID);
        BloodTest bloodTest = new BloodTest(patient.getId(), testID + "-1");
        RadiologicalTest radiologicalTest = new RadiologicalTest(patient.getId(), testID + "-2");


        doctor.addAppointment(appointment);
        doctor.addAppointment(appointment1);
        doctor.setSecreter(secreter);
        doctor.setDepartment(polyclinic);

        patient.addAppointment(appointment);
        patient.addPrescription(prescription);
        patient.addTest(covidTest);

        patient1.addAppointment(appointment1);
        patient1.addPrescription(prescription);
        patient1.addTest(covidTest);
        
        
        secreter.addPrescription(prescription);

        polyclinic.addDoctor(doctor);
        polyclinic.addNurse(nurse);
        polyclinic.addPatients(patient);
        polyclinic.addPatients(patient1);
        polyclinic.addSecreter(secreter);

        lab.addClinicalTechnician(technician);
        lab.addOldTest(covidTest);
        lab.addWaitingTest(radiologicalTest);
        lab.addWaitingTest(bloodTest);

        reception.addAdvisorStaff(advisor);
        reception.addAppointment(appointment);
        reception.addAppointment(appointment1);

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
        myHospital.users.add(patient1);

        myHospital.patients.add(patient);
        myHospital.patients.add(patient1);

        myHospital.appointments.add(appointment);
        myHospital.appointments.add(appointment1);

        myHospital.tests.add(covidTest);
        myHospital.tests.add(bloodTest);
        myHospital.tests.add(radiologicalTest);

        

        myHospital.doctorMenu(doctor);
        myHospital.ADVMenu(advisor);
        myHospital.secreterMenu(secreter);
        myHospital.doctorMenu(doctor);

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

