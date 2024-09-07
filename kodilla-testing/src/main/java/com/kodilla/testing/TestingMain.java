package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {

    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUserName();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();
        int a = 13;
        int b = 7;

        int addingResult = calculator.add(a, b);
        if (addingResult == 20) {
            System.out.println("Adding test OK");
        } else {
            System.out.println("Adding test Error!");
        }

        int subtractionResult = calculator.subtract(a, b);
        if (subtractionResult == 6) {
            System.out.println("Subtraction test OK");
        } else {
            System.out.println("Subtraction test Error!");
        }
    }
}