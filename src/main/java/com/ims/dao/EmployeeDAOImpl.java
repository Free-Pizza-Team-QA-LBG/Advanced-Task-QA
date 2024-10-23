package com.ims.dao;

import com.ims.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    private final Connection connection;

    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean createEmployee(Employee employee) {
        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement(
                    "INSERT INTO employees VALUES (?, ?, ?, ?, ?, ?)"
            );

            stmt.setInt(1, employee.getId());
            stmt.setString(1, employee.getFirstName());
            stmt.setString(1, employee.getLastName());
            stmt.setString(1, employee.getEmail());
            stmt.setString(1, employee.getDepartment());
            stmt.setFloat(1, employee.getSalary());

            int insertedRowsCount = stmt.executeUpdate();

            if (insertedRowsCount > 0) {
                // Row was inserted, get auto increment ID value
                ResultSet result = stmt.getGeneratedKeys();

                if (result.next()) {
                    // Set ID on Employee instance to match inserted row
                    int id = result.getInt(1);
                    employee.setId(id);
                }

                DBConnection.closeResultSet(result);

                return true;
            }
        } catch (SQLException e) {
            // TODO: Handle error
            System.out.println("error: " + e.getMessage());
        } finally {
            DBConnection.closeStatement(stmt);
        }

        return false;
    }

    @Override
    public Employee readEmployee(int id) {
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            stmt = connection.prepareStatement(
                "SELECT * FROM employees WHERE id = ?"
            );

            stmt.setInt(1, id);

            result = stmt.executeQuery();

            if (result.next()) {
                return new Employee(
                    result.getInt("id"),
                    result.getString("first_name"),
                    result.getString("last_name"),
                    result.getString("email"),
                    result.getString("department"),
                    result.getFloat("salary")
                );
            }
        } catch (SQLException e) {
            // TODO: Handle error
            System.out.println("error: " + e.getMessage());
        } finally {
            DBConnection.closeStatement(stmt);
            DBConnection.closeResultSet(result);
        }

        return null;
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(int id) {

    }

    @Override
    public ArrayList<Employee> getAllEmployees() {
        PreparedStatement stmt = null;
        ResultSet result = null;
        ArrayList<Employee> employees = new ArrayList<>();

        try {
            stmt = connection.prepareStatement(
                    "SELECT * FROM employees"
            );

            result = stmt.executeQuery();

            while (result.next()) {
                employees.add(
                    new Employee(
                            result.getInt("id"),
                            result.getString("first_name"),
                            result.getString("last_name"),
                            result.getString("email"),
                            result.getString("department"),
                            result.getFloat("salary")
                    )
                );
            }
        } catch (SQLException e) {
            // TODO: Handle error
            System.out.println("error: " + e.getMessage());

            return null;
        } finally {
            DBConnection.closeStatement(stmt);
            DBConnection.closeResultSet(result);
        }

        return employees;
    }
}
