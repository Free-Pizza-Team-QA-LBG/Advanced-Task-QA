package com.ims.service;
import com.ims.dao.DBConnection;
import com.ims.dao.EmployeeDAO;
import com.ims.model.Employee;
import com.ims.utils.IMSRegex;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author BenSnellgrove
 * @version 23/10
 * <p>
 * - Interacts with EmployeeDAO for CRUD operations.
 * - Contains business logic such as validations, input sanitization, etc.
 */
public class EmployeeService {

    private String sanitizeName(String name) {
        return name.replaceAll("\\s", "");
    }

    private static boolean validateSalary(float salary) {
        // Database column is DECIMAL(10,2), so 11 digit salaries are illegal
        return salary > 0 && salary < 10000000000L;
    }

    private static boolean validateEmail(String email) {

        Pattern pattern = Pattern.compile(IMSRegex.EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean validateEmployee(int id, String firstName, String lastName, String email, String department, float salary) {
        return EmployeeService.validateSalary(salary) && EmployeeService.validateEmail(email);
    }

    private static boolean validateEmployee(Employee employee) {
        return EmployeeService.validateEmployee(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getSalary()
        );
    }

    public static boolean addAndValidateEmployee(Employee employee) {

        boolean isValid = validateEmployee(employee);

        if (isValid) {
            Connection conn = DBConnection.getConnection();
            EmployeeDAO newEmployeeDAOImpl = new EmployeeDAO(conn);
            newEmployeeDAOImpl.create(employee);
        }

        return isValid;
    }

    public static boolean updateAndValidateEmployee(Employee employee) {

        boolean isValid = validateEmployee(employee);

        if (isValid) {
            Connection conn = DBConnection.getConnection();
            EmployeeDAO updateEmployeeDAOImpl = new EmployeeDAO(conn);
            updateEmployeeDAOImpl.update(employee);
        }

        return isValid;
    }

    public static boolean deleteAndValidateEmployee(int id) {

        Connection conn = DBConnection.getConnection();
        EmployeeDAO deleteEmployeeDAOImpl = new EmployeeDAO(conn);
        deleteEmployeeDAOImpl.delete(id);

        return true;
    }

    public static Employee viewAndValidateEmployee(int id) {

        Connection conn = DBConnection.getConnection();
        EmployeeDAO viewEmployeeDAOImpl = new EmployeeDAO(conn);
        Employee employee = viewEmployeeDAOImpl.read(id);

        return employee;
    }

    public static ArrayList<Employee> listAllAndValidateEmployee() {
        //return true;

        Connection conn = DBConnection.getConnection();
        EmployeeDAO viewAllEmployeeDAOImpl = new EmployeeDAO(conn);
        ArrayList<Employee> employees = viewAllEmployeeDAOImpl.getAll();

        return employees;
    }
}
