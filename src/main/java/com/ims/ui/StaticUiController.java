package com.ims.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;


public class StaticUiController {

    public static void InitialiseUI() throws IOException {


        UiController uiController = new UiController();

        JFrame frame = new JFrame("DATA MANGLER 9000");
        frame.setSize(300, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Set layout to null for absolute positioning


        // Create all text boxes
        JTextField textFieldFirstName = new JTextField();
        textFieldFirstName.setBounds(50, 30, 200, 30); // Set position and size
        JLabel labelFistName = new JLabel("Fist Name:");
        labelFistName.setBounds(50, 5, 200, 30);
        frame.add(labelFistName);

        JTextField textFieldLastName = new JTextField();
        textFieldLastName.setBounds(50, 80, 200, 30); // Set position and size
        JLabel labelLastName = new JLabel("Last Name:");
        labelLastName.setBounds(50, 55, 200, 30);
        frame.add(labelLastName);

        JTextField textFieldID = new JTextField();
        textFieldID.setBounds(50, 130, 200, 30); // Set position and size
        JLabel labelID = new JLabel("ID:");
        labelID.setBounds(50, 105, 200, 30);
        frame.add(labelID);

        JTextField textFieldEmail = new JTextField();
        textFieldEmail.setBounds(50, 180, 200, 30); // Set position and size
        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(50, 155, 200, 30);
        frame.add(labelEmail);

        JTextField textFieldDepartment = new JTextField();
        textFieldDepartment.setBounds(50, 230, 200, 30); // Set position and size
        JLabel labelDepartment = new JLabel("Department:");
        labelDepartment.setBounds(50, 205, 200, 30);
        frame.add(labelDepartment);


        JTextField textFieldSalary = new JTextField();
        textFieldSalary.setBounds(50, 280, 200, 30); // Set position and size
        JLabel labelSalary = new JLabel("Salary:");
        labelSalary.setBounds(50, 255, 200, 30);
        frame.add(labelSalary);

        // Create a buttons
        JButton buttonAddEmployee = new JButton("Add Employee");
        buttonAddEmployee.setBounds(75, 330, 150, 30);

        JButton buttonUpdateEmployee = new JButton("Update Employee");
        buttonUpdateEmployee.setBounds(75, 380, 150, 30);

        JButton buttonGetEmployee = new JButton("View Employee");
        buttonGetEmployee.setBounds(75, 430, 150, 30);

        JButton imageButton = new JButton(new ImageIcon(StaticUiController.class.getResource("/missileSwitch.png")));
        imageButton.setBounds(100, 480, 100, 50); // Set position and size

        // List all employees button
        JButton buttonListAllEmployees = new JButton("List all employees");
        buttonListAllEmployees.setBounds(75, 580, 150, 30);

        // Add action listener to the button
        buttonAddEmployee.addActionListener(new ActionListener() {
            @Override
             public void actionPerformed(ActionEvent e) {
                 // Print the text from the text field to the console
                 System.out.println(textFieldFirstName.getText());
                 uiController.handleQuery("add " +
                         textFieldFirstName.getText() + " " +
                         textFieldLastName.getText() + " " +
                         textFieldEmail.getText() + " " +
                         textFieldDepartment.getText() + " " +
                         textFieldSalary.getText());
             }
         });


        buttonUpdateEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Print the text from the text field to the console
                System.out.println(textFieldID.getText());
                uiController.handleQuery("update " +
                        textFieldID.getText() + " " +
                        textFieldFirstName.getText() + " " +
                        textFieldLastName.getText() + " " +
                        textFieldEmail.getText() + " " +
                        textFieldDepartment.getText() + " " +
                        textFieldSalary.getText());
            }
        });


        buttonGetEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Print the text from the text field to the console
                System.out.println(textFieldID.getText());
                uiController.handleQuery("get " + textFieldID.getText());
            }
        });


        buttonListAllEmployees.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Print the text from the text field to the console
                System.out.println("list");
                uiController.handleQuery("list " + textFieldID.getText());
            }
        });

        // Add action listener to the image button (optional)
        imageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Boom");
                uiController.handleQuery("fire " + textFieldID.getText());
            }
        });


        // Add components to the frame
        frame.add(textFieldFirstName);
        frame.add(textFieldLastName);
        frame.add(textFieldEmail);
        frame.add(textFieldDepartment);
        frame.add(textFieldSalary);
        frame.add(textFieldID);
        frame.add(buttonAddEmployee);
        frame.add(buttonUpdateEmployee);
        frame.add(buttonListAllEmployees);
        frame.add(imageButton);
        frame.add(buttonGetEmployee);

        // Set frame visibility
        frame.setVisible(true);
    }
}

