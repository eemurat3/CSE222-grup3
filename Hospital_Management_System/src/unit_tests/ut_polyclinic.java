package unit_tests;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;	
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
	@Test
    static void testDoctorOperating() {
		Polyclinic pl = new Polyclinic();
		Doctor d = new Doctor("murat","xyz","1",25,"xyz@gtu.uedu.tr","xyz");
		Doctor d1 = new Doctor("murat2","xyz","1",25,"xyz@gtu.uedu.tr","xyz");
		pl.addDoctor(d);
		pl.addDoctor(d1);
		assertEquals(pl.getDoctors().get(0).getName(),"murat");
		assertEquals(pl.getDoctors().get(1).getName(),"murat2");
		assertEquals(pl.getDoctors().size(),2);
		assertEquals(pl.findDoctor("murat3", "xyz"),-1);
		assertEquals(pl.findDoctor("murat2", "xyz"),1);
		assertNull(pl.deleteDoctor("murat3", "xyz"));
		assertSame(pl.deleteDoctor("murat", "xyz"), d);	
		assertEquals(pl.getDoctors().size(),1);
    }
	/**
	 * Nurse operating test
	 */
	@Test
    static void testNurseOperating() {
		Polyclinic pl = new Polyclinic();
		Nurse n1 = new Nurse("try","xyz","1",25,"xy1z@gtu.uedu.tr","xyz");
		Nurse n2 = new Nurse("try2","xyz","1",25,"xyz@gtu.uedu.tr","xyz");
		pl.addNurse(n1);
		pl.addNurse(n2);
		assertEquals(pl.getNurses().get(0).getSurname(),"xyz");
		assertEquals(pl.getNurses().get(1).getName(),"try2");
		assertEquals(pl.getNurses().size(),2);
		assertEquals(pl.findNurse("try3", "xyz"),-1);
		assertEquals(pl.findNurse("try2", "xyz"),1);
		assertNull(pl.deleteNurse("tryx", "xyz"));
		assertSame(pl.deleteNurse("try", "xyz"), n1);	
		assertEquals(pl.getNurses().size(),1);
    }
	/**
	 * secretary operating test
	 */
	@Test
    static void testSecreterOperating() {
		Polyclinic pl = new Polyclinic();
		Secreter s1 = new Secreter("secreter1","xyz","1",25,"xy1z@gtu.uedu.tr","xyz");
		Secreter s2 = new Secreter("secreter2","xyz","1",25,"xyz@gtu.uedu.tr","xyz");
		pl.addSecreter(s1);
		pl.addSecreter(s2);
		assertEquals(pl.getSecreters().get(0).getSurname(),"xyz");
		assertEquals(pl.getSecreters().get(1).getName(),"secreter2");
		assertEquals(pl.getSecreters().size(),2);
		assertEquals(pl.findSecreter("secreterll", "xyz"),-1);
		assertEquals(pl.findSecreter("secreter1", "xyz"),0);
		assertNull(pl.deleteSecreter("tryx", "xyz"));
		assertNotNull(pl.deleteSecreter("secreter2", "xyz"));	
		assertEquals(pl.getSecreters().size(),1);
    }
	/**
	 * patient operating test
	 */
	@Test
    static void testPatientOperating() {
		Polyclinic pl = new Polyclinic();
		Patient p1 = new Patient("patient1","xyzw","1",25);
		Patient p2 = new Patient("patient2","xyz","2",25);
		pl.addPatients(p1);
		pl.addPatients(p2);
		assertEquals(pl.getPatients().peek().getSurname(),"xyzw");
		assertEquals(pl.getPatients().contains(p2),true);
		assertEquals(pl.getPatients().size(),2);
		assertEquals(pl.findPatient("patient21", "xyz"),-1);
		assertEquals(pl.findPatient("patient1", "xyzw"),0);
		assertNull(pl.deletePatient("tryx", "xyz"));
		assertNotNull(pl.deletePatient("patient2", "xyz"));	
		assertEquals(pl.getPatients().size(),1);
    }
	/**
	 * Add method running time for Doctor,Nurse and scretary
	 */
	static public void addMethodRunningTime() {
		Polyclinic pl = new Polyclinic();
		Nurse n1 = new Nurse("try"+1,"xyz","1",25,"xy1z@gtu.uedu.tr","xyz");
		Nurse n2 = new Nurse("try"+2,"xyz","1",25,"xy1z@gtu.uedu.tr","xyz");
		Nurse n3 = new Nurse("try"+3,"xyz","1",25,"xy1z@gtu.uedu.tr","xyz");
		long startTime = System.nanoTime();
		pl.addNurse(n1);
		pl.addNurse(n2);
		pl.addNurse(n3);
		System.out.println("running time for adding(doctor,nurse,secretary)  : " + (System.nanoTime() - startTime)/3 + " ns");
	}
	/**
	 * delete method running time for Doctor,Nurse and scretary
	 */
	static public void deleteMethodRunningTime() {
		Polyclinic pl = new Polyclinic();
		Nurse n1 = new Nurse("try"+1,"xyz","1",25,"xy1z@gtu.uedu.tr","xyz");
		Nurse n2 = new Nurse("try"+2,"xyz","1",25,"xy1z@gtu.uedu.tr","xyz");
		Nurse n3 = new Nurse("try"+3,"xyz","1",25,"xy1z@gtu.uedu.tr","xyz");
		Nurse n4 = new Nurse("try"+4,"xyz","1",25,"xy1z@gtu.uedu.tr","xyz");
		Nurse n5 = new Nurse("try"+5,"xyz","1",25,"xy1z@gtu.uedu.tr","xyz");
		Nurse n6 = new Nurse("try"+6,"xyz","1",25,"xy1z@gtu.uedu.tr","xyz");
		pl.addNurse(n1);
		pl.addNurse(n2);
		pl.addNurse(n3);
		pl.addNurse(n4);
		pl.addNurse(n5);
		pl.addNurse(n6);
		long startTime = System.nanoTime();
		Nurse temp = pl.deleteNurse("try1", "xyz");
		System.out.println("running time for deleting(doctor,nurse,secretary) : " + (System.nanoTime() - startTime)/3 + " ns");
	}
	public static void main(String [] args) {
		testDoctorOperating();
		testNurseOperating();
		testSecreterOperating();
		testPatientOperating();
		addMethodRunningTime();
		deleteMethodRunningTime();
	}
}

