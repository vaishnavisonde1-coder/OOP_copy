/*ASSIGNMENT 7
(Scenario-Based)
A software company wants to develop an Employee Management System to store and process information about different types of employees. The company has different categories of employees such as Full-Time Employees and Part-Time Employees. All employees have some common information such as Employee ID, Name and Basic Salary, while different employee categories have their own salary calculation methods. The company also wants to provide common services such as generating employee details and calculating salary through a common interface. Task Write a Java program to implement the Employee Management System using Inheritance, Interface and Polymorphism.

1.	Implement Inheritance 
Create a base class named Employee containing: 
● Employee ID 
● Employee Name 
● Basic Salary
hierarchical inheritance
Create the following derived classes: 
● FullTimeEmployee 
● PartTimeEmployee 
Use inheritance to reuse the common properties and methods of the Employee class.

2.	 Implement Interface 
Create an interface named SalaryCalculator containing a method: 
calculateSalary() 
Implement this interface in both FullTimeEmployee and PartTimeEmployee. The salary should be calculated differently for each type of employee. 
For example: 
● Full-TimeEmployee: 
Final Salary = Basic Salary + Allowances-Deductions 
● Part-TimeEmployee: 
Final Salary = Hours Worked × Hourly Rate

3.	Implement Polymorphism 
Create an Employee reference and use it to refer to objects of: 
● FullTimeEmployee
● PartTimeEmployee 
Demonstrate runtime polymorphism by calling the appropriate overridden methods using the Employee reference.

4.	 Display Employee Details 
For each employee, display: 
● Employee ID 
● Employee Name 
● Employee Type 
● Basic Salary/relevant salary information 
● Calculated Final Salary
 */
package assignment7;
import java.util.Scanner;

interface SalaryCalculator {
    double calculateSalary();
}

//Base Class
abstract class Employee implements SalaryCalculator {
    protected int empId;
    protected String name;
    protected double basicSalary;

    // Constructor
    public Employee(int empId, String name, double basicSalary) {
        this.empId = empId;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public abstract void displayDetails();
}

// Derived Class for Full-Time Employees
class FullTimeEmployee extends Employee {
    private double allowances;
    private double deductions;
    
    public FullTimeEmployee(int empId, String name, double basicSalary, double allowances, double deductions) {
        super(empId, name, basicSalary); //super is used to access the data from the parent class
        this.allowances = allowances;
        this.deductions = deductions;
    }
    
    @Override
    public double calculateSalary() {
        return basicSalary + allowances - deductions;
    }

    @Override
    public void displayDetails() {
        System.out.println("Employee Type    : Full-Time Employee");
        System.out.println("Employee ID      : " + empId);
        System.out.println("Employee Name    : " + name);
        System.out.println("Basic Salary     : $" + basicSalary);
        System.out.println("Allowances       : $" + allowances);
        System.out.println("Deductions       : $" + deductions);
        System.out.println("Final Salary     : $" + calculateSalary());
        System.out.println("\n");
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int empId, String name, int hoursWorked, double hourlyRate) {
        super(empId, name, 0.0); 
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public void displayDetails() {
        System.out.println("Employee Type    : Part-Time Employee");
        System.out.println("Employee ID      : " + empId);
        System.out.println("Employee Name    : " + name);
        System.out.println("Hours Worked     : " + hoursWorked + " hrs");
        System.out.println("Hourly Rate      : $" + hourlyRate + "/hr");
        System.out.println("Final Salary     : $" + calculateSalary());
        System.out.println("\n");
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" EMPLOYEE MANAGEMENT SYSTEM ");

        System.out.println("--- Enter Full-Time Employee Details ---");
        System.out.print("Enter Employee ID: ");
        int ftId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Employee Name: ");
        String ftName = scanner.nextLine();

        System.out.print("Enter Basic Salary: ");
        double ftBasicSalary = scanner.nextDouble();

        System.out.print("Enter Allowances: ");
        double ftAllowances = scanner.nextDouble();

        System.out.print("Enter Deductions: ");
        double ftDeductions = scanner.nextDouble();

        System.out.println("\n--- Enter Part-Time Employee Details ---");
        System.out.print("Enter Employee ID: ");
        int ptId = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter Employee Name: ");
        String ptName = scanner.nextLine();

        System.out.print("Enter Hours Worked: ");
        int ptHours = scanner.nextInt();

        System.out.print("Enter Hourly Rate: ");
        double ptRate = scanner.nextDouble();

        Employee emp1 = new FullTimeEmployee(ftId, ftName, ftBasicSalary, ftAllowances, ftDeductions);
        Employee emp2 = new PartTimeEmployee(ptId, ptName, ptHours, ptRate);

        Employee[] employeeList = { emp1, emp2 };

        System.out.println("\n");
        System.out.println(" EMPLOYEE DETAILS SUMMARY ");

        for (Employee emp : employeeList) {
            emp.displayDetails();
            System.out.println();
        }

        scanner.close();
    }
}