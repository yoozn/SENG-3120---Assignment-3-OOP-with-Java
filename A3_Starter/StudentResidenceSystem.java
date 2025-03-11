import java.util.TreeMap;
import java.util.Scanner;

public class StudentResidenceSystem {
    private Maintenance residence;
    TreeMap<String, Student> students;
    TreeMap<String, Manager> managers;

    public StudentResidenceSystem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name of residence: ");
        String resName = scanner.nextLine();

        System.out.print("Enter the minimum bed label: ");
        int minBedLabel = scanner.nextInt();

        System.out.print("Enter the maximum bed label: ");
        int maxBedLabel = scanner.nextInt();

        residence = new Maintenance(resName, minBedLabel, maxBedLabel);
        scanner.close();
    }

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        
        System.out.print("Enter student SSN: ");
        int ssn = scanner.nextInt();

        System.out.print("Enter student ID");
        String SID = scanner.nextLine();

        Student newStudent = new Student(studentName, ssn, SID);
        students.put(SID, newStudent);

        scanner.close();
    }

    public void addManager() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Is the manager a consultant? (y/n) ");
        String consultantCheck = scanner.nextLine();

        String employeeRole = (consultantCheck == "y") ? "consultant" : "manager";

        System.out.print("Enter " + employeeRole + " name: ");
        String employeeName = scanner.nextLine();

        System.out.print("Enter " + employeeRole + " SSN: ");
        int ssn = scanner.nextInt();

        System.out.print("Enter " + employeeRole + " employee ID: ");
        String employeeID = scanner.nextLine();

        if (consultantCheck == "y") {
            Consultant newConsultant = new Consultant(employeeName, ssn, employeeID);
            managers.put(employeeID, newConsultant);
        }

        else if (consultantCheck == "n") {
            Manager newManager = new Manager(employeeName, ssn, employeeID);
            managers.put(employeeID, newManager);
        }

        scanner.close();
        
    }

    public void assignManagerToStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter managers employee ID: ");
        String employeeID = scanner.nextLine();

        System.out.print("Enter students ID: ");
        String SID = scanner.nextLine();

        Manager manager = managers.get(employeeID);
        Student student = students.get(SID);

        manager.addStudent(student);
        student.addManager(manager);

        scanner.close();
    }

    public void assignBed() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter students ID: ");
        String SID = scanner.nextLine();

        System.out.print("Enter bed label: ");
        int bedLabel = scanner.nextInt();

        Student student = students.get(SID);

        residence.assignStudentToBed(student, bedLabel);

        scanner.close();
    }

    public void dropAssociation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter managers employee ID: ");
        String employeeID = scanner.nextLine();

        System.out.print("Enter students ID: ");
        String SID = scanner.nextLine();

        Manager manager = managers.get(employeeID);
        Student student = students.get(SID);

        manager.removeStudent(SID);
        student.removeManager(employeeID);

        scanner.close();
    }
    
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

    public String toString() {
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

    public void displayEmptyBeds() {

    }

    public void releaseStudent() {

    }

    public static void main(String[] args) {
        StudentResidenceSystem SRS = new StudentResidenceSystem();
    }


}



