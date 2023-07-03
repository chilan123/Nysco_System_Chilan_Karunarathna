import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private int employeeId;
    private String name;
    private String designation;
    private String department;
    private double salary;

    public Employee(int employeeId, String name, String designation, String department, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.designation = designation;
        this.department = department;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class EmployeeManagementSystem {
    private List<Employee> employees;
    private Scanner scanner;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("********************************************");
        System.out.println("*           Welcome to Nysco HR            *");
        System.out.println("*          Phone: Badulla 055 2225164      *");
        System.out.println("********************************************");

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Salary");
            System.out.println("4. Remove Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addEmployee();
                        break;
                    case 2:
                        viewEmployees();
                        break;
                    case 3:
                        updateSalary();
                        break;
                    case 4:
                        removeEmployee();
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please try again.");
                scanner.nextLine();
            }
        }

        System.out.println("\nThank you for using the Employee Management System!");
        scanner.close();
    }

    private void addEmployee() {
        try {
            System.out.print("\nEnter employee ID: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();

            System.out.print("Enter employee designation: ");
            String designation = scanner.nextLine();

            System.out.print("Enter employee department: ");
            String department = scanner.nextLine();

            System.out.print("Enter employee salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();

            Employee employee = new Employee(employeeId, name, designation, department, salary);
            employees.add(employee);

            System.out.println("Employee added successfully!");
        } catch (Exception e) {
            System.out.println("Invalid input! Please try again.");
            scanner.nextLine();
        }
    }

    private void viewEmployees() {
        System.out.println("\n--- Employee List ---");
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee employee : employees) {
                System.out.println("Employee ID: " + employee.getEmployeeId());
                System.out.println("Name: " + employee.getName());
                System.out.println("Designation: " + employee.getDesignation());
                System.out.println("Department: " + employee.getDepartment());
                System.out.println("Salary: " + employee.getSalary());
                System.out.println("-------------------------");
            }
        }
    }

    private void updateSalary() {
        viewEmployees();

        if (employees.isEmpty()) {
            return;
        }

        try {
            System.out.print("Enter the employee ID to update salary: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine();

            Employee employeeToUpdate = null;
            for (Employee employee : employees) {
                if (employee.getEmployeeId() == employeeId) {
                    employeeToUpdate = employee;
                    break;
                }
            }

            if (employeeToUpdate == null) {
                System.out.println("Employee not found!");
            } else {
                System.out.print("Enter the new salary: ");
                double newSalary = scanner.nextDouble();
                scanner.nextLine();

                employeeToUpdate.setSalary(newSalary);
                System.out.println("Salary updated successfully!");
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Please try again.");
            scanner.nextLine();
        }
    }

    private void removeEmployee() {
        viewEmployees();

        if (employees.isEmpty()) {
            return;
        }

        try {
            System.out.print("Enter the employee ID to remove: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine();

            Employee employeeToRemove = null;
            for (Employee employee : employees) {
                if (employee.getEmployeeId() == employeeId) {
                    employeeToRemove = employee;
                    break;
                }
            }

            if (employeeToRemove == null) {
                System.out.println("Employee not found!");
            } else {
                employees.remove(employeeToRemove);
                System.out.println("Employee removed successfully!");
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Please try again.");
            scanner.nextLine();
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        ems.start();
    }
}
