
package courseregistrationsystem;

import java.util.Scanner;

public class CourseRegistrationSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Course[] courses; 

        System.out.print("How many courses would you like to create? (at least 3): ");
        int courseCount = scanner.nextInt();
        scanner.nextLine();

        while (courseCount < 3) {
            System.out.print("You must create at least 3 courses. Please enter a valid number: ");
            courseCount = scanner.nextInt();
            scanner.nextLine();
        }

        courses = new Course[courseCount];

        for (int i = 0; i < courseCount; i++) {
            System.out.println("\n--- Entering details for Course " + (i + 1) + " ---");
            System.out.print("Enter course name: ");
            String cName = scanner.nextLine();
            System.out.print("Enter classroom capacity: ");
            int cCapacity = scanner.nextInt();
            scanner.nextLine();

            courses[i] = new Course(cName, cCapacity);
        }

        System.out.println("\n=== Available Courses for Registration ===");
        for (Course c : courses) {
            System.out.println("- " + c.courseName + " (Capacity: " + c.capacity + ")");
        }

        boolean running = true;
        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Register Student to a Course");
            System.out.println("2. View All Courses and Details");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Buffer temizleme

            switch (choice) {
                case 1:
                    // 4. Register Students
                    System.out.print("Enter Student ID: ");
                    String sID = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String sName = scanner.nextLine();
                    System.out.print("Enter exact course name to register: ");
                    String targetCourseName = scanner.nextLine();

                    Course foundCourse = null;
                    for (Course c : courses) {
                        if (c.courseName.equalsIgnoreCase(targetCourseName)) {
                            foundCourse = c;
                            break;
                        }
                    }

                    if (foundCourse == null) {
                        System.out.println("No course found with that name.");
                    } else {
                        Student newStudent = new Student(sID, sName);
                        foundCourse.addStudent(newStudent);
                    }
                    break;

                case 2:
                    // 5. View All Courses
                    System.out.println("\n=== All Courses & Status ===");
                    for (Course c : courses) {
                        c.displayCourseInfo();
                    }
                    break;

                case 3:
                    running = false;
                    System.out.println("Exiting program. Good-bye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
    
}
