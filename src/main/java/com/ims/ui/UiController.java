package com.ims.ui;
import javax.management.RuntimeErrorException;
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


public class UiController {

    private Scanner scanner;

    /**
     *  Initialises scanner - global to object.
     *  Standard constructor
     */
    public void UiController(){
        this.scanner = new Scanner(System.in);
    }


    /**
     *  Reads a user-written line from terminal using scanner. Returns it.
     *
     */
    public String readLineFromUser() throws Exception {
        if(scanner == null){
            throw new Exception("There exists no scanner - you cannot read");
        }

        System.out.println("oi m8 whots u wont to do?");
        String userInputString = scanner.nextLine();
        return userInputString;
    }


    // this is all incredibly janky but we don't quite know how it will look yet - all subject to change

    public void addEmployee(){

    }

    public void viewEmployeeDetails(int id){

    }

    public void updateEmployeeDetails(int id){

    }

    public void deleteEmployeeDetails(int id){

    }

    public void listAllEmployees(){

    }








    


}
