package com.ims.dao;

import com.ims.model.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDAO {
    boolean createEmployee(Employee employee);

    Employee readEmployee(int id);

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(int id);

    ArrayList<Employee> getAllEmployees();
}
