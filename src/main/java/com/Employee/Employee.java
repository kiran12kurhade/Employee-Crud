package com.Employee;
/*
Author: Kiran Kisan Kurhade
Desc: Adding Crud Operation to Employee Class
Date: 03/10/2024
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Employee {

    private int id;
    private String name;
    private String address;

    public Employee(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    // Method to add an employee
    public static void addEmployee(ArrayList<Employee> employees, Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    // Method to delete an employee by ID
    public static void deleteEmployee(ArrayList<Employee> employees, int id) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId() == id) {
                iterator.remove();
                System.out.println("Employee deleted successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // Method to update an employee by ID
    public static void updateEmployee(ArrayList<Employee> employees, int id, String newName, String newAddress) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setName(newName);
                employee.setAddress(newAddress);
                System.out.println("Employee updated successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // Method to display all employees
    public static void displayEmployees(ArrayList<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Display All Employees");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Address: ");
                    String address = scanner.nextLine();
                    Employee employee = new Employee(id, name, address);
                    addEmployee(employees, employee);
                    break;
                case 2:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    deleteEmployee(employees, deleteId);
                    break;
                case 3:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter new Employee Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Employee Address: ");
                    String newAddress = scanner.nextLine();
                    updateEmployee(employees, updateId, newName, newAddress);
                    break;
                case 4:
                    displayEmployees(employees);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
        scanner.close();
    }
}
