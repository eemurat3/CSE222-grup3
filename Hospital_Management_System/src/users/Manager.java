package users;

import departments.Department;
import systems.HMSystem;

/**
 *
 * @author Yusuf Talha Altun
 */
public class Manager extends Worker{
    public Manager(String name, String surname, String id, int age,String email , String password) {
        super(name, surname, id, age, email ,  password);
    }

    //Fonksiyon argumani (Worker worker, String newName, String newSurname, ....) olabilir.
    public void editStaff(Worker worker1, Worker worker2){
        worker1.setName(worker2.getName());
        worker1.setSurname(worker2.getSurname());
        worker1.setId(worker2.getId());
        worker1.setAge(worker2.getAge());
        worker1.setUsername(worker2.getUsername());
        worker1.setPassword(worker2.getPassword());
    }

    public void removeDepartment(Department department){
        HMSystem.departments.remove(department);
    }

    // Department copy constructor gerekebilir 
    public void addDepartment(Department department){
        Department newDep = new Department(); // Department newDep = new Department(department);
        HMSystem.departments.add(newDep);
    }

    /**
     * This function adds a worker to the list of workers
     * @param worker The worker to be added to the system.
     */
    public void addStaff(Worker worker){
        HMSystem.workers.add(worker);
    }

    /**
     * This function removes a worker from the list of workers
     * @param worker The worker to be removed from the system.
     */
    public void removeStaff(Worker worker){
        HMSystem.workers.remove(worker);
    }

    /**
     * This function displays the patient's prescriptions, doctors, and records
     * @param patient the patient object
     */
    public void displayPatientInfo(Patient patient){
        patient.displayPrescriptions();
        patient.displayDoctors();
        patient.displayRecords();
    }

}