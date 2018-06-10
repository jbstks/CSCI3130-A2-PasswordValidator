package com.csci3130.jbstks.password_validator;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test, which will execute on an Android device.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class EspressoUITest {

    // Test is done on the main activity
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    // Tests strong password message
    @Test
    public void testStrongPassUI() {
        onView(withId(R.id.pwField)).perform(typeText("Thisisastrongpassword123?"), closeSoftKeyboard());
        onView(withId(R.id.validateButton)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("Strong password!")));
    }

    // Tests weak password message
    @Test
    public void testNotStrongPassUI() {
        onView(withId(R.id.pwField)).perform(typeText("password"), closeSoftKeyboard());
        onView(withId(R.id.validateButton)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("Weak password!")));
    }
}
