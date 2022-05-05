package tests;

import users.BinarySearchTree;

/**
 * @author H. Tuğçe Yavuz
 */
public class BloodTest extends Test{
	private String bloodType;
	private String rH;
	private int vitaminA;
	private int vitaminD;
	private int vitaminE;
	private int hemoglobin;
	private int potassium;
	private int calcium;
  
    /**
    *  Constructor For BloodTest Class
    *  @param patientID number 
    */	
	public BloodTest(String patientID)
	{
		super(patientID);
		vitaminD = (int)(Math.random() * 100);
		vitaminA = (int)(Math.random() * 100);
		vitaminE = (int)(Math.random() * 100);
		hemoglobin = (int)(Math.random() * 20);
		potassium = (int)(Math.random() * 10);
		calcium = (int)(Math.random() * 10);
		int bloodT = (int)(Math.random() * 4);
		int rhT = (int)(Math.random() * 2);
		if(bloodT == 1)	bloodType = "0";
		else if(bloodT == 2)	bloodType = "A";
		else if(bloodT == 3)	bloodType = "B";
		else 	bloodType = "AB";
		if(rhT == 1)	rH = "+";
		else rH = "-";
	}
	
	/**No Parameter Constructor For BloodTest Class*/
	public BloodTest(){super("0");}
  
 	//getters and setters for blood test elements

	public String getBloodType(){return bloodType;}
  	public void setBloodType(String bloodType){this.bloodType = bloodType;}

	public String getRH(){return rH;}
  	public void setRH(String rH){this.rH = rH;}
  
  	public int getVitaminA(){return vitaminA;}
  	public void setVitaminA(int vitaminA){this.vitaminA = vitaminA;}
  
	public int getVitaminD(){return vitaminD;}
	public void setVitaminD(int vitaminD){this.vitaminD = vitaminD;}

	public int getVitaminE(){return vitaminE;}
  	public void setVitaminE(int vitaminE){this.vitaminE = vitaminE;}

	public int getHemoglobin(){return hemoglobin;}
  	public void setHemoglobin(int hemoglobin){this.hemoglobin = hemoglobin;}

  	public int getPotassium(){return potassium;}
  	public void setPotassium(int potassium){this.potassium = potassium;}

  	public int getCalcium(){return calcium;}	
  	public void setCalcium(int calcium){this.calcium = calcium;}
  
  	@Override
	public String toString()
	{
		return  "\nPatient's ID: " + getID() + "\nBlood Type : " + bloodType + " rH : " + rH + "\n\nBLOOD TEST RESULTS :"
			+ "\nVitamin-A : " + String.valueOf(vitaminA) + "ug/L" + "\nVitamin-D : " + String.valueOf(vitaminD) + "ug/L"
			+ "\nVitamin-E : " + String.valueOf(vitaminE) + "ug/L" + "\nHemoglobin : " + String.valueOf(hemoglobin) + "gr/dL"
			+ "\nPotassium : " + String.valueOf(potassium) + " mmol/l" + "\nCalcium : " + String.valueOf(calcium) + "mg/dL" + "\n\n";
	}

	/**
	 * performance analysis of bloodtest class
	 * @param args
	 */
	public static void main(String[] args){

		System.out.println("------------ Test of Blood Test ---------------");
        
        String ID1 = "2222222";

        /**Constructor test */

        BloodTest test1 = new BloodTest(ID1);

		/**initially created test result */
		
		System.out.println(test1);
       
        /**Setter test */

        test1.setBloodType("AB");
		test1.setRH("+");
		test1.setHemoglobin(10);
		test1.setPotassium(5);
        test1.setCalcium(2);
		test1.setVitaminA(50);
		test1.setVitaminD(70);
		test1.setVitaminE(60);


        /**Getter test after changes*/

        System.out.println("Get Blood Type: " + test1.getBloodType());      
        System.out.println("Get RH: " + test1.getRH());
		System.out.println("Get VitaminA: " + test1.getVitaminA());
		System.out.println("Get VitaminD: " + test1.getVitaminD());
		System.out.println("Get VitaminE: " + test1.getVitaminE());
		System.out.println("Get Hemoglobin: " + test1.getHemoglobin());
		System.out.println("Get Calcium: " + test1.getCalcium());
		System.out.println("Get Potassium: " + test1.getPotassium());

        System.out.println();	


		/*performance testing*/

		//randomly created patient ids for 100 patient
		String[] ID100 = new String[100]; 
		for(int i = 0; i < 100; i++){
			Integer nextint = (int) (3200 * Math.random());
			ID100[i] = nextint.toString();	
		}

		BinarySearchTree<Test> bst100 = new BinarySearchTree<>();
		double sum;
        double start = 0;
        double end1 = 0; 

        start = System.nanoTime(); 
        for(int i = 0; i < 100; i++){
			bst100.add(new BloodTest(ID100[i]));
		}
        end1 = System.nanoTime(); 
        sum = (end1 - start); 
         
        System.out.println("Run Time for 100 test: " + sum / 1000000000);
		/*-------------------------------------------------------------*/

		//randomly created patient ids for 1000 patient
		String[] ID1000 = new String[1000];
		for(int i = 0; i < 1000; i++){
			Integer nextint = (int) (3200 * Math.random());
			ID1000[i] = nextint.toString();	
		}

		BinarySearchTree<Test> bst1000 = new BinarySearchTree<>();
        start = 0;
        end1 = 0; 

        start = System.nanoTime(); 
        for(int i = 0; i < 1000; i++){
			bst1000.add(new BloodTest(ID1000[i]));
		}
        end1 = System.nanoTime(); 
        sum = (end1 - start); 
         
        System.out.println("Run Time for 1000 test: " + sum / 1000000000);
		/*-------------------------------------------------------------*/

		//randomly created patient ids for 10000 patient
		String[] ID10000 = new String[10000];
		for(int i = 0; i < 10000; i++){
			Integer nextint = (int) (3200 * Math.random());
			ID10000[i] = nextint.toString();	
		}

		BinarySearchTree<Test> bst10000 = new BinarySearchTree<>();
        start = 0;
        end1 = 0; 

        start = System.nanoTime(); 
        for(int i = 0; i < 10000; i++){
			bst10000.add(new BloodTest(ID10000[i]));
		}
        end1 = System.nanoTime(); 
        sum = (end1 - start); 
         
        System.out.println("Run Time for 10000 test: " + sum / 1000000000);
	}

}

