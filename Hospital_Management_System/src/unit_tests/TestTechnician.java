
/**
 * TestTechnician
 */

import src.*;

public class TestTechnician {

    public static void testTechnician() {
        
        Technician technician = new Technician("hasan", "onder", "234678", 22, "hasan", "onder");

        BinarySearchTree<Test> covidTests = new BinarySearchTree<>();
        BinarySearchTree<Test> bloodTests = new BinarySearchTree<>();
        BinarySearchTree<Test> radiologicalTests = new BinarySearchTree<>();


        technician.takeCovidTest(new CovidTest("123", true), covidTests);
         // Attempting Same Test Addition
        technician.takeCovidTest(new CovidTest("123", true), covidTests);

        technician.takeCovidTest(new CovidTest("234", false), covidTests);
        technician.takeCovidTest(new CovidTest("345"), covidTests);
        

        technician.takeBloodTest(new BloodTest("123"), bloodTests);
        technician.takeBloodTest(new BloodTest("345"), bloodTests);

        
        technician.takeRadiologicalTest(new RadiologicalTest("123", "png", "MR"), radiologicalTests);
        technician.takeRadiologicalTest(new RadiologicalTest("345", "png", "X-RAY"), radiologicalTests);
        technician.takeRadiologicalTest(new RadiologicalTest("432", "png", "PET"), radiologicalTests);


        System.out.println("\n\tCOVID TESTS");
        technician.displayCovidTests(covidTests);
        System.out.println("\n\tBLOOD TESTS");
        technician.displayBloodTests(bloodTests);
        System.out.println("\n\tRADIOLOGICAL TESTS");
        technician.displayRadiologicalTests(radiologicalTests);

        System.out.print("-------------------UPDATED TESTS-------------------");

        CovidTest updateCovidTest = new CovidTest("123", false);
        CovidTest updateCovidTest2 = new CovidTest("234", true);
        technician.updateCovidTest(updateCovidTest, covidTests);
        technician.updateCovidTest(updateCovidTest2, covidTests);

        BloodTest updateBloodTest = new BloodTest("123");
        technician.updateBloodTest(updateBloodTest, bloodTests);
        
        RadiologicalTest updateRadiologicalTest = new RadiologicalTest("123", "jpeg", "PET");
        technician.updateRadiologicalTest(updateRadiologicalTest, radiologicalTests);

        System.out.println("\n\tCOVID TESTS");
        technician.displayCovidTests(covidTests);
        System.out.println("\n\tBLOOD TESTS");
        technician.displayBloodTests(bloodTests);
        System.out.println("\n\tRADIOLOGICAL TESTS");
        technician.displayRadiologicalTests(radiologicalTests);        


        {
            Technician test = new Technician("name", "surname", "id", 11, "username", "password");
            BinarySearchTree<Test> covidTest1000 = new BinarySearchTree<>();
            
            long startTime = System.nanoTime();
            for (Integer i = 0; i < 1000; i++) {
                test.takeCovidTest(new CovidTest(i.toString()), covidTest1000);
            }
            long endTime = System.nanoTime();

            System.out.println("\nTotal time(ms) for adding 1000 covidTest = "  + ((endTime-startTime) / 1000));
        }

        {
            Technician test = new Technician("name", "surname", "id", 11, "username", "password");
            BinarySearchTree<Test> covidTest10000 = new BinarySearchTree<>();
            
            long startTime = System.nanoTime();
            for (Integer i = 0; i < 10000; i++) {
                test.takeCovidTest(new CovidTest(i.toString()), covidTest10000);
            }
            long endTime = System.nanoTime();

            System.out.println("\nTotal time(ms) for adding 10000 covidTest = "  + ((endTime-startTime) / 1000));
        }        

        {
            Technician test = new Technician("name", "surname", "id", 11, "username", "password");
            BinarySearchTree<Test> bloodTest1000 = new BinarySearchTree<>();
            
            long startTime = System.nanoTime();
            for (Integer i = 0; i < 1000; i++) {
                test.takeBloodTest(new BloodTest(i.toString()), bloodTest1000);
            }
            long endTime = System.nanoTime();

            System.out.println("\nTotal time(ms) for adding 1000 bloodTest = "  + ((endTime-startTime) / 1000));
        }

        {
            Technician test = new Technician("name", "surname", "id", 11, "username", "password");
            BinarySearchTree<Test> bloodTest10000 = new BinarySearchTree<>();
            
            long startTime = System.nanoTime();
            for (Integer i = 0; i < 10000; i++) {
                test.takeBloodTest(new BloodTest(i.toString()), bloodTest10000);
            }
            long endTime = System.nanoTime();

            System.out.println("\nTotal time(ms) for adding 10000 bloodTest = "  + ((endTime-startTime) / 1000));
        }
        
        {
            Technician test = new Technician("name", "surname", "id", 11, "username", "password");
            BinarySearchTree<Test> radiological1000 = new BinarySearchTree<>();
            
            long startTime = System.nanoTime();
            for (Integer i = 0; i < 1000; i++) {
                test.takeRadiologicalTest(new RadiologicalTest(i.toString()), radiological1000);
            }
            long endTime = System.nanoTime();

            System.out.println("\nTotal time(ms) for adding 1000 radiologicalTest = "  + ((endTime-startTime) / 1000));
        }

        {
            Technician test = new Technician("name", "surname", "id", 11, "username", "password");
            BinarySearchTree<Test> radiological10000 = new BinarySearchTree<>();
            
            long startTime = System.nanoTime();
            for (Integer i = 0; i < 10000; i++) {
                test.takeRadiologicalTest(new RadiologicalTest(i.toString()), radiological10000);
            }
            long endTime = System.nanoTime();

            System.out.println("\nTotal time(ms) for adding 10000 radiologicalTest = "  + ((endTime-startTime) / 1000));
        }         

    }

    public static void main(String[] args) {
        
        testTechnician();
    }
}
