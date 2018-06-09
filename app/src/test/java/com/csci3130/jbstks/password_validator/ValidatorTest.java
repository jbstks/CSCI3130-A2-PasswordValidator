package com.csci3130.jbstks.password_validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {
    /*
     * Testing validate function in Validator.java
     * Testing if statement that verifies the given password is not "password" and
     * if statement that verifies the given password is at least 8 characters
     */
    Validator passwordTest = new Validator();
    String pw;

    @Test
    public void testIsNotPassword() {
        // Should fail "is not 'password'" rule; pass "is at least 8 characters" rule
        // is "password"
        pw = "password";
        assertEquals(1, passwordTest.validate(pw));

        // Should fail "is not 'password'" rule; pass "is at least 8 characters" rule
        // is "password" with uppercase letter
        pw = "Password";
        assertEquals(1, passwordTest.validate(pw));

        // Should fail "is not 'password'" rule; pass "is at least 8 characters" rule
        // is "password" with uppercase letters
        pw = "paSSword";
        assertEquals(1, passwordTest.validate(pw));

        // Should pass "is not 'password'" rule; fail "is at least 8 characters" rule
        // is not "password"
        pw = "test123";
        assertEquals(1, passwordTest.validate(pw));

        // Should pass both rules
        // contains "password" but is not strictly "password"
        pw = "password123";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass both rules
        // is not "password"
        pw = "test1234";
        assertEquals(2, passwordTest.validate(pw));
    }

    @Test
    public void testIsAtLeast8Char() {
        // Should pass "is at least 8 characters" rule; fail "is not 'password'" rule
        // 8 character password
        pw = "password";
        assertEquals(1, passwordTest.validate(pw));

        // Should pass both tests
        // 9 character password
        pw = "test12345";
        assertEquals(2, passwordTest.validate(pw));

        // Should fail "is at least 8 characters" rule; pass "is not 'password'" rule
        // 1 character password
        pw = "1";
        assertEquals(1, passwordTest.validate(pw));

        // Should fail "is at least 8 characters" rule; pass "is not 'password'" rule
        // 2 character password
        pw = "12";
        assertEquals(1, passwordTest.validate(pw));

        // Should fail "is at least 8 characters" rule; pass "is not 'password'" rule
        // 3 character password
        pw = "123";
        assertEquals(1, passwordTest.validate(pw));

        // Should fail "is at least 8 characters" rule; pass "is not 'password'" rule
        // 4 character password
        pw = "1234";
        assertEquals(1, passwordTest.validate(pw));

        // Should fail "is at least 8 characters" rule; pass "is not 'password'" rule
        // 5 character password
        pw = "12345";
        assertEquals(1, passwordTest.validate(pw));

        // Should fail "is at least 8 characters" rule; pass "is not 'password'" rule
        // 6 character password
        pw = "123456";
        assertEquals(1, passwordTest.validate(pw));

        // Should fail "is at least 8 characters" rule; pass "is not 'password'" rule
        // 8 character password
        pw = "1234567";
        assertEquals(1, passwordTest.validate(pw));
    }
}