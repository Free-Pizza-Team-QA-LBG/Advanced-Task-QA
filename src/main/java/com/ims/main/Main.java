package com.ims.main;

import com.ims.ui.UiController;

public class Main {
    public static void main(String[] args) throws Exception {

        UiController uiController = new UiController();

        // only poll user input ten times to avoid getting stuck - may change to while(true) later.
        for(int i = 0; i< 10; i++){
            String userInput = uiController.readLineFromUser();
            System.out.println(userInput);
        }
    }

}
