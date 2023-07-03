import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private String school;
    private String birthday;
    private String phoneNumber;
    private String parentDetails;
    private String emailAddress;
    private String whatsappNumber;
    private String gender;

    public Student(String name, String school, String birthday, String phoneNumber, String parentDetails,
                   String emailAddress, String whatsappNumber, String gender) {
        this.name = name;
        this.school = school;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.parentDetails = parentDetails;
        this.emailAddress = emailAddress;
        this.whatsappNumber = whatsappNumber;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getParentDetails() {
        return parentDetails;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getWhatsappNumber() {
        return whatsappNumber;
    }

    public String getGender() {
        return gender;
    }
}

class Course {
    private String name;
    private String fees;
    private String lecturer;
    private String hall;

    public Course(String name, String fees, String lecturer, String hall) {
        this.name = name;
        this.fees = fees;
        this.lecturer = lecturer;
        this.hall = hall;
    }

    public String getName() {
        return name;
    }

    public String getFees() {
        return fees;
    }

    public String getLecturer() {
        return lecturer;
    }

    public String getHall() {
        return hall;
    }
}

class StudentRegistration {
    private List<Student> students;
    private List<Course> courses;
    private Scanner scanner;

    public StudentRegistration() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n********** WELCOME TO NYSCO **********");
            System.out.println("              (Educational)              ");
            System.out.println("                Badulla");
            System.out.println("          055 2225164");
            System.out.println("\n--- Student Registration ---");
            System.out.println("1. Register Student");
            System.out.println("2. View Courses");
            System.out.println("3. Upload Identity Card Copy");
            System.out.println("4. Upload PDF of Receipt");
            System.out.println("5. Display Contact Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerStudent();
                    break;
                case 2:
                    viewCourses();
                    break;
                case 3:
                    uploadIdentityCardCopy();
                    break;
                case 4:
                    uploadReceiptPDF();
                    break;
                case 5:
                    displayContactDetails();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        System.out.println("Thank you for using the Student Registration System!");
        scanner.close();
    }

    private void registerStudent() {
        System.out.print("\nEnter student's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student's school: ");
        String school = scanner.nextLine();

        System.out.print("Enter student's birthday: ");
        String birthday = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter parent's details: ");
        String parentDetails = scanner.nextLine();

        System.out.print("Enter email address: ");
        String emailAddress = scanner.nextLine();

        System.out.print("Enter WhatsApp number: ");
        String whatsappNumber = scanner.nextLine();

        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();

        Student student = new Student(name, school, birthday, phoneNumber, parentDetails,
                emailAddress, whatsappNumber, gender);
        students.add(student);

        System.out.println("Student registered successfully!");
    }

    private void viewCourses() {
        System.out.println("\n--- Available Courses ---");
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
        } else {
            for (int i = 0; i < courses.size(); i++) {
                Course course = courses.get(i);
                System.out.println((i + 1) + ". " + course.getName());
                System.out.println("   Fees: " + course.getFees());
                System.out.println("   Lecturer: " + course.getLecturer());
                System.out.println("   Hall: " + course.getHall());
            }
        }
    }

    private void uploadIdentityCardCopy() {
        // Logic for uploading identity card copy goes here...
        System.out.println("Identity card copy uploaded successfully!");
    }

    private void uploadReceiptPDF() {
        // Logic for uploading receipt PDF goes here...
        System.out.println("Receipt PDF uploaded successfully!");
    }

    private void displayContactDetails() {

        System.out.println("\n--- Contact Details ---");
        System.out.println("Address: gree land drive, badulupitiya, badull");
        System.out.println("Phone: -055 2225 164");
        System.out.println("Email: info@nysco.com");
        System.out.println("Website: www.nysco.com");
    }

    public void addCourse(String name, String fees, String lecturer, String hall) {
        Course course = new Course(name, fees, lecturer, hall);
        courses.add(course);
    }
}

class Main {
    public static void main(String[] args) {
        StudentRegistration registration = new StudentRegistration();

        // Adding dummy courses
        registration.addCourse("Course Application Assistant", "$100", "John Smith", "Room 101");
        registration.addCourse("Computer Hardware", "200000", "Emily Johnson", "Room 202");
        registration.addCourse("Computer Graphic", "1200000", "David Brown", "Room 303");
        registration.addCourse("Programming", "200000", "Sarah Davis", "Room 404");
        registration.addCourse("Advanced English", "1200000", "Michael Wilson", "Room 505");
        registration.addCourse("NVQ Level Course", "200000", "Jessica Taylor", "Room 606");

        registration.start();
    }
}
