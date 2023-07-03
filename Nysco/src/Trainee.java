import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Trainee {
    private String name;
    private String address;
    private String contactNumber;
    private String email;
    private String course;
    private String password;
    private String username;
    private List<String> privateData;

    public Trainee(String name, String address, String contactNumber, String email, String course) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.email = email;
        this.course = course;
        this.privateData = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getPrivateData() {
        return privateData;
    }

    public void addPrivateData(String data) {
        privateData.add(data);
    }

    public boolean isPasswordStrong(String password) {
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return false;
        }
        if (!password.matches(".*\\d.*")) {
            System.out.println("Password must contain at least one digit.");
            return false;
        }
        if (!password.matches(".*[!@#$%^&*()].*")) {
            System.out.println("Password must contain at least one special character.");
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            System.out.println("Password must contain at least one uppercase letter.");
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            System.out.println("Password must contain at least one lowercase letter.");
            return false;
        }
        return true;
    }
}

class TraineeManagementSystem {
    private List<Trainee> trainees;
    private Scanner scanner;

    public TraineeManagementSystem() {
        this.trainees = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("************************************");
        System.out.println("  Welcome to Nysco Trainee System   ");
        System.out.println("************************************\n");

        int choice;
        do {
            System.out.println("--- Trainee Management System ---");
            System.out.println("1. Add Trainee");
            System.out.println("2. View Trainees");
            System.out.println("3. Private Data");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTrainee();
                    break;
                case 2:
                    viewTrainees();
                    break;
                case 3:
                    privateMenu();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            System.out.println();
        } while (choice != 4);
    }

    private void addTrainee() {
        System.out.println("\n--- Add Trainee ---");
        System.out.print("Enter trainee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter trainee address: ");
        String address = scanner.nextLine();
        System.out.print("Enter trainee contact number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter trainee email: ");
        String email = scanner.nextLine();
        System.out.print("Enter trainee course: ");
        String course = scanner.nextLine();

        Trainee trainee = new Trainee(name, address, contactNumber, email, course);

        System.out.print("Do you want to set a password for this trainee? (yes/no): ");
        String setPasswordChoice = scanner.nextLine();
        if (setPasswordChoice.equalsIgnoreCase("yes")) {
            String password;
            do {
                System.out.print("Enter a password: ");
                password = scanner.nextLine();
            } while (!trainee.isPasswordStrong(password));
            trainee.setPassword(password);
        }

        System.out.print("Do you want to set a username for this trainee? (yes/no): ");
        String setUsernameChoice = scanner.nextLine();
        if (setUsernameChoice.equalsIgnoreCase("yes")) {
            System.out.print("Enter a username: ");
            String username = scanner.nextLine();
            trainee.setUsername(username);
            System.out.println("Username set successfully!");
        }

        trainees.add(trainee);
        System.out.println("Trainee details added successfully!");
    }

    private void viewTrainees() {
        System.out.println("\n--- View Trainees ---");
        if (trainees.isEmpty()) {
            System.out.println("No trainees found.");
        } else {
            for (Trainee trainee : trainees) {
                System.out.println("Name: " + trainee.getName());
                System.out.println("Address: " + trainee.getAddress());
                System.out.println("Contact Number: " + trainee.getContactNumber());
                System.out.println("Email: " + trainee.getEmail());
                System.out.println("Course: " + trainee.getCourse());
                System.out.println("---------------------------");
            }
        }
    }

    private void privateMenu() {
        System.out.println("\n--- Private Data ---");
        System.out.print("Enter trainee username: ");
        String username = scanner.nextLine();
        System.out.print("Enter trainee password: ");
        String password = scanner.nextLine();

        Trainee trainee = findTraineeByUsername(username);
        if (trainee != null && trainee.getPassword() != null && trainee.getPassword().equals(password)) {
            System.out.println("Access granted!");
            System.out.print("Do you want to (V)iew or (A)dd private data? ");
            String option = scanner.nextLine();
            if (option.equalsIgnoreCase("V")) {
                viewPrivateData(trainee);
            } else if (option.equalsIgnoreCase("A")) {
                addPrivateData(trainee);
            } else {
                System.out.println("Invalid option!");
            }
        } else {
            System.out.println("Access denied! Invalid username or password.");
        }
    }

    private void addPrivateData(Trainee trainee) {
        System.out.println("\n--- Add Private Data ---");
        System.out.print("Enter private data: ");
        String privateData = scanner.nextLine();

        trainee.addPrivateData(privateData);
        System.out.println("Private data added successfully!");
    }

    private void viewPrivateData(Trainee trainee) {
        System.out.println("\n--- Private Data ---");
        List<String> privateDataList = trainee.getPrivateData();
        if (privateDataList.isEmpty()) {
            System.out.println("No private data found.");
        } else {
            for (String data : privateDataList) {
                System.out.println(data);
            }
        }
    }

    private Trainee findTraineeByUsername(String username) {
        for (Trainee trainee : trainees) {
            if (trainee.getUsername() != null && trainee.getUsername().equals(username)) {
                return trainee;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        TraineeManagementSystem traineeManagementSystem = new TraineeManagementSystem();
        traineeManagementSystem.start();
    }
}
