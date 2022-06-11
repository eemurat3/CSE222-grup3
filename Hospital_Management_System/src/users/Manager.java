package users;

import departments.Department;
import departments.Lab;
import departments.Polyclinic;
import departments.Reception;
import systems.HMSystem;

/**
 *
 * @author Yusuf Talha Altun
 * Manager Class extends Worker Class
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
    public void addDepartment(int departmentType,String departmentName,int departmentID){
        switch(departmentType){
            //Lab
            case 0:
                HMSystem.departments.add(new Lab(departmentName,departmentID));
            //Polyclinic
            case 1:
                HMSystem.departments.add(new Polyclinic(departmentName,departmentID));
            //Reception
            case 2:
                HMSystem.departments.add(new Reception(departmentName,departmentID));
        }
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

    public static void main(String[] args) {

        System.out.print("\n\n\t\t\t MANAGER TESTING STARTS \n\n");

        System.out.println("\n\n\n------------ Testing Manager------------\n");
        
        String name = "name";
        String surname = "surname";
        String id = "id";
        int age = 30;
        String username = "username";
        String password = "password";
        Worker worker = new Worker(name, surname, id, age, username, password);
        Department dep = new Reception("wf",34);
        Patient patient = new Patient(name, surname, id, age);

        
        long startTime = System.nanoTime();
        testEditStaff(100, worker, worker);
        long endTime = System.nanoTime();
        System.out.println("Running time for editing staff in the 100 elements : " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        testEditStaff(1000, worker, worker);
        endTime = System.nanoTime();
        System.out.println("Running time for editing staff in the 1000 elements : " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        testEditStaff(10000, worker, worker);
        endTime = System.nanoTime();
        System.out.println("Running time for editing staff in the 10000 elements : " + (endTime - startTime) + " ns");



        startTime = System.nanoTime();
        testRemoveDepartment(100, dep);
        endTime = System.nanoTime();
        System.out.println("Running time for removing department in the 100 elements : " + (endTime - startTime) + " ns");
        
        startTime = System.nanoTime();
        testRemoveDepartment(1000, dep);
        endTime = System.nanoTime();
        System.out.println("Running time for removing department in the 1000 elements : " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        testRemoveDepartment(10000, dep);
        endTime = System.nanoTime();
        System.out.println("Running time for removing department in the 10000 elements : " + (endTime - startTime) + " ns");



        startTime = System.nanoTime();
        testAddDepartment(100, dep);
        endTime = System.nanoTime();
        System.out.println("Running time for adding department in the 100 elements : " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        testAddDepartment(1000, dep);
        endTime = System.nanoTime();
        System.out.println("Running time for adding department in the 1000 elements : " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        testAddDepartment(10000, dep);
        endTime = System.nanoTime();
        System.out.println("Running time for adding department in the 10000 elements : " + (endTime - startTime) + " ns");



        startTime = System.nanoTime();
        testAddStaff(100, worker);
        endTime = System.nanoTime();
        System.out.println("Running time for adding staff in the 100 elements : " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        testAddStaff(1000, worker);
        endTime = System.nanoTime();
        System.out.println("Running time for adding staff in the 1000 elements : " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        testAddStaff(10000, worker);
        endTime = System.nanoTime();
        System.out.println("Running time for adding staff in the 10000 elements : " + (endTime - startTime) + " ns");



        startTime = System.nanoTime();
        testRemoveStaff(100, worker);
        endTime = System.nanoTime();
        System.out.println("Running time for removing staff in the 100 elements : " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        testRemoveStaff(1000, worker);
        endTime = System.nanoTime();
        System.out.println("Running time for removing staff in the 1000 elements : " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        testRemoveStaff(10000, worker);
        endTime = System.nanoTime();
        System.out.println("Running time for removing staff in the 10000 elements : " + (endTime - startTime) + " ns");



        startTime = System.nanoTime();
        testDisplayPatientInfo(100, patient);
        endTime = System.nanoTime();
        System.out.println("Running time for displaying patient info in the 100 elements : " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        testDisplayPatientInfo(1000, patient);
        endTime = System.nanoTime();
        System.out.println("Running time for displaying patient info in the 1000 elements : " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        testDisplayPatientInfo(10000, patient);
        endTime = System.nanoTime();
        System.out.println("Running time for displaying patient info in the 10000 elements : " + (endTime - startTime) + " ns");
    
        System.out.print("\n\n\t\t\t MANAGER TESTING ENDS \n\n");
    
    }


    public static void testEditStaff(int counter, Worker w1, Worker w2){
        Manager manager = new Manager("name", "surname", "id", 30, "email", "password");
        for(int i = 0 ; i < counter ; i++){
            manager.editStaff(w1, w2);
        }
    }

    public static void testRemoveDepartment(int counter, Department dep){
        Manager manager = new Manager("name", "surname", "id", 30, "email", "password");
        for(int i = 0 ; i < counter ; i++){
            manager.removeDepartment(dep);
        }
    }

    public static void testAddDepartment(int counter, Department dep){
        Manager manager = new Manager("name", "surname", "id", 30, "email", "password");
        for(int i = 0 ; i < counter ; i++){
            manager.addDepartment(0,"d",i);
        }     
    }

    public static void testAddStaff(int counter, Worker worker){
        Manager manager = new Manager("name", "surname", "id", 30, "email", "password");
        for(int i = 0 ; i < counter ; i++){
            manager.addStaff(worker);
        }
    }

    public static void testRemoveStaff(int counter, Worker worker){
        Manager manager = new Manager("name", "surname", "id", 30, "email", "password");
        for(int i = 0 ; i < counter ; i++){
            manager.removeStaff(worker);
        }   
    }

    public static void testDisplayPatientInfo(int counter, Patient patient){
        Manager manager = new Manager("name", "surname", "id", 30, "email", "password");
        for(int i = 0 ; i < counter ; i++){
            manager.displayPatientInfo(patient);
        }
    }
    
}