package com.ims.dao;

import com.ims.model.Employee;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeDAOTest {
    @Mock
    private Connection conn;

    @Mock
    private PreparedStatement stmt;

    @Mock
    private ResultSet result;

    private MockedStatic<DBConnection> mockDBConnection;

    @Before
    public void setUp() throws SQLException {
        when(conn.prepareStatement(any(String.class))).thenReturn(stmt);
        mockDBConnection = mockStatic(DBConnection.class);
        mockDBConnection.when(DBConnection::getConnection).thenReturn(conn);
    }

    @After
    public void tearDown() {
        mockDBConnection.close();
    }

    @Test
    public void readEmployee() throws SQLException {
        Employee employee = new Employee(1, "John", "Smith", "john.smith@qatraining.com", "Engineering", 50000.00f);

        when(result.next()).thenReturn(true);
        when(result.getInt("id")).thenReturn(1);
        when(result.getString("first_name")).thenReturn(employee.getFirstName());
        when(result.getString("last_name")).thenReturn(employee.getLastName());
        when(result.getString("email")).thenReturn(employee.getEmail());
        when(result.getString("department")).thenReturn(employee.getDepartment());
        when(result.getFloat("salary")).thenReturn(employee.getSalary());
        when(stmt.executeQuery()).thenReturn(result);

        Employee foundEmployee = new EmployeeDAO(conn).read(1);

        assertEquals(foundEmployee.getId(), employee.getId());
        assertEquals(foundEmployee.getFirstName(), employee.getFirstName());
        assertEquals(foundEmployee.getLastName(), employee.getLastName());
        assertEquals(foundEmployee.getEmail(), employee.getEmail());
        assertEquals(foundEmployee.getDepartment(), employee.getDepartment());
        assertEquals(foundEmployee.getSalary(), employee.getSalary(), 0.00f);
    }
}
