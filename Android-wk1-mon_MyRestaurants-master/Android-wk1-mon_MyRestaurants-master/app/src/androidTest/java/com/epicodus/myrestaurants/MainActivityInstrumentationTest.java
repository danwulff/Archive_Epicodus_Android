package com.epicodus.myrestaurants;


import android.app.Activity;
import android.content.Context;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Guest on 6/27/16.
 */
public class MainActivityInstrumentationTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void validateEditText() {
        onView(withId(R.id.locationEditText)).perform(typeText("Portland")).check(matches(withText("Portland")));
    }

    @Test
    public void locationIsSentToRestaurantsActivity() {
        String location = "Portland";
        onView(withId(R.id.locationEditText)).perform(typeText(location), ViewActions.closeSoftKeyboard());
        //ViewActions.closeSoftKeyboard() can work in any context, not just for testing
        //try and catch below are to give time for the keyboard to close prior to pushing button
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.findRestaurantsButton)).perform(click());
        onView(withId(R.id.locationTextView)).check(matches(withText("Here are all the restaurants near: " + location)));
    }

}
