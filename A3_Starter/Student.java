import java.util.ArrayList;

public class Student extends Person {
    private int bedLabel = -1;
    //ArrayList
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

    //public void addManager() {}

    //public void removeManager(String employeeID) {}

    //public bool hasManager() {}

    
/*     public String toString() {
        return ""
    } */

   public static void main(String[] args) {
    Student stud01 = new Student("Bob", 1234, "S54321s");

    System.out.println(stud01.getSID());
    System.out.println(stud01.getName());
    System.out.println(stud01.getSSN());
    System.out.println(stud01.getBedLabel());
    stud01.setBedLabel(45);
    System.out.println(stud01.getBedLabel());

   }

}