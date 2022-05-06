package systems;
import tests.*;

import java.util.*;

import departments.*;
import users.*;

/**
 * HMSystem is a class that contains all the data structures that are used in the program
 */
public class HMSystem 
{
    static public List<PriorityQueue<Appointment>> appointments = new ArrayList<>();
   
    static public List<Department> departments = new ArrayList<>();
    static public List<Patient> patients = new ArrayList<>();
    static public List<Worker> workers = new ArrayList<>();
   
    static public BinarySearchTree<User> users = new BinarySearchTree<>();

    static public Queue<Test> tests = new LinkedList<>();
    

}