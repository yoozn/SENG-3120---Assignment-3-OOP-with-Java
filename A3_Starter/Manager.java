import java.util.ArrayList;


/**
 * A model of a manager who has a name, health number, employee id, and list of students.
 */
public class Manager extends BasicManager {
    /** 
     * The list of students the manager manages
     */
    protected ArrayList<Student> studentList = new ArrayList<Student>();
    /**
     * Initialize an instance of a Manager with the given name, social insurance number, and employee id.
     * @param name the name of the manager
     * @param ssn the social insurance number of the manager
     * @param employeeID the id of the manager
     */
    public Manager(String name, int ssn, String employeeID) {
        super(name, ssn, employeeID);
    }

    /**
     * Add a new student to the managers list
     * @param s the student to be added
     */
    public void addStudent(Student s) {
        studentList.add(s);
    }

    /**
     * Remove a student from the managers list
     * @param SID the student id of the student to be added
     */
    public void removeStudent(String SID) {
        for (int i = studentList.size()-1; i >= 0; i--) {
            if (studentList.get(i).getSID().equals(SID)) {
                studentList.remove(i);
            }
        }
    }

    /**
     * Check if the manager list contains a specified student
     * @param SID the student id of the student to be checked
     * @return true or false depending on if student is in list
     * @precond SID != null && !SID.equals("")
     */
    public Boolean hasStudent(String SID) {

        if (SID == null || SID.equals(""))
            throw new IllegalArgumentException("The SID cannot be empty or null.  "
                    + "It is " + SID);
        
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getSID().equals(SID)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return a string representation of the manager
     * 
     * @return a string representation of the manager
     */
    public String toString() {
        String information = "MANAGER\n";
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
     * The main method to test functionality of manager class
     * @param args arguments of default java main function
     */
    public static void main(String[] args) {
        Manager manager01 = new Manager("Joe", 123450, "123");
        Student student02 = new Student("Bobby", 1235, "5");
        manager01.addStudent(student02);
        System.out.println(manager01.hasStudent("5"));
    }
}
