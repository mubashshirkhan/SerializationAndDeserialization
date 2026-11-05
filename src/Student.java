import java.io.Serializable;

public class Student implements Serializable {
    //by implementing we are giving permission to save object

    private static final long serialVersionUID = 1L;
    private int sno;
    private String sname;
    private String course;
    private double fee;
    private transient String username;
    private transient String password;
    private double height;

    public int getSno() {
        return sno;
    }


    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student(" +
                "sno=" + sno +
                ", sname='" + sname + '\'' +
                ", course='" + course + '\'' +
                ", fee=" + fee +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ')';
    }
    static {
        System.out.println("class is loaded");
    }
    Student(){
        System.out.println("Npc exe, st obj created");
    }

}
