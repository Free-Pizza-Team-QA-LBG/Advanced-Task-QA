package com.ims.dao;

import com.ims.model.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDAO {
    boolean createEmployee(Employee employee) throws SQLException;

    Employee readEmployee(int id) throws SQLException;

    void updateEmployee(Employee employee) throws SQLException;

    void deleteEmployee(int id) throws SQLException;

    ArrayList<Employee> getAllEmployees() throws SQLException;
}
