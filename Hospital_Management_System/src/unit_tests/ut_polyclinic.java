package unit_tests;
import departments.Polyclinic;
import users.*;
/**
 * unit test for polyclinic operation
 * @author murat Kaymaz
 *
 */
public class ut_polyclinic {
	/**
	 * Doctor operating test
	 */
	//@Test
    static void testDoctorOperating() {
		System.out.println("******Doctor operation Unit test**********");
		Polyclinic pl = new Polyclinic();
		Doctor d = new Doctor("murat","xyz","1",25,"xyz@gtu.uedu.tr","xyz");
		Doctor d1 = new Doctor("murat2","xyz","1",25,"xyz@gtu.uedu.tr","xyz");
		pl.addDoctor(d);
		pl.addDoctor(d1);

		System.out.println("pl.getDoctors().get(0).getName() == murat  : "+(pl.getDoctors().get(0).getName()=="murat"));
		System.out.println("pl.getDoctors().get(1).getName() == murat2 : " + (pl.getDoctors().get(1).getName()=="murat2"));
		System.out.println("pl.getDoctors().size(), == 2               : "+(pl.getDoctors().size()==2));
		System.out.println("pl.findDoctor(murat3, xyz) == -1           : "+(pl.findDoctor("murat3", "xyz")==-1));
		System.out.println("pl.findDoctor(murat2, xyz) == 1            : "+(pl.findDoctor("murat2", "xyz")== 1));
		System.out.println("pl.deleteDoctor(murat3, xyz) == null       : "+(pl.deleteDoctor("murat3", "xyz") == null));
		System.out.println("pl.deleteDoctor(murat, xyz) == d           : "+(pl.deleteDoctor("murat", "xyz") == d));
		System.out.println("pl.getDoctors().size(), == 1               : "+(pl.getDoctors().size()==1));
    }
	/**
	 * Nurse operating test
	 */
	//@Test
    static void testNurseOperating() {
		System.out.println("\n******Nurse operation Unit test**********");
		Polyclinic pl = new Polyclinic();
		Nurse n1 = new Nurse("try","xyz","1",25,"xy1z@gtu.uedu.tr","xyz");
		Nurse n2 = new Nurse("try2","xyz","1",25,"xyz@gtu.uedu.tr","xyz");
		pl.addNurse(n1);
		pl.addNurse(n2);
		System.out.println("pl.getNurses().get(0).getSurname() == xyz  : "+(pl.getNurses().get(0).getSurname() == "xyz"));
		System.out.println("pl.getNurses().get(1).getName(),try2)      : "+(pl.getNurses().get(1).getName()=="try2"));
		System.out.println("pl.getNurses().size() == 2                 : " + (pl.getNurses().size() == 2));
		System.out.println("pl.findNurse(try3, xyz) == -1              : "+(pl.findNurse("try3", "xyz") ==-1));
		System.out.println("pl.findNurse(try2, xyz)==1                 : "+(pl.findNurse("try2", "xyz")==1));
		System.out.println("pl.deleteNurse(tryx, xyz) == null          : "+(pl.deleteNurse("tryx", "xyz") == null));
		System.out.println("pl.deleteNurse(try, xyz) == n1             : "+(pl.deleteNurse("try", "xyz") == n1));
		System.out.println("pl.getNurses().size() == 1                 : " + (pl.getNurses().size() == 1));
    }
	/**
	 * secretary operating test
	 */
	//@Test
    static void testSecreterOperating() {
		System.out.println("\n******Secretary operation Unit test**********");
		Polyclinic pl = new Polyclinic();
		Secreter s1 = new Secreter("secreter1","xyz","1",25,"xy1z@gtu.uedu.tr","xyz");
		Secreter s2 = new Secreter("secreter2","xyz","1",25,"xyz@gtu.uedu.tr","xyz");
		pl.addSecreter(s1);
		pl.addSecreter(s2);

		System.out.println("pl.getSecreters().get(0).getSurname() == xyz    : "+(pl.getSecreters().get(0).getSurname() =="xyz"));
		System.out.println("pl.getSecreters().get(1).getName() == secreter2 : "+(pl.getSecreters().get(1).getName() == "secreter2"));
		System.out.println("pl.getSecreters().size()==2                     : " + (pl.getSecreters().size()==2));
		System.out.println("pl.findSecreter(secreterll, xyz) == -1          : "+(pl.findSecreter("secreterll", "xyz")==-1));
		System.out.println("pl.findSecreter(secreter1, xyz) == 0            : "+(pl.findSecreter("secreter1", "xyz")==0));
		System.out.println("pl.deleteSecreter(tryx, xyz)) == null           : "+(pl.deleteSecreter("tryx", "xyz") == null));
		System.out.println("pl.deleteSecreter(secreter2, xyz)) == s2        : "+(pl.deleteSecreter("secreter2", "xyz") == s2));
		System.out.println("pl.getSecreters().size()==1                     : " + (pl.getSecreters().size()==1));
    }
	/**
	 * patient operating test
	 */
	//@Test
    static void testPatientOperating() {
		System.out.println("\n******Patient operation Unit test**********");
		Polyclinic pl = new Polyclinic();
		Patient p1 = new Patient("patient1","xyzw","1",25);
		Patient p2 = new Patient("patient2","xyz","2",25);
		pl.addPatients(p1);
		pl.addPatients(p2);

		System.out.println("pl.getPatients().peek().getSurname() == xyzw  : "+(pl.getPatients().peek().getSurname()=="xyzw"));
		System.out.println("pl.getPatients().contains(p2) == true         : "+(pl.getPatients().contains(p2)==true));
		System.out.println("pl.getPatients().size()==2                    : " + (pl.getPatients().size()==2  ));
		System.out.println("pl.findPatient(patient21, xyz) == -1          : "+(pl.findPatient("patient21", "xyz")==-1));
		System.out.println("pl.findPatient(patient1, xyzw) == 0           : "+(pl.findPatient("patient1", "xyzw") == 0 ));
		System.out.println("pl.deletePatient(tryx, xyz) == null           : "+(pl.deletePatient("tryx", "xyz") == null));
		System.out.println("pl.deletePatient(patient2, xyz) == null       : "+(pl.deletePatient("patient2", "xyz") != null));
		System.out.println("pl.getPatients().size()==1                    : " + (pl.getPatients().size()==1));
    }
	/**
	 * Add method running time for Doctor,Nurse and scretary
	 * @param elementsize : number of element for adding operation
	 */
	static public void addMethodRunningTime(int elementsize) {
		Polyclinic pl = new Polyclinic();
		long startTime = System.nanoTime();
		for(int i=0;i<elementsize;i++) {
			Nurse n1 = new Nurse("try"+i,"xyz","1",25,"xy1z@gtu.uedu.tr","xyz");
			pl.addNurse(n1);
		}
		System.out.println("running time for adding {"+ elementsize+"} Elements(doctor,nurse,secretary)  : " + (System.nanoTime() - startTime) + " ns");
	}
	/**
	 * delete method running time for Doctor,Nurse and scretary
	 * @param elementsize : number of element n the arraylist
	 * @param deleting_index : deleting index in the array
	 */
	static public void deleteMethodRunningTime(int elementsize,int deleting_index) {
		Polyclinic pl = new Polyclinic();
		for(int i=0;i<elementsize;i++) {
			Secreter s = new Secreter("secreter"+i,"xyz"+i,"1",25,"xyz@gtu.uedu.tr","xyz");
			pl.addSecreter(s);
		}
		
		long startTime = System.nanoTime();
		//ArrayList<Secreter> temp = pl.getSecreters();
		Secreter temp = pl.deleteSecreter(deleting_index);
		//System.out.println(pl.getSecreters().get(deleting_index).getName()+" "+pl.getSecreters().get(deleting_index).getSurname());
		if(temp != null)
			System.out.println("running time for deleting "+deleting_index+".th element in the {"+ elementsize+"} Elements(doctor,nurse,secretary) : " + (System.nanoTime() - startTime )+ " ns");
	}
	public static void main(String [] args) {
		testDoctorOperating();
		testNurseOperating();
		testSecreterOperating();
		testPatientOperating();
		System.out.println("\n*************Adding operation running time************");
		addMethodRunningTime(10);
		addMethodRunningTime(100);
		addMethodRunningTime(1000);
		addMethodRunningTime(10000);
		System.out.println("\n************Deleting operation running time**********");
		deleteMethodRunningTime(10,1);
		deleteMethodRunningTime(100,1);
		deleteMethodRunningTime(1000,1);
		deleteMethodRunningTime(10000,1);
		deleteMethodRunningTime(10,8);
		deleteMethodRunningTime(100,98);
		deleteMethodRunningTime(1000,998);
		deleteMethodRunningTime(10000,9998);
	}
}

