package departments;

/**
 *
 * @author harunerenozkaya
 *
 */

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

import system.Appointment;
import users.Advisor;

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
        for(int i = 0; i < advisors.size(); i++){
            if(appointments.get(i).getId().equals(appointmentID))
                appointments.remove(i);
        }
    }
}
