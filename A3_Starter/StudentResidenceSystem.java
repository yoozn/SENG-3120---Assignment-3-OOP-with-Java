import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * A model of the overarching Student Residence Management System
 */
public class StudentResidenceSystem {
    /**
     * The instance of the residence
     */
    private Maintenance residence;
    /**
     * The collection of all the students in the system
     */
    TreeMap<String, Student> students = new TreeMap<String, Student>();
    /**
     * The collection of all the managers in the system
     */
    TreeMap<String, Manager> managers = new TreeMap<String, Manager>();
    /**
     * The scanner to take user input
     */
    private Scanner scanner;

    /**
     * Initialize an instance of the Student Residence System which takes the scanner as parameter
     * @param scanner
     * @precond resName != null && !resName.equals("") && minBedLabel >= 0 && maxBedLabel >= minBedLabel
     */
    public StudentResidenceSystem(Scanner scanner) {
        /**
         * Make the local scanner the same instance as the external scanner
         */
        this.scanner = scanner;
        System.out.print("Enter name of residence: ");
        /**
         * The name of the residence from user input
         */


        String resName = scanner.nextLine();
        if (resName == null || resName.equals(""))
            throw new IllegalArgumentException("The name of a Residence cannot be null or empty.  "
                    + "It is " + resName);

        System.out.print("Enter the minimum bed label: ");
        /**
         * The minimum bed label of the residence from user input
         */
        int minBedLabel = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the maximum bed label: ");
        /**
         * The maximum bed label from user input
         */
        int maxBedLabel = scanner.nextInt();
        scanner.nextLine();

        if (minBedLabel < 0 || maxBedLabel < minBedLabel)
            throw new IllegalArgumentException("The bed labels " + minBedLabel + " and " + maxBedLabel
                    + " are invalid as they cannot be negative, and must have at least one bed.");

        /**
         * The instance of the residence created from user input
         */
        residence = new Maintenance(resName, minBedLabel, maxBedLabel);
        //scanner.close();
    }

    /**
     * Add a new student to the system
     * @precond studentName != null && !studentName.equals("") && ssn >= 0 && SID != null & !SID.equals("")
     */
    public void addStudent() {
        //Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        /**
         * The new students name from the user input
         */
        String studentName = scanner.nextLine();

        if (studentName == null || studentName.equals(""))
            throw new IllegalArgumentException("The name of a student cannot be null or empty.  "
                    + "It is " + studentName);
        
        System.out.print("Enter student SSN: ");
        /**
         * The new students social insurance number from the users input
         */
        int ssn = scanner.nextInt();
        scanner.nextLine();

        if (ssn < 0 )
            throw new IllegalArgumentException("The ssn is invalid as it cannot be negative.");

        System.out.print("Enter student ID: ");
        /**
         * The new students student id from the user input
         */
        String SID = scanner.nextLine();
        if (SID == null || SID.equals(""))
            throw new IllegalArgumentException("The ID of a student cannot be null or empty.  "
                    + "It is " + SID);

        /**
         * The instance of the new student created from the users inputs
         */
        Student newStudent = new Student(studentName, ssn, SID);
        students.put(SID, newStudent);

        //scanner.close();
    }

