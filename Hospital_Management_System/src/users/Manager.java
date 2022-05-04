package users;
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
        worker1.setID(worker2.getID());
        worker1.setAge(worker2.getAge());
        worker1.setUsername(worker2.getUsername());
        worker1.setPassword(worker2.getPassword());
    }

    public void removeDepartment(Department department){
        HMSystem.departments.remove(department);
    }

    public void inquiryStocks(Product product){
        product.checkStocks();
    }

    public void addDepartment(Department department){
        Department newDep = new Department(department);
        HMSystem.departments.add(newDep);
    }

    public void orderProduct(Product product){
        product.order();
    }

    public void addStaff(Worker worker){
        HMSystem.workers.add(worker);
    }

    public void removeStaff(Worker worker){
        HMSystem.workers.remove(worker);
    }

    public void displayPatientInfo(Patient patient){
        patient.displayPrescriptions();
        patient.displayDoctors();
        patient.displayRecords();
    }

}