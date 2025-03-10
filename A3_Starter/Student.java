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
}
