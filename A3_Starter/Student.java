import java.util.ArrayList;

/**
 * A model of a student who has a name, social insurance number, student id, bed label, and list of managers.
 */
public class Student extends Person {
    /**
     * The label of the students bed
     */
    private int bedLabel = -1;
    /**
     * The list of maangers the student has
     */
    private ArrayList<Manager> managerList = new ArrayList<Manager>();
    /**
     * The students id
     */
    private String SID;

    /**
     * Initialize an instance of a student with the given name, social insurance number, and SID
     * @param name the name of the student
     * @param ssn the social insurance number of the student
     * @param SID the id of the student
     */
    public Student (String name, int ssn, String SID) {
        super(name, ssn);
        this.SID = SID;
    }

    /**
     * Returns the students id
     * @return the student id
     */
    public String getSID() {
        return SID;
    }

    /**
     * Returns the students bed label
     * @return the students bed label
     */
    public int getBedLabel() {
        return bedLabel;
    }

    /**
     * Set the students bed label
     * @param bedLabel the students new bed label
     * @precond bedLabel > 0
     */
    public void setBedLabel(int bedLabel) {
        if (bedLabel <= 0)
            throw new IllegalArgumentException("The bed label must be greater than 0.  "
                    + "It is " + bedLabel);
        this.bedLabel = bedLabel;
        
    }

    /**
     * Add a new manager to the students manager list
     * @param m the manager to be added to the list
     */
    public void addManager(Manager m) {
        managerList.add(m);
    }

    /**
     * Remove a manager from the students manager list
     * @param employeeID the employee id of the manager to be removed from the list
     */
    public void removeManager(String employeeID) {
        for (int i = managerList.size() -1; i >= 0; i--) {
            if (managerList.get(i).getEmployeeId().equals(employeeID)) {
                managerList.remove(i);
            }
        }
    }

    /**
     * Check if the student has a specified manager
     * @param employeeID the employee id of the manager to be checked
     * @return true or false depending on if the manager is in the list
     */
    public Boolean hasManager(String employeeID) {
        for (Manager manager : managerList) {
            if (manager.getEmployeeId().equals(employeeID)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return a string representation of the student
     * @return a string representation of the student
     */
    public String toString() {
        String information = "STUDENT\n";
        information += "NAME: " + this.getName() + "\n";
        information += "STUDENT ID: " + this.getSID() + "\n";
        information += "SSN: " + this.getSSN() + "\n";
        if (bedLabel != -1) {
            information += "Bed: " + bedLabel + "\n";
        }

        if (managerList.size() > 0) {
            information += "Managers: \n";
            for (Manager manager : managerList) {
                information += "  -" + manager.getName() + "\n";
            }
        }
        return information;
    }

    /**
     * The main method to test functionality of student class
     * @param args arguments of default java main function
     */
   public static void main(String[] args) {
    Student stud01 = new Student("Bob", 1234, "S54321s");
    Manager manager01 = new Manager("Joe", 0, null);
    Manager manager02 = new Manager("Bob", 0, null);
    Manager manager03 = new Manager("Guy", 0, null);

    System.out.println(stud01.getSID());
    System.out.println(stud01.getName());
    System.out.println(stud01.getSSN());
    System.out.println(stud01.getBedLabel());
    stud01.setBedLabel(45);
    System.out.println(stud01.getBedLabel());
    stud01.addManager(manager01);
    stud01.addManager(manager02);
    stud01.addManager(manager03);
    System.out.println(stud01.toString());
   }
}