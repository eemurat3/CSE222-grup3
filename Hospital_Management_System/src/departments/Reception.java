package departments;

/**
 *
 * @author harunerenozkaya
 *
 */

import java.util.ArrayList;
import java.util.Date;

import systems.Appointment;
import users.Advisor;
import users.Doctor;
import users.Patient;

/**
 * The Reception class is a subclass of the Department class. 
 */
public class Reception extends Department{
    /**
	 * advisor list
	 */
    private ArrayList<Advisor> advisors;

    /**
	 * appointment list
	 */
    private ArrayList<Appointment> appointments;
    
    
    // A constructor.
    public Reception(){
        advisors = new ArrayList<Advisor>();
        appointments = new ArrayList<Appointment>();
    }

    // A constructor.
    public Reception(ArrayList<Advisor> advisors,ArrayList<Appointment> appointments){
        this.advisors = advisors;
        this.appointments = appointments;
    }

    /**
     * Get advisory staff by advisory id
     * @param advisorID which is unique code for advisor
     * @return a advisor object
     */
    public Advisor getAdvisoryStaff(String advisorID){
        for(Advisor i : advisors){
            if(i.getId().equals(advisorID))
                return i;
        }
        return null;
    }

    /**
     * Add new advisory staff
     * @param advisor which is an advisor object
     */
    public void addAdvisorStaff(Advisor advisor){
        advisors.add(advisor);
    }

    /**
     * Remove a advisory staff
     * @param advisorID which is unique code for advisor
     */
    public void removeAdvisorStaff(String advisorID){
        for(int i = 0; i < advisors.size(); i++){
            if(advisors.get(i).getId().equals(advisorID))
                advisors.remove(i);
        }
    }

    /**
     * Get a appointment by appointment id
     * @param appointmentID which is unique code for appointment
     * @return a appointment object
     */
    public Appointment getAppointment (String appointmentID){
        for(Appointment i : appointments){
            if(i.getId().equals(appointmentID))
                return i;
        }
        return null;
    }

    /**
     * Add new appointment
     * @param appointment which is an appointment object
     */
    public void addAppointment(Appointment appointment){
        appointments.add(appointment);
    }

    /**
     * Remove a appointment
     * @param appointmentID which is unique code for appointment
     */
    public void removeAppointment(String appointmentID){
        for(int i = 0; i < appointments.size(); i++){
            if(appointments.get(i).getId().equals(appointmentID))
                appointments.remove(i);
        }
    }

