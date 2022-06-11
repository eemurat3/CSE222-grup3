package tests;

/**
 * @author H. Tuğçe Yavuz
 */
/**
 * This class is a subclass of the Test class. Represents the blood test results of the patients.
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
	public BloodTest(String patientID,String testID)
	{
		super(patientID,testID,0);
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
	public BloodTest(){super("0","0",0);}

	/**
	 * This function returns the blood type of the patient.
	 * 
	 * @return The bloodType variable is being returned.
	 */
	public String getBloodType(){return bloodType;}

  	/**
	* Sets the blood type of the patient
	* 
	* @param bloodType The blood type of the donor.
	*/
	public void setBloodType(String bloodType){this.bloodType = bloodType;}

	/**
	 * This function returns the rH type
	 * @return The rH type
	 */
	public String getRH(){return rH;}

  	/**
	* This function sets the value of the rH variable to the value of the rH parameter
	* 
	* @param rH The rH type
	*/
	public void setRH(String rH){this.rH = rH;}
  
  	/**
	* This function returns the value of the vitaminA variable.
	* 
	* @return The value of the variable vitaminA.
	*/
	public int getVitaminA(){return vitaminA;}

  	/**
	* This function sets the value of the vitaminA variable to the value of the vitaminA parameter.
	* 
	* @param vitaminA The amount of vitamin A
	*/
	public void setVitaminA(int vitaminA){this.vitaminA = vitaminA;}
  
	/**
	 * This function returns the value of the vitaminD variable.
	 * 
	 * @return The value of the variable vitaminD.
	 */
	public int getVitaminD(){return vitaminD;}

	/**
	 * This function sets the vitaminD variable to the value of the vitaminD parameter
	 * 
	 * @param vitaminD The amount of vitaminD.
	 */
	public void setVitaminD(int vitaminD){this.vitaminD = vitaminD;}

	/**
	 * This function returns the value of the vitaminE variable.
	 * 
	 * @return The value of the variable vitaminE.
	 */
	public int getVitaminE(){return vitaminE;}

  	/**
	* This function sets the value of the vitaminE variable to the value of the vitaminE parameter.
	* 
	* @param vitaminE The amount of vitaminE.
	*/
	public void setVitaminE(int vitaminE){this.vitaminE = vitaminE;}

	/**
	 * This function returns the hemoglobin value of the blood sample.
	 * 
	 * @return The value of the hemoglobin variable.
	 */
	public int getHemoglobin(){return hemoglobin;}

	/**
	 * This function sets the hemoglobin value of the patient
	 * 
	 * @param hemoglobin The hemoglobin level of the patient.
	 */
  	public void setHemoglobin(int hemoglobin){this.hemoglobin = hemoglobin;}

  	/**
	* This function returns the potassium value.
	* 
	* @return The value of the potassium variable.
	*/
	public int getPotassium(){return potassium;}

  	/**
	* This function sets the potassium value of the object to the value of the parameter
	* 
	* @param potassium The amount of potassium.
	*/
	public void setPotassium(int potassium){this.potassium = potassium;}

  	/**
	* This function returns the calcium value.
	* 
	* @return The value of the variable calcium.
	*/
	public int getCalcium(){return calcium;}

  	/**
	* This function sets the calcium variable to the value of the calcium parameter.
	* 
	* @param calcium The amount of calcium.
	*/
	public void setCalcium(int calcium){this.calcium = calcium;}
  
  	/**
	* Returns a string that contains the patient's ID, blood type, rH, and the results of
	* the blood test 
	* @return The toString method is being returned.
	*/
	@Override
	public String toString()
	{
		return  "\n\nPatient's ID: " + getPatientID() + "\nBlood Type : " + bloodType + " rH : " + rH + "BLOOD TEST RESULTS :\n"
			+ "\nVitamin-A : " + String.valueOf(vitaminA) + "ug/L" + "\nVitamin-D : " + String.valueOf(vitaminD) + "ug/L"
			+ "\nVitamin-E : " + String.valueOf(vitaminE) + "ug/L" + "\nHemoglobin : " + String.valueOf(hemoglobin) + "gr/dL"
			+ "\nPotassium : " + String.valueOf(potassium) + " mmol/l" + "\nCalcium : " + String.valueOf(calcium) + "mg/dL";
	}

	/**
	 * performance analysis of bloodtest class
	 * @param args
	 */
	public static void main(String[] args){
        System.out.print("\n\n\t\t\t BLOOD TEST UNIT TESTING STARTS \n\n");


		System.out.println("------------ Test of Blood Test ---------------");

		String ID1 = "2222222";

		/**Constructor test */

		BloodTest test1 = new BloodTest(ID1,"123");

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

        System.out.print("\n\n\t\t\t BLOOD TEST UNIT TESTING ENDS \n\n");

	}

}

