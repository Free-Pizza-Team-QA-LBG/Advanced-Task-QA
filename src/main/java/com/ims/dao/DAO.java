package com.ims.dao;

import com.ims.model.Employee;

import java.util.ArrayList;

public interface DAO<T> {
    /**
     * Creates a new employee in the database.
     *
     * @param target The Employee object containing the data to be stored in the database
     * @return A boolean indicating whether the operation was successful
     */
    boolean create(T target);

    /**
     * Reads an employee from the database.
     *
     * @param id The ID of the employee to be read
     * @return The created Employee object
     */
    T read(int id);

    /**
     * Updates an employee in the database. The ID of the employee must exist in the database.
     *
     * @param target The Employee object containing the data to be updated
     * @return A boolean indicating whether the operation was successful
     */
    boolean update(T target);

    /**
     * Deletes an employee from the database. The ID of the employee must exist in the database.
     *
     * @param id The Employee object containing the data to be deleted
     * @return A boolean indicating whether the operation was successful
     */
    boolean delete(int id);

    /**
     * Reads all employees from the database.
     *
     * @return An ArrayList containing all employee objects
     */
    ArrayList<T> getAll();
}
