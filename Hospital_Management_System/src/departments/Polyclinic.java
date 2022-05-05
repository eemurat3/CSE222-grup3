package departments;
/**
 * 
 * @author murat Kaymaz
 *
 */
import users.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

//import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
public class Polyclinic extends Department {
	/**
	 * polyclinic doctor list
	 */
	private ArrayList<Doctor> doctors = new ArrayList<>();
	/**
	 * polyclinic nurse list
	 */
	private ArrayList<Nurse> nurses = new ArrayList<>();
	/**
	 * polyclinic secreter list
	 */
	private ArrayList<Secreter> secreters = new ArrayList<>();
	/***
	 * polyclinic patient queue
	 */
	private Queue<Patient> patients = new PriorityQueue<>();
	/**
	 * default constructor
	 */
	public Polyclinic() {
		/*doctors   = ;
	    nurses    = new ArrayList<Nurse>();
	    secreters = new ArrayList<Secreter>();
	    patients  = new Queue<Patient>();*/
	}
	/**
	* one parameter constructor
	*/
	public Polyclinic(String name) {
		setName(name);
	}
	/**
	 * add new doctor to polyclinc
	 * @param d : new doctor
	 */
	public void addDoctor(Doctor d) {
		doctors.add(d);
	}
	/**
	 * add new nurse to polyclinc
	 * @param n : new nurse
	 */
	public void addNurse(Nurse n) {
		nurses.add(n);
	}
	/**
	 * add new secreter to polyclinc
	 * @param s : new secreter
	 */
	public void addSecreter(Secreter s) {
		secreters.add(s);
	}
	/**
	 * add new patients to patients queue
	 * @param p : new patient
	 */
	public void addPatients(Patient p) {
		patients.add(p);
	}
	/**
	 * get the doctors list of the polyclinic 
	 * @return : doctors list
	 */
	public ArrayList<Doctor> getDoctors() {
		return doctors;
	}
	/**
	 * get the nurses list of the polyclinic 
	 * @return : nurses list
	 */
	public ArrayList<Nurse> getNurses() {
		return nurses;
	}
	/**
	 * get the secreters list of the polyclinic 
	 * @return : secreters list
	 */
	public ArrayList<Secreter> getSecreters() {
		return secreters;
	}
	/**
	 * get the patients queue of the polyclinic 
	 * @return : patients Queue
	 */
	public Queue<Patient>  getPatients() {
		return patients;
	}
	/**
	 * Search doctor in the polyclinic doctors list
	 * @param name : doctor name
	 * @param surname : doctor surname
	 * @return : index doctor is find else -1
	 */
	public int findDoctor(String name,String surname) {
		for(int i=0;i<doctors.size();i++) {
			if(doctors.get(i).getName().equals(name) && doctors.get(i).getSurname().equals(surname))
				return i;
		}
		return -1;
	}
	/**
	 * Search Nurse in the polyclinic nurses list
	 * @param name : nurse name
	 * @param surname : nurse surname
	 * @return : index nurse is find else -1
	 */
	public int findNurse(String name,String surname) {
		for(int i=0;i<nurses.size();i++) {
			if(nurses.get(i).getName() == name && nurses.get(i).getSurname()==surname)
				return i;
		}
		return -1;
	}
	/**
	 * Search secreter in the polyclinic secreters list
	 * @param name : secreter name
	 * @param surname : secreter surname
	 * @return : index secreter is find else -1
	 */
	public int findSecreter(String name,String surname) {
		for(int i=0;i<secreters.size();i++) {
			if(secreters.get(i).getName() == name && secreters.get(i).getSurname()==surname)
				return i;
		}
		return -1;
	}
	/**
	 * Search patient in the polyclinic patients queue
	 * @param name : patient name
	 * @param surname : patient surname
	 * @return : index patient is find else -1
	 */
	public int findPatient(String name,String surname) {
		int index=0;
		Iterator<Patient> itr = patients.iterator();
	    while(itr.hasNext()){
	    	Patient p = itr.next();
	    	if(p.getName() == name && p.getSurname() == surname) {
	    		return index;
	    	}
	        index++;
	    }
		return -1;
	}
	/**
	 * delete existing doctor in the polyclinic doctor list
	 * @param name : doctor name
	 * @param surname : doctor surname
	 * @return null doctor is not finded else deleting doctor object
	 */
	public Doctor deleteDoctor(String name,String surname) {
		int index = findDoctor(name,surname);
		if(index >= 0) {
			Doctor deleted = doctors.get(index);
			doctors.remove(index);
			return deleted;
		}
		return null;
	}
	/**
	 * delete existing nurse in the polyclinic nurse list
	 * @param name : nurse name
	 * @param surname : nurse surname
	 * @return  null nurse is not finded else deleting nurse object
	 */
	public Nurse deleteNurse(String name,String surname) {
		int index = findNurse(name,surname);
		if(index >= 0) {
			Nurse deleted = nurses.get(index);
			nurses.remove(index);
			return deleted;
		}
		return null;
	}
	/**
	 * delete existing secreter in the polyclinic secreter list
	 * @param name : secreter name
	 * @param surname : secreter surname
	 * @return  null secreter is not finded else deleting secreter object
	 */
	public Secreter deleteSecreter(String name,String surname) {
		int index = findSecreter(name,surname);
		if(index >= 0) {
			Secreter deleted = secreters.get(index);
			secreters.remove(index);
			return deleted;
		}
		return null;
	}
	/**
	 * delete existing patient in the polyclinic patient queue
	 * @param name : patient name
	 * @param surname : patient surname
	 * @return  null patient is not finded else deleting patient object
	 */
	public Patient deletePatient(String name,String surname) {
		int index = findPatient(name,surname);
		if(index >= 0) {
			Object[] arr =  patients.toArray();
			Patient deleted = (Patient)arr[index];
			System.out.println("name : "+ deleted.getName()+" "+deleted.getSurname());
			patients.remove(deleted);
			return deleted;
		}
		return null;
	}
}
