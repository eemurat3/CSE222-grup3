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
    private ArrayList<Advisor> advisors;
    //TODO appointments type can be different
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
     */
    public Advisor getAdvisoryStaff(Integer advisorID){
        for(Advisor i : advisors){
            if(i.id == advisorID)
                return i;
        }
    }

    /**
     * Add new advisory staff
     */
    public void addAdvisorStaff(Advisor advisor){
        advisors.add(advisor);
    }

    /**
     * Remove a advisory staff
     */
    public void removeAdvisorStaff(int advisorID){
        for(int i = 0; i < advisors.size(); i++){
            if(advisors.get(i).id == advisorID)
                advisors.remove(i);
        }
    }

    /**
     * Get a apoointment by appointment id
     */
    public Appointment getAppointment (Integer appointmentID){
        for(Appointment i : appointments){
            if(i.id == appointmentID)
                return i;
        }
    }

    /**
     * Add new appointment
     */
    public void addAppointment(Appointment appointment){
        appointments.add(appointment);
    }

    /**
     * Remove a appointment
     */
    public void removeAppointment(int appointmentID){
        for(int i = 0; i < advisors.size(); i++){
            if(appointments.get(i).id == appointmentID)
                appointments.remove(i);
        }
    }
}
