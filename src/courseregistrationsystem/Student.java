
package courseregistrationsystem;

public class Student {
    public String studentID;
    public String name;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public void displayStudentInfo() {
        System.out.println("Student ID: " + studentID + ", Name: " + name);
    }
}
