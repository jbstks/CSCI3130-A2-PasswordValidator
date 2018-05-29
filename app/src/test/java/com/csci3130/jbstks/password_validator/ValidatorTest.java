package com.csci3130.jbstks.password_validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {
    /*
     * Testing validate function in Validator.java
     * Testing if statement that verifies the given password is not "password" and
     * if statement that verifies the given password is at least 8 characters
     */
    @Test
    public void testValidate() {
        Validator passwordTest = new Validator();
        String pw;

        // Should fail "is not 'password'" rule; pass "is at least 8 characters" rule
        pw = "password";
        assertEquals(1, passwordTest.validate(pw));

        // Should fail "is not 'password'" rule; pass "is at least 8 characters" rule
        pw = "Password";
        assertEquals(1, passwordTest.validate(pw));

        // Should fail "is at least 8 characters" rule; pass "is not 'password'" rule
        pw = "test123";
        assertEquals(1, passwordTest.validate(pw));

        // Should pass both rules
        pw = "test1234";
        assertEquals(2, passwordTest.validate(pw));
    }
}