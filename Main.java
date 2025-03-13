import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int employeeID;
    private String name;
    private double salary;
    private String department;

    public Employee(int employeeID, String name, double salary, String department) {
        this.employeeID = employeeID;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public int getEmployeeID() { return employeeID; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }

    public void setSalary(double salary) { this.salary = salary; }
    public void setDepartment(String department) { this.department = department; }

    public void displayEmployee() {
        System.out.println("ID: " + employeeID + ", Name: " + name + ", Salary: " + salary + ", Department: " + department);
    }
}

public class Main {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nEmployee Management System:");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
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
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        employees.add(new Employee(id, name, salary, department));
        System.out.println("Employee added successfully!");
    }

    private static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee emp : employees) {
                emp.displayEmployee();
            }
        }
    }

    private static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        for (Employee emp : employees) {
            if (emp.getEmployeeID() == id) {
                System.out.print("Enter new Salary: ");
                double newSalary = scanner.nextDouble();
                scanner.nextLine(); 

                System.out.print("Enter new Department: ");
                String newDepartment = scanner.nextLine();

                emp.setSalary(newSalary);
                emp.setDepartment(newDepartment);
                System.out.println("Employee updated successfully!");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    private static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        employees.removeIf(emp -> emp.getEmployeeID() == id);
        System.out.println("Employee deleted successfully!");
    }
}