    /**
     * Add a new manager to the system
     * @precond consultantCheck != "y" || consultantCheck != "n" && employeeName != null & !employeeName.equals("") && ssn >= 0 && employeeID != null & !employeeID.equals("")
     */
    public void addManager() {
        //Scanner scanner = new Scanner(System.in);

        System.out.print("Is the manager a consultant? (y/n) ");
        /**
         * The check variable to see if the new manager is a consultant
         */
        String consultantCheck = scanner.nextLine();
        consultantCheck = consultantCheck.trim();

        if (consultantCheck == null || consultantCheck.equals(""))
            throw new IllegalArgumentException("The input must be either y or n.  "
                    + "It is " + consultantCheck);

        /**
         * The employee role (manager or consultant) from consultant check
         */
        String employeeRole = (consultantCheck.equals("y")) ? "consultant" : "manager";

        System.out.print("Enter " + employeeRole + " name: ");
        /**
         * The new employees name from user
         */
        String employeeName = scanner.nextLine();

        if (employeeName == null || employeeName.equals(""))
            throw new IllegalArgumentException("The name of a employee cannot be null or empty.  "
                    + "It is " + employeeName);

        System.out.print("Enter " + employeeRole + " SSN: ");
        /**
         * The new employees social insurance number from user input
         */
        int ssn = scanner.nextInt();
        scanner.nextLine();

        if (ssn < 0 )
            throw new IllegalArgumentException("The ssn is invalid as it cannot be negative.");

        System.out.print("Enter " + employeeRole + " employee ID: ");
        /**
         * The new employees employee ID from user input
         */
        String employeeID = scanner.nextLine();

        if (employeeID == null || employeeID.equals(""))
            throw new IllegalArgumentException("The ID of a employee cannot be null or empty.  "
                    + "It is " + employeeID);

        if (consultantCheck.equals("y")) {
            /**
             * The instance of the new consultant from users inputs
             */
            Manager newConsultant = new Consultant(employeeName, ssn, employeeID);
            managers.put(employeeID, newConsultant);
            System.out.println("Put Consultant into list");
            System.out.println(managers.get(employeeID));
        }

        else if (consultantCheck.equals("n")) {
            /**
             * The instance of the new manager from users inputs
             */
            Manager newManager = new Manager(employeeName, ssn, employeeID);
            managers.put(employeeID, newManager);
            System.out.println("Put Manager into list");
            System.out.println(managers.get(employeeID));
        }

        //scanner.close();
        
    }

    /**
     * Assign a manager to a student (and a student to a manager)
     * @precond employeeID != null & !employeeID.equals("") && && SID != null & !SID.equals("")
     */
    public void assignManagerToStudent() {
        //Scanner scanner = new Scanner(System.in);
        System.out.print("Enter managers employee ID: ");
        /**
         * The employees id to be assigned to student from user input
         */
        String employeeID = scanner.nextLine();

        if (employeeID == null || employeeID.equals(""))
            throw new IllegalArgumentException("The ID of a employee cannot be null or empty.  "
                    + "It is " + employeeID);


        System.out.print("Enter students ID: ");
        /**
         * The students id to be assigned to manager from user input
         */
        String SID = scanner.nextLine();

        if (SID == null || SID.equals(""))
            throw new IllegalArgumentException("The ID of a student cannot be null or empty.  "
                    + "It is " + SID);

        /**
         * The instance of the manager taken from list of managers
         */
        Manager manager = managers.get(employeeID);
        /**
         * The instance of the student taken from list of students
         */
        Student student = students.get(SID);

        manager.addStudent(student);
        student.addManager(manager);

        //scanner.close();
    }

    /**
     * Assign a bed to a student
     * @precond SID != null & !SID.equals("") && bedLabel >= 0
     */
    public void assignBed() {
        //Scanner scanner = new Scanner(System.in);
        System.out.print("Enter students ID: ");
        /**
         * The student id of the student to be assigned a bed, taken from user input
         */
        String SID = scanner.nextLine();

        if (SID == null || SID.equals(""))
        throw new IllegalArgumentException("The ID of a student cannot be null or empty.  "
                + "It is " + SID);

        System.out.print("Enter bed label: ");
        /**
         * The bed label of the bed to be assigned to the student, taken from user input
         */
        int bedLabel = scanner.nextInt();
        scanner.nextLine();

        if (bedLabel < 0)
        throw new IllegalArgumentException("The bed label must be non-negative.");


        /**
         * The instance of the student to be assigned a bed, taken from list of students
         */
        Student student = students.get(SID);

        residence.assignStudentToBed(student, bedLabel);
        student.setBedLabel(bedLabel);

        //scanner.close();
    }

