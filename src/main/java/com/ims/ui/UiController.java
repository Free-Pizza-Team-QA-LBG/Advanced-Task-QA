package com.ims.ui;

import com.ims.dao.DBConnection;
import com.ims.model.Employee;
import com.ims.dao.EmployeeDAO;
import com.ims.service.EmployeeService;


import java.sql.Connection;
import java.util.Arrays;


/**
 * User Interface (UI):
 * - In the ui package, implement a simple CLI-based interface to interact with the system.
 * - It should allow the user to:
 * - Add an employee.
 * - View employee details by ID.
 * - Update employee details.
 * - Delete an employee by ID.
 * - List all employees.
 * - Use Scanner for reading input from the user
 */


/**
 * @author TheHamer
 * @version 23/10
 *
 * - Interacts with EmployeeDAO for CRUD operations.
 * - Contains business logic such as validations, input sanitization, etc.
 */

public class UiController {


    public void handleQuery(String q) {
        System.out.println("Handling Query: " + q);

        String[] args = q.split(" ");

        for (int i = 0; i < args.length; i++) {
            args[i] = args[i].toLowerCase();
        }

        switch (args[0]) {

            case "add": case "create": case "new":
                addEmployee(Arrays.copyOfRange(args, 1, args.length));
                break;

            case "view": case "get": case "see":
                viewEmployeeDetails(Integer.parseInt(args[1]));
                break;

            case "update": case "change":
                updateEmployeeDetails(
                        Integer.parseInt(args[1]), Arrays.copyOfRange(args, 2, args.length - 1)
                );
                break;


            case "delete": case "remove": case "fire":
                deleteEmployeeDetails(Integer.parseInt(args[1]));
                break;

            case "list": case "all":
                listAllEmployees();
                break;

            default:
                System.out.println("Sorry! We don't recognise that command!");
        }


    }


    // this is all incredibly janky but we don't quite know how it will look yet - all subject to change

    void addEmployee(String[] args) {
        //Employee employee new Employee();
        Employee employeeToAdd = new Employee(args[1], args[2], args[3], args[4], Integer.valueOf(args[5]));
        System.out.println(employeeToAdd);
        boolean isValidAndAdded = EmployeeService.addAndValidateEmployee(employeeToAdd);
        System.out.println((isValidAndAdded) ? "Adding employee":"Error did not add!");
    }

    void viewEmployeeDetails(int id) {
        System.out.println("Viewing employee");

    }

    void updateEmployeeDetails(int id, String[] args) {
        System.out.println("Updating employee");

    }

    void deleteEmployeeDetails(int id) {
        System.out.println("Deleting employee");

    }

    void listAllEmployees() {
        System.out.println("Listing employees");

    }


}