    /**
     * This function is used to print the list of Clicical Technicians and Appointments
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        

        result.append("Clicical Technicians : \n");
        for(int i=0;i<advisors.size();i++){
            result.append(i + ")" + advisors.get(i).getId()+"\n");
        }
        result.append("\n");
        result.append("Appointments : \n");
        for(int i=0;i<appointments.size();i++){
            result.append(i + ")" + appointments.get(i).getId()+"\n");
        }
        result.append("\n");

        return result.toString();
    }

    /**
     * The function creates 10 advisors and 10 appointments and adds them to the reception department.
     * Then, it adds 2 advisors and 2 appointments to the reception department. Then, it removes the
     * last 2 advisors and 2 appointments from the reception department. Finally, it prints the data of
     * the reception department
     */
    public static void main(String[] args){

        System.out.print("\n\n\t\t\t RECEPTION UNIT TESTING STARTS \n\n");

        ArrayList<Advisor> advisorsT = new ArrayList<>();
        ArrayList<Appointment> appointmentsT = new ArrayList<>();

        /* Fill technicians and tests*/

        for(int i=0;i<10;i++){
            advisorsT.add(new Advisor("a", "b",String.valueOf(i), 0, "username", "password"));
        }
        for(int i=0;i<10;i++){
            appointmentsT.add(new Appointment(new Polyclinic(), new Doctor("name", "surname", String.valueOf(i), 0, "email", "password"), new Patient("name", "surname", String.valueOf(i), 0), new Date(),String.valueOf(i)));
        }

		System.out.println("------------ Test of Reception Department ---------------");

		/** Constructor test */
        System.out.println("/** Constructor test */ \n");

        Reception reception = new Reception();
        Reception reception2 = new Reception(advisorsT,appointmentsT);

		/** Initially created test result */
        System.out.println("/** Initially created test result */ \n");

        System.out.println(reception);
        System.out.println(reception2);
		
		/** Modify methods */
        
        reception.addAdvisorStaff(new Advisor("name", "surname", "11", 0, "username", "password"));
        reception.addAppointment(new Appointment(new Polyclinic(), new Doctor("name", "surname", "11", 0, "email", "password"), new Patient("name", "surname", "11", 0), new Date(), "11"));
        reception.addAdvisorStaff(new Advisor("name", "surname", "12", 0, "username", "password"));
        reception.addAppointment(new Appointment(new Polyclinic(), new Doctor("name", "surname", "12", 0, "email", "password"), new Patient("name", "surname", "12", 0), new Date(), "12"));
        reception.removeAdvisorStaff("11");
        reception.removeAppointment("12");
		
		/** Data after modifying */

        System.out.println("/** Data after modifying */\n");

		System.out.println(reception);
        
		/* Performance Testing */

        System.out.println("/* Performance Testing */\n");
        
        //100 item
        //advisors

        
        String[] ID100 = new String[100]; 
		for(int i = 0; i < 100; i++){
			Integer nextint = (int) (3200 * Math.random());
			ID100[i] = nextint.toString();	
		}

        ArrayList<Advisor> advisors100 = new ArrayList<>();
        ArrayList<Appointment> appointments100 = new ArrayList<>();

        double sum;
        double start = 0;
        double end1 = 0; 

        start = System.nanoTime(); 
        for(int i = 0; i < 100; i++){
            advisors100.add(new Advisor("name", "surname", String.valueOf(i), 0, "username", "password"));
        }
        end1 = System.nanoTime(); 
        sum = (end1 - start); 
        
        System.out.println("Run Time for 100 advisors: " + sum / 1000000000);

        //100 item
        //appointments

        double sumApp;
        double startApp = 0;
        double end1App = 0; 

        startApp = System.nanoTime(); 
        for(int i = 0; i < 100; i++){
            appointments100.add(new Appointment(new Polyclinic(), new Doctor("name", "surname", String.valueOf(i), 0, "email", "password"), new Patient("name", "surname", String.valueOf(i), 0), new Date(), String.valueOf(i)));
        }
        end1App = System.nanoTime(); 
        sumApp = (end1App - startApp); 
        
        System.out.println("Run Time for 100 appointments: " + sumApp / 1000000000);
        
        /*--------------------------------------------*/
        //1000 item
        //advisors

        String[] ID1000 = new String[1000]; 
		for(int i = 0; i < 1000; i++){
			Integer nextint = (int) (32000 * Math.random());
			ID1000[i] = nextint.toString();	
		}

        ArrayList<Advisor> advisors1000 = new ArrayList<>();
        ArrayList<Appointment> appointments1000 = new ArrayList<>();

        double sum2;
        double start2 = 0;
        double end2 = 0; 

        start2 = System.nanoTime(); 
        for(int i = 0; i < 1000; i++){
            advisors1000.add(new Advisor("name", "surname", String.valueOf(i), 0, "username", "password"));
        }
        end2 = System.nanoTime(); 
        sum2 = (end2 - start2); 
        
        System.out.println("Run Time for 1000 advisors: " + sum2 / 1000000000);

        //1000 item
        //appointments

        double sumApp2;
        double startApp2 = 0;
        double end1App2 = 0; 

        startApp2 = System.nanoTime(); 
        for(int i = 0; i < 1000; i++){
            appointments1000.add(new Appointment(new Polyclinic(), new Doctor("name", "surname", String.valueOf(i), 0, "email", "password"), new Patient("name", "surname", String.valueOf(i), 0), new Date(), String.valueOf(i)));
        }
        end1App2 = System.nanoTime(); 
        sumApp2 = (end1App2 - startApp2); 
        
        System.out.println("Run Time for 1000 appointments: " + sumApp2 / 1000000000);

    
        /*--------------------------------------------*/
        //10000 item
        //advisors

        String[] ID10000 = new String[10000]; 
		for(int i = 0; i < 10000; i++){
			Integer nextint = (int) (320000 * Math.random());
			ID10000[i] = nextint.toString();	
		}

        ArrayList<Advisor> advisors10000 = new ArrayList<>();
        ArrayList<Appointment> appointments10000 = new ArrayList<>();

        double sum3;
        double start3 = 0;
        double end3 = 0; 

        start3 = System.nanoTime(); 
        for(int i = 0; i < 10000; i++){
            advisors10000.add(new Advisor("name", "surname", String.valueOf(i), 0, "username", "password"));
        }
        end3 = System.nanoTime(); 
        sum3 = (end3 - start3); 
        
        System.out.println("Run Time for 10000 advisors: " + sum3 / 1000000000);

        //10000 item
        //appointments

        double sumApp3;
        double startApp3 = 0;
        double end1App3 = 0; 

        startApp3 = System.nanoTime(); 
        for(int i = 0; i < 10000; i++){
            appointments10000.add(new Appointment(new Polyclinic(), new Doctor("name", "surname", String.valueOf(i), 0, "email", "password"), new Patient("name", "surname", String.valueOf(i), 0), new Date(), String.valueOf(i)));
        }
        end1App3 = System.nanoTime(); 
        sumApp3 = (end1App3 - startApp3); 
        
        System.out.println("Run Time for 10000 appointments: " + sumApp3 / 1000000000);
        System.out.print("\n\n\t\t\t RECEPTION UNIT TESTING ENDS \n\n");

	}
}