    /**
     * Drop the relationship between a manager and a student
     * @precond employeeID != null & !employeeID.equals("") && && SID != null & !SID.equals("")
     */
    public void dropAssociation() {
        //Scanner scanner = new Scanner(System.in);
        System.out.print("Enter managers employee ID: ");
        /**
         * The id of the employee to be dropped from a student, taken from user input
         */
        String employeeID = scanner.nextLine();

        if (employeeID == null || employeeID.equals(""))
        throw new IllegalArgumentException("The ID of a employee cannot be null or empty.  "
                + "It is " + employeeID);

        System.out.print("Enter students ID: ");
        /**
         * The id of the student to be dropped from a manager, taken from user input
         */
        String SID = scanner.nextLine();

        if (SID == null || SID.equals(""))
        throw new IllegalArgumentException("The ID of a student cannot be null or empty.  "
                + "It is " + SID);

        /**
         * The instance of the manager to be dropped from a student, taken from list of managers
         */
        Manager manager = managers.get(employeeID);
        /**
         * The instance of the student to be dropped from a manager, taken from list of students
         */
        Student student = students.get(SID);

        manager.removeStudent(SID);
        student.removeManager(employeeID);

        //scanner.close();
    }
    
    /**
     * Print out the current system state
     */
    public void systemState() {
        System.out.println("Current System State:");
        System.out.println("Students:");
        for (Student student : students.values()) {
            System.out.println(student.toString());
        }

        System.out.println("Managers: ");
        for (Manager manager : managers.values()) {
            System.out.println(manager.toString());
        }

        System.out.println("Residence information: ");
        residence.toString();
    }

    /**
     * Return a string representation of the Student Residence System
     */
    public String toString() {
        /**
         * The string that will be returned
         */
        String information = "";
        information += "Students: \n";
        for (Student student : students.values()) {
            information += "   -" + student.getName() + "\n";
        }

        information += ("Managers: \n");
        for (Manager manager : managers.values()) {
            information += "  - " + manager.getName() + "\n";
        }

        information += ("Residence information: \n");
        information += "Residence name: " + residence.getName() + "\n";
        information += "Minimum bed label: " + residence.getMinBedLabel() + "\n";
        information += "Maximum bed label: " + residence.getMaxBedLabel() + "\n";
        return information;
    }

    /**
     * Display the available beds
     */
    public void displayEmptyBeds() {
        for (int i=residence.getMinBedLabel(); i<=residence.getMaxBedLabel(); i++){
            if (!residence.isOccupied(i)){
                System.out.println("Bed with number: "+ i);
            }
        }
    }

    /**
     * Method to delete a Student from the system 
     * 
     *      */
    public void releaseStudent() {
        System.out.print("Enter the Student I.D: ");
        String SID=scanner.nextLine();
        Student S = students.get(SID);
        int bedLabel= S.getBedLabel();
        residence.freeBed(bedLabel);
        students.remove(SID);
        System.out.println("Student Deleted");
    }


    /**
     * The main execution of the Student Residence System
     * 
     * @param args arguments of default java main function
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        StudentResidenceSystem SRS = new StudentResidenceSystem(scanner);

        while (true) { 
            System.out.println("Student Residence System:");
            System.out.println("1. Quit");
            System.out.println("2. Add new student");
            System.out.println("3. Add new manager");
            System.out.println("4. Assign manager to student");
            System.out.println("5. Display empty beds");
            System.out.println("6. Assign student bed");
            System.out.println("7. Release student");
            System.out.println("8. Drop manager-student association");
            System.out.println("9. Display current system state");
            int selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 1:
                    scanner.close();
                    break;
                case 2:
                    SRS.addStudent();
                    break;
                case 3:
                    SRS.addManager();
                    break;
                case 4:
                    SRS.assignManagerToStudent();
                    break;
                case 5:
                    SRS.displayEmptyBeds();
                    break;
                case 6:
                    SRS.assignBed();
                    break;
                case 7:
                    SRS.releaseStudent();
                    break;
                case 8:
                    SRS.dropAssociation();
                    break;
                case 9:
                    SRS.systemState();
                    break;
                default:
                    break;
            }
        }
    }


}



