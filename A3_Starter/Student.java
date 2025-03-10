import java.util.ArrayList;

public class Student extends Person {
    private int bedLabel = -1;
    private ArrayList<Manager> managerList = new ArrayList<Manager>();
    private String SID;

    public Student (String name, int ssn, String SID) {
        super(name, ssn);
        this.SID = SID;
    }

    public String getSID() {
        return SID;
    }

    public int getBedLabel() {
        return bedLabel;
    }

    public void setBedLabel(int bedLabel) {
        this.bedLabel = bedLabel;
    }

    public void addManager(Manager m) {
        managerList.add(m);
    }

    public void removeManager(String employeeID) {
        for (int i = managerList.size() -1; i >= 0; i--) {
            if (managerList.get(i).getEmployeeId() == employeeID) {
                managerList.remove(i);
            }
        }
    }

    public Boolean hasManager(String employeeID) {
        for (Manager manager : managerList) {
            if (manager.getEmployeeId() == employeeID) {
                return true;
            }
        }
        return false;
    }

    
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