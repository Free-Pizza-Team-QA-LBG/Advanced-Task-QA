package com.ims.dao;

import com.ims.model.Employee;

import java.util.ArrayList;

public interface EmployeeDAO {
    /**
     * Creates a new employee in the database.
     *
     * @param employee The Employee object containing the data to be stored in the database
     * @return A boolean indicating whether the operation was successful
     */
    boolean createEmployee(Employee employee);

    /**
     * Reads an employee from the database.
     *
     * @param id The ID of the employee to be read
     * @return The created Employee object
     */
    Employee readEmployee(int id);

    /**
     * Updates an employee in the database. The ID of the employee must exist in the database.
     *
     * @param employee The Employee object containing the data to be updated
     * @return A boolean indicating whether the operation was successful
     */
    boolean updateEmployee(Employee employee);

    /**
     * Deletes an employee from the database. The ID of the employee must exist in the database.
     *
     * @param id The Employee object containing the data to be deleted
     * @return A boolean indicating whether the operation was successful
     */
    boolean deleteEmployee(int id);

    /**
     * Reads all employees from the database.
     *
     * @return An ArrayList containing all employee objects
     */
    ArrayList<Employee> getAllEmployees();
}
