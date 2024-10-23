package com.ims.ui;
import com.ims.dao.EmployeeDAOImpl;
import com.ims.model.Employee;

import javax.management.RuntimeErrorException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 User Interface (UI):
 - In the ui package, implement a simple CLI-based interface to interact with the system.
 - It should allow the user to:
 - Add an employee.
 - View employee details by ID.
 - Update employee details.
 - Delete an employee by ID.
 - List all employees.
 - Use Scanner for reading input from the user
 */


/**
 * @author TheHamer
 * @version 23/10
 *
 * - Interacts with EmployeeDAO for CRUD operations.
 * - Contains business logic such as validations, input sanitization, etc.
 */

public class UiController {
    EmployeeDAOImpl employeeDAO;

    public UiController() {
        try {
            employeeDAO = new EmployeeDAOImpl(
                    DriverManager.getConnection(
                            "jdbc:mysql://35.197.242.113/ims_db",
                            "root",
                            ""
                    )
            );
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    public void handleQuery(ArrayList<String> parameters){
        Employee currentEmployee = new Employee(
                Integer.parseInt(parameters.get(0)),
                parameters.get(1),
                parameters.get(2),
                parameters.get(3),
                parameters.get(4),
                Float.parseFloat(parameters.get(5))
        );

        employeeDAO.createEmployee(currentEmployee);
    }


    // this is all incredibly janky but we don't quite know how it will look yet - all subject to change

    void addEmployee(){

    }

    void viewEmployeeDetails(int id){

    }

    void updateEmployeeDetails(int id){

    }

    void deleteEmployeeDetails(int id){

    }

    void listAllEmployees(){

    }








    


}
