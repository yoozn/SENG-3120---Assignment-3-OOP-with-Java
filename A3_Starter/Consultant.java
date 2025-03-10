public class Consultant extends Manager {
    public Consultant(String name, int ssn, String employeeID) {
        super(name, ssn, employeeID);
    }

    public String toString() {
        String information = "CONSULTANT:\n";
        information += "NAME: " + this.getName() + "\n";
        information += "EMPLOYEE ID: " + this.getEmployeeId();
        information += "SSN: " + this.getSSN() + "\n";

        if (studentList.size() > 0) {
            information += "Students: \n";
            for (Student student : studentList) {
                information += "  -" + student.getName() + "\n";
            }
        }
        return information;
    }

    public static void main(String[] args) {

    }
}
