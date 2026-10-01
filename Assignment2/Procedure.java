/*
 * Class: CMSC203 
 * Instructor:Ahmed Tarek
 * Description: Make a program where it asks a patient to enter certain data in order to display the patient's information,
 *  the three medical procedures, and the total charges for those procedures.
 * Due: 9/30/2026
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Yizhu Wang
*/

public class Procedure {

    private String procedureName;
    private String procedureDate;
    private String practitionerName;
    private double charges;

    public Procedure() {
        procedureName = "";
        procedureDate = "";
        practitionerName = "";
        charges = 0.0;
    }

    public Procedure(String procedureName, String procedureDate) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
    }

    public Procedure(String procedureName, String procedureDate,
                     String practitionerName, double charges) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
        this.practitionerName = practitionerName;
        this.charges = charges;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public String getProcedureDate() {
        return procedureDate;
    }

    public String getPractitionerName() {
        return practitionerName;
    }

    public double getCharges() {
        return charges;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public void setProcedureDate(String procedureDate) {
        this.procedureDate = procedureDate;
    }

    public void setPractitionerName(String practitionerName) {
        this.practitionerName = practitionerName;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    public String toString() {
        return "Procedure Name: " + procedureName + "\n"
                + "Procedure Date: " + procedureDate + "\n"
                + "Practitioner Name: " + practitionerName + "\n"
                + "Charges: " + String.format("%.2f", charges);
    }
}