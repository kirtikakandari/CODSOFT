import java.util.*;
class Course {
    String courseCode, title, description, schedule;
    int capacity;
    int enrolled = 0;
    Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }
    boolean hasSlot() {return enrolled < capacity;}
    void enroll() {enrolled++;}
    void drop() {
        if (enrolled > 0) enrolled--;
    }
    void display() {
        System.out.println(courseCode + ": " + title + " | " + description +
            " | Slots left: " + (capacity - enrolled) + " | Schedule: " + schedule);
    }
}
class Student {
    int studentID;
    String name;
    List<Course> registeredCourses = new ArrayList<>();
    Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }
    void registerCourse(Course c) {
        if (c.hasSlot() && !registeredCourses.contains(c)) {
            registeredCourses.add(c);
            c.enroll();
            System.out.println("Registered for " + c.title);
        } else {
            System.out.println("Cannot register (Full or Already Registered)");
        }
    }
    void dropCourse(Course c) {
        if (registeredCourses.remove(c)) {
            c.drop();
            System.out.println("Dropped " + c.title);
        } else {
            System.out.println(" Not registered in this course.");
        }
    }
    void showRegisteredCourses() {
        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered.");
        } else {
            System.out.println("📚 Registered Courses:");
            for (Course c : registeredCourses) {
                System.out.println(" - " + c.title);
            }
        }
    }
}
public class Task5_registrationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("CS101", "Java Programming", "Intro to Java", 3, "Mon-Wed 10AM"));
        courses.add(new Course("CS102", "Data Structures", "Stacks, Queues, Trees", 2, "Tue-Thu 1PM"));
        courses.add(new Course("CS103", "DBMS", "Databases and SQL", 2, "Fri 2PM"));
        System.out.println("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Student Name: ");
        String name = sc.nextLine();
        Student student = new Student(id, name);

        int choice;
        do {
            System.out.println("\nSTUDENT COURSE REGISTRATION");
            System.out.println("1. List Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n📋 Available Courses:");
                    for (int i = 0; i < courses.size(); i++) {
                        System.out.print((i + 1) + ". ");
                        courses.get(i).display();
                    }
                    break;
                case 2:
                    System.out.print("Enter course number to register: ");
                    int regIndex = sc.nextInt() - 1;
                    if (regIndex >= 0 && regIndex < courses.size())
                        student.registerCourse(courses.get(regIndex));
                    else
                        System.out.println("Invalid choice.");
                    break;
                case 3:
                    System.out.print("Enter course number to drop: ");
                    int dropIndex = sc.nextInt() - 1;
                    if (dropIndex >= 0 && dropIndex < courses.size())
                        student.dropCourse(courses.get(dropIndex));
                    else
                        System.out.println("Invalid choice.");
                    break;
                case 4:
                    student.showRegisteredCourses();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option!");
            }

        } while (choice != 5);
        sc.close();
    }
}

