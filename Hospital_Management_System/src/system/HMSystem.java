package system;
import tests.*;

import java.util.*;

import departments.*;
import users.*;

public class HMSystem 
{
    static public List<PriorityQueue<Appointment>> appointments = new ArrayList<>();
   
    static public List<Department> departments = new ArrayList<>();
    static public List<Patient> patients = new ArrayList<>();
    static public List<Worker> workers = new ArrayList<>();
   
    static public BinarySearchTree<User> users = new BinarySearchTree<>();

    static public Queue<Test> tests = new LinkedList<>();


    

}