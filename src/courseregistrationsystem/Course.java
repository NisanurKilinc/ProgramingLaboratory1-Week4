
package courseregistrationsystem;

public class Course {
    public String courseName;
    public int capacity;
    public Student[] enrolledStudents;
    public int studentCount;

    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new Student[capacity];
        this.studentCount = 0;
    }

    public boolean addStudent(Student student) {
        
        if (studentCount >= capacity) {
            System.out.println("This course is full. Registration failed.");
            return false;
        }
        
        for (int i = 0; i < studentCount; i++) {
            if (enrolledStudents[i].studentID.equals(student.studentID)) {
                System.out.println("This student is already registered for this course.");
                return false;
            }
        }

        enrolledStudents[studentCount] = student;
        studentCount++;
        System.out.println("Registration successful.");
        return true;
    }

    public void displayCourseInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Capacity: " + capacity);
        System.out.println("Current Number of Enrolled Students: " + studentCount);
        System.out.println("Enrolled Students:");
        if (studentCount == 0) {
            System.out.println("  - No students enrolled yet.");
        } else {
            for (int i = 0; i < studentCount; i++) {
                System.out.print("  - ");
                enrolledStudents[i].displayStudentInfo();
            }
        }
        System.out.println("--------------------------------------------------");
    }
}
