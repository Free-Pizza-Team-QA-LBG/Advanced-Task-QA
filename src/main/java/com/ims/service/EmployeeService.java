package com.ims.service;
import com.ims.model.Employee;
import com.ims.utils.IMSRegex;

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

    private boolean validateSalary(float salary) {
        // Database column is DECIMAL(10,2), so 11 digit salaries are illegal
        return salary > 0 && salary < 10000000000L;
    }

    private boolean validateEmail(String email) {

        Pattern pattern = Pattern.compile(IMSRegex.EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validateEmployee(int id, String firstName, String lastName, String email, String department, float salary) {
        return this.validateSalary(salary) && this.validateEmail(email);
    }

    public boolean validateEmployee(Employee employee) {
        return this.validateEmployee(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getSalary()
        );
    }
}
