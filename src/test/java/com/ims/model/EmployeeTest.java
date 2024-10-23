package com.ims.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {
    Employee testEmployee;

    @Before
    public void init() {
        testEmployee = new Employee(1,
                "Test",
                "Man",
                "hi@free-pizza.com",
                "QA",
                1.0f);
    }

    @Test
    public void constructorTest() {
        assertNotNull(testEmployee);
    }

    @Test
    public void getterTest() {
        assertEquals(1, testEmployee.getId());
        assertEquals("Test", testEmployee.getFirstName());
        assertEquals("Man", testEmployee.getLastName());
        assertEquals("hi@free-pizza.com", testEmployee.getEmail());
        assertEquals("QA", testEmployee.getDepartment());
        assertEquals(1.0f, testEmployee.getSalary(), 0.0);
    }

    @Test
    public void setterTest() {
        testEmployee.setId(2);
        assertEquals(2, testEmployee.getId());
        testEmployee.setFirstName("John");
        assertEquals("John", testEmployee.getFirstName());
        testEmployee.setLastName("Wick");
        assertEquals("Wick", testEmployee.getLastName());
        testEmployee.setEmail("hello@free-pizza.com");
        assertEquals("hello@free-pizza.com", testEmployee.getEmail());
        testEmployee.setDepartment("Finance");
        assertEquals("Finance", testEmployee.getDepartment());
        testEmployee.setSalary(12.0f);
        assertEquals(12.0f, testEmployee.getSalary(), 0.0);
    }

    @Test
    public void toStringTest() {
        assertEquals("""
                Employee details:
                    ID: 1
                    Name: Test Man
                    Email: hi@free-pizza.com
                    Department: QA
                    Salary: 1.00
                    """
                , testEmployee.toString()
        );
    }

}
