import java.util.ArrayList;

public class Manager extends BasicManager {
    private ArrayList<Student> studentList = new ArrayList<Student>();

    public Manager(String name, int ssn, String employeeID) {
        super(name, ssn, employeeID);
    }

    public void addStudent(Student s) {
        studentList.add(s);
    }

    public void removeStudent(String SID) {
        for (int i = studentList.size() -1; i >= 0; i--) {
            if (studentList.get(i).getSID() == SID) {
                studentList.remove(i);
            }
        }
    }

    public Boolean hasStudent(String SID) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getSID() == SID) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Manager manager01 = new Manager("Joe", 123450, "123");
        Student student02 = new Student("Bobby", 1235, "5");
        manager01.addStudent(student02);
        System.out.println(manager01.hasStudent("5"));
    }
}
