package com.csci3130.jbstks.password_validator;
/**
 * Assignment 1
 * Validator.java
 *
 * @author Joanna Bistekos (B00710704)
 * 06/09/2018
 *
 * This work is entirely my own
 */
public class Validator {
    /**
     * Validates the given password
     *
     * @param pw the password String in question
     * @return the number of rules that the String passed
     */
    public int validate(String pw) {
        // Number of rules passed
        int passed = 0;

        // Checks if the given password is not (case insensitive) "password"
        if (!pw.equalsIgnoreCase("password")) passed++;
        // Checks if the given password is at least 8 characters
        if (pw.length() > 7) passed++;

        return passed;
    }
}