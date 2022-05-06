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

    // A constructor that takes in three strings and sets the private variables to the new values.
    public Prescription(String newMed, String newInst, String newNote)
    {
        medicine = newMed;
        instructions = newInst;
        note = newNote;
    }

    /**
     * The function getPrescription() returns a string that is the concatenation of the medicine,
     * instructions, and note fields
     * @return The medicine, instructions, and note.
     */
    public String getPrescription(){return medicine + instructions + note;}

    /**
     * This function returns the medicine of the patient.
     * @return The medicine variable is being returned.
     */
    public String getMed(){return medicine;}

    /**
     * This function returns the instructions for the recipe.
     * 
     * @return The instructions for the recipe.
     */
    public String getInstructions(){return instructions;}

    /**
     * This function returns the note.
     * 
     * @return The note variable is being returned.
     */
    public String getNote(){return note;}

    /**
     * This function sets the medicine variable to the value of the newMed variable.
     * @param newMed The new medicine to be set.
     */
    public void setMed(String newMed){medicine = newMed;}

    /**
     * This function sets the instructions of the recipe to the value of the parameter newInst.
     * @param newInst The new instructions for the recipe.
     */
    public void setInstructions(String newInst){instructions = newInst;}
    
    /**
     * This function sets the note to the value of the newNote parameter.
     * 
     * @param newNote The new note to be set.
     */
    public void setNote(String newNote){note = newNote;}
    
    /**
     * The toString() method returns a string representation of the object
     * 
     * @return The medicine name, instructions, and note.
     */
    @Override
    public String toString() {
        return "Prescription{" + "\nmedicine name: " + getMed() + "\nInstructions: " + getInstructions() + "\nNote: " + getNote() + "\n}\n";
    }
}
