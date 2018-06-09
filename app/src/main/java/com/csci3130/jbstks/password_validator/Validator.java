package com.csci3130.jbstks.password_validator;
/**
 * Assignment 2
 * Validator.java
 *
 * @author Joanna Bistekos (B00710704)
 * 06/09/2018
 *
 * This work is entirely my own
 */
public class Validator {
    /**
     * Validates the given password with a set of rules
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

        // Checks if the given password has one of the following symbols
        if (pw.matches(".*[!?,.:;'^+$#@]+.*")) passed++;
        // Checks if the given password has at least 1 lowercase and uppercase letter
        if (pw.matches(".*[A-Z]+.*") && pw.matches(".*[a-z]+.*")) passed++;
        // Checks if the given password contains at least 1 number
        if (pw.matches(".*[0-9]+.*")) passed++;

        return passed;
    }
}