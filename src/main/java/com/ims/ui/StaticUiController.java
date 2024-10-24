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
        frame.setSize(300, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Set layout to null for absolute positioning

        // Add Labels
        JLabel labelFistName = new JLabel("Fist Name:");
        labelFistName.setBounds(50, 5, 200, 30);
        frame.add(labelFistName);

        JLabel labelLastName = new JLabel("Last Name:");
        labelLastName.setBounds(50, 55, 200, 30);
        frame.add(labelLastName);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(50, 105, 200, 30);
        frame.add(labelEmail);

        JLabel labelDepartment = new JLabel("Department:");
        labelDepartment.setBounds(50, 155, 200, 30);
        frame.add(labelDepartment);


        JLabel labelSalary = new JLabel("Salary:");
        labelSalary.setBounds(50, 205, 200, 30);
        frame.add(labelSalary);

        // Create all text boxes
        JTextField textFieldFirstName = new JTextField();
        textFieldFirstName.setBounds(50, 30, 200, 30); // Set position and size

        JTextField textFieldLastName = new JTextField();
        textFieldLastName.setBounds(50, 80, 200, 30); // Set position and size

        JTextField textFieldEmail = new JTextField();
        textFieldEmail.setBounds(50, 130, 200, 30); // Set position and size

        JTextField textFieldDepartment = new JTextField();
        textFieldDepartment.setBounds(50, 180, 200, 30); // Set position and size

        JTextField textFieldSalary = new JTextField();
        textFieldSalary.setBounds(50, 230, 200, 30); // Set position and size

        // Create a buttons
        JButton buttonAddEmployee = new JButton("Print to Console");
        buttonAddEmployee.setBounds(75, 270, 150, 30);

        // Add action listener to the button
        buttonAddEmployee.addActionListener(new ActionListener() {
            @Override
             public void actionPerformed(ActionEvent e) {
                 // Print the text from the text field to the console
                 System.out.println(textFieldFirstName.getText());
                 uiController.handleQuery(textFieldFirstName.getText());

                 System.out.println(textFieldLastName.getText());
                 uiController.handleQuery(textFieldLastName.getText());

                 System.out.println(textFieldEmail.getText());
                 uiController.handleQuery(textFieldEmail.getText());

                 System.out.println(textFieldDepartment.getText());
                 uiController.handleQuery(textFieldDepartment.getText());

                 System.out.println(textFieldSalary.getText());
                 uiController.handleQuery(textFieldSalary.getText());
             }
         });


        // Create the BIG RED BUTTON
        // C:\Users\Admin\QA\QA-Exercise-Hard\Advanced-Task-QA\src\images
        //ImageIcon icon = new ImageIcon("src/images/missileSwitch.png"); // Load the image


        JButton imageButton = new JButton(new ImageIcon(StaticUiController.class.getResource("/missileSwitch.png")));
        imageButton.setBounds(100, 320, 100, 50); // Set position and size

        // Add action listener to the image button (optional)
        imageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Boom");
            }
        });


        // Add components to the frame
        frame.add(textFieldFirstName);
        frame.add(textFieldLastName);
        frame.add(textFieldEmail);
        frame.add(textFieldDepartment);
        frame.add(textFieldSalary);
        frame.add(buttonAddEmployee);
        frame.add(imageButton);

        // Set frame visibility
        frame.setVisible(true);
    }
}

