package systems;

/**
 *
 * @author Ahmet Uslugolu
 */
public class Prescription 
{
    private String medicine = "None";
    private String instructions = "None";
    private String note = "None";

    public Prescription(String newMed, String newInst, String newNote)
    {
        medicine = newMed;
        instructions = newInst;
        note = newNote;
    }

    public String getPrescription(){return medicine + instructions + note;}
    public String getMed(){return medicine;}
    public String getInstructions(){return instructions;}
    public String getNote(){return note;}

    public void setMed(String newMed){medicine = newMed;}
    public void setInstructions(String newInst){instructions = newInst;}
    public void setNote(String newNote){note = newNote;}
    
    @Override
    public String toString() {
        return "Prescription{" + "\nmedicine name: " + getMed() + "\nInstructions: " + getInstructions() + "\nNote: " + getNote() + "\n}\n";
    }
}
