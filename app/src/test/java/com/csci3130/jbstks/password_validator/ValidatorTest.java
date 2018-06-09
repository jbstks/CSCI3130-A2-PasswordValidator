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
        // Should fail "is not 'password'" rule; fail everything else except
        // pass "is at least 8 characters" rule
        // is "password"
        pw = "password";
        assertEquals(1, passwordTest.validate(pw));

        // Should fail "is not 'password'" rule; fail everything else except
        // pass "is at least 8 characters" and "has at least 1 upper and lowercase letter" rule
        // is "password" with uppercase letter
        pw = "Password";
        assertEquals(2, passwordTest.validate(pw));

        // Should fail "is not 'password'" rule; fail everything else except
        // pass "is at least 8 characters" and "has at least 1 upper and lowercase letter" rule
        // is "password" with uppercase letters
        pw = "paSSword";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "is not 'password'" rule; fail everything else except
        // pass "is at least 8 characters" rule
        // is not "password"
        pw = "testtest";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "is not 'password'" rule; fail everything else except
        // pass "is at least 8 characters" rule
        // contains "password" but is not strictly "password"
        pw = "passwordtest";
        assertEquals(2, passwordTest.validate(pw));

    }

    @Test
    public void testIsAtLeast8Char() {
        // Should pass "is at least 8 characters" rule; fail everything else
        // 8 character password
        pw = "password";
        assertEquals(1, passwordTest.validate(pw));

        // Should pass "is at least 8 characters" rule;
        // fail everything else except "is not 'password'" rule
        // 9 character password
        pw = "abcdefghi";
        assertEquals(2, passwordTest.validate(pw));

        // Should fail "is at least 8 characters" rule;
        // fail everything else except pass "is not 'password'" rule
        // 1 character password
        pw = "a";
        assertEquals(1, passwordTest.validate(pw));

        // Should fail "is at least 8 characters" rule;
        // fail everything else except pass "is not 'password'" rule
        // 2 character password
        pw = "ab";
        assertEquals(1, passwordTest.validate(pw));

        // Should fail "is at least 8 characters" rule;
        // fail everything else except pass "is not 'password'" rule
        // 3 character password
        pw = "abc";
        assertEquals(1, passwordTest.validate(pw));

        // Should fail "is at least 8 characters" rule;
        // fail everything else except pass "is not 'password'" rule
        // 4 character password
        pw = "abcd";
        assertEquals(1, passwordTest.validate(pw));

        // Should fail "is at least 8 characters" rule;
        // fail everything else except pass "is not 'password'" rule
        // 5 character password
        pw = "abcde";
        assertEquals(1, passwordTest.validate(pw));

        // Should fail "is at least 8 characters" rule;
        // fail everything else except pass "is not 'password'" rule
        // 6 character password
        pw = "abcdef";
        assertEquals(1, passwordTest.validate(pw));

        // Should fail "is at least 8 characters" rule;
        // fail everything else except pass "is not 'password'" rule
        // 7 character password
        pw = "abcdefg";
        assertEquals(1, passwordTest.validate(pw));
    }

    @Test
    public void testHasSpecialChar() {
        // Should pass "has at least special 1 character" rule;
        // fail everything else except "is at least 8 characters" and "is not 'password'" rules
        // all special characters password
        pw = "!?,.:;'^+$#@";
        assertEquals(3, passwordTest.validate(pw));

        // Should pass "has at least special 1 character" rule;
        // fail everything else except "is not 'password'" rule
        // password with ! special character
        pw = "!test";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "has at least special 1 character" rule;
        // fail everything else except "is not 'password'" rule
        // password with ? special character
        pw = "t?est";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "has at least special 1 character" rule;
        // fail everything else except "is not 'password'" rule
        // password with , special character
        pw = "te,st";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "has at least special 1 character" rule;
        // fail everything else except "is not 'password'" rule
        // password with . special character
        pw = "tes.t";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "has at least special 1 character" rule;
        // fail everything else except "is not 'password'" rule
        // password with : special character
        pw = "test:";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "has at least special 1 character" rule;
        // fail everything else except "is not 'password'" rule
        // password with ; special character
        pw = ";test";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "has at least special 1 character" rule;
        // fail everything else except "is not 'password'" rule
        // password with ' special character
        pw = "t'est";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "has at least special 1 character" rule;
        // fail everything else except "is not 'password'" rule
        // password with ^ special character
        pw = "te^st";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "has at least special 1 character" rule;
        // fail everything else except "is not 'password'" rule
        // password with + special character
        pw = "tes+t";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "has at least special 1 character" rule;
        // fail everything else except "is not 'password'" rule
        // password with $ special character
        pw = "test$";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "has at least special 1 character" rule;
        // fail everything else except "is not 'password'" rule
        // password with # special character
        pw = "#test";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "has at least special 1 character" rule;
        // fail everything else except "is not 'password'" rule
        // password with @ special character
        pw = "t@est";
        assertEquals(2, passwordTest.validate(pw));
    }

    @Test
    public void testHasUpperLowercase() {
        // Should pass "has at least 1 upper and lowercase letter" rule;
        // fail everything else except "is not 'password'" rule
        pw = "Aaa";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "has at least 1 upper and lowercase letter" rule;
        // fail everything else except "is not 'password'" rule
        pw = "aAa";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "has at least 1 upper and lowercase letter" rule;
        // fail everything else except "is not 'password'" rule
        pw = "aaA";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "has at least 1 upper and lowercase letter" rule;
        // fail everything else except "is not 'password'" rule
        pw = "AaA";
        assertEquals(2, passwordTest.validate(pw));

        // Should fail "has at least 1 upper and lowercase letter" rule;
        // fail everything else except "is not 'password'" rule
        pw = "AA";
        assertEquals(1, passwordTest.validate(pw));

        // Should fail "has at least 1 upper and lowercase letter" rule;
        // fail everything else except "is not 'password'" rule
        pw = "aa";
        assertEquals(1, passwordTest.validate(pw));
    }

    @Test
    public void testHasNumber() {
        // Should pass "has at least 1 number" rule;
        // fail everything else except "is not 'password'" rule
        pw = "1";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "has at least 1 number" rule;
        // fail everything else except "is not 'password'" rule
        pw = "2";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "has at least 1 number" rule;
        // fail everything else except "is not 'password'" rule
        pw = "3";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "has at least 1 number" rule;
        // fail everything else except "is not 'password'" rule
        pw = "4";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "has at least 1 number" rule;
        // fail everything else except "is not 'password'" rule
        pw = "5";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "has at least 1 number" rule;
        // fail everything else except "is not 'password'" rule
        pw = "6";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "has at least 1 number" rule;
        // fail everything else except "is not 'password'" rule
        pw = "7";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "has at least 1 number" rule;
        // fail everything else except "is not 'password'" rule
        pw = "8";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "has at least 1 number" rule;
        // fail everything else except "is not 'password'" rule
        pw = "1a";
        assertEquals(2, passwordTest.validate(pw));

        // Should pass "has at least 1 number" rule;
        // fail everything else except "is not 'password'" rule
        pw = "a1";
        assertEquals(2, passwordTest.validate(pw));

        // Should fail "has at least 1 number" rule;
        // fail everything else except "is not 'password'" rule
        pw = "a";
        assertEquals(1, passwordTest.validate(pw));
    }
}