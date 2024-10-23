package com.ims.model;

/**
 * @author Alex Terry
 * @version 23/10/2024
 *  - Implement the Employee class in the model package. It should have:
 *    - Fields matching the database structure: id, first_name, last_name, email, department, salary.
 *    - Getters and Setters for all fields.
 *    - A constructor to initialize the Employee object.
 *    - A toString() method for printing employee details.
 */
public class Employee {
    private int id;

    private String firstName, lastName, email, department;
    private float salary;

    public Employee(int id, String firstName, String lastName, String email, String department, float salary) {
        this(firstName, lastName, email, department, salary);
        this.id = id;
    }

    public Employee(String firstName, String lastName, String email, String department, float salary) {
        this.id = 0;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return """
                Employee details:
                    ID: %d
                    Name: %s %s
                    Email: %s
                    Department: %s
                    Salary: %.2f
                    """.formatted(id, firstName, lastName, email, department, salary);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

}
