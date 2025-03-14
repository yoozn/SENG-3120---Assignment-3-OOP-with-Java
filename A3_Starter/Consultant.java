
/**
 * A model of a consultant who has a name, social insurance number, and employee id.
 */
public class Consultant extends Manager {
    /**
     * Initialize an instance of a consultant with the given name, social insurance number, and employee id.
     * @param name the name of the consultant
     * @param ssn the social insurance number of the consultant
     * @param employeeID the employee id of the consultant
     */
    public Consultant(String name, int ssn, String employeeID) {
        super(name, ssn, employeeID);
    }

    /**
     * Return a string representation of the consultant
     * @return a string representation of the consultant
     */
    public String toString() {
        String information = "CONSULTANT:\n";
        information += "NAME: " + this.getName() + "\n";
        information += "EMPLOYEE ID: " + this.getEmployeeId() + "\n";
        information += "SSN: " + this.getSSN() + "\n";

        if (studentList.size() > 0) {
            information += "Students: \n";
            for (Student student : studentList) {
                information += "  -" + student.getName() + "\n";
            }
        }
        return information;
    }

    /**
     * The main method to test functionality of consultant class
     * @param args arguments of default java main function
     */
    public static void main(String[] args) {

    }
}
