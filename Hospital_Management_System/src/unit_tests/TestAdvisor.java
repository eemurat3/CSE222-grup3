package unit_tests;
import users.*;
import departments.*;

public class TestAdvisor {

    /**
     * It creates an Advisor object, adds 3 patients to it, and then prints the queue
     */
    public static void testAdvisor() {
        
        Advisor test = new Advisor("hasan", "onder", "3248", 22, "hasan", "onder");

        test.addPatient(new Patient("xxx", "xxx", "123", 15));
        
        System.out.print(test.displayQueue());

        // Attempting Same Patient Addition
        test.addPatient(new Patient("xxx", "xxx", "123", 15));

        System.out.print(test.displayQueue());

        test.addPatient(new Patient("aaa", "aaa", "456", 21));

        System.out.print(test.displayQueue());

        {
            Advisor patient1000 = new Advisor("hasan", "onder", "3248", 22, "hasan", "onder");
            long startTime = System.nanoTime();

            for (Integer i = 0; i < 1000; i++) 
                patient1000.addPatient(new Patient("name", "surname", i.toString() , 30));
            
                long endTime = System.nanoTime();

            System.out.println("\nTotal time(ms) for adding 1000 patient =  "  + ((endTime-startTime) / 1000));
        }

        {
            Advisor patient10000 = new Advisor("hasan", "onder", "3248", 22, "hasan", "onder");
            long startTime = System.nanoTime();
            for (Integer i = 0; i < 10000; i++)
                patient10000.addPatient(new Patient("name", "surname", i.toString() , 30));
    
            long endTime = System.nanoTime();
    
            System.out.println("\nTotal time(ms) for adding 10000 patient = "  + ((endTime-startTime) / 1000)); 
        }
        


    }    

    /**
     * The function `testAdvisor()` creates a new `Advisor` object, and then calls the `getAdvice()`
     * method on that object
     */
    public static void main(String[] args) {
        
        testAdvisor();

    }
}
