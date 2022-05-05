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

public class Reception {
    /**
	 * advisor list
	 */
    private ArrayList<Advisor> advisors;

    //TODO appointments type can be different

    /**
	 * appointment list
	 */
    private ArrayList<Appointment> appointments;
    
    
    public Reception(){
        advisors = new ArrayList<Advisor>();
        appointments = new ArrayList<Appointment>();
    }

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

    public static void main(String[] args){

        ArrayList<Advisor> advisorsT = new ArrayList<>();
        ArrayList<Appointment> appointmentsT = new ArrayList<>();

        /* Fill technicians and tests*/

        for(int i=0;i<10;i++){
            advisorsT.add(new Advisor("a", "b",String.valueOf(i), 0, "username", "password"));
        }
        for(int i=0;i<10;i++){
            appointmentsT.add(new Appointment(new Polyclinic(), new Doctor("name", "surname", String.valueOf(i), 0, "email", "password"), new Patient("name", "surname", String.valueOf(i), 0), new Date()));
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

        /*
        lab.addTest(new BloodTest("11"));
        lab.addTest(new BloodTest("12"));
        lab.addClinicalTechnician(new Technician("kemal", "leman", "11", 0, "ms", "sm"));
        lab.addClinicalTechnician(new Technician("kemal", "leman", "12", 0, "ms", "sm"));
        lab.removeTest("12");
        lab.removeClinicalTechnician("12");*/
		
		/** Data after modifying */

        
        //System.out.println("/** Data after modifying */\n");

		//System.out.println(lab);
        
		/* Performance Testing */

        //System.out.println("/* Performance Testing */\n");
        
        //100 item
        //tests

        /*
        String[] ID100 = new String[100]; 
		for(int i = 0; i < 100; i++){
			Integer nextint = (int) (3200 * Math.random());
			ID100[i] = nextint.toString();	
		}

        TreeMap<String,Test> tests100 = new TreeMap<>();
        ArrayList<Technician> technicians100 = new ArrayList<>();

        double sum;
        double start = 0;
        double end1 = 0; 

        start = System.nanoTime(); 
        for(int i = 0; i < 100; i++){
            tests100.put(String.valueOf(i), new BloodTest(String.valueOf(i)));
        }
        end1 = System.nanoTime(); 
        sum = (end1 - start); 
        
        System.out.println("Run Time for 100 test: " + sum / 1000000000);

        //100 item
        //technicians

        double sumTec;
        double startTec = 0;
        double end1Tec = 0; 

        startTec = System.nanoTime(); 
        for(int i = 0; i < 100; i++){
            technicians100.add(new Technician("a","b",String.valueOf(i), 0, "c", "d"));
        }
        end1Tec = System.nanoTime(); 
        sumTec = (end1Tec - startTec); 
        
        System.out.println("Run Time for 100 technician: " + sumTec / 1000000000);*/
        
        /*--------------------------------------------*/

        /*
        //1000 item
        //tests

        String[] ID1000 = new String[1000]; 
		for(int i = 0; i < 1000; i++){
			Integer nextint = (int) (32000 * Math.random());
			ID1000[i] = nextint.toString();	
		}

        TreeMap<String,Test> tests1000 = new TreeMap<>();

        double sum2;
        double start2 = 0;
        double end2 = 0; 

        start2 = System.nanoTime(); 
        for(int i = 0; i < 1000; i++){
            tests1000.put(String.valueOf(i), new BloodTest(String.valueOf(i)));
        }
        end2 = System.nanoTime(); 
        sum2 = (end2 - start2); 
        
        System.out.println("Run Time for 1000 test: " + sum2 / 1000000000);


        //1000 item
        //technician

        ArrayList<Technician> technicians1000 = new ArrayList<>();

        double sum2Tec;
        double start2Tec = 0;
        double end2Tec = 0; 

        start2Tec = System.nanoTime(); 
        for(int i = 0; i < 1000; i++){
            technicians1000.add(new Technician("a","b",String.valueOf(i), 0, "c", "d"));
        }
        end2Tec = System.nanoTime(); 
        sum2Tec = (end2Tec - start2Tec); 
        
        System.out.println("Run Time for 1000 technician: " + sum2Tec / 1000000000);
        */

        /*--------------------------------------------*/

        //10000 item
        //tests
        /*

        String[] ID10000 = new String[10000]; 
		for(int i = 0; i < 10000; i++){
			Integer nextint = (int) (320000 * Math.random());
			ID10000[i] = nextint.toString();	
		}

        TreeMap<String,Test> tests10000 = new TreeMap<>();

        double sum3;
        double start3 = 0;
        double end3 = 0; 

        start3 = System.nanoTime(); 
        for(int i = 0; i < 10000; i++){
            tests10000.put(String.valueOf(i), new BloodTest(String.valueOf(i)));
        }
        end3 = System.nanoTime(); 
        sum3 = (end3 - start3); 
        
        System.out.println("Run Time for 10000 test: " + sum3 / 1000000000);

        //10000 item
        //technician

        ArrayList<Technician> technicians10000 = new ArrayList<>();

        double sum3Tec;
        double start3Tec = 0;
        double end3Tec = 0; 

        start3Tec = System.nanoTime(); 
        for(int i = 0; i < 10000; i++){
            technicians10000.add(new Technician("a","b",String.valueOf(i), 0, "c", "d"));
        }
        end3Tec = System.nanoTime(); 
        sum3Tec = (end3Tec - start3Tec); 
        
        System.out.println("Run Time for 10000 technician: " + sum3Tec / 1000000000);
        */
	}
}
