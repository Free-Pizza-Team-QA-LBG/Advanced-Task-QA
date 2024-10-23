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



}